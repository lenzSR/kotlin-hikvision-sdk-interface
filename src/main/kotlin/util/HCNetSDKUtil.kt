package org.example.util

import com.sun.jna.Pointer
import com.sun.jna.ptr.IntByReference
import org.example.constant.HCNetSDKConstant.NET_DVR_DEV_ADDRESS_MAX_LEN
import org.example.constant.HCNetSDKConstant.NET_DVR_GET_PTZPOS
import org.example.constant.HCNetSDKConstant.NET_DVR_LOGIN_PASSWD_MAX_LEN
import org.example.constant.HCNetSDKConstant.NET_DVR_LOGIN_USERNAME_MAX_LEN
import org.example.function.callback.LoginResultCallback
import org.example.sdk.HCNetSDK
import org.example.structure.*

object HCNetSDKUtil {
    val hCNetSDK: HCNetSDK = HCNetSDK.INSTANCE
    private val cameras = mutableListOf(
        Camera("your camera address", "login username", 8000, "login password", "defined name"),
    )
    val registeredCameraMap = mutableMapOf<Int, Camera>()

    data class Camera(
        val ip: String,
        val username: String,
        val port: Int,
        val password: String,
        val name: String,
        var channel: Int = 0
    )

    init {
        try {
            if (!hCNetSDK.NET_DVR_Init()) {
                hCNetSDK.NET_DVR_SetConnectTime(2000, 1)
                hCNetSDK.NET_DVR_SetReconnect(100000, true)
                println("-----------SDK初始化失败-----------")
            } else {
                println("-----------SDK初始化成功-----------")
            }

            cameras.forEach { camera ->
                println("注册摄像头: ${camera.name}, ${camera.ip}, ${camera.username}, ${camera.port}, ${camera.password}")
                register(camera)
            }
        } catch (e: Exception) {
            println("初始化失败: ${e.message}")
        }
    }

    private fun register(camera: Camera) {
        val loginInfo = NET_DVR_USER_LOGIN_INFO().apply {
            // 确保使用正确的字符编码(通常设备SDK使用GBK编码)
            sDeviceAddress = camera.ip.toByteArray(charset("GBK")).copyOf(NET_DVR_DEV_ADDRESS_MAX_LEN)
            sUserName = camera.username.toByteArray(charset("GBK")).copyOf(NET_DVR_LOGIN_USERNAME_MAX_LEN)
            sPassword = camera.password.toByteArray(charset("GBK")).copyOf(NET_DVR_LOGIN_PASSWD_MAX_LEN)
            wPort = camera.port.toShort()
            bUseAsynLogin = true
            cbLoginResult = object : LoginResultCallback {
                override fun invoke(
                    lUserID: Int,
                    dwResult: Int,
                    lpDeviceInfo: NET_DVR_DEVICEINFO_V30?,
                    pUser: Pointer?
                ): Int {
                    if (dwResult == 0) {
                        println("登录失败，错误码: ${hCNetSDK.NET_DVR_GetLastError()}")
                    } else {
                        registeredCameraMap[lUserID] = camera.apply { this.channel = lpDeviceInfo?.byStartChan?.toInt() ?: 0 }
                        println("登录成功，用户ID: $lUserID, camera: $camera")
                    }
                    return lUserID
                }
            }

            write() // 确保写入原生内存
        }

        val deviceInfo = NET_DVR_DEVICEINFO_V40()

        hCNetSDK.NET_DVR_Login_V40(loginInfo, deviceInfo)
    }

    fun getDVRConfig(userId: Int): String {
        val intByReference = IntByReference(0)
        val pos = NET_DVR_PTZPOS()
        val pointer = pos.pointer

        if (!hCNetSDK.NET_DVR_GetDVRConfig(userId, NET_DVR_GET_PTZPOS, registeredCameraMap[userId]?.channel ?: 1, pointer, pos.size(), intByReference)) {
            return "获取设备工作状态失败，错误码: ${hCNetSDK.NET_DVR_GetLastError()}，${hCNetSDK.NET_DVR_GetErrorMsg(IntByReference(hCNetSDK.NET_DVR_GetLastError()))}"
        }

        // 读取数据
        pos.read()

        return """
            设备${registeredCameraMap[userId]?.name ?: "未知设备"}的位置:
            获取的PanPos: ${pos.wPanPos}
            获取的TiltPos: ${pos.wTiltPos}
            获取的ZoomPos: ${pos.wZoomPos}
            显示的PanPos: ${getDisplayPos(pos.wPanPos)}
            显示的TiltPos: ${getDisplayPos(pos.wTiltPos)}
            显示的ZoomPos: ${getDisplayPos(pos.wZoomPos)}
        """.trimIndent()
    }

    /**
     * 获取云台显示的PTZ位置
     * 将真实位置值转换为显示位置值
     *
     * @param value 云台获取的位置值
     */
    private fun getDisplayPos(value: Short): Int = (value.toInt() ushr 4).toString(16).toInt()
}
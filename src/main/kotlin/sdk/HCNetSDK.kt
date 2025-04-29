package org.example.sdk

import com.sun.jna.Library
import com.sun.jna.Native
import com.sun.jna.Pointer
import com.sun.jna.ptr.IntByReference
import org.example.structure.NET_DVR_DEVICEINFO_V40
import org.example.structure.NET_DVR_USER_LOGIN_INFO
import org.example.structure.NET_DVR_WORKSTATE_V30

interface HCNetSDK : Library {
    companion object {
        /**
         * 加载HCNetSDK库实例
         * name: 海康动态链接库HCNetSDK.dll的绝对路径
         * 如果编译项目使用jar包运行，该路径不能打包在jar包中，无法加载处于jar包中的dll
         */
        val INSTANCE: HCNetSDK by lazy {
            // 替换为本地动态链接库HCNetSDK.dll的绝对路径
            Native.load(System.getProperty("user.dir") + "\\dll\\" + "HCNetSDK.dll", HCNetSDK::class.java)
        }
    }

    // ============== 根据SDK手册定义SDK加载函数 ==============
    fun NET_DVR_Init(): Boolean
    fun NET_DVR_SetConnectTime(dwWaitTime: Int, dwTryTimes: Int): Boolean
    fun NET_DVR_SetReconnect(dwInterval: Int, bEnableRecon: Boolean): Boolean

    // 用户登录接口
    fun NET_DVR_Login_V40(pLoginInfo: NET_DVR_USER_LOGIN_INFO?, lpDeviceInfo: NET_DVR_DEVICEINFO_V40?): Int

    // 登出释放资源接口
    fun NET_DVR_Logout(lUserID: Int): Boolean
    fun NET_DVR_Cleanup(): Boolean

    // 异常信息捕获接口
    fun NET_DVR_GetLastError(): Int
    fun NET_DVR_GetErrorMsg(pErrorNo: IntByReference): String

    // 设备能力集接口
    fun NET_DVR_GetDVRWorkState_V30(lUserID: Int, lpWorkState: NET_DVR_WORKSTATE_V30): Boolean
    fun NET_DVR_GetDVRConfig(lUserID: Int, dwCommand: Int, lChannel: Int, lpOutBuffer: Pointer?, dwOutBufferSize: Int, lpBytesReturned: IntByReference?): Boolean
    fun NET_DVR_SetDVRConfig(lUserID: Int, dwCommand: Int, lChannel: Int, lpInBuffer: Pointer?, dwInBufferSize: Int): Boolean
}
package org.example.function.callback

import com.sun.jna.Callback
import com.sun.jna.Pointer
import org.example.structure.NET_DVR_DEVICEINFO_V30

// ============== 回调接口 ==============
interface LoginResultCallback : Callback {
    /**
     * 登录结果回调
     * @param lUserID 用户ID
     * @param dwResult 登录结果 0-失败，1-成功
     * @param lpDeviceInfo 设备信息结构体
     * @param pUser 用户数据指针
     */
    fun invoke(
        lUserID: Int,
        dwResult: Int,
        lpDeviceInfo: NET_DVR_DEVICEINFO_V30?,
        pUser: Pointer?
    ): Int
}
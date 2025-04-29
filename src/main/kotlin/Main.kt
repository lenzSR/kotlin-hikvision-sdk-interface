package org.example

import org.example.util.HCNetSDKUtil
import org.example.util.HCNetSDKUtil.hCNetSDK

fun main() {
    HCNetSDKUtil
    // 等待异步登录完成
    Thread.sleep(5000)
    HCNetSDKUtil.registeredCameraMap.forEach { (userId, _) ->
        println(HCNetSDKUtil.getDVRConfig(userId))
        hCNetSDK.NET_DVR_Logout(userId)
    }
    hCNetSDK.NET_DVR_Cleanup()
}
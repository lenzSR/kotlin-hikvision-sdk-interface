package org.example.structure

import com.sun.jna.Pointer
import com.sun.jna.Structure
import org.example.constant.HCNetSDKConstant
import org.example.function.callback.LoginResultCallback

@Structure.FieldOrder(
    "sDeviceAddress", "byUseTransport", "wPort", "sUserName", "sPassword", "cbLoginResult",
    "pUser", "bUseAsynLogin", "byProxyType", "byUseUTCTime", "byLoginMode", "byHttps",
    "iProxyID", "byVerifyMode", "byRes2"
)
class NET_DVR_USER_LOGIN_INFO : Structure() {
    @JvmField var sDeviceAddress: ByteArray = ByteArray(HCNetSDKConstant.NET_DVR_DEV_ADDRESS_MAX_LEN)
    @JvmField var byUseTransport: Byte = 0
    @JvmField var wPort: Short = 0
    @JvmField var sUserName: ByteArray = ByteArray(HCNetSDKConstant.NET_DVR_LOGIN_USERNAME_MAX_LEN)
    @JvmField var sPassword: ByteArray = ByteArray(HCNetSDKConstant.NET_DVR_LOGIN_PASSWD_MAX_LEN)
    @JvmField var cbLoginResult: LoginResultCallback? = null
    @JvmField var pUser: Pointer? = null
    @JvmField var bUseAsynLogin: Boolean = false
    @JvmField var byProxyType: Byte = 0
    @JvmField var byUseUTCTime: Byte = 0
    @JvmField var byLoginMode: Byte = 0
    @JvmField var byHttps: Byte = 0
    @JvmField var iProxyID: Int = 0
    @JvmField var byVerifyMode: Byte = 0
    @JvmField var byRes2: ByteArray = ByteArray(119)
}
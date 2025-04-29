package org.example.structure

import com.sun.jna.Pointer
import com.sun.jna.Structure
import org.example.constant.HCNetSDKConstant
import org.example.function.callback.LoginResultCallback

@Structure.FieldOrder(
    "wAction",
    "wPanPos",
    "wTiltPos",
    "wZoomPos"
)
class NET_DVR_PTZPOS : Structure() {
    @JvmField var wAction: Short = 0    // 获取时该字段无效
    @JvmField var wPanPos: Short = 0    // 水平参数
    @JvmField var wTiltPos: Short = 0   // 垂直参数
    @JvmField var wZoomPos: Short = 0   // 变倍参数
}
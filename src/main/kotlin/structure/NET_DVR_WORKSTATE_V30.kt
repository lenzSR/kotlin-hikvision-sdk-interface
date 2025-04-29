package org.example.structure

import com.sun.jna.Structure
import org.example.constant.HCNetSDKConstant.MAX_ALARMIN_V30
import org.example.constant.HCNetSDKConstant.MAX_ALARMOUT_V30
import org.example.constant.HCNetSDKConstant.MAX_AUDIO_V30
import org.example.constant.HCNetSDKConstant.MAX_CHANNUM_V30
import org.example.constant.HCNetSDKConstant.MAX_DISKNUM_V30

/**
 * 设备工作状态结构体(V30版本)
 */
@Structure.FieldOrder(
    "dwDeviceStatic", "struHardDiskStatic", "struChanStatic",
    "byAlarmInStatic", "byAlarmOutStatic", "dwLocalDisplay",
    "byAudioChanStatus", "byRes"
)
class NET_DVR_WORKSTATE_V30 : Structure() {
    // 设备整体状态
    @JvmField var dwDeviceStatic: Int = 0     // 设备状态:
    // 0-正常, 1-CPU占用>85%, 2-硬件错误

    // 存储状态(最多33个硬盘)
    @JvmField var struHardDiskStatic: Array<NET_DVR_DISKSTATE?> = arrayOfNulls(MAX_DISKNUM_V30)

    // 通道状态(最多64个通道)
    @JvmField var struChanStatic: Array<NET_DVR_CHANNELSTATE_V30?> = arrayOfNulls(MAX_CHANNUM_V30)

    // 报警状态
    @JvmField var byAlarmInStatic: ByteArray = ByteArray(MAX_ALARMIN_V30)  // 报警输入状态(每个bit代表一个端口)
    @JvmField var byAlarmOutStatic: ByteArray = ByteArray(MAX_ALARMOUT_V30)  // 报警输出状态(每个bit代表一个端口)

    // 显示状态
    @JvmField var dwLocalDisplay: Int = 0     // 本地显示状态: 0-正常, 1-不正常

    // 语音通道状态
    @JvmField var byAudioChanStatus: ByteArray = ByteArray(MAX_AUDIO_V30)  // 语音通道状态:
    // 0-未使用, 1-使用中, 0xFF-无效

    // 保留字段
    @JvmField var byRes: ByteArray = ByteArray(10)
}
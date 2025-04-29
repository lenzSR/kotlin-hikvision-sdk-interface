package org.example.structure

import com.sun.jna.Structure
import org.example.constant.HCNetSDKConstant

/**
 * 设备信息V30结构体
 */
@Structure.FieldOrder(
    "sSerialNumber", "byDVRType", "wDevType", "byChanNum", "byStartChan", "byIPChanNum", "byHighDChanNum",
    "byStartDChan", "byAudioChanNum", "byStartDTalkChan", "byVoiceInChanNum", "byStartVoiceInChanNo",
    "byAlarmInPortNum", "byAlarmOutPortNum", "byDiskNum", "byMainProto", "bySubProto",
    "byMultiStreamProto", "bySupport", "bySupport1", "bySupport2", "bySupport3",
    "bySupport4", "byZeroChanNum", "byLanguageType", "byMirrorChanNum", "wStartMirrorChanNo",
    "byRes2"
)
class NET_DVR_DEVICEINFO_V30 : Structure() {
    // 设备基本信息
    @JvmField var sSerialNumber: ByteArray = ByteArray(HCNetSDKConstant.SERIALNO_LEN) // 设备序列号
    @JvmField var byDVRType: Byte = 0 // 设备类型: 1-DVR, 2-ATM DVR, 3-DVS...
    @JvmField var wDevType: Short = 0 // 设备型号

    // 通道信息
    @JvmField var byChanNum: Byte = 0 // 模拟通道个数
    @JvmField var byStartChan: Byte = 0 // 起始通道号
    @JvmField var byIPChanNum: Byte = 0 // 数字通道个数(低位)
    @JvmField var byHighDChanNum: Byte = 0 // 数字通道个数(高位)
    @JvmField var byStartDChan: Byte = 0 // 起始数字通道号(0表示无效)

    // 音频相关
    @JvmField var byAudioChanNum: Byte = 0 // 语音通道数
    @JvmField var byStartDTalkChan: Byte = 0 // 起始数字对讲通道号
    @JvmField var byVoiceInChanNum: Byte = 0 // 音频输入通道数
    @JvmField var byStartVoiceInChanNo: Byte = 0 // 音频输入起始通道号

    // 报警相关
    @JvmField var byAlarmInPortNum: Byte = 0 // 报警输入个数
    @JvmField var byAlarmOutPortNum: Byte = 0 // 报警输出个数

    // 存储相关
    @JvmField var byDiskNum: Byte = 0 // 硬盘个数

    // 协议支持
    @JvmField var byMainProto: Byte = 0 // 主码流协议: 0-private, 1-rtsp, 2-两者
    @JvmField var bySubProto: Byte = 0 // 子码流协议: 0-private, 1-rtsp, 2-两者
    @JvmField var byMultiStreamProto: Byte = 0 // 多码流支持(按位表示)

    // 能力集
    @JvmField var bySupport: Byte = 0 // 能力集
    @JvmField var bySupport1: Byte = 0 // 能力集扩展1
    @JvmField var bySupport2: Byte = 0 // 能力集扩展2
    @JvmField var bySupport3: Byte = 0 // 能力集扩展3
    @JvmField var bySupport4: Byte = 0 // 能力集扩展4

    // 其他功能
    @JvmField var byZeroChanNum: Byte = 0 // 零通道编码个数
    @JvmField var byLanguageType: Byte = 0 // 支持语种能力(按位表示)
    @JvmField var byMirrorChanNum: Byte = 0 // 镜像通道个数
    @JvmField var wStartMirrorChanNo: Short = 0 // 起始镜像通道号

    // 保留字段
    @JvmField var byRes2: Byte = 0
}
package org.example.structure

import com.sun.jna.Structure

/**
 * 通道状态结构体(V30版本)
 */
@Structure.FieldOrder(
    "byRecordStatic", "bySignalStatic", "byHardwareStatic",
    "dwBitRate", "dwLinkNum", "dwIPLinkNum", "byExceedMaxLink",
    "struClientIP", "dwAllBitRate", "dwChannelNo",
    "byRes1", "byRes"
)
class NET_DVR_CHANNELSTATE_V30 : Structure() {
    // 通道基本状态
    @JvmField var byRecordStatic: Byte = 0    // 录像状态: 0-不录像, 1-录像
    @JvmField var bySignalStatic: Byte = 0    // 信号状态: 0-正常, 1-信号丢失
    @JvmField var byHardwareStatic: Byte = 0  // 硬件状态: 0-正常, 1-异常

    // 连接信息
    @JvmField var dwBitRate: Int = 0          // 当前码率(bps)
    @JvmField var dwLinkNum: Int = 0          // 客户端连接数
    @JvmField var dwIPLinkNum: Int = 0        // IP接入连接数(如果是IP通道)
    @JvmField var byExceedMaxLink: Byte = 0   // 是否超过最大连接数: 0-未超, 1-已超

    // 客户端IP信息(最多6个)
    @JvmField var struClientIP: Array<NET_DVR_IPADDR?> = arrayOfNulls(6)

    // 扩展信息
    @JvmField var dwAllBitRate: Int = 0       // 所有码率总和(bps)
    @JvmField var dwChannelNo: Int = 0       // 通道号(0xFFFFFFFF表示无效)

    // 保留字段
    @JvmField var byRes1: Byte = 0
    @JvmField var byRes: ByteArray = ByteArray(3)
}
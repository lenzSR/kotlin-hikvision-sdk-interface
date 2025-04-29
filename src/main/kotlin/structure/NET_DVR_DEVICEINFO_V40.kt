package org.example.structure

import com.sun.jna.Structure

/**
 * 设备信息V40结构体(扩展V30)
 */
@Structure.FieldOrder(
    "struDeviceV30", "bySupportLock", "byRetryLoginTime", "byPasswordLevel", "dwSurplusLockTime",
    "byCharEncodeType", "bySupportDev5", "bySupport", "bySupportStreamEncrypt", "byLoginMode",
    "dwOEMCode", "iResidualValidity", "byResidualValidity", "byPassWordResetLevel",
    "bySingleStartDTalkChan", "bySingleDTalkChanNums", "byMarketType", "byRes1", "byRes2"
)
class NET_DVR_DEVICEINFO_V40 : Structure() {
    // 基础设备信息
    @JvmField var struDeviceV30: NET_DVR_DEVICEINFO_V30 = NET_DVR_DEVICEINFO_V30()

    // 安全相关
    @JvmField var bySupportLock: Byte = 0 // 是否支持锁定
    @JvmField var byRetryLoginTime: Byte = 0 // 重试登录时间
    @JvmField var byPasswordLevel: Byte = 0 // 密码强度
    @JvmField var dwSurplusLockTime: Int = 0 // 剩余锁定时间

    // 国际化支持
    @JvmField var byCharEncodeType: Byte = 0 // 字符编码类型

    // 扩展能力
    @JvmField var bySupportDev5: Byte = 0 // 是否支持V50版本
    @JvmField var bySupport: Byte = 0 // 能力集扩展
    @JvmField var bySupportStreamEncrypt: Byte = 0 // 流加密支持

    // 登录信息
    @JvmField var byLoginMode: Byte = 0 // 登录模式
    @JvmField var dwOEMCode: Int = 0 // OEM代码

    // 密码策略
    @JvmField var iResidualValidity: Int = 0 // 密码剩余有效天数
    @JvmField var byResidualValidity: Byte = 0 // 密码有效期是否有效
    @JvmField var byPassWordResetLevel: Byte = 0 // 密码重置级别

    // 音轨通道
    @JvmField var bySingleStartDTalkChan: Byte = 0 // 独立音轨起始通道
    @JvmField var bySingleDTalkChanNums: Byte = 0 // 独立音轨通道总数

    // 设备类型
    @JvmField var byMarketType: Byte = 0 // 市场类型: 1-经销型,2-行业型

    // 保留字段
    @JvmField var byRes1: Byte = 0
    @JvmField var byRes2: ByteArray = ByteArray(238)
}
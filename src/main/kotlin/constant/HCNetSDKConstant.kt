package org.example.constant

object HCNetSDKConstant {
    const val SERIALNO_LEN: Int = 48
    const val NET_DVR_DEV_ADDRESS_MAX_LEN: Int = 129
    const val NET_DVR_LOGIN_USERNAME_MAX_LEN: Int = 64
    const val NET_DVR_LOGIN_PASSWD_MAX_LEN: Int = 64
    const val MAX_ANALOG_CHANNUM: Int = 32;    //最大32个模拟通道
    const val MAX_ANALOG_ALARMOUT: Int = 32;    //最大32路模拟报警输出
    const val MAX_ANALOG_ALARMIN: Int = 32;    //最大32路模拟报警输入
    const val MAX_IP_ALARMIN_V40: Int = 4096;    //允许加入的最多报警输入数
    const val MAX_IP_ALARMOUT_V40: Int = 4096;    //允许加入的最多报警输出数
    const val MAX_ALARMOUT_V40: Int = (MAX_IP_ALARMOUT_V40 + MAX_ANALOG_ALARMOUT) //4128
    const val MAX_ALARMIN_V40: Int = (MAX_IP_ALARMIN_V40 + MAX_ANALOG_ALARMOUT) //4128
    const val MAX_CHANNUM_V40: Int = 512
    const val MAX_IP_DEVICE: Int = 32    //允许接入的最大IP设备数
    const val MAX_IP_CHANNEL: Int = 32   //允许加入的最多IP通道数
    const val MAX_IP_ALARMIN: Int = 128   //允许加入的最多报警输入数
    const val MAX_IP_ALARMOUT: Int = 64 //允许加入的最多报警输出数

    /* 最大支持的通道数 最大模拟加上最大IP支持 */
    const val MAX_CHANNUM_V30: Int = (MAX_ANALOG_CHANNUM + MAX_IP_CHANNEL)  //64
    const val MAX_ALARMOUT_V30: Int = (MAX_ANALOG_ALARMOUT + MAX_IP_ALARMOUT)   //96
    const val MAX_ALARMIN_V30: Int = (MAX_ANALOG_ALARMIN + MAX_IP_ALARMIN)  //160
    const val MAX_AUDIO_V30: Int = 2
    const val MAX_DISKNUM_V30: Int = 33
    const val MAX_LINK: Int = 6
    const val NET_DVR_GET_PTZPOS: Int = 293
}
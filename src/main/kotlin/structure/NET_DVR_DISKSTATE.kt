package org.example.structure

import com.sun.jna.Structure

/**
 * 硬盘状态结构体
 */
@Structure.FieldOrder(
    "dwVolume", "dwFreeSpace", "dwHardDiskStatic"
)
class NET_DVR_DISKSTATE : Structure() {
    @JvmField var dwVolume: Int = 0          // 硬盘总容量(MB)
    @JvmField var dwFreeSpace: Int = 0       // 硬盘剩余空间(MB)
    @JvmField var dwHardDiskStatic: Int = 0  // 硬盘状态(按位):
    // 0x1-休眠, 0x2-不正常, 0x4-休眠硬盘出错
}

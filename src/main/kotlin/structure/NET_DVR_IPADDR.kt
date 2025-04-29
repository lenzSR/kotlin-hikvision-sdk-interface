package org.example.structure

import com.sun.jna.Structure

/**
 * IP地址结构体
 */
@Structure.FieldOrder(
    "sIpV4", "byRes"
)
class NET_DVR_IPADDR : Structure() {
    @JvmField var sIpV4: ByteArray = ByteArray(16)  // IPv4地址
    @JvmField var byRes: ByteArray = ByteArray(128) // 保留字段

    override fun toString(): String {
        return """
        NET_DVR_IPADDR:
          sIpV4: ${String(sIpV4)}
          byRes: ${String(byRes)}
        """.trimIndent()
    }
}
package com.company.attendance.utils

import java.security.MessageDigest
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object CryptoUtils {
    
    private const val HMAC_ALGORITHM = "HmacSHA256"
    private const val SHARED_SECRET = "your_shared_secret_here" // Should match server
    
    fun generateEventId(deviceUuid: String, timestamp: Long): String {
        val data = "$deviceUuid$timestamp"
        return generateHMAC(data, SHARED_SECRET)
    }
    
    private fun generateHMAC(data: String, key: String): String {
        val secretKeySpec = SecretKeySpec(key.toByteArray(), HMAC_ALGORITHM)
        val mac = Mac.getInstance(HMAC_ALGORITHM)
        mac.init(secretKeySpec)
        val hmacBytes = mac.doFinal(data.toByteArray())
        return bytesToHex(hmacBytes)
    }
    
    private fun bytesToHex(bytes: ByteArray): String {
        return bytes.joinToString("") { "%02x".format(it) }
    }
    
    fun sha256Hash(input: String): String {
        val bytes = MessageDigest.getInstance("SHA-256").digest(input.toByteArray())
        return bytesToHex(bytes)
    }
}
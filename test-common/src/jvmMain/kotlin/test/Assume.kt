package test

import org.junit.jupiter.api.Assumptions
import java.net.NetworkInterface

fun assumeDevPcTest() = Assumptions.assumeTrue {
    val addresses = NetworkInterface.getNetworkInterfaces().toList().map { it.inetAddresses.toList().map { inetAddress -> inetAddress.hostAddress } }.flatten()
    addresses.any { it.startsWith("192.168.168.") }
}

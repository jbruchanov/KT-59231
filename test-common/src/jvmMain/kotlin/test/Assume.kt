package test

import java.net.NetworkInterface
import org.junit.jupiter.api.Assumptions

fun assumeDevPcTest() = Assumptions.assumeTrue {
    val addresses = NetworkInterface.getNetworkInterfaces().toList().map { it.inetAddresses.toList().map { inetAddress -> inetAddress.hostAddress } }.flatten()
    addresses.any { it.startsWith("192.168.168.") }
}

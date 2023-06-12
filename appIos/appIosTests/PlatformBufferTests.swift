
import XCTest

import JibruCore

final class PlatformBufferTests: XCTestCase {
    
    private var sampleString = "Hello World!"
    private var sampleStringData: Data!
    

    override func setUp() {
        self.sampleStringData = self.sampleString.data(using: .utf8)!
    }
    
    func testInsert_When_sameLength_Then_positionUpdated() throws {
        let pf = PlatformBufferKt.allocatePlatformBuffer(size: 16)
        XCTAssertEqual(pf.position(), 0)
        
        IosPlatformBufferKt.write(pf, data: sampleStringData, length: Int32(sampleString.count))
        XCTAssertEqual(pf.position(), Int32(sampleString.count))
    }
    
    func testInsert_When_differentLength_Then_positionUpdated() throws {
        let pf = PlatformBufferKt.allocatePlatformBuffer(size: 16)
        XCTAssertEqual(pf.position(), 0)
        
        IosPlatformBufferKt.write(pf, data: sampleStringData, length: Int32(2))
        XCTAssertEqual(pf.position(), Int32(2))
    }
    
    func testInsert_When_fullLength_Then_expectedValue() throws {
        let pf = PlatformBufferKt.allocatePlatformBuffer(size: 16)
        pf.writeString(text: "1234567890123456", charset: .utf8)
        pf.position(newPosition: 0)
        
        IosPlatformBufferKt.write(pf, data: sampleStringData, length: Int32(sampleString.count))
        
        let nsData = IosPlatformBufferKt.mutableDataUnsafe(pf)
        let result = NSString(bytes: nsData.bytes, length: nsData.count, encoding: NSUTF8StringEncoding)! as String
        XCTAssertEqual(result, "Hello World!3456")
    }
    
    func testInsert_When_partialLength_Then_expectedValue() throws {
        let pf = PlatformBufferKt.allocatePlatformBuffer(size: 16)
        pf.writeString(text: "1234567890123456", charset: .utf8)
        pf.position(newPosition: 0)
        
        IosPlatformBufferKt.write(pf, data: sampleStringData, length: Int32(2))
        
        let nsData = IosPlatformBufferKt.mutableDataUnsafe(pf)
        let result = NSString(bytes: nsData.bytes, length: nsData.count, encoding: NSUTF8StringEncoding)! as String
        XCTAssertEqual(result, "He34567890123456")
    }
}

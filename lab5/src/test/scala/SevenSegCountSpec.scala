import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class SevenSegCountSpec extends AnyFlatSpec with ChiselScalatestTester {
	"SevenSegTest " should "pass" in {
		test(new CountSevenSeg).withAnnotations(Seq(WriteVcdAnnotation)) { dut =>
			
			def print7Segment(x:BigInt,y: Int) = {
				var tempStr = ""
				println(y.toHexString)                         //Print the hexadecimal value
				println(if ((~x & 0x01) != 0) " _"  else " ")  //Print top "_"
				tempStr += (if((~x & 0x20) != 0) "|" else " ") //Print top left "|"
				tempStr += (if((~x & 0x40) != 0) "_" else " ") //Print middle "_"
				tempStr += (if((~x & 0x2) != 0) "|" else " ")  //Print top right "|"
				println(tempStr)
				tempStr = (if((~x & 0x10) != 0) "|" else " ")  //Print lower left "|"
				tempStr += (if((~x & 0x8) != 0) "_" else " ")  //Print lower "_"
				tempStr += (if((~x & 0x4) != 0) "|" else " ")  //Print lower right "|"
				println(tempStr)
				println()                                      //Print empty line
			}

			for (value <- 0 until 20) {
				println(dut.io.seg.peek().litValue.toString(2).reverse.padTo(7,'0').reverse) // And check the value on the output.
				print7Segment(dut.io.seg.peek().litValue, value%16) // Here we print the result, as it would look on the 7-segment display.
                dut.clock.step(1)
			}
			
		}
	}
}

import chisel3._
import chisel3.util._

class DisplayMultiplexer extends Module {
  val io = IO(new Bundle {
    val sum = Input(UInt(16.W))
    val seg = Output(UInt(7.W))
    val an = Output(UInt(4.W))
  })

  val sevSeg = WireDefault("b1111111".U(7.W))
  val select = WireDefault("b0001".U(4.W))

  // *** your code starts here
  
  object State extends ChiselEnum {
    val sum1, sum2, sum3, sum4 = Value
  }
  import State._

  val stateReg = RegInit(sum1)
  val sev = Module(new SevenSegDec())
  sev.io.in := io.sum(3,0)
  select := "b0001".U(4.W)
  
  switch(stateReg) {
    is(sum1) {
      sev.io.in := io.sum(3,0)
	  sevSeg := sev.io.out
	  select := "b0001".U(4.W)
      stateReg := sum2
    }
    is(sum2) {
      sev.io.in := io.sum(7,4)
	  sevSeg := sev.io.out
	  select := "b0010".U(4.W)
      stateReg := sum3
    }
    is(sum3) {
      sev.io.in := io.sum(11,8)
	  sevSeg := sev.io.out
	  select := "b0100".U(4.W)
      stateReg := sum4
    }
    is(sum4) {
      sev.io.in := io.sum(15,12)
	  sevSeg := sev.io.out
	  select := "b1000".U(4.W)
      stateReg := sum1
    }
  }
  
  // *** your code ends here

  io.seg := ~sevSeg
  io.an := ~select
}

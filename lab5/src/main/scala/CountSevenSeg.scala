import chisel3._

class CountSevenSeg extends Module {
  val io = IO(new Bundle {
    val seg = Output(UInt(7.W))
    val an = Output(UInt(4.W))
  })

  val sevSeg = WireDefault("b1111111".U(7.W))

  // *** your code starts here
  val tickCounterReg = RegInit(0.U(4.W))
  val sevModule = Module(new SevenSegDecoder ())
  sevModule.io.sw := tickCounterReg
  sevSeg := ~sevModule.io.seg

  tickCounterReg := tickCounterReg + 1.U

  // *** your code ends here

  io.seg := ~sevSeg
  io.an := "b1110".U
}

// generate Verilog
object CountSevenSeg extends App {
  emitVerilog(new CountSevenSeg())
}
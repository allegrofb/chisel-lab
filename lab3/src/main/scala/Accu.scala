import chisel3._

class Accu extends Module {
  val io = IO(new Bundle {
    val din = Input(UInt(8.W))
    val setZero = Input(Bool())
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****
  val accu = RegInit(0.U(8.W))
  accu := Mux(io.setZero, 0.U, accu + io.din)
  //res := 0.U // dummy code to make it compile
  res := accu

  // ***** your code ends here *****

  io.dout := res
}
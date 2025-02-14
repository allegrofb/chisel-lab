import chisel3._

class Count15 extends Module {
  val io = IO(new Bundle {
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****
  val cntReg = RegInit (0.U(8.W))
  cntReg := Mux(cntReg === 15.U, 0.U, cntReg + 1.U)
  res := cntReg
  //res := 0.U // dummy code to make it compile

  // ***** your code ends here *****

  io.dout := res
}
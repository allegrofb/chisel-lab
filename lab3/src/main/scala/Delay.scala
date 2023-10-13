import chisel3._

class Delay extends Module {
  val io = IO(new Bundle {
    val din = Input(UInt(8.W))
    val dout = Output(UInt(8.W))
  })

  val res = Wire(UInt())

  // ***** your code starts here *****

  // below is dummy code to make this example compile
  //res := io.din
  val delay = RegNext(RegNext(io.din))
  res := delay

  // ***** your code ends here *****

  io.dout := res
}
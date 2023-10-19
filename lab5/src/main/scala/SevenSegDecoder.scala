import chisel3._
import chisel3.util._

class SevenSegDecoder extends Module {
  val io = IO(new Bundle {
    val sw = Input(UInt(4.W))
    val seg = Output(UInt(7.W))
    val an = Output(UInt(4.W))
  })

  val sevSeg = WireDefault(0.U(7.W))
  
  // ***** your code starts here *****

  val sev = Wire(Vec(7, UInt (1.W)))
  when(io.sw === 0.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 0.U
  } .elsewhen(io.sw === 1.U) {
	    sev(0) := 0.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 0.U
		sev(4) := 0.U
		sev(5) := 0.U
		sev(6) := 0.U
  } .elsewhen(io.sw === 2.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 0.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 0.U
		sev(6) := 1.U
  } .elsewhen(io.sw === 3.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 0.U
		sev(5) := 0.U
		sev(6) := 1.U
  } .elsewhen(io.sw === 4.U) {
	    sev(0) := 0.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 0.U
		sev(4) := 0.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.sw === 5.U) {
	    sev(0) := 1.U
		sev(1) := 0.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 0.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.sw === 6.U) {
	    sev(0) := 1.U
		sev(1) := 0.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.sw === 7.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 0.U
		sev(4) := 0.U
		sev(5) := 0.U
		sev(6) := 0.U
  } .elsewhen(io.sw === 8.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.sw === 9.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 0.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.sw === 10.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 0.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.sw === 11.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.sw === 12.U) {
	    sev(0) := 1.U
		sev(1) := 0.U
		sev(2) := 0.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 0.U
  } .elsewhen(io.sw === 13.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 0.U
  } .elsewhen(io.sw === 14.U) {
	    sev(0) := 1.U
		sev(1) := 0.U
		sev(2) := 0.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.sw === 15.U) {
	    sev(0) := 1.U
		sev(1) := 0.U
		sev(2) := 0.U
		sev(3) := 0.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .otherwise {
	    sev(0) := 0.U
		sev(1) := 0.U
		sev(2) := 0.U
		sev(3) := 0.U
		sev(4) := 0.U
		sev(5) := 0.U
		sev(6) := 1.U
  }
  
  sevSeg := sev.asUInt
  
  // ***** your code ends here *****

  io.seg := ~sevSeg
  io.an := "b1110".U
}

// generate Verilog
object SevenSegDecoder extends App {
  emitVerilog(new SevenSegDecoder())
}



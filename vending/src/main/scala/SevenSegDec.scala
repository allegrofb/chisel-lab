import chisel3._
import chisel3.util._

class SevenSegDec extends Module {
  val io = IO(new Bundle {
    val in = Input(UInt(4.W))
    val out = Output(UInt(7.W))
  })

  val sevSeg = WireDefault(0.U)

  // *** add your table from Lab 6 here or use the version from Lab 8.

  val sev = Wire(Vec(7, UInt (1.W)))
  when(io.in === 0.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 0.U
  } .elsewhen(io.in === 1.U) {
	    sev(0) := 0.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 0.U
		sev(4) := 0.U
		sev(5) := 0.U
		sev(6) := 0.U
  } .elsewhen(io.in === 2.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 0.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 0.U
		sev(6) := 1.U
  } .elsewhen(io.in === 3.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 0.U
		sev(5) := 0.U
		sev(6) := 1.U
  } .elsewhen(io.in === 4.U) {
	    sev(0) := 0.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 0.U
		sev(4) := 0.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.in === 5.U) {
	    sev(0) := 1.U
		sev(1) := 0.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 0.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.in === 6.U) {
	    sev(0) := 1.U
		sev(1) := 0.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.in === 7.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 0.U
		sev(4) := 0.U
		sev(5) := 0.U
		sev(6) := 0.U
  } .elsewhen(io.in === 8.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.in === 9.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 0.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.in === 10.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 0.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.in === 11.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.in === 12.U) {
	    sev(0) := 1.U
		sev(1) := 0.U
		sev(2) := 0.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 0.U
  } .elsewhen(io.in === 13.U) {
	    sev(0) := 1.U
		sev(1) := 1.U
		sev(2) := 1.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 0.U
  } .elsewhen(io.in === 14.U) {
	    sev(0) := 1.U
		sev(1) := 0.U
		sev(2) := 0.U
		sev(3) := 1.U
		sev(4) := 1.U
		sev(5) := 1.U
		sev(6) := 1.U
  } .elsewhen(io.in === 15.U) {
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
  
  sevSeg := ~sev.asUInt
  // *** end adding the table

  io.out := sevSeg
}



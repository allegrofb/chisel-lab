import chisel3._
import chisel3.util._

/**
  * Use Mux2 components to build a 4:1 multiplexer
  */

class Mux4 extends Module {
  val io = IO(new Bundle {
    val a = Input(UInt(1.W))
    val b = Input(UInt(1.W))
    val c = Input(UInt(1.W))
    val d = Input(UInt(1.W))
    val sel = Input(UInt(2.W))
    val y = Output(UInt(1.W))
  })

  // ***** your code starts here *****

  // create a Mux4 component out of Mux2 components
  // and connect the input and output ports.

  val mux2_1 = Module(new Mux2())
  val mux2_2 = Module(new Mux2())
  val mux2_3 = Module(new Mux2())
  mux2_1.io.a := io.a
  mux2_1.io.b := io.b
  mux2_1.io.sel := 0.U
  mux2_2.io.a := io.c
  mux2_2.io.b := io.d
  mux2_2.io.sel := 0.U
  mux2_3.io.a := mux2_1.io.y
  mux2_3.io.b := mux2_2.io.y
  mux2_3.io.sel := 0.U
  
  /*when(io.sel === 0.U) {
	mux2_1.io.sel := 0.U
	mux2_3.io.sel := 0.U
  } .elsewhen(io.sel === 1.U) {
	mux2_1.io.sel := 1.U
	mux2_3.io.sel := 0.U
  } .elsewhen(io.sel === 2.U) {
	mux2_2.io.sel := 0.U
	mux2_3.io.sel := 1.U
  } .elsewhen(io.sel === 3.U) {
	mux2_2.io.sel := 1.U
	mux2_3.io.sel := 1.U
  }*/
  
  switch(io.sel) {
	is (0.U) { 
		mux2_1.io.sel := 0.U
		mux2_3.io.sel := 0.U
	}
	is (1.U) { 
		mux2_1.io.sel := 1.U
		mux2_3.io.sel := 0.U
	}
	is (2.U) { 
		mux2_2.io.sel := 0.U
		mux2_3.io.sel := 1.U
	}
	is (3.U) { 
		mux2_2.io.sel := 1.U
		mux2_3.io.sel := 1.U
	}
  }
  
  io.y := mux2_3.io.y  
  
  // below is dummy code to make this example compile
  //io.y := io.c

  // ***** your code ends here *****
}
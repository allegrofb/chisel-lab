import chisel3._
import chiseltest._
import org.scalatest.flatspec.AnyFlatSpec

class Mux5Test extends AnyFlatSpec with ChiselScalatestTester {
  "Mux5 " should "pass" in {
    test(new Mux5()) { dut =>
      // write your test here
		dut.io.a.poke ("ha".U)
		dut.io.b.poke ("hb".U)
		dut.io.c.poke ("hc".U)
		dut.io.d.poke ("hd".U)
		dut.io.e.poke ("he".U)
		dut.io.sel.poke (0.U)
		dut.io.y.expect ("ha".U)
		//dut.io.sel.poke (1.U)
		//dut.io.y.expect ("hb".U)
		dut.io.sel.poke (2.U)
		dut.io.y.expect ("hc".U)
		dut.io.sel.poke (3.U)
		dut.io.y.expect ("hd".U)
		//dut.io.sel.poke (4.U)
		//dut.io.y.expect ("he".U)
    }
  }
}

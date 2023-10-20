import chisel3._
import chisel3.util._

class VendingMachine(maxCount: Int) extends Module {
  val io = IO(new Bundle {
    val price = Input(UInt(5.W))
    val coin2 = Input(Bool())
    val coin5 = Input(Bool())
    val buy = Input(Bool())
    val releaseCan = Output(Bool())
    val alarm = Output(Bool())
    val seg = Output(UInt(7.W))
    val an = Output(UInt(4.W))
  })

  val sevSeg = WireDefault(0.U)

  // ***** some dummy connections *****
  val sumReg = RegInit(0.U(16.W))
  
  // ***** DisplayMultiplexer *****
  val dispMux = Module(new DisplayMultiplexer())
  dispMux.io.sum := sumReg
  sevSeg := ~dispMux.io.seg

  // ***** received coin2 *****
  val coin2Received = io.coin2 & !RegNext(io.coin2)
  when ( coin2Received ) {
    //printf(s"coin2Received happend\n")
    sumReg := sumReg + 2.U(16.W)
  }
  
  // ***** received coin5 *****
  val coin5Received = io.coin5 & !RegNext(io.coin5)
  when ( coin5Received ) {
    //printf(s"coin5Received happend\n")
    sumReg := sumReg + 5.U(16.W)
  }

  // ***** push buy button *****
  val buyReceived = io.buy & !RegNext(io.buy)

  // ***** delay *****
  val tickCounterReg = RegInit (0.U(32.W))
  val lowFrequCntReg = RegInit (0.U(4.W))
  val tick = tickCounterReg === (300).U
  tickCounterReg := tickCounterReg + 1.U
  when (tick) {
  	tickCounterReg := 0.U
  	lowFrequCntReg := lowFrequCntReg + 1.U
  }
  
  
  // ***** FSM *****
  object State extends ChiselEnum {
    val norm, alarm, releaseCan = Value
  }
  import State._

  val stateReg = RegInit(norm)
  
  val io_alarm = RegInit(0.U)
  val io_releaseCan = RegInit(0.U)  
  
  switch(stateReg) {
    is(norm) {
      when ( buyReceived && (sumReg >= io.price)) {
        //printf(s"norm -> releaseCan\n")
        sumReg := sumReg - io.price
  	    stateReg := releaseCan
        io_releaseCan := 1.U
      } .elsewhen ( buyReceived && (sumReg < io.price)) {
        //printf(s"norm -> alarm\n")
	    stateReg := alarm
        io_alarm := 1.U
      }
    }
    is(alarm) {
      when (lowFrequCntReg =/= RegNext(lowFrequCntReg)) {
        //printf(s"alarm -> norm\n")
        io_alarm := 0.U
		stateReg := norm
	  }
    }
    is(releaseCan) {
      when (lowFrequCntReg =/= RegNext(lowFrequCntReg)) {
        //printf(s"releaseCan -> norm\n")
        io_releaseCan := 0.U
		stateReg := norm
	  }
    }
  }  
  // ***** FSM end *****
  
  //io.alarm := io.coin2
  //io.releaseCan := io.coin5

  io.alarm := io_alarm
  io.releaseCan := io_releaseCan
  
  io.seg := sevSeg
  io.an := dispMux.io.an
}

// generate Verilog
object VendingMachine extends App {
  (new chisel3.stage.ChiselStage).emitVerilog(new VendingMachine(100000))
}



circuit Mux5 :
  module Mux5 :
    input clock : Clock
    input reset : UInt<1>
    output io : { flip a : UInt<8>, flip b : UInt<8>, flip c : UInt<8>, flip d : UInt<8>, flip e : UInt<8>, flip sel : UInt<3>, y : UInt<8>}

    io.y <= UInt<1>("h1") @[Mux5.scala 19:8]
    node _T = eq(UInt<1>("h0"), io.sel) @[Mux5.scala 20:18]
    when _T : @[Mux5.scala 20:18]
      io.y <= io.a @[Mux5.scala 21:25]
    else :
      node _T_1 = eq(UInt<1>("h1"), io.sel) @[Mux5.scala 20:18]
      when _T_1 : @[Mux5.scala 20:18]
        io.y <= UInt<1>("h1") @[Mux5.scala 22:25]
      else :
        node _T_2 = eq(UInt<2>("h2"), io.sel) @[Mux5.scala 20:18]
        when _T_2 : @[Mux5.scala 20:18]
          io.y <= io.c @[Mux5.scala 23:25]
        else :
          node _T_3 = eq(UInt<2>("h3"), io.sel) @[Mux5.scala 20:18]
          when _T_3 : @[Mux5.scala 20:18]
            io.y <= io.d @[Mux5.scala 24:25]
          else :
            node _T_4 = eq(UInt<3>("h5"), io.sel) @[Mux5.scala 20:18]
            when _T_4 : @[Mux5.scala 20:18]
              io.y <= io.e @[Mux5.scala 25:25]



module Mux5(
  input        clock,
  input        reset,
  input  [7:0] io_a,
  input  [7:0] io_b,
  input  [7:0] io_c,
  input  [7:0] io_d,
  input  [7:0] io_e,
  input  [2:0] io_sel,
  output [7:0] io_y
);
  wire [7:0] _GEN_0 = 3'h5 == io_sel ? io_e : 8'h1; // @[Mux5.scala 20:18 25:25 19:8]
  wire [7:0] _GEN_1 = 3'h3 == io_sel ? io_d : _GEN_0; // @[Mux5.scala 20:18 24:25]
  wire [7:0] _GEN_2 = 3'h2 == io_sel ? io_c : _GEN_1; // @[Mux5.scala 20:18 23:25]
  wire [7:0] _GEN_3 = 3'h1 == io_sel ? 8'h1 : _GEN_2; // @[Mux5.scala 20:18 22:25]
  assign io_y = 3'h0 == io_sel ? io_a : _GEN_3; // @[Mux5.scala 20:18 21:25]
endmodule

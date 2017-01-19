/*****************************************
Emitting Generated Code
*******************************************/
package generated.scala
class  extends ((Array[java.lang.String])=>(Unit)) {
  def apply(x0:Array[java.lang.String]): Unit = {
    val x1 = ppl.delite.runtime.profiler.PerformanceTimer.start("load")
    val x2 = generated.scala.io.DeliteFileInputStream(Seq("/home/greg/Research/data/SF1/lineitem.tbl"), None, None,0L)
    val x3 = x2.size
    var x70: Int = 0
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x74 = new Array[Int](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x75 = new Array[Int](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x76 = new Array[Int](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x77 = new Array[Int](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x78 = new Array[Double](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x79 = new Array[Double](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x80 = new Array[Double](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x81 = new Array[Double](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x82 = new Array[java.lang.String](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x83 = new Array[java.lang.String](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x84 = new Array[Int](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x85 = new Array[Int](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x86 = new Array[Int](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x87 = new Array[java.lang.String](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x88 = new Array[java.lang.String](x70.toInt)
    if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x89 = new Array[java.lang.String](x70.toInt)
    val x90 = new generated.scala.DeliteArrayAnon310125598(x74,x75,x76,x77,x78,x79,x80,x81,x82,x83,x84,x85,x86,x87,x88,x89)
    var x375_buf: generated.scala.DeliteArrayAnon310125598 = x90
    var x375_size: Int = 0
    var x375_conditionals: Int = 0
    var x4: Int = 0
    val x2_stream: generated.scala.io.DeliteFileInputStream = x2.openCopyAtNewLine(0)
    val x2_offset: Long = x2.streamOffset
    while (x2_stream.position < x2_offset + x3 ) {
      val x5 = x2_stream.readLine()
      val x6 = x5.split("\\|", -1)
      val x7 = x6(0.toInt)
      val x8 = {
        x7.toInt}
      val x9 = x6(1.toInt)
      val x10 = {
        x9.toInt}
      val x11 = x6(2.toInt)
      val x12 = {
        x11.toInt}
      val x13 = x6(3.toInt)
      val x14 = {
        x13.toInt}
      val x15 = x6(4.toInt)
      val x16 = {
        x15.toDouble}
      val x17 = x6(5.toInt)
      val x18 = {
        x17.toDouble}
      val x19 = x6(6.toInt)
      val x20 = {
        x19.toDouble}
      val x21 = x6(7.toInt)
      val x22 = {
        x21.toDouble}
      val x23 = x6(8.toInt)
      val x24 = x6(9.toInt)
      val x25 = x6(10.toInt)
      val x26 = x25.split("-", 0)
      val x27 = x26(0.toInt)
      val x28 = {
        x27.toInt}
      val x33 = {
        x28 << 9}
      val x31 = x26(2.toInt)
      val x32 = {
        x31.toInt}
      val x29 = x26(1.toInt)
      val x30 = {
        x29.toInt}
      val x34 = {
        x30 << 5}
      val x35 = x34 + x32
      val x36 = x33 + x35
      def x37_block = {
        x36
      }
      val x37 = x37_block
      val x38 = x6(11.toInt)
      val x39 = x38.split("-", 0)
      val x40 = x39(0.toInt)
      val x41 = {
        x40.toInt}
      val x46 = {
        x41 << 9}
      val x44 = x39(2.toInt)
      val x45 = {
        x44.toInt}
      val x42 = x39(1.toInt)
      val x43 = {
        x42.toInt}
      val x47 = {
        x43 << 5}
      val x48 = x47 + x45
      val x49 = x46 + x48
      def x50_block = {
        x49
      }
      val x50 = x50_block
      val x51 = x6(12.toInt)
      val x52 = x51.split("-", 0)
      val x53 = x52(0.toInt)
      val x54 = {
        x53.toInt}
      val x59 = {
        x54 << 9}
      val x57 = x52(2.toInt)
      val x58 = {
        x57.toInt}
      val x55 = x52(1.toInt)
      val x56 = {
        x55.toInt}
      val x60 = {
        x56 << 5}
      val x61 = x60 + x58
      val x62 = x59 + x61
      def x63_block = {
        x62
      }
      val x63 = x63_block
      val x64 = x6(13.toInt)
      val x65 = x6(14.toInt)
      val x66 = x6(15.toInt)
      val x67 = new generated.scala.Anon310125598(x8,x10,x12,x14,x16,x18,x20,x22,x23,x24,x37,x50,x63,x64,x65,x66)
      val x68 = x375_buf
      val x69 = x67
      if (true) {
        val x143 = x375_size
        val x144 = x68.l_orderkey_36
        val x145 = x144.length
        val x146 = x145 - 1
        val x147 = x143 > x146
        val x251 = {
          def x251thenb(): Unit = {
            val x148 = x145 < 16
            val x152 = {
              def x152thenb(): Int = {
                16
              }
              def x152elseb(): Int = {
                val x149 = x145 * 2
                val x150 = x149 < 0
                val x151 = {
                  def x151thenb(): Int = {
                    2147483647
                  }
                  def x151elseb(): Int = {
                    x149
                  }
                  if (x150) {
                    x151thenb()
                  } else {
                    x151elseb()
                  }
                }
                x151
              }
              if (x148) {
                x152thenb()
              } else {
                x152elseb()
              }
            }
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x153 = new Array[Int](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x154 = new Array[Int](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x155 = new Array[Int](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x156 = new Array[Int](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x157 = new Array[Double](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x158 = new Array[Double](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x159 = new Array[Double](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x160 = new Array[Double](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x161 = new Array[java.lang.String](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x162 = new Array[java.lang.String](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x163 = new Array[Int](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x164 = new Array[Int](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x165 = new Array[Int](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x166 = new Array[java.lang.String](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x167 = new Array[java.lang.String](x152.toInt)
            if (x152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x168 = new Array[java.lang.String](x152.toInt)
            val x170 = System.arraycopy(x144,0.toInt,x153,0.toInt,x145.toInt)
            val x171 = x68.l_partkey_37
            val x172 = System.arraycopy(x171,0.toInt,x154,0.toInt,x145.toInt)
            val x173 = x68.l_suppkey_38
            val x174 = System.arraycopy(x173,0.toInt,x155,0.toInt,x145.toInt)
            val x175 = x68.l_linenumber_39
            val x176 = System.arraycopy(x175,0.toInt,x156,0.toInt,x145.toInt)
            val x177 = x68.l_quantity_40
            val x178 = System.arraycopy(x177,0.toInt,x157,0.toInt,x145.toInt)
            val x179 = x68.l_extendedprice_41
            val x180 = System.arraycopy(x179,0.toInt,x158,0.toInt,x145.toInt)
            val x181 = x68.l_discount_42
            val x182 = System.arraycopy(x181,0.toInt,x159,0.toInt,x145.toInt)
            val x183 = x68.l_tax_43
            val x184 = System.arraycopy(x183,0.toInt,x160,0.toInt,x145.toInt)
            val x185 = x68.l_returnflag_44
            val x186 = System.arraycopy(x185,0.toInt,x161,0.toInt,x145.toInt)
            val x187 = x68.l_linestatus_45
            val x188 = System.arraycopy(x187,0.toInt,x162,0.toInt,x145.toInt)
            val x189 = x68.l_shipdate_46
            val x190 = System.arraycopy(x189,0.toInt,x163,0.toInt,x145.toInt)
            val x191 = x68.l_commitdate_47
            val x192 = System.arraycopy(x191,0.toInt,x164,0.toInt,x145.toInt)
            val x193 = x68.l_receiptdate_48
            val x194 = System.arraycopy(x193,0.toInt,x165,0.toInt,x145.toInt)
            val x195 = x68.l_shipinstruct_49
            val x196 = System.arraycopy(x195,0.toInt,x166,0.toInt,x145.toInt)
            val x197 = x68.l_shipmode_50
            val x198 = System.arraycopy(x197,0.toInt,x167,0.toInt,x145.toInt)
            val x199 = x68.l_comment_51
            val x200 = System.arraycopy(x199,0.toInt,x168,0.toInt,x145.toInt)
            val x95 = x69.l_orderkey_36
            val x201 = x153(x143.toInt) = x95
            val x98 = x69.l_partkey_37
            val x202 = x154(x143.toInt) = x98
            val x101 = x69.l_suppkey_38
            val x203 = x155(x143.toInt) = x101
            val x104 = x69.l_linenumber_39
            val x204 = x156(x143.toInt) = x104
            val x107 = x69.l_quantity_40
            val x205 = x157(x143.toInt) = x107
            val x110 = x69.l_extendedprice_41
            val x206 = x158(x143.toInt) = x110
            val x113 = x69.l_discount_42
            val x207 = x159(x143.toInt) = x113
            val x116 = x69.l_tax_43
            val x208 = x160(x143.toInt) = x116
            val x119 = x69.l_returnflag_44
            val x209 = x161(x143.toInt) = x119
            val x122 = x69.l_linestatus_45
            val x210 = x162(x143.toInt) = x122
            val x125 = x69.l_shipdate_46
            val x211 = x163(x143.toInt) = x125
            val x128 = x69.l_commitdate_47
            val x212 = x164(x143.toInt) = x128
            val x131 = x69.l_receiptdate_48
            val x213 = x165(x143.toInt) = x131
            val x134 = x69.l_shipinstruct_49
            val x214 = x166(x143.toInt) = x134
            val x137 = x69.l_shipmode_50
            val x215 = x167(x143.toInt) = x137
            val x140 = x69.l_comment_51
            val x216 = x168(x143.toInt) = x140
            val x169 = new generated.scala.DeliteArrayAnon310125598(x153,x154,x155,x156,x157,x158,x159,x160,x161,x162,x163,x164,x165,x166,x167,x168)
            val x217 = x375_buf = x169
            x217
          }
          def x251elseb(): Unit = {
            val x95 = x69.l_orderkey_36
            val x219 = x68.l_orderkey_36(x143.toInt) = x95
            val x220 = x68.l_partkey_37
            val x98 = x69.l_partkey_37
            val x221 = x68.l_partkey_37(x143.toInt) = x98
            val x222 = x68.l_suppkey_38
            val x101 = x69.l_suppkey_38
            val x223 = x68.l_suppkey_38(x143.toInt) = x101
            val x224 = x68.l_linenumber_39
            val x104 = x69.l_linenumber_39
            val x225 = x68.l_linenumber_39(x143.toInt) = x104
            val x226 = x68.l_quantity_40
            val x107 = x69.l_quantity_40
            val x227 = x68.l_quantity_40(x143.toInt) = x107
            val x228 = x68.l_extendedprice_41
            val x110 = x69.l_extendedprice_41
            val x229 = x68.l_extendedprice_41(x143.toInt) = x110
            val x230 = x68.l_discount_42
            val x113 = x69.l_discount_42
            val x231 = x68.l_discount_42(x143.toInt) = x113
            val x232 = x68.l_tax_43
            val x116 = x69.l_tax_43
            val x233 = x68.l_tax_43(x143.toInt) = x116
            val x234 = x68.l_returnflag_44
            val x119 = x69.l_returnflag_44
            val x235 = x68.l_returnflag_44(x143.toInt) = x119
            val x236 = x68.l_linestatus_45
            val x122 = x69.l_linestatus_45
            val x237 = x68.l_linestatus_45(x143.toInt) = x122
            val x238 = x68.l_shipdate_46
            val x125 = x69.l_shipdate_46
            val x239 = x68.l_shipdate_46(x143.toInt) = x125
            val x240 = x68.l_commitdate_47
            val x128 = x69.l_commitdate_47
            val x241 = x68.l_commitdate_47(x143.toInt) = x128
            val x242 = x68.l_receiptdate_48
            val x131 = x69.l_receiptdate_48
            val x243 = x68.l_receiptdate_48(x143.toInt) = x131
            val x244 = x68.l_shipinstruct_49
            val x134 = x69.l_shipinstruct_49
            val x245 = x68.l_shipinstruct_49(x143.toInt) = x134
            val x246 = x68.l_shipmode_50
            val x137 = x69.l_shipmode_50
            val x247 = x68.l_shipmode_50(x143.toInt) = x137
            val x248 = x68.l_comment_51
            val x140 = x69.l_comment_51
            val x249 = x68.l_comment_51(x143.toInt) = x140
            ()
          }
          if (x147) {
            x251thenb()
          } else {
            x251elseb()
          }
        }
        x375_size = x375_size + 1
      }
      x375_conditionals = x375_conditionals + 1
      x4 = x4 + 1
    } // end fat loop x375
    x2_stream.close();
    var x68: generated.scala.DeliteArrayAnon310125598 = x375_buf
    x70 = x375_conditionals
    val x253 = x68.l_orderkey_36
    val x254 = x253.length
    val x255 = x254 > x70
    val x306 = {
      def x306thenb(): Unit = {
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x256 = new Array[Int](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x257 = new Array[Int](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x258 = new Array[Int](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x259 = new Array[Int](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x260 = new Array[Double](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x261 = new Array[Double](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x262 = new Array[Double](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x263 = new Array[Double](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x264 = new Array[java.lang.String](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x265 = new Array[java.lang.String](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x266 = new Array[Int](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x267 = new Array[Int](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x268 = new Array[Int](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x269 = new Array[java.lang.String](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x270 = new Array[java.lang.String](x70.toInt)
        if (x70 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x271 = new Array[java.lang.String](x70.toInt)
        val x273 = System.arraycopy(x253,0.toInt,x256,0.toInt,x70.toInt)
        val x274 = x68.l_partkey_37
        val x275 = System.arraycopy(x274,0.toInt,x257,0.toInt,x70.toInt)
        val x276 = x68.l_suppkey_38
        val x277 = System.arraycopy(x276,0.toInt,x258,0.toInt,x70.toInt)
        val x278 = x68.l_linenumber_39
        val x279 = System.arraycopy(x278,0.toInt,x259,0.toInt,x70.toInt)
        val x280 = x68.l_quantity_40
        val x281 = System.arraycopy(x280,0.toInt,x260,0.toInt,x70.toInt)
        val x282 = x68.l_extendedprice_41
        val x283 = System.arraycopy(x282,0.toInt,x261,0.toInt,x70.toInt)
        val x284 = x68.l_discount_42
        val x285 = System.arraycopy(x284,0.toInt,x262,0.toInt,x70.toInt)
        val x286 = x68.l_tax_43
        val x287 = System.arraycopy(x286,0.toInt,x263,0.toInt,x70.toInt)
        val x288 = x68.l_returnflag_44
        val x289 = System.arraycopy(x288,0.toInt,x264,0.toInt,x70.toInt)
        val x290 = x68.l_linestatus_45
        val x291 = System.arraycopy(x290,0.toInt,x265,0.toInt,x70.toInt)
        val x292 = x68.l_shipdate_46
        val x293 = System.arraycopy(x292,0.toInt,x266,0.toInt,x70.toInt)
        val x294 = x68.l_commitdate_47
        val x295 = System.arraycopy(x294,0.toInt,x267,0.toInt,x70.toInt)
        val x296 = x68.l_receiptdate_48
        val x297 = System.arraycopy(x296,0.toInt,x268,0.toInt,x70.toInt)
        val x298 = x68.l_shipinstruct_49
        val x299 = System.arraycopy(x298,0.toInt,x269,0.toInt,x70.toInt)
        val x300 = x68.l_shipmode_50
        val x301 = System.arraycopy(x300,0.toInt,x270,0.toInt,x70.toInt)
        val x302 = x68.l_comment_51
        val x303 = System.arraycopy(x302,0.toInt,x271,0.toInt,x70.toInt)
        val x272 = new generated.scala.DeliteArrayAnon310125598(x256,x257,x258,x259,x260,x261,x262,x263,x264,x265,x266,x267,x268,x269,x270,x271)
        val x304 = x68 = x272
        x304
      }
      if (x255) {
        x306thenb()
      }
    }
    val x375 = x68
    val x376 = x375.l_orderkey_36
    val x377 = x376.length
    val x379 = ppl.delite.runtime.profiler.PerformanceTimer.stop("load")
    val x380 = {
      println("preload: Done")}
    val x381 = ppl.delite.runtime.profiler.PerformanceTimer.start("exec")
    val x384 = x375.l_partkey_37
    val x386 = x375.l_suppkey_38
    val x388 = x375.l_linenumber_39
    val x390 = x375.l_quantity_40
    val x392 = x375.l_extendedprice_41
    val x394 = x375.l_discount_42
    val x396 = x375.l_tax_43
    val x398 = x375.l_returnflag_44
    val x400 = x375.l_linestatus_45
    val x402 = x375.l_shipdate_46
    val x404 = x375.l_commitdate_47
    val x406 = x375.l_receiptdate_48
    val x408 = x375.l_shipinstruct_49
    val x410 = x375.l_shipmode_50
    val x412 = x375.l_comment_51
    val x415 = {
      1998 << 9}
    val x416 = {
      9 << 5}
    val x417 = x416 + 2
    val x418 = x415 + x417
    def x686_block = {
      true
    }
    val x686 = x686_block
    var x422: Int = 0
    var x426: Int = x422
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x427 = new Array[Int](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x428 = new Array[Int](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x429 = new Array[Int](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x430 = new Array[Int](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x431 = new Array[Double](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x432 = new Array[Double](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x433 = new Array[Double](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x434 = new Array[Double](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x435 = new Array[java.lang.String](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x436 = new Array[java.lang.String](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x437 = new Array[Int](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x438 = new Array[Int](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x439 = new Array[Int](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x440 = new Array[java.lang.String](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x441 = new Array[java.lang.String](x422.toInt)
    if (x422 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x442 = new Array[java.lang.String](x422.toInt)
    var x444: Array[Int] = x427
    var x445: Array[Int] = x428
    var x446: Array[Int] = x429
    var x447: Array[Int] = x430
    var x448: Array[Double] = x431
    var x449: Array[Double] = x432
    var x450: Array[Double] = x433
    var x451: Array[Double] = x434
    var x452: Array[java.lang.String] = x435
    var x453: Array[java.lang.String] = x436
    var x454: Array[Int] = x437
    var x455: Array[Int] = x438
    var x456: Array[Int] = x439
    var x457: Array[java.lang.String] = x440
    var x458: Array[java.lang.String] = x441
    var x459: Array[java.lang.String] = x442
    val x460 = new generated.scala.DeliteArrayAnon310125598(x444,x445,x446,x447,x448,x449,x450,x451,x452,x453,x454,x455,x456,x457,x458,x459)
    val x461 = new generated.scala.TableAnon310125598(x426,x460)
    var x779_buf: generated.scala.TableAnon310125598 = x461
    var x779_size: Int = 0
    var x779_conditionals: Int = 0
    var x382: Int = 0
    while (x382 < x377) {  // begin fat loop x779
      val x383 = x376(x382.toInt)
      val x385 = x384(x382.toInt)
      val x387 = x386(x382.toInt)
      val x389 = x388(x382.toInt)
      val x391 = x390(x382.toInt)
      val x393 = x392(x382.toInt)
      val x395 = x394(x382.toInt)
      val x397 = x396(x382.toInt)
      val x399 = x398(x382.toInt)
      val x401 = x400(x382.toInt)
      val x403 = x402(x382.toInt)
      val x405 = x404(x382.toInt)
      val x407 = x406(x382.toInt)
      val x409 = x408(x382.toInt)
      val x411 = x410(x382.toInt)
      val x413 = x412(x382.toInt)
      val x414 = new generated.scala.Anon310125598(x383,x385,x387,x389,x391,x393,x395,x397,x399,x401,x403,x405,x407,x409,x411,x413)
      val x419 = {
        x403 <= x418}
      if (x419) {
        val x420 = x779_buf
        val x421 = x414
        if (x686) {
          val x467 = x421.l_orderkey_36
          val x470 = x421.l_partkey_37
          val x473 = x421.l_suppkey_38
          val x476 = x421.l_linenumber_39
          val x479 = x421.l_quantity_40
          val x482 = x421.l_extendedprice_41
          val x485 = x421.l_discount_42
          val x488 = x421.l_tax_43
          val x491 = x421.l_returnflag_44
          val x494 = x421.l_linestatus_45
          val x497 = x421.l_shipdate_46
          val x500 = x421.l_commitdate_47
          val x503 = x421.l_receiptdate_48
          val x506 = x421.l_shipinstruct_49
          val x509 = x421.l_shipmode_50
          val x512 = x421.l_comment_51
          def x684_block = {
            def x682_block = {
              val x515 = x420.size
              val x521 = x515 + 1
              def x680_block = {
                def x645_block = {
                  def x605_block = {
                    val x516 = x420.data
                    val x517 = x516.l_orderkey_36
                    val x518 = x517.length
                    val x519 = x518 - x515
                    val x520 = {
                      x519 < 1}
                    val x603 = {
                      def x603thenb(): Unit = {
                        val x522 = x518 * 2
                        val x523 = {
                          4 max x522}
                        val x552 = x516.l_partkey_37
                        val x554 = x516.l_suppkey_38
                        val x556 = x516.l_linenumber_39
                        val x558 = x516.l_quantity_40
                        val x560 = x516.l_extendedprice_41
                        val x562 = x516.l_discount_42
                        val x564 = x516.l_tax_43
                        val x566 = x516.l_returnflag_44
                        val x568 = x516.l_linestatus_45
                        val x570 = x516.l_shipdate_46
                        val x572 = x516.l_commitdate_47
                        val x574 = x516.l_receiptdate_48
                        val x576 = x516.l_shipinstruct_49
                        val x578 = x516.l_shipmode_50
                        val x580 = x516.l_comment_51
                        def x601_block = {
                          var x524: Int = x523
                          val x532 = while ({
                            val x525 = x524
                            val x526 = {
                              x525 < x521}
                            x526}) {
                            val x528 = x524
                            val x529 = x528 * 2
                            x524 = x529
                            ()
                          }
                          val x533 = x524
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x534 = new Array[Int](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x535 = new Array[Int](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x536 = new Array[Int](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x537 = new Array[Int](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x538 = new Array[Double](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x539 = new Array[Double](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x540 = new Array[Double](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x541 = new Array[Double](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x542 = new Array[java.lang.String](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x543 = new Array[java.lang.String](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x544 = new Array[Int](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x545 = new Array[Int](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x546 = new Array[Int](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x547 = new Array[java.lang.String](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x548 = new Array[java.lang.String](x533.toInt)
                          if (x533 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x549 = new Array[java.lang.String](x533.toInt)
                          val x551 = System.arraycopy(x517,0.toInt,x534,0.toInt,x515.toInt)
                          val x553 = System.arraycopy(x552,0.toInt,x535,0.toInt,x515.toInt)
                          val x555 = System.arraycopy(x554,0.toInt,x536,0.toInt,x515.toInt)
                          val x557 = System.arraycopy(x556,0.toInt,x537,0.toInt,x515.toInt)
                          val x559 = System.arraycopy(x558,0.toInt,x538,0.toInt,x515.toInt)
                          val x561 = System.arraycopy(x560,0.toInt,x539,0.toInt,x515.toInt)
                          val x563 = System.arraycopy(x562,0.toInt,x540,0.toInt,x515.toInt)
                          val x565 = System.arraycopy(x564,0.toInt,x541,0.toInt,x515.toInt)
                          val x567 = System.arraycopy(x566,0.toInt,x542,0.toInt,x515.toInt)
                          val x569 = System.arraycopy(x568,0.toInt,x543,0.toInt,x515.toInt)
                          val x571 = System.arraycopy(x570,0.toInt,x544,0.toInt,x515.toInt)
                          val x573 = System.arraycopy(x572,0.toInt,x545,0.toInt,x515.toInt)
                          val x575 = System.arraycopy(x574,0.toInt,x546,0.toInt,x515.toInt)
                          val x577 = System.arraycopy(x576,0.toInt,x547,0.toInt,x515.toInt)
                          val x579 = System.arraycopy(x578,0.toInt,x548,0.toInt,x515.toInt)
                          val x581 = System.arraycopy(x580,0.toInt,x549,0.toInt,x515.toInt)
                          val x582 = x534// unsafe immutable
                          val x583 = x535// unsafe immutable
                          val x584 = x536// unsafe immutable
                          val x585 = x537// unsafe immutable
                          val x586 = x538// unsafe immutable
                          val x587 = x539// unsafe immutable
                          val x588 = x540// unsafe immutable
                          val x589 = x541// unsafe immutable
                          val x590 = x542// unsafe immutable
                          val x591 = x543// unsafe immutable
                          val x592 = x544// unsafe immutable
                          val x593 = x545// unsafe immutable
                          val x594 = x546// unsafe immutable
                          val x595 = x547// unsafe immutable
                          val x596 = x548// unsafe immutable
                          val x597 = x549// unsafe immutable
                          val x598 = new generated.scala.DeliteArrayAnon310125598(x582,x583,x584,x585,x586,x587,x588,x589,x590,x591,x592,x593,x594,x595,x596,x597)
                          val x599 = x420.data = x598
                          x599
                        }
                        val x601 = x601_block
                        x601
                      }
                      if (x520) {
                        x603thenb()
                      }
                    }
                    x603
                  }
                  val x605 = x605_block
                  val x606 = x420.data
                  val x607 = x420.size
                  val x608 = x607 - x515
                  val x609 = x606.l_orderkey_36
                  val x610 = System.arraycopy(x609,x515.toInt,x420.data.l_orderkey_36,x521.toInt,x608.toInt)
                  val x611 = x606.l_partkey_37
                  val x612 = System.arraycopy(x611,x515.toInt,x420.data.l_partkey_37,x521.toInt,x608.toInt)
                  val x613 = x606.l_suppkey_38
                  val x614 = System.arraycopy(x613,x515.toInt,x420.data.l_suppkey_38,x521.toInt,x608.toInt)
                  val x615 = x606.l_linenumber_39
                  val x616 = System.arraycopy(x615,x515.toInt,x420.data.l_linenumber_39,x521.toInt,x608.toInt)
                  val x617 = x606.l_quantity_40
                  val x618 = System.arraycopy(x617,x515.toInt,x420.data.l_quantity_40,x521.toInt,x608.toInt)
                  val x619 = x606.l_extendedprice_41
                  val x620 = System.arraycopy(x619,x515.toInt,x420.data.l_extendedprice_41,x521.toInt,x608.toInt)
                  val x621 = x606.l_discount_42
                  val x622 = System.arraycopy(x621,x515.toInt,x420.data.l_discount_42,x521.toInt,x608.toInt)
                  val x623 = x606.l_tax_43
                  val x624 = System.arraycopy(x623,x515.toInt,x420.data.l_tax_43,x521.toInt,x608.toInt)
                  val x625 = x606.l_returnflag_44
                  val x626 = System.arraycopy(x625,x515.toInt,x420.data.l_returnflag_44,x521.toInt,x608.toInt)
                  val x627 = x606.l_linestatus_45
                  val x628 = System.arraycopy(x627,x515.toInt,x420.data.l_linestatus_45,x521.toInt,x608.toInt)
                  val x629 = x606.l_shipdate_46
                  val x630 = System.arraycopy(x629,x515.toInt,x420.data.l_shipdate_46,x521.toInt,x608.toInt)
                  val x631 = x606.l_commitdate_47
                  val x632 = System.arraycopy(x631,x515.toInt,x420.data.l_commitdate_47,x521.toInt,x608.toInt)
                  val x633 = x606.l_receiptdate_48
                  val x634 = System.arraycopy(x633,x515.toInt,x420.data.l_receiptdate_48,x521.toInt,x608.toInt)
                  val x635 = x606.l_shipinstruct_49
                  val x636 = System.arraycopy(x635,x515.toInt,x420.data.l_shipinstruct_49,x521.toInt,x608.toInt)
                  val x637 = x606.l_shipmode_50
                  val x638 = System.arraycopy(x637,x515.toInt,x420.data.l_shipmode_50,x521.toInt,x608.toInt)
                  val x639 = x606.l_comment_51
                  val x640 = System.arraycopy(x639,x515.toInt,x420.data.l_comment_51,x521.toInt,x608.toInt)
                  val x641 = x420.size
                  val x642 = x641 + 1
                  val x643 = x420.size = x642
                  x643
                }
                val x645 = x645_block
                val x646 = x420.data
                val x648 = x420.data.l_orderkey_36(x515.toInt) = x467
                val x650 = x420.data.l_partkey_37(x515.toInt) = x470
                val x652 = x420.data.l_suppkey_38(x515.toInt) = x473
                val x654 = x420.data.l_linenumber_39(x515.toInt) = x476
                val x656 = x420.data.l_quantity_40(x515.toInt) = x479
                val x658 = x420.data.l_extendedprice_41(x515.toInt) = x482
                val x660 = x420.data.l_discount_42(x515.toInt) = x485
                val x662 = x420.data.l_tax_43(x515.toInt) = x488
                val x664 = x420.data.l_returnflag_44(x515.toInt) = x491
                val x666 = x420.data.l_linestatus_45(x515.toInt) = x494
                val x668 = x420.data.l_shipdate_46(x515.toInt) = x497
                val x670 = x420.data.l_commitdate_47(x515.toInt) = x500
                val x672 = x420.data.l_receiptdate_48(x515.toInt) = x503
                val x674 = x420.data.l_shipinstruct_49(x515.toInt) = x506
                val x676 = x420.data.l_shipmode_50(x515.toInt) = x509
                val x678 = x420.data.l_comment_51(x515.toInt) = x512
                ()
              }
              val x680 = x680_block
              x680
            }
            val x682 = x682_block
            x682
          }
          val x684 = x684_block
          x779_size = x779_size + 1
        }
        x779_conditionals = x779_conditionals + 1
      }
      x382 = x382 + 1
    } // end fat loop x779
    var x420: generated.scala.TableAnon310125598 = x779_buf
    x422 = x779_conditionals
    val x687 = x420.size = x422
    val x779 = x420
    val x780 = x779.size
    val x782 = x779.data
    val x791 = x782.l_quantity_40
    val x793 = x782.l_extendedprice_41
    val x795 = x782.l_discount_42
    val x797 = x782.l_tax_43
    val x799 = x782.l_returnflag_44
    val x801 = x782.l_linestatus_45
    def x953_block = {
      true
    }
    val x953 = x953_block
    var x819: Int = x780
    var x823: Int = x819
    if (x819 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x824 = new Array[Double](x819.toInt)
    if (x819 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x825 = new Array[Double](x819.toInt)
    if (x819 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x826 = new Array[Double](x819.toInt)
    if (x819 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x827 = new Array[Double](x819.toInt)
    if (x819 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x828 = new Array[java.lang.String](x819.toInt)
    if (x819 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x829 = new Array[java.lang.String](x819.toInt)
    var x831: Array[Double] = x824
    var x832: Array[Double] = x825
    var x833: Array[Double] = x826
    var x834: Array[Double] = x827
    var x835: Array[java.lang.String] = x828
    var x836: Array[java.lang.String] = x829
    val x837 = new generated.scala.DeliteArrayAnon516171423(x831,x832,x833,x834,x835,x836)
    val x838 = new generated.scala.TableAnon516171423(x823,x837)
    val x996_data: generated.scala.TableAnon516171423 = x838
    var x996_size: Int = 0
    var x996_conditionals: Int = 0
    var x781: Int = 0
    while (x781 < x780) {  // begin fat loop x996
      val x792 = x791(x781.toInt)
      val x794 = x793(x781.toInt)
      val x796 = x795(x781.toInt)
      val x798 = x797(x781.toInt)
      val x800 = x799(x781.toInt)
      val x802 = x801(x781.toInt)
      val x816 = new generated.scala.Anon516171423(x792,x794,x796,x798,x800,x802)
      val x818 = x816
      val x817 = x996_data
      val x842 = x817.data
      val x844 = x818.l_quantity_40
      val x845 = x817.data.l_quantity_40(x781.toInt) = x844
      val x847 = x818.l_extendedprice_41
      val x848 = x817.data.l_extendedprice_41(x781.toInt) = x847
      val x850 = x818.l_discount_42
      val x851 = x817.data.l_discount_42(x781.toInt) = x850
      val x853 = x818.l_tax_43
      val x854 = x817.data.l_tax_43(x781.toInt) = x853
      val x856 = x818.l_returnflag_44
      val x857 = x817.data.l_returnflag_44(x781.toInt) = x856
      val x859 = x818.l_linestatus_45
      val x860 = x817.data.l_linestatus_45(x781.toInt) = x859
      x781 = x781 + 1
    } // end fat loop x996
    val x817 = x996_data
    val x996 = x817
    val x998 = x996.size
    val x997 = x996.data
    val x1001 = x997.l_quantity_40
    val x1003 = x997.l_extendedprice_41
    val x1005 = x997.l_discount_42
    val x1007 = x997.l_tax_43
    val x1009 = x997.l_returnflag_44
    val x1011 = x997.l_linestatus_45
    val x1920 = {
      null.asInstanceOf[Null].asInstanceOf[generated.scala.Anon1187970594]}
    var x2138x3113_hash_pos: generated.scala.container.HashMapImpl[generated.scala.Anon1637442313] = new generated.scala.container.HashMapImpl[generated.scala.Anon1637442313](512,128)
    var x1953: Int = 128
    if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1956 = new Array[java.lang.String](x1953.toInt)
    if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1957 = new Array[java.lang.String](x1953.toInt)
    if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1958 = new Array[Double](x1953.toInt)
    if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1959 = new Array[Double](x1953.toInt)
    if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1960 = new Array[Double](x1953.toInt)
    if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1961 = new Array[Double](x1953.toInt)
    if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1962 = new Array[Double](x1953.toInt)
    if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1963 = new Array[Double](x1953.toInt)
    if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1964 = new Array[Double](x1953.toInt)
    if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1965 = new Array[Int](x1953.toInt)
    val x1966 = new generated.scala.DeliteArrayAnon1187970594(x1956,x1957,x1958,x1959,x1960,x1961,x1962,x1963,x1964,x1965)
    var x2138_hash_data: generated.scala.DeliteArrayAnon1187970594 = x1966
    var x2244: Int = 128
    if (x2244 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2247 = new Array[Int](x2244.toInt)
    var x3113_hash_data: Array[Int] = x2247
    var x1906: Int = 0
    while (x1906 < x998) {  // begin fat loop x2138,x3113
      val x1907 = x1001(x1906.toInt)
      val x1908 = x1003(x1906.toInt)
      val x1909 = x1005(x1906.toInt)
      val x1915 = {
        1.0 - x1909}
      val x1916 = {
        x1908 * x1915}
      val x1910 = x1007(x1906.toInt)
      val x1917 = {
        1.0 + x1910}
      val x1918 = {
        x1916 * x1917}
      val x1911 = x1009(x1906.toInt)
      val x1912 = x1011(x1906.toInt)
      val x1919 = new generated.scala.Anon1187970594(x1911,x1912,x1907,x1908,x1916,x1918,x1907,x1908,x1909,1)
      val x1914 = new generated.scala.Anon1637442313(x1911,x1912)
      if (true) {
        // common key Block(Sym(1914)) for x2138x3113
        val x2138x3113_sze: Int = x2138x3113_hash_pos.size
        val x2138x3113_idx: Int = x2138x3113_hash_pos.put(x1914)
        if (x2138x3113_idx == x2138x3113_sze) { // new key
          val x1955: generated.scala.DeliteArrayAnon1187970594 = x2138_hash_data
          val x1952: generated.scala.Anon1187970594 = x1919
          val x2023 = x2138x3113_sze
          val x2024 = x1955.l_returnflag_44
          val x2025 = x2024.length
          val x2026 = x2025 - 1
          val x2027 = x2023 > x2026
          val x2095 = {
            def x2095thenb(): Unit = {
              val x2028 = x2025 < 16
              val x2032 = {
                def x2032thenb(): Int = {
                  16
                }
                def x2032elseb(): Int = {
                  val x2029 = x2025 * 2
                  val x2030 = x2029 < 0
                  val x2031 = {
                    def x2031thenb(): Int = {
                      2147483647
                    }
                    def x2031elseb(): Int = {
                      x2029
                    }
                    if (x2030) {
                      x2031thenb()
                    } else {
                      x2031elseb()
                    }
                  }
                  x2031
                }
                if (x2028) {
                  x2032thenb()
                } else {
                  x2032elseb()
                }
              }
              if (x2032 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2033 = new Array[java.lang.String](x2032.toInt)
              if (x2032 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2034 = new Array[java.lang.String](x2032.toInt)
              if (x2032 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2035 = new Array[Double](x2032.toInt)
              if (x2032 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2036 = new Array[Double](x2032.toInt)
              if (x2032 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2037 = new Array[Double](x2032.toInt)
              if (x2032 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2038 = new Array[Double](x2032.toInt)
              if (x2032 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2039 = new Array[Double](x2032.toInt)
              if (x2032 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2040 = new Array[Double](x2032.toInt)
              if (x2032 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2041 = new Array[Double](x2032.toInt)
              if (x2032 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2042 = new Array[Int](x2032.toInt)
              val x2044 = System.arraycopy(x2024,0.toInt,x2033,0.toInt,x2025.toInt)
              val x2045 = x1955.l_linestatus_45
              val x2046 = System.arraycopy(x2045,0.toInt,x2034,0.toInt,x2025.toInt)
              val x2047 = x1955.sum_qty_138
              val x2048 = System.arraycopy(x2047,0.toInt,x2035,0.toInt,x2025.toInt)
              val x2049 = x1955.sum_base_price_139
              val x2050 = System.arraycopy(x2049,0.toInt,x2036,0.toInt,x2025.toInt)
              val x2051 = x1955.sum_disc_price_140
              val x2052 = System.arraycopy(x2051,0.toInt,x2037,0.toInt,x2025.toInt)
              val x2053 = x1955.sum_charge_141
              val x2054 = System.arraycopy(x2053,0.toInt,x2038,0.toInt,x2025.toInt)
              val x2055 = x1955.avg_qty_142
              val x2056 = System.arraycopy(x2055,0.toInt,x2039,0.toInt,x2025.toInt)
              val x2057 = x1955.avg_price_143
              val x2058 = System.arraycopy(x2057,0.toInt,x2040,0.toInt,x2025.toInt)
              val x2059 = x1955.avg_disc_144
              val x2060 = System.arraycopy(x2059,0.toInt,x2041,0.toInt,x2025.toInt)
              val x2061 = x1955.count_order_145
              val x2062 = System.arraycopy(x2061,0.toInt,x2042,0.toInt,x2025.toInt)
              val x1991 = x1952.l_returnflag_44
              val x2063 = x2033(x2023.toInt) = x1991
              val x1994 = x1952.l_linestatus_45
              val x2064 = x2034(x2023.toInt) = x1994
              val x1997 = x1952.sum_qty_138
              val x2065 = x2035(x2023.toInt) = x1997
              val x2000 = x1952.sum_base_price_139
              val x2066 = x2036(x2023.toInt) = x2000
              val x2003 = x1952.sum_disc_price_140
              val x2067 = x2037(x2023.toInt) = x2003
              val x2006 = x1952.sum_charge_141
              val x2068 = x2038(x2023.toInt) = x2006
              val x2009 = x1952.avg_qty_142
              val x2069 = x2039(x2023.toInt) = x2009
              val x2012 = x1952.avg_price_143
              val x2070 = x2040(x2023.toInt) = x2012
              val x2015 = x1952.avg_disc_144
              val x2071 = x2041(x2023.toInt) = x2015
              val x2018 = x1952.count_order_145
              val x2072 = x2042(x2023.toInt) = x2018
              val x2043 = new generated.scala.DeliteArrayAnon1187970594(x2033,x2034,x2035,x2036,x2037,x2038,x2039,x2040,x2041,x2042)
              val x2073 = x2138_hash_data = x2043
              x2073
            }
            def x2095elseb(): Unit = {
              val x1991 = x1952.l_returnflag_44
              val x2075 = x1955.l_returnflag_44(x2023.toInt) = x1991
              val x2076 = x1955.l_linestatus_45
              val x1994 = x1952.l_linestatus_45
              val x2077 = x1955.l_linestatus_45(x2023.toInt) = x1994
              val x2078 = x1955.sum_qty_138
              val x1997 = x1952.sum_qty_138
              val x2079 = x1955.sum_qty_138(x2023.toInt) = x1997
              val x2080 = x1955.sum_base_price_139
              val x2000 = x1952.sum_base_price_139
              val x2081 = x1955.sum_base_price_139(x2023.toInt) = x2000
              val x2082 = x1955.sum_disc_price_140
              val x2003 = x1952.sum_disc_price_140
              val x2083 = x1955.sum_disc_price_140(x2023.toInt) = x2003
              val x2084 = x1955.sum_charge_141
              val x2006 = x1952.sum_charge_141
              val x2085 = x1955.sum_charge_141(x2023.toInt) = x2006
              val x2086 = x1955.avg_qty_142
              val x2009 = x1952.avg_qty_142
              val x2087 = x1955.avg_qty_142(x2023.toInt) = x2009
              val x2088 = x1955.avg_price_143
              val x2012 = x1952.avg_price_143
              val x2089 = x1955.avg_price_143(x2023.toInt) = x2012
              val x2090 = x1955.avg_disc_144
              val x2015 = x1952.avg_disc_144
              val x2091 = x1955.avg_disc_144(x2023.toInt) = x2015
              val x2092 = x1955.count_order_145
              val x2018 = x1952.count_order_145
              val x2093 = x1955.count_order_145(x2023.toInt) = x2018
              ()
            }
            if (x2027) {
              x2095thenb()
            } else {
              x2095elseb()
            }
          }
          val x2246: Array[Int] = x3113_hash_data
          val x2243: Int = 1
          val x2255 = x2138x3113_sze
          val x2256 = x2246.length
          val x2257 = x2256 - 1
          val x2258 = x2255 > x2257
          val x2271 = {
            def x2271thenb(): Unit = {
              val x2259 = x2256 < 16
              val x2263 = {
                def x2263thenb(): Int = {
                  16
                }
                def x2263elseb(): Int = {
                  val x2260 = x2256 * 2
                  val x2261 = x2260 < 0
                  val x2262 = {
                    def x2262thenb(): Int = {
                      2147483647
                    }
                    def x2262elseb(): Int = {
                      x2260
                    }
                    if (x2261) {
                      x2262thenb()
                    } else {
                      x2262elseb()
                    }
                  }
                  x2262
                }
                if (x2259) {
                  x2263thenb()
                } else {
                  x2263elseb()
                }
              }
              if (x2263 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2264 = new Array[Int](x2263.toInt)
              val x2265 = System.arraycopy(x2246,0.toInt,x2264,0.toInt,x2256.toInt)
              val x2266 = x2264(x2255.toInt) = x2243
              val x2267 = x3113_hash_data = x2264
              x2267
            }
            def x2271elseb(): Unit = {
              val x2269 = x2246(x2255.toInt) = x2243
              x2269
            }
            if (x2258) {
              x2271thenb()
            } else {
              x2271elseb()
            }
          }
        } else { // existing key
          val x1954: Int = x2138x3113_idx
          val x1955: generated.scala.DeliteArrayAnon1187970594 = x2138_hash_data
          val x1968 = x1955.l_returnflag_44
          val x1970 = x1955.l_linestatus_45
          val x1972 = x1955.sum_qty_138
          val x1974 = x1955.sum_base_price_139
          val x1976 = x1955.sum_disc_price_140
          val x1978 = x1955.sum_charge_141
          val x1980 = x1955.avg_qty_142
          val x1982 = x1955.avg_price_143
          val x1984 = x1955.avg_disc_144
          val x1986 = x1955.count_order_145
          val x1969 = x1968(x1954.toInt)
          val x1971 = x1970(x1954.toInt)
          val x1973 = x1972(x1954.toInt)
          val x1975 = x1974(x1954.toInt)
          val x1977 = x1976(x1954.toInt)
          val x1979 = x1978(x1954.toInt)
          val x1981 = x1980(x1954.toInt)
          val x1983 = x1982(x1954.toInt)
          val x1985 = x1984(x1954.toInt)
          val x1987 = x1986(x1954.toInt)
          val x1988 = new generated.scala.Anon1187970594(x1969,x1971,x1973,x1975,x1977,x1979,x1981,x1983,x1985,x1987)
          val x1921: generated.scala.Anon1187970594 = x1988
          val x1922: generated.scala.Anon1187970594 = x1919
          val x1923 = x1921.l_returnflag_44
          val x1925 = x1921.l_linestatus_45
          val x1927 = x1921.sum_qty_138
          val x1928 = x1922.sum_qty_138
          val x1929 = {
            x1927 + x1928}
          val x1930 = x1921.sum_base_price_139
          val x1931 = x1922.sum_base_price_139
          val x1932 = {
            x1930 + x1931}
          val x1933 = x1921.sum_disc_price_140
          val x1934 = x1922.sum_disc_price_140
          val x1935 = {
            x1933 + x1934}
          val x1936 = x1921.sum_charge_141
          val x1937 = x1922.sum_charge_141
          val x1938 = {
            x1936 + x1937}
          val x1939 = x1921.avg_qty_142
          val x1940 = x1922.avg_qty_142
          val x1941 = {
            x1939 + x1940}
          val x1942 = x1921.avg_price_143
          val x1943 = x1922.avg_price_143
          val x1944 = {
            x1942 + x1943}
          val x1945 = x1921.avg_disc_144
          val x1946 = x1922.avg_disc_144
          val x1947 = {
            x1945 + x1946}
          val x1948 = x1921.count_order_145
          val x1949 = x1922.count_order_145
          val x1950 = {
            x1948 + x1949}
          val x1951 = new generated.scala.Anon1187970594(x1923,x1925,x1929,x1932,x1935,x1938,x1941,x1944,x1947,x1950)
          val x1952: generated.scala.Anon1187970594 = x1951
          val x1990 = x1955.l_returnflag_44
          val x1991 = x1952.l_returnflag_44
          val x1992 = x1955.l_returnflag_44(x1954.toInt) = x1991
          val x1993 = x1955.l_linestatus_45
          val x1994 = x1952.l_linestatus_45
          val x1995 = x1955.l_linestatus_45(x1954.toInt) = x1994
          val x1996 = x1955.sum_qty_138
          val x1997 = x1952.sum_qty_138
          val x1998 = x1955.sum_qty_138(x1954.toInt) = x1997
          val x1999 = x1955.sum_base_price_139
          val x2000 = x1952.sum_base_price_139
          val x2001 = x1955.sum_base_price_139(x1954.toInt) = x2000
          val x2002 = x1955.sum_disc_price_140
          val x2003 = x1952.sum_disc_price_140
          val x2004 = x1955.sum_disc_price_140(x1954.toInt) = x2003
          val x2005 = x1955.sum_charge_141
          val x2006 = x1952.sum_charge_141
          val x2007 = x1955.sum_charge_141(x1954.toInt) = x2006
          val x2008 = x1955.avg_qty_142
          val x2009 = x1952.avg_qty_142
          val x2010 = x1955.avg_qty_142(x1954.toInt) = x2009
          val x2011 = x1955.avg_price_143
          val x2012 = x1952.avg_price_143
          val x2013 = x1955.avg_price_143(x1954.toInt) = x2012
          val x2014 = x1955.avg_disc_144
          val x2015 = x1952.avg_disc_144
          val x2016 = x1955.avg_disc_144(x1954.toInt) = x2015
          val x2017 = x1955.count_order_145
          val x2018 = x1952.count_order_145
          val x2019 = x1955.count_order_145(x1954.toInt) = x2018
          val x2245: Int = x2138x3113_idx
          val x2246: Array[Int] = x3113_hash_data
          val x2249 = x2246(x2245.toInt)
          val x2240: Int = x2249
          val x2241: Int = 1
          val x2242 = x2240 + x2241
          val x2243: Int = x2242
          val x2251 = x2246(x2245.toInt) = x2243
        }
      }
      x1906 = x1906 + 1
    } // end fat loop x2138,x3113
    val x2138x3113_sze: Int = x2138x3113_hash_pos.size
    var x1955: generated.scala.DeliteArrayAnon1187970594 = x2138_hash_data
    x1953 = x2138x3113_sze
    val x2097 = x1955.l_returnflag_44
    val x2098 = x2097.length
    val x2099 = x2098 > x1953
    val x2132 = {
      def x2132thenb(): Unit = {
        if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2100 = new Array[java.lang.String](x1953.toInt)
        if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2101 = new Array[java.lang.String](x1953.toInt)
        if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2102 = new Array[Double](x1953.toInt)
        if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2103 = new Array[Double](x1953.toInt)
        if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2104 = new Array[Double](x1953.toInt)
        if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2105 = new Array[Double](x1953.toInt)
        if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2106 = new Array[Double](x1953.toInt)
        if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2107 = new Array[Double](x1953.toInt)
        if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2108 = new Array[Double](x1953.toInt)
        if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2109 = new Array[Int](x1953.toInt)
        val x2111 = System.arraycopy(x2097,0.toInt,x2100,0.toInt,x1953.toInt)
        val x2112 = x1955.l_linestatus_45
        val x2113 = System.arraycopy(x2112,0.toInt,x2101,0.toInt,x1953.toInt)
        val x2114 = x1955.sum_qty_138
        val x2115 = System.arraycopy(x2114,0.toInt,x2102,0.toInt,x1953.toInt)
        val x2116 = x1955.sum_base_price_139
        val x2117 = System.arraycopy(x2116,0.toInt,x2103,0.toInt,x1953.toInt)
        val x2118 = x1955.sum_disc_price_140
        val x2119 = System.arraycopy(x2118,0.toInt,x2104,0.toInt,x1953.toInt)
        val x2120 = x1955.sum_charge_141
        val x2121 = System.arraycopy(x2120,0.toInt,x2105,0.toInt,x1953.toInt)
        val x2122 = x1955.avg_qty_142
        val x2123 = System.arraycopy(x2122,0.toInt,x2106,0.toInt,x1953.toInt)
        val x2124 = x1955.avg_price_143
        val x2125 = System.arraycopy(x2124,0.toInt,x2107,0.toInt,x1953.toInt)
        val x2126 = x1955.avg_disc_144
        val x2127 = System.arraycopy(x2126,0.toInt,x2108,0.toInt,x1953.toInt)
        val x2128 = x1955.count_order_145
        val x2129 = System.arraycopy(x2128,0.toInt,x2109,0.toInt,x1953.toInt)
        val x2110 = new generated.scala.DeliteArrayAnon1187970594(x2100,x2101,x2102,x2103,x2104,x2105,x2106,x2107,x2108,x2109)
        val x2130 = x1955 = x2110
        x2130
      }
      if (x2099) {
        x2132thenb()
      }
    }
    val x2138: generated.scala.DeliteArrayAnon1187970594 = x1955
    var x2246: Array[Int] = x3113_hash_data
    x2244 = x2138x3113_sze
    val x2273 = x2246.length
    val x2274 = x2273 > x2244
    val x2279 = {
      def x2279thenb(): Unit = {
        if (x2244 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2275 = new Array[Int](x2244.toInt)
        val x2276 = System.arraycopy(x2246,0.toInt,x2275,0.toInt,x2244.toInt)
        val x2277 = x2246 = x2275
        x2277
      }
      if (x2274) {
        x2279thenb()
      }
    }
    val x3113: Array[Int] = x2246
    val x2139 = x2138.l_returnflag_44
    val x2140 = x2139.length
    val x2291 = x2138.l_linestatus_45
    val x2293 = x2138.sum_qty_138
    val x2295 = x2138.sum_base_price_139
    val x2297 = x2138.sum_disc_price_140
    val x2299 = x2138.sum_charge_141
    val x2307 = x2138.count_order_145
    val x2301 = x2138.avg_qty_142
    val x2303 = x2138.avg_price_143
    val x2305 = x2138.avg_disc_144
    def x2503_block = {
      true
    }
    val x2503 = x2503_block
    var x2317: Int = x2140
    var x2321: Int = x2317
    if (x2317 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2322 = new Array[java.lang.String](x2317.toInt)
    if (x2317 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2323 = new Array[java.lang.String](x2317.toInt)
    if (x2317 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2324 = new Array[Double](x2317.toInt)
    if (x2317 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2325 = new Array[Double](x2317.toInt)
    if (x2317 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2326 = new Array[Double](x2317.toInt)
    if (x2317 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2327 = new Array[Double](x2317.toInt)
    if (x2317 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2328 = new Array[Double](x2317.toInt)
    if (x2317 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2329 = new Array[Double](x2317.toInt)
    if (x2317 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2330 = new Array[Double](x2317.toInt)
    if (x2317 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2331 = new Array[Int](x2317.toInt)
    var x2333: Array[java.lang.String] = x2322
    var x2334: Array[java.lang.String] = x2323
    var x2335: Array[Double] = x2324
    var x2336: Array[Double] = x2325
    var x2337: Array[Double] = x2326
    var x2338: Array[Double] = x2327
    var x2339: Array[Double] = x2328
    var x2340: Array[Double] = x2329
    var x2341: Array[Double] = x2330
    var x2342: Array[Int] = x2331
    val x2343 = new generated.scala.DeliteArrayAnon1187970594(x2333,x2334,x2335,x2336,x2337,x2338,x2339,x2340,x2341,x2342)
    val x2344 = new generated.scala.TableAnon1187970594(x2321,x2343)
    val x3119_data: generated.scala.TableAnon1187970594 = x2344
    var x3119_size: Int = 0
    var x3119_conditionals: Int = 0
    var x2289: Int = 0
    while (x2289 < x2140) {  // begin fat loop x3119
      val x2290 = x2139(x2289.toInt)
      val x2292 = x2291(x2289.toInt)
      val x2294 = x2293(x2289.toInt)
      val x2296 = x2295(x2289.toInt)
      val x2298 = x2297(x2289.toInt)
      val x2300 = x2299(x2289.toInt)
      val x2308 = x2307(x2289.toInt)
      val x2302 = x2301(x2289.toInt)
      val x3114 = x3113(x2289.toInt)
      val x3115 = {
        implicitly[Fractional[Double]].div(x2302,x3114)}
      val x2304 = x2303(x2289.toInt)
      val x3116 = {
        implicitly[Fractional[Double]].div(x2304,x3114)}
      val x2306 = x2305(x2289.toInt)
      val x3117 = {
        implicitly[Fractional[Double]].div(x2306,x3114)}
      val x3118 = new generated.scala.Anon1187970594(x2290,x2292,x2294,x2296,x2298,x2300,x3115,x3116,x3117,x2308)
      val x2316 = x3118
      val x2315 = x3119_data
      val x2348 = x2315.data
      val x2350 = x2316.l_returnflag_44
      val x2351 = x2315.data.l_returnflag_44(x2289.toInt) = x2350
      val x2353 = x2316.l_linestatus_45
      val x2354 = x2315.data.l_linestatus_45(x2289.toInt) = x2353
      val x2356 = x2316.sum_qty_138
      val x2357 = x2315.data.sum_qty_138(x2289.toInt) = x2356
      val x2359 = x2316.sum_base_price_139
      val x2360 = x2315.data.sum_base_price_139(x2289.toInt) = x2359
      val x2362 = x2316.sum_disc_price_140
      val x2363 = x2315.data.sum_disc_price_140(x2289.toInt) = x2362
      val x2365 = x2316.sum_charge_141
      val x2366 = x2315.data.sum_charge_141(x2289.toInt) = x2365
      val x2368 = x2316.avg_qty_142
      val x2369 = x2315.data.avg_qty_142(x2289.toInt) = x2368
      val x2371 = x2316.avg_price_143
      val x2372 = x2315.data.avg_price_143(x2289.toInt) = x2371
      val x2374 = x2316.avg_disc_144
      val x2375 = x2315.data.avg_disc_144(x2289.toInt) = x2374
      val x2377 = x2316.count_order_145
      val x2378 = x2315.data.count_order_145(x2289.toInt) = x2377
      x2289 = x2289 + 1
    } // end fat loop x3119
    val x2315 = x3119_data
    val x3119 = x2315
    val x3120 = x3119.size
    val x3121 = x3119.data
    val x3122 = x3121.l_returnflag_44
    val x3124 = x3121.l_linestatus_45
    val x3126 = x3121.sum_qty_138
    val x3128 = x3121.sum_base_price_139
    val x3130 = x3121.sum_disc_price_140
    val x3132 = x3121.sum_charge_141
    val x3134 = x3121.avg_qty_142
    val x3136 = x3121.avg_price_143
    val x3138 = x3121.avg_disc_144
    val x3140 = x3121.count_order_145
    def x2779_block = {
      true
    }
    val x2779 = x2779_block
    var x2593: Int = x3120
    var x2597: Int = x2593
    if (x2593 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2598 = new Array[java.lang.String](x2593.toInt)
    if (x2593 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2599 = new Array[java.lang.String](x2593.toInt)
    if (x2593 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2600 = new Array[Double](x2593.toInt)
    if (x2593 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2601 = new Array[Double](x2593.toInt)
    if (x2593 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2602 = new Array[Double](x2593.toInt)
    if (x2593 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2603 = new Array[Double](x2593.toInt)
    if (x2593 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2604 = new Array[Double](x2593.toInt)
    if (x2593 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2605 = new Array[Double](x2593.toInt)
    if (x2593 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2606 = new Array[Double](x2593.toInt)
    if (x2593 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2607 = new Array[Long](x2593.toInt)
    var x2609: Array[java.lang.String] = x2598
    var x2610: Array[java.lang.String] = x2599
    var x2611: Array[Double] = x2600
    var x2612: Array[Double] = x2601
    var x2613: Array[Double] = x2602
    var x2614: Array[Double] = x2603
    var x2615: Array[Double] = x2604
    var x2616: Array[Double] = x2605
    var x2617: Array[Double] = x2606
    var x2618: Array[Long] = x2607
    val x2619 = new generated.scala.DeliteArrayAnon1702267215(x2609,x2610,x2611,x2612,x2613,x2614,x2615,x2616,x2617,x2618)
    val x2620 = new generated.scala.TableAnon1702267215(x2597,x2619)
    val x3143_data: generated.scala.TableAnon1702267215 = x2620
    var x3143_size: Int = 0
    var x3143_conditionals: Int = 0
    var x2568: Int = 0
    while (x2568 < x3120) {  // begin fat loop x3143
      val x3123 = x3122(x2568.toInt)
      val x3125 = x3124(x2568.toInt)
      val x3127 = x3126(x2568.toInt)
      val x3129 = x3128(x2568.toInt)
      val x3131 = x3130(x2568.toInt)
      val x3133 = x3132(x2568.toInt)
      val x3135 = x3134(x2568.toInt)
      val x3137 = x3136(x2568.toInt)
      val x3139 = x3138(x2568.toInt)
      val x3141 = x3140(x2568.toInt)
      val x3142 = new generated.scala.Anon1702267215(x3123,x3125,x3127,x3129,x3131,x3133,x3135,x3137,x3139,x3141)
      val x2592 = x3142
      val x2591 = x3143_data
      val x2624 = x2591.data
      val x2626 = x2592.l_returnflag_44
      val x2627 = x2591.data.l_returnflag_44(x2568.toInt) = x2626
      val x2629 = x2592.l_linestatus_45
      val x2630 = x2591.data.l_linestatus_45(x2568.toInt) = x2629
      val x2632 = x2592.sum_qty_138
      val x2633 = x2591.data.sum_qty_138(x2568.toInt) = x2632
      val x2635 = x2592.sum_base_price_139
      val x2636 = x2591.data.sum_base_price_139(x2568.toInt) = x2635
      val x2638 = x2592.sum_disc_price_140
      val x2639 = x2591.data.sum_disc_price_140(x2568.toInt) = x2638
      val x2641 = x2592.sum_charge_141
      val x2642 = x2591.data.sum_charge_141(x2568.toInt) = x2641
      val x2644 = x2592.avg_qty_142
      val x2645 = x2591.data.avg_qty_142(x2568.toInt) = x2644
      val x2647 = x2592.avg_price_143
      val x2648 = x2591.data.avg_price_143(x2568.toInt) = x2647
      val x2650 = x2592.avg_disc_144
      val x2651 = x2591.data.avg_disc_144(x2568.toInt) = x2650
      val x2653 = x2592.count_order_145
      val x2654 = x2591.data.count_order_145(x2568.toInt) = x2653
      x2568 = x2568 + 1
    } // end fat loop x3143
    val x2591 = x3143_data
    val x3143 = x2591
    val x3144 = x3143.size
    val x3145 = x3143.data
    val x3146 = x3145.l_returnflag_44
    val x3154 = x3145.l_linestatus_45
    val x3162 = {
      val len = x3144.toInt
      val comp = new generated.scala.container.IntComparator {
        def compare(o1: Int, o2: Int): Int = {
          val x2844 = o1
          val x2845 = o2
          val x3147 = x3146(x2844.toInt)
          val x3148 = x3146(x2845.toInt)
          val x3149 = {
            x3147 < x3148}
          val x3152 = {
            def x3152thenb(): Int = {
              -1
            }
            def x3152elseb(): Int = {
              val x3150 = {
                x3147 > x3148}
              val x3151 = {
                def x3151thenb(): Int = {
                  1
                }
                def x3151elseb(): Int = {
                  0
                }
                if (x3150) {
                  x3151thenb()
                } else {
                  x3151elseb()
                }
              }
              x3151
            }
            if (x3149) {
              x3152thenb()
            } else {
              x3152elseb()
            }
          }
          val x3153 = x3152 == 0
          val x3161 = {
            def x3161thenb(): Int = {
              val x3155 = x3154(x2844.toInt)
              val x3156 = x3154(x2845.toInt)
              val x3157 = {
                x3155 < x3156}
              val x3160 = {
                def x3160thenb(): Int = {
                  -1
                }
                def x3160elseb(): Int = {
                  val x3158 = {
                    x3155 > x3156}
                  val x3159 = {
                    def x3159thenb(): Int = {
                      1
                    }
                    def x3159elseb(): Int = {
                      0
                    }
                    if (x3158) {
                      x3159thenb()
                    } else {
                      x3159elseb()
                    }
                  }
                  x3159
                }
                if (x3157) {
                  x3160thenb()
                } else {
                  x3160elseb()
                }
              }
              x3160
            }
            def x3161elseb(): Int = {
              x3152
            }
            if (x3153) {
              x3161thenb()
            } else {
              x3161elseb()
            }
          }
          x3161.toInt
      } }
      val d = new Array[Int](len)
      var i = 0; while(i < len) { d(i) = i; i += 1 }
      generated.scala.container.SortingImpl.sort(d,comp)
      d
    }
    val x3166 = x3145.sum_qty_138
    val x3168 = x3145.sum_base_price_139
    val x3170 = x3145.sum_disc_price_140
    val x3172 = x3145.sum_charge_141
    val x3174 = x3145.avg_qty_142
    val x3176 = x3145.avg_price_143
    val x3178 = x3145.avg_disc_144
    val x3180 = x3145.count_order_145
    var x2905: Int = x3144
    if (x2905 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2909 = new Array[java.lang.String](x2905.toInt)
    if (x2905 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2910 = new Array[java.lang.String](x2905.toInt)
    if (x2905 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2911 = new Array[Double](x2905.toInt)
    if (x2905 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2912 = new Array[Double](x2905.toInt)
    if (x2905 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2913 = new Array[Double](x2905.toInt)
    if (x2905 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2914 = new Array[Double](x2905.toInt)
    if (x2905 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2915 = new Array[Double](x2905.toInt)
    if (x2905 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2916 = new Array[Double](x2905.toInt)
    if (x2905 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2917 = new Array[Double](x2905.toInt)
    if (x2905 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2918 = new Array[Long](x2905.toInt)
    val x2919 = new generated.scala.DeliteArrayAnon1702267215(x2909,x2910,x2911,x2912,x2913,x2914,x2915,x2916,x2917,x2918)
    val x3183_data: generated.scala.DeliteArrayAnon1702267215 = x2919
    var x3183_size: Int = 0
    var x3183_conditionals: Int = 0
    var x2890: Int = 0
    while (x2890 < x3144) {  // begin fat loop x3183
      val x3163 = x3162(x2890.toInt)
      val x3164 = x3146(x3163.toInt)
      val x3165 = x3154(x3163.toInt)
      val x3167 = x3166(x3163.toInt)
      val x3169 = x3168(x3163.toInt)
      val x3171 = x3170(x3163.toInt)
      val x3173 = x3172(x3163.toInt)
      val x3175 = x3174(x3163.toInt)
      val x3177 = x3176(x3163.toInt)
      val x3179 = x3178(x3163.toInt)
      val x3181 = x3180(x3163.toInt)
      val x3182 = new generated.scala.Anon1702267215(x3164,x3165,x3167,x3169,x3171,x3173,x3175,x3177,x3179,x3181)
      val x2904 = x3182
      val x2903 = x3183_data
      val x2923 = x2903.l_returnflag_44
      val x2924 = x2904.l_returnflag_44
      val x2925 = x2903.l_returnflag_44(x2890.toInt) = x2924
      val x2926 = x2903.l_linestatus_45
      val x2927 = x2904.l_linestatus_45
      val x2928 = x2903.l_linestatus_45(x2890.toInt) = x2927
      val x2929 = x2903.sum_qty_138
      val x2930 = x2904.sum_qty_138
      val x2931 = x2903.sum_qty_138(x2890.toInt) = x2930
      val x2932 = x2903.sum_base_price_139
      val x2933 = x2904.sum_base_price_139
      val x2934 = x2903.sum_base_price_139(x2890.toInt) = x2933
      val x2935 = x2903.sum_disc_price_140
      val x2936 = x2904.sum_disc_price_140
      val x2937 = x2903.sum_disc_price_140(x2890.toInt) = x2936
      val x2938 = x2903.sum_charge_141
      val x2939 = x2904.sum_charge_141
      val x2940 = x2903.sum_charge_141(x2890.toInt) = x2939
      val x2941 = x2903.avg_qty_142
      val x2942 = x2904.avg_qty_142
      val x2943 = x2903.avg_qty_142(x2890.toInt) = x2942
      val x2944 = x2903.avg_price_143
      val x2945 = x2904.avg_price_143
      val x2946 = x2903.avg_price_143(x2890.toInt) = x2945
      val x2947 = x2903.avg_disc_144
      val x2948 = x2904.avg_disc_144
      val x2949 = x2903.avg_disc_144(x2890.toInt) = x2948
      val x2950 = x2903.count_order_145
      val x2951 = x2904.count_order_145
      val x2952 = x2903.count_order_145(x2890.toInt) = x2951
      x2890 = x2890 + 1
    } // end fat loop x3183
    val x2903 = x3183_data
    val x3183 = x2903
    val x3184 = new generated.scala.TableAnon1702267215(x3144,x3183)
    val x3185 = ppl.delite.runtime.profiler.PerformanceTimer.stop("exec")
    val x3186 = {
      TablePrinter.printAsTable(x3184, 20)}
    ()
  }
}
/*****************************************
End of Generated Code
*******************************************/

/*****************************************
Emitting Generated Code
*******************************************/
package generated.scala
class  extends ((Array[java.lang.String])=>(Unit)) {
  def apply(x0:Array[java.lang.String]): Unit = {
    val x1 = generated.scala.io.DeliteFileInputStream(Seq("/home/greg/Research/data/SF1/lineitem.tbl"), None, None,0L)
    val x2 = x1.size
    var x69: Int = 0
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x73 = new Array[Int](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x74 = new Array[Int](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x75 = new Array[Int](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x76 = new Array[Int](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x77 = new Array[Double](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x78 = new Array[Double](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x79 = new Array[Double](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x80 = new Array[Double](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x81 = new Array[java.lang.String](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x82 = new Array[java.lang.String](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x83 = new Array[Int](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x84 = new Array[Int](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x85 = new Array[Int](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x86 = new Array[java.lang.String](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x87 = new Array[java.lang.String](x69.toInt)
    if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x88 = new Array[java.lang.String](x69.toInt)
    val x89 = new generated.scala.DeliteArrayAnon310125598(x73,x74,x75,x76,x77,x78,x79,x80,x81,x82,x83,x84,x85,x86,x87,x88)
    var x374_buf: generated.scala.DeliteArrayAnon310125598 = x89
    var x374_size: Int = 0
    var x374_conditionals: Int = 0
    var x3: Int = 0
    val x1_stream: generated.scala.io.DeliteFileInputStream = x1.openCopyAtNewLine(0)
    val x1_offset: Long = x1.streamOffset
    while (x1_stream.position < x1_offset + x2 ) {
      val x4 = x1_stream.readLine()
      val x5 = x4.split("\\|", -1)
      val x6 = x5(0.toInt)
      val x7 = {
        x6.toInt}
      val x8 = x5(1.toInt)
      val x9 = {
        x8.toInt}
      val x10 = x5(2.toInt)
      val x11 = {
        x10.toInt}
      val x12 = x5(3.toInt)
      val x13 = {
        x12.toInt}
      val x14 = x5(4.toInt)
      val x15 = {
        x14.toDouble}
      val x16 = x5(5.toInt)
      val x17 = {
        x16.toDouble}
      val x18 = x5(6.toInt)
      val x19 = {
        x18.toDouble}
      val x20 = x5(7.toInt)
      val x21 = {
        x20.toDouble}
      val x22 = x5(8.toInt)
      val x23 = x5(9.toInt)
      val x24 = x5(10.toInt)
      val x25 = x24.split("-", 0)
      val x26 = x25(0.toInt)
      val x27 = {
        x26.toInt}
      val x32 = {
        x27 << 9}
      val x30 = x25(2.toInt)
      val x31 = {
        x30.toInt}
      val x28 = x25(1.toInt)
      val x29 = {
        x28.toInt}
      val x33 = {
        x29 << 5}
      val x34 = x33 + x31
      val x35 = x32 + x34
      def x36_block = {
        x35
      }
      val x36 = x36_block
      val x37 = x5(11.toInt)
      val x38 = x37.split("-", 0)
      val x39 = x38(0.toInt)
      val x40 = {
        x39.toInt}
      val x45 = {
        x40 << 9}
      val x43 = x38(2.toInt)
      val x44 = {
        x43.toInt}
      val x41 = x38(1.toInt)
      val x42 = {
        x41.toInt}
      val x46 = {
        x42 << 5}
      val x47 = x46 + x44
      val x48 = x45 + x47
      def x49_block = {
        x48
      }
      val x49 = x49_block
      val x50 = x5(12.toInt)
      val x51 = x50.split("-", 0)
      val x52 = x51(0.toInt)
      val x53 = {
        x52.toInt}
      val x58 = {
        x53 << 9}
      val x56 = x51(2.toInt)
      val x57 = {
        x56.toInt}
      val x54 = x51(1.toInt)
      val x55 = {
        x54.toInt}
      val x59 = {
        x55 << 5}
      val x60 = x59 + x57
      val x61 = x58 + x60
      def x62_block = {
        x61
      }
      val x62 = x62_block
      val x63 = x5(13.toInt)
      val x64 = x5(14.toInt)
      val x65 = x5(15.toInt)
      val x66 = new generated.scala.Anon310125598(x7,x9,x11,x13,x15,x17,x19,x21,x22,x23,x36,x49,x62,x63,x64,x65)
      val x67 = x374_buf
      val x68 = x66
      if (true) {
        val x142 = x374_size
        val x143 = x67.l_orderkey_36
        val x144 = x143.length
        val x145 = x144 - 1
        val x146 = x142 > x145
        val x250 = {
          def x250thenb(): Unit = {
            val x147 = x144 < 16
            val x151 = {
              def x151thenb(): Int = {
                16
              }
              def x151elseb(): Int = {
                val x148 = x144 * 2
                val x149 = x148 < 0
                val x150 = {
                  def x150thenb(): Int = {
                    2147483647
                  }
                  def x150elseb(): Int = {
                    x148
                  }
                  if (x149) {
                    x150thenb()
                  } else {
                    x150elseb()
                  }
                }
                x150
              }
              if (x147) {
                x151thenb()
              } else {
                x151elseb()
              }
            }
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x152 = new Array[Int](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x153 = new Array[Int](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x154 = new Array[Int](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x155 = new Array[Int](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x156 = new Array[Double](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x157 = new Array[Double](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x158 = new Array[Double](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x159 = new Array[Double](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x160 = new Array[java.lang.String](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x161 = new Array[java.lang.String](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x162 = new Array[Int](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x163 = new Array[Int](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x164 = new Array[Int](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x165 = new Array[java.lang.String](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x166 = new Array[java.lang.String](x151.toInt)
            if (x151 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x167 = new Array[java.lang.String](x151.toInt)
            val x169 = System.arraycopy(x143,0.toInt,x152,0.toInt,x144.toInt)
            val x170 = x67.l_partkey_37
            val x171 = System.arraycopy(x170,0.toInt,x153,0.toInt,x144.toInt)
            val x172 = x67.l_suppkey_38
            val x173 = System.arraycopy(x172,0.toInt,x154,0.toInt,x144.toInt)
            val x174 = x67.l_linenumber_39
            val x175 = System.arraycopy(x174,0.toInt,x155,0.toInt,x144.toInt)
            val x176 = x67.l_quantity_40
            val x177 = System.arraycopy(x176,0.toInt,x156,0.toInt,x144.toInt)
            val x178 = x67.l_extendedprice_41
            val x179 = System.arraycopy(x178,0.toInt,x157,0.toInt,x144.toInt)
            val x180 = x67.l_discount_42
            val x181 = System.arraycopy(x180,0.toInt,x158,0.toInt,x144.toInt)
            val x182 = x67.l_tax_43
            val x183 = System.arraycopy(x182,0.toInt,x159,0.toInt,x144.toInt)
            val x184 = x67.l_returnflag_44
            val x185 = System.arraycopy(x184,0.toInt,x160,0.toInt,x144.toInt)
            val x186 = x67.l_linestatus_45
            val x187 = System.arraycopy(x186,0.toInt,x161,0.toInt,x144.toInt)
            val x188 = x67.l_shipdate_46
            val x189 = System.arraycopy(x188,0.toInt,x162,0.toInt,x144.toInt)
            val x190 = x67.l_commitdate_47
            val x191 = System.arraycopy(x190,0.toInt,x163,0.toInt,x144.toInt)
            val x192 = x67.l_receiptdate_48
            val x193 = System.arraycopy(x192,0.toInt,x164,0.toInt,x144.toInt)
            val x194 = x67.l_shipinstruct_49
            val x195 = System.arraycopy(x194,0.toInt,x165,0.toInt,x144.toInt)
            val x196 = x67.l_shipmode_50
            val x197 = System.arraycopy(x196,0.toInt,x166,0.toInt,x144.toInt)
            val x198 = x67.l_comment_51
            val x199 = System.arraycopy(x198,0.toInt,x167,0.toInt,x144.toInt)
            val x94 = x68.l_orderkey_36
            val x200 = x152(x142.toInt) = x94
            val x97 = x68.l_partkey_37
            val x201 = x153(x142.toInt) = x97
            val x100 = x68.l_suppkey_38
            val x202 = x154(x142.toInt) = x100
            val x103 = x68.l_linenumber_39
            val x203 = x155(x142.toInt) = x103
            val x106 = x68.l_quantity_40
            val x204 = x156(x142.toInt) = x106
            val x109 = x68.l_extendedprice_41
            val x205 = x157(x142.toInt) = x109
            val x112 = x68.l_discount_42
            val x206 = x158(x142.toInt) = x112
            val x115 = x68.l_tax_43
            val x207 = x159(x142.toInt) = x115
            val x118 = x68.l_returnflag_44
            val x208 = x160(x142.toInt) = x118
            val x121 = x68.l_linestatus_45
            val x209 = x161(x142.toInt) = x121
            val x124 = x68.l_shipdate_46
            val x210 = x162(x142.toInt) = x124
            val x127 = x68.l_commitdate_47
            val x211 = x163(x142.toInt) = x127
            val x130 = x68.l_receiptdate_48
            val x212 = x164(x142.toInt) = x130
            val x133 = x68.l_shipinstruct_49
            val x213 = x165(x142.toInt) = x133
            val x136 = x68.l_shipmode_50
            val x214 = x166(x142.toInt) = x136
            val x139 = x68.l_comment_51
            val x215 = x167(x142.toInt) = x139
            val x168 = new generated.scala.DeliteArrayAnon310125598(x152,x153,x154,x155,x156,x157,x158,x159,x160,x161,x162,x163,x164,x165,x166,x167)
            val x216 = x374_buf = x168
            x216
          }
          def x250elseb(): Unit = {
            val x94 = x68.l_orderkey_36
            val x218 = x67.l_orderkey_36(x142.toInt) = x94
            val x219 = x67.l_partkey_37
            val x97 = x68.l_partkey_37
            val x220 = x67.l_partkey_37(x142.toInt) = x97
            val x221 = x67.l_suppkey_38
            val x100 = x68.l_suppkey_38
            val x222 = x67.l_suppkey_38(x142.toInt) = x100
            val x223 = x67.l_linenumber_39
            val x103 = x68.l_linenumber_39
            val x224 = x67.l_linenumber_39(x142.toInt) = x103
            val x225 = x67.l_quantity_40
            val x106 = x68.l_quantity_40
            val x226 = x67.l_quantity_40(x142.toInt) = x106
            val x227 = x67.l_extendedprice_41
            val x109 = x68.l_extendedprice_41
            val x228 = x67.l_extendedprice_41(x142.toInt) = x109
            val x229 = x67.l_discount_42
            val x112 = x68.l_discount_42
            val x230 = x67.l_discount_42(x142.toInt) = x112
            val x231 = x67.l_tax_43
            val x115 = x68.l_tax_43
            val x232 = x67.l_tax_43(x142.toInt) = x115
            val x233 = x67.l_returnflag_44
            val x118 = x68.l_returnflag_44
            val x234 = x67.l_returnflag_44(x142.toInt) = x118
            val x235 = x67.l_linestatus_45
            val x121 = x68.l_linestatus_45
            val x236 = x67.l_linestatus_45(x142.toInt) = x121
            val x237 = x67.l_shipdate_46
            val x124 = x68.l_shipdate_46
            val x238 = x67.l_shipdate_46(x142.toInt) = x124
            val x239 = x67.l_commitdate_47
            val x127 = x68.l_commitdate_47
            val x240 = x67.l_commitdate_47(x142.toInt) = x127
            val x241 = x67.l_receiptdate_48
            val x130 = x68.l_receiptdate_48
            val x242 = x67.l_receiptdate_48(x142.toInt) = x130
            val x243 = x67.l_shipinstruct_49
            val x133 = x68.l_shipinstruct_49
            val x244 = x67.l_shipinstruct_49(x142.toInt) = x133
            val x245 = x67.l_shipmode_50
            val x136 = x68.l_shipmode_50
            val x246 = x67.l_shipmode_50(x142.toInt) = x136
            val x247 = x67.l_comment_51
            val x139 = x68.l_comment_51
            val x248 = x67.l_comment_51(x142.toInt) = x139
            ()
          }
          if (x146) {
            x250thenb()
          } else {
            x250elseb()
          }
        }
        x374_size = x374_size + 1
      }
      x374_conditionals = x374_conditionals + 1
      x3 = x3 + 1
    } // end fat loop x374
    x1_stream.close();
    var x67: generated.scala.DeliteArrayAnon310125598 = x374_buf
    x69 = x374_conditionals
    val x252 = x67.l_orderkey_36
    val x253 = x252.length
    val x254 = x253 > x69
    val x305 = {
      def x305thenb(): Unit = {
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x255 = new Array[Int](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x256 = new Array[Int](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x257 = new Array[Int](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x258 = new Array[Int](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x259 = new Array[Double](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x260 = new Array[Double](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x261 = new Array[Double](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x262 = new Array[Double](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x263 = new Array[java.lang.String](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x264 = new Array[java.lang.String](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x265 = new Array[Int](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x266 = new Array[Int](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x267 = new Array[Int](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x268 = new Array[java.lang.String](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x269 = new Array[java.lang.String](x69.toInt)
        if (x69 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x270 = new Array[java.lang.String](x69.toInt)
        val x272 = System.arraycopy(x252,0.toInt,x255,0.toInt,x69.toInt)
        val x273 = x67.l_partkey_37
        val x274 = System.arraycopy(x273,0.toInt,x256,0.toInt,x69.toInt)
        val x275 = x67.l_suppkey_38
        val x276 = System.arraycopy(x275,0.toInt,x257,0.toInt,x69.toInt)
        val x277 = x67.l_linenumber_39
        val x278 = System.arraycopy(x277,0.toInt,x258,0.toInt,x69.toInt)
        val x279 = x67.l_quantity_40
        val x280 = System.arraycopy(x279,0.toInt,x259,0.toInt,x69.toInt)
        val x281 = x67.l_extendedprice_41
        val x282 = System.arraycopy(x281,0.toInt,x260,0.toInt,x69.toInt)
        val x283 = x67.l_discount_42
        val x284 = System.arraycopy(x283,0.toInt,x261,0.toInt,x69.toInt)
        val x285 = x67.l_tax_43
        val x286 = System.arraycopy(x285,0.toInt,x262,0.toInt,x69.toInt)
        val x287 = x67.l_returnflag_44
        val x288 = System.arraycopy(x287,0.toInt,x263,0.toInt,x69.toInt)
        val x289 = x67.l_linestatus_45
        val x290 = System.arraycopy(x289,0.toInt,x264,0.toInt,x69.toInt)
        val x291 = x67.l_shipdate_46
        val x292 = System.arraycopy(x291,0.toInt,x265,0.toInt,x69.toInt)
        val x293 = x67.l_commitdate_47
        val x294 = System.arraycopy(x293,0.toInt,x266,0.toInt,x69.toInt)
        val x295 = x67.l_receiptdate_48
        val x296 = System.arraycopy(x295,0.toInt,x267,0.toInt,x69.toInt)
        val x297 = x67.l_shipinstruct_49
        val x298 = System.arraycopy(x297,0.toInt,x268,0.toInt,x69.toInt)
        val x299 = x67.l_shipmode_50
        val x300 = System.arraycopy(x299,0.toInt,x269,0.toInt,x69.toInt)
        val x301 = x67.l_comment_51
        val x302 = System.arraycopy(x301,0.toInt,x270,0.toInt,x69.toInt)
        val x271 = new generated.scala.DeliteArrayAnon310125598(x255,x256,x257,x258,x259,x260,x261,x262,x263,x264,x265,x266,x267,x268,x269,x270)
        val x303 = x67 = x271
        x303
      }
      if (x254) {
        x305thenb()
      }
    }
    val x374 = x67
    val x375 = x374.l_orderkey_36
    val x376 = x375.length
    val x380 = x374.l_partkey_37
    val x382 = x374.l_suppkey_38
    val x384 = x374.l_linenumber_39
    val x386 = x374.l_quantity_40
    val x388 = x374.l_extendedprice_41
    val x390 = x374.l_discount_42
    val x392 = x374.l_tax_43
    val x394 = x374.l_returnflag_44
    val x396 = x374.l_linestatus_45
    val x398 = x374.l_shipdate_46
    val x400 = x374.l_commitdate_47
    val x402 = x374.l_receiptdate_48
    val x404 = x374.l_shipinstruct_49
    val x406 = x374.l_shipmode_50
    val x408 = x374.l_comment_51
    val x411 = {
      1998 << 9}
    val x412 = {
      9 << 5}
    val x413 = x412 + 2
    val x414 = x411 + x413
    def x682_block = {
      true
    }
    val x682 = x682_block
    var x418: Int = 0
    var x422: Int = x418
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x423 = new Array[Int](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x424 = new Array[Int](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x425 = new Array[Int](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x426 = new Array[Int](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x427 = new Array[Double](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x428 = new Array[Double](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x429 = new Array[Double](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x430 = new Array[Double](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x431 = new Array[java.lang.String](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x432 = new Array[java.lang.String](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x433 = new Array[Int](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x434 = new Array[Int](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x435 = new Array[Int](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x436 = new Array[java.lang.String](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x437 = new Array[java.lang.String](x418.toInt)
    if (x418 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x438 = new Array[java.lang.String](x418.toInt)
    var x440: Array[Int] = x423
    var x441: Array[Int] = x424
    var x442: Array[Int] = x425
    var x443: Array[Int] = x426
    var x444: Array[Double] = x427
    var x445: Array[Double] = x428
    var x446: Array[Double] = x429
    var x447: Array[Double] = x430
    var x448: Array[java.lang.String] = x431
    var x449: Array[java.lang.String] = x432
    var x450: Array[Int] = x433
    var x451: Array[Int] = x434
    var x452: Array[Int] = x435
    var x453: Array[java.lang.String] = x436
    var x454: Array[java.lang.String] = x437
    var x455: Array[java.lang.String] = x438
    val x456 = new generated.scala.DeliteArrayAnon310125598(x440,x441,x442,x443,x444,x445,x446,x447,x448,x449,x450,x451,x452,x453,x454,x455)
    val x457 = new generated.scala.TableAnon310125598(x422,x456)
    var x775_buf: generated.scala.TableAnon310125598 = x457
    var x775_size: Int = 0
    var x775_conditionals: Int = 0
    var x378: Int = 0
    while (x378 < x376) {  // begin fat loop x775
      val x379 = x375(x378.toInt)
      val x381 = x380(x378.toInt)
      val x383 = x382(x378.toInt)
      val x385 = x384(x378.toInt)
      val x387 = x386(x378.toInt)
      val x389 = x388(x378.toInt)
      val x391 = x390(x378.toInt)
      val x393 = x392(x378.toInt)
      val x395 = x394(x378.toInt)
      val x397 = x396(x378.toInt)
      val x399 = x398(x378.toInt)
      val x401 = x400(x378.toInt)
      val x403 = x402(x378.toInt)
      val x405 = x404(x378.toInt)
      val x407 = x406(x378.toInt)
      val x409 = x408(x378.toInt)
      val x410 = new generated.scala.Anon310125598(x379,x381,x383,x385,x387,x389,x391,x393,x395,x397,x399,x401,x403,x405,x407,x409)
      val x415 = {
        x399 <= x414}
      if (x415) {
        val x416 = x775_buf
        val x417 = x410
        if (x682) {
          val x463 = x417.l_orderkey_36
          val x466 = x417.l_partkey_37
          val x469 = x417.l_suppkey_38
          val x472 = x417.l_linenumber_39
          val x475 = x417.l_quantity_40
          val x478 = x417.l_extendedprice_41
          val x481 = x417.l_discount_42
          val x484 = x417.l_tax_43
          val x487 = x417.l_returnflag_44
          val x490 = x417.l_linestatus_45
          val x493 = x417.l_shipdate_46
          val x496 = x417.l_commitdate_47
          val x499 = x417.l_receiptdate_48
          val x502 = x417.l_shipinstruct_49
          val x505 = x417.l_shipmode_50
          val x508 = x417.l_comment_51
          def x680_block = {
            def x678_block = {
              val x511 = x416.size
              val x517 = x511 + 1
              def x676_block = {
                def x641_block = {
                  def x601_block = {
                    val x512 = x416.data
                    val x513 = x512.l_orderkey_36
                    val x514 = x513.length
                    val x515 = x514 - x511
                    val x516 = {
                      x515 < 1}
                    val x599 = {
                      def x599thenb(): Unit = {
                        val x518 = x514 * 2
                        val x519 = {
                          4 max x518}
                        val x548 = x512.l_partkey_37
                        val x550 = x512.l_suppkey_38
                        val x552 = x512.l_linenumber_39
                        val x554 = x512.l_quantity_40
                        val x556 = x512.l_extendedprice_41
                        val x558 = x512.l_discount_42
                        val x560 = x512.l_tax_43
                        val x562 = x512.l_returnflag_44
                        val x564 = x512.l_linestatus_45
                        val x566 = x512.l_shipdate_46
                        val x568 = x512.l_commitdate_47
                        val x570 = x512.l_receiptdate_48
                        val x572 = x512.l_shipinstruct_49
                        val x574 = x512.l_shipmode_50
                        val x576 = x512.l_comment_51
                        def x597_block = {
                          var x520: Int = x519
                          val x528 = while ({
                            val x521 = x520
                            val x522 = {
                              x521 < x517}
                            x522}) {
                            val x524 = x520
                            val x525 = x524 * 2
                            x520 = x525
                            ()
                          }
                          val x529 = x520
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x530 = new Array[Int](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x531 = new Array[Int](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x532 = new Array[Int](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x533 = new Array[Int](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x534 = new Array[Double](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x535 = new Array[Double](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x536 = new Array[Double](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x537 = new Array[Double](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x538 = new Array[java.lang.String](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x539 = new Array[java.lang.String](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x540 = new Array[Int](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x541 = new Array[Int](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x542 = new Array[Int](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x543 = new Array[java.lang.String](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x544 = new Array[java.lang.String](x529.toInt)
                          if (x529 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x545 = new Array[java.lang.String](x529.toInt)
                          val x547 = System.arraycopy(x513,0.toInt,x530,0.toInt,x511.toInt)
                          val x549 = System.arraycopy(x548,0.toInt,x531,0.toInt,x511.toInt)
                          val x551 = System.arraycopy(x550,0.toInt,x532,0.toInt,x511.toInt)
                          val x553 = System.arraycopy(x552,0.toInt,x533,0.toInt,x511.toInt)
                          val x555 = System.arraycopy(x554,0.toInt,x534,0.toInt,x511.toInt)
                          val x557 = System.arraycopy(x556,0.toInt,x535,0.toInt,x511.toInt)
                          val x559 = System.arraycopy(x558,0.toInt,x536,0.toInt,x511.toInt)
                          val x561 = System.arraycopy(x560,0.toInt,x537,0.toInt,x511.toInt)
                          val x563 = System.arraycopy(x562,0.toInt,x538,0.toInt,x511.toInt)
                          val x565 = System.arraycopy(x564,0.toInt,x539,0.toInt,x511.toInt)
                          val x567 = System.arraycopy(x566,0.toInt,x540,0.toInt,x511.toInt)
                          val x569 = System.arraycopy(x568,0.toInt,x541,0.toInt,x511.toInt)
                          val x571 = System.arraycopy(x570,0.toInt,x542,0.toInt,x511.toInt)
                          val x573 = System.arraycopy(x572,0.toInt,x543,0.toInt,x511.toInt)
                          val x575 = System.arraycopy(x574,0.toInt,x544,0.toInt,x511.toInt)
                          val x577 = System.arraycopy(x576,0.toInt,x545,0.toInt,x511.toInt)
                          val x578 = x530// unsafe immutable
                          val x579 = x531// unsafe immutable
                          val x580 = x532// unsafe immutable
                          val x581 = x533// unsafe immutable
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
                          val x594 = new generated.scala.DeliteArrayAnon310125598(x578,x579,x580,x581,x582,x583,x584,x585,x586,x587,x588,x589,x590,x591,x592,x593)
                          val x595 = x416.data = x594
                          x595
                        }
                        val x597 = x597_block
                        x597
                      }
                      if (x516) {
                        x599thenb()
                      }
                    }
                    x599
                  }
                  val x601 = x601_block
                  val x602 = x416.data
                  val x603 = x416.size
                  val x604 = x603 - x511
                  val x605 = x602.l_orderkey_36
                  val x606 = System.arraycopy(x605,x511.toInt,x416.data.l_orderkey_36,x517.toInt,x604.toInt)
                  val x607 = x602.l_partkey_37
                  val x608 = System.arraycopy(x607,x511.toInt,x416.data.l_partkey_37,x517.toInt,x604.toInt)
                  val x609 = x602.l_suppkey_38
                  val x610 = System.arraycopy(x609,x511.toInt,x416.data.l_suppkey_38,x517.toInt,x604.toInt)
                  val x611 = x602.l_linenumber_39
                  val x612 = System.arraycopy(x611,x511.toInt,x416.data.l_linenumber_39,x517.toInt,x604.toInt)
                  val x613 = x602.l_quantity_40
                  val x614 = System.arraycopy(x613,x511.toInt,x416.data.l_quantity_40,x517.toInt,x604.toInt)
                  val x615 = x602.l_extendedprice_41
                  val x616 = System.arraycopy(x615,x511.toInt,x416.data.l_extendedprice_41,x517.toInt,x604.toInt)
                  val x617 = x602.l_discount_42
                  val x618 = System.arraycopy(x617,x511.toInt,x416.data.l_discount_42,x517.toInt,x604.toInt)
                  val x619 = x602.l_tax_43
                  val x620 = System.arraycopy(x619,x511.toInt,x416.data.l_tax_43,x517.toInt,x604.toInt)
                  val x621 = x602.l_returnflag_44
                  val x622 = System.arraycopy(x621,x511.toInt,x416.data.l_returnflag_44,x517.toInt,x604.toInt)
                  val x623 = x602.l_linestatus_45
                  val x624 = System.arraycopy(x623,x511.toInt,x416.data.l_linestatus_45,x517.toInt,x604.toInt)
                  val x625 = x602.l_shipdate_46
                  val x626 = System.arraycopy(x625,x511.toInt,x416.data.l_shipdate_46,x517.toInt,x604.toInt)
                  val x627 = x602.l_commitdate_47
                  val x628 = System.arraycopy(x627,x511.toInt,x416.data.l_commitdate_47,x517.toInt,x604.toInt)
                  val x629 = x602.l_receiptdate_48
                  val x630 = System.arraycopy(x629,x511.toInt,x416.data.l_receiptdate_48,x517.toInt,x604.toInt)
                  val x631 = x602.l_shipinstruct_49
                  val x632 = System.arraycopy(x631,x511.toInt,x416.data.l_shipinstruct_49,x517.toInt,x604.toInt)
                  val x633 = x602.l_shipmode_50
                  val x634 = System.arraycopy(x633,x511.toInt,x416.data.l_shipmode_50,x517.toInt,x604.toInt)
                  val x635 = x602.l_comment_51
                  val x636 = System.arraycopy(x635,x511.toInt,x416.data.l_comment_51,x517.toInt,x604.toInt)
                  val x637 = x416.size
                  val x638 = x637 + 1
                  val x639 = x416.size = x638
                  x639
                }
                val x641 = x641_block
                val x642 = x416.data
                val x644 = x416.data.l_orderkey_36(x511.toInt) = x463
                val x646 = x416.data.l_partkey_37(x511.toInt) = x466
                val x648 = x416.data.l_suppkey_38(x511.toInt) = x469
                val x650 = x416.data.l_linenumber_39(x511.toInt) = x472
                val x652 = x416.data.l_quantity_40(x511.toInt) = x475
                val x654 = x416.data.l_extendedprice_41(x511.toInt) = x478
                val x656 = x416.data.l_discount_42(x511.toInt) = x481
                val x658 = x416.data.l_tax_43(x511.toInt) = x484
                val x660 = x416.data.l_returnflag_44(x511.toInt) = x487
                val x662 = x416.data.l_linestatus_45(x511.toInt) = x490
                val x664 = x416.data.l_shipdate_46(x511.toInt) = x493
                val x666 = x416.data.l_commitdate_47(x511.toInt) = x496
                val x668 = x416.data.l_receiptdate_48(x511.toInt) = x499
                val x670 = x416.data.l_shipinstruct_49(x511.toInt) = x502
                val x672 = x416.data.l_shipmode_50(x511.toInt) = x505
                val x674 = x416.data.l_comment_51(x511.toInt) = x508
                ()
              }
              val x676 = x676_block
              x676
            }
            val x678 = x678_block
            x678
          }
          val x680 = x680_block
          x775_size = x775_size + 1
        }
        x775_conditionals = x775_conditionals + 1
      }
      x378 = x378 + 1
    } // end fat loop x775
    var x416: generated.scala.TableAnon310125598 = x775_buf
    x418 = x775_conditionals
    val x683 = x416.size = x418
    val x775 = x416
    val x776 = x775.size
    val x778 = x775.data
    val x787 = x778.l_quantity_40
    val x789 = x778.l_extendedprice_41
    val x791 = x778.l_discount_42
    val x793 = x778.l_tax_43
    val x795 = x778.l_returnflag_44
    val x797 = x778.l_linestatus_45
    def x949_block = {
      true
    }
    val x949 = x949_block
    var x815: Int = x776
    var x819: Int = x815
    if (x815 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x820 = new Array[Double](x815.toInt)
    if (x815 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x821 = new Array[Double](x815.toInt)
    if (x815 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x822 = new Array[Double](x815.toInt)
    if (x815 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x823 = new Array[Double](x815.toInt)
    if (x815 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x824 = new Array[java.lang.String](x815.toInt)
    if (x815 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x825 = new Array[java.lang.String](x815.toInt)
    var x827: Array[Double] = x820
    var x828: Array[Double] = x821
    var x829: Array[Double] = x822
    var x830: Array[Double] = x823
    var x831: Array[java.lang.String] = x824
    var x832: Array[java.lang.String] = x825
    val x833 = new generated.scala.DeliteArrayAnon516171423(x827,x828,x829,x830,x831,x832)
    val x834 = new generated.scala.TableAnon516171423(x819,x833)
    val x992_data: generated.scala.TableAnon516171423 = x834
    var x992_size: Int = 0
    var x992_conditionals: Int = 0
    var x777: Int = 0
    while (x777 < x776) {  // begin fat loop x992
      val x788 = x787(x777.toInt)
      val x790 = x789(x777.toInt)
      val x792 = x791(x777.toInt)
      val x794 = x793(x777.toInt)
      val x796 = x795(x777.toInt)
      val x798 = x797(x777.toInt)
      val x812 = new generated.scala.Anon516171423(x788,x790,x792,x794,x796,x798)
      val x814 = x812
      val x813 = x992_data
      val x838 = x813.data
      val x840 = x814.l_quantity_40
      val x841 = x813.data.l_quantity_40(x777.toInt) = x840
      val x843 = x814.l_extendedprice_41
      val x844 = x813.data.l_extendedprice_41(x777.toInt) = x843
      val x846 = x814.l_discount_42
      val x847 = x813.data.l_discount_42(x777.toInt) = x846
      val x849 = x814.l_tax_43
      val x850 = x813.data.l_tax_43(x777.toInt) = x849
      val x852 = x814.l_returnflag_44
      val x853 = x813.data.l_returnflag_44(x777.toInt) = x852
      val x855 = x814.l_linestatus_45
      val x856 = x813.data.l_linestatus_45(x777.toInt) = x855
      x777 = x777 + 1
    } // end fat loop x992
    val x813 = x992_data
    val x992 = x813
    val x994 = x992.size
    val x993 = x992.data
    val x997 = x993.l_quantity_40
    val x999 = x993.l_extendedprice_41
    val x1001 = x993.l_discount_42
    val x1003 = x993.l_tax_43
    val x1005 = x993.l_returnflag_44
    val x1007 = x993.l_linestatus_45
    val x1916 = {
      null.asInstanceOf[Null].asInstanceOf[generated.scala.Anon1187970594]}
    var x2134x3108_hash_pos: generated.scala.container.HashMapImpl[generated.scala.Anon1637442313] = new generated.scala.container.HashMapImpl[generated.scala.Anon1637442313](512,128)
    var x1949: Int = 128
    if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1952 = new Array[java.lang.String](x1949.toInt)
    if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1953 = new Array[java.lang.String](x1949.toInt)
    if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1954 = new Array[Double](x1949.toInt)
    if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1955 = new Array[Double](x1949.toInt)
    if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1956 = new Array[Double](x1949.toInt)
    if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1957 = new Array[Double](x1949.toInt)
    if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1958 = new Array[Double](x1949.toInt)
    if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1959 = new Array[Double](x1949.toInt)
    if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1960 = new Array[Double](x1949.toInt)
    if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1961 = new Array[Int](x1949.toInt)
    val x1962 = new generated.scala.DeliteArrayAnon1187970594(x1952,x1953,x1954,x1955,x1956,x1957,x1958,x1959,x1960,x1961)
    var x2134_hash_data: generated.scala.DeliteArrayAnon1187970594 = x1962
    var x2240: Int = 128
    if (x2240 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2243 = new Array[Int](x2240.toInt)
    var x3108_hash_data: Array[Int] = x2243
    var x1902: Int = 0
    while (x1902 < x994) {  // begin fat loop x2134,x3108
      val x1903 = x997(x1902.toInt)
      val x1904 = x999(x1902.toInt)
      val x1905 = x1001(x1902.toInt)
      val x1911 = {
        1.0 - x1905}
      val x1912 = {
        x1904 * x1911}
      val x1906 = x1003(x1902.toInt)
      val x1913 = {
        1.0 + x1906}
      val x1914 = {
        x1912 * x1913}
      val x1907 = x1005(x1902.toInt)
      val x1908 = x1007(x1902.toInt)
      val x1915 = new generated.scala.Anon1187970594(x1907,x1908,x1903,x1904,x1912,x1914,x1903,x1904,x1905,1)
      val x1910 = new generated.scala.Anon1637442313(x1907,x1908)
      if (true) {
        // common key Block(Sym(1910)) for x2134x3108
        val x2134x3108_sze: Int = x2134x3108_hash_pos.size
        val x2134x3108_idx: Int = x2134x3108_hash_pos.put(x1910)
        if (x2134x3108_idx == x2134x3108_sze) { // new key
          val x1951: generated.scala.DeliteArrayAnon1187970594 = x2134_hash_data
          val x1948: generated.scala.Anon1187970594 = x1915
          val x2019 = x2134x3108_sze
          val x2020 = x1951.l_returnflag_44
          val x2021 = x2020.length
          val x2022 = x2021 - 1
          val x2023 = x2019 > x2022
          val x2091 = {
            def x2091thenb(): Unit = {
              val x2024 = x2021 < 16
              val x2028 = {
                def x2028thenb(): Int = {
                  16
                }
                def x2028elseb(): Int = {
                  val x2025 = x2021 * 2
                  val x2026 = x2025 < 0
                  val x2027 = {
                    def x2027thenb(): Int = {
                      2147483647
                    }
                    def x2027elseb(): Int = {
                      x2025
                    }
                    if (x2026) {
                      x2027thenb()
                    } else {
                      x2027elseb()
                    }
                  }
                  x2027
                }
                if (x2024) {
                  x2028thenb()
                } else {
                  x2028elseb()
                }
              }
              if (x2028 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2029 = new Array[java.lang.String](x2028.toInt)
              if (x2028 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2030 = new Array[java.lang.String](x2028.toInt)
              if (x2028 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2031 = new Array[Double](x2028.toInt)
              if (x2028 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2032 = new Array[Double](x2028.toInt)
              if (x2028 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2033 = new Array[Double](x2028.toInt)
              if (x2028 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2034 = new Array[Double](x2028.toInt)
              if (x2028 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2035 = new Array[Double](x2028.toInt)
              if (x2028 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2036 = new Array[Double](x2028.toInt)
              if (x2028 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2037 = new Array[Double](x2028.toInt)
              if (x2028 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2038 = new Array[Int](x2028.toInt)
              val x2040 = System.arraycopy(x2020,0.toInt,x2029,0.toInt,x2021.toInt)
              val x2041 = x1951.l_linestatus_45
              val x2042 = System.arraycopy(x2041,0.toInt,x2030,0.toInt,x2021.toInt)
              val x2043 = x1951.sum_qty_138
              val x2044 = System.arraycopy(x2043,0.toInt,x2031,0.toInt,x2021.toInt)
              val x2045 = x1951.sum_base_price_139
              val x2046 = System.arraycopy(x2045,0.toInt,x2032,0.toInt,x2021.toInt)
              val x2047 = x1951.sum_disc_price_140
              val x2048 = System.arraycopy(x2047,0.toInt,x2033,0.toInt,x2021.toInt)
              val x2049 = x1951.sum_charge_141
              val x2050 = System.arraycopy(x2049,0.toInt,x2034,0.toInt,x2021.toInt)
              val x2051 = x1951.avg_qty_142
              val x2052 = System.arraycopy(x2051,0.toInt,x2035,0.toInt,x2021.toInt)
              val x2053 = x1951.avg_price_143
              val x2054 = System.arraycopy(x2053,0.toInt,x2036,0.toInt,x2021.toInt)
              val x2055 = x1951.avg_disc_144
              val x2056 = System.arraycopy(x2055,0.toInt,x2037,0.toInt,x2021.toInt)
              val x2057 = x1951.count_order_145
              val x2058 = System.arraycopy(x2057,0.toInt,x2038,0.toInt,x2021.toInt)
              val x1987 = x1948.l_returnflag_44
              val x2059 = x2029(x2019.toInt) = x1987
              val x1990 = x1948.l_linestatus_45
              val x2060 = x2030(x2019.toInt) = x1990
              val x1993 = x1948.sum_qty_138
              val x2061 = x2031(x2019.toInt) = x1993
              val x1996 = x1948.sum_base_price_139
              val x2062 = x2032(x2019.toInt) = x1996
              val x1999 = x1948.sum_disc_price_140
              val x2063 = x2033(x2019.toInt) = x1999
              val x2002 = x1948.sum_charge_141
              val x2064 = x2034(x2019.toInt) = x2002
              val x2005 = x1948.avg_qty_142
              val x2065 = x2035(x2019.toInt) = x2005
              val x2008 = x1948.avg_price_143
              val x2066 = x2036(x2019.toInt) = x2008
              val x2011 = x1948.avg_disc_144
              val x2067 = x2037(x2019.toInt) = x2011
              val x2014 = x1948.count_order_145
              val x2068 = x2038(x2019.toInt) = x2014
              val x2039 = new generated.scala.DeliteArrayAnon1187970594(x2029,x2030,x2031,x2032,x2033,x2034,x2035,x2036,x2037,x2038)
              val x2069 = x2134_hash_data = x2039
              x2069
            }
            def x2091elseb(): Unit = {
              val x1987 = x1948.l_returnflag_44
              val x2071 = x1951.l_returnflag_44(x2019.toInt) = x1987
              val x2072 = x1951.l_linestatus_45
              val x1990 = x1948.l_linestatus_45
              val x2073 = x1951.l_linestatus_45(x2019.toInt) = x1990
              val x2074 = x1951.sum_qty_138
              val x1993 = x1948.sum_qty_138
              val x2075 = x1951.sum_qty_138(x2019.toInt) = x1993
              val x2076 = x1951.sum_base_price_139
              val x1996 = x1948.sum_base_price_139
              val x2077 = x1951.sum_base_price_139(x2019.toInt) = x1996
              val x2078 = x1951.sum_disc_price_140
              val x1999 = x1948.sum_disc_price_140
              val x2079 = x1951.sum_disc_price_140(x2019.toInt) = x1999
              val x2080 = x1951.sum_charge_141
              val x2002 = x1948.sum_charge_141
              val x2081 = x1951.sum_charge_141(x2019.toInt) = x2002
              val x2082 = x1951.avg_qty_142
              val x2005 = x1948.avg_qty_142
              val x2083 = x1951.avg_qty_142(x2019.toInt) = x2005
              val x2084 = x1951.avg_price_143
              val x2008 = x1948.avg_price_143
              val x2085 = x1951.avg_price_143(x2019.toInt) = x2008
              val x2086 = x1951.avg_disc_144
              val x2011 = x1948.avg_disc_144
              val x2087 = x1951.avg_disc_144(x2019.toInt) = x2011
              val x2088 = x1951.count_order_145
              val x2014 = x1948.count_order_145
              val x2089 = x1951.count_order_145(x2019.toInt) = x2014
              ()
            }
            if (x2023) {
              x2091thenb()
            } else {
              x2091elseb()
            }
          }
          val x2242: Array[Int] = x3108_hash_data
          val x2239: Int = 1
          val x2251 = x2134x3108_sze
          val x2252 = x2242.length
          val x2253 = x2252 - 1
          val x2254 = x2251 > x2253
          val x2267 = {
            def x2267thenb(): Unit = {
              val x2255 = x2252 < 16
              val x2259 = {
                def x2259thenb(): Int = {
                  16
                }
                def x2259elseb(): Int = {
                  val x2256 = x2252 * 2
                  val x2257 = x2256 < 0
                  val x2258 = {
                    def x2258thenb(): Int = {
                      2147483647
                    }
                    def x2258elseb(): Int = {
                      x2256
                    }
                    if (x2257) {
                      x2258thenb()
                    } else {
                      x2258elseb()
                    }
                  }
                  x2258
                }
                if (x2255) {
                  x2259thenb()
                } else {
                  x2259elseb()
                }
              }
              if (x2259 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x2260 = new Array[Int](x2259.toInt)
              val x2261 = System.arraycopy(x2242,0.toInt,x2260,0.toInt,x2252.toInt)
              val x2262 = x2260(x2251.toInt) = x2239
              val x2263 = x3108_hash_data = x2260
              x2263
            }
            def x2267elseb(): Unit = {
              val x2265 = x2242(x2251.toInt) = x2239
              x2265
            }
            if (x2254) {
              x2267thenb()
            } else {
              x2267elseb()
            }
          }
        } else { // existing key
          val x1950: Int = x2134x3108_idx
          val x1951: generated.scala.DeliteArrayAnon1187970594 = x2134_hash_data
          val x1964 = x1951.l_returnflag_44
          val x1966 = x1951.l_linestatus_45
          val x1968 = x1951.sum_qty_138
          val x1970 = x1951.sum_base_price_139
          val x1972 = x1951.sum_disc_price_140
          val x1974 = x1951.sum_charge_141
          val x1976 = x1951.avg_qty_142
          val x1978 = x1951.avg_price_143
          val x1980 = x1951.avg_disc_144
          val x1982 = x1951.count_order_145
          val x1965 = x1964(x1950.toInt)
          val x1967 = x1966(x1950.toInt)
          val x1969 = x1968(x1950.toInt)
          val x1971 = x1970(x1950.toInt)
          val x1973 = x1972(x1950.toInt)
          val x1975 = x1974(x1950.toInt)
          val x1977 = x1976(x1950.toInt)
          val x1979 = x1978(x1950.toInt)
          val x1981 = x1980(x1950.toInt)
          val x1983 = x1982(x1950.toInt)
          val x1984 = new generated.scala.Anon1187970594(x1965,x1967,x1969,x1971,x1973,x1975,x1977,x1979,x1981,x1983)
          val x1917: generated.scala.Anon1187970594 = x1984
          val x1918: generated.scala.Anon1187970594 = x1915
          val x1919 = x1917.l_returnflag_44
          val x1921 = x1917.l_linestatus_45
          val x1923 = x1917.sum_qty_138
          val x1924 = x1918.sum_qty_138
          val x1925 = {
            x1923 + x1924}
          val x1926 = x1917.sum_base_price_139
          val x1927 = x1918.sum_base_price_139
          val x1928 = {
            x1926 + x1927}
          val x1929 = x1917.sum_disc_price_140
          val x1930 = x1918.sum_disc_price_140
          val x1931 = {
            x1929 + x1930}
          val x1932 = x1917.sum_charge_141
          val x1933 = x1918.sum_charge_141
          val x1934 = {
            x1932 + x1933}
          val x1935 = x1917.avg_qty_142
          val x1936 = x1918.avg_qty_142
          val x1937 = {
            x1935 + x1936}
          val x1938 = x1917.avg_price_143
          val x1939 = x1918.avg_price_143
          val x1940 = {
            x1938 + x1939}
          val x1941 = x1917.avg_disc_144
          val x1942 = x1918.avg_disc_144
          val x1943 = {
            x1941 + x1942}
          val x1944 = x1917.count_order_145
          val x1945 = x1918.count_order_145
          val x1946 = {
            x1944 + x1945}
          val x1947 = new generated.scala.Anon1187970594(x1919,x1921,x1925,x1928,x1931,x1934,x1937,x1940,x1943,x1946)
          val x1948: generated.scala.Anon1187970594 = x1947
          val x1986 = x1951.l_returnflag_44
          val x1987 = x1948.l_returnflag_44
          val x1988 = x1951.l_returnflag_44(x1950.toInt) = x1987
          val x1989 = x1951.l_linestatus_45
          val x1990 = x1948.l_linestatus_45
          val x1991 = x1951.l_linestatus_45(x1950.toInt) = x1990
          val x1992 = x1951.sum_qty_138
          val x1993 = x1948.sum_qty_138
          val x1994 = x1951.sum_qty_138(x1950.toInt) = x1993
          val x1995 = x1951.sum_base_price_139
          val x1996 = x1948.sum_base_price_139
          val x1997 = x1951.sum_base_price_139(x1950.toInt) = x1996
          val x1998 = x1951.sum_disc_price_140
          val x1999 = x1948.sum_disc_price_140
          val x2000 = x1951.sum_disc_price_140(x1950.toInt) = x1999
          val x2001 = x1951.sum_charge_141
          val x2002 = x1948.sum_charge_141
          val x2003 = x1951.sum_charge_141(x1950.toInt) = x2002
          val x2004 = x1951.avg_qty_142
          val x2005 = x1948.avg_qty_142
          val x2006 = x1951.avg_qty_142(x1950.toInt) = x2005
          val x2007 = x1951.avg_price_143
          val x2008 = x1948.avg_price_143
          val x2009 = x1951.avg_price_143(x1950.toInt) = x2008
          val x2010 = x1951.avg_disc_144
          val x2011 = x1948.avg_disc_144
          val x2012 = x1951.avg_disc_144(x1950.toInt) = x2011
          val x2013 = x1951.count_order_145
          val x2014 = x1948.count_order_145
          val x2015 = x1951.count_order_145(x1950.toInt) = x2014
          val x2241: Int = x2134x3108_idx
          val x2242: Array[Int] = x3108_hash_data
          val x2245 = x2242(x2241.toInt)
          val x2236: Int = x2245
          val x2237: Int = 1
          val x2238 = x2236 + x2237
          val x2239: Int = x2238
          val x2247 = x2242(x2241.toInt) = x2239
        }
      }
      x1902 = x1902 + 1
    } // end fat loop x2134,x3108
    val x2134x3108_sze: Int = x2134x3108_hash_pos.size
    var x1951: generated.scala.DeliteArrayAnon1187970594 = x2134_hash_data
    x1949 = x2134x3108_sze
    val x2093 = x1951.l_returnflag_44
    val x2094 = x2093.length
    val x2095 = x2094 > x1949
    val x2128 = {
      def x2128thenb(): Unit = {
        if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2096 = new Array[java.lang.String](x1949.toInt)
        if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2097 = new Array[java.lang.String](x1949.toInt)
        if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2098 = new Array[Double](x1949.toInt)
        if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2099 = new Array[Double](x1949.toInt)
        if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2100 = new Array[Double](x1949.toInt)
        if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2101 = new Array[Double](x1949.toInt)
        if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2102 = new Array[Double](x1949.toInt)
        if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2103 = new Array[Double](x1949.toInt)
        if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2104 = new Array[Double](x1949.toInt)
        if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2105 = new Array[Int](x1949.toInt)
        val x2107 = System.arraycopy(x2093,0.toInt,x2096,0.toInt,x1949.toInt)
        val x2108 = x1951.l_linestatus_45
        val x2109 = System.arraycopy(x2108,0.toInt,x2097,0.toInt,x1949.toInt)
        val x2110 = x1951.sum_qty_138
        val x2111 = System.arraycopy(x2110,0.toInt,x2098,0.toInt,x1949.toInt)
        val x2112 = x1951.sum_base_price_139
        val x2113 = System.arraycopy(x2112,0.toInt,x2099,0.toInt,x1949.toInt)
        val x2114 = x1951.sum_disc_price_140
        val x2115 = System.arraycopy(x2114,0.toInt,x2100,0.toInt,x1949.toInt)
        val x2116 = x1951.sum_charge_141
        val x2117 = System.arraycopy(x2116,0.toInt,x2101,0.toInt,x1949.toInt)
        val x2118 = x1951.avg_qty_142
        val x2119 = System.arraycopy(x2118,0.toInt,x2102,0.toInt,x1949.toInt)
        val x2120 = x1951.avg_price_143
        val x2121 = System.arraycopy(x2120,0.toInt,x2103,0.toInt,x1949.toInt)
        val x2122 = x1951.avg_disc_144
        val x2123 = System.arraycopy(x2122,0.toInt,x2104,0.toInt,x1949.toInt)
        val x2124 = x1951.count_order_145
        val x2125 = System.arraycopy(x2124,0.toInt,x2105,0.toInt,x1949.toInt)
        val x2106 = new generated.scala.DeliteArrayAnon1187970594(x2096,x2097,x2098,x2099,x2100,x2101,x2102,x2103,x2104,x2105)
        val x2126 = x1951 = x2106
        x2126
      }
      if (x2095) {
        x2128thenb()
      }
    }
    val x2134: generated.scala.DeliteArrayAnon1187970594 = x1951
    var x2242: Array[Int] = x3108_hash_data
    x2240 = x2134x3108_sze
    val x2269 = x2242.length
    val x2270 = x2269 > x2240
    val x2275 = {
      def x2275thenb(): Unit = {
        if (x2240 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x2271 = new Array[Int](x2240.toInt)
        val x2272 = System.arraycopy(x2242,0.toInt,x2271,0.toInt,x2240.toInt)
        val x2273 = x2242 = x2271
        x2273
      }
      if (x2270) {
        x2275thenb()
      }
    }
    val x3108: Array[Int] = x2242
    val x2135 = x2134.l_returnflag_44
    val x2136 = x2135.length
    val x2287 = x2134.l_linestatus_45
    val x2289 = x2134.sum_qty_138
    val x2291 = x2134.sum_base_price_139
    val x2293 = x2134.sum_disc_price_140
    val x2295 = x2134.sum_charge_141
    val x2303 = x2134.count_order_145
    val x2297 = x2134.avg_qty_142
    val x2299 = x2134.avg_price_143
    val x2301 = x2134.avg_disc_144
    def x2499_block = {
      true
    }
    val x2499 = x2499_block
    var x2313: Int = x2136
    var x2317: Int = x2313
    if (x2313 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2318 = new Array[java.lang.String](x2313.toInt)
    if (x2313 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2319 = new Array[java.lang.String](x2313.toInt)
    if (x2313 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2320 = new Array[Double](x2313.toInt)
    if (x2313 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2321 = new Array[Double](x2313.toInt)
    if (x2313 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2322 = new Array[Double](x2313.toInt)
    if (x2313 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2323 = new Array[Double](x2313.toInt)
    if (x2313 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2324 = new Array[Double](x2313.toInt)
    if (x2313 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2325 = new Array[Double](x2313.toInt)
    if (x2313 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2326 = new Array[Double](x2313.toInt)
    if (x2313 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2327 = new Array[Int](x2313.toInt)
    var x2329: Array[java.lang.String] = x2318
    var x2330: Array[java.lang.String] = x2319
    var x2331: Array[Double] = x2320
    var x2332: Array[Double] = x2321
    var x2333: Array[Double] = x2322
    var x2334: Array[Double] = x2323
    var x2335: Array[Double] = x2324
    var x2336: Array[Double] = x2325
    var x2337: Array[Double] = x2326
    var x2338: Array[Int] = x2327
    val x2339 = new generated.scala.DeliteArrayAnon1187970594(x2329,x2330,x2331,x2332,x2333,x2334,x2335,x2336,x2337,x2338)
    val x2340 = new generated.scala.TableAnon1187970594(x2317,x2339)
    val x3114_data: generated.scala.TableAnon1187970594 = x2340
    var x3114_size: Int = 0
    var x3114_conditionals: Int = 0
    var x2285: Int = 0
    while (x2285 < x2136) {  // begin fat loop x3114
      val x2286 = x2135(x2285.toInt)
      val x2288 = x2287(x2285.toInt)
      val x2290 = x2289(x2285.toInt)
      val x2292 = x2291(x2285.toInt)
      val x2294 = x2293(x2285.toInt)
      val x2296 = x2295(x2285.toInt)
      val x2304 = x2303(x2285.toInt)
      val x2298 = x2297(x2285.toInt)
      val x3109 = x3108(x2285.toInt)
      val x3110 = {
        implicitly[Fractional[Double]].div(x2298,x3109)}
      val x2300 = x2299(x2285.toInt)
      val x3111 = {
        implicitly[Fractional[Double]].div(x2300,x3109)}
      val x2302 = x2301(x2285.toInt)
      val x3112 = {
        implicitly[Fractional[Double]].div(x2302,x3109)}
      val x3113 = new generated.scala.Anon1187970594(x2286,x2288,x2290,x2292,x2294,x2296,x3110,x3111,x3112,x2304)
      val x2312 = x3113
      val x2311 = x3114_data
      val x2344 = x2311.data
      val x2346 = x2312.l_returnflag_44
      val x2347 = x2311.data.l_returnflag_44(x2285.toInt) = x2346
      val x2349 = x2312.l_linestatus_45
      val x2350 = x2311.data.l_linestatus_45(x2285.toInt) = x2349
      val x2352 = x2312.sum_qty_138
      val x2353 = x2311.data.sum_qty_138(x2285.toInt) = x2352
      val x2355 = x2312.sum_base_price_139
      val x2356 = x2311.data.sum_base_price_139(x2285.toInt) = x2355
      val x2358 = x2312.sum_disc_price_140
      val x2359 = x2311.data.sum_disc_price_140(x2285.toInt) = x2358
      val x2361 = x2312.sum_charge_141
      val x2362 = x2311.data.sum_charge_141(x2285.toInt) = x2361
      val x2364 = x2312.avg_qty_142
      val x2365 = x2311.data.avg_qty_142(x2285.toInt) = x2364
      val x2367 = x2312.avg_price_143
      val x2368 = x2311.data.avg_price_143(x2285.toInt) = x2367
      val x2370 = x2312.avg_disc_144
      val x2371 = x2311.data.avg_disc_144(x2285.toInt) = x2370
      val x2373 = x2312.count_order_145
      val x2374 = x2311.data.count_order_145(x2285.toInt) = x2373
      x2285 = x2285 + 1
    } // end fat loop x3114
    val x2311 = x3114_data
    val x3114 = x2311
    val x3115 = x3114.size
    val x3116 = x3114.data
    val x3117 = x3116.l_returnflag_44
    val x3119 = x3116.l_linestatus_45
    val x3121 = x3116.sum_qty_138
    val x3123 = x3116.sum_base_price_139
    val x3125 = x3116.sum_disc_price_140
    val x3127 = x3116.sum_charge_141
    val x3129 = x3116.avg_qty_142
    val x3131 = x3116.avg_price_143
    val x3133 = x3116.avg_disc_144
    val x3135 = x3116.count_order_145
    def x2775_block = {
      true
    }
    val x2775 = x2775_block
    var x2589: Int = x3115
    var x2593: Int = x2589
    if (x2589 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2594 = new Array[java.lang.String](x2589.toInt)
    if (x2589 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2595 = new Array[java.lang.String](x2589.toInt)
    if (x2589 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2596 = new Array[Double](x2589.toInt)
    if (x2589 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2597 = new Array[Double](x2589.toInt)
    if (x2589 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2598 = new Array[Double](x2589.toInt)
    if (x2589 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2599 = new Array[Double](x2589.toInt)
    if (x2589 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2600 = new Array[Double](x2589.toInt)
    if (x2589 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2601 = new Array[Double](x2589.toInt)
    if (x2589 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2602 = new Array[Double](x2589.toInt)
    if (x2589 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2603 = new Array[Long](x2589.toInt)
    var x2605: Array[java.lang.String] = x2594
    var x2606: Array[java.lang.String] = x2595
    var x2607: Array[Double] = x2596
    var x2608: Array[Double] = x2597
    var x2609: Array[Double] = x2598
    var x2610: Array[Double] = x2599
    var x2611: Array[Double] = x2600
    var x2612: Array[Double] = x2601
    var x2613: Array[Double] = x2602
    var x2614: Array[Long] = x2603
    val x2615 = new generated.scala.DeliteArrayAnon1702267215(x2605,x2606,x2607,x2608,x2609,x2610,x2611,x2612,x2613,x2614)
    val x2616 = new generated.scala.TableAnon1702267215(x2593,x2615)
    val x3138_data: generated.scala.TableAnon1702267215 = x2616
    var x3138_size: Int = 0
    var x3138_conditionals: Int = 0
    var x2564: Int = 0
    while (x2564 < x3115) {  // begin fat loop x3138
      val x3118 = x3117(x2564.toInt)
      val x3120 = x3119(x2564.toInt)
      val x3122 = x3121(x2564.toInt)
      val x3124 = x3123(x2564.toInt)
      val x3126 = x3125(x2564.toInt)
      val x3128 = x3127(x2564.toInt)
      val x3130 = x3129(x2564.toInt)
      val x3132 = x3131(x2564.toInt)
      val x3134 = x3133(x2564.toInt)
      val x3136 = x3135(x2564.toInt)
      val x3137 = new generated.scala.Anon1702267215(x3118,x3120,x3122,x3124,x3126,x3128,x3130,x3132,x3134,x3136)
      val x2588 = x3137
      val x2587 = x3138_data
      val x2620 = x2587.data
      val x2622 = x2588.l_returnflag_44
      val x2623 = x2587.data.l_returnflag_44(x2564.toInt) = x2622
      val x2625 = x2588.l_linestatus_45
      val x2626 = x2587.data.l_linestatus_45(x2564.toInt) = x2625
      val x2628 = x2588.sum_qty_138
      val x2629 = x2587.data.sum_qty_138(x2564.toInt) = x2628
      val x2631 = x2588.sum_base_price_139
      val x2632 = x2587.data.sum_base_price_139(x2564.toInt) = x2631
      val x2634 = x2588.sum_disc_price_140
      val x2635 = x2587.data.sum_disc_price_140(x2564.toInt) = x2634
      val x2637 = x2588.sum_charge_141
      val x2638 = x2587.data.sum_charge_141(x2564.toInt) = x2637
      val x2640 = x2588.avg_qty_142
      val x2641 = x2587.data.avg_qty_142(x2564.toInt) = x2640
      val x2643 = x2588.avg_price_143
      val x2644 = x2587.data.avg_price_143(x2564.toInt) = x2643
      val x2646 = x2588.avg_disc_144
      val x2647 = x2587.data.avg_disc_144(x2564.toInt) = x2646
      val x2649 = x2588.count_order_145
      val x2650 = x2587.data.count_order_145(x2564.toInt) = x2649
      x2564 = x2564 + 1
    } // end fat loop x3138
    val x2587 = x3138_data
    val x3138 = x2587
    val x3139 = x3138.size
    val x3140 = x3138.data
    val x3141 = x3140.l_returnflag_44
    val x3149 = x3140.l_linestatus_45
    val x3157 = {
      val len = x3139.toInt
      val comp = new generated.scala.container.IntComparator {
        def compare(o1: Int, o2: Int): Int = {
          val x2840 = o1
          val x2841 = o2
          val x3142 = x3141(x2840.toInt)
          val x3143 = x3141(x2841.toInt)
          val x3144 = {
            x3142 < x3143}
          val x3147 = {
            def x3147thenb(): Int = {
              -1
            }
            def x3147elseb(): Int = {
              val x3145 = {
                x3142 > x3143}
              val x3146 = {
                def x3146thenb(): Int = {
                  1
                }
                def x3146elseb(): Int = {
                  0
                }
                if (x3145) {
                  x3146thenb()
                } else {
                  x3146elseb()
                }
              }
              x3146
            }
            if (x3144) {
              x3147thenb()
            } else {
              x3147elseb()
            }
          }
          val x3148 = x3147 == 0
          val x3156 = {
            def x3156thenb(): Int = {
              val x3150 = x3149(x2840.toInt)
              val x3151 = x3149(x2841.toInt)
              val x3152 = {
                x3150 < x3151}
              val x3155 = {
                def x3155thenb(): Int = {
                  -1
                }
                def x3155elseb(): Int = {
                  val x3153 = {
                    x3150 > x3151}
                  val x3154 = {
                    def x3154thenb(): Int = {
                      1
                    }
                    def x3154elseb(): Int = {
                      0
                    }
                    if (x3153) {
                      x3154thenb()
                    } else {
                      x3154elseb()
                    }
                  }
                  x3154
                }
                if (x3152) {
                  x3155thenb()
                } else {
                  x3155elseb()
                }
              }
              x3155
            }
            def x3156elseb(): Int = {
              x3147
            }
            if (x3148) {
              x3156thenb()
            } else {
              x3156elseb()
            }
          }
          x3156.toInt
      } }
      val d = new Array[Int](len)
      var i = 0; while(i < len) { d(i) = i; i += 1 }
      generated.scala.container.SortingImpl.sort(d,comp)
      d
    }
    val x3161 = x3140.sum_qty_138
    val x3163 = x3140.sum_base_price_139
    val x3165 = x3140.sum_disc_price_140
    val x3167 = x3140.sum_charge_141
    val x3169 = x3140.avg_qty_142
    val x3171 = x3140.avg_price_143
    val x3173 = x3140.avg_disc_144
    val x3175 = x3140.count_order_145
    var x2901: Int = x3139
    if (x2901 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2905 = new Array[java.lang.String](x2901.toInt)
    if (x2901 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2906 = new Array[java.lang.String](x2901.toInt)
    if (x2901 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2907 = new Array[Double](x2901.toInt)
    if (x2901 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2908 = new Array[Double](x2901.toInt)
    if (x2901 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2909 = new Array[Double](x2901.toInt)
    if (x2901 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2910 = new Array[Double](x2901.toInt)
    if (x2901 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2911 = new Array[Double](x2901.toInt)
    if (x2901 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2912 = new Array[Double](x2901.toInt)
    if (x2901 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2913 = new Array[Double](x2901.toInt)
    if (x2901 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x2914 = new Array[Long](x2901.toInt)
    val x2915 = new generated.scala.DeliteArrayAnon1702267215(x2905,x2906,x2907,x2908,x2909,x2910,x2911,x2912,x2913,x2914)
    val x3178_data: generated.scala.DeliteArrayAnon1702267215 = x2915
    var x3178_size: Int = 0
    var x3178_conditionals: Int = 0
    var x2886: Int = 0
    while (x2886 < x3139) {  // begin fat loop x3178
      val x3158 = x3157(x2886.toInt)
      val x3159 = x3141(x3158.toInt)
      val x3160 = x3149(x3158.toInt)
      val x3162 = x3161(x3158.toInt)
      val x3164 = x3163(x3158.toInt)
      val x3166 = x3165(x3158.toInt)
      val x3168 = x3167(x3158.toInt)
      val x3170 = x3169(x3158.toInt)
      val x3172 = x3171(x3158.toInt)
      val x3174 = x3173(x3158.toInt)
      val x3176 = x3175(x3158.toInt)
      val x3177 = new generated.scala.Anon1702267215(x3159,x3160,x3162,x3164,x3166,x3168,x3170,x3172,x3174,x3176)
      val x2900 = x3177
      val x2899 = x3178_data
      val x2919 = x2899.l_returnflag_44
      val x2920 = x2900.l_returnflag_44
      val x2921 = x2899.l_returnflag_44(x2886.toInt) = x2920
      val x2922 = x2899.l_linestatus_45
      val x2923 = x2900.l_linestatus_45
      val x2924 = x2899.l_linestatus_45(x2886.toInt) = x2923
      val x2925 = x2899.sum_qty_138
      val x2926 = x2900.sum_qty_138
      val x2927 = x2899.sum_qty_138(x2886.toInt) = x2926
      val x2928 = x2899.sum_base_price_139
      val x2929 = x2900.sum_base_price_139
      val x2930 = x2899.sum_base_price_139(x2886.toInt) = x2929
      val x2931 = x2899.sum_disc_price_140
      val x2932 = x2900.sum_disc_price_140
      val x2933 = x2899.sum_disc_price_140(x2886.toInt) = x2932
      val x2934 = x2899.sum_charge_141
      val x2935 = x2900.sum_charge_141
      val x2936 = x2899.sum_charge_141(x2886.toInt) = x2935
      val x2937 = x2899.avg_qty_142
      val x2938 = x2900.avg_qty_142
      val x2939 = x2899.avg_qty_142(x2886.toInt) = x2938
      val x2940 = x2899.avg_price_143
      val x2941 = x2900.avg_price_143
      val x2942 = x2899.avg_price_143(x2886.toInt) = x2941
      val x2943 = x2899.avg_disc_144
      val x2944 = x2900.avg_disc_144
      val x2945 = x2899.avg_disc_144(x2886.toInt) = x2944
      val x2946 = x2899.count_order_145
      val x2947 = x2900.count_order_145
      val x2948 = x2899.count_order_145(x2886.toInt) = x2947
      x2886 = x2886 + 1
    } // end fat loop x3178
    val x2899 = x3178_data
    val x3178 = x2899
    val x3179 = new generated.scala.TableAnon1702267215(x3139,x3178)
    val x3180 = {
      TablePrinter.printAsTable(x3179, 20)}
    ()
  }
}
/*****************************************
End of Generated Code
*******************************************/

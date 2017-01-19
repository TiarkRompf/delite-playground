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
      1994 << 9}
    val x412 = {
      1 << 5}
    val x413 = x412 + 1
    val x414 = x411 + x413
    val x416 = {
      1995 << 9}
    val x417 = x416 + x413
    def x692_block = {
      true
    }
    val x692 = x692_block
    var x428: Int = 0
    var x432: Int = x428
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x433 = new Array[Int](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x434 = new Array[Int](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x435 = new Array[Int](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x436 = new Array[Int](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x437 = new Array[Double](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x438 = new Array[Double](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x439 = new Array[Double](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x440 = new Array[Double](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x441 = new Array[java.lang.String](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x442 = new Array[java.lang.String](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x443 = new Array[Int](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x444 = new Array[Int](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x445 = new Array[Int](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x446 = new Array[java.lang.String](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x447 = new Array[java.lang.String](x428.toInt)
    if (x428 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x448 = new Array[java.lang.String](x428.toInt)
    var x450: Array[Int] = x433
    var x451: Array[Int] = x434
    var x452: Array[Int] = x435
    var x453: Array[Int] = x436
    var x454: Array[Double] = x437
    var x455: Array[Double] = x438
    var x456: Array[Double] = x439
    var x457: Array[Double] = x440
    var x458: Array[java.lang.String] = x441
    var x459: Array[java.lang.String] = x442
    var x460: Array[Int] = x443
    var x461: Array[Int] = x444
    var x462: Array[Int] = x445
    var x463: Array[java.lang.String] = x446
    var x464: Array[java.lang.String] = x447
    var x465: Array[java.lang.String] = x448
    val x466 = new generated.scala.DeliteArrayAnon310125598(x450,x451,x452,x453,x454,x455,x456,x457,x458,x459,x460,x461,x462,x463,x464,x465)
    val x467 = new generated.scala.TableAnon310125598(x432,x466)
    var x785_buf: generated.scala.TableAnon310125598 = x467
    var x785_size: Int = 0
    var x785_conditionals: Int = 0
    var x378: Int = 0
    while (x378 < x376) {  // begin fat loop x785
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
        x399 >= x414}
      val x418 = {
        x399 < x417}
      val x419 = {
        x415 && x418}
      val x420 = {
        x391 >= 0.05}
      val x421 = {
        x419 && x420}
      val x422 = {
        x391 <= 0.07}
      val x423 = {
        x421 && x422}
      val x424 = {
        x387 < 24.0}
      val x425 = {
        x423 && x424}
      if (x425) {
        val x426 = x785_buf
        val x427 = x410
        if (x692) {
          val x473 = x427.l_orderkey_36
          val x476 = x427.l_partkey_37
          val x479 = x427.l_suppkey_38
          val x482 = x427.l_linenumber_39
          val x485 = x427.l_quantity_40
          val x488 = x427.l_extendedprice_41
          val x491 = x427.l_discount_42
          val x494 = x427.l_tax_43
          val x497 = x427.l_returnflag_44
          val x500 = x427.l_linestatus_45
          val x503 = x427.l_shipdate_46
          val x506 = x427.l_commitdate_47
          val x509 = x427.l_receiptdate_48
          val x512 = x427.l_shipinstruct_49
          val x515 = x427.l_shipmode_50
          val x518 = x427.l_comment_51
          def x690_block = {
            def x688_block = {
              val x521 = x426.size
              val x527 = x521 + 1
              def x686_block = {
                def x651_block = {
                  def x611_block = {
                    val x522 = x426.data
                    val x523 = x522.l_orderkey_36
                    val x524 = x523.length
                    val x525 = x524 - x521
                    val x526 = {
                      x525 < 1}
                    val x609 = {
                      def x609thenb(): Unit = {
                        val x528 = x524 * 2
                        val x529 = {
                          4 max x528}
                        val x558 = x522.l_partkey_37
                        val x560 = x522.l_suppkey_38
                        val x562 = x522.l_linenumber_39
                        val x564 = x522.l_quantity_40
                        val x566 = x522.l_extendedprice_41
                        val x568 = x522.l_discount_42
                        val x570 = x522.l_tax_43
                        val x572 = x522.l_returnflag_44
                        val x574 = x522.l_linestatus_45
                        val x576 = x522.l_shipdate_46
                        val x578 = x522.l_commitdate_47
                        val x580 = x522.l_receiptdate_48
                        val x582 = x522.l_shipinstruct_49
                        val x584 = x522.l_shipmode_50
                        val x586 = x522.l_comment_51
                        def x607_block = {
                          var x530: Int = x529
                          val x538 = while ({
                            val x531 = x530
                            val x532 = {
                              x531 < x527}
                            x532}) {
                            val x534 = x530
                            val x535 = x534 * 2
                            x530 = x535
                            ()
                          }
                          val x539 = x530
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x540 = new Array[Int](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x541 = new Array[Int](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x542 = new Array[Int](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x543 = new Array[Int](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x544 = new Array[Double](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x545 = new Array[Double](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x546 = new Array[Double](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x547 = new Array[Double](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x548 = new Array[java.lang.String](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x549 = new Array[java.lang.String](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x550 = new Array[Int](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x551 = new Array[Int](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x552 = new Array[Int](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x553 = new Array[java.lang.String](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x554 = new Array[java.lang.String](x539.toInt)
                          if (x539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x555 = new Array[java.lang.String](x539.toInt)
                          val x557 = System.arraycopy(x523,0.toInt,x540,0.toInt,x521.toInt)
                          val x559 = System.arraycopy(x558,0.toInt,x541,0.toInt,x521.toInt)
                          val x561 = System.arraycopy(x560,0.toInt,x542,0.toInt,x521.toInt)
                          val x563 = System.arraycopy(x562,0.toInt,x543,0.toInt,x521.toInt)
                          val x565 = System.arraycopy(x564,0.toInt,x544,0.toInt,x521.toInt)
                          val x567 = System.arraycopy(x566,0.toInt,x545,0.toInt,x521.toInt)
                          val x569 = System.arraycopy(x568,0.toInt,x546,0.toInt,x521.toInt)
                          val x571 = System.arraycopy(x570,0.toInt,x547,0.toInt,x521.toInt)
                          val x573 = System.arraycopy(x572,0.toInt,x548,0.toInt,x521.toInt)
                          val x575 = System.arraycopy(x574,0.toInt,x549,0.toInt,x521.toInt)
                          val x577 = System.arraycopy(x576,0.toInt,x550,0.toInt,x521.toInt)
                          val x579 = System.arraycopy(x578,0.toInt,x551,0.toInt,x521.toInt)
                          val x581 = System.arraycopy(x580,0.toInt,x552,0.toInt,x521.toInt)
                          val x583 = System.arraycopy(x582,0.toInt,x553,0.toInt,x521.toInt)
                          val x585 = System.arraycopy(x584,0.toInt,x554,0.toInt,x521.toInt)
                          val x587 = System.arraycopy(x586,0.toInt,x555,0.toInt,x521.toInt)
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
                          val x598 = x550// unsafe immutable
                          val x599 = x551// unsafe immutable
                          val x600 = x552// unsafe immutable
                          val x601 = x553// unsafe immutable
                          val x602 = x554// unsafe immutable
                          val x603 = x555// unsafe immutable
                          val x604 = new generated.scala.DeliteArrayAnon310125598(x588,x589,x590,x591,x592,x593,x594,x595,x596,x597,x598,x599,x600,x601,x602,x603)
                          val x605 = x426.data = x604
                          x605
                        }
                        val x607 = x607_block
                        x607
                      }
                      if (x526) {
                        x609thenb()
                      }
                    }
                    x609
                  }
                  val x611 = x611_block
                  val x612 = x426.data
                  val x613 = x426.size
                  val x614 = x613 - x521
                  val x615 = x612.l_orderkey_36
                  val x616 = System.arraycopy(x615,x521.toInt,x426.data.l_orderkey_36,x527.toInt,x614.toInt)
                  val x617 = x612.l_partkey_37
                  val x618 = System.arraycopy(x617,x521.toInt,x426.data.l_partkey_37,x527.toInt,x614.toInt)
                  val x619 = x612.l_suppkey_38
                  val x620 = System.arraycopy(x619,x521.toInt,x426.data.l_suppkey_38,x527.toInt,x614.toInt)
                  val x621 = x612.l_linenumber_39
                  val x622 = System.arraycopy(x621,x521.toInt,x426.data.l_linenumber_39,x527.toInt,x614.toInt)
                  val x623 = x612.l_quantity_40
                  val x624 = System.arraycopy(x623,x521.toInt,x426.data.l_quantity_40,x527.toInt,x614.toInt)
                  val x625 = x612.l_extendedprice_41
                  val x626 = System.arraycopy(x625,x521.toInt,x426.data.l_extendedprice_41,x527.toInt,x614.toInt)
                  val x627 = x612.l_discount_42
                  val x628 = System.arraycopy(x627,x521.toInt,x426.data.l_discount_42,x527.toInt,x614.toInt)
                  val x629 = x612.l_tax_43
                  val x630 = System.arraycopy(x629,x521.toInt,x426.data.l_tax_43,x527.toInt,x614.toInt)
                  val x631 = x612.l_returnflag_44
                  val x632 = System.arraycopy(x631,x521.toInt,x426.data.l_returnflag_44,x527.toInt,x614.toInt)
                  val x633 = x612.l_linestatus_45
                  val x634 = System.arraycopy(x633,x521.toInt,x426.data.l_linestatus_45,x527.toInt,x614.toInt)
                  val x635 = x612.l_shipdate_46
                  val x636 = System.arraycopy(x635,x521.toInt,x426.data.l_shipdate_46,x527.toInt,x614.toInt)
                  val x637 = x612.l_commitdate_47
                  val x638 = System.arraycopy(x637,x521.toInt,x426.data.l_commitdate_47,x527.toInt,x614.toInt)
                  val x639 = x612.l_receiptdate_48
                  val x640 = System.arraycopy(x639,x521.toInt,x426.data.l_receiptdate_48,x527.toInt,x614.toInt)
                  val x641 = x612.l_shipinstruct_49
                  val x642 = System.arraycopy(x641,x521.toInt,x426.data.l_shipinstruct_49,x527.toInt,x614.toInt)
                  val x643 = x612.l_shipmode_50
                  val x644 = System.arraycopy(x643,x521.toInt,x426.data.l_shipmode_50,x527.toInt,x614.toInt)
                  val x645 = x612.l_comment_51
                  val x646 = System.arraycopy(x645,x521.toInt,x426.data.l_comment_51,x527.toInt,x614.toInt)
                  val x647 = x426.size
                  val x648 = x647 + 1
                  val x649 = x426.size = x648
                  x649
                }
                val x651 = x651_block
                val x652 = x426.data
                val x654 = x426.data.l_orderkey_36(x521.toInt) = x473
                val x656 = x426.data.l_partkey_37(x521.toInt) = x476
                val x658 = x426.data.l_suppkey_38(x521.toInt) = x479
                val x660 = x426.data.l_linenumber_39(x521.toInt) = x482
                val x662 = x426.data.l_quantity_40(x521.toInt) = x485
                val x664 = x426.data.l_extendedprice_41(x521.toInt) = x488
                val x666 = x426.data.l_discount_42(x521.toInt) = x491
                val x668 = x426.data.l_tax_43(x521.toInt) = x494
                val x670 = x426.data.l_returnflag_44(x521.toInt) = x497
                val x672 = x426.data.l_linestatus_45(x521.toInt) = x500
                val x674 = x426.data.l_shipdate_46(x521.toInt) = x503
                val x676 = x426.data.l_commitdate_47(x521.toInt) = x506
                val x678 = x426.data.l_receiptdate_48(x521.toInt) = x509
                val x680 = x426.data.l_shipinstruct_49(x521.toInt) = x512
                val x682 = x426.data.l_shipmode_50(x521.toInt) = x515
                val x684 = x426.data.l_comment_51(x521.toInt) = x518
                ()
              }
              val x686 = x686_block
              x686
            }
            val x688 = x688_block
            x688
          }
          val x690 = x690_block
          x785_size = x785_size + 1
        }
        x785_conditionals = x785_conditionals + 1
      }
      x378 = x378 + 1
    } // end fat loop x785
    var x426: generated.scala.TableAnon310125598 = x785_buf
    x428 = x785_conditionals
    val x693 = x426.size = x428
    val x785 = x426
    val x786 = x785.size
    val x788 = x785.data
    val x799 = x788.l_extendedprice_41
    val x801 = x788.l_discount_42
    def x907_block = {
      true
    }
    val x907 = x907_block
    var x825: Int = x786
    var x829: Int = x825
    if (x825 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x830 = new Array[Double](x825.toInt)
    if (x825 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x831 = new Array[Double](x825.toInt)
    var x833: Array[Double] = x830
    var x834: Array[Double] = x831
    val x835 = new generated.scala.DeliteArrayAnon1578811879(x833,x834)
    val x836 = new generated.scala.TableAnon1578811879(x829,x835)
    val x930_data: generated.scala.TableAnon1578811879 = x836
    var x930_size: Int = 0
    var x930_conditionals: Int = 0
    var x787: Int = 0
    while (x787 < x786) {  // begin fat loop x930
      val x800 = x799(x787.toInt)
      val x802 = x801(x787.toInt)
      val x822 = new generated.scala.Anon1578811879(x800,x802)
      val x824 = x822
      val x823 = x930_data
      val x840 = x823.data
      val x842 = x824.l_extendedprice_41
      val x843 = x823.data.l_extendedprice_41(x787.toInt) = x842
      val x845 = x824.l_discount_42
      val x846 = x823.data.l_discount_42(x787.toInt) = x845
      x787 = x787 + 1
    } // end fat loop x930
    val x823 = x930_data
    val x930 = x823
    val x931 = x930.size
    val x933 = x930.data
    val x941_zero: Double = 0.0
    var x941: Double = x941_zero
    var x932: Int = 0
    if (x931 > 0) { // prerun fat loop x941
      val x934 = x933(x932.toInt)
      val x935 = x934.l_extendedprice_41
      val x936 = x934.l_discount_42
      val x937 = {
        x935 * x936}
      x941 = x937
    }
    x932 = 1
    while (x932 < x931) {  // begin fat loop x941
      val x934 = x933(x932.toInt)
      val x935 = x934.l_extendedprice_41
      val x936 = x934.l_discount_42
      val x937 = {
        x935 * x936}
      val x938 = x941
      val x939 = x937
      val x940 = {
        x938 + x939}
      x941 = x940
      x932 = x932 + 1
    } // end fat loop x941
    val x942 = new generated.scala.Anon719361767(x941)
    val x943 = new Array[generated.scala.Anon719361767](1)
    x943(0) = x942
    x943
    val x944 = x943.length
    def x999_thin = {
      // a *thin* loop follows: x999
      var x949: Int = x944
      if (x949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
      val x953 = new Array[Double](x949.toInt)
      val x954 = new generated.scala.DeliteArrayAnon719361767(x953)
      val x999_data: generated.scala.DeliteArrayAnon719361767 = x954
      var x999_size: Int = 0
      var x999_conditionals: Int = 0
      var x945: Int = 0
      while (x945 < x944) {  // begin fat loop x999
        val x946 = x943(x945.toInt)
        val x948 = x946
        val x947 = x999_data
        val x958 = x947.revenue_138
        val x959 = x948.revenue_138
        val x960 = x947.revenue_138(x945.toInt) = x959
        x945 = x945 + 1
      } // end fat loop x999
      val x947 = x999_data
      val x999 = x947
      x999
    }
    val x999 = x999_thin
    val x1000 = new generated.scala.TableAnon719361767(1,x999)
    val x1001 = {
      TablePrinter.printAsTable(x1000, 20)}
    ()
  }
}
/*****************************************
End of Generated Code
*******************************************/

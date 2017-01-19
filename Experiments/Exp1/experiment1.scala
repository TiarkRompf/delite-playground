/*****************************************
Emitting Generated Code
*******************************************/
package generated.scala
class  extends ((Array[java.lang.String])=>(Unit)) {
  def apply(x0:Array[java.lang.String]): Unit = {
    val x1 = {
      println("TPC-H")}
    val x2 = generated.scala.io.DeliteFileInputStream(Seq("/home/greg/Research/data/SF1/nation.tbl"), None, None,0L)
    val x3 = x2.size
    var x16: Int = 0
    if (x16 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x20 = new Array[Int](x16.toInt)
    if (x16 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x21 = new Array[java.lang.String](x16.toInt)
    if (x16 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x22 = new Array[Int](x16.toInt)
    if (x16 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x23 = new Array[java.lang.String](x16.toInt)
    val x24 = new generated.scala.DeliteArrayAnon2060362663(x20,x21,x22,x23)
    var x117_buf: generated.scala.DeliteArrayAnon2060362663 = x24
    var x117_size: Int = 0
    var x117_conditionals: Int = 0
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
      val x10 = x6(2.toInt)
      val x11 = {
        x10.toInt}
      val x12 = x6(3.toInt)
      val x13 = new generated.scala.Anon2060362663(x8,x9,x11,x12)
      val x14 = x117_buf
      val x15 = x13
      if (true) {
        val x41 = x117_size
        val x42 = x14.n_nationkey_114
        val x43 = x42.length
        val x44 = x43 - 1
        val x45 = x41 > x44
        val x77 = {
          def x77thenb(): Unit = {
            val x46 = x43 < 16
            val x50 = {
              def x50thenb(): Int = {
                16
              }
              def x50elseb(): Int = {
                val x47 = x43 * 2
                val x48 = x47 < 0
                val x49 = {
                  def x49thenb(): Int = {
                    2147483647
                  }
                  def x49elseb(): Int = {
                    x47
                  }
                  if (x48) {
                    x49thenb()
                  } else {
                    x49elseb()
                  }
                }
                x49
              }
              if (x46) {
                x50thenb()
              } else {
                x50elseb()
              }
            }
            if (x50 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x51 = new Array[Int](x50.toInt)
            if (x50 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x52 = new Array[java.lang.String](x50.toInt)
            if (x50 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x53 = new Array[Int](x50.toInt)
            if (x50 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x54 = new Array[java.lang.String](x50.toInt)
            val x56 = System.arraycopy(x42,0.toInt,x51,0.toInt,x43.toInt)
            val x57 = x14.n_name_115
            val x58 = System.arraycopy(x57,0.toInt,x52,0.toInt,x43.toInt)
            val x59 = x14.n_regionkey_116
            val x60 = System.arraycopy(x59,0.toInt,x53,0.toInt,x43.toInt)
            val x61 = x14.n_comment_117
            val x62 = System.arraycopy(x61,0.toInt,x54,0.toInt,x43.toInt)
            val x29 = x15.n_nationkey_114
            val x63 = x51(x41.toInt) = x29
            val x32 = x15.n_name_115
            val x64 = x52(x41.toInt) = x32
            val x35 = x15.n_regionkey_116
            val x65 = x53(x41.toInt) = x35
            val x38 = x15.n_comment_117
            val x66 = x54(x41.toInt) = x38
            val x55 = new generated.scala.DeliteArrayAnon2060362663(x51,x52,x53,x54)
            val x67 = x117_buf = x55
            x67
          }
          def x77elseb(): Unit = {
            val x29 = x15.n_nationkey_114
            val x69 = x14.n_nationkey_114(x41.toInt) = x29
            val x70 = x14.n_name_115
            val x32 = x15.n_name_115
            val x71 = x14.n_name_115(x41.toInt) = x32
            val x72 = x14.n_regionkey_116
            val x35 = x15.n_regionkey_116
            val x73 = x14.n_regionkey_116(x41.toInt) = x35
            val x74 = x14.n_comment_117
            val x38 = x15.n_comment_117
            val x75 = x14.n_comment_117(x41.toInt) = x38
            ()
          }
          if (x45) {
            x77thenb()
          } else {
            x77elseb()
          }
        }
        x117_size = x117_size + 1
      }
      x117_conditionals = x117_conditionals + 1
      x4 = x4 + 1
    } // end fat loop x117
    x2_stream.close();
    var x14: generated.scala.DeliteArrayAnon2060362663 = x117_buf
    x16 = x117_conditionals
    val x79 = x14.n_nationkey_114
    val x80 = x79.length
    val x81 = x80 > x16
    val x96 = {
      def x96thenb(): Unit = {
        if (x16 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x82 = new Array[Int](x16.toInt)
        if (x16 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x83 = new Array[java.lang.String](x16.toInt)
        if (x16 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x84 = new Array[Int](x16.toInt)
        if (x16 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x85 = new Array[java.lang.String](x16.toInt)
        val x87 = System.arraycopy(x79,0.toInt,x82,0.toInt,x16.toInt)
        val x88 = x14.n_name_115
        val x89 = System.arraycopy(x88,0.toInt,x83,0.toInt,x16.toInt)
        val x90 = x14.n_regionkey_116
        val x91 = System.arraycopy(x90,0.toInt,x84,0.toInt,x16.toInt)
        val x92 = x14.n_comment_117
        val x93 = System.arraycopy(x92,0.toInt,x85,0.toInt,x16.toInt)
        val x86 = new generated.scala.DeliteArrayAnon2060362663(x82,x83,x84,x85)
        val x94 = x14 = x86
        x94
      }
      if (x81) {
        x96thenb()
      }
    }
    val x117 = x14
    val x118 = x117.n_nationkey_114
    val x119 = x118.length
    val x123 = x117.n_name_115
    val x125 = x117.n_regionkey_116
    val x127 = x117.n_comment_117
    def x244_block = {
      true
    }
    val x244 = x244_block
    var x136: Int = 0
    var x140: Int = x136
    if (x136 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x141 = new Array[Int](x136.toInt)
    if (x136 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x142 = new Array[java.lang.String](x136.toInt)
    if (x136 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x143 = new Array[Int](x136.toInt)
    if (x136 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x144 = new Array[java.lang.String](x136.toInt)
    var x146: Array[Int] = x141
    var x147: Array[java.lang.String] = x142
    var x148: Array[Int] = x143
    var x149: Array[java.lang.String] = x144
    val x150 = new generated.scala.DeliteArrayAnon2060362663(x146,x147,x148,x149)
    val x151 = new generated.scala.TableAnon2060362663(x140,x150)
    var x277_buf: generated.scala.TableAnon2060362663 = x151
    var x277_size: Int = 0
    var x277_conditionals: Int = 0
    var x121: Int = 0
    while (x121 < x119) {  // begin fat loop x277
      val x122 = x118(x121.toInt)
      val x124 = x123(x121.toInt)
      val x126 = x125(x121.toInt)
      val x128 = x127(x121.toInt)
      val x129 = new generated.scala.Anon2060362663(x122,x124,x126,x128)
      val x130 = x126 == 2147483647
      val x131 = !x130
      val x132 = {
        x126 > 0}
      val x133 = {
        x131 && x132}
      if (x133) {
        val x134 = x277_buf
        val x135 = x129
        if (x244) {
          val x157 = x135.n_nationkey_114
          val x160 = x135.n_name_115
          val x163 = x135.n_regionkey_116
          val x166 = x135.n_comment_117
          def x242_block = {
            def x240_block = {
              val x169 = x134.size
              val x175 = x169 + 1
              def x238_block = {
                def x227_block = {
                  def x211_block = {
                    val x170 = x134.data
                    val x171 = x170.n_nationkey_114
                    val x172 = x171.length
                    val x173 = x172 - x169
                    val x174 = {
                      x173 < 1}
                    val x209 = {
                      def x209thenb(): Unit = {
                        val x176 = x172 * 2
                        val x177 = {
                          4 max x176}
                        val x194 = x170.n_name_115
                        val x196 = x170.n_regionkey_116
                        val x198 = x170.n_comment_117
                        def x207_block = {
                          var x178: Int = x177
                          val x186 = while ({
                            val x179 = x178
                            val x180 = {
                              x179 < x175}
                            x180}) {
                            val x182 = x178
                            val x183 = x182 * 2
                            x178 = x183
                            ()
                          }
                          val x187 = x178
                          if (x187 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x188 = new Array[Int](x187.toInt)
                          if (x187 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x189 = new Array[java.lang.String](x187.toInt)
                          if (x187 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x190 = new Array[Int](x187.toInt)
                          if (x187 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x191 = new Array[java.lang.String](x187.toInt)
                          val x193 = System.arraycopy(x171,0.toInt,x188,0.toInt,x169.toInt)
                          val x195 = System.arraycopy(x194,0.toInt,x189,0.toInt,x169.toInt)
                          val x197 = System.arraycopy(x196,0.toInt,x190,0.toInt,x169.toInt)
                          val x199 = System.arraycopy(x198,0.toInt,x191,0.toInt,x169.toInt)
                          val x200 = x188// unsafe immutable
                          val x201 = x189// unsafe immutable
                          val x202 = x190// unsafe immutable
                          val x203 = x191// unsafe immutable
                          val x204 = new generated.scala.DeliteArrayAnon2060362663(x200,x201,x202,x203)
                          val x205 = x134.data = x204
                          x205
                        }
                        val x207 = x207_block
                        x207
                      }
                      if (x174) {
                        x209thenb()
                      }
                    }
                    x209
                  }
                  val x211 = x211_block
                  val x212 = x134.data
                  val x213 = x134.size
                  val x214 = x213 - x169
                  val x215 = x212.n_nationkey_114
                  val x216 = System.arraycopy(x215,x169.toInt,x134.data.n_nationkey_114,x175.toInt,x214.toInt)
                  val x217 = x212.n_name_115
                  val x218 = System.arraycopy(x217,x169.toInt,x134.data.n_name_115,x175.toInt,x214.toInt)
                  val x219 = x212.n_regionkey_116
                  val x220 = System.arraycopy(x219,x169.toInt,x134.data.n_regionkey_116,x175.toInt,x214.toInt)
                  val x221 = x212.n_comment_117
                  val x222 = System.arraycopy(x221,x169.toInt,x134.data.n_comment_117,x175.toInt,x214.toInt)
                  val x223 = x134.size
                  val x224 = x223 + 1
                  val x225 = x134.size = x224
                  x225
                }
                val x227 = x227_block
                val x228 = x134.data
                val x230 = x134.data.n_nationkey_114(x169.toInt) = x157
                val x232 = x134.data.n_name_115(x169.toInt) = x160
                val x234 = x134.data.n_regionkey_116(x169.toInt) = x163
                val x236 = x134.data.n_comment_117(x169.toInt) = x166
                ()
              }
              val x238 = x238_block
              x238
            }
            val x240 = x240_block
            x240
          }
          val x242 = x242_block
          x277_size = x277_size + 1
        }
        x277_conditionals = x277_conditionals + 1
      }
      x121 = x121 + 1
    } // end fat loop x277
    var x134: generated.scala.TableAnon2060362663 = x277_buf
    x136 = x277_conditionals
    val x245 = x134.size = x136
    val x277 = x134
    val x278 = x277.size
    val x280 = x277.data
    val x283 = x280.n_name_115
    def x362_block = {
      true
    }
    val x362 = x362_block
    var x293: Int = x278
    var x297: Int = x293
    if (x293 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x298 = new Array[java.lang.String](x293.toInt)
    var x300: Array[java.lang.String] = x298
    val x301 = new generated.scala.DeliteArrayAnon1696572197(x300)
    val x302 = new generated.scala.TableAnon1696572197(x297,x301)
    val x380_data: generated.scala.TableAnon1696572197 = x302
    var x380_size: Int = 0
    var x380_conditionals: Int = 0
    var x279: Int = 0
    while (x279 < x278) {  // begin fat loop x380
      val x284 = x283(x279.toInt)
      val x290 = new generated.scala.Anon1696572197(x284)
      val x292 = x290
      val x291 = x380_data
      val x306 = x291.data
      val x308 = x292.n_name_115
      val x309 = x291.data.n_name_115(x279.toInt) = x308
      x279 = x279 + 1
    } // end fat loop x380
    val x291 = x380_data
    val x380 = x291
    val x381 = {
      TablePrinter.printAsTable(x380, 20)}
    ()
  }
}
/*****************************************
End of Generated Code
*******************************************/

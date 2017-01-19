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
    def x241_block = {
      true
    }
    val x241 = x241_block
    var x133: Int = 0
    var x137: Int = x133
    if (x133 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x138 = new Array[Int](x133.toInt)
    if (x133 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x139 = new Array[java.lang.String](x133.toInt)
    if (x133 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x140 = new Array[Int](x133.toInt)
    if (x133 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x141 = new Array[java.lang.String](x133.toInt)
    var x143: Array[Int] = x138
    var x144: Array[java.lang.String] = x139
    var x145: Array[Int] = x140
    var x146: Array[java.lang.String] = x141
    val x147 = new generated.scala.DeliteArrayAnon2060362663(x143,x144,x145,x146)
    val x148 = new generated.scala.TableAnon2060362663(x137,x147)
    var x274_buf: generated.scala.TableAnon2060362663 = x148
    var x274_size: Int = 0
    var x274_conditionals: Int = 0
    var x121: Int = 0
    while (x121 < x119) {  // begin fat loop x274
      val x122 = x118(x121.toInt)
      val x124 = x123(x121.toInt)
      val x126 = x125(x121.toInt)
      val x128 = x127(x121.toInt)
      val x129 = new generated.scala.Anon2060362663(x122,x124,x126,x128)
      val x130 = {
        x126 > 1337}
      if (x130) {
        val x131 = x274_buf
        val x132 = x129
        if (x241) {
          val x154 = x132.n_nationkey_114
          val x157 = x132.n_name_115
          val x160 = x132.n_regionkey_116
          val x163 = x132.n_comment_117
          def x239_block = {
            def x237_block = {
              val x166 = x131.size
              val x172 = x166 + 1
              def x235_block = {
                def x224_block = {
                  def x208_block = {
                    val x167 = x131.data
                    val x168 = x167.n_nationkey_114
                    val x169 = x168.length
                    val x170 = x169 - x166
                    val x171 = {
                      x170 < 1}
                    val x206 = {
                      def x206thenb(): Unit = {
                        val x173 = x169 * 2
                        val x174 = {
                          4 max x173}
                        val x191 = x167.n_name_115
                        val x193 = x167.n_regionkey_116
                        val x195 = x167.n_comment_117
                        def x204_block = {
                          var x175: Int = x174
                          val x183 = while ({
                            val x176 = x175
                            val x177 = {
                              x176 < x172}
                            x177}) {
                            val x179 = x175
                            val x180 = x179 * 2
                            x175 = x180
                            ()
                          }
                          val x184 = x175
                          if (x184 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x185 = new Array[Int](x184.toInt)
                          if (x184 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x186 = new Array[java.lang.String](x184.toInt)
                          if (x184 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x187 = new Array[Int](x184.toInt)
                          if (x184 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x188 = new Array[java.lang.String](x184.toInt)
                          val x190 = System.arraycopy(x168,0.toInt,x185,0.toInt,x166.toInt)
                          val x192 = System.arraycopy(x191,0.toInt,x186,0.toInt,x166.toInt)
                          val x194 = System.arraycopy(x193,0.toInt,x187,0.toInt,x166.toInt)
                          val x196 = System.arraycopy(x195,0.toInt,x188,0.toInt,x166.toInt)
                          val x197 = x185// unsafe immutable
                          val x198 = x186// unsafe immutable
                          val x199 = x187// unsafe immutable
                          val x200 = x188// unsafe immutable
                          val x201 = new generated.scala.DeliteArrayAnon2060362663(x197,x198,x199,x200)
                          val x202 = x131.data = x201
                          x202
                        }
                        val x204 = x204_block
                        x204
                      }
                      if (x171) {
                        x206thenb()
                      }
                    }
                    x206
                  }
                  val x208 = x208_block
                  val x209 = x131.data
                  val x210 = x131.size
                  val x211 = x210 - x166
                  val x212 = x209.n_nationkey_114
                  val x213 = System.arraycopy(x212,x166.toInt,x131.data.n_nationkey_114,x172.toInt,x211.toInt)
                  val x214 = x209.n_name_115
                  val x215 = System.arraycopy(x214,x166.toInt,x131.data.n_name_115,x172.toInt,x211.toInt)
                  val x216 = x209.n_regionkey_116
                  val x217 = System.arraycopy(x216,x166.toInt,x131.data.n_regionkey_116,x172.toInt,x211.toInt)
                  val x218 = x209.n_comment_117
                  val x219 = System.arraycopy(x218,x166.toInt,x131.data.n_comment_117,x172.toInt,x211.toInt)
                  val x220 = x131.size
                  val x221 = x220 + 1
                  val x222 = x131.size = x221
                  x222
                }
                val x224 = x224_block
                val x225 = x131.data
                val x227 = x131.data.n_nationkey_114(x166.toInt) = x154
                val x229 = x131.data.n_name_115(x166.toInt) = x157
                val x231 = x131.data.n_regionkey_116(x166.toInt) = x160
                val x233 = x131.data.n_comment_117(x166.toInt) = x163
                ()
              }
              val x235 = x235_block
              x235
            }
            val x237 = x237_block
            x237
          }
          val x239 = x239_block
          x274_size = x274_size + 1
        }
        x274_conditionals = x274_conditionals + 1
      }
      x121 = x121 + 1
    } // end fat loop x274
    var x131: generated.scala.TableAnon2060362663 = x274_buf
    x133 = x274_conditionals
    val x242 = x131.size = x133
    val x274 = x131
    val x275 = x274.size
    val x277 = x274.data
    val x280 = x277.n_name_115
    def x359_block = {
      true
    }
    val x359 = x359_block
    var x290: Int = x275
    var x294: Int = x290
    if (x290 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x295 = new Array[java.lang.String](x290.toInt)
    var x297: Array[java.lang.String] = x295
    val x298 = new generated.scala.DeliteArrayAnon1696572197(x297)
    val x299 = new generated.scala.TableAnon1696572197(x294,x298)
    val x377_data: generated.scala.TableAnon1696572197 = x299
    var x377_size: Int = 0
    var x377_conditionals: Int = 0
    var x276: Int = 0
    while (x276 < x275) {  // begin fat loop x377
      val x281 = x280(x276.toInt)
      val x287 = new generated.scala.Anon1696572197(x281)
      val x289 = x287
      val x288 = x377_data
      val x303 = x288.data
      val x305 = x289.n_name_115
      val x306 = x288.data.n_name_115(x276.toInt) = x305
      x276 = x276 + 1
    } // end fat loop x377
    val x288 = x377_data
    val x377 = x288
    val x378 = {
      TablePrinter.printAsTable(x377, 20)}
    ()
  }
}
/*****************************************
End of Generated Code
*******************************************/

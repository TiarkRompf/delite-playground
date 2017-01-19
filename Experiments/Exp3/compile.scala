/*****************************************
Emitting Generated Code
*******************************************/
package generated.scala
class  extends ((Array[java.lang.String])=>(Unit)) {
  def apply(x0:Array[java.lang.String]): Unit = {
    val x1 = generated.scala.io.DeliteFileInputStream(Seq("/home/greg/Research/data/SF1/nation.tbl"), None, None,0L)
    val x2 = x1.size
    var x15: Int = 0
    if (x15 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x19 = new Array[Int](x15.toInt)
    if (x15 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x20 = new Array[java.lang.String](x15.toInt)
    if (x15 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x21 = new Array[Int](x15.toInt)
    if (x15 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x22 = new Array[java.lang.String](x15.toInt)
    val x23 = new generated.scala.DeliteArrayAnon2060362663(x19,x20,x21,x22)
    var x116_buf: generated.scala.DeliteArrayAnon2060362663 = x23
    var x116_size: Int = 0
    var x116_conditionals: Int = 0
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
      val x9 = x5(2.toInt)
      val x10 = {
        x9.toInt}
      val x11 = x5(3.toInt)
      val x12 = new generated.scala.Anon2060362663(x7,x8,x10,x11)
      val x13 = x116_buf
      val x14 = x12
      if (true) {
        val x40 = x116_size
        val x41 = x13.n_nationkey_114
        val x42 = x41.length
        val x43 = x42 - 1
        val x44 = x40 > x43
        val x76 = {
          def x76thenb(): Unit = {
            val x45 = x42 < 16
            val x49 = {
              def x49thenb(): Int = {
                16
              }
              def x49elseb(): Int = {
                val x46 = x42 * 2
                val x47 = x46 < 0
                val x48 = {
                  def x48thenb(): Int = {
                    2147483647
                  }
                  def x48elseb(): Int = {
                    x46
                  }
                  if (x47) {
                    x48thenb()
                  } else {
                    x48elseb()
                  }
                }
                x48
              }
              if (x45) {
                x49thenb()
              } else {
                x49elseb()
              }
            }
            if (x49 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x50 = new Array[Int](x49.toInt)
            if (x49 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x51 = new Array[java.lang.String](x49.toInt)
            if (x49 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x52 = new Array[Int](x49.toInt)
            if (x49 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
            val x53 = new Array[java.lang.String](x49.toInt)
            val x55 = System.arraycopy(x41,0.toInt,x50,0.toInt,x42.toInt)
            val x56 = x13.n_name_115
            val x57 = System.arraycopy(x56,0.toInt,x51,0.toInt,x42.toInt)
            val x58 = x13.n_regionkey_116
            val x59 = System.arraycopy(x58,0.toInt,x52,0.toInt,x42.toInt)
            val x60 = x13.n_comment_117
            val x61 = System.arraycopy(x60,0.toInt,x53,0.toInt,x42.toInt)
            val x28 = x14.n_nationkey_114
            val x62 = x50(x40.toInt) = x28
            val x31 = x14.n_name_115
            val x63 = x51(x40.toInt) = x31
            val x34 = x14.n_regionkey_116
            val x64 = x52(x40.toInt) = x34
            val x37 = x14.n_comment_117
            val x65 = x53(x40.toInt) = x37
            val x54 = new generated.scala.DeliteArrayAnon2060362663(x50,x51,x52,x53)
            val x66 = x116_buf = x54
            x66
          }
          def x76elseb(): Unit = {
            val x28 = x14.n_nationkey_114
            val x68 = x13.n_nationkey_114(x40.toInt) = x28
            val x69 = x13.n_name_115
            val x31 = x14.n_name_115
            val x70 = x13.n_name_115(x40.toInt) = x31
            val x71 = x13.n_regionkey_116
            val x34 = x14.n_regionkey_116
            val x72 = x13.n_regionkey_116(x40.toInt) = x34
            val x73 = x13.n_comment_117
            val x37 = x14.n_comment_117
            val x74 = x13.n_comment_117(x40.toInt) = x37
            ()
          }
          if (x44) {
            x76thenb()
          } else {
            x76elseb()
          }
        }
        x116_size = x116_size + 1
      }
      x116_conditionals = x116_conditionals + 1
      x3 = x3 + 1
    } // end fat loop x116
    x1_stream.close();
    var x13: generated.scala.DeliteArrayAnon2060362663 = x116_buf
    x15 = x116_conditionals
    val x78 = x13.n_nationkey_114
    val x79 = x78.length
    val x80 = x79 > x15
    val x95 = {
      def x95thenb(): Unit = {
        if (x15 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x81 = new Array[Int](x15.toInt)
        if (x15 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x82 = new Array[java.lang.String](x15.toInt)
        if (x15 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x83 = new Array[Int](x15.toInt)
        if (x15 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x84 = new Array[java.lang.String](x15.toInt)
        val x86 = System.arraycopy(x78,0.toInt,x81,0.toInt,x15.toInt)
        val x87 = x13.n_name_115
        val x88 = System.arraycopy(x87,0.toInt,x82,0.toInt,x15.toInt)
        val x89 = x13.n_regionkey_116
        val x90 = System.arraycopy(x89,0.toInt,x83,0.toInt,x15.toInt)
        val x91 = x13.n_comment_117
        val x92 = System.arraycopy(x91,0.toInt,x84,0.toInt,x15.toInt)
        val x85 = new generated.scala.DeliteArrayAnon2060362663(x81,x82,x83,x84)
        val x93 = x13 = x85
        x93
      }
      if (x80) {
        x95thenb()
      }
    }
    val x116 = x13
    val x117 = x116.n_nationkey_114
    val x118 = x117.length
    val x122 = x116.n_name_115
    val x124 = x116.n_regionkey_116
    val x126 = x116.n_comment_117
    def x240_block = {
      true
    }
    val x240 = x240_block
    var x132: Int = 0
    var x136: Int = x132
    if (x132 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x137 = new Array[Int](x132.toInt)
    if (x132 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x138 = new Array[java.lang.String](x132.toInt)
    if (x132 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x139 = new Array[Int](x132.toInt)
    if (x132 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x140 = new Array[java.lang.String](x132.toInt)
    var x142: Array[Int] = x137
    var x143: Array[java.lang.String] = x138
    var x144: Array[Int] = x139
    var x145: Array[java.lang.String] = x140
    val x146 = new generated.scala.DeliteArrayAnon2060362663(x142,x143,x144,x145)
    val x147 = new generated.scala.TableAnon2060362663(x136,x146)
    var x273_buf: generated.scala.TableAnon2060362663 = x147
    var x273_size: Int = 0
    var x273_conditionals: Int = 0
    var x120: Int = 0
    while (x120 < x118) {  // begin fat loop x273
      val x121 = x117(x120.toInt)
      val x123 = x122(x120.toInt)
      val x125 = x124(x120.toInt)
      val x127 = x126(x120.toInt)
      val x128 = new generated.scala.Anon2060362663(x121,x123,x125,x127)
      val x129 = {
        x125 > 0}
      if (x129) {
        val x130 = x273_buf
        val x131 = x128
        if (x240) {
          val x153 = x131.n_nationkey_114
          val x156 = x131.n_name_115
          val x159 = x131.n_regionkey_116
          val x162 = x131.n_comment_117
          def x238_block = {
            def x236_block = {
              val x165 = x130.size
              val x171 = x165 + 1
              def x234_block = {
                def x223_block = {
                  def x207_block = {
                    val x166 = x130.data
                    val x167 = x166.n_nationkey_114
                    val x168 = x167.length
                    val x169 = x168 - x165
                    val x170 = {
                      x169 < 1}
                    val x205 = {
                      def x205thenb(): Unit = {
                        val x172 = x168 * 2
                        val x173 = {
                          4 max x172}
                        val x190 = x166.n_name_115
                        val x192 = x166.n_regionkey_116
                        val x194 = x166.n_comment_117
                        def x203_block = {
                          var x174: Int = x173
                          val x182 = while ({
                            val x175 = x174
                            val x176 = {
                              x175 < x171}
                            x176}) {
                            val x178 = x174
                            val x179 = x178 * 2
                            x174 = x179
                            ()
                          }
                          val x183 = x174
                          if (x183 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x184 = new Array[Int](x183.toInt)
                          if (x183 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x185 = new Array[java.lang.String](x183.toInt)
                          if (x183 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x186 = new Array[Int](x183.toInt)
                          if (x183 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
                          val x187 = new Array[java.lang.String](x183.toInt)
                          val x189 = System.arraycopy(x167,0.toInt,x184,0.toInt,x165.toInt)
                          val x191 = System.arraycopy(x190,0.toInt,x185,0.toInt,x165.toInt)
                          val x193 = System.arraycopy(x192,0.toInt,x186,0.toInt,x165.toInt)
                          val x195 = System.arraycopy(x194,0.toInt,x187,0.toInt,x165.toInt)
                          val x196 = x184// unsafe immutable
                          val x197 = x185// unsafe immutable
                          val x198 = x186// unsafe immutable
                          val x199 = x187// unsafe immutable
                          val x200 = new generated.scala.DeliteArrayAnon2060362663(x196,x197,x198,x199)
                          val x201 = x130.data = x200
                          x201
                        }
                        val x203 = x203_block
                        x203
                      }
                      if (x170) {
                        x205thenb()
                      }
                    }
                    x205
                  }
                  val x207 = x207_block
                  val x208 = x130.data
                  val x209 = x130.size
                  val x210 = x209 - x165
                  val x211 = x208.n_nationkey_114
                  val x212 = System.arraycopy(x211,x165.toInt,x130.data.n_nationkey_114,x171.toInt,x210.toInt)
                  val x213 = x208.n_name_115
                  val x214 = System.arraycopy(x213,x165.toInt,x130.data.n_name_115,x171.toInt,x210.toInt)
                  val x215 = x208.n_regionkey_116
                  val x216 = System.arraycopy(x215,x165.toInt,x130.data.n_regionkey_116,x171.toInt,x210.toInt)
                  val x217 = x208.n_comment_117
                  val x218 = System.arraycopy(x217,x165.toInt,x130.data.n_comment_117,x171.toInt,x210.toInt)
                  val x219 = x130.size
                  val x220 = x219 + 1
                  val x221 = x130.size = x220
                  x221
                }
                val x223 = x223_block
                val x224 = x130.data
                val x226 = x130.data.n_nationkey_114(x165.toInt) = x153
                val x228 = x130.data.n_name_115(x165.toInt) = x156
                val x230 = x130.data.n_regionkey_116(x165.toInt) = x159
                val x232 = x130.data.n_comment_117(x165.toInt) = x162
                ()
              }
              val x234 = x234_block
              x234
            }
            val x236 = x236_block
            x236
          }
          val x238 = x238_block
          x273_size = x273_size + 1
        }
        x273_conditionals = x273_conditionals + 1
      }
      x120 = x120 + 1
    } // end fat loop x273
    var x130: generated.scala.TableAnon2060362663 = x273_buf
    x132 = x273_conditionals
    val x241 = x130.size = x132
    val x273 = x130
    val x274 = x273.size
    val x276 = x273.data
    val x281 = x276.n_regionkey_116
    def x358_block = {
      true
    }
    val x358 = x358_block
    var x289: Int = x274
    var x293: Int = x289
    if (x289 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x294 = new Array[Int](x289.toInt)
    var x296: Array[Int] = x294
    val x297 = new generated.scala.DeliteArrayAnon1022047691(x296)
    val x298 = new generated.scala.TableAnon1022047691(x293,x297)
    val x376_data: generated.scala.TableAnon1022047691 = x298
    var x376_size: Int = 0
    var x376_conditionals: Int = 0
    var x275: Int = 0
    while (x275 < x274) {  // begin fat loop x376
      val x282 = x281(x275.toInt)
      val x286 = new generated.scala.Anon1022047691(x282)
      val x288 = x286
      val x287 = x376_data
      val x302 = x287.data
      val x304 = x288.n_regionkey_116
      val x305 = x287.data.n_regionkey_116(x275.toInt) = x304
      x275 = x275 + 1
    } // end fat loop x376
    val x287 = x376_data
    val x376 = x287
    val x378 = x376.size
    val x377 = x376.data
    val x381 = x377.n_regionkey_116
    val x786 = {
      null.asInstanceOf[Null].asInstanceOf[generated.scala.Anon46814458]}
    var x861_hash_pos: generated.scala.container.HashMapImpl[Int] = new generated.scala.container.HashMapImpl[Int](512,128)
    var x796: Int = 128
    if (x796 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x799 = new Array[Int](x796.toInt)
    if (x796 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x800 = new Array[Int](x796.toInt)
    val x801 = new generated.scala.DeliteArrayAnon46814458(x799,x800)
    var x861_hash_data: generated.scala.DeliteArrayAnon46814458 = x801
    var x782: Int = 0
    while (x782 < x378) {  // begin fat loop x861
      val x783 = x381(x782.toInt)
      val x785 = new generated.scala.Anon46814458(x783,1)
      if (true) {
        // common key Block(Sym(783)) for x861
        val x861_sze: Int = x861_hash_pos.size
        val x861_idx: Int = x861_hash_pos.put(x783)
        if (x861_idx == x861_sze) { // new key
          val x798: generated.scala.DeliteArrayAnon46814458 = x861_hash_data
          val x795: generated.scala.Anon46814458 = x785
          val x818 = x861_sze
          val x819 = x798.n_regionkey_116
          val x820 = x819.length
          val x821 = x820 - 1
          val x822 = x818 > x821
          val x842 = {
            def x842thenb(): Unit = {
              val x823 = x820 < 16
              val x827 = {
                def x827thenb(): Int = {
                  16
                }
                def x827elseb(): Int = {
                  val x824 = x820 * 2
                  val x825 = x824 < 0
                  val x826 = {
                    def x826thenb(): Int = {
                      2147483647
                    }
                    def x826elseb(): Int = {
                      x824
                    }
                    if (x825) {
                      x826thenb()
                    } else {
                      x826elseb()
                    }
                  }
                  x826
                }
                if (x823) {
                  x827thenb()
                } else {
                  x827elseb()
                }
              }
              if (x827 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x828 = new Array[Int](x827.toInt)
              if (x827 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
              val x829 = new Array[Int](x827.toInt)
              val x831 = System.arraycopy(x819,0.toInt,x828,0.toInt,x820.toInt)
              val x832 = x798.count1_143
              val x833 = System.arraycopy(x832,0.toInt,x829,0.toInt,x820.toInt)
              val x810 = x795.n_regionkey_116
              val x834 = x828(x818.toInt) = x810
              val x813 = x795.count1_143
              val x835 = x829(x818.toInt) = x813
              val x830 = new generated.scala.DeliteArrayAnon46814458(x828,x829)
              val x836 = x861_hash_data = x830
              x836
            }
            def x842elseb(): Unit = {
              val x810 = x795.n_regionkey_116
              val x838 = x798.n_regionkey_116(x818.toInt) = x810
              val x839 = x798.count1_143
              val x813 = x795.count1_143
              val x840 = x798.count1_143(x818.toInt) = x813
              ()
            }
            if (x822) {
              x842thenb()
            } else {
              x842elseb()
            }
          }
        } else { // existing key
          val x797: Int = x861_idx
          val x798: generated.scala.DeliteArrayAnon46814458 = x861_hash_data
          val x803 = x798.n_regionkey_116
          val x805 = x798.count1_143
          val x804 = x803(x797.toInt)
          val x806 = x805(x797.toInt)
          val x807 = new generated.scala.Anon46814458(x804,x806)
          val x787: generated.scala.Anon46814458 = x807
          val x788: generated.scala.Anon46814458 = x785
          val x789 = x787.n_regionkey_116
          val x791 = x787.count1_143
          val x792 = x788.count1_143
          val x793 = {
            x791 + x792}
          val x794 = new generated.scala.Anon46814458(x789,x793)
          val x795: generated.scala.Anon46814458 = x794
          val x809 = x798.n_regionkey_116
          val x810 = x795.n_regionkey_116
          val x811 = x798.n_regionkey_116(x797.toInt) = x810
          val x812 = x798.count1_143
          val x813 = x795.count1_143
          val x814 = x798.count1_143(x797.toInt) = x813
        }
      }
      x782 = x782 + 1
    } // end fat loop x861
    val x861_sze: Int = x861_hash_pos.size
    var x798: generated.scala.DeliteArrayAnon46814458 = x861_hash_data
    x796 = x861_sze
    val x844 = x798.n_regionkey_116
    val x845 = x844.length
    val x846 = x845 > x796
    val x855 = {
      def x855thenb(): Unit = {
        if (x796 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x847 = new Array[Int](x796.toInt)
        if (x796 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
        val x848 = new Array[Int](x796.toInt)
        val x850 = System.arraycopy(x844,0.toInt,x847,0.toInt,x796.toInt)
        val x851 = x798.count1_143
        val x852 = System.arraycopy(x851,0.toInt,x848,0.toInt,x796.toInt)
        val x849 = new generated.scala.DeliteArrayAnon46814458(x847,x848)
        val x853 = x798 = x849
        x853
      }
      if (x846) {
        x855thenb()
      }
    }
    val x861: generated.scala.DeliteArrayAnon46814458 = x798
    val x862 = x861.n_regionkey_116
    val x863 = x862.length
    val x972 = x861.count1_143
    def x1060_block = {
      true
    }
    val x1060 = x1060_block
    var x978: Int = x863
    var x982: Int = x978
    if (x978 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x983 = new Array[Int](x978.toInt)
    if (x978 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x984 = new Array[Int](x978.toInt)
    var x986: Array[Int] = x983
    var x987: Array[Int] = x984
    val x988 = new generated.scala.DeliteArrayAnon46814458(x986,x987)
    val x989 = new generated.scala.TableAnon46814458(x982,x988)
    val x1083_data: generated.scala.TableAnon46814458 = x989
    var x1083_size: Int = 0
    var x1083_conditionals: Int = 0
    var x970: Int = 0
    while (x970 < x863) {  // begin fat loop x1083
      val x971 = x862(x970.toInt)
      val x973 = x972(x970.toInt)
      val x974 = new generated.scala.Anon46814458(x971,x973)
      val x977 = x974
      val x976 = x1083_data
      val x993 = x976.data
      val x995 = x977.n_regionkey_116
      val x996 = x976.data.n_regionkey_116(x970.toInt) = x995
      val x998 = x977.count1_143
      val x999 = x976.data.count1_143(x970.toInt) = x998
      x970 = x970 + 1
    } // end fat loop x1083
    val x976 = x1083_data
    val x1083 = x976
    val x1084 = x1083.size
    val x1086 = x1083.data
    val x1087 = x1086.n_regionkey_116
    val x1089 = x1086.count1_143
    def x1176_block = {
      true
    }
    val x1176 = x1176_block
    var x1094: Int = x1084
    var x1098: Int = x1094
    if (x1094 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1099 = new Array[Int](x1094.toInt)
    if (x1094 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
    val x1100 = new Array[Long](x1094.toInt)
    var x1102: Array[Int] = x1099
    var x1103: Array[Long] = x1100
    val x1104 = new generated.scala.DeliteArrayAnon49491876(x1102,x1103)
    val x1105 = new generated.scala.TableAnon49491876(x1098,x1104)
    val x1199_data: generated.scala.TableAnon49491876 = x1105
    var x1199_size: Int = 0
    var x1199_conditionals: Int = 0
    var x1085: Int = 0
    while (x1085 < x1084) {  // begin fat loop x1199
      val x1088 = x1087(x1085.toInt)
      val x1090 = x1089(x1085.toInt)
      val x1091 = new generated.scala.Anon49491876(x1088,x1090)
      val x1093 = x1091
      val x1092 = x1199_data
      val x1109 = x1092.data
      val x1111 = x1093.n_regionkey_116
      val x1112 = x1092.data.n_regionkey_116(x1085.toInt) = x1111
      val x1114 = x1093.count1_143
      val x1115 = x1092.data.count1_143(x1085.toInt) = x1114
      x1085 = x1085 + 1
    } // end fat loop x1199
    val x1092 = x1199_data
    val x1199 = x1092
    val x1200 = {
      TablePrinter.printAsTable(x1199, 20)}
    ()
  }
}
/*****************************************
End of Generated Code
*******************************************/

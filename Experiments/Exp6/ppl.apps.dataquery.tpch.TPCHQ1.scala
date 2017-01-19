/*****************************************
  Emitting Generated Code                  
*******************************************/
package generated.scala
class  extends ((Array[java.lang.String])=>(Unit)) {
def apply(x0:Array[java.lang.String]): Unit = {
val x1 = println("TPC-H Q1")
val x2 = x0.length
val x3 = x2 < 1
val x7 = {
def x7thenb(): Nothing = {
val x4 = println("Usage: TPCHQ## <input directory>")
val x5 = sys.exit(-1)
x5
}
if (x3) {
x7thenb()
}
}
val x8 = x0(0)
val x9 = x8+"/lineitem.tbl"
val x10 = generated.scala.io.DeliteFileInputStream(Seq(x9), None, None,0L)
val x11 = x10.size
var x78: Int = 0
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x82 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x83 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x84 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x85 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x86 = new Array[Double](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x87 = new Array[Double](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x88 = new Array[Double](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x89 = new Array[Double](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x90 = new Array[Char](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x91 = new Array[Char](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x92 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x93 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x94 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x95 = new Array[java.lang.String](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x96 = new Array[java.lang.String](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x97 = new Array[java.lang.String](x78.toInt)
val x98 = new generated.scala.DeliteArrayAnon1327827276(x82,x83,x84,x85,x86,x87,x88,x89,x90,x91,x92,x93,x94,x95,x96,x97)
var x383_buf: generated.scala.DeliteArrayAnon1327827276 = x98
var x383_size: Int = 0
var x383_conditionals: Int = 0
var x12: Int = 0
val x10_stream: generated.scala.io.DeliteFileInputStream = x10.openCopyAtNewLine(0,x11)
while (!x10_stream.isEmpty() ) {
val x13 = x10_stream.readLine()
val x15 = x13.split("\\|",-1)
val x16 = x15(0)
val x17 = java.lang.Integer.parseInt(x16)
val x18 = x15(1)
val x19 = java.lang.Integer.parseInt(x18)
val x20 = x15(2)
val x21 = java.lang.Integer.parseInt(x20)
val x22 = x15(3)
val x23 = java.lang.Integer.parseInt(x22)
val x24 = x15(4)
val x25 = java.lang.Double.parseDouble(x24)
val x26 = x15(5)
val x27 = java.lang.Double.parseDouble(x26)
val x28 = x15(6)
val x29 = java.lang.Double.parseDouble(x28)
val x30 = x15(7)
val x31 = java.lang.Double.parseDouble(x30)
val x32 = x15(8)
val x33 = x32.charAt(0)
val x34 = x15(9)
val x35 = x34.charAt(0)
val x36 = x15(10)
val x37 = x36.split("-",0)
val x42 = x37(2)
val x43 = java.lang.Integer.parseInt(x42)
val x38 = x37(0)
val x39 = java.lang.Integer.parseInt(x38)
val x44 = x39 << 9
val x40 = x37(1)
val x41 = java.lang.Integer.parseInt(x40)
val x45 = x41 << 5
val x46 = x44 + x45
val x47 = x46 + x43
val x48 = x15(11)
val x49 = x48.split("-",0)
val x54 = x49(2)
val x55 = java.lang.Integer.parseInt(x54)
val x50 = x49(0)
val x51 = java.lang.Integer.parseInt(x50)
val x56 = x51 << 9
val x52 = x49(1)
val x53 = java.lang.Integer.parseInt(x52)
val x57 = x53 << 5
val x58 = x56 + x57
val x59 = x58 + x55
val x60 = x15(12)
val x61 = x60.split("-",0)
val x66 = x61(2)
val x67 = java.lang.Integer.parseInt(x66)
val x62 = x61(0)
val x63 = java.lang.Integer.parseInt(x62)
val x68 = x63 << 9
val x64 = x61(1)
val x65 = java.lang.Integer.parseInt(x64)
val x69 = x65 << 5
val x70 = x68 + x69
val x71 = x70 + x67
val x72 = x15(13)
val x73 = x15(14)
val x74 = x15(15)
val x75 = new generated.scala.Anon1327827276(x17,x19,x21,x23,x25,x27,x29,x31,x33,x35,x47,x59,x71,x72,x73,x74)
val x76 = x383_buf
val x77 = x75
if (true) {
val x151 = x383_size
val x152 = x76.l_orderkey
val x153 = x152.length
val x154 = x153 - 1
val x155 = x151 > x154
val x259 = {
def x259thenb(): Unit = {
val x156 = x153 < 16
val x160 = {
def x160thenb(): Int = {
16
}
def x160elseb(): Int = {
val x157 = x153 * 2
val x158 = x157 < 0
val x159 = {
def x159thenb(): Int = {
2147483647
}
def x159elseb(): Int = {
x157
}
if (x158) {
x159thenb()
} else { 
x159elseb()
}
}
x159
}
if (x156) {
x160thenb()
} else { 
x160elseb()
}
}
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x161 = new Array[Int](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x162 = new Array[Int](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x163 = new Array[Int](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x164 = new Array[Int](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x165 = new Array[Double](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x166 = new Array[Double](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x167 = new Array[Double](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x168 = new Array[Double](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x169 = new Array[Char](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x170 = new Array[Char](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x171 = new Array[Int](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x172 = new Array[Int](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x173 = new Array[Int](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x174 = new Array[java.lang.String](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x175 = new Array[java.lang.String](x160.toInt)
if (x160 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x176 = new Array[java.lang.String](x160.toInt)
val x178 = System.arraycopy(x152,0.toInt,x161,0.toInt,x153.toInt)
val x179 = x76.l_partkey
val x180 = System.arraycopy(x179,0.toInt,x162,0.toInt,x153.toInt)
val x181 = x76.l_suppkey
val x182 = System.arraycopy(x181,0.toInt,x163,0.toInt,x153.toInt)
val x183 = x76.l_linenumber
val x184 = System.arraycopy(x183,0.toInt,x164,0.toInt,x153.toInt)
val x185 = x76.l_quantity
val x186 = System.arraycopy(x185,0.toInt,x165,0.toInt,x153.toInt)
val x187 = x76.l_extendedprice
val x188 = System.arraycopy(x187,0.toInt,x166,0.toInt,x153.toInt)
val x189 = x76.l_discount
val x190 = System.arraycopy(x189,0.toInt,x167,0.toInt,x153.toInt)
val x191 = x76.l_tax
val x192 = System.arraycopy(x191,0.toInt,x168,0.toInt,x153.toInt)
val x193 = x76.l_returnflag
val x194 = System.arraycopy(x193,0.toInt,x169,0.toInt,x153.toInt)
val x195 = x76.l_linestatus
val x196 = System.arraycopy(x195,0.toInt,x170,0.toInt,x153.toInt)
val x197 = x76.l_shipdate
val x198 = System.arraycopy(x197,0.toInt,x171,0.toInt,x153.toInt)
val x199 = x76.l_commitdate
val x200 = System.arraycopy(x199,0.toInt,x172,0.toInt,x153.toInt)
val x201 = x76.l_receiptdate
val x202 = System.arraycopy(x201,0.toInt,x173,0.toInt,x153.toInt)
val x203 = x76.l_shipinstruct
val x204 = System.arraycopy(x203,0.toInt,x174,0.toInt,x153.toInt)
val x205 = x76.l_shipmode
val x206 = System.arraycopy(x205,0.toInt,x175,0.toInt,x153.toInt)
val x207 = x76.l_comment
val x208 = System.arraycopy(x207,0.toInt,x176,0.toInt,x153.toInt)
val x103 = x77.l_orderkey
val x209 = x161(x151.toInt) = x103
val x106 = x77.l_partkey
val x210 = x162(x151.toInt) = x106
val x109 = x77.l_suppkey
val x211 = x163(x151.toInt) = x109
val x112 = x77.l_linenumber
val x212 = x164(x151.toInt) = x112
val x115 = x77.l_quantity
val x213 = x165(x151.toInt) = x115
val x118 = x77.l_extendedprice
val x214 = x166(x151.toInt) = x118
val x121 = x77.l_discount
val x215 = x167(x151.toInt) = x121
val x124 = x77.l_tax
val x216 = x168(x151.toInt) = x124
val x127 = x77.l_returnflag
val x217 = x169(x151.toInt) = x127
val x130 = x77.l_linestatus
val x218 = x170(x151.toInt) = x130
val x133 = x77.l_shipdate
val x219 = x171(x151.toInt) = x133
val x136 = x77.l_commitdate
val x220 = x172(x151.toInt) = x136
val x139 = x77.l_receiptdate
val x221 = x173(x151.toInt) = x139
val x142 = x77.l_shipinstruct
val x222 = x174(x151.toInt) = x142
val x145 = x77.l_shipmode
val x223 = x175(x151.toInt) = x145
val x148 = x77.l_comment
val x224 = x176(x151.toInt) = x148
val x177 = new generated.scala.DeliteArrayAnon1327827276(x161,x162,x163,x164,x165,x166,x167,x168,x169,x170,x171,x172,x173,x174,x175,x176)
val x225 = x383_buf = x177
x225
}
def x259elseb(): Unit = {
val x103 = x77.l_orderkey
val x227 = x76.l_orderkey(x151.toInt) = x103
val x228 = x76.l_partkey
val x106 = x77.l_partkey
val x229 = x76.l_partkey(x151.toInt) = x106
val x230 = x76.l_suppkey
val x109 = x77.l_suppkey
val x231 = x76.l_suppkey(x151.toInt) = x109
val x232 = x76.l_linenumber
val x112 = x77.l_linenumber
val x233 = x76.l_linenumber(x151.toInt) = x112
val x234 = x76.l_quantity
val x115 = x77.l_quantity
val x235 = x76.l_quantity(x151.toInt) = x115
val x236 = x76.l_extendedprice
val x118 = x77.l_extendedprice
val x237 = x76.l_extendedprice(x151.toInt) = x118
val x238 = x76.l_discount
val x121 = x77.l_discount
val x239 = x76.l_discount(x151.toInt) = x121
val x240 = x76.l_tax
val x124 = x77.l_tax
val x241 = x76.l_tax(x151.toInt) = x124
val x242 = x76.l_returnflag
val x127 = x77.l_returnflag
val x243 = x76.l_returnflag(x151.toInt) = x127
val x244 = x76.l_linestatus
val x130 = x77.l_linestatus
val x245 = x76.l_linestatus(x151.toInt) = x130
val x246 = x76.l_shipdate
val x133 = x77.l_shipdate
val x247 = x76.l_shipdate(x151.toInt) = x133
val x248 = x76.l_commitdate
val x136 = x77.l_commitdate
val x249 = x76.l_commitdate(x151.toInt) = x136
val x250 = x76.l_receiptdate
val x139 = x77.l_receiptdate
val x251 = x76.l_receiptdate(x151.toInt) = x139
val x252 = x76.l_shipinstruct
val x142 = x77.l_shipinstruct
val x253 = x76.l_shipinstruct(x151.toInt) = x142
val x254 = x76.l_shipmode
val x145 = x77.l_shipmode
val x255 = x76.l_shipmode(x151.toInt) = x145
val x256 = x76.l_comment
val x148 = x77.l_comment
val x257 = x76.l_comment(x151.toInt) = x148
()
}
if (x155) {
x259thenb()
} else { 
x259elseb()
}
}
x383_size = x383_size + 1
}
x383_conditionals = x383_conditionals + 1
x12 = x12 + 1
} // end fat loop x383
x10_stream.close();
var x76: generated.scala.DeliteArrayAnon1327827276 = x383_buf
x78 = x383_conditionals
val x261 = x76.l_orderkey
val x262 = x261.length
val x263 = x262 > x78
val x314 = {
def x314thenb(): Unit = {
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x264 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x265 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x266 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x267 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x268 = new Array[Double](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x269 = new Array[Double](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x270 = new Array[Double](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x271 = new Array[Double](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x272 = new Array[Char](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x273 = new Array[Char](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x274 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x275 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x276 = new Array[Int](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x277 = new Array[java.lang.String](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x278 = new Array[java.lang.String](x78.toInt)
if (x78 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x279 = new Array[java.lang.String](x78.toInt)
val x281 = System.arraycopy(x261,0.toInt,x264,0.toInt,x78.toInt)
val x282 = x76.l_partkey
val x283 = System.arraycopy(x282,0.toInt,x265,0.toInt,x78.toInt)
val x284 = x76.l_suppkey
val x285 = System.arraycopy(x284,0.toInt,x266,0.toInt,x78.toInt)
val x286 = x76.l_linenumber
val x287 = System.arraycopy(x286,0.toInt,x267,0.toInt,x78.toInt)
val x288 = x76.l_quantity
val x289 = System.arraycopy(x288,0.toInt,x268,0.toInt,x78.toInt)
val x290 = x76.l_extendedprice
val x291 = System.arraycopy(x290,0.toInt,x269,0.toInt,x78.toInt)
val x292 = x76.l_discount
val x293 = System.arraycopy(x292,0.toInt,x270,0.toInt,x78.toInt)
val x294 = x76.l_tax
val x295 = System.arraycopy(x294,0.toInt,x271,0.toInt,x78.toInt)
val x296 = x76.l_returnflag
val x297 = System.arraycopy(x296,0.toInt,x272,0.toInt,x78.toInt)
val x298 = x76.l_linestatus
val x299 = System.arraycopy(x298,0.toInt,x273,0.toInt,x78.toInt)
val x300 = x76.l_shipdate
val x301 = System.arraycopy(x300,0.toInt,x274,0.toInt,x78.toInt)
val x302 = x76.l_commitdate
val x303 = System.arraycopy(x302,0.toInt,x275,0.toInt,x78.toInt)
val x304 = x76.l_receiptdate
val x305 = System.arraycopy(x304,0.toInt,x276,0.toInt,x78.toInt)
val x306 = x76.l_shipinstruct
val x307 = System.arraycopy(x306,0.toInt,x277,0.toInt,x78.toInt)
val x308 = x76.l_shipmode
val x309 = System.arraycopy(x308,0.toInt,x278,0.toInt,x78.toInt)
val x310 = x76.l_comment
val x311 = System.arraycopy(x310,0.toInt,x279,0.toInt,x78.toInt)
val x280 = new generated.scala.DeliteArrayAnon1327827276(x264,x265,x266,x267,x268,x269,x270,x271,x272,x273,x274,x275,x276,x277,x278,x279)
val x312 = x76 = x280
x312
}
if (x263) {
x314thenb()
}
}
val x383 = x76
val x384 = x383.l_orderkey
val x385 = x384.length
val x387 = Seq(x385)
val x388 = ppl.delite.runtime.profiler.PerformanceTimer.start("app")
val x397 = x383.l_quantity
val x399 = x383.l_extendedprice
val x401 = x383.l_discount
val x403 = x383.l_tax
val x405 = x383.l_returnflag
val x407 = x383.l_linestatus
val x678 = 0.asInstanceOf[Int]
val x501 = 0.asInstanceOf[Double]
val x677 = 0.asInstanceOf[Char]
val x679 = new generated.scala.Anon201185238(x677,x677,x501,x501,x501,x501,x501,x501,x501,x678)
val x422 = "1998-12-01".split("-",0)
val x427 = x422(2)
val x428 = java.lang.Integer.parseInt(x427)
val x423 = x422(0)
val x424 = java.lang.Integer.parseInt(x423)
val x429 = x424 << 9
val x425 = x422(1)
val x426 = java.lang.Integer.parseInt(x425)
val x430 = x426 << 5
val x431 = x429 + x430
val x432 = x431 + x428
val x409 = x383.l_shipdate
var x753x1368_hash_pos: generated.scala.container.HashMapImpl[Int] = new generated.scala.container.HashMapImpl[Int](512,128)
var x712: Int = 128
val x716 = new generated.scala.TableAnon201185238(x715,x712)
var x753_hash_data: generated.scala.TableAnon201185238 = x716
var x778: Int = 128
val x782 = new generated.scala.TableInt(x781,x778)
var x1368_hash_data: generated.scala.TableInt = x782
var x652: Int = 0
while (x652 < x385) {  // begin fat loop x753,x1368
val x657 = x397(x652.toInt)
val x658 = x399(x652.toInt)
val x659 = x401(x652.toInt)
val x671 = 1.0 - x659
val x672 = x658 * x671
val x660 = x403(x652.toInt)
val x673 = 1.0 + x660
val x674 = x672 * x673
val x661 = x405(x652.toInt)
val x662 = x407(x652.toInt)
val x675 = new generated.scala.Anon201185238(x661,x662,x657,x658,x672,x674,x657,x658,x659,1)
val x670 = (x661.asInstanceOf[Int] << 0) + (x662.asInstanceOf[Int] << 16)
val x663 = x409(x652.toInt)
val x676 = x663 <= x432
if (x676) {
// common key Block(Sym(670)) for x753x1368
val x753x1368_sze: Int = x753x1368_hash_pos.size
val x753x1368_idx: Int = x753x1368_hash_pos.put(x670)
if (x753x1368_idx == x753x1368_sze) { // new key
val x714: generated.scala.TableAnon201185238 = x753_hash_data
val x711: generated.scala.Anon201185238 = x675
val x780: generated.scala.TableInt = x1368_hash_data
val x777: Int = 1
} else { // existing key
val x713: Int = x753x1368_idx
val x714: generated.scala.TableAnon201185238 = x753_hash_data
val x718 = x714.data
val x719 = x718.returnFlag
val x720 = x719(x713.toInt)
val x721 = x718.lineStatus
val x722 = x721(x713.toInt)
val x723 = x718.sumQty
val x724 = x723(x713.toInt)
val x725 = x718.sumBasePrice
val x726 = x725(x713.toInt)
val x727 = x718.sumDiscountedPrice
val x728 = x727(x713.toInt)
val x729 = x718.sumCharge
val x730 = x729(x713.toInt)
val x731 = x718.avgQty
val x732 = x731(x713.toInt)
val x733 = x718.avgPrice
val x734 = x733(x713.toInt)
val x735 = x718.avgDiscount
val x736 = x735(x713.toInt)
val x737 = x718.countOrder
val x738 = x737(x713.toInt)
val x739 = new generated.scala.Anon201185238(x720,x722,x724,x726,x728,x730,x732,x734,x736,x738)
val x680: generated.scala.Anon201185238 = x739
val x681: generated.scala.Anon201185238 = x675
val x682 = x680.returnFlag
val x684 = x680.lineStatus
val x686 = x680.sumQty
val x687 = x681.sumQty
val x688 = x686 + x687
val x689 = x680.sumBasePrice
val x690 = x681.sumBasePrice
val x691 = x689 + x690
val x692 = x680.sumDiscountedPrice
val x693 = x681.sumDiscountedPrice
val x694 = x692 + x693
val x695 = x680.sumCharge
val x696 = x681.sumCharge
val x697 = x695 + x696
val x698 = x680.avgQty
val x699 = x681.avgQty
val x700 = x698 + x699
val x701 = x680.avgPrice
val x702 = x681.avgPrice
val x703 = x701 + x702
val x704 = x680.avgDiscount
val x705 = x681.avgDiscount
val x706 = x704 + x705
val x707 = x680.countOrder
val x708 = x681.countOrder
val x709 = x707 + x708
val x710 = new generated.scala.Anon201185238(x682,x684,x688,x691,x694,x697,x700,x703,x706,x709)
val x711: generated.scala.Anon201185238 = x710
val x779: Int = x753x1368_idx
val x780: generated.scala.TableInt = x1368_hash_data
val x784 = x780.data
val x785 = x784(x779.toInt)
val x774: Int = x785
val x775: Int = 1
val x776 = x774 + x775
val x777: Int = x776
}
}
x652 = x652 + 1
} // end fat loop x753,x1368
val x753x1368_sze: Int = x753x1368_hash_pos.size
var x714: generated.scala.TableAnon201185238 = x753_hash_data
x712 = x753x1368_sze
val x753: generated.scala.TableAnon201185238 = x714
var x780: generated.scala.TableInt = x1368_hash_data
x778 = x753x1368_sze
val x1368: generated.scala.TableInt = x780
val x800 = x753.size
val x802 = x753.data
val x803 = x802.returnFlag
val x805 = x802.lineStatus
val x807 = x802.sumQty
val x809 = x802.sumBasePrice
val x811 = x802.sumDiscountedPrice
val x813 = x802.sumCharge
val x821 = x802.countOrder
val x815 = x802.avgQty
val x1369 = x1368.data
val x817 = x802.avgPrice
val x819 = x802.avgDiscount
var x832: Int = x800
val x837 = new generated.scala.TableAnon201185238(x836,x832)
val x1375_data: generated.scala.TableAnon201185238 = x837
var x1375_size: Int = 0
var x1375_conditionals: Int = 0
var x801: Int = 0
while (x801 < x800) {  // begin fat loop x1375
val x804 = x803(x801.toInt)
val x806 = x805(x801.toInt)
val x808 = x807(x801.toInt)
val x810 = x809(x801.toInt)
val x812 = x811(x801.toInt)
val x814 = x813(x801.toInt)
val x822 = x821(x801.toInt)
val x816 = x815(x801.toInt)
val x1370 = x1369(x801.toInt)
val x1371 = x816 / x1370
val x818 = x817(x801.toInt)
val x1372 = x818 / x1370
val x820 = x819(x801.toInt)
val x1373 = x820 / x1370
val x1374 = new generated.scala.Anon201185238(x804,x806,x808,x810,x812,x814,x1371,x1372,x1373,x822)
val x831 = x1374
val x830 = x1375_data
x801 = x801 + 1
} // end fat loop x1375
val x830 = x1375_data
val x1375 = x830
val x1376 = x1375.size
val x1377 = x1375.data
val x1378 = x1377.returnFlag
val x1383 = x1377.lineStatus
val x1388 = {
val len = x1376.toInt
val comp = new generated.scala.container.IntComparator {
def compare(o1: Int, o2: Int): Int = {
val x1114 = o1
val x1115 = o2
val x1379 = x1378(x1114.toInt)
val x1380 = x1378(x1115.toInt)
val x1381 = java.lang.Character.compare(x1379,x1380)
val x1382 = x1381 == 0
val x1387 = {
def x1387thenb(): Int = {
val x1384 = x1383(x1114.toInt)
val x1385 = x1383(x1115.toInt)
val x1386 = java.lang.Character.compare(x1384,x1385)
x1386
}
def x1387elseb(): Int = {
x1381
}
if (x1382) {
x1387thenb()
} else { 
x1387elseb()
}
}
x1387.toInt
} }
val d = new Array[Int](len)
var i = 0; while(i < len) { d(i) = i; i += 1 }
generated.scala.container.SortingImpl.sort(d,comp)
d
}
val x1392 = x1377.sumQty
val x1394 = x1377.sumBasePrice
val x1396 = x1377.sumDiscountedPrice
val x1398 = x1377.sumCharge
val x1400 = x1377.avgQty
val x1402 = x1377.avgPrice
val x1404 = x1377.avgDiscount
val x1406 = x1377.countOrder
var x1158: Int = x1376
if (x1158 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1162 = new Array[Char](x1158.toInt)
if (x1158 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1163 = new Array[Char](x1158.toInt)
if (x1158 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1164 = new Array[Double](x1158.toInt)
if (x1158 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1165 = new Array[Double](x1158.toInt)
if (x1158 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1166 = new Array[Double](x1158.toInt)
if (x1158 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1167 = new Array[Double](x1158.toInt)
if (x1158 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1168 = new Array[Double](x1158.toInt)
if (x1158 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1169 = new Array[Double](x1158.toInt)
if (x1158 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1170 = new Array[Double](x1158.toInt)
if (x1158 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1171 = new Array[Int](x1158.toInt)
val x1172 = new generated.scala.DeliteArrayAnon201185238(x1162,x1163,x1164,x1165,x1166,x1167,x1168,x1169,x1170,x1171)
val x1409_data: generated.scala.DeliteArrayAnon201185238 = x1172
var x1409_size: Int = 0
var x1409_conditionals: Int = 0
var x1143: Int = 0
while (x1143 < x1376) {  // begin fat loop x1409
val x1389 = x1388(x1143.toInt)
val x1390 = x1378(x1389.toInt)
val x1391 = x1383(x1389.toInt)
val x1393 = x1392(x1389.toInt)
val x1395 = x1394(x1389.toInt)
val x1397 = x1396(x1389.toInt)
val x1399 = x1398(x1389.toInt)
val x1401 = x1400(x1389.toInt)
val x1403 = x1402(x1389.toInt)
val x1405 = x1404(x1389.toInt)
val x1407 = x1406(x1389.toInt)
val x1408 = new generated.scala.Anon201185238(x1390,x1391,x1393,x1395,x1397,x1399,x1401,x1403,x1405,x1407)
val x1157 = x1408
val x1156 = x1409_data
val x1176 = x1156.returnFlag
val x1177 = x1157.returnFlag
val x1178 = x1156.returnFlag(x1143.toInt) = x1177
val x1179 = x1156.lineStatus
val x1180 = x1157.lineStatus
val x1181 = x1156.lineStatus(x1143.toInt) = x1180
val x1182 = x1156.sumQty
val x1183 = x1157.sumQty
val x1184 = x1156.sumQty(x1143.toInt) = x1183
val x1185 = x1156.sumBasePrice
val x1186 = x1157.sumBasePrice
val x1187 = x1156.sumBasePrice(x1143.toInt) = x1186
val x1188 = x1156.sumDiscountedPrice
val x1189 = x1157.sumDiscountedPrice
val x1190 = x1156.sumDiscountedPrice(x1143.toInt) = x1189
val x1191 = x1156.sumCharge
val x1192 = x1157.sumCharge
val x1193 = x1156.sumCharge(x1143.toInt) = x1192
val x1194 = x1156.avgQty
val x1195 = x1157.avgQty
val x1196 = x1156.avgQty(x1143.toInt) = x1195
val x1197 = x1156.avgPrice
val x1198 = x1157.avgPrice
val x1199 = x1156.avgPrice(x1143.toInt) = x1198
val x1200 = x1156.avgDiscount
val x1201 = x1157.avgDiscount
val x1202 = x1156.avgDiscount(x1143.toInt) = x1201
val x1203 = x1156.countOrder
val x1204 = x1157.countOrder
val x1205 = x1156.countOrder(x1143.toInt) = x1204
x1143 = x1143 + 1
} // end fat loop x1409
val x1156 = x1409_data
val x1409 = x1156
val x1410 = new generated.scala.TableAnon201185238(x1409,x1376)
def x1411_block = { 
x1410
}
val x1411 = x1411_block
val x1412 = Seq(x1411)
val x1413 = ppl.delite.runtime.profiler.PerformanceTimer.stop("app")
val x1414 = generated.scala.container.Table.printAsTable(x1411, 100)
()
}
}
/*****************************************
  End of Generated Code                  
*******************************************/

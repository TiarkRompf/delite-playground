/*****************************************
  Emitting Generated Code                  
*******************************************/
package generated.scala
class  extends ((Array[java.lang.String])=>(Unit)) {
def apply(x0:Array[java.lang.String]): Unit = {
val x1 = generated.scala.io.DeliteFileInputStream(Seq("/home/greg/Research/data/SF1/lineitem.tbl"), None, None,0L)
val x2 = x1.size
var x71: Int = 0
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x75 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x76 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x77 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x78 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x79 = new Array[Double](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x80 = new Array[Double](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x81 = new Array[Double](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x82 = new Array[Double](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x83 = new Array[Char](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x84 = new Array[Char](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x85 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x86 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x87 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x88 = new Array[java.lang.String](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x89 = new Array[java.lang.String](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x90 = new Array[java.lang.String](x71.toInt)
val x91 = new generated.scala.DeliteArrayAnon1782511006(x75,x76,x77,x78,x79,x80,x81,x82,x83,x84,x85,x86,x87,x88,x89,x90)
var x376_buf: generated.scala.DeliteArrayAnon1782511006 = x91
var x376_size: Int = 0
var x376_conditionals: Int = 0
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
val x23 = {
x22.charAt(0)}
val x24 = x5(9.toInt)
val x25 = {
x24.charAt(0)}
val x26 = x5(10.toInt)
val x27 = x26.split("-", 0)
val x28 = x27(0.toInt)
val x29 = {
x28.toInt}
val x34 = {
x29 << 9}
val x32 = x27(2.toInt)
val x33 = {
x32.toInt}
val x30 = x27(1.toInt)
val x31 = {
x30.toInt}
val x35 = {
x31 << 5}
val x36 = x35 + x33
val x37 = x34 + x36
def x38_block = { 
x37
}
val x38 = x38_block
val x39 = x5(11.toInt)
val x40 = x39.split("-", 0)
val x41 = x40(0.toInt)
val x42 = {
x41.toInt}
val x47 = {
x42 << 9}
val x45 = x40(2.toInt)
val x46 = {
x45.toInt}
val x43 = x40(1.toInt)
val x44 = {
x43.toInt}
val x48 = {
x44 << 5}
val x49 = x48 + x46
val x50 = x47 + x49
def x51_block = { 
x50
}
val x51 = x51_block
val x52 = x5(12.toInt)
val x53 = x52.split("-", 0)
val x54 = x53(0.toInt)
val x55 = {
x54.toInt}
val x60 = {
x55 << 9}
val x58 = x53(2.toInt)
val x59 = {
x58.toInt}
val x56 = x53(1.toInt)
val x57 = {
x56.toInt}
val x61 = {
x57 << 5}
val x62 = x61 + x59
val x63 = x60 + x62
def x64_block = { 
x63
}
val x64 = x64_block
val x65 = x5(13.toInt)
val x66 = x5(14.toInt)
val x67 = x5(15.toInt)
val x68 = new generated.scala.Anon1782511006(x7,x9,x11,x13,x15,x17,x19,x21,x23,x25,x38,x51,x64,x65,x66,x67)
val x69 = x376_buf
val x70 = x68
if (true) {
val x144 = x376_size
val x145 = x69.l_orderkey
val x146 = x145.length
val x147 = x146 - 1
val x148 = x144 > x147
val x252 = {
def x252thenb(): Unit = {
val x149 = x146 < 16
val x153 = {
def x153thenb(): Int = {
16
}
def x153elseb(): Int = {
val x150 = x146 * 2
val x151 = x150 < 0
val x152 = {
def x152thenb(): Int = {
2147483647
}
def x152elseb(): Int = {
x150
}
if (x151) {
x152thenb()
} else { 
x152elseb()
}
}
x152
}
if (x149) {
x153thenb()
} else { 
x153elseb()
}
}
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x154 = new Array[Int](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x155 = new Array[Int](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x156 = new Array[Int](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x157 = new Array[Int](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x158 = new Array[Double](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x159 = new Array[Double](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x160 = new Array[Double](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x161 = new Array[Double](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x162 = new Array[Char](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x163 = new Array[Char](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x164 = new Array[Int](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x165 = new Array[Int](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x166 = new Array[Int](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x167 = new Array[java.lang.String](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x168 = new Array[java.lang.String](x153.toInt)
if (x153 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x169 = new Array[java.lang.String](x153.toInt)
val x171 = System.arraycopy(x145,0.toInt,x154,0.toInt,x146.toInt)
val x172 = x69.l_partkey
val x173 = System.arraycopy(x172,0.toInt,x155,0.toInt,x146.toInt)
val x174 = x69.l_suppkey
val x175 = System.arraycopy(x174,0.toInt,x156,0.toInt,x146.toInt)
val x176 = x69.l_linenumber
val x177 = System.arraycopy(x176,0.toInt,x157,0.toInt,x146.toInt)
val x178 = x69.l_quantity
val x179 = System.arraycopy(x178,0.toInt,x158,0.toInt,x146.toInt)
val x180 = x69.l_extendedprice
val x181 = System.arraycopy(x180,0.toInt,x159,0.toInt,x146.toInt)
val x182 = x69.l_discount
val x183 = System.arraycopy(x182,0.toInt,x160,0.toInt,x146.toInt)
val x184 = x69.l_tax
val x185 = System.arraycopy(x184,0.toInt,x161,0.toInt,x146.toInt)
val x186 = x69.l_returnflag
val x187 = System.arraycopy(x186,0.toInt,x162,0.toInt,x146.toInt)
val x188 = x69.l_linestatus
val x189 = System.arraycopy(x188,0.toInt,x163,0.toInt,x146.toInt)
val x190 = x69.l_shipdate
val x191 = System.arraycopy(x190,0.toInt,x164,0.toInt,x146.toInt)
val x192 = x69.l_commitdate
val x193 = System.arraycopy(x192,0.toInt,x165,0.toInt,x146.toInt)
val x194 = x69.l_receiptdate
val x195 = System.arraycopy(x194,0.toInt,x166,0.toInt,x146.toInt)
val x196 = x69.l_shipinstruct
val x197 = System.arraycopy(x196,0.toInt,x167,0.toInt,x146.toInt)
val x198 = x69.l_shipmode
val x199 = System.arraycopy(x198,0.toInt,x168,0.toInt,x146.toInt)
val x200 = x69.l_comment
val x201 = System.arraycopy(x200,0.toInt,x169,0.toInt,x146.toInt)
val x96 = x70.l_orderkey
val x202 = x154(x144.toInt) = x96
val x99 = x70.l_partkey
val x203 = x155(x144.toInt) = x99
val x102 = x70.l_suppkey
val x204 = x156(x144.toInt) = x102
val x105 = x70.l_linenumber
val x205 = x157(x144.toInt) = x105
val x108 = x70.l_quantity
val x206 = x158(x144.toInt) = x108
val x111 = x70.l_extendedprice
val x207 = x159(x144.toInt) = x111
val x114 = x70.l_discount
val x208 = x160(x144.toInt) = x114
val x117 = x70.l_tax
val x209 = x161(x144.toInt) = x117
val x120 = x70.l_returnflag
val x210 = x162(x144.toInt) = x120
val x123 = x70.l_linestatus
val x211 = x163(x144.toInt) = x123
val x126 = x70.l_shipdate
val x212 = x164(x144.toInt) = x126
val x129 = x70.l_commitdate
val x213 = x165(x144.toInt) = x129
val x132 = x70.l_receiptdate
val x214 = x166(x144.toInt) = x132
val x135 = x70.l_shipinstruct
val x215 = x167(x144.toInt) = x135
val x138 = x70.l_shipmode
val x216 = x168(x144.toInt) = x138
val x141 = x70.l_comment
val x217 = x169(x144.toInt) = x141
val x170 = new generated.scala.DeliteArrayAnon1782511006(x154,x155,x156,x157,x158,x159,x160,x161,x162,x163,x164,x165,x166,x167,x168,x169)
val x218 = x376_buf = x170
x218
}
def x252elseb(): Unit = {
val x96 = x70.l_orderkey
val x220 = x69.l_orderkey(x144.toInt) = x96
val x221 = x69.l_partkey
val x99 = x70.l_partkey
val x222 = x69.l_partkey(x144.toInt) = x99
val x223 = x69.l_suppkey
val x102 = x70.l_suppkey
val x224 = x69.l_suppkey(x144.toInt) = x102
val x225 = x69.l_linenumber
val x105 = x70.l_linenumber
val x226 = x69.l_linenumber(x144.toInt) = x105
val x227 = x69.l_quantity
val x108 = x70.l_quantity
val x228 = x69.l_quantity(x144.toInt) = x108
val x229 = x69.l_extendedprice
val x111 = x70.l_extendedprice
val x230 = x69.l_extendedprice(x144.toInt) = x111
val x231 = x69.l_discount
val x114 = x70.l_discount
val x232 = x69.l_discount(x144.toInt) = x114
val x233 = x69.l_tax
val x117 = x70.l_tax
val x234 = x69.l_tax(x144.toInt) = x117
val x235 = x69.l_returnflag
val x120 = x70.l_returnflag
val x236 = x69.l_returnflag(x144.toInt) = x120
val x237 = x69.l_linestatus
val x123 = x70.l_linestatus
val x238 = x69.l_linestatus(x144.toInt) = x123
val x239 = x69.l_shipdate
val x126 = x70.l_shipdate
val x240 = x69.l_shipdate(x144.toInt) = x126
val x241 = x69.l_commitdate
val x129 = x70.l_commitdate
val x242 = x69.l_commitdate(x144.toInt) = x129
val x243 = x69.l_receiptdate
val x132 = x70.l_receiptdate
val x244 = x69.l_receiptdate(x144.toInt) = x132
val x245 = x69.l_shipinstruct
val x135 = x70.l_shipinstruct
val x246 = x69.l_shipinstruct(x144.toInt) = x135
val x247 = x69.l_shipmode
val x138 = x70.l_shipmode
val x248 = x69.l_shipmode(x144.toInt) = x138
val x249 = x69.l_comment
val x141 = x70.l_comment
val x250 = x69.l_comment(x144.toInt) = x141
()
}
if (x148) {
x252thenb()
} else { 
x252elseb()
}
}
x376_size = x376_size + 1
}
x376_conditionals = x376_conditionals + 1
x3 = x3 + 1
} // end fat loop x376
x1_stream.close();
var x69: generated.scala.DeliteArrayAnon1782511006 = x376_buf
x71 = x376_conditionals
val x254 = x69.l_orderkey
val x255 = x254.length
val x256 = x255 > x71
val x307 = {
def x307thenb(): Unit = {
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x257 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x258 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x259 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x260 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x261 = new Array[Double](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x262 = new Array[Double](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x263 = new Array[Double](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x264 = new Array[Double](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x265 = new Array[Char](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x266 = new Array[Char](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x267 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x268 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x269 = new Array[Int](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x270 = new Array[java.lang.String](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x271 = new Array[java.lang.String](x71.toInt)
if (x71 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x272 = new Array[java.lang.String](x71.toInt)
val x274 = System.arraycopy(x254,0.toInt,x257,0.toInt,x71.toInt)
val x275 = x69.l_partkey
val x276 = System.arraycopy(x275,0.toInt,x258,0.toInt,x71.toInt)
val x277 = x69.l_suppkey
val x278 = System.arraycopy(x277,0.toInt,x259,0.toInt,x71.toInt)
val x279 = x69.l_linenumber
val x280 = System.arraycopy(x279,0.toInt,x260,0.toInt,x71.toInt)
val x281 = x69.l_quantity
val x282 = System.arraycopy(x281,0.toInt,x261,0.toInt,x71.toInt)
val x283 = x69.l_extendedprice
val x284 = System.arraycopy(x283,0.toInt,x262,0.toInt,x71.toInt)
val x285 = x69.l_discount
val x286 = System.arraycopy(x285,0.toInt,x263,0.toInt,x71.toInt)
val x287 = x69.l_tax
val x288 = System.arraycopy(x287,0.toInt,x264,0.toInt,x71.toInt)
val x289 = x69.l_returnflag
val x290 = System.arraycopy(x289,0.toInt,x265,0.toInt,x71.toInt)
val x291 = x69.l_linestatus
val x292 = System.arraycopy(x291,0.toInt,x266,0.toInt,x71.toInt)
val x293 = x69.l_shipdate
val x294 = System.arraycopy(x293,0.toInt,x267,0.toInt,x71.toInt)
val x295 = x69.l_commitdate
val x296 = System.arraycopy(x295,0.toInt,x268,0.toInt,x71.toInt)
val x297 = x69.l_receiptdate
val x298 = System.arraycopy(x297,0.toInt,x269,0.toInt,x71.toInt)
val x299 = x69.l_shipinstruct
val x300 = System.arraycopy(x299,0.toInt,x270,0.toInt,x71.toInt)
val x301 = x69.l_shipmode
val x302 = System.arraycopy(x301,0.toInt,x271,0.toInt,x71.toInt)
val x303 = x69.l_comment
val x304 = System.arraycopy(x303,0.toInt,x272,0.toInt,x71.toInt)
val x273 = new generated.scala.DeliteArrayAnon1782511006(x257,x258,x259,x260,x261,x262,x263,x264,x265,x266,x267,x268,x269,x270,x271,x272)
val x305 = x69 = x273
x305
}
if (x256) {
x307thenb()
}
}
val x376 = x69
val x377 = x376.l_orderkey
val x378 = x377.length
val x382 = x376.l_partkey
val x384 = x376.l_suppkey
val x386 = x376.l_linenumber
val x388 = x376.l_quantity
val x390 = x376.l_extendedprice
val x392 = x376.l_discount
val x394 = x376.l_tax
val x396 = x376.l_returnflag
val x398 = x376.l_linestatus
val x400 = x376.l_shipdate
val x402 = x376.l_commitdate
val x404 = x376.l_receiptdate
val x406 = x376.l_shipinstruct
val x408 = x376.l_shipmode
val x410 = x376.l_comment
val x413 = "1994-01-01".split("-", 0)
val x414 = x413(0.toInt)
val x415 = {
x414.toInt}
val x420 = {
x415 << 9}
val x418 = x413(2.toInt)
val x419 = {
x418.toInt}
val x416 = x413(1.toInt)
val x417 = {
x416.toInt}
val x421 = {
x417 << 5}
val x422 = x421 + x419
val x423 = x420 + x422
def x424_block = { 
x423
}
val x424 = x424_block
val x426 = "1995-01-01".split("-", 0)
val x427 = x426(0.toInt)
val x428 = {
x427.toInt}
val x433 = {
x428 << 9}
val x431 = x426(2.toInt)
val x432 = {
x431.toInt}
val x429 = x426(1.toInt)
val x430 = {
x429.toInt}
val x434 = {
x430 << 5}
val x435 = x434 + x432
val x436 = x433 + x435
def x437_block = { 
x436
}
val x437 = x437_block
def x712_block = { 
true
}
val x712 = x712_block
var x448: Int = 0
var x452: Int = x448
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x453 = new Array[Int](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x454 = new Array[Int](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x455 = new Array[Int](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x456 = new Array[Int](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x457 = new Array[Double](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x458 = new Array[Double](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x459 = new Array[Double](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x460 = new Array[Double](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x461 = new Array[Char](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x462 = new Array[Char](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x463 = new Array[Int](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x464 = new Array[Int](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x465 = new Array[Int](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x466 = new Array[java.lang.String](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x467 = new Array[java.lang.String](x448.toInt)
if (x448 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x468 = new Array[java.lang.String](x448.toInt)
var x470: Array[Int] = x453
var x471: Array[Int] = x454
var x472: Array[Int] = x455
var x473: Array[Int] = x456
var x474: Array[Double] = x457
var x475: Array[Double] = x458
var x476: Array[Double] = x459
var x477: Array[Double] = x460
var x478: Array[Char] = x461
var x479: Array[Char] = x462
var x480: Array[Int] = x463
var x481: Array[Int] = x464
var x482: Array[Int] = x465
var x483: Array[java.lang.String] = x466
var x484: Array[java.lang.String] = x467
var x485: Array[java.lang.String] = x468
val x486 = new generated.scala.DeliteArrayAnon1782511006(x470,x471,x472,x473,x474,x475,x476,x477,x478,x479,x480,x481,x482,x483,x484,x485)
val x487 = new generated.scala.TableAnon1782511006(x452,x486)
var x805_buf: generated.scala.TableAnon1782511006 = x487
var x805_size: Int = 0
var x805_conditionals: Int = 0
var x380: Int = 0
while (x380 < x378) {  // begin fat loop x805
val x381 = x377(x380.toInt)
val x383 = x382(x380.toInt)
val x385 = x384(x380.toInt)
val x387 = x386(x380.toInt)
val x389 = x388(x380.toInt)
val x391 = x390(x380.toInt)
val x393 = x392(x380.toInt)
val x395 = x394(x380.toInt)
val x397 = x396(x380.toInt)
val x399 = x398(x380.toInt)
val x401 = x400(x380.toInt)
val x403 = x402(x380.toInt)
val x405 = x404(x380.toInt)
val x407 = x406(x380.toInt)
val x409 = x408(x380.toInt)
val x411 = x410(x380.toInt)
val x412 = new generated.scala.Anon1782511006(x381,x383,x385,x387,x389,x391,x393,x395,x397,x399,x401,x403,x405,x407,x409,x411)
val x425 = {
x401 >= x424}
val x438 = {
x401 < x437}
val x439 = {
x425 && x438}
val x440 = {
x393 >= 0.05}
val x441 = {
x439 && x440}
val x442 = {
x393 <= 0.07}
val x443 = {
x441 && x442}
val x444 = {
x389 < 24.0}
val x445 = {
x443 && x444}
if (x445) {
val x446 = x805_buf
val x447 = x412
if (x712) {
val x493 = x447.l_orderkey
val x496 = x447.l_partkey
val x499 = x447.l_suppkey
val x502 = x447.l_linenumber
val x505 = x447.l_quantity
val x508 = x447.l_extendedprice
val x511 = x447.l_discount
val x514 = x447.l_tax
val x517 = x447.l_returnflag
val x520 = x447.l_linestatus
val x523 = x447.l_shipdate
val x526 = x447.l_commitdate
val x529 = x447.l_receiptdate
val x532 = x447.l_shipinstruct
val x535 = x447.l_shipmode
val x538 = x447.l_comment
def x710_block = { 
def x708_block = { 
val x541 = x446.size
val x547 = x541 + 1
def x706_block = { 
def x671_block = { 
def x631_block = { 
val x542 = x446.data
val x543 = x542.l_orderkey
val x544 = x543.length
val x545 = x544 - x541
val x546 = {
x545 < 1}
val x629 = {
def x629thenb(): Unit = {
val x548 = x544 * 2
val x549 = {
4 max x548}
val x578 = x542.l_partkey
val x580 = x542.l_suppkey
val x582 = x542.l_linenumber
val x584 = x542.l_quantity
val x586 = x542.l_extendedprice
val x588 = x542.l_discount
val x590 = x542.l_tax
val x592 = x542.l_returnflag
val x594 = x542.l_linestatus
val x596 = x542.l_shipdate
val x598 = x542.l_commitdate
val x600 = x542.l_receiptdate
val x602 = x542.l_shipinstruct
val x604 = x542.l_shipmode
val x606 = x542.l_comment
def x627_block = { 
var x550: Int = x549
val x558 = while ({
val x551 = x550
val x552 = {
x551 < x547}
x552}) {
val x554 = x550
val x555 = x554 * 2
x550 = x555
()
}
val x559 = x550
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x560 = new Array[Int](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x561 = new Array[Int](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x562 = new Array[Int](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x563 = new Array[Int](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x564 = new Array[Double](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x565 = new Array[Double](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x566 = new Array[Double](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x567 = new Array[Double](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x568 = new Array[Char](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x569 = new Array[Char](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x570 = new Array[Int](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x571 = new Array[Int](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x572 = new Array[Int](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x573 = new Array[java.lang.String](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x574 = new Array[java.lang.String](x559.toInt)
if (x559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x575 = new Array[java.lang.String](x559.toInt)
val x577 = System.arraycopy(x543,0.toInt,x560,0.toInt,x541.toInt)
val x579 = System.arraycopy(x578,0.toInt,x561,0.toInt,x541.toInt)
val x581 = System.arraycopy(x580,0.toInt,x562,0.toInt,x541.toInt)
val x583 = System.arraycopy(x582,0.toInt,x563,0.toInt,x541.toInt)
val x585 = System.arraycopy(x584,0.toInt,x564,0.toInt,x541.toInt)
val x587 = System.arraycopy(x586,0.toInt,x565,0.toInt,x541.toInt)
val x589 = System.arraycopy(x588,0.toInt,x566,0.toInt,x541.toInt)
val x591 = System.arraycopy(x590,0.toInt,x567,0.toInt,x541.toInt)
val x593 = System.arraycopy(x592,0.toInt,x568,0.toInt,x541.toInt)
val x595 = System.arraycopy(x594,0.toInt,x569,0.toInt,x541.toInt)
val x597 = System.arraycopy(x596,0.toInt,x570,0.toInt,x541.toInt)
val x599 = System.arraycopy(x598,0.toInt,x571,0.toInt,x541.toInt)
val x601 = System.arraycopy(x600,0.toInt,x572,0.toInt,x541.toInt)
val x603 = System.arraycopy(x602,0.toInt,x573,0.toInt,x541.toInt)
val x605 = System.arraycopy(x604,0.toInt,x574,0.toInt,x541.toInt)
val x607 = System.arraycopy(x606,0.toInt,x575,0.toInt,x541.toInt)
val x608 = x560// unsafe immutable
val x609 = x561// unsafe immutable
val x610 = x562// unsafe immutable
val x611 = x563// unsafe immutable
val x612 = x564// unsafe immutable
val x613 = x565// unsafe immutable
val x614 = x566// unsafe immutable
val x615 = x567// unsafe immutable
val x616 = x568// unsafe immutable
val x617 = x569// unsafe immutable
val x618 = x570// unsafe immutable
val x619 = x571// unsafe immutable
val x620 = x572// unsafe immutable
val x621 = x573// unsafe immutable
val x622 = x574// unsafe immutable
val x623 = x575// unsafe immutable
val x624 = new generated.scala.DeliteArrayAnon1782511006(x608,x609,x610,x611,x612,x613,x614,x615,x616,x617,x618,x619,x620,x621,x622,x623)
val x625 = x446.data = x624
x625
}
val x627 = x627_block
x627
}
if (x546) {
x629thenb()
}
}
x629
}
val x631 = x631_block
val x632 = x446.data
val x633 = x446.size
val x634 = x633 - x541
val x635 = x632.l_orderkey
val x636 = System.arraycopy(x635,x541.toInt,x446.data.l_orderkey,x547.toInt,x634.toInt)
val x637 = x632.l_partkey
val x638 = System.arraycopy(x637,x541.toInt,x446.data.l_partkey,x547.toInt,x634.toInt)
val x639 = x632.l_suppkey
val x640 = System.arraycopy(x639,x541.toInt,x446.data.l_suppkey,x547.toInt,x634.toInt)
val x641 = x632.l_linenumber
val x642 = System.arraycopy(x641,x541.toInt,x446.data.l_linenumber,x547.toInt,x634.toInt)
val x643 = x632.l_quantity
val x644 = System.arraycopy(x643,x541.toInt,x446.data.l_quantity,x547.toInt,x634.toInt)
val x645 = x632.l_extendedprice
val x646 = System.arraycopy(x645,x541.toInt,x446.data.l_extendedprice,x547.toInt,x634.toInt)
val x647 = x632.l_discount
val x648 = System.arraycopy(x647,x541.toInt,x446.data.l_discount,x547.toInt,x634.toInt)
val x649 = x632.l_tax
val x650 = System.arraycopy(x649,x541.toInt,x446.data.l_tax,x547.toInt,x634.toInt)
val x651 = x632.l_returnflag
val x652 = System.arraycopy(x651,x541.toInt,x446.data.l_returnflag,x547.toInt,x634.toInt)
val x653 = x632.l_linestatus
val x654 = System.arraycopy(x653,x541.toInt,x446.data.l_linestatus,x547.toInt,x634.toInt)
val x655 = x632.l_shipdate
val x656 = System.arraycopy(x655,x541.toInt,x446.data.l_shipdate,x547.toInt,x634.toInt)
val x657 = x632.l_commitdate
val x658 = System.arraycopy(x657,x541.toInt,x446.data.l_commitdate,x547.toInt,x634.toInt)
val x659 = x632.l_receiptdate
val x660 = System.arraycopy(x659,x541.toInt,x446.data.l_receiptdate,x547.toInt,x634.toInt)
val x661 = x632.l_shipinstruct
val x662 = System.arraycopy(x661,x541.toInt,x446.data.l_shipinstruct,x547.toInt,x634.toInt)
val x663 = x632.l_shipmode
val x664 = System.arraycopy(x663,x541.toInt,x446.data.l_shipmode,x547.toInt,x634.toInt)
val x665 = x632.l_comment
val x666 = System.arraycopy(x665,x541.toInt,x446.data.l_comment,x547.toInt,x634.toInt)
val x667 = x446.size
val x668 = x667 + 1
val x669 = x446.size = x668
x669
}
val x671 = x671_block
val x672 = x446.data
val x674 = x446.data.l_orderkey(x541.toInt) = x493
val x676 = x446.data.l_partkey(x541.toInt) = x496
val x678 = x446.data.l_suppkey(x541.toInt) = x499
val x680 = x446.data.l_linenumber(x541.toInt) = x502
val x682 = x446.data.l_quantity(x541.toInt) = x505
val x684 = x446.data.l_extendedprice(x541.toInt) = x508
val x686 = x446.data.l_discount(x541.toInt) = x511
val x688 = x446.data.l_tax(x541.toInt) = x514
val x690 = x446.data.l_returnflag(x541.toInt) = x517
val x692 = x446.data.l_linestatus(x541.toInt) = x520
val x694 = x446.data.l_shipdate(x541.toInt) = x523
val x696 = x446.data.l_commitdate(x541.toInt) = x526
val x698 = x446.data.l_receiptdate(x541.toInt) = x529
val x700 = x446.data.l_shipinstruct(x541.toInt) = x532
val x702 = x446.data.l_shipmode(x541.toInt) = x535
val x704 = x446.data.l_comment(x541.toInt) = x538
()
}
val x706 = x706_block
x706
}
val x708 = x708_block
x708
}
val x710 = x710_block
x805_size = x805_size + 1
}
x805_conditionals = x805_conditionals + 1
}
x380 = x380 + 1
} // end fat loop x805
var x446: generated.scala.TableAnon1782511006 = x805_buf
x448 = x805_conditionals
val x713 = x446.size = x448
val x805 = x446
val x806 = x805.size
val x808 = x805.data
val x819 = x808.l_extendedprice
val x821 = x808.l_discount
val x846_zero: Double = 0.0
var x846: Double = x846_zero
var x807: Int = 0
if (x806 > 0) { // prerun fat loop x846
val x820 = x819(x807.toInt)
val x822 = x821(x807.toInt)
val x842 = {
x820 * x822}
x846 = x842
}
x807 = 1
while (x807 < x806) {  // begin fat loop x846
val x820 = x819(x807.toInt)
val x822 = x821(x807.toInt)
val x842 = {
x820 * x822}
val x843 = x846
val x844 = x842
val x845 = {
x843 + x844}
x846 = x845
x807 = x807 + 1
} // end fat loop x846
val x847 = {
println(x846)}
()
}
}
/*****************************************
  End of Generated Code                  
*******************************************/

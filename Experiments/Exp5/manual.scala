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
val x91 = new generated.scala.DeliteArrayAnon381027130(x75,x76,x77,x78,x79,x80,x81,x82,x83,x84,x85,x86,x87,x88,x89,x90)
var x376_buf: generated.scala.DeliteArrayAnon381027130 = x91
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
val x68 = new generated.scala.Anon381027130(x7,x9,x11,x13,x15,x17,x19,x21,x23,x25,x38,x51,x64,x65,x66,x67)
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
val x170 = new generated.scala.DeliteArrayAnon381027130(x154,x155,x156,x157,x158,x159,x160,x161,x162,x163,x164,x165,x166,x167,x168,x169)
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
var x69: generated.scala.DeliteArrayAnon381027130 = x376_buf
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
val x273 = new generated.scala.DeliteArrayAnon381027130(x257,x258,x259,x260,x261,x262,x263,x264,x265,x266,x267,x268,x269,x270,x271,x272)
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
val x388 = x376.l_quantity
val x390 = x376.l_extendedprice
val x392 = x376.l_discount
val x394 = x376.l_tax
val x396 = x376.l_returnflag
val x398 = x376.l_linestatus
val x1114 = {
null.asInstanceOf[Null].asInstanceOf[generated.scala.Anon201185238]}
val x413 = "1998-12-01".split("-", 0)
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
val x400 = x376.l_shipdate
var x1332x2057_hash_pos: generated.scala.container.HashMapImpl[generated.scala.Tup2CharChar] = new generated.scala.container.HashMapImpl[generated.scala.Tup2CharChar](512,128)
var x1147: Int = 128
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1150 = new Array[Char](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1151 = new Array[Char](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1152 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1153 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1154 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1155 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1156 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1157 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1158 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1159 = new Array[Int](x1147.toInt)
val x1160 = new generated.scala.DeliteArrayAnon201185238(x1150,x1151,x1152,x1153,x1154,x1155,x1156,x1157,x1158,x1159)
var x1332_hash_data: generated.scala.DeliteArrayAnon201185238 = x1160
var x1471: Int = 128
if (x1471 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1474 = new Array[Int](x1471.toInt)
var x2057_hash_data: Array[Int] = x1474
var x1089: Int = 0
while (x1089 < x378) {  // begin fat loop x1332,x2057
val x1094 = x388(x1089.toInt)
val x1095 = x390(x1089.toInt)
val x1096 = x392(x1089.toInt)
val x1108 = {
1.0 - x1096}
val x1109 = {
x1095 * x1108}
val x1097 = x394(x1089.toInt)
val x1110 = {
1.0 + x1097}
val x1111 = {
x1109 * x1110}
val x1098 = x396(x1089.toInt)
val x1099 = x398(x1089.toInt)
val x1112 = new generated.scala.Anon201185238(x1098,x1099,x1094,x1095,x1109,x1111,x1094,x1095,x1096,1)
val x1107 = new generated.scala.Tup2CharChar(x1098,x1099)
val x1100 = x400(x1089.toInt)
val x1113 = {
x1100 <= x424}
if (x1113) {
// common key Block(Sym(1107)) for x1332x2057
val x1332x2057_sze: Int = x1332x2057_hash_pos.size
val x1332x2057_idx: Int = x1332x2057_hash_pos.put(x1107)
if (x1332x2057_idx == x1332x2057_sze) { // new key
val x1149: generated.scala.DeliteArrayAnon201185238 = x1332_hash_data
val x1146: generated.scala.Anon201185238 = x1112
val x1217 = x1332x2057_sze
val x1218 = x1149.returnFlag
val x1219 = x1218.length
val x1220 = x1219 - 1
val x1221 = x1217 > x1220
val x1289 = {
def x1289thenb(): Unit = {
val x1222 = x1219 < 16
val x1226 = {
def x1226thenb(): Int = {
16
}
def x1226elseb(): Int = {
val x1223 = x1219 * 2
val x1224 = x1223 < 0
val x1225 = {
def x1225thenb(): Int = {
2147483647
}
def x1225elseb(): Int = {
x1223
}
if (x1224) {
x1225thenb()
} else { 
x1225elseb()
}
}
x1225
}
if (x1222) {
x1226thenb()
} else { 
x1226elseb()
}
}
if (x1226 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1227 = new Array[Char](x1226.toInt)
if (x1226 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1228 = new Array[Char](x1226.toInt)
if (x1226 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1229 = new Array[Double](x1226.toInt)
if (x1226 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1230 = new Array[Double](x1226.toInt)
if (x1226 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1231 = new Array[Double](x1226.toInt)
if (x1226 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1232 = new Array[Double](x1226.toInt)
if (x1226 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1233 = new Array[Double](x1226.toInt)
if (x1226 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1234 = new Array[Double](x1226.toInt)
if (x1226 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1235 = new Array[Double](x1226.toInt)
if (x1226 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1236 = new Array[Int](x1226.toInt)
val x1238 = System.arraycopy(x1218,0.toInt,x1227,0.toInt,x1219.toInt)
val x1239 = x1149.lineStatus
val x1240 = System.arraycopy(x1239,0.toInt,x1228,0.toInt,x1219.toInt)
val x1241 = x1149.sumQty
val x1242 = System.arraycopy(x1241,0.toInt,x1229,0.toInt,x1219.toInt)
val x1243 = x1149.sumBasePrice
val x1244 = System.arraycopy(x1243,0.toInt,x1230,0.toInt,x1219.toInt)
val x1245 = x1149.sumDiscountedPrice
val x1246 = System.arraycopy(x1245,0.toInt,x1231,0.toInt,x1219.toInt)
val x1247 = x1149.sumCharge
val x1248 = System.arraycopy(x1247,0.toInt,x1232,0.toInt,x1219.toInt)
val x1249 = x1149.avgQty
val x1250 = System.arraycopy(x1249,0.toInt,x1233,0.toInt,x1219.toInt)
val x1251 = x1149.avgPrice
val x1252 = System.arraycopy(x1251,0.toInt,x1234,0.toInt,x1219.toInt)
val x1253 = x1149.avgDiscount
val x1254 = System.arraycopy(x1253,0.toInt,x1235,0.toInt,x1219.toInt)
val x1255 = x1149.countOrder
val x1256 = System.arraycopy(x1255,0.toInt,x1236,0.toInt,x1219.toInt)
val x1185 = x1146.returnFlag
val x1257 = x1227(x1217.toInt) = x1185
val x1188 = x1146.lineStatus
val x1258 = x1228(x1217.toInt) = x1188
val x1191 = x1146.sumQty
val x1259 = x1229(x1217.toInt) = x1191
val x1194 = x1146.sumBasePrice
val x1260 = x1230(x1217.toInt) = x1194
val x1197 = x1146.sumDiscountedPrice
val x1261 = x1231(x1217.toInt) = x1197
val x1200 = x1146.sumCharge
val x1262 = x1232(x1217.toInt) = x1200
val x1203 = x1146.avgQty
val x1263 = x1233(x1217.toInt) = x1203
val x1206 = x1146.avgPrice
val x1264 = x1234(x1217.toInt) = x1206
val x1209 = x1146.avgDiscount
val x1265 = x1235(x1217.toInt) = x1209
val x1212 = x1146.countOrder
val x1266 = x1236(x1217.toInt) = x1212
val x1237 = new generated.scala.DeliteArrayAnon201185238(x1227,x1228,x1229,x1230,x1231,x1232,x1233,x1234,x1235,x1236)
val x1267 = x1332_hash_data = x1237
x1267
}
def x1289elseb(): Unit = {
val x1185 = x1146.returnFlag
val x1269 = x1149.returnFlag(x1217.toInt) = x1185
val x1270 = x1149.lineStatus
val x1188 = x1146.lineStatus
val x1271 = x1149.lineStatus(x1217.toInt) = x1188
val x1272 = x1149.sumQty
val x1191 = x1146.sumQty
val x1273 = x1149.sumQty(x1217.toInt) = x1191
val x1274 = x1149.sumBasePrice
val x1194 = x1146.sumBasePrice
val x1275 = x1149.sumBasePrice(x1217.toInt) = x1194
val x1276 = x1149.sumDiscountedPrice
val x1197 = x1146.sumDiscountedPrice
val x1277 = x1149.sumDiscountedPrice(x1217.toInt) = x1197
val x1278 = x1149.sumCharge
val x1200 = x1146.sumCharge
val x1279 = x1149.sumCharge(x1217.toInt) = x1200
val x1280 = x1149.avgQty
val x1203 = x1146.avgQty
val x1281 = x1149.avgQty(x1217.toInt) = x1203
val x1282 = x1149.avgPrice
val x1206 = x1146.avgPrice
val x1283 = x1149.avgPrice(x1217.toInt) = x1206
val x1284 = x1149.avgDiscount
val x1209 = x1146.avgDiscount
val x1285 = x1149.avgDiscount(x1217.toInt) = x1209
val x1286 = x1149.countOrder
val x1212 = x1146.countOrder
val x1287 = x1149.countOrder(x1217.toInt) = x1212
()
}
if (x1221) {
x1289thenb()
} else { 
x1289elseb()
}
}
val x1473: Array[Int] = x2057_hash_data
val x1470: Int = 1
val x1482 = x1332x2057_sze
val x1483 = x1473.length
val x1484 = x1483 - 1
val x1485 = x1482 > x1484
val x1498 = {
def x1498thenb(): Unit = {
val x1486 = x1483 < 16
val x1490 = {
def x1490thenb(): Int = {
16
}
def x1490elseb(): Int = {
val x1487 = x1483 * 2
val x1488 = x1487 < 0
val x1489 = {
def x1489thenb(): Int = {
2147483647
}
def x1489elseb(): Int = {
x1487
}
if (x1488) {
x1489thenb()
} else { 
x1489elseb()
}
}
x1489
}
if (x1486) {
x1490thenb()
} else { 
x1490elseb()
}
}
if (x1490 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1491 = new Array[Int](x1490.toInt)
val x1492 = System.arraycopy(x1473,0.toInt,x1491,0.toInt,x1483.toInt)
val x1493 = x1491(x1482.toInt) = x1470
val x1494 = x2057_hash_data = x1491
x1494
}
def x1498elseb(): Unit = {
val x1496 = x1473(x1482.toInt) = x1470
x1496
}
if (x1485) {
x1498thenb()
} else { 
x1498elseb()
}
}
} else { // existing key
val x1148: Int = x1332x2057_idx
val x1149: generated.scala.DeliteArrayAnon201185238 = x1332_hash_data
val x1162 = x1149.returnFlag
val x1164 = x1149.lineStatus
val x1166 = x1149.sumQty
val x1168 = x1149.sumBasePrice
val x1170 = x1149.sumDiscountedPrice
val x1172 = x1149.sumCharge
val x1174 = x1149.avgQty
val x1176 = x1149.avgPrice
val x1178 = x1149.avgDiscount
val x1180 = x1149.countOrder
val x1163 = x1162(x1148.toInt)
val x1165 = x1164(x1148.toInt)
val x1167 = x1166(x1148.toInt)
val x1169 = x1168(x1148.toInt)
val x1171 = x1170(x1148.toInt)
val x1173 = x1172(x1148.toInt)
val x1175 = x1174(x1148.toInt)
val x1177 = x1176(x1148.toInt)
val x1179 = x1178(x1148.toInt)
val x1181 = x1180(x1148.toInt)
val x1182 = new generated.scala.Anon201185238(x1163,x1165,x1167,x1169,x1171,x1173,x1175,x1177,x1179,x1181)
val x1115: generated.scala.Anon201185238 = x1182
val x1116: generated.scala.Anon201185238 = x1112
val x1117 = x1115.returnFlag
val x1119 = x1115.lineStatus
val x1121 = x1115.sumQty
val x1122 = x1116.sumQty
val x1123 = {
x1121 + x1122}
val x1124 = x1115.sumBasePrice
val x1125 = x1116.sumBasePrice
val x1126 = {
x1124 + x1125}
val x1127 = x1115.sumDiscountedPrice
val x1128 = x1116.sumDiscountedPrice
val x1129 = {
x1127 + x1128}
val x1130 = x1115.sumCharge
val x1131 = x1116.sumCharge
val x1132 = {
x1130 + x1131}
val x1133 = x1115.avgQty
val x1134 = x1116.avgQty
val x1135 = {
x1133 + x1134}
val x1136 = x1115.avgPrice
val x1137 = x1116.avgPrice
val x1138 = {
x1136 + x1137}
val x1139 = x1115.avgDiscount
val x1140 = x1116.avgDiscount
val x1141 = {
x1139 + x1140}
val x1142 = x1115.countOrder
val x1143 = x1116.countOrder
val x1144 = {
x1142 + x1143}
val x1145 = new generated.scala.Anon201185238(x1117,x1119,x1123,x1126,x1129,x1132,x1135,x1138,x1141,x1144)
val x1146: generated.scala.Anon201185238 = x1145
val x1184 = x1149.returnFlag
val x1185 = x1146.returnFlag
val x1186 = x1149.returnFlag(x1148.toInt) = x1185
val x1187 = x1149.lineStatus
val x1188 = x1146.lineStatus
val x1189 = x1149.lineStatus(x1148.toInt) = x1188
val x1190 = x1149.sumQty
val x1191 = x1146.sumQty
val x1192 = x1149.sumQty(x1148.toInt) = x1191
val x1193 = x1149.sumBasePrice
val x1194 = x1146.sumBasePrice
val x1195 = x1149.sumBasePrice(x1148.toInt) = x1194
val x1196 = x1149.sumDiscountedPrice
val x1197 = x1146.sumDiscountedPrice
val x1198 = x1149.sumDiscountedPrice(x1148.toInt) = x1197
val x1199 = x1149.sumCharge
val x1200 = x1146.sumCharge
val x1201 = x1149.sumCharge(x1148.toInt) = x1200
val x1202 = x1149.avgQty
val x1203 = x1146.avgQty
val x1204 = x1149.avgQty(x1148.toInt) = x1203
val x1205 = x1149.avgPrice
val x1206 = x1146.avgPrice
val x1207 = x1149.avgPrice(x1148.toInt) = x1206
val x1208 = x1149.avgDiscount
val x1209 = x1146.avgDiscount
val x1210 = x1149.avgDiscount(x1148.toInt) = x1209
val x1211 = x1149.countOrder
val x1212 = x1146.countOrder
val x1213 = x1149.countOrder(x1148.toInt) = x1212
val x1472: Int = x1332x2057_idx
val x1473: Array[Int] = x2057_hash_data
val x1476 = x1473(x1472.toInt)
val x1467: Int = x1476
val x1468: Int = 1
val x1469 = x1467 + x1468
val x1470: Int = x1469
val x1478 = x1473(x1472.toInt) = x1470
}
}
x1089 = x1089 + 1
} // end fat loop x1332,x2057
val x1332x2057_sze: Int = x1332x2057_hash_pos.size
var x1149: generated.scala.DeliteArrayAnon201185238 = x1332_hash_data
x1147 = x1332x2057_sze
val x1291 = x1149.returnFlag
val x1292 = x1291.length
val x1293 = x1292 > x1147
val x1326 = {
def x1326thenb(): Unit = {
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1294 = new Array[Char](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1295 = new Array[Char](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1296 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1297 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1298 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1299 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1300 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1301 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1302 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1303 = new Array[Int](x1147.toInt)
val x1305 = System.arraycopy(x1291,0.toInt,x1294,0.toInt,x1147.toInt)
val x1306 = x1149.lineStatus
val x1307 = System.arraycopy(x1306,0.toInt,x1295,0.toInt,x1147.toInt)
val x1308 = x1149.sumQty
val x1309 = System.arraycopy(x1308,0.toInt,x1296,0.toInt,x1147.toInt)
val x1310 = x1149.sumBasePrice
val x1311 = System.arraycopy(x1310,0.toInt,x1297,0.toInt,x1147.toInt)
val x1312 = x1149.sumDiscountedPrice
val x1313 = System.arraycopy(x1312,0.toInt,x1298,0.toInt,x1147.toInt)
val x1314 = x1149.sumCharge
val x1315 = System.arraycopy(x1314,0.toInt,x1299,0.toInt,x1147.toInt)
val x1316 = x1149.avgQty
val x1317 = System.arraycopy(x1316,0.toInt,x1300,0.toInt,x1147.toInt)
val x1318 = x1149.avgPrice
val x1319 = System.arraycopy(x1318,0.toInt,x1301,0.toInt,x1147.toInt)
val x1320 = x1149.avgDiscount
val x1321 = System.arraycopy(x1320,0.toInt,x1302,0.toInt,x1147.toInt)
val x1322 = x1149.countOrder
val x1323 = System.arraycopy(x1322,0.toInt,x1303,0.toInt,x1147.toInt)
val x1304 = new generated.scala.DeliteArrayAnon201185238(x1294,x1295,x1296,x1297,x1298,x1299,x1300,x1301,x1302,x1303)
val x1324 = x1149 = x1304
x1324
}
if (x1293) {
x1326thenb()
}
}
val x1332: generated.scala.DeliteArrayAnon201185238 = x1149
var x1473: Array[Int] = x2057_hash_data
x1471 = x1332x2057_sze
val x1500 = x1473.length
val x1501 = x1500 > x1471
val x1506 = {
def x1506thenb(): Unit = {
if (x1471 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1502 = new Array[Int](x1471.toInt)
val x1503 = System.arraycopy(x1473,0.toInt,x1502,0.toInt,x1471.toInt)
val x1504 = x1473 = x1502
x1504
}
if (x1501) {
x1506thenb()
}
}
val x2057: Array[Int] = x1473
val x1333 = x1332.returnFlag
val x1334 = x1333.length
val x1518 = x1332.lineStatus
val x1520 = x1332.sumQty
val x1522 = x1332.sumBasePrice
val x1524 = x1332.sumDiscountedPrice
val x1526 = x1332.sumCharge
val x1534 = x1332.countOrder
val x1528 = x1332.avgQty
val x1530 = x1332.avgPrice
val x1532 = x1332.avgDiscount
def x1730_block = { 
true
}
val x1730 = x1730_block
var x1544: Int = x1334
var x1548: Int = x1544
if (x1544 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1549 = new Array[Char](x1544.toInt)
if (x1544 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1550 = new Array[Char](x1544.toInt)
if (x1544 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1551 = new Array[Double](x1544.toInt)
if (x1544 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1552 = new Array[Double](x1544.toInt)
if (x1544 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1553 = new Array[Double](x1544.toInt)
if (x1544 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1554 = new Array[Double](x1544.toInt)
if (x1544 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1555 = new Array[Double](x1544.toInt)
if (x1544 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1556 = new Array[Double](x1544.toInt)
if (x1544 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1557 = new Array[Double](x1544.toInt)
if (x1544 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1558 = new Array[Int](x1544.toInt)
var x1560: Array[Char] = x1549
var x1561: Array[Char] = x1550
var x1562: Array[Double] = x1551
var x1563: Array[Double] = x1552
var x1564: Array[Double] = x1553
var x1565: Array[Double] = x1554
var x1566: Array[Double] = x1555
var x1567: Array[Double] = x1556
var x1568: Array[Double] = x1557
var x1569: Array[Int] = x1558
val x1570 = new generated.scala.DeliteArrayAnon201185238(x1560,x1561,x1562,x1563,x1564,x1565,x1566,x1567,x1568,x1569)
val x1571 = new generated.scala.TableAnon201185238(x1548,x1570)
val x2063_data: generated.scala.TableAnon201185238 = x1571
var x2063_size: Int = 0
var x2063_conditionals: Int = 0
var x1516: Int = 0
while (x1516 < x1334) {  // begin fat loop x2063
val x1517 = x1333(x1516.toInt)
val x1519 = x1518(x1516.toInt)
val x1521 = x1520(x1516.toInt)
val x1523 = x1522(x1516.toInt)
val x1525 = x1524(x1516.toInt)
val x1527 = x1526(x1516.toInt)
val x1535 = x1534(x1516.toInt)
val x1529 = x1528(x1516.toInt)
val x2058 = x2057(x1516.toInt)
val x2059 = {
implicitly[Fractional[Double]].div(x1529,x2058)}
val x1531 = x1530(x1516.toInt)
val x2060 = {
implicitly[Fractional[Double]].div(x1531,x2058)}
val x1533 = x1532(x1516.toInt)
val x2061 = {
implicitly[Fractional[Double]].div(x1533,x2058)}
val x2062 = new generated.scala.Anon201185238(x1517,x1519,x1521,x1523,x1525,x1527,x2059,x2060,x2061,x1535)
val x1543 = x2062
val x1542 = x2063_data
val x1575 = x1542.data
val x1577 = x1543.returnFlag
val x1578 = x1542.data.returnFlag(x1516.toInt) = x1577
val x1580 = x1543.lineStatus
val x1581 = x1542.data.lineStatus(x1516.toInt) = x1580
val x1583 = x1543.sumQty
val x1584 = x1542.data.sumQty(x1516.toInt) = x1583
val x1586 = x1543.sumBasePrice
val x1587 = x1542.data.sumBasePrice(x1516.toInt) = x1586
val x1589 = x1543.sumDiscountedPrice
val x1590 = x1542.data.sumDiscountedPrice(x1516.toInt) = x1589
val x1592 = x1543.sumCharge
val x1593 = x1542.data.sumCharge(x1516.toInt) = x1592
val x1595 = x1543.avgQty
val x1596 = x1542.data.avgQty(x1516.toInt) = x1595
val x1598 = x1543.avgPrice
val x1599 = x1542.data.avgPrice(x1516.toInt) = x1598
val x1601 = x1543.avgDiscount
val x1602 = x1542.data.avgDiscount(x1516.toInt) = x1601
val x1604 = x1543.countOrder
val x1605 = x1542.data.countOrder(x1516.toInt) = x1604
x1516 = x1516 + 1
} // end fat loop x2063
val x1542 = x2063_data
val x2063 = x1542
val x2064 = x2063.size
val x2065 = x2063.data
val x2066 = x2065.returnFlag
val x2071 = x2065.lineStatus
val x2076 = {
val len = x2064.toInt
val comp = new generated.scala.container.IntComparator {
def compare(o1: Int, o2: Int): Int = {
val x1795 = o1
val x1796 = o2
val x2067 = x2066(x1795.toInt)
val x2068 = x2066(x1796.toInt)
val x2069 = x2067 - x2068
val x2070 = x2069 == 0
val x2075 = {
def x2075thenb(): Int = {
val x2072 = x2071(x1795.toInt)
val x2073 = x2071(x1796.toInt)
val x2074 = x2072 - x2073
x2074
}
def x2075elseb(): Int = {
x2069
}
if (x2070) {
x2075thenb()
} else { 
x2075elseb()
}
}
x2075.toInt
} }
val d = new Array[Int](len)
var i = 0; while(i < len) { d(i) = i; i += 1 }
generated.scala.container.SortingImpl.sort(d,comp)
d
}
val x2080 = x2065.sumQty
val x2082 = x2065.sumBasePrice
val x2084 = x2065.sumDiscountedPrice
val x2086 = x2065.sumCharge
val x2088 = x2065.avgQty
val x2090 = x2065.avgPrice
val x2092 = x2065.avgDiscount
val x2094 = x2065.countOrder
var x1850: Int = x2064
if (x1850 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1854 = new Array[Char](x1850.toInt)
if (x1850 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1855 = new Array[Char](x1850.toInt)
if (x1850 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1856 = new Array[Double](x1850.toInt)
if (x1850 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1857 = new Array[Double](x1850.toInt)
if (x1850 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1858 = new Array[Double](x1850.toInt)
if (x1850 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1859 = new Array[Double](x1850.toInt)
if (x1850 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1860 = new Array[Double](x1850.toInt)
if (x1850 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1861 = new Array[Double](x1850.toInt)
if (x1850 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1862 = new Array[Double](x1850.toInt)
if (x1850 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1863 = new Array[Int](x1850.toInt)
val x1864 = new generated.scala.DeliteArrayAnon201185238(x1854,x1855,x1856,x1857,x1858,x1859,x1860,x1861,x1862,x1863)
val x2097_data: generated.scala.DeliteArrayAnon201185238 = x1864
var x2097_size: Int = 0
var x2097_conditionals: Int = 0
var x1835: Int = 0
while (x1835 < x2064) {  // begin fat loop x2097
val x2077 = x2076(x1835.toInt)
val x2078 = x2066(x2077.toInt)
val x2079 = x2071(x2077.toInt)
val x2081 = x2080(x2077.toInt)
val x2083 = x2082(x2077.toInt)
val x2085 = x2084(x2077.toInt)
val x2087 = x2086(x2077.toInt)
val x2089 = x2088(x2077.toInt)
val x2091 = x2090(x2077.toInt)
val x2093 = x2092(x2077.toInt)
val x2095 = x2094(x2077.toInt)
val x2096 = new generated.scala.Anon201185238(x2078,x2079,x2081,x2083,x2085,x2087,x2089,x2091,x2093,x2095)
val x1849 = x2096
val x1848 = x2097_data
val x1868 = x1848.returnFlag
val x1869 = x1849.returnFlag
val x1870 = x1848.returnFlag(x1835.toInt) = x1869
val x1871 = x1848.lineStatus
val x1872 = x1849.lineStatus
val x1873 = x1848.lineStatus(x1835.toInt) = x1872
val x1874 = x1848.sumQty
val x1875 = x1849.sumQty
val x1876 = x1848.sumQty(x1835.toInt) = x1875
val x1877 = x1848.sumBasePrice
val x1878 = x1849.sumBasePrice
val x1879 = x1848.sumBasePrice(x1835.toInt) = x1878
val x1880 = x1848.sumDiscountedPrice
val x1881 = x1849.sumDiscountedPrice
val x1882 = x1848.sumDiscountedPrice(x1835.toInt) = x1881
val x1883 = x1848.sumCharge
val x1884 = x1849.sumCharge
val x1885 = x1848.sumCharge(x1835.toInt) = x1884
val x1886 = x1848.avgQty
val x1887 = x1849.avgQty
val x1888 = x1848.avgQty(x1835.toInt) = x1887
val x1889 = x1848.avgPrice
val x1890 = x1849.avgPrice
val x1891 = x1848.avgPrice(x1835.toInt) = x1890
val x1892 = x1848.avgDiscount
val x1893 = x1849.avgDiscount
val x1894 = x1848.avgDiscount(x1835.toInt) = x1893
val x1895 = x1848.countOrder
val x1896 = x1849.countOrder
val x1897 = x1848.countOrder(x1835.toInt) = x1896
x1835 = x1835 + 1
} // end fat loop x2097
val x1848 = x2097_data
val x2097 = x1848
val x2098 = new generated.scala.TableAnon201185238(x2064,x2097)
val x2099 = {
TablePrinter.printAsTable(x2098, 100)}
()
}
}
/*****************************************
  End of Generated Code                  
*******************************************/

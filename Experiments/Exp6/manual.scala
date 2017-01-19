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
val x91 = new generated.scala.DeliteArrayAnon1275687624(x75,x76,x77,x78,x79,x80,x81,x82,x83,x84,x85,x86,x87,x88,x89,x90)
var x376_buf: generated.scala.DeliteArrayAnon1275687624 = x91
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
val x68 = new generated.scala.Anon1275687624(x7,x9,x11,x13,x15,x17,x19,x21,x23,x25,x38,x51,x64,x65,x66,x67)
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
val x170 = new generated.scala.DeliteArrayAnon1275687624(x154,x155,x156,x157,x158,x159,x160,x161,x162,x163,x164,x165,x166,x167,x168,x169)
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
var x69: generated.scala.DeliteArrayAnon1275687624 = x376_buf
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
val x273 = new generated.scala.DeliteArrayAnon1275687624(x257,x258,x259,x260,x261,x262,x263,x264,x265,x266,x267,x268,x269,x270,x271,x272)
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
val x380 = ppl.delite.runtime.profiler.PerformanceTimer.start("app")
val x389 = x376.l_quantity
val x391 = x376.l_extendedprice
val x393 = x376.l_discount
val x395 = x376.l_tax
val x397 = x376.l_returnflag
val x399 = x376.l_linestatus
val x1115 = {
null.asInstanceOf[Null].asInstanceOf[generated.scala.Anon201185238]}
val x414 = "1998-12-01".split("-", 0)
val x415 = x414(0.toInt)
val x416 = {
x415.toInt}
val x421 = {
x416 << 9}
val x419 = x414(2.toInt)
val x420 = {
x419.toInt}
val x417 = x414(1.toInt)
val x418 = {
x417.toInt}
val x422 = {
x418 << 5}
val x423 = x422 + x420
val x424 = x421 + x423
def x425_block = { 
x424
}
val x425 = x425_block
val x401 = x376.l_shipdate
var x1333x2059_hash_pos: generated.scala.container.HashMapImpl[generated.scala.Tup2CharChar] = new generated.scala.container.HashMapImpl[generated.scala.Tup2CharChar](512,128)
var x1148: Int = 128
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1151 = new Array[Char](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1152 = new Array[Char](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1153 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1154 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1155 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1156 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1157 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1158 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1159 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1160 = new Array[Int](x1148.toInt)
val x1161 = new generated.scala.DeliteArrayAnon201185238(x1151,x1152,x1153,x1154,x1155,x1156,x1157,x1158,x1159,x1160)
var x1333_hash_data: generated.scala.DeliteArrayAnon201185238 = x1161
var x1472: Int = 128
if (x1472 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1475 = new Array[Int](x1472.toInt)
var x2059_hash_data: Array[Int] = x1475
var x1090: Int = 0
while (x1090 < x378) {  // begin fat loop x1333,x2059
val x1095 = x389(x1090.toInt)
val x1096 = x391(x1090.toInt)
val x1097 = x393(x1090.toInt)
val x1109 = {
1.0 - x1097}
val x1110 = {
x1096 * x1109}
val x1098 = x395(x1090.toInt)
val x1111 = {
1.0 + x1098}
val x1112 = {
x1110 * x1111}
val x1099 = x397(x1090.toInt)
val x1100 = x399(x1090.toInt)
val x1113 = new generated.scala.Anon201185238(x1099,x1100,x1095,x1096,x1110,x1112,x1095,x1096,x1097,1)
val x1108 = new generated.scala.Tup2CharChar(x1099,x1100)
val x1101 = x401(x1090.toInt)
val x1114 = {
x1101 <= x425}
if (x1114) {
// common key Block(Sym(1108)) for x1333x2059
val x1333x2059_sze: Int = x1333x2059_hash_pos.size
val x1333x2059_idx: Int = x1333x2059_hash_pos.put(x1108)
if (x1333x2059_idx == x1333x2059_sze) { // new key
val x1150: generated.scala.DeliteArrayAnon201185238 = x1333_hash_data
val x1147: generated.scala.Anon201185238 = x1113
val x1218 = x1333x2059_sze
val x1219 = x1150.returnFlag
val x1220 = x1219.length
val x1221 = x1220 - 1
val x1222 = x1218 > x1221
val x1290 = {
def x1290thenb(): Unit = {
val x1223 = x1220 < 16
val x1227 = {
def x1227thenb(): Int = {
16
}
def x1227elseb(): Int = {
val x1224 = x1220 * 2
val x1225 = x1224 < 0
val x1226 = {
def x1226thenb(): Int = {
2147483647
}
def x1226elseb(): Int = {
x1224
}
if (x1225) {
x1226thenb()
} else { 
x1226elseb()
}
}
x1226
}
if (x1223) {
x1227thenb()
} else { 
x1227elseb()
}
}
if (x1227 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1228 = new Array[Char](x1227.toInt)
if (x1227 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1229 = new Array[Char](x1227.toInt)
if (x1227 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1230 = new Array[Double](x1227.toInt)
if (x1227 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1231 = new Array[Double](x1227.toInt)
if (x1227 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1232 = new Array[Double](x1227.toInt)
if (x1227 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1233 = new Array[Double](x1227.toInt)
if (x1227 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1234 = new Array[Double](x1227.toInt)
if (x1227 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1235 = new Array[Double](x1227.toInt)
if (x1227 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1236 = new Array[Double](x1227.toInt)
if (x1227 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1237 = new Array[Int](x1227.toInt)
val x1239 = System.arraycopy(x1219,0.toInt,x1228,0.toInt,x1220.toInt)
val x1240 = x1150.lineStatus
val x1241 = System.arraycopy(x1240,0.toInt,x1229,0.toInt,x1220.toInt)
val x1242 = x1150.sumQty
val x1243 = System.arraycopy(x1242,0.toInt,x1230,0.toInt,x1220.toInt)
val x1244 = x1150.sumBasePrice
val x1245 = System.arraycopy(x1244,0.toInt,x1231,0.toInt,x1220.toInt)
val x1246 = x1150.sumDiscountedPrice
val x1247 = System.arraycopy(x1246,0.toInt,x1232,0.toInt,x1220.toInt)
val x1248 = x1150.sumCharge
val x1249 = System.arraycopy(x1248,0.toInt,x1233,0.toInt,x1220.toInt)
val x1250 = x1150.avgQty
val x1251 = System.arraycopy(x1250,0.toInt,x1234,0.toInt,x1220.toInt)
val x1252 = x1150.avgPrice
val x1253 = System.arraycopy(x1252,0.toInt,x1235,0.toInt,x1220.toInt)
val x1254 = x1150.avgDiscount
val x1255 = System.arraycopy(x1254,0.toInt,x1236,0.toInt,x1220.toInt)
val x1256 = x1150.countOrder
val x1257 = System.arraycopy(x1256,0.toInt,x1237,0.toInt,x1220.toInt)
val x1186 = x1147.returnFlag
val x1258 = x1228(x1218.toInt) = x1186
val x1189 = x1147.lineStatus
val x1259 = x1229(x1218.toInt) = x1189
val x1192 = x1147.sumQty
val x1260 = x1230(x1218.toInt) = x1192
val x1195 = x1147.sumBasePrice
val x1261 = x1231(x1218.toInt) = x1195
val x1198 = x1147.sumDiscountedPrice
val x1262 = x1232(x1218.toInt) = x1198
val x1201 = x1147.sumCharge
val x1263 = x1233(x1218.toInt) = x1201
val x1204 = x1147.avgQty
val x1264 = x1234(x1218.toInt) = x1204
val x1207 = x1147.avgPrice
val x1265 = x1235(x1218.toInt) = x1207
val x1210 = x1147.avgDiscount
val x1266 = x1236(x1218.toInt) = x1210
val x1213 = x1147.countOrder
val x1267 = x1237(x1218.toInt) = x1213
val x1238 = new generated.scala.DeliteArrayAnon201185238(x1228,x1229,x1230,x1231,x1232,x1233,x1234,x1235,x1236,x1237)
val x1268 = x1333_hash_data = x1238
x1268
}
def x1290elseb(): Unit = {
val x1186 = x1147.returnFlag
val x1270 = x1150.returnFlag(x1218.toInt) = x1186
val x1271 = x1150.lineStatus
val x1189 = x1147.lineStatus
val x1272 = x1150.lineStatus(x1218.toInt) = x1189
val x1273 = x1150.sumQty
val x1192 = x1147.sumQty
val x1274 = x1150.sumQty(x1218.toInt) = x1192
val x1275 = x1150.sumBasePrice
val x1195 = x1147.sumBasePrice
val x1276 = x1150.sumBasePrice(x1218.toInt) = x1195
val x1277 = x1150.sumDiscountedPrice
val x1198 = x1147.sumDiscountedPrice
val x1278 = x1150.sumDiscountedPrice(x1218.toInt) = x1198
val x1279 = x1150.sumCharge
val x1201 = x1147.sumCharge
val x1280 = x1150.sumCharge(x1218.toInt) = x1201
val x1281 = x1150.avgQty
val x1204 = x1147.avgQty
val x1282 = x1150.avgQty(x1218.toInt) = x1204
val x1283 = x1150.avgPrice
val x1207 = x1147.avgPrice
val x1284 = x1150.avgPrice(x1218.toInt) = x1207
val x1285 = x1150.avgDiscount
val x1210 = x1147.avgDiscount
val x1286 = x1150.avgDiscount(x1218.toInt) = x1210
val x1287 = x1150.countOrder
val x1213 = x1147.countOrder
val x1288 = x1150.countOrder(x1218.toInt) = x1213
()
}
if (x1222) {
x1290thenb()
} else { 
x1290elseb()
}
}
val x1474: Array[Int] = x2059_hash_data
val x1471: Int = 1
val x1483 = x1333x2059_sze
val x1484 = x1474.length
val x1485 = x1484 - 1
val x1486 = x1483 > x1485
val x1499 = {
def x1499thenb(): Unit = {
val x1487 = x1484 < 16
val x1491 = {
def x1491thenb(): Int = {
16
}
def x1491elseb(): Int = {
val x1488 = x1484 * 2
val x1489 = x1488 < 0
val x1490 = {
def x1490thenb(): Int = {
2147483647
}
def x1490elseb(): Int = {
x1488
}
if (x1489) {
x1490thenb()
} else { 
x1490elseb()
}
}
x1490
}
if (x1487) {
x1491thenb()
} else { 
x1491elseb()
}
}
if (x1491 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1492 = new Array[Int](x1491.toInt)
val x1493 = System.arraycopy(x1474,0.toInt,x1492,0.toInt,x1484.toInt)
val x1494 = x1492(x1483.toInt) = x1471
val x1495 = x2059_hash_data = x1492
x1495
}
def x1499elseb(): Unit = {
val x1497 = x1474(x1483.toInt) = x1471
x1497
}
if (x1486) {
x1499thenb()
} else { 
x1499elseb()
}
}
} else { // existing key
val x1149: Int = x1333x2059_idx
val x1150: generated.scala.DeliteArrayAnon201185238 = x1333_hash_data
val x1163 = x1150.returnFlag
val x1165 = x1150.lineStatus
val x1167 = x1150.sumQty
val x1169 = x1150.sumBasePrice
val x1171 = x1150.sumDiscountedPrice
val x1173 = x1150.sumCharge
val x1175 = x1150.avgQty
val x1177 = x1150.avgPrice
val x1179 = x1150.avgDiscount
val x1181 = x1150.countOrder
val x1164 = x1163(x1149.toInt)
val x1166 = x1165(x1149.toInt)
val x1168 = x1167(x1149.toInt)
val x1170 = x1169(x1149.toInt)
val x1172 = x1171(x1149.toInt)
val x1174 = x1173(x1149.toInt)
val x1176 = x1175(x1149.toInt)
val x1178 = x1177(x1149.toInt)
val x1180 = x1179(x1149.toInt)
val x1182 = x1181(x1149.toInt)
val x1183 = new generated.scala.Anon201185238(x1164,x1166,x1168,x1170,x1172,x1174,x1176,x1178,x1180,x1182)
val x1116: generated.scala.Anon201185238 = x1183
val x1117: generated.scala.Anon201185238 = x1113
val x1118 = x1116.returnFlag
val x1120 = x1116.lineStatus
val x1122 = x1116.sumQty
val x1123 = x1117.sumQty
val x1124 = {
x1122 + x1123}
val x1125 = x1116.sumBasePrice
val x1126 = x1117.sumBasePrice
val x1127 = {
x1125 + x1126}
val x1128 = x1116.sumDiscountedPrice
val x1129 = x1117.sumDiscountedPrice
val x1130 = {
x1128 + x1129}
val x1131 = x1116.sumCharge
val x1132 = x1117.sumCharge
val x1133 = {
x1131 + x1132}
val x1134 = x1116.avgQty
val x1135 = x1117.avgQty
val x1136 = {
x1134 + x1135}
val x1137 = x1116.avgPrice
val x1138 = x1117.avgPrice
val x1139 = {
x1137 + x1138}
val x1140 = x1116.avgDiscount
val x1141 = x1117.avgDiscount
val x1142 = {
x1140 + x1141}
val x1143 = x1116.countOrder
val x1144 = x1117.countOrder
val x1145 = {
x1143 + x1144}
val x1146 = new generated.scala.Anon201185238(x1118,x1120,x1124,x1127,x1130,x1133,x1136,x1139,x1142,x1145)
val x1147: generated.scala.Anon201185238 = x1146
val x1185 = x1150.returnFlag
val x1186 = x1147.returnFlag
val x1187 = x1150.returnFlag(x1149.toInt) = x1186
val x1188 = x1150.lineStatus
val x1189 = x1147.lineStatus
val x1190 = x1150.lineStatus(x1149.toInt) = x1189
val x1191 = x1150.sumQty
val x1192 = x1147.sumQty
val x1193 = x1150.sumQty(x1149.toInt) = x1192
val x1194 = x1150.sumBasePrice
val x1195 = x1147.sumBasePrice
val x1196 = x1150.sumBasePrice(x1149.toInt) = x1195
val x1197 = x1150.sumDiscountedPrice
val x1198 = x1147.sumDiscountedPrice
val x1199 = x1150.sumDiscountedPrice(x1149.toInt) = x1198
val x1200 = x1150.sumCharge
val x1201 = x1147.sumCharge
val x1202 = x1150.sumCharge(x1149.toInt) = x1201
val x1203 = x1150.avgQty
val x1204 = x1147.avgQty
val x1205 = x1150.avgQty(x1149.toInt) = x1204
val x1206 = x1150.avgPrice
val x1207 = x1147.avgPrice
val x1208 = x1150.avgPrice(x1149.toInt) = x1207
val x1209 = x1150.avgDiscount
val x1210 = x1147.avgDiscount
val x1211 = x1150.avgDiscount(x1149.toInt) = x1210
val x1212 = x1150.countOrder
val x1213 = x1147.countOrder
val x1214 = x1150.countOrder(x1149.toInt) = x1213
val x1473: Int = x1333x2059_idx
val x1474: Array[Int] = x2059_hash_data
val x1477 = x1474(x1473.toInt)
val x1468: Int = x1477
val x1469: Int = 1
val x1470 = x1468 + x1469
val x1471: Int = x1470
val x1479 = x1474(x1473.toInt) = x1471
}
}
x1090 = x1090 + 1
} // end fat loop x1333,x2059
val x1333x2059_sze: Int = x1333x2059_hash_pos.size
var x1150: generated.scala.DeliteArrayAnon201185238 = x1333_hash_data
x1148 = x1333x2059_sze
val x1292 = x1150.returnFlag
val x1293 = x1292.length
val x1294 = x1293 > x1148
val x1327 = {
def x1327thenb(): Unit = {
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1295 = new Array[Char](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1296 = new Array[Char](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1297 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1298 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1299 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1300 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1301 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1302 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1303 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1304 = new Array[Int](x1148.toInt)
val x1306 = System.arraycopy(x1292,0.toInt,x1295,0.toInt,x1148.toInt)
val x1307 = x1150.lineStatus
val x1308 = System.arraycopy(x1307,0.toInt,x1296,0.toInt,x1148.toInt)
val x1309 = x1150.sumQty
val x1310 = System.arraycopy(x1309,0.toInt,x1297,0.toInt,x1148.toInt)
val x1311 = x1150.sumBasePrice
val x1312 = System.arraycopy(x1311,0.toInt,x1298,0.toInt,x1148.toInt)
val x1313 = x1150.sumDiscountedPrice
val x1314 = System.arraycopy(x1313,0.toInt,x1299,0.toInt,x1148.toInt)
val x1315 = x1150.sumCharge
val x1316 = System.arraycopy(x1315,0.toInt,x1300,0.toInt,x1148.toInt)
val x1317 = x1150.avgQty
val x1318 = System.arraycopy(x1317,0.toInt,x1301,0.toInt,x1148.toInt)
val x1319 = x1150.avgPrice
val x1320 = System.arraycopy(x1319,0.toInt,x1302,0.toInt,x1148.toInt)
val x1321 = x1150.avgDiscount
val x1322 = System.arraycopy(x1321,0.toInt,x1303,0.toInt,x1148.toInt)
val x1323 = x1150.countOrder
val x1324 = System.arraycopy(x1323,0.toInt,x1304,0.toInt,x1148.toInt)
val x1305 = new generated.scala.DeliteArrayAnon201185238(x1295,x1296,x1297,x1298,x1299,x1300,x1301,x1302,x1303,x1304)
val x1325 = x1150 = x1305
x1325
}
if (x1294) {
x1327thenb()
}
}
val x1333: generated.scala.DeliteArrayAnon201185238 = x1150
var x1474: Array[Int] = x2059_hash_data
x1472 = x1333x2059_sze
val x1501 = x1474.length
val x1502 = x1501 > x1472
val x1507 = {
def x1507thenb(): Unit = {
if (x1472 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1503 = new Array[Int](x1472.toInt)
val x1504 = System.arraycopy(x1474,0.toInt,x1503,0.toInt,x1472.toInt)
val x1505 = x1474 = x1503
x1505
}
if (x1502) {
x1507thenb()
}
}
val x2059: Array[Int] = x1474
val x1334 = x1333.returnFlag
val x1335 = x1334.length
val x1519 = x1333.lineStatus
val x1521 = x1333.sumQty
val x1523 = x1333.sumBasePrice
val x1525 = x1333.sumDiscountedPrice
val x1527 = x1333.sumCharge
val x1535 = x1333.countOrder
val x1529 = x1333.avgQty
val x1531 = x1333.avgPrice
val x1533 = x1333.avgDiscount
def x1731_block = { 
true
}
val x1731 = x1731_block
var x1545: Int = x1335
var x1549: Int = x1545
if (x1545 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1550 = new Array[Char](x1545.toInt)
if (x1545 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1551 = new Array[Char](x1545.toInt)
if (x1545 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1552 = new Array[Double](x1545.toInt)
if (x1545 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1553 = new Array[Double](x1545.toInt)
if (x1545 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1554 = new Array[Double](x1545.toInt)
if (x1545 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1555 = new Array[Double](x1545.toInt)
if (x1545 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1556 = new Array[Double](x1545.toInt)
if (x1545 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1557 = new Array[Double](x1545.toInt)
if (x1545 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1558 = new Array[Double](x1545.toInt)
if (x1545 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1559 = new Array[Int](x1545.toInt)
var x1561: Array[Char] = x1550
var x1562: Array[Char] = x1551
var x1563: Array[Double] = x1552
var x1564: Array[Double] = x1553
var x1565: Array[Double] = x1554
var x1566: Array[Double] = x1555
var x1567: Array[Double] = x1556
var x1568: Array[Double] = x1557
var x1569: Array[Double] = x1558
var x1570: Array[Int] = x1559
val x1571 = new generated.scala.DeliteArrayAnon201185238(x1561,x1562,x1563,x1564,x1565,x1566,x1567,x1568,x1569,x1570)
val x1572 = new generated.scala.TableAnon201185238(x1549,x1571)
val x2065_data: generated.scala.TableAnon201185238 = x1572
var x2065_size: Int = 0
var x2065_conditionals: Int = 0
var x1517: Int = 0
while (x1517 < x1335) {  // begin fat loop x2065
val x1518 = x1334(x1517.toInt)
val x1520 = x1519(x1517.toInt)
val x1522 = x1521(x1517.toInt)
val x1524 = x1523(x1517.toInt)
val x1526 = x1525(x1517.toInt)
val x1528 = x1527(x1517.toInt)
val x1536 = x1535(x1517.toInt)
val x1530 = x1529(x1517.toInt)
val x2060 = x2059(x1517.toInt)
val x2061 = {
implicitly[Fractional[Double]].div(x1530,x2060)}
val x1532 = x1531(x1517.toInt)
val x2062 = {
implicitly[Fractional[Double]].div(x1532,x2060)}
val x1534 = x1533(x1517.toInt)
val x2063 = {
implicitly[Fractional[Double]].div(x1534,x2060)}
val x2064 = new generated.scala.Anon201185238(x1518,x1520,x1522,x1524,x1526,x1528,x2061,x2062,x2063,x1536)
val x1544 = x2064
val x1543 = x2065_data
val x1576 = x1543.data
val x1578 = x1544.returnFlag
val x1579 = x1543.data.returnFlag(x1517.toInt) = x1578
val x1581 = x1544.lineStatus
val x1582 = x1543.data.lineStatus(x1517.toInt) = x1581
val x1584 = x1544.sumQty
val x1585 = x1543.data.sumQty(x1517.toInt) = x1584
val x1587 = x1544.sumBasePrice
val x1588 = x1543.data.sumBasePrice(x1517.toInt) = x1587
val x1590 = x1544.sumDiscountedPrice
val x1591 = x1543.data.sumDiscountedPrice(x1517.toInt) = x1590
val x1593 = x1544.sumCharge
val x1594 = x1543.data.sumCharge(x1517.toInt) = x1593
val x1596 = x1544.avgQty
val x1597 = x1543.data.avgQty(x1517.toInt) = x1596
val x1599 = x1544.avgPrice
val x1600 = x1543.data.avgPrice(x1517.toInt) = x1599
val x1602 = x1544.avgDiscount
val x1603 = x1543.data.avgDiscount(x1517.toInt) = x1602
val x1605 = x1544.countOrder
val x1606 = x1543.data.countOrder(x1517.toInt) = x1605
x1517 = x1517 + 1
} // end fat loop x2065
val x1543 = x2065_data
val x2065 = x1543
val x2066 = x2065.size
val x2067 = x2065.data
val x2068 = x2067.returnFlag
val x2073 = x2067.lineStatus
val x2078 = {
val len = x2066.toInt
val comp = new generated.scala.container.IntComparator {
def compare(o1: Int, o2: Int): Int = {
val x1796 = o1
val x1797 = o2
val x2069 = x2068(x1796.toInt)
val x2070 = x2068(x1797.toInt)
val x2071 = x2069 - x2070
val x2072 = x2071 == 0
val x2077 = {
def x2077thenb(): Int = {
val x2074 = x2073(x1796.toInt)
val x2075 = x2073(x1797.toInt)
val x2076 = x2074 - x2075
x2076
}
def x2077elseb(): Int = {
x2071
}
if (x2072) {
x2077thenb()
} else { 
x2077elseb()
}
}
x2077.toInt
} }
val d = new Array[Int](len)
var i = 0; while(i < len) { d(i) = i; i += 1 }
generated.scala.container.SortingImpl.sort(d,comp)
d
}
val x2082 = x2067.sumQty
val x2084 = x2067.sumBasePrice
val x2086 = x2067.sumDiscountedPrice
val x2088 = x2067.sumCharge
val x2090 = x2067.avgQty
val x2092 = x2067.avgPrice
val x2094 = x2067.avgDiscount
val x2096 = x2067.countOrder
var x1851: Int = x2066
if (x1851 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1855 = new Array[Char](x1851.toInt)
if (x1851 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1856 = new Array[Char](x1851.toInt)
if (x1851 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1857 = new Array[Double](x1851.toInt)
if (x1851 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1858 = new Array[Double](x1851.toInt)
if (x1851 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1859 = new Array[Double](x1851.toInt)
if (x1851 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1860 = new Array[Double](x1851.toInt)
if (x1851 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1861 = new Array[Double](x1851.toInt)
if (x1851 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1862 = new Array[Double](x1851.toInt)
if (x1851 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1863 = new Array[Double](x1851.toInt)
if (x1851 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1864 = new Array[Int](x1851.toInt)
val x1865 = new generated.scala.DeliteArrayAnon201185238(x1855,x1856,x1857,x1858,x1859,x1860,x1861,x1862,x1863,x1864)
val x2099_data: generated.scala.DeliteArrayAnon201185238 = x1865
var x2099_size: Int = 0
var x2099_conditionals: Int = 0
var x1836: Int = 0
while (x1836 < x2066) {  // begin fat loop x2099
val x2079 = x2078(x1836.toInt)
val x2080 = x2068(x2079.toInt)
val x2081 = x2073(x2079.toInt)
val x2083 = x2082(x2079.toInt)
val x2085 = x2084(x2079.toInt)
val x2087 = x2086(x2079.toInt)
val x2089 = x2088(x2079.toInt)
val x2091 = x2090(x2079.toInt)
val x2093 = x2092(x2079.toInt)
val x2095 = x2094(x2079.toInt)
val x2097 = x2096(x2079.toInt)
val x2098 = new generated.scala.Anon201185238(x2080,x2081,x2083,x2085,x2087,x2089,x2091,x2093,x2095,x2097)
val x1850 = x2098
val x1849 = x2099_data
val x1869 = x1849.returnFlag
val x1870 = x1850.returnFlag
val x1871 = x1849.returnFlag(x1836.toInt) = x1870
val x1872 = x1849.lineStatus
val x1873 = x1850.lineStatus
val x1874 = x1849.lineStatus(x1836.toInt) = x1873
val x1875 = x1849.sumQty
val x1876 = x1850.sumQty
val x1877 = x1849.sumQty(x1836.toInt) = x1876
val x1878 = x1849.sumBasePrice
val x1879 = x1850.sumBasePrice
val x1880 = x1849.sumBasePrice(x1836.toInt) = x1879
val x1881 = x1849.sumDiscountedPrice
val x1882 = x1850.sumDiscountedPrice
val x1883 = x1849.sumDiscountedPrice(x1836.toInt) = x1882
val x1884 = x1849.sumCharge
val x1885 = x1850.sumCharge
val x1886 = x1849.sumCharge(x1836.toInt) = x1885
val x1887 = x1849.avgQty
val x1888 = x1850.avgQty
val x1889 = x1849.avgQty(x1836.toInt) = x1888
val x1890 = x1849.avgPrice
val x1891 = x1850.avgPrice
val x1892 = x1849.avgPrice(x1836.toInt) = x1891
val x1893 = x1849.avgDiscount
val x1894 = x1850.avgDiscount
val x1895 = x1849.avgDiscount(x1836.toInt) = x1894
val x1896 = x1849.countOrder
val x1897 = x1850.countOrder
val x1898 = x1849.countOrder(x1836.toInt) = x1897
x1836 = x1836 + 1
} // end fat loop x2099
val x1849 = x2099_data
val x2099 = x1849
val x2100 = new generated.scala.TableAnon201185238(x2066,x2099)
val x2101 = ppl.delite.runtime.profiler.PerformanceTimer.stop("app")
val x2102 = {
TablePrinter.printAsTable(x2100, 100)}
()
}
}
/*****************************************
  End of Generated Code                  
*******************************************/

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
val x23 = new generated.scala.DeliteArrayAnon717052109(x19,x20,x21,x22)
var x116_buf: generated.scala.DeliteArrayAnon717052109 = x23
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
val x12 = new generated.scala.Anon717052109(x7,x8,x10,x11)
val x13 = x116_buf
val x14 = x12
if (true) {
val x40 = x116_size
val x41 = x13.n_nationkey
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
val x56 = x13.n_name
val x57 = System.arraycopy(x56,0.toInt,x51,0.toInt,x42.toInt)
val x58 = x13.n_regionkey
val x59 = System.arraycopy(x58,0.toInt,x52,0.toInt,x42.toInt)
val x60 = x13.n_comment
val x61 = System.arraycopy(x60,0.toInt,x53,0.toInt,x42.toInt)
val x28 = x14.n_nationkey
val x62 = x50(x40.toInt) = x28
val x31 = x14.n_name
val x63 = x51(x40.toInt) = x31
val x34 = x14.n_regionkey
val x64 = x52(x40.toInt) = x34
val x37 = x14.n_comment
val x65 = x53(x40.toInt) = x37
val x54 = new generated.scala.DeliteArrayAnon717052109(x50,x51,x52,x53)
val x66 = x116_buf = x54
x66
}
def x76elseb(): Unit = {
val x28 = x14.n_nationkey
val x68 = x13.n_nationkey(x40.toInt) = x28
val x69 = x13.n_name
val x31 = x14.n_name
val x70 = x13.n_name(x40.toInt) = x31
val x71 = x13.n_regionkey
val x34 = x14.n_regionkey
val x72 = x13.n_regionkey(x40.toInt) = x34
val x73 = x13.n_comment
val x37 = x14.n_comment
val x74 = x13.n_comment(x40.toInt) = x37
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
var x13: generated.scala.DeliteArrayAnon717052109 = x116_buf
x15 = x116_conditionals
val x78 = x13.n_nationkey
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
val x87 = x13.n_name
val x88 = System.arraycopy(x87,0.toInt,x82,0.toInt,x15.toInt)
val x89 = x13.n_regionkey
val x90 = System.arraycopy(x89,0.toInt,x83,0.toInt,x15.toInt)
val x91 = x13.n_comment
val x92 = System.arraycopy(x91,0.toInt,x84,0.toInt,x15.toInt)
val x85 = new generated.scala.DeliteArrayAnon717052109(x81,x82,x83,x84)
val x93 = x13 = x85
x93
}
if (x80) {
x95thenb()
}
}
val x116 = x13
val x117 = x116.n_nationkey
val x118 = x117.length
val x122 = x116.n_name
val x124 = x116.n_regionkey
val x126 = x116.n_comment
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
val x146 = new generated.scala.DeliteArrayAnon717052109(x142,x143,x144,x145)
val x147 = new generated.scala.TableAnon717052109(x136,x146)
var x273_buf: generated.scala.TableAnon717052109 = x147
var x273_size: Int = 0
var x273_conditionals: Int = 0
var x120: Int = 0
while (x120 < x118) {  // begin fat loop x273
val x121 = x117(x120.toInt)
val x123 = x122(x120.toInt)
val x125 = x124(x120.toInt)
val x127 = x126(x120.toInt)
val x128 = new generated.scala.Anon717052109(x121,x123,x125,x127)
val x129 = {
x125 > 0}
if (x129) {
val x130 = x273_buf
val x131 = x128
if (x240) {
val x153 = x131.n_nationkey
val x156 = x131.n_name
val x159 = x131.n_regionkey
val x162 = x131.n_comment
def x238_block = { 
def x236_block = { 
val x165 = x130.size
val x171 = x165 + 1
def x234_block = { 
def x223_block = { 
def x207_block = { 
val x166 = x130.data
val x167 = x166.n_nationkey
val x168 = x167.length
val x169 = x168 - x165
val x170 = {
x169 < 1}
val x205 = {
def x205thenb(): Unit = {
val x172 = x168 * 2
val x173 = {
4 max x172}
val x190 = x166.n_name
val x192 = x166.n_regionkey
val x194 = x166.n_comment
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
val x200 = new generated.scala.DeliteArrayAnon717052109(x196,x197,x198,x199)
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
val x211 = x208.n_nationkey
val x212 = System.arraycopy(x211,x165.toInt,x130.data.n_nationkey,x171.toInt,x210.toInt)
val x213 = x208.n_name
val x214 = System.arraycopy(x213,x165.toInt,x130.data.n_name,x171.toInt,x210.toInt)
val x215 = x208.n_regionkey
val x216 = System.arraycopy(x215,x165.toInt,x130.data.n_regionkey,x171.toInt,x210.toInt)
val x217 = x208.n_comment
val x218 = System.arraycopy(x217,x165.toInt,x130.data.n_comment,x171.toInt,x210.toInt)
val x219 = x130.size
val x220 = x219 + 1
val x221 = x130.size = x220
x221
}
val x223 = x223_block
val x224 = x130.data
val x226 = x130.data.n_nationkey(x165.toInt) = x153
val x228 = x130.data.n_name(x165.toInt) = x156
val x230 = x130.data.n_regionkey(x165.toInt) = x159
val x232 = x130.data.n_comment(x165.toInt) = x162
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
var x130: generated.scala.TableAnon717052109 = x273_buf
x132 = x273_conditionals
val x241 = x130.size = x132
val x273 = x130
val x274 = x273.size
val x276 = x273.data
val x279 = x276.n_name
def x358_block = { 
true
}
val x358 = x358_block
var x289: Int = x274
var x293: Int = x289
if (x289 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x294 = new Array[java.lang.String](x289.toInt)
var x296: Array[java.lang.String] = x294
val x297 = new generated.scala.DeliteArrayAnon140607009(x296)
val x298 = new generated.scala.TableAnon140607009(x293,x297)
val x376_data: generated.scala.TableAnon140607009 = x298
var x376_size: Int = 0
var x376_conditionals: Int = 0
var x275: Int = 0
while (x275 < x274) {  // begin fat loop x376
val x280 = x279(x275.toInt)
val x286 = new generated.scala.Anon140607009(x280)
val x288 = x286
val x287 = x376_data
val x302 = x287.data
val x304 = x288.n_name
val x305 = x287.data.n_name(x275.toInt) = x304
x275 = x275 + 1
} // end fat loop x376
val x287 = x376_data
val x376 = x287
val x377 = {
TablePrinter.printAsTable(x376, 100)}
()
}
}
/*****************************************
End of Generated Code                  
*******************************************/

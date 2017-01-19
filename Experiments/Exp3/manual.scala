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
val x124 = x116.n_regionkey
val x349 = {
null.asInstanceOf[Null].asInstanceOf[generated.scala.Anon1415709433]}
var x424_hash_pos: generated.scala.container.HashMapImpl[Int] = new generated.scala.container.HashMapImpl[Int](512,128)
var x359: Int = 128
if (x359 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x362 = new Array[Int](x359.toInt)
if (x359 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x363 = new Array[Int](x359.toInt)
val x364 = new generated.scala.DeliteArrayAnon1415709433(x362,x363)
var x424_hash_data: generated.scala.DeliteArrayAnon1415709433 = x364
var x341: Int = 0
while (x341 < x118) {  // begin fat loop x424
val x344 = x124(x341.toInt)
val x347 = new generated.scala.Anon1415709433(x344,1)
val x348 = {
x344 > 0}
if (x348) {
// common key Block(Sym(344)) for x424
val x424_sze: Int = x424_hash_pos.size
val x424_idx: Int = x424_hash_pos.put(x344)
if (x424_idx == x424_sze) { // new key
val x361: generated.scala.DeliteArrayAnon1415709433 = x424_hash_data
val x358: generated.scala.Anon1415709433 = x347
val x381 = x424_sze
val x382 = x361.n_regionkey
val x383 = x382.length
val x384 = x383 - 1
val x385 = x381 > x384
val x405 = {
def x405thenb(): Unit = {
val x386 = x383 < 16
val x390 = {
def x390thenb(): Int = {
16
}
def x390elseb(): Int = {
val x387 = x383 * 2
val x388 = x387 < 0
val x389 = {
def x389thenb(): Int = {
2147483647
}
def x389elseb(): Int = {
x387
}
if (x388) {
x389thenb()
} else { 
x389elseb()
}
}
x389
}
if (x386) {
x390thenb()
} else { 
x390elseb()
}
}
if (x390 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x391 = new Array[Int](x390.toInt)
if (x390 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x392 = new Array[Int](x390.toInt)
val x394 = System.arraycopy(x382,0.toInt,x391,0.toInt,x383.toInt)
val x395 = x361.count
val x396 = System.arraycopy(x395,0.toInt,x392,0.toInt,x383.toInt)
val x373 = x358.n_regionkey
val x397 = x391(x381.toInt) = x373
val x376 = x358.count
val x398 = x392(x381.toInt) = x376
val x393 = new generated.scala.DeliteArrayAnon1415709433(x391,x392)
val x399 = x424_hash_data = x393
x399
}
def x405elseb(): Unit = {
val x373 = x358.n_regionkey
val x401 = x361.n_regionkey(x381.toInt) = x373
val x402 = x361.count
val x376 = x358.count
val x403 = x361.count(x381.toInt) = x376
()
}
if (x385) {
x405thenb()
} else { 
x405elseb()
}
}
} else { // existing key
val x360: Int = x424_idx
val x361: generated.scala.DeliteArrayAnon1415709433 = x424_hash_data
val x366 = x361.n_regionkey
val x368 = x361.count
val x367 = x366(x360.toInt)
val x369 = x368(x360.toInt)
val x370 = new generated.scala.Anon1415709433(x367,x369)
val x350: generated.scala.Anon1415709433 = x370
val x351: generated.scala.Anon1415709433 = x347
val x352 = x350.n_regionkey
val x354 = x350.count
val x355 = x351.count
val x356 = {
x354 + x355}
val x357 = new generated.scala.Anon1415709433(x352,x356)
val x358: generated.scala.Anon1415709433 = x357
val x372 = x361.n_regionkey
val x373 = x358.n_regionkey
val x374 = x361.n_regionkey(x360.toInt) = x373
val x375 = x361.count
val x376 = x358.count
val x377 = x361.count(x360.toInt) = x376
}
}
x341 = x341 + 1
} // end fat loop x424
val x424_sze: Int = x424_hash_pos.size
var x361: generated.scala.DeliteArrayAnon1415709433 = x424_hash_data
x359 = x424_sze
val x407 = x361.n_regionkey
val x408 = x407.length
val x409 = x408 > x359
val x418 = {
def x418thenb(): Unit = {
if (x359 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x410 = new Array[Int](x359.toInt)
if (x359 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x411 = new Array[Int](x359.toInt)
val x413 = System.arraycopy(x407,0.toInt,x410,0.toInt,x359.toInt)
val x414 = x361.count
val x415 = System.arraycopy(x414,0.toInt,x411,0.toInt,x359.toInt)
val x412 = new generated.scala.DeliteArrayAnon1415709433(x410,x411)
val x416 = x361 = x412
x416
}
if (x409) {
x418thenb()
}
}
val x424: generated.scala.DeliteArrayAnon1415709433 = x361
val x425 = x424.n_regionkey
val x426 = x425.length
val x547 = x424.count
def x635_block = { 
true
}
val x635 = x635_block
var x553: Int = x426
var x557: Int = x553
if (x553 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x558 = new Array[Int](x553.toInt)
if (x553 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x559 = new Array[Int](x553.toInt)
var x561: Array[Int] = x558
var x562: Array[Int] = x559
val x563 = new generated.scala.DeliteArrayAnon1415709433(x561,x562)
val x564 = new generated.scala.TableAnon1415709433(x557,x563)
val x658_data: generated.scala.TableAnon1415709433 = x564
var x658_size: Int = 0
var x658_conditionals: Int = 0
var x545: Int = 0
while (x545 < x426) {  // begin fat loop x658
val x546 = x425(x545.toInt)
val x548 = x547(x545.toInt)
val x549 = new generated.scala.Anon1415709433(x546,x548)
val x552 = x549
val x551 = x658_data
val x568 = x551.data
val x570 = x552.n_regionkey
val x571 = x551.data.n_regionkey(x545.toInt) = x570
val x573 = x552.count
val x574 = x551.data.count(x545.toInt) = x573
x545 = x545 + 1
} // end fat loop x658
val x551 = x658_data
val x658 = x551
val x659 = {
TablePrinter.printAsTable(x658, 100)}
()
}
}
/*****************************************
  End of Generated Code                  
*******************************************/

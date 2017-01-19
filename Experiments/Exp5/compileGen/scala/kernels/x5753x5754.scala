package generated.scala
//activation record for fat loop
final class activation_x5753x5754 {
var left_act: activation_x5753x5754 = _
var all_acts: Array[activation_x5753x5754] = _
var x5753x5754_hash_pos: generated.scala.container.HashMapImpl[generated.scala.Anon1637442313] = _
var x5753x5754_size: Int = _
var x5753: generated.scala.DeliteArrayAnon1187970594 = _
var x5753_hash_data: generated.scala.DeliteArrayAnon1187970594 = _
var x5754: Array[Int] = _
var x5754_hash_data: Array[Int] = _
}
object activation_x5753x5754 {
}
object kernel_x5753x5754 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2:Long,x1916:generated.scala.Anon1187970594,x1:generated.scala.io.DeliteFileInputStream,x414:Int): activation_x5753x5754 = {
val x5753x5754_closure = new generated.scala.DeliteOpMultiLoop[activation_x5753x5754] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x2
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x5753x5754 = {
val __act: activation_x5753x5754 = new activation_x5753x5754()
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5753x5754,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x5753x5754]): activation_x5753x5754 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x5753x5754 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x5753x5754 = sync.get(localStart)
//combine local
var i: Int = localStart+1
while (i < localEnd) {
combine(resourceInfo,act,sync.get(i))
i = i+1
}
//combine remote
var half: Int = tid
var step: Int = 1
while ((half % 2 == 0) && (tid + step < numThreads)) {
combine(resourceInfo,act,sync.getC(tid+step))
half = half / 2
step = step * 2
}
sync.setC(tid,act)
sync.awaitBarrier
if (tid == 0) {
finalize(resourceInfo,act)
}
act
}

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5753x5754): activation_x5753x5754 = {
val act: activation_x5753x5754 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5753x5754,start:Long,end:Long): activation_x5753x5754 = {
val x1_stream: generated.scala.io.DeliteFileInputStream = x1.openCopyAtNewLine(start)
val x1_stream_offset: Long = x1_stream.streamOffset
val isEmpty: Boolean = end <= x1_stream.position
val __act2: activation_x5753x5754 = init(resourceInfo,__act,-1,isEmpty,x1_stream)
while (x1_stream.position < x1_stream_offset + end) {
process(resourceInfo,__act2,-1,x1_stream)
}
x1_stream.close();
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5753x5754,x3:Int,isEmpty:Boolean,x1_stream:generated.scala.io.DeliteFileInputStream): activation_x5753x5754 = {
val __act2: activation_x5753x5754 = new activation_x5753x5754()
__act2.x5753x5754_hash_pos = new generated.scala.container.HashMapImpl[generated.scala.Anon1637442313](512,128)
__act2.x5753x5754_size = -1
val x1949: Int = 128
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4598 = new Array[java.lang.String](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4599 = new Array[java.lang.String](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4600 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4601 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4602 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4603 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4604 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4605 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4606 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4607 = new Array[Int](x1949.toInt)
val x4608 = new generated.scala.DeliteArrayAnon1187970594(x4598,x4599,x4600,x4601,x4602,x4603,x4604,x4605,x4606,x4607)
__act2.x5753_hash_data = x4608
val x2240: Int = 128
if (x2240 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4783 = new Array[Int](x2240.toInt)
__act2.x5754_hash_data = x4783
if (!isEmpty) {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
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
val x5510 = {
x36 <= x414}
val x14 = x5(4.toInt)
val x15 = {
x14.toDouble}
val x16 = x5(5.toInt)
val x17 = {
x16.toDouble}
val x18 = x5(6.toInt)
val x19 = {
x18.toDouble}
val x22 = x5(8.toInt)
val x23 = x5(9.toInt)
val x5686 = {
1.0 - x19}
val x5687 = {
x17 * x5686}
val x20 = x5(7.toInt)
val x21 = {
x20.toDouble}
val x5688 = {
1.0 + x21}
val x5689 = {
x5687 * x5688}
val x5690 = new generated.scala.Anon1187970594(x22,x23,x15,x17,x5687,x5689,x15,x17,x19,1)
val x5691 = new generated.scala.Anon1637442313(x22,x23)
if (true && x5510) {
// common key Block(Sym(5691)) for x5753x5754
val x5753x5754_sze: Int = __act2.x5753x5754_hash_pos.size
val x5753x5754_idx: Int = __act2.x5753x5754_hash_pos.put(x5691)
if (x5753x5754_idx == x5753x5754_sze) { // new key
val x1951: generated.scala.DeliteArrayAnon1187970594 = __act2.x5753_hash_data
val x1948: generated.scala.Anon1187970594 = x5690
val x4655 = x5753x5754_sze
val x4656 = x1951.l_returnflag_44
val x4657 = x4656.length
val x4658 = x4657 - 1
val x4659 = x4655 > x4658
val x4727 = {
def x4727thenb(): Unit = {
val x4660 = x4657 < 16
val x4664 = {
def x4664thenb(): Int = {
16
}
def x4664elseb(): Int = {
val x4661 = x4657 * 2
val x4662 = x4661 < 0
val x4663 = {
def x4663thenb(): Int = {
2147483647
}
def x4663elseb(): Int = {
x4661
}
if (x4662) {
x4663thenb()
} else { 
x4663elseb()
}
}
x4663
}
if (x4660) {
x4664thenb()
} else { 
x4664elseb()
}
}
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4665 = new Array[java.lang.String](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4666 = new Array[java.lang.String](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4667 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4668 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4669 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4670 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4671 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4672 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4673 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4674 = new Array[Int](x4664.toInt)
val x4675 = System.arraycopy(x4656,0.toInt,x4665,0.toInt,x4657.toInt)
val x4676 = x1951.l_linestatus_45
val x4677 = System.arraycopy(x4676,0.toInt,x4666,0.toInt,x4657.toInt)
val x4678 = x1951.sum_qty_138
val x4679 = System.arraycopy(x4678,0.toInt,x4667,0.toInt,x4657.toInt)
val x4680 = x1951.sum_base_price_139
val x4681 = System.arraycopy(x4680,0.toInt,x4668,0.toInt,x4657.toInt)
val x4682 = x1951.sum_disc_price_140
val x4683 = System.arraycopy(x4682,0.toInt,x4669,0.toInt,x4657.toInt)
val x4684 = x1951.sum_charge_141
val x4685 = System.arraycopy(x4684,0.toInt,x4670,0.toInt,x4657.toInt)
val x4686 = x1951.avg_qty_142
val x4687 = System.arraycopy(x4686,0.toInt,x4671,0.toInt,x4657.toInt)
val x4688 = x1951.avg_price_143
val x4689 = System.arraycopy(x4688,0.toInt,x4672,0.toInt,x4657.toInt)
val x4690 = x1951.avg_disc_144
val x4691 = System.arraycopy(x4690,0.toInt,x4673,0.toInt,x4657.toInt)
val x4692 = x1951.count_order_145
val x4693 = System.arraycopy(x4692,0.toInt,x4674,0.toInt,x4657.toInt)
val x1987 = x1948.l_returnflag_44
val x4694 = x4665(x4655.toInt) = x1987
val x1990 = x1948.l_linestatus_45
val x4695 = x4666(x4655.toInt) = x1990
val x1993 = x1948.sum_qty_138
val x4696 = x4667(x4655.toInt) = x1993
val x1996 = x1948.sum_base_price_139
val x4697 = x4668(x4655.toInt) = x1996
val x1999 = x1948.sum_disc_price_140
val x4698 = x4669(x4655.toInt) = x1999
val x2002 = x1948.sum_charge_141
val x4699 = x4670(x4655.toInt) = x2002
val x2005 = x1948.avg_qty_142
val x4700 = x4671(x4655.toInt) = x2005
val x2008 = x1948.avg_price_143
val x4701 = x4672(x4655.toInt) = x2008
val x2011 = x1948.avg_disc_144
val x4702 = x4673(x4655.toInt) = x2011
val x2014 = x1948.count_order_145
val x4703 = x4674(x4655.toInt) = x2014
val x4704 = new generated.scala.DeliteArrayAnon1187970594(x4665,x4666,x4667,x4668,x4669,x4670,x4671,x4672,x4673,x4674)
val x4705 = __act2.x5753_hash_data = x4704
x4705
}
def x4727elseb(): Unit = {
val x1987 = x1948.l_returnflag_44
val x4707 = x1951.l_returnflag_44(x4655.toInt) = x1987
val x4708 = x1951.l_linestatus_45
val x1990 = x1948.l_linestatus_45
val x4709 = x1951.l_linestatus_45(x4655.toInt) = x1990
val x4710 = x1951.sum_qty_138
val x1993 = x1948.sum_qty_138
val x4711 = x1951.sum_qty_138(x4655.toInt) = x1993
val x4712 = x1951.sum_base_price_139
val x1996 = x1948.sum_base_price_139
val x4713 = x1951.sum_base_price_139(x4655.toInt) = x1996
val x4714 = x1951.sum_disc_price_140
val x1999 = x1948.sum_disc_price_140
val x4715 = x1951.sum_disc_price_140(x4655.toInt) = x1999
val x4716 = x1951.sum_charge_141
val x2002 = x1948.sum_charge_141
val x4717 = x1951.sum_charge_141(x4655.toInt) = x2002
val x4718 = x1951.avg_qty_142
val x2005 = x1948.avg_qty_142
val x4719 = x1951.avg_qty_142(x4655.toInt) = x2005
val x4720 = x1951.avg_price_143
val x2008 = x1948.avg_price_143
val x4721 = x1951.avg_price_143(x4655.toInt) = x2008
val x4722 = x1951.avg_disc_144
val x2011 = x1948.avg_disc_144
val x4723 = x1951.avg_disc_144(x4655.toInt) = x2011
val x4724 = x1951.count_order_145
val x2014 = x1948.count_order_145
val x4725 = x1951.count_order_145(x4655.toInt) = x2014
()
}
if (x4659) {
x4727thenb()
} else { 
x4727elseb()
}
}
val x2242: Array[Int] = __act2.x5754_hash_data
val x2239: Int = 1
val x4791 = x5753x5754_sze
val x4792 = x2242.length
val x4793 = x4792 - 1
val x4794 = x4791 > x4793
val x4807 = {
def x4807thenb(): Unit = {
val x4795 = x4792 < 16
val x4799 = {
def x4799thenb(): Int = {
16
}
def x4799elseb(): Int = {
val x4796 = x4792 * 2
val x4797 = x4796 < 0
val x4798 = {
def x4798thenb(): Int = {
2147483647
}
def x4798elseb(): Int = {
x4796
}
if (x4797) {
x4798thenb()
} else { 
x4798elseb()
}
}
x4798
}
if (x4795) {
x4799thenb()
} else { 
x4799elseb()
}
}
if (x4799 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4800 = new Array[Int](x4799.toInt)
val x4801 = System.arraycopy(x2242,0.toInt,x4800,0.toInt,x4792.toInt)
val x4802 = x4800(x4791.toInt) = x2239
val x4803 = __act2.x5754_hash_data = x4800
x4803
}
def x4807elseb(): Unit = {
val x4805 = x2242(x4791.toInt) = x2239
x4805
}
if (x4794) {
x4807thenb()
} else { 
x4807elseb()
}
}
} else { // existing key
val x1950: Int = x5753x5754_idx
val x1951: generated.scala.DeliteArrayAnon1187970594 = __act2.x5753_hash_data
val x4610 = x1951.l_returnflag_44
val x4611 = x1951.l_linestatus_45
val x4612 = x1951.sum_qty_138
val x4613 = x1951.sum_base_price_139
val x4614 = x1951.sum_disc_price_140
val x4615 = x1951.sum_charge_141
val x4616 = x1951.avg_qty_142
val x4617 = x1951.avg_price_143
val x4618 = x1951.avg_disc_144
val x4619 = x1951.count_order_145
val x4620 = x4610(x1950.toInt)
val x4621 = x4611(x1950.toInt)
val x4622 = x4612(x1950.toInt)
val x4623 = x4613(x1950.toInt)
val x4624 = x4614(x1950.toInt)
val x4625 = x4615(x1950.toInt)
val x4626 = x4616(x1950.toInt)
val x4627 = x4617(x1950.toInt)
val x4628 = x4618(x1950.toInt)
val x4629 = x4619(x1950.toInt)
val x4630 = new generated.scala.Anon1187970594(x4620,x4621,x4622,x4623,x4624,x4625,x4626,x4627,x4628,x4629)
val x1917: generated.scala.Anon1187970594 = x4630
val x1918: generated.scala.Anon1187970594 = x5690
val x1919 = x1917.l_returnflag_44
val x1921 = x1917.l_linestatus_45
val x1923 = x1917.sum_qty_138
val x1924 = x1918.sum_qty_138
val x1925 = {
x1923 + x1924}
val x1926 = x1917.sum_base_price_139
val x1927 = x1918.sum_base_price_139
val x1928 = {
x1926 + x1927}
val x1929 = x1917.sum_disc_price_140
val x1930 = x1918.sum_disc_price_140
val x1931 = {
x1929 + x1930}
val x1932 = x1917.sum_charge_141
val x1933 = x1918.sum_charge_141
val x1934 = {
x1932 + x1933}
val x1935 = x1917.avg_qty_142
val x1936 = x1918.avg_qty_142
val x1937 = {
x1935 + x1936}
val x1938 = x1917.avg_price_143
val x1939 = x1918.avg_price_143
val x1940 = {
x1938 + x1939}
val x1941 = x1917.avg_disc_144
val x1942 = x1918.avg_disc_144
val x1943 = {
x1941 + x1942}
val x1944 = x1917.count_order_145
val x1945 = x1918.count_order_145
val x1946 = {
x1944 + x1945}
val x1947 = new generated.scala.Anon1187970594(x1919,x1921,x1925,x1928,x1931,x1934,x1937,x1940,x1943,x1946)
val x1948: generated.scala.Anon1187970594 = x1947
val x4632 = x1951.l_returnflag_44
val x1987 = x1948.l_returnflag_44
val x4633 = x1951.l_returnflag_44(x1950.toInt) = x1987
val x4634 = x1951.l_linestatus_45
val x1990 = x1948.l_linestatus_45
val x4635 = x1951.l_linestatus_45(x1950.toInt) = x1990
val x4636 = x1951.sum_qty_138
val x1993 = x1948.sum_qty_138
val x4637 = x1951.sum_qty_138(x1950.toInt) = x1993
val x4638 = x1951.sum_base_price_139
val x1996 = x1948.sum_base_price_139
val x4639 = x1951.sum_base_price_139(x1950.toInt) = x1996
val x4640 = x1951.sum_disc_price_140
val x1999 = x1948.sum_disc_price_140
val x4641 = x1951.sum_disc_price_140(x1950.toInt) = x1999
val x4642 = x1951.sum_charge_141
val x2002 = x1948.sum_charge_141
val x4643 = x1951.sum_charge_141(x1950.toInt) = x2002
val x4644 = x1951.avg_qty_142
val x2005 = x1948.avg_qty_142
val x4645 = x1951.avg_qty_142(x1950.toInt) = x2005
val x4646 = x1951.avg_price_143
val x2008 = x1948.avg_price_143
val x4647 = x1951.avg_price_143(x1950.toInt) = x2008
val x4648 = x1951.avg_disc_144
val x2011 = x1948.avg_disc_144
val x4649 = x1951.avg_disc_144(x1950.toInt) = x2011
val x4650 = x1951.count_order_145
val x2014 = x1948.count_order_145
val x4651 = x1951.count_order_145(x1950.toInt) = x2014
val x2241: Int = x5753x5754_idx
val x2242: Array[Int] = __act2.x5754_hash_data
val x4785 = x2242(x2241.toInt)
val x2236: Int = x4785
val x2237: Int = 1
val x2238 = x2236 + x2237
val x2239: Int = x2238
val x4787 = x2242(x2241.toInt) = x2239
}
}
}
__act2
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5753x5754,x3:Int,x1_stream:generated.scala.io.DeliteFileInputStream): Unit = {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
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
val x5510 = {
x36 <= x414}
val x14 = x5(4.toInt)
val x15 = {
x14.toDouble}
val x16 = x5(5.toInt)
val x17 = {
x16.toDouble}
val x18 = x5(6.toInt)
val x19 = {
x18.toDouble}
val x22 = x5(8.toInt)
val x23 = x5(9.toInt)
val x5686 = {
1.0 - x19}
val x5687 = {
x17 * x5686}
val x20 = x5(7.toInt)
val x21 = {
x20.toDouble}
val x5688 = {
1.0 + x21}
val x5689 = {
x5687 * x5688}
val x5690 = new generated.scala.Anon1187970594(x22,x23,x15,x17,x5687,x5689,x15,x17,x19,1)
val x5691 = new generated.scala.Anon1637442313(x22,x23)
if (true && x5510) {
// common key Block(Sym(5691)) for x5753x5754
val x5753x5754_sze: Int = __act.x5753x5754_hash_pos.size
val x5753x5754_idx: Int = __act.x5753x5754_hash_pos.put(x5691)
if (x5753x5754_idx == x5753x5754_sze) { // new key
val x1951: generated.scala.DeliteArrayAnon1187970594 = __act.x5753_hash_data
val x1948: generated.scala.Anon1187970594 = x5690
val x4655 = x5753x5754_sze
val x4656 = x1951.l_returnflag_44
val x4657 = x4656.length
val x4658 = x4657 - 1
val x4659 = x4655 > x4658
val x4727 = {
def x4727thenb(): Unit = {
val x4660 = x4657 < 16
val x4664 = {
def x4664thenb(): Int = {
16
}
def x4664elseb(): Int = {
val x4661 = x4657 * 2
val x4662 = x4661 < 0
val x4663 = {
def x4663thenb(): Int = {
2147483647
}
def x4663elseb(): Int = {
x4661
}
if (x4662) {
x4663thenb()
} else { 
x4663elseb()
}
}
x4663
}
if (x4660) {
x4664thenb()
} else { 
x4664elseb()
}
}
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4665 = new Array[java.lang.String](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4666 = new Array[java.lang.String](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4667 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4668 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4669 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4670 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4671 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4672 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4673 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4674 = new Array[Int](x4664.toInt)
val x4675 = System.arraycopy(x4656,0.toInt,x4665,0.toInt,x4657.toInt)
val x4676 = x1951.l_linestatus_45
val x4677 = System.arraycopy(x4676,0.toInt,x4666,0.toInt,x4657.toInt)
val x4678 = x1951.sum_qty_138
val x4679 = System.arraycopy(x4678,0.toInt,x4667,0.toInt,x4657.toInt)
val x4680 = x1951.sum_base_price_139
val x4681 = System.arraycopy(x4680,0.toInt,x4668,0.toInt,x4657.toInt)
val x4682 = x1951.sum_disc_price_140
val x4683 = System.arraycopy(x4682,0.toInt,x4669,0.toInt,x4657.toInt)
val x4684 = x1951.sum_charge_141
val x4685 = System.arraycopy(x4684,0.toInt,x4670,0.toInt,x4657.toInt)
val x4686 = x1951.avg_qty_142
val x4687 = System.arraycopy(x4686,0.toInt,x4671,0.toInt,x4657.toInt)
val x4688 = x1951.avg_price_143
val x4689 = System.arraycopy(x4688,0.toInt,x4672,0.toInt,x4657.toInt)
val x4690 = x1951.avg_disc_144
val x4691 = System.arraycopy(x4690,0.toInt,x4673,0.toInt,x4657.toInt)
val x4692 = x1951.count_order_145
val x4693 = System.arraycopy(x4692,0.toInt,x4674,0.toInt,x4657.toInt)
val x1987 = x1948.l_returnflag_44
val x4694 = x4665(x4655.toInt) = x1987
val x1990 = x1948.l_linestatus_45
val x4695 = x4666(x4655.toInt) = x1990
val x1993 = x1948.sum_qty_138
val x4696 = x4667(x4655.toInt) = x1993
val x1996 = x1948.sum_base_price_139
val x4697 = x4668(x4655.toInt) = x1996
val x1999 = x1948.sum_disc_price_140
val x4698 = x4669(x4655.toInt) = x1999
val x2002 = x1948.sum_charge_141
val x4699 = x4670(x4655.toInt) = x2002
val x2005 = x1948.avg_qty_142
val x4700 = x4671(x4655.toInt) = x2005
val x2008 = x1948.avg_price_143
val x4701 = x4672(x4655.toInt) = x2008
val x2011 = x1948.avg_disc_144
val x4702 = x4673(x4655.toInt) = x2011
val x2014 = x1948.count_order_145
val x4703 = x4674(x4655.toInt) = x2014
val x4704 = new generated.scala.DeliteArrayAnon1187970594(x4665,x4666,x4667,x4668,x4669,x4670,x4671,x4672,x4673,x4674)
val x4705 = __act.x5753_hash_data = x4704
x4705
}
def x4727elseb(): Unit = {
val x1987 = x1948.l_returnflag_44
val x4707 = x1951.l_returnflag_44(x4655.toInt) = x1987
val x4708 = x1951.l_linestatus_45
val x1990 = x1948.l_linestatus_45
val x4709 = x1951.l_linestatus_45(x4655.toInt) = x1990
val x4710 = x1951.sum_qty_138
val x1993 = x1948.sum_qty_138
val x4711 = x1951.sum_qty_138(x4655.toInt) = x1993
val x4712 = x1951.sum_base_price_139
val x1996 = x1948.sum_base_price_139
val x4713 = x1951.sum_base_price_139(x4655.toInt) = x1996
val x4714 = x1951.sum_disc_price_140
val x1999 = x1948.sum_disc_price_140
val x4715 = x1951.sum_disc_price_140(x4655.toInt) = x1999
val x4716 = x1951.sum_charge_141
val x2002 = x1948.sum_charge_141
val x4717 = x1951.sum_charge_141(x4655.toInt) = x2002
val x4718 = x1951.avg_qty_142
val x2005 = x1948.avg_qty_142
val x4719 = x1951.avg_qty_142(x4655.toInt) = x2005
val x4720 = x1951.avg_price_143
val x2008 = x1948.avg_price_143
val x4721 = x1951.avg_price_143(x4655.toInt) = x2008
val x4722 = x1951.avg_disc_144
val x2011 = x1948.avg_disc_144
val x4723 = x1951.avg_disc_144(x4655.toInt) = x2011
val x4724 = x1951.count_order_145
val x2014 = x1948.count_order_145
val x4725 = x1951.count_order_145(x4655.toInt) = x2014
()
}
if (x4659) {
x4727thenb()
} else { 
x4727elseb()
}
}
val x2242: Array[Int] = __act.x5754_hash_data
val x2239: Int = 1
val x4791 = x5753x5754_sze
val x4792 = x2242.length
val x4793 = x4792 - 1
val x4794 = x4791 > x4793
val x4807 = {
def x4807thenb(): Unit = {
val x4795 = x4792 < 16
val x4799 = {
def x4799thenb(): Int = {
16
}
def x4799elseb(): Int = {
val x4796 = x4792 * 2
val x4797 = x4796 < 0
val x4798 = {
def x4798thenb(): Int = {
2147483647
}
def x4798elseb(): Int = {
x4796
}
if (x4797) {
x4798thenb()
} else { 
x4798elseb()
}
}
x4798
}
if (x4795) {
x4799thenb()
} else { 
x4799elseb()
}
}
if (x4799 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4800 = new Array[Int](x4799.toInt)
val x4801 = System.arraycopy(x2242,0.toInt,x4800,0.toInt,x4792.toInt)
val x4802 = x4800(x4791.toInt) = x2239
val x4803 = __act.x5754_hash_data = x4800
x4803
}
def x4807elseb(): Unit = {
val x4805 = x2242(x4791.toInt) = x2239
x4805
}
if (x4794) {
x4807thenb()
} else { 
x4807elseb()
}
}
} else { // existing key
val x1950: Int = x5753x5754_idx
val x1951: generated.scala.DeliteArrayAnon1187970594 = __act.x5753_hash_data
val x4610 = x1951.l_returnflag_44
val x4611 = x1951.l_linestatus_45
val x4612 = x1951.sum_qty_138
val x4613 = x1951.sum_base_price_139
val x4614 = x1951.sum_disc_price_140
val x4615 = x1951.sum_charge_141
val x4616 = x1951.avg_qty_142
val x4617 = x1951.avg_price_143
val x4618 = x1951.avg_disc_144
val x4619 = x1951.count_order_145
val x4620 = x4610(x1950.toInt)
val x4621 = x4611(x1950.toInt)
val x4622 = x4612(x1950.toInt)
val x4623 = x4613(x1950.toInt)
val x4624 = x4614(x1950.toInt)
val x4625 = x4615(x1950.toInt)
val x4626 = x4616(x1950.toInt)
val x4627 = x4617(x1950.toInt)
val x4628 = x4618(x1950.toInt)
val x4629 = x4619(x1950.toInt)
val x4630 = new generated.scala.Anon1187970594(x4620,x4621,x4622,x4623,x4624,x4625,x4626,x4627,x4628,x4629)
val x1917: generated.scala.Anon1187970594 = x4630
val x1918: generated.scala.Anon1187970594 = x5690
val x1919 = x1917.l_returnflag_44
val x1921 = x1917.l_linestatus_45
val x1923 = x1917.sum_qty_138
val x1924 = x1918.sum_qty_138
val x1925 = {
x1923 + x1924}
val x1926 = x1917.sum_base_price_139
val x1927 = x1918.sum_base_price_139
val x1928 = {
x1926 + x1927}
val x1929 = x1917.sum_disc_price_140
val x1930 = x1918.sum_disc_price_140
val x1931 = {
x1929 + x1930}
val x1932 = x1917.sum_charge_141
val x1933 = x1918.sum_charge_141
val x1934 = {
x1932 + x1933}
val x1935 = x1917.avg_qty_142
val x1936 = x1918.avg_qty_142
val x1937 = {
x1935 + x1936}
val x1938 = x1917.avg_price_143
val x1939 = x1918.avg_price_143
val x1940 = {
x1938 + x1939}
val x1941 = x1917.avg_disc_144
val x1942 = x1918.avg_disc_144
val x1943 = {
x1941 + x1942}
val x1944 = x1917.count_order_145
val x1945 = x1918.count_order_145
val x1946 = {
x1944 + x1945}
val x1947 = new generated.scala.Anon1187970594(x1919,x1921,x1925,x1928,x1931,x1934,x1937,x1940,x1943,x1946)
val x1948: generated.scala.Anon1187970594 = x1947
val x4632 = x1951.l_returnflag_44
val x1987 = x1948.l_returnflag_44
val x4633 = x1951.l_returnflag_44(x1950.toInt) = x1987
val x4634 = x1951.l_linestatus_45
val x1990 = x1948.l_linestatus_45
val x4635 = x1951.l_linestatus_45(x1950.toInt) = x1990
val x4636 = x1951.sum_qty_138
val x1993 = x1948.sum_qty_138
val x4637 = x1951.sum_qty_138(x1950.toInt) = x1993
val x4638 = x1951.sum_base_price_139
val x1996 = x1948.sum_base_price_139
val x4639 = x1951.sum_base_price_139(x1950.toInt) = x1996
val x4640 = x1951.sum_disc_price_140
val x1999 = x1948.sum_disc_price_140
val x4641 = x1951.sum_disc_price_140(x1950.toInt) = x1999
val x4642 = x1951.sum_charge_141
val x2002 = x1948.sum_charge_141
val x4643 = x1951.sum_charge_141(x1950.toInt) = x2002
val x4644 = x1951.avg_qty_142
val x2005 = x1948.avg_qty_142
val x4645 = x1951.avg_qty_142(x1950.toInt) = x2005
val x4646 = x1951.avg_price_143
val x2008 = x1948.avg_price_143
val x4647 = x1951.avg_price_143(x1950.toInt) = x2008
val x4648 = x1951.avg_disc_144
val x2011 = x1948.avg_disc_144
val x4649 = x1951.avg_disc_144(x1950.toInt) = x2011
val x4650 = x1951.count_order_145
val x2014 = x1948.count_order_145
val x4651 = x1951.count_order_145(x1950.toInt) = x2014
val x2241: Int = x5753x5754_idx
val x2242: Array[Int] = __act.x5754_hash_data
val x4785 = x2242(x2241.toInt)
val x2236: Int = x4785
val x2237: Int = 1
val x2238 = x2236 + x2237
val x2239: Int = x2238
val x4787 = x2242(x2241.toInt) = x2239
}
}
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5753x5754,rhs:activation_x5753x5754): Unit = {
// common key Block(Sym(5691)) for x5753x5754
if (__act.x5753x5754_size == -1) __act.x5753x5754_size = __act.x5753x5754_hash_pos.size
if (rhs.x5753x5754_size == -1) rhs.x5753x5754_size = rhs.x5753x5754_hash_pos.size
var x5753x5754rhs_idx: Int = 0
while (x5753x5754rhs_idx < rhs.x5753x5754_hash_pos.size) {
val x5753x5754_k: generated.scala.Anon1637442313 = rhs.x5753x5754_hash_pos.unsafeKeys(x5753x5754rhs_idx.toInt)
val x5753x5754_sze: Int = __act.x5753x5754_hash_pos.size
val x5753x5754_idx: Int = __act.x5753x5754_hash_pos.put(x5753x5754_k)
if (x5753x5754_idx == x5753x5754_sze) { // new key
var x1951: generated.scala.DeliteArrayAnon1187970594 = rhs.x5753_hash_data
val x1950: Int = x5753x5754rhs_idx
val x4610 = x1951.l_returnflag_44
val x4611 = x1951.l_linestatus_45
val x4612 = x1951.sum_qty_138
val x4613 = x1951.sum_base_price_139
val x4614 = x1951.sum_disc_price_140
val x4615 = x1951.sum_charge_141
val x4616 = x1951.avg_qty_142
val x4617 = x1951.avg_price_143
val x4618 = x1951.avg_disc_144
val x4619 = x1951.count_order_145
val x4620 = x4610(x1950.toInt)
val x4621 = x4611(x1950.toInt)
val x4622 = x4612(x1950.toInt)
val x4623 = x4613(x1950.toInt)
val x4624 = x4614(x1950.toInt)
val x4625 = x4615(x1950.toInt)
val x4626 = x4616(x1950.toInt)
val x4627 = x4617(x1950.toInt)
val x4628 = x4618(x1950.toInt)
val x4629 = x4619(x1950.toInt)
val x4630 = new generated.scala.Anon1187970594(x4620,x4621,x4622,x4623,x4624,x4625,x4626,x4627,x4628,x4629)
x1951 = __act.x5753_hash_data
val x1948: generated.scala.Anon1187970594 = x4630
val x4655 = x5753x5754_sze
val x4656 = x1951.l_returnflag_44
val x4657 = x4656.length
val x4658 = x4657 - 1
val x4659 = x4655 > x4658
val x4727 = {
def x4727thenb(): Unit = {
val x4660 = x4657 < 16
val x4664 = {
def x4664thenb(): Int = {
16
}
def x4664elseb(): Int = {
val x4661 = x4657 * 2
val x4662 = x4661 < 0
val x4663 = {
def x4663thenb(): Int = {
2147483647
}
def x4663elseb(): Int = {
x4661
}
if (x4662) {
x4663thenb()
} else { 
x4663elseb()
}
}
x4663
}
if (x4660) {
x4664thenb()
} else { 
x4664elseb()
}
}
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4665 = new Array[java.lang.String](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4666 = new Array[java.lang.String](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4667 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4668 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4669 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4670 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4671 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4672 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4673 = new Array[Double](x4664.toInt)
if (x4664 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4674 = new Array[Int](x4664.toInt)
val x4675 = System.arraycopy(x4656,0.toInt,x4665,0.toInt,x4657.toInt)
val x4676 = x1951.l_linestatus_45
val x4677 = System.arraycopy(x4676,0.toInt,x4666,0.toInt,x4657.toInt)
val x4678 = x1951.sum_qty_138
val x4679 = System.arraycopy(x4678,0.toInt,x4667,0.toInt,x4657.toInt)
val x4680 = x1951.sum_base_price_139
val x4681 = System.arraycopy(x4680,0.toInt,x4668,0.toInt,x4657.toInt)
val x4682 = x1951.sum_disc_price_140
val x4683 = System.arraycopy(x4682,0.toInt,x4669,0.toInt,x4657.toInt)
val x4684 = x1951.sum_charge_141
val x4685 = System.arraycopy(x4684,0.toInt,x4670,0.toInt,x4657.toInt)
val x4686 = x1951.avg_qty_142
val x4687 = System.arraycopy(x4686,0.toInt,x4671,0.toInt,x4657.toInt)
val x4688 = x1951.avg_price_143
val x4689 = System.arraycopy(x4688,0.toInt,x4672,0.toInt,x4657.toInt)
val x4690 = x1951.avg_disc_144
val x4691 = System.arraycopy(x4690,0.toInt,x4673,0.toInt,x4657.toInt)
val x4692 = x1951.count_order_145
val x4693 = System.arraycopy(x4692,0.toInt,x4674,0.toInt,x4657.toInt)
val x1987 = x1948.l_returnflag_44
val x4694 = x4665(x4655.toInt) = x1987
val x1990 = x1948.l_linestatus_45
val x4695 = x4666(x4655.toInt) = x1990
val x1993 = x1948.sum_qty_138
val x4696 = x4667(x4655.toInt) = x1993
val x1996 = x1948.sum_base_price_139
val x4697 = x4668(x4655.toInt) = x1996
val x1999 = x1948.sum_disc_price_140
val x4698 = x4669(x4655.toInt) = x1999
val x2002 = x1948.sum_charge_141
val x4699 = x4670(x4655.toInt) = x2002
val x2005 = x1948.avg_qty_142
val x4700 = x4671(x4655.toInt) = x2005
val x2008 = x1948.avg_price_143
val x4701 = x4672(x4655.toInt) = x2008
val x2011 = x1948.avg_disc_144
val x4702 = x4673(x4655.toInt) = x2011
val x2014 = x1948.count_order_145
val x4703 = x4674(x4655.toInt) = x2014
val x4704 = new generated.scala.DeliteArrayAnon1187970594(x4665,x4666,x4667,x4668,x4669,x4670,x4671,x4672,x4673,x4674)
val x4705 = __act.x5753_hash_data = x4704
x4705
}
def x4727elseb(): Unit = {
val x1987 = x1948.l_returnflag_44
val x4707 = x1951.l_returnflag_44(x4655.toInt) = x1987
val x4708 = x1951.l_linestatus_45
val x1990 = x1948.l_linestatus_45
val x4709 = x1951.l_linestatus_45(x4655.toInt) = x1990
val x4710 = x1951.sum_qty_138
val x1993 = x1948.sum_qty_138
val x4711 = x1951.sum_qty_138(x4655.toInt) = x1993
val x4712 = x1951.sum_base_price_139
val x1996 = x1948.sum_base_price_139
val x4713 = x1951.sum_base_price_139(x4655.toInt) = x1996
val x4714 = x1951.sum_disc_price_140
val x1999 = x1948.sum_disc_price_140
val x4715 = x1951.sum_disc_price_140(x4655.toInt) = x1999
val x4716 = x1951.sum_charge_141
val x2002 = x1948.sum_charge_141
val x4717 = x1951.sum_charge_141(x4655.toInt) = x2002
val x4718 = x1951.avg_qty_142
val x2005 = x1948.avg_qty_142
val x4719 = x1951.avg_qty_142(x4655.toInt) = x2005
val x4720 = x1951.avg_price_143
val x2008 = x1948.avg_price_143
val x4721 = x1951.avg_price_143(x4655.toInt) = x2008
val x4722 = x1951.avg_disc_144
val x2011 = x1948.avg_disc_144
val x4723 = x1951.avg_disc_144(x4655.toInt) = x2011
val x4724 = x1951.count_order_145
val x2014 = x1948.count_order_145
val x4725 = x1951.count_order_145(x4655.toInt) = x2014
()
}
if (x4659) {
x4727thenb()
} else { 
x4727elseb()
}
}
var x2242: Array[Int] = rhs.x5754_hash_data
val x2241: Int = x5753x5754rhs_idx
val x4785 = x2242(x2241.toInt)
x2242 = __act.x5754_hash_data
val x2239: Int = x4785
val x4791 = x5753x5754_sze
val x4792 = x2242.length
val x4793 = x4792 - 1
val x4794 = x4791 > x4793
val x4807 = {
def x4807thenb(): Unit = {
val x4795 = x4792 < 16
val x4799 = {
def x4799thenb(): Int = {
16
}
def x4799elseb(): Int = {
val x4796 = x4792 * 2
val x4797 = x4796 < 0
val x4798 = {
def x4798thenb(): Int = {
2147483647
}
def x4798elseb(): Int = {
x4796
}
if (x4797) {
x4798thenb()
} else { 
x4798elseb()
}
}
x4798
}
if (x4795) {
x4799thenb()
} else { 
x4799elseb()
}
}
if (x4799 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4800 = new Array[Int](x4799.toInt)
val x4801 = System.arraycopy(x2242,0.toInt,x4800,0.toInt,x4792.toInt)
val x4802 = x4800(x4791.toInt) = x2239
val x4803 = __act.x5754_hash_data = x4800
x4803
}
def x4807elseb(): Unit = {
val x4805 = x2242(x4791.toInt) = x2239
x4805
}
if (x4794) {
x4807thenb()
} else { 
x4807elseb()
}
}
} else { // existing key
val x1951: generated.scala.DeliteArrayAnon1187970594 = rhs.x5753_hash_data
val x1950: Int = x5753x5754rhs_idx
val x4610 = x1951.l_returnflag_44
val x4611 = x1951.l_linestatus_45
val x4612 = x1951.sum_qty_138
val x4613 = x1951.sum_base_price_139
val x4614 = x1951.sum_disc_price_140
val x4615 = x1951.sum_charge_141
val x4616 = x1951.avg_qty_142
val x4617 = x1951.avg_price_143
val x4618 = x1951.avg_disc_144
val x4619 = x1951.count_order_145
val x4620 = x4610(x1950.toInt)
val x4621 = x4611(x1950.toInt)
val x4622 = x4612(x1950.toInt)
val x4623 = x4613(x1950.toInt)
val x4624 = x4614(x1950.toInt)
val x4625 = x4615(x1950.toInt)
val x4626 = x4616(x1950.toInt)
val x4627 = x4617(x1950.toInt)
val x4628 = x4618(x1950.toInt)
val x4629 = x4619(x1950.toInt)
val x4630 = new generated.scala.Anon1187970594(x4620,x4621,x4622,x4623,x4624,x4625,x4626,x4627,x4628,x4629)
val x5753_v: generated.scala.Anon1187970594 = x4630
val x5753_reduce_block: Unit = {
val x1951: generated.scala.DeliteArrayAnon1187970594 = __act.x5753_hash_data
val x1950: Int = x5753x5754_idx
val x4610 = x1951.l_returnflag_44
val x4611 = x1951.l_linestatus_45
val x4612 = x1951.sum_qty_138
val x4613 = x1951.sum_base_price_139
val x4614 = x1951.sum_disc_price_140
val x4615 = x1951.sum_charge_141
val x4616 = x1951.avg_qty_142
val x4617 = x1951.avg_price_143
val x4618 = x1951.avg_disc_144
val x4619 = x1951.count_order_145
val x4620 = x4610(x1950.toInt)
val x4621 = x4611(x1950.toInt)
val x4622 = x4612(x1950.toInt)
val x4623 = x4613(x1950.toInt)
val x4624 = x4614(x1950.toInt)
val x4625 = x4615(x1950.toInt)
val x4626 = x4616(x1950.toInt)
val x4627 = x4617(x1950.toInt)
val x4628 = x4618(x1950.toInt)
val x4629 = x4619(x1950.toInt)
val x4630 = new generated.scala.Anon1187970594(x4620,x4621,x4622,x4623,x4624,x4625,x4626,x4627,x4628,x4629)
val x1917: generated.scala.Anon1187970594 = x4630
val x1918: generated.scala.Anon1187970594 = x5753_v
val x1919 = x1917.l_returnflag_44
val x1921 = x1917.l_linestatus_45
val x1923 = x1917.sum_qty_138
val x1924 = x1918.sum_qty_138
val x1925 = {
x1923 + x1924}
val x1926 = x1917.sum_base_price_139
val x1927 = x1918.sum_base_price_139
val x1928 = {
x1926 + x1927}
val x1929 = x1917.sum_disc_price_140
val x1930 = x1918.sum_disc_price_140
val x1931 = {
x1929 + x1930}
val x1932 = x1917.sum_charge_141
val x1933 = x1918.sum_charge_141
val x1934 = {
x1932 + x1933}
val x1935 = x1917.avg_qty_142
val x1936 = x1918.avg_qty_142
val x1937 = {
x1935 + x1936}
val x1938 = x1917.avg_price_143
val x1939 = x1918.avg_price_143
val x1940 = {
x1938 + x1939}
val x1941 = x1917.avg_disc_144
val x1942 = x1918.avg_disc_144
val x1943 = {
x1941 + x1942}
val x1944 = x1917.count_order_145
val x1945 = x1918.count_order_145
val x1946 = {
x1944 + x1945}
val x1947 = new generated.scala.Anon1187970594(x1919,x1921,x1925,x1928,x1931,x1934,x1937,x1940,x1943,x1946)
val x1948: generated.scala.Anon1187970594 = x1947
val x4632 = x1951.l_returnflag_44
val x1987 = x1948.l_returnflag_44
val x4633 = x1951.l_returnflag_44(x1950.toInt) = x1987
val x4634 = x1951.l_linestatus_45
val x1990 = x1948.l_linestatus_45
val x4635 = x1951.l_linestatus_45(x1950.toInt) = x1990
val x4636 = x1951.sum_qty_138
val x1993 = x1948.sum_qty_138
val x4637 = x1951.sum_qty_138(x1950.toInt) = x1993
val x4638 = x1951.sum_base_price_139
val x1996 = x1948.sum_base_price_139
val x4639 = x1951.sum_base_price_139(x1950.toInt) = x1996
val x4640 = x1951.sum_disc_price_140
val x1999 = x1948.sum_disc_price_140
val x4641 = x1951.sum_disc_price_140(x1950.toInt) = x1999
val x4642 = x1951.sum_charge_141
val x2002 = x1948.sum_charge_141
val x4643 = x1951.sum_charge_141(x1950.toInt) = x2002
val x4644 = x1951.avg_qty_142
val x2005 = x1948.avg_qty_142
val x4645 = x1951.avg_qty_142(x1950.toInt) = x2005
val x4646 = x1951.avg_price_143
val x2008 = x1948.avg_price_143
val x4647 = x1951.avg_price_143(x1950.toInt) = x2008
val x4648 = x1951.avg_disc_144
val x2011 = x1948.avg_disc_144
val x4649 = x1951.avg_disc_144(x1950.toInt) = x2011
val x4650 = x1951.count_order_145
val x2014 = x1948.count_order_145
val x4651 = x1951.count_order_145(x1950.toInt) = x2014
}
val x2242: Array[Int] = rhs.x5754_hash_data
val x2241: Int = x5753x5754rhs_idx
val x4785 = x2242(x2241.toInt)
val x5754_v: Int = x4785
val x5754_reduce_block: Unit = {
val x2242: Array[Int] = __act.x5754_hash_data
val x2241: Int = x5753x5754_idx
val x4785 = x2242(x2241.toInt)
val x2236: Int = x4785
val x2237: Int = x5754_v
val x2238 = x2236 + x2237
val x2239: Int = x2238
val x4787 = x2242(x2241.toInt) = x2239
}
}
x5753x5754rhs_idx = x5753x5754rhs_idx+1
}
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5753x5754,lhs:activation_x5753x5754): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5753x5754): Unit = {
val tid: Int = resourceInfo.groupId
if (tid > 0) {
val all_acts: Array[activation_x5753x5754] = new Array[activation_x5753x5754](resourceInfo.groupSize)
var currentAct: activation_x5753x5754 = __act
var i: Int = tid
while(i >= 0) {
all_acts(i.toInt) = currentAct
currentAct.all_acts = all_acts
currentAct = currentAct.left_act
i = i-1
}
} else {
}
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5753x5754): Unit = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
if (__act.all_acts ne null) {
val all_acts: Array[activation_x5753x5754] = __act.all_acts
val x5753x5754_globalKeys: Array[generated.scala.Anon1637442313] = __act.all_acts(0).x5753x5754_hash_pos.unsafeKeys
var x5753x5754_idx: Int = ((__act.all_acts(0).x5753x5754_hash_pos.size).asInstanceOf[Long] * tid / numThreads).asInstanceOf[Int]
val x5753x5754_end: Int = ((__act.all_acts(0).x5753x5754_hash_pos.size).asInstanceOf[Long] * (tid+1) / numThreads).asInstanceOf[Int]
while (x5753x5754_idx < x5753x5754_end) {
x5753x5754_idx = x5753x5754_idx + 1
}
}
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5753x5754): Unit = {
val x5753x5754_sze: Int = __act.x5753x5754_hash_pos.size
var x1951: generated.scala.DeliteArrayAnon1187970594 = __act.x5753_hash_data
val x1949: Int = x5753x5754_sze
val x4729 = x1951.l_returnflag_44
val x4730 = x4729.length
val x4731 = x4730 > x1949
val x4764 = {
def x4764thenb(): Unit = {
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4732 = new Array[java.lang.String](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4733 = new Array[java.lang.String](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4734 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4735 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4736 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4737 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4738 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4739 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4740 = new Array[Double](x1949.toInt)
if (x1949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4741 = new Array[Int](x1949.toInt)
val x4742 = System.arraycopy(x4729,0.toInt,x4732,0.toInt,x1949.toInt)
val x4743 = x1951.l_linestatus_45
val x4744 = System.arraycopy(x4743,0.toInt,x4733,0.toInt,x1949.toInt)
val x4745 = x1951.sum_qty_138
val x4746 = System.arraycopy(x4745,0.toInt,x4734,0.toInt,x1949.toInt)
val x4747 = x1951.sum_base_price_139
val x4748 = System.arraycopy(x4747,0.toInt,x4735,0.toInt,x1949.toInt)
val x4749 = x1951.sum_disc_price_140
val x4750 = System.arraycopy(x4749,0.toInt,x4736,0.toInt,x1949.toInt)
val x4751 = x1951.sum_charge_141
val x4752 = System.arraycopy(x4751,0.toInt,x4737,0.toInt,x1949.toInt)
val x4753 = x1951.avg_qty_142
val x4754 = System.arraycopy(x4753,0.toInt,x4738,0.toInt,x1949.toInt)
val x4755 = x1951.avg_price_143
val x4756 = System.arraycopy(x4755,0.toInt,x4739,0.toInt,x1949.toInt)
val x4757 = x1951.avg_disc_144
val x4758 = System.arraycopy(x4757,0.toInt,x4740,0.toInt,x1949.toInt)
val x4759 = x1951.count_order_145
val x4760 = System.arraycopy(x4759,0.toInt,x4741,0.toInt,x1949.toInt)
val x4761 = new generated.scala.DeliteArrayAnon1187970594(x4732,x4733,x4734,x4735,x4736,x4737,x4738,x4739,x4740,x4741)
val x4762 = x1951 = x4761
x4762
}
if (x4731) {
x4764thenb()
}
}
__act.x5753 = x1951
var x2242: Array[Int] = __act.x5754_hash_data
val x2240: Int = x5753x5754_sze
val x4809 = x2242.length
val x4810 = x4809 > x2240
val x4815 = {
def x4815thenb(): Unit = {
if (x2240 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4811 = new Array[Int](x2240.toInt)
val x4812 = System.arraycopy(x2242,0.toInt,x4811,0.toInt,x2240.toInt)
val x4813 = x2242 = x4811
x4813
}
if (x4810) {
x4815thenb()
}
}
__act.x5754 = x2242
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x5753x5754 = {
val act: activation_x5753x5754 = new activation_x5753x5754
act.x5753x5754_hash_pos = new generated.scala.container.HashMapImpl[generated.scala.Anon1637442313](512,128)
act
}

}
x5753x5754_closure.loopStart = 0
x5753x5754_closure.loopSize = x2
val alloc: activation_x5753x5754 = x5753x5754_closure.alloc(resourceInfo)
var x5753x5754: activation_x5753x5754 = null
if (resourceInfo.availableThreads <= 1) {
x5753x5754 = x5753x5754_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x5753x5754] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x5753x5754](x5753x5754_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x5753x5754_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x5753x5754 = x5753x5754_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x5753x5754
}}

/**********/


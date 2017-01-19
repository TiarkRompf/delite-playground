package generated.scala
//activation record for fat loop
final class activation_x5583x5615 {
var left_act: activation_x5583x5615 = _
var all_acts: Array[activation_x5583x5615] = _
var x5583x5615_hash_pos: generated.scala.container.HashMapImpl[generated.scala.Anon1637442313] = _
var x5583x5615_size: Int = _
var x5583: generated.scala.DeliteArrayAnon1187970594 = _
var x5583_hash_data: generated.scala.DeliteArrayAnon1187970594 = _
var x5615: Array[Int] = _
var x5615_hash_data: Array[Int] = _
}
object activation_x5583x5615 {
}
object kernel_x5583x5615 {
def apply(resourceInfo:generated.scala.ResourceInfo,x3820:Int,x1920:generated.scala.Anon1187970594,x3604:Array[Int],x418:Int,x3346:Array[Double],x3389:Array[Double],x3432:Array[Double],x3518:Array[java.lang.String],x3561:Array[java.lang.String],x3475:Array[Double]): activation_x5583x5615 = {
val x5583x5615_closure = new generated.scala.DeliteOpMultiLoop[activation_x5583x5615] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x3820
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x5583x5615 = {
val __act: activation_x5583x5615 = new activation_x5583x5615()
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5583x5615,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x5583x5615]): activation_x5583x5615 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x5583x5615 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x5583x5615 = sync.get(localStart)
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

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5583x5615): activation_x5583x5615 = {
val act: activation_x5583x5615 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5583x5615,start:Long,end:Long): activation_x5583x5615 = {
val isEmpty: Boolean = end-start <= 0
var idx: Int = (start).asInstanceOf[Int]
val __act2: activation_x5583x5615 = init(resourceInfo,__act,idx,isEmpty)
idx = idx + 1
while (idx < end) {
process(resourceInfo,__act2,idx)
idx = idx + 1
}
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5583x5615,x382:Int,isEmpty:Boolean): activation_x5583x5615 = {
val __act2: activation_x5583x5615 = new activation_x5583x5615()
__act2.x5583x5615_hash_pos = new generated.scala.container.HashMapImpl[generated.scala.Anon1637442313](512,128)
__act2.x5583x5615_size = -1
val x1953: Int = 128
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4607 = new Array[java.lang.String](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4608 = new Array[java.lang.String](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4609 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4610 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4611 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4612 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4613 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4614 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4615 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4616 = new Array[Int](x1953.toInt)
val x4617 = new generated.scala.DeliteArrayAnon1187970594(x4607,x4608,x4609,x4610,x4611,x4612,x4613,x4614,x4615,x4616)
__act2.x5583_hash_data = x4617
val x2244: Int = 128
if (x2244 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4792 = new Array[Int](x2244.toInt)
__act2.x5615_hash_data = x4792
if (!isEmpty) {
val x3861 = x3604(x382.toInt)
val x3862 = {
x3861 <= x418}
val x3867 = x3346(x382.toInt)
val x3868 = x3389(x382.toInt)
val x3869 = x3432(x382.toInt)
val x3871 = x3518(x382.toInt)
val x3872 = x3561(x382.toInt)
val x5516 = {
1.0 - x3869}
val x5517 = {
x3868 * x5516}
val x3870 = x3475(x382.toInt)
val x5518 = {
1.0 + x3870}
val x5519 = {
x5517 * x5518}
val x5520 = new generated.scala.Anon1187970594(x3871,x3872,x3867,x3868,x5517,x5519,x3867,x3868,x3869,1)
val x5515 = new generated.scala.Anon1637442313(x3871,x3872)
if (true && x3862) {
// common key Block(Sym(5515)) for x5583x5615
val x5583x5615_sze: Int = __act2.x5583x5615_hash_pos.size
val x5583x5615_idx: Int = __act2.x5583x5615_hash_pos.put(x5515)
if (x5583x5615_idx == x5583x5615_sze) { // new key
val x1955: generated.scala.DeliteArrayAnon1187970594 = __act2.x5583_hash_data
val x1952: generated.scala.Anon1187970594 = x5520
val x4664 = x5583x5615_sze
val x4665 = x1955.l_returnflag_44
val x4666 = x4665.length
val x4667 = x4666 - 1
val x4668 = x4664 > x4667
val x4736 = {
def x4736thenb(): Unit = {
val x4669 = x4666 < 16
val x4673 = {
def x4673thenb(): Int = {
16
}
def x4673elseb(): Int = {
val x4670 = x4666 * 2
val x4671 = x4670 < 0
val x4672 = {
def x4672thenb(): Int = {
2147483647
}
def x4672elseb(): Int = {
x4670
}
if (x4671) {
x4672thenb()
} else { 
x4672elseb()
}
}
x4672
}
if (x4669) {
x4673thenb()
} else { 
x4673elseb()
}
}
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4674 = new Array[java.lang.String](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4675 = new Array[java.lang.String](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4676 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4677 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4678 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4679 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4680 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4681 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4682 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4683 = new Array[Int](x4673.toInt)
val x4684 = System.arraycopy(x4665,0.toInt,x4674,0.toInt,x4666.toInt)
val x4685 = x1955.l_linestatus_45
val x4686 = System.arraycopy(x4685,0.toInt,x4675,0.toInt,x4666.toInt)
val x4687 = x1955.sum_qty_138
val x4688 = System.arraycopy(x4687,0.toInt,x4676,0.toInt,x4666.toInt)
val x4689 = x1955.sum_base_price_139
val x4690 = System.arraycopy(x4689,0.toInt,x4677,0.toInt,x4666.toInt)
val x4691 = x1955.sum_disc_price_140
val x4692 = System.arraycopy(x4691,0.toInt,x4678,0.toInt,x4666.toInt)
val x4693 = x1955.sum_charge_141
val x4694 = System.arraycopy(x4693,0.toInt,x4679,0.toInt,x4666.toInt)
val x4695 = x1955.avg_qty_142
val x4696 = System.arraycopy(x4695,0.toInt,x4680,0.toInt,x4666.toInt)
val x4697 = x1955.avg_price_143
val x4698 = System.arraycopy(x4697,0.toInt,x4681,0.toInt,x4666.toInt)
val x4699 = x1955.avg_disc_144
val x4700 = System.arraycopy(x4699,0.toInt,x4682,0.toInt,x4666.toInt)
val x4701 = x1955.count_order_145
val x4702 = System.arraycopy(x4701,0.toInt,x4683,0.toInt,x4666.toInt)
val x1991 = x1952.l_returnflag_44
val x4703 = x4674(x4664.toInt) = x1991
val x1994 = x1952.l_linestatus_45
val x4704 = x4675(x4664.toInt) = x1994
val x1997 = x1952.sum_qty_138
val x4705 = x4676(x4664.toInt) = x1997
val x2000 = x1952.sum_base_price_139
val x4706 = x4677(x4664.toInt) = x2000
val x2003 = x1952.sum_disc_price_140
val x4707 = x4678(x4664.toInt) = x2003
val x2006 = x1952.sum_charge_141
val x4708 = x4679(x4664.toInt) = x2006
val x2009 = x1952.avg_qty_142
val x4709 = x4680(x4664.toInt) = x2009
val x2012 = x1952.avg_price_143
val x4710 = x4681(x4664.toInt) = x2012
val x2015 = x1952.avg_disc_144
val x4711 = x4682(x4664.toInt) = x2015
val x2018 = x1952.count_order_145
val x4712 = x4683(x4664.toInt) = x2018
val x4713 = new generated.scala.DeliteArrayAnon1187970594(x4674,x4675,x4676,x4677,x4678,x4679,x4680,x4681,x4682,x4683)
val x4714 = __act2.x5583_hash_data = x4713
x4714
}
def x4736elseb(): Unit = {
val x1991 = x1952.l_returnflag_44
val x4716 = x1955.l_returnflag_44(x4664.toInt) = x1991
val x4717 = x1955.l_linestatus_45
val x1994 = x1952.l_linestatus_45
val x4718 = x1955.l_linestatus_45(x4664.toInt) = x1994
val x4719 = x1955.sum_qty_138
val x1997 = x1952.sum_qty_138
val x4720 = x1955.sum_qty_138(x4664.toInt) = x1997
val x4721 = x1955.sum_base_price_139
val x2000 = x1952.sum_base_price_139
val x4722 = x1955.sum_base_price_139(x4664.toInt) = x2000
val x4723 = x1955.sum_disc_price_140
val x2003 = x1952.sum_disc_price_140
val x4724 = x1955.sum_disc_price_140(x4664.toInt) = x2003
val x4725 = x1955.sum_charge_141
val x2006 = x1952.sum_charge_141
val x4726 = x1955.sum_charge_141(x4664.toInt) = x2006
val x4727 = x1955.avg_qty_142
val x2009 = x1952.avg_qty_142
val x4728 = x1955.avg_qty_142(x4664.toInt) = x2009
val x4729 = x1955.avg_price_143
val x2012 = x1952.avg_price_143
val x4730 = x1955.avg_price_143(x4664.toInt) = x2012
val x4731 = x1955.avg_disc_144
val x2015 = x1952.avg_disc_144
val x4732 = x1955.avg_disc_144(x4664.toInt) = x2015
val x4733 = x1955.count_order_145
val x2018 = x1952.count_order_145
val x4734 = x1955.count_order_145(x4664.toInt) = x2018
()
}
if (x4668) {
x4736thenb()
} else { 
x4736elseb()
}
}
val x2246: Array[Int] = __act2.x5615_hash_data
val x2243: Int = 1
val x4800 = x5583x5615_sze
val x4801 = x2246.length
val x4802 = x4801 - 1
val x4803 = x4800 > x4802
val x4816 = {
def x4816thenb(): Unit = {
val x4804 = x4801 < 16
val x4808 = {
def x4808thenb(): Int = {
16
}
def x4808elseb(): Int = {
val x4805 = x4801 * 2
val x4806 = x4805 < 0
val x4807 = {
def x4807thenb(): Int = {
2147483647
}
def x4807elseb(): Int = {
x4805
}
if (x4806) {
x4807thenb()
} else { 
x4807elseb()
}
}
x4807
}
if (x4804) {
x4808thenb()
} else { 
x4808elseb()
}
}
if (x4808 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4809 = new Array[Int](x4808.toInt)
val x4810 = System.arraycopy(x2246,0.toInt,x4809,0.toInt,x4801.toInt)
val x4811 = x4809(x4800.toInt) = x2243
val x4812 = __act2.x5615_hash_data = x4809
x4812
}
def x4816elseb(): Unit = {
val x4814 = x2246(x4800.toInt) = x2243
x4814
}
if (x4803) {
x4816thenb()
} else { 
x4816elseb()
}
}
} else { // existing key
val x1954: Int = x5583x5615_idx
val x1955: generated.scala.DeliteArrayAnon1187970594 = __act2.x5583_hash_data
val x4619 = x1955.l_returnflag_44
val x4620 = x1955.l_linestatus_45
val x4621 = x1955.sum_qty_138
val x4622 = x1955.sum_base_price_139
val x4623 = x1955.sum_disc_price_140
val x4624 = x1955.sum_charge_141
val x4625 = x1955.avg_qty_142
val x4626 = x1955.avg_price_143
val x4627 = x1955.avg_disc_144
val x4628 = x1955.count_order_145
val x4629 = x4619(x1954.toInt)
val x4630 = x4620(x1954.toInt)
val x4631 = x4621(x1954.toInt)
val x4632 = x4622(x1954.toInt)
val x4633 = x4623(x1954.toInt)
val x4634 = x4624(x1954.toInt)
val x4635 = x4625(x1954.toInt)
val x4636 = x4626(x1954.toInt)
val x4637 = x4627(x1954.toInt)
val x4638 = x4628(x1954.toInt)
val x4639 = new generated.scala.Anon1187970594(x4629,x4630,x4631,x4632,x4633,x4634,x4635,x4636,x4637,x4638)
val x1921: generated.scala.Anon1187970594 = x4639
val x1922: generated.scala.Anon1187970594 = x5520
val x1923 = x1921.l_returnflag_44
val x1925 = x1921.l_linestatus_45
val x1927 = x1921.sum_qty_138
val x1928 = x1922.sum_qty_138
val x1929 = {
x1927 + x1928}
val x1930 = x1921.sum_base_price_139
val x1931 = x1922.sum_base_price_139
val x1932 = {
x1930 + x1931}
val x1933 = x1921.sum_disc_price_140
val x1934 = x1922.sum_disc_price_140
val x1935 = {
x1933 + x1934}
val x1936 = x1921.sum_charge_141
val x1937 = x1922.sum_charge_141
val x1938 = {
x1936 + x1937}
val x1939 = x1921.avg_qty_142
val x1940 = x1922.avg_qty_142
val x1941 = {
x1939 + x1940}
val x1942 = x1921.avg_price_143
val x1943 = x1922.avg_price_143
val x1944 = {
x1942 + x1943}
val x1945 = x1921.avg_disc_144
val x1946 = x1922.avg_disc_144
val x1947 = {
x1945 + x1946}
val x1948 = x1921.count_order_145
val x1949 = x1922.count_order_145
val x1950 = {
x1948 + x1949}
val x1951 = new generated.scala.Anon1187970594(x1923,x1925,x1929,x1932,x1935,x1938,x1941,x1944,x1947,x1950)
val x1952: generated.scala.Anon1187970594 = x1951
val x4641 = x1955.l_returnflag_44
val x1991 = x1952.l_returnflag_44
val x4642 = x1955.l_returnflag_44(x1954.toInt) = x1991
val x4643 = x1955.l_linestatus_45
val x1994 = x1952.l_linestatus_45
val x4644 = x1955.l_linestatus_45(x1954.toInt) = x1994
val x4645 = x1955.sum_qty_138
val x1997 = x1952.sum_qty_138
val x4646 = x1955.sum_qty_138(x1954.toInt) = x1997
val x4647 = x1955.sum_base_price_139
val x2000 = x1952.sum_base_price_139
val x4648 = x1955.sum_base_price_139(x1954.toInt) = x2000
val x4649 = x1955.sum_disc_price_140
val x2003 = x1952.sum_disc_price_140
val x4650 = x1955.sum_disc_price_140(x1954.toInt) = x2003
val x4651 = x1955.sum_charge_141
val x2006 = x1952.sum_charge_141
val x4652 = x1955.sum_charge_141(x1954.toInt) = x2006
val x4653 = x1955.avg_qty_142
val x2009 = x1952.avg_qty_142
val x4654 = x1955.avg_qty_142(x1954.toInt) = x2009
val x4655 = x1955.avg_price_143
val x2012 = x1952.avg_price_143
val x4656 = x1955.avg_price_143(x1954.toInt) = x2012
val x4657 = x1955.avg_disc_144
val x2015 = x1952.avg_disc_144
val x4658 = x1955.avg_disc_144(x1954.toInt) = x2015
val x4659 = x1955.count_order_145
val x2018 = x1952.count_order_145
val x4660 = x1955.count_order_145(x1954.toInt) = x2018
val x2245: Int = x5583x5615_idx
val x2246: Array[Int] = __act2.x5615_hash_data
val x4794 = x2246(x2245.toInt)
val x2240: Int = x4794
val x2241: Int = 1
val x2242 = x2240 + x2241
val x2243: Int = x2242
val x4796 = x2246(x2245.toInt) = x2243
}
}
}
__act2
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5583x5615,x382:Int): Unit = {
val x3861 = x3604(x382.toInt)
val x3862 = {
x3861 <= x418}
val x3867 = x3346(x382.toInt)
val x3868 = x3389(x382.toInt)
val x3869 = x3432(x382.toInt)
val x3871 = x3518(x382.toInt)
val x3872 = x3561(x382.toInt)
val x5516 = {
1.0 - x3869}
val x5517 = {
x3868 * x5516}
val x3870 = x3475(x382.toInt)
val x5518 = {
1.0 + x3870}
val x5519 = {
x5517 * x5518}
val x5520 = new generated.scala.Anon1187970594(x3871,x3872,x3867,x3868,x5517,x5519,x3867,x3868,x3869,1)
val x5515 = new generated.scala.Anon1637442313(x3871,x3872)
if (true && x3862) {
// common key Block(Sym(5515)) for x5583x5615
val x5583x5615_sze: Int = __act.x5583x5615_hash_pos.size
val x5583x5615_idx: Int = __act.x5583x5615_hash_pos.put(x5515)
if (x5583x5615_idx == x5583x5615_sze) { // new key
val x1955: generated.scala.DeliteArrayAnon1187970594 = __act.x5583_hash_data
val x1952: generated.scala.Anon1187970594 = x5520
val x4664 = x5583x5615_sze
val x4665 = x1955.l_returnflag_44
val x4666 = x4665.length
val x4667 = x4666 - 1
val x4668 = x4664 > x4667
val x4736 = {
def x4736thenb(): Unit = {
val x4669 = x4666 < 16
val x4673 = {
def x4673thenb(): Int = {
16
}
def x4673elseb(): Int = {
val x4670 = x4666 * 2
val x4671 = x4670 < 0
val x4672 = {
def x4672thenb(): Int = {
2147483647
}
def x4672elseb(): Int = {
x4670
}
if (x4671) {
x4672thenb()
} else { 
x4672elseb()
}
}
x4672
}
if (x4669) {
x4673thenb()
} else { 
x4673elseb()
}
}
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4674 = new Array[java.lang.String](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4675 = new Array[java.lang.String](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4676 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4677 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4678 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4679 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4680 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4681 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4682 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4683 = new Array[Int](x4673.toInt)
val x4684 = System.arraycopy(x4665,0.toInt,x4674,0.toInt,x4666.toInt)
val x4685 = x1955.l_linestatus_45
val x4686 = System.arraycopy(x4685,0.toInt,x4675,0.toInt,x4666.toInt)
val x4687 = x1955.sum_qty_138
val x4688 = System.arraycopy(x4687,0.toInt,x4676,0.toInt,x4666.toInt)
val x4689 = x1955.sum_base_price_139
val x4690 = System.arraycopy(x4689,0.toInt,x4677,0.toInt,x4666.toInt)
val x4691 = x1955.sum_disc_price_140
val x4692 = System.arraycopy(x4691,0.toInt,x4678,0.toInt,x4666.toInt)
val x4693 = x1955.sum_charge_141
val x4694 = System.arraycopy(x4693,0.toInt,x4679,0.toInt,x4666.toInt)
val x4695 = x1955.avg_qty_142
val x4696 = System.arraycopy(x4695,0.toInt,x4680,0.toInt,x4666.toInt)
val x4697 = x1955.avg_price_143
val x4698 = System.arraycopy(x4697,0.toInt,x4681,0.toInt,x4666.toInt)
val x4699 = x1955.avg_disc_144
val x4700 = System.arraycopy(x4699,0.toInt,x4682,0.toInt,x4666.toInt)
val x4701 = x1955.count_order_145
val x4702 = System.arraycopy(x4701,0.toInt,x4683,0.toInt,x4666.toInt)
val x1991 = x1952.l_returnflag_44
val x4703 = x4674(x4664.toInt) = x1991
val x1994 = x1952.l_linestatus_45
val x4704 = x4675(x4664.toInt) = x1994
val x1997 = x1952.sum_qty_138
val x4705 = x4676(x4664.toInt) = x1997
val x2000 = x1952.sum_base_price_139
val x4706 = x4677(x4664.toInt) = x2000
val x2003 = x1952.sum_disc_price_140
val x4707 = x4678(x4664.toInt) = x2003
val x2006 = x1952.sum_charge_141
val x4708 = x4679(x4664.toInt) = x2006
val x2009 = x1952.avg_qty_142
val x4709 = x4680(x4664.toInt) = x2009
val x2012 = x1952.avg_price_143
val x4710 = x4681(x4664.toInt) = x2012
val x2015 = x1952.avg_disc_144
val x4711 = x4682(x4664.toInt) = x2015
val x2018 = x1952.count_order_145
val x4712 = x4683(x4664.toInt) = x2018
val x4713 = new generated.scala.DeliteArrayAnon1187970594(x4674,x4675,x4676,x4677,x4678,x4679,x4680,x4681,x4682,x4683)
val x4714 = __act.x5583_hash_data = x4713
x4714
}
def x4736elseb(): Unit = {
val x1991 = x1952.l_returnflag_44
val x4716 = x1955.l_returnflag_44(x4664.toInt) = x1991
val x4717 = x1955.l_linestatus_45
val x1994 = x1952.l_linestatus_45
val x4718 = x1955.l_linestatus_45(x4664.toInt) = x1994
val x4719 = x1955.sum_qty_138
val x1997 = x1952.sum_qty_138
val x4720 = x1955.sum_qty_138(x4664.toInt) = x1997
val x4721 = x1955.sum_base_price_139
val x2000 = x1952.sum_base_price_139
val x4722 = x1955.sum_base_price_139(x4664.toInt) = x2000
val x4723 = x1955.sum_disc_price_140
val x2003 = x1952.sum_disc_price_140
val x4724 = x1955.sum_disc_price_140(x4664.toInt) = x2003
val x4725 = x1955.sum_charge_141
val x2006 = x1952.sum_charge_141
val x4726 = x1955.sum_charge_141(x4664.toInt) = x2006
val x4727 = x1955.avg_qty_142
val x2009 = x1952.avg_qty_142
val x4728 = x1955.avg_qty_142(x4664.toInt) = x2009
val x4729 = x1955.avg_price_143
val x2012 = x1952.avg_price_143
val x4730 = x1955.avg_price_143(x4664.toInt) = x2012
val x4731 = x1955.avg_disc_144
val x2015 = x1952.avg_disc_144
val x4732 = x1955.avg_disc_144(x4664.toInt) = x2015
val x4733 = x1955.count_order_145
val x2018 = x1952.count_order_145
val x4734 = x1955.count_order_145(x4664.toInt) = x2018
()
}
if (x4668) {
x4736thenb()
} else { 
x4736elseb()
}
}
val x2246: Array[Int] = __act.x5615_hash_data
val x2243: Int = 1
val x4800 = x5583x5615_sze
val x4801 = x2246.length
val x4802 = x4801 - 1
val x4803 = x4800 > x4802
val x4816 = {
def x4816thenb(): Unit = {
val x4804 = x4801 < 16
val x4808 = {
def x4808thenb(): Int = {
16
}
def x4808elseb(): Int = {
val x4805 = x4801 * 2
val x4806 = x4805 < 0
val x4807 = {
def x4807thenb(): Int = {
2147483647
}
def x4807elseb(): Int = {
x4805
}
if (x4806) {
x4807thenb()
} else { 
x4807elseb()
}
}
x4807
}
if (x4804) {
x4808thenb()
} else { 
x4808elseb()
}
}
if (x4808 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4809 = new Array[Int](x4808.toInt)
val x4810 = System.arraycopy(x2246,0.toInt,x4809,0.toInt,x4801.toInt)
val x4811 = x4809(x4800.toInt) = x2243
val x4812 = __act.x5615_hash_data = x4809
x4812
}
def x4816elseb(): Unit = {
val x4814 = x2246(x4800.toInt) = x2243
x4814
}
if (x4803) {
x4816thenb()
} else { 
x4816elseb()
}
}
} else { // existing key
val x1954: Int = x5583x5615_idx
val x1955: generated.scala.DeliteArrayAnon1187970594 = __act.x5583_hash_data
val x4619 = x1955.l_returnflag_44
val x4620 = x1955.l_linestatus_45
val x4621 = x1955.sum_qty_138
val x4622 = x1955.sum_base_price_139
val x4623 = x1955.sum_disc_price_140
val x4624 = x1955.sum_charge_141
val x4625 = x1955.avg_qty_142
val x4626 = x1955.avg_price_143
val x4627 = x1955.avg_disc_144
val x4628 = x1955.count_order_145
val x4629 = x4619(x1954.toInt)
val x4630 = x4620(x1954.toInt)
val x4631 = x4621(x1954.toInt)
val x4632 = x4622(x1954.toInt)
val x4633 = x4623(x1954.toInt)
val x4634 = x4624(x1954.toInt)
val x4635 = x4625(x1954.toInt)
val x4636 = x4626(x1954.toInt)
val x4637 = x4627(x1954.toInt)
val x4638 = x4628(x1954.toInt)
val x4639 = new generated.scala.Anon1187970594(x4629,x4630,x4631,x4632,x4633,x4634,x4635,x4636,x4637,x4638)
val x1921: generated.scala.Anon1187970594 = x4639
val x1922: generated.scala.Anon1187970594 = x5520
val x1923 = x1921.l_returnflag_44
val x1925 = x1921.l_linestatus_45
val x1927 = x1921.sum_qty_138
val x1928 = x1922.sum_qty_138
val x1929 = {
x1927 + x1928}
val x1930 = x1921.sum_base_price_139
val x1931 = x1922.sum_base_price_139
val x1932 = {
x1930 + x1931}
val x1933 = x1921.sum_disc_price_140
val x1934 = x1922.sum_disc_price_140
val x1935 = {
x1933 + x1934}
val x1936 = x1921.sum_charge_141
val x1937 = x1922.sum_charge_141
val x1938 = {
x1936 + x1937}
val x1939 = x1921.avg_qty_142
val x1940 = x1922.avg_qty_142
val x1941 = {
x1939 + x1940}
val x1942 = x1921.avg_price_143
val x1943 = x1922.avg_price_143
val x1944 = {
x1942 + x1943}
val x1945 = x1921.avg_disc_144
val x1946 = x1922.avg_disc_144
val x1947 = {
x1945 + x1946}
val x1948 = x1921.count_order_145
val x1949 = x1922.count_order_145
val x1950 = {
x1948 + x1949}
val x1951 = new generated.scala.Anon1187970594(x1923,x1925,x1929,x1932,x1935,x1938,x1941,x1944,x1947,x1950)
val x1952: generated.scala.Anon1187970594 = x1951
val x4641 = x1955.l_returnflag_44
val x1991 = x1952.l_returnflag_44
val x4642 = x1955.l_returnflag_44(x1954.toInt) = x1991
val x4643 = x1955.l_linestatus_45
val x1994 = x1952.l_linestatus_45
val x4644 = x1955.l_linestatus_45(x1954.toInt) = x1994
val x4645 = x1955.sum_qty_138
val x1997 = x1952.sum_qty_138
val x4646 = x1955.sum_qty_138(x1954.toInt) = x1997
val x4647 = x1955.sum_base_price_139
val x2000 = x1952.sum_base_price_139
val x4648 = x1955.sum_base_price_139(x1954.toInt) = x2000
val x4649 = x1955.sum_disc_price_140
val x2003 = x1952.sum_disc_price_140
val x4650 = x1955.sum_disc_price_140(x1954.toInt) = x2003
val x4651 = x1955.sum_charge_141
val x2006 = x1952.sum_charge_141
val x4652 = x1955.sum_charge_141(x1954.toInt) = x2006
val x4653 = x1955.avg_qty_142
val x2009 = x1952.avg_qty_142
val x4654 = x1955.avg_qty_142(x1954.toInt) = x2009
val x4655 = x1955.avg_price_143
val x2012 = x1952.avg_price_143
val x4656 = x1955.avg_price_143(x1954.toInt) = x2012
val x4657 = x1955.avg_disc_144
val x2015 = x1952.avg_disc_144
val x4658 = x1955.avg_disc_144(x1954.toInt) = x2015
val x4659 = x1955.count_order_145
val x2018 = x1952.count_order_145
val x4660 = x1955.count_order_145(x1954.toInt) = x2018
val x2245: Int = x5583x5615_idx
val x2246: Array[Int] = __act.x5615_hash_data
val x4794 = x2246(x2245.toInt)
val x2240: Int = x4794
val x2241: Int = 1
val x2242 = x2240 + x2241
val x2243: Int = x2242
val x4796 = x2246(x2245.toInt) = x2243
}
}
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5583x5615,rhs:activation_x5583x5615): Unit = {
// common key Block(Sym(5515)) for x5583x5615
if (__act.x5583x5615_size == -1) __act.x5583x5615_size = __act.x5583x5615_hash_pos.size
if (rhs.x5583x5615_size == -1) rhs.x5583x5615_size = rhs.x5583x5615_hash_pos.size
var x5583x5615rhs_idx: Int = 0
while (x5583x5615rhs_idx < rhs.x5583x5615_hash_pos.size) {
val x5583x5615_k: generated.scala.Anon1637442313 = rhs.x5583x5615_hash_pos.unsafeKeys(x5583x5615rhs_idx.toInt)
val x5583x5615_sze: Int = __act.x5583x5615_hash_pos.size
val x5583x5615_idx: Int = __act.x5583x5615_hash_pos.put(x5583x5615_k)
if (x5583x5615_idx == x5583x5615_sze) { // new key
var x1955: generated.scala.DeliteArrayAnon1187970594 = rhs.x5583_hash_data
val x1954: Int = x5583x5615rhs_idx
val x4619 = x1955.l_returnflag_44
val x4620 = x1955.l_linestatus_45
val x4621 = x1955.sum_qty_138
val x4622 = x1955.sum_base_price_139
val x4623 = x1955.sum_disc_price_140
val x4624 = x1955.sum_charge_141
val x4625 = x1955.avg_qty_142
val x4626 = x1955.avg_price_143
val x4627 = x1955.avg_disc_144
val x4628 = x1955.count_order_145
val x4629 = x4619(x1954.toInt)
val x4630 = x4620(x1954.toInt)
val x4631 = x4621(x1954.toInt)
val x4632 = x4622(x1954.toInt)
val x4633 = x4623(x1954.toInt)
val x4634 = x4624(x1954.toInt)
val x4635 = x4625(x1954.toInt)
val x4636 = x4626(x1954.toInt)
val x4637 = x4627(x1954.toInt)
val x4638 = x4628(x1954.toInt)
val x4639 = new generated.scala.Anon1187970594(x4629,x4630,x4631,x4632,x4633,x4634,x4635,x4636,x4637,x4638)
x1955 = __act.x5583_hash_data
val x1952: generated.scala.Anon1187970594 = x4639
val x4664 = x5583x5615_sze
val x4665 = x1955.l_returnflag_44
val x4666 = x4665.length
val x4667 = x4666 - 1
val x4668 = x4664 > x4667
val x4736 = {
def x4736thenb(): Unit = {
val x4669 = x4666 < 16
val x4673 = {
def x4673thenb(): Int = {
16
}
def x4673elseb(): Int = {
val x4670 = x4666 * 2
val x4671 = x4670 < 0
val x4672 = {
def x4672thenb(): Int = {
2147483647
}
def x4672elseb(): Int = {
x4670
}
if (x4671) {
x4672thenb()
} else { 
x4672elseb()
}
}
x4672
}
if (x4669) {
x4673thenb()
} else { 
x4673elseb()
}
}
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4674 = new Array[java.lang.String](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4675 = new Array[java.lang.String](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4676 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4677 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4678 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4679 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4680 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4681 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4682 = new Array[Double](x4673.toInt)
if (x4673 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4683 = new Array[Int](x4673.toInt)
val x4684 = System.arraycopy(x4665,0.toInt,x4674,0.toInt,x4666.toInt)
val x4685 = x1955.l_linestatus_45
val x4686 = System.arraycopy(x4685,0.toInt,x4675,0.toInt,x4666.toInt)
val x4687 = x1955.sum_qty_138
val x4688 = System.arraycopy(x4687,0.toInt,x4676,0.toInt,x4666.toInt)
val x4689 = x1955.sum_base_price_139
val x4690 = System.arraycopy(x4689,0.toInt,x4677,0.toInt,x4666.toInt)
val x4691 = x1955.sum_disc_price_140
val x4692 = System.arraycopy(x4691,0.toInt,x4678,0.toInt,x4666.toInt)
val x4693 = x1955.sum_charge_141
val x4694 = System.arraycopy(x4693,0.toInt,x4679,0.toInt,x4666.toInt)
val x4695 = x1955.avg_qty_142
val x4696 = System.arraycopy(x4695,0.toInt,x4680,0.toInt,x4666.toInt)
val x4697 = x1955.avg_price_143
val x4698 = System.arraycopy(x4697,0.toInt,x4681,0.toInt,x4666.toInt)
val x4699 = x1955.avg_disc_144
val x4700 = System.arraycopy(x4699,0.toInt,x4682,0.toInt,x4666.toInt)
val x4701 = x1955.count_order_145
val x4702 = System.arraycopy(x4701,0.toInt,x4683,0.toInt,x4666.toInt)
val x1991 = x1952.l_returnflag_44
val x4703 = x4674(x4664.toInt) = x1991
val x1994 = x1952.l_linestatus_45
val x4704 = x4675(x4664.toInt) = x1994
val x1997 = x1952.sum_qty_138
val x4705 = x4676(x4664.toInt) = x1997
val x2000 = x1952.sum_base_price_139
val x4706 = x4677(x4664.toInt) = x2000
val x2003 = x1952.sum_disc_price_140
val x4707 = x4678(x4664.toInt) = x2003
val x2006 = x1952.sum_charge_141
val x4708 = x4679(x4664.toInt) = x2006
val x2009 = x1952.avg_qty_142
val x4709 = x4680(x4664.toInt) = x2009
val x2012 = x1952.avg_price_143
val x4710 = x4681(x4664.toInt) = x2012
val x2015 = x1952.avg_disc_144
val x4711 = x4682(x4664.toInt) = x2015
val x2018 = x1952.count_order_145
val x4712 = x4683(x4664.toInt) = x2018
val x4713 = new generated.scala.DeliteArrayAnon1187970594(x4674,x4675,x4676,x4677,x4678,x4679,x4680,x4681,x4682,x4683)
val x4714 = __act.x5583_hash_data = x4713
x4714
}
def x4736elseb(): Unit = {
val x1991 = x1952.l_returnflag_44
val x4716 = x1955.l_returnflag_44(x4664.toInt) = x1991
val x4717 = x1955.l_linestatus_45
val x1994 = x1952.l_linestatus_45
val x4718 = x1955.l_linestatus_45(x4664.toInt) = x1994
val x4719 = x1955.sum_qty_138
val x1997 = x1952.sum_qty_138
val x4720 = x1955.sum_qty_138(x4664.toInt) = x1997
val x4721 = x1955.sum_base_price_139
val x2000 = x1952.sum_base_price_139
val x4722 = x1955.sum_base_price_139(x4664.toInt) = x2000
val x4723 = x1955.sum_disc_price_140
val x2003 = x1952.sum_disc_price_140
val x4724 = x1955.sum_disc_price_140(x4664.toInt) = x2003
val x4725 = x1955.sum_charge_141
val x2006 = x1952.sum_charge_141
val x4726 = x1955.sum_charge_141(x4664.toInt) = x2006
val x4727 = x1955.avg_qty_142
val x2009 = x1952.avg_qty_142
val x4728 = x1955.avg_qty_142(x4664.toInt) = x2009
val x4729 = x1955.avg_price_143
val x2012 = x1952.avg_price_143
val x4730 = x1955.avg_price_143(x4664.toInt) = x2012
val x4731 = x1955.avg_disc_144
val x2015 = x1952.avg_disc_144
val x4732 = x1955.avg_disc_144(x4664.toInt) = x2015
val x4733 = x1955.count_order_145
val x2018 = x1952.count_order_145
val x4734 = x1955.count_order_145(x4664.toInt) = x2018
()
}
if (x4668) {
x4736thenb()
} else { 
x4736elseb()
}
}
var x2246: Array[Int] = rhs.x5615_hash_data
val x2245: Int = x5583x5615rhs_idx
val x4794 = x2246(x2245.toInt)
x2246 = __act.x5615_hash_data
val x2243: Int = x4794
val x4800 = x5583x5615_sze
val x4801 = x2246.length
val x4802 = x4801 - 1
val x4803 = x4800 > x4802
val x4816 = {
def x4816thenb(): Unit = {
val x4804 = x4801 < 16
val x4808 = {
def x4808thenb(): Int = {
16
}
def x4808elseb(): Int = {
val x4805 = x4801 * 2
val x4806 = x4805 < 0
val x4807 = {
def x4807thenb(): Int = {
2147483647
}
def x4807elseb(): Int = {
x4805
}
if (x4806) {
x4807thenb()
} else { 
x4807elseb()
}
}
x4807
}
if (x4804) {
x4808thenb()
} else { 
x4808elseb()
}
}
if (x4808 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4809 = new Array[Int](x4808.toInt)
val x4810 = System.arraycopy(x2246,0.toInt,x4809,0.toInt,x4801.toInt)
val x4811 = x4809(x4800.toInt) = x2243
val x4812 = __act.x5615_hash_data = x4809
x4812
}
def x4816elseb(): Unit = {
val x4814 = x2246(x4800.toInt) = x2243
x4814
}
if (x4803) {
x4816thenb()
} else { 
x4816elseb()
}
}
} else { // existing key
val x1955: generated.scala.DeliteArrayAnon1187970594 = rhs.x5583_hash_data
val x1954: Int = x5583x5615rhs_idx
val x4619 = x1955.l_returnflag_44
val x4620 = x1955.l_linestatus_45
val x4621 = x1955.sum_qty_138
val x4622 = x1955.sum_base_price_139
val x4623 = x1955.sum_disc_price_140
val x4624 = x1955.sum_charge_141
val x4625 = x1955.avg_qty_142
val x4626 = x1955.avg_price_143
val x4627 = x1955.avg_disc_144
val x4628 = x1955.count_order_145
val x4629 = x4619(x1954.toInt)
val x4630 = x4620(x1954.toInt)
val x4631 = x4621(x1954.toInt)
val x4632 = x4622(x1954.toInt)
val x4633 = x4623(x1954.toInt)
val x4634 = x4624(x1954.toInt)
val x4635 = x4625(x1954.toInt)
val x4636 = x4626(x1954.toInt)
val x4637 = x4627(x1954.toInt)
val x4638 = x4628(x1954.toInt)
val x4639 = new generated.scala.Anon1187970594(x4629,x4630,x4631,x4632,x4633,x4634,x4635,x4636,x4637,x4638)
val x5583_v: generated.scala.Anon1187970594 = x4639
val x5583_reduce_block: Unit = {
val x1955: generated.scala.DeliteArrayAnon1187970594 = __act.x5583_hash_data
val x1954: Int = x5583x5615_idx
val x4619 = x1955.l_returnflag_44
val x4620 = x1955.l_linestatus_45
val x4621 = x1955.sum_qty_138
val x4622 = x1955.sum_base_price_139
val x4623 = x1955.sum_disc_price_140
val x4624 = x1955.sum_charge_141
val x4625 = x1955.avg_qty_142
val x4626 = x1955.avg_price_143
val x4627 = x1955.avg_disc_144
val x4628 = x1955.count_order_145
val x4629 = x4619(x1954.toInt)
val x4630 = x4620(x1954.toInt)
val x4631 = x4621(x1954.toInt)
val x4632 = x4622(x1954.toInt)
val x4633 = x4623(x1954.toInt)
val x4634 = x4624(x1954.toInt)
val x4635 = x4625(x1954.toInt)
val x4636 = x4626(x1954.toInt)
val x4637 = x4627(x1954.toInt)
val x4638 = x4628(x1954.toInt)
val x4639 = new generated.scala.Anon1187970594(x4629,x4630,x4631,x4632,x4633,x4634,x4635,x4636,x4637,x4638)
val x1921: generated.scala.Anon1187970594 = x4639
val x1922: generated.scala.Anon1187970594 = x5583_v
val x1923 = x1921.l_returnflag_44
val x1925 = x1921.l_linestatus_45
val x1927 = x1921.sum_qty_138
val x1928 = x1922.sum_qty_138
val x1929 = {
x1927 + x1928}
val x1930 = x1921.sum_base_price_139
val x1931 = x1922.sum_base_price_139
val x1932 = {
x1930 + x1931}
val x1933 = x1921.sum_disc_price_140
val x1934 = x1922.sum_disc_price_140
val x1935 = {
x1933 + x1934}
val x1936 = x1921.sum_charge_141
val x1937 = x1922.sum_charge_141
val x1938 = {
x1936 + x1937}
val x1939 = x1921.avg_qty_142
val x1940 = x1922.avg_qty_142
val x1941 = {
x1939 + x1940}
val x1942 = x1921.avg_price_143
val x1943 = x1922.avg_price_143
val x1944 = {
x1942 + x1943}
val x1945 = x1921.avg_disc_144
val x1946 = x1922.avg_disc_144
val x1947 = {
x1945 + x1946}
val x1948 = x1921.count_order_145
val x1949 = x1922.count_order_145
val x1950 = {
x1948 + x1949}
val x1951 = new generated.scala.Anon1187970594(x1923,x1925,x1929,x1932,x1935,x1938,x1941,x1944,x1947,x1950)
val x1952: generated.scala.Anon1187970594 = x1951
val x4641 = x1955.l_returnflag_44
val x1991 = x1952.l_returnflag_44
val x4642 = x1955.l_returnflag_44(x1954.toInt) = x1991
val x4643 = x1955.l_linestatus_45
val x1994 = x1952.l_linestatus_45
val x4644 = x1955.l_linestatus_45(x1954.toInt) = x1994
val x4645 = x1955.sum_qty_138
val x1997 = x1952.sum_qty_138
val x4646 = x1955.sum_qty_138(x1954.toInt) = x1997
val x4647 = x1955.sum_base_price_139
val x2000 = x1952.sum_base_price_139
val x4648 = x1955.sum_base_price_139(x1954.toInt) = x2000
val x4649 = x1955.sum_disc_price_140
val x2003 = x1952.sum_disc_price_140
val x4650 = x1955.sum_disc_price_140(x1954.toInt) = x2003
val x4651 = x1955.sum_charge_141
val x2006 = x1952.sum_charge_141
val x4652 = x1955.sum_charge_141(x1954.toInt) = x2006
val x4653 = x1955.avg_qty_142
val x2009 = x1952.avg_qty_142
val x4654 = x1955.avg_qty_142(x1954.toInt) = x2009
val x4655 = x1955.avg_price_143
val x2012 = x1952.avg_price_143
val x4656 = x1955.avg_price_143(x1954.toInt) = x2012
val x4657 = x1955.avg_disc_144
val x2015 = x1952.avg_disc_144
val x4658 = x1955.avg_disc_144(x1954.toInt) = x2015
val x4659 = x1955.count_order_145
val x2018 = x1952.count_order_145
val x4660 = x1955.count_order_145(x1954.toInt) = x2018
}
val x2246: Array[Int] = rhs.x5615_hash_data
val x2245: Int = x5583x5615rhs_idx
val x4794 = x2246(x2245.toInt)
val x5615_v: Int = x4794
val x5615_reduce_block: Unit = {
val x2246: Array[Int] = __act.x5615_hash_data
val x2245: Int = x5583x5615_idx
val x4794 = x2246(x2245.toInt)
val x2240: Int = x4794
val x2241: Int = x5615_v
val x2242 = x2240 + x2241
val x2243: Int = x2242
val x4796 = x2246(x2245.toInt) = x2243
}
}
x5583x5615rhs_idx = x5583x5615rhs_idx+1
}
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5583x5615,lhs:activation_x5583x5615): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5583x5615): Unit = {
val tid: Int = resourceInfo.groupId
if (tid > 0) {
val all_acts: Array[activation_x5583x5615] = new Array[activation_x5583x5615](resourceInfo.groupSize)
var currentAct: activation_x5583x5615 = __act
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

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5583x5615): Unit = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
if (__act.all_acts ne null) {
val all_acts: Array[activation_x5583x5615] = __act.all_acts
val x5583x5615_globalKeys: Array[generated.scala.Anon1637442313] = __act.all_acts(0).x5583x5615_hash_pos.unsafeKeys
var x5583x5615_idx: Int = ((__act.all_acts(0).x5583x5615_hash_pos.size).asInstanceOf[Long] * tid / numThreads).asInstanceOf[Int]
val x5583x5615_end: Int = ((__act.all_acts(0).x5583x5615_hash_pos.size).asInstanceOf[Long] * (tid+1) / numThreads).asInstanceOf[Int]
while (x5583x5615_idx < x5583x5615_end) {
x5583x5615_idx = x5583x5615_idx + 1
}
}
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5583x5615): Unit = {
val x5583x5615_sze: Int = __act.x5583x5615_hash_pos.size
var x1955: generated.scala.DeliteArrayAnon1187970594 = __act.x5583_hash_data
val x1953: Int = x5583x5615_sze
val x4738 = x1955.l_returnflag_44
val x4739 = x4738.length
val x4740 = x4739 > x1953
val x4773 = {
def x4773thenb(): Unit = {
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4741 = new Array[java.lang.String](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4742 = new Array[java.lang.String](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4743 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4744 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4745 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4746 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4747 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4748 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4749 = new Array[Double](x1953.toInt)
if (x1953 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4750 = new Array[Int](x1953.toInt)
val x4751 = System.arraycopy(x4738,0.toInt,x4741,0.toInt,x1953.toInt)
val x4752 = x1955.l_linestatus_45
val x4753 = System.arraycopy(x4752,0.toInt,x4742,0.toInt,x1953.toInt)
val x4754 = x1955.sum_qty_138
val x4755 = System.arraycopy(x4754,0.toInt,x4743,0.toInt,x1953.toInt)
val x4756 = x1955.sum_base_price_139
val x4757 = System.arraycopy(x4756,0.toInt,x4744,0.toInt,x1953.toInt)
val x4758 = x1955.sum_disc_price_140
val x4759 = System.arraycopy(x4758,0.toInt,x4745,0.toInt,x1953.toInt)
val x4760 = x1955.sum_charge_141
val x4761 = System.arraycopy(x4760,0.toInt,x4746,0.toInt,x1953.toInt)
val x4762 = x1955.avg_qty_142
val x4763 = System.arraycopy(x4762,0.toInt,x4747,0.toInt,x1953.toInt)
val x4764 = x1955.avg_price_143
val x4765 = System.arraycopy(x4764,0.toInt,x4748,0.toInt,x1953.toInt)
val x4766 = x1955.avg_disc_144
val x4767 = System.arraycopy(x4766,0.toInt,x4749,0.toInt,x1953.toInt)
val x4768 = x1955.count_order_145
val x4769 = System.arraycopy(x4768,0.toInt,x4750,0.toInt,x1953.toInt)
val x4770 = new generated.scala.DeliteArrayAnon1187970594(x4741,x4742,x4743,x4744,x4745,x4746,x4747,x4748,x4749,x4750)
val x4771 = x1955 = x4770
x4771
}
if (x4740) {
x4773thenb()
}
}
__act.x5583 = x1955
var x2246: Array[Int] = __act.x5615_hash_data
val x2244: Int = x5583x5615_sze
val x4818 = x2246.length
val x4819 = x4818 > x2244
val x4824 = {
def x4824thenb(): Unit = {
if (x2244 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4820 = new Array[Int](x2244.toInt)
val x4821 = System.arraycopy(x2246,0.toInt,x4820,0.toInt,x2244.toInt)
val x4822 = x2246 = x4820
x4822
}
if (x4819) {
x4824thenb()
}
}
__act.x5615 = x2246
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x5583x5615 = {
val act: activation_x5583x5615 = new activation_x5583x5615
act.x5583x5615_hash_pos = new generated.scala.container.HashMapImpl[generated.scala.Anon1637442313](512,128)
act
}

}
x5583x5615_closure.loopStart = 0
x5583x5615_closure.loopSize = x3820
val alloc: activation_x5583x5615 = x5583x5615_closure.alloc(resourceInfo)
var x5583x5615: activation_x5583x5615 = null
if (resourceInfo.availableThreads <= 1) {
x5583x5615 = x5583x5615_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x5583x5615] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x5583x5615](x5583x5615_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x5583x5615_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x5583x5615 = x5583x5615_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x5583x5615
}}

/**********/


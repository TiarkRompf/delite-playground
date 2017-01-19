package generated.scala
//activation record for fat loop
final class activation_x1718 {
var left_act: activation_x1718 = _
var all_acts: Array[activation_x1718] = _
var x1718_hash_pos: generated.scala.container.HashMapImpl[Int] = _
var x1718_size: Int = _
var x1718: generated.scala.DeliteArrayAnon46814458 = _
var x1718_hash_data: generated.scala.DeliteArrayAnon46814458 = _
}
object activation_x1718 {
}
object kernel_x1718 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2:Long,x786:generated.scala.Anon46814458,x1:generated.scala.io.DeliteFileInputStream): activation_x1718 = {
val x1718_closure = new generated.scala.DeliteOpMultiLoop[activation_x1718] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x2
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x1718 = {
val __act: activation_x1718 = new activation_x1718()
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x1718,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x1718]): activation_x1718 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x1718 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x1718 = sync.get(localStart)
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

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x1718): activation_x1718 = {
val act: activation_x1718 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x1718,start:Long,end:Long): activation_x1718 = {
val x1_stream: generated.scala.io.DeliteFileInputStream = x1.openCopyAtNewLine(start)
val x1_stream_offset: Long = x1_stream.streamOffset
val isEmpty: Boolean = end <= x1_stream.position
val __act2: activation_x1718 = init(resourceInfo,__act,-1,isEmpty,x1_stream)
while (x1_stream.position < x1_stream_offset + end) {
process(resourceInfo,__act2,-1,x1_stream)
}
x1_stream.close();
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x1718,x3:Int,isEmpty:Boolean,x1_stream:generated.scala.io.DeliteFileInputStream): activation_x1718 = {
val __act2: activation_x1718 = new activation_x1718()
__act2.x1718_hash_pos = new generated.scala.container.HashMapImpl[Int](512,128)
__act2.x1718_size = -1
val x796: Int = 128
if (x796 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1587 = new Array[Int](x796.toInt)
if (x796 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1588 = new Array[Int](x796.toInt)
val x1589 = new generated.scala.DeliteArrayAnon46814458(x1587,x1588)
__act2.x1718_hash_data = x1589
if (!isEmpty) {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
val x9 = x5(2.toInt)
val x10 = {
x9.toInt}
val x1680 = {
x10 > 0}
val x1710 = new generated.scala.Anon46814458(x10,1)
if (true && x1680) {
// common key Block(Sym(10)) for x1718
val x1718_sze: Int = __act2.x1718_hash_pos.size
val x1718_idx: Int = __act2.x1718_hash_pos.put(x10)
if (x1718_idx == x1718_sze) { // new key
val x798: generated.scala.DeliteArrayAnon46814458 = __act2.x1718_hash_data
val x795: generated.scala.Anon46814458 = x1710
val x1604 = x1718_sze
val x1605 = x798.n_regionkey_116
val x1606 = x1605.length
val x1607 = x1606 - 1
val x1608 = x1604 > x1607
val x1628 = {
def x1628thenb(): Unit = {
val x1609 = x1606 < 16
val x1613 = {
def x1613thenb(): Int = {
16
}
def x1613elseb(): Int = {
val x1610 = x1606 * 2
val x1611 = x1610 < 0
val x1612 = {
def x1612thenb(): Int = {
2147483647
}
def x1612elseb(): Int = {
x1610
}
if (x1611) {
x1612thenb()
} else { 
x1612elseb()
}
}
x1612
}
if (x1609) {
x1613thenb()
} else { 
x1613elseb()
}
}
if (x1613 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1614 = new Array[Int](x1613.toInt)
if (x1613 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1615 = new Array[Int](x1613.toInt)
val x1616 = System.arraycopy(x1605,0.toInt,x1614,0.toInt,x1606.toInt)
val x1617 = x798.count1_143
val x1618 = System.arraycopy(x1617,0.toInt,x1615,0.toInt,x1606.toInt)
val x810 = x795.n_regionkey_116
val x1619 = x1614(x1604.toInt) = x810
val x813 = x795.count1_143
val x1620 = x1615(x1604.toInt) = x813
val x1621 = new generated.scala.DeliteArrayAnon46814458(x1614,x1615)
val x1622 = __act2.x1718_hash_data = x1621
x1622
}
def x1628elseb(): Unit = {
val x810 = x795.n_regionkey_116
val x1624 = x798.n_regionkey_116(x1604.toInt) = x810
val x1625 = x798.count1_143
val x813 = x795.count1_143
val x1626 = x798.count1_143(x1604.toInt) = x813
()
}
if (x1608) {
x1628thenb()
} else { 
x1628elseb()
}
}
} else { // existing key
val x797: Int = x1718_idx
val x798: generated.scala.DeliteArrayAnon46814458 = __act2.x1718_hash_data
val x1591 = x798.n_regionkey_116
val x1592 = x798.count1_143
val x1593 = x1591(x797.toInt)
val x1594 = x1592(x797.toInt)
val x1595 = new generated.scala.Anon46814458(x1593,x1594)
val x787: generated.scala.Anon46814458 = x1595
val x788: generated.scala.Anon46814458 = x1710
val x789 = x787.n_regionkey_116
val x791 = x787.count1_143
val x792 = x788.count1_143
val x793 = {
x791 + x792}
val x794 = new generated.scala.Anon46814458(x789,x793)
val x795: generated.scala.Anon46814458 = x794
val x1597 = x798.n_regionkey_116
val x810 = x795.n_regionkey_116
val x1598 = x798.n_regionkey_116(x797.toInt) = x810
val x1599 = x798.count1_143
val x813 = x795.count1_143
val x1600 = x798.count1_143(x797.toInt) = x813
}
}
}
__act2
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x1718,x3:Int,x1_stream:generated.scala.io.DeliteFileInputStream): Unit = {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
val x9 = x5(2.toInt)
val x10 = {
x9.toInt}
val x1680 = {
x10 > 0}
val x1710 = new generated.scala.Anon46814458(x10,1)
if (true && x1680) {
// common key Block(Sym(10)) for x1718
val x1718_sze: Int = __act.x1718_hash_pos.size
val x1718_idx: Int = __act.x1718_hash_pos.put(x10)
if (x1718_idx == x1718_sze) { // new key
val x798: generated.scala.DeliteArrayAnon46814458 = __act.x1718_hash_data
val x795: generated.scala.Anon46814458 = x1710
val x1604 = x1718_sze
val x1605 = x798.n_regionkey_116
val x1606 = x1605.length
val x1607 = x1606 - 1
val x1608 = x1604 > x1607
val x1628 = {
def x1628thenb(): Unit = {
val x1609 = x1606 < 16
val x1613 = {
def x1613thenb(): Int = {
16
}
def x1613elseb(): Int = {
val x1610 = x1606 * 2
val x1611 = x1610 < 0
val x1612 = {
def x1612thenb(): Int = {
2147483647
}
def x1612elseb(): Int = {
x1610
}
if (x1611) {
x1612thenb()
} else { 
x1612elseb()
}
}
x1612
}
if (x1609) {
x1613thenb()
} else { 
x1613elseb()
}
}
if (x1613 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1614 = new Array[Int](x1613.toInt)
if (x1613 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1615 = new Array[Int](x1613.toInt)
val x1616 = System.arraycopy(x1605,0.toInt,x1614,0.toInt,x1606.toInt)
val x1617 = x798.count1_143
val x1618 = System.arraycopy(x1617,0.toInt,x1615,0.toInt,x1606.toInt)
val x810 = x795.n_regionkey_116
val x1619 = x1614(x1604.toInt) = x810
val x813 = x795.count1_143
val x1620 = x1615(x1604.toInt) = x813
val x1621 = new generated.scala.DeliteArrayAnon46814458(x1614,x1615)
val x1622 = __act.x1718_hash_data = x1621
x1622
}
def x1628elseb(): Unit = {
val x810 = x795.n_regionkey_116
val x1624 = x798.n_regionkey_116(x1604.toInt) = x810
val x1625 = x798.count1_143
val x813 = x795.count1_143
val x1626 = x798.count1_143(x1604.toInt) = x813
()
}
if (x1608) {
x1628thenb()
} else { 
x1628elseb()
}
}
} else { // existing key
val x797: Int = x1718_idx
val x798: generated.scala.DeliteArrayAnon46814458 = __act.x1718_hash_data
val x1591 = x798.n_regionkey_116
val x1592 = x798.count1_143
val x1593 = x1591(x797.toInt)
val x1594 = x1592(x797.toInt)
val x1595 = new generated.scala.Anon46814458(x1593,x1594)
val x787: generated.scala.Anon46814458 = x1595
val x788: generated.scala.Anon46814458 = x1710
val x789 = x787.n_regionkey_116
val x791 = x787.count1_143
val x792 = x788.count1_143
val x793 = {
x791 + x792}
val x794 = new generated.scala.Anon46814458(x789,x793)
val x795: generated.scala.Anon46814458 = x794
val x1597 = x798.n_regionkey_116
val x810 = x795.n_regionkey_116
val x1598 = x798.n_regionkey_116(x797.toInt) = x810
val x1599 = x798.count1_143
val x813 = x795.count1_143
val x1600 = x798.count1_143(x797.toInt) = x813
}
}
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x1718,rhs:activation_x1718): Unit = {
// common key Block(Sym(10)) for x1718
if (__act.x1718_size == -1) __act.x1718_size = __act.x1718_hash_pos.size
if (rhs.x1718_size == -1) rhs.x1718_size = rhs.x1718_hash_pos.size
var x1718rhs_idx: Int = 0
while (x1718rhs_idx < rhs.x1718_hash_pos.size) {
val x1718_k: Int = rhs.x1718_hash_pos.unsafeKeys(x1718rhs_idx.toInt)
val x1718_sze: Int = __act.x1718_hash_pos.size
val x1718_idx: Int = __act.x1718_hash_pos.put(x1718_k)
if (x1718_idx == x1718_sze) { // new key
var x798: generated.scala.DeliteArrayAnon46814458 = rhs.x1718_hash_data
val x797: Int = x1718rhs_idx
val x1591 = x798.n_regionkey_116
val x1592 = x798.count1_143
val x1593 = x1591(x797.toInt)
val x1594 = x1592(x797.toInt)
val x1595 = new generated.scala.Anon46814458(x1593,x1594)
x798 = __act.x1718_hash_data
val x795: generated.scala.Anon46814458 = x1595
val x1604 = x1718_sze
val x1605 = x798.n_regionkey_116
val x1606 = x1605.length
val x1607 = x1606 - 1
val x1608 = x1604 > x1607
val x1628 = {
def x1628thenb(): Unit = {
val x1609 = x1606 < 16
val x1613 = {
def x1613thenb(): Int = {
16
}
def x1613elseb(): Int = {
val x1610 = x1606 * 2
val x1611 = x1610 < 0
val x1612 = {
def x1612thenb(): Int = {
2147483647
}
def x1612elseb(): Int = {
x1610
}
if (x1611) {
x1612thenb()
} else { 
x1612elseb()
}
}
x1612
}
if (x1609) {
x1613thenb()
} else { 
x1613elseb()
}
}
if (x1613 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1614 = new Array[Int](x1613.toInt)
if (x1613 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1615 = new Array[Int](x1613.toInt)
val x1616 = System.arraycopy(x1605,0.toInt,x1614,0.toInt,x1606.toInt)
val x1617 = x798.count1_143
val x1618 = System.arraycopy(x1617,0.toInt,x1615,0.toInt,x1606.toInt)
val x810 = x795.n_regionkey_116
val x1619 = x1614(x1604.toInt) = x810
val x813 = x795.count1_143
val x1620 = x1615(x1604.toInt) = x813
val x1621 = new generated.scala.DeliteArrayAnon46814458(x1614,x1615)
val x1622 = __act.x1718_hash_data = x1621
x1622
}
def x1628elseb(): Unit = {
val x810 = x795.n_regionkey_116
val x1624 = x798.n_regionkey_116(x1604.toInt) = x810
val x1625 = x798.count1_143
val x813 = x795.count1_143
val x1626 = x798.count1_143(x1604.toInt) = x813
()
}
if (x1608) {
x1628thenb()
} else { 
x1628elseb()
}
}
} else { // existing key
val x798: generated.scala.DeliteArrayAnon46814458 = rhs.x1718_hash_data
val x797: Int = x1718rhs_idx
val x1591 = x798.n_regionkey_116
val x1592 = x798.count1_143
val x1593 = x1591(x797.toInt)
val x1594 = x1592(x797.toInt)
val x1595 = new generated.scala.Anon46814458(x1593,x1594)
val x1718_v: generated.scala.Anon46814458 = x1595
val x1718_reduce_block: Unit = {
val x798: generated.scala.DeliteArrayAnon46814458 = __act.x1718_hash_data
val x797: Int = x1718_idx
val x1591 = x798.n_regionkey_116
val x1592 = x798.count1_143
val x1593 = x1591(x797.toInt)
val x1594 = x1592(x797.toInt)
val x1595 = new generated.scala.Anon46814458(x1593,x1594)
val x787: generated.scala.Anon46814458 = x1595
val x788: generated.scala.Anon46814458 = x1718_v
val x789 = x787.n_regionkey_116
val x791 = x787.count1_143
val x792 = x788.count1_143
val x793 = {
x791 + x792}
val x794 = new generated.scala.Anon46814458(x789,x793)
val x795: generated.scala.Anon46814458 = x794
val x1597 = x798.n_regionkey_116
val x810 = x795.n_regionkey_116
val x1598 = x798.n_regionkey_116(x797.toInt) = x810
val x1599 = x798.count1_143
val x813 = x795.count1_143
val x1600 = x798.count1_143(x797.toInt) = x813
}
}
x1718rhs_idx = x1718rhs_idx+1
}
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x1718,lhs:activation_x1718): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x1718): Unit = {
val tid: Int = resourceInfo.groupId
if (tid > 0) {
val all_acts: Array[activation_x1718] = new Array[activation_x1718](resourceInfo.groupSize)
var currentAct: activation_x1718 = __act
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

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x1718): Unit = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
if (__act.all_acts ne null) {
val all_acts: Array[activation_x1718] = __act.all_acts
val x1718_globalKeys: Array[Int] = __act.all_acts(0).x1718_hash_pos.unsafeKeys
var x1718_idx: Int = ((__act.all_acts(0).x1718_hash_pos.size).asInstanceOf[Long] * tid / numThreads).asInstanceOf[Int]
val x1718_end: Int = ((__act.all_acts(0).x1718_hash_pos.size).asInstanceOf[Long] * (tid+1) / numThreads).asInstanceOf[Int]
while (x1718_idx < x1718_end) {
x1718_idx = x1718_idx + 1
}
}
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x1718): Unit = {
val x1718_sze: Int = __act.x1718_hash_pos.size
var x798: generated.scala.DeliteArrayAnon46814458 = __act.x1718_hash_data
val x796: Int = x1718_sze
val x1630 = x798.n_regionkey_116
val x1631 = x1630.length
val x1632 = x1631 > x796
val x1641 = {
def x1641thenb(): Unit = {
if (x796 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1633 = new Array[Int](x796.toInt)
if (x796 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x1634 = new Array[Int](x796.toInt)
val x1635 = System.arraycopy(x1630,0.toInt,x1633,0.toInt,x796.toInt)
val x1636 = x798.count1_143
val x1637 = System.arraycopy(x1636,0.toInt,x1634,0.toInt,x796.toInt)
val x1638 = new generated.scala.DeliteArrayAnon46814458(x1633,x1634)
val x1639 = x798 = x1638
x1639
}
if (x1632) {
x1641thenb()
}
}
__act.x1718 = x798
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x1718 = {
val act: activation_x1718 = new activation_x1718
act.x1718_hash_pos = new generated.scala.container.HashMapImpl[Int](512,128)
act
}

}
x1718_closure.loopStart = 0
x1718_closure.loopSize = x2
val alloc: activation_x1718 = x1718_closure.alloc(resourceInfo)
var x1718: activation_x1718 = null
if (resourceInfo.availableThreads <= 1) {
x1718 = x1718_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x1718] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x1718](x1718_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x1718_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x1718 = x1718_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x1718
}}

/**********/


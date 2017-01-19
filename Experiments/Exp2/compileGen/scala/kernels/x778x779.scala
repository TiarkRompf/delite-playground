package generated.scala
//activation record for fat loop
final class activation_x778x779 {
var left_act: activation_x778x779 = _
var x778: Array[Int] = _
var x778_data: Array[Int] = _
var x778_buf: Array[Int] = _
var x778_size: Int = _
var x778_offset: Int = _
var x778_conditionals: Int = _
def x778_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Int],cs:Int): Unit = {
x778_data = xs
x778_conditionals = cs
if (left_act ne null)
left_act.x778_data_set(resourceInfo,xs,cs)
}

var x779: Array[java.lang.String] = _
var x779_data: Array[java.lang.String] = _
var x779_buf: Array[java.lang.String] = _
var x779_size: Int = _
var x779_offset: Int = _
var x779_conditionals: Int = _
def x779_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[java.lang.String],cs:Int): Unit = {
x779_data = xs
x779_conditionals = cs
if (left_act ne null)
left_act.x779_data_set(resourceInfo,xs,cs)
}

}
object activation_x778x779 {
}
object kernel_x778x779 {
def apply(resourceInfo:generated.scala.ResourceInfo,x3:Long,x2:generated.scala.io.DeliteFileInputStream): activation_x778x779 = {
val x778x779_closure = new generated.scala.DeliteOpMultiLoop[activation_x778x779] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x3
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x778x779 = {
val __act: activation_x778x779 = new activation_x778x779()
// __act.x778 stays null for now
// __act.x779 stays null for now
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x778x779,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x778x779]): activation_x778x779 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x778x779 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x778x779 = sync.get(localStart)
//post combine
if (tid != 0) postCombine(resourceInfo,act,sync.getP(tid-1))
var j: Int = localStart+1
var currentAct: activation_x778x779 = act
while (j < localEnd) {
val rhsAct: activation_x778x779 = sync.get(j)
postCombine(resourceInfo,rhsAct,currentAct)
currentAct = rhsAct
j = j+1
}
if (tid == numThreads-1) postProcInit(resourceInfo,currentAct)
sync.setP(tid, currentAct)
sync.awaitBarrier
//post process
var k: Int = localStart
while (k < localEnd) {
postProcess(resourceInfo,sync.get(k))
k = k+1
}
sync.awaitBarrier
if (tid == 0) {
finalize(resourceInfo,act)
}
act
}

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x778x779): activation_x778x779 = {
val act: activation_x778x779 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
postProcInit(resourceInfo,act)
postProcess(resourceInfo,act)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x778x779,start:Long,end:Long): activation_x778x779 = {
val x2_stream: generated.scala.io.DeliteFileInputStream = x2.openCopyAtNewLine(start)
val x2_stream_offset: Long = x2_stream.streamOffset
val isEmpty: Boolean = end <= x2_stream.position
val __act2: activation_x778x779 = init(resourceInfo,__act,-1,isEmpty,x2_stream)
while (x2_stream.position < x2_stream_offset + end) {
process(resourceInfo,__act2,-1,x2_stream)
}
x2_stream.close();
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x778x779,x4:Int,isEmpty:Boolean,x2_stream:generated.scala.io.DeliteFileInputStream): activation_x778x779 = {
val __act2: activation_x778x779 = new activation_x778x779()
val x581 = 0
if (x581 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x585 = new Array[Int](x581.toInt)
__act2.x778_buf = x585
val x624 = 0
if (x624 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x628 = new Array[java.lang.String](x624.toInt)
__act2.x779_buf = x628
if (!isEmpty) {
val x5 = x2_stream.readLine()
val x6 = x5.split("\\|", -1)
val x7 = x6(0.toInt)
val x8 = {
x7.toInt}
val x9 = x6(1.toInt)
val x10 = x6(2.toInt)
val x11 = {
x10.toInt}
val x768 = {
x11 > 1337}
if (x768) {
val x579 = __act2.x778_buf
val x580 = x8
if (true) {
val x591 = __act2.x778_size
val x592 = x579.length
val x593 = x592 - 1
val x594 = x591 > x593
val x607 = {
def x607thenb(): Unit = {
val x595 = x592 < 16
val x599 = {
def x599thenb(): Int = {
16
}
def x599elseb(): Int = {
val x596 = x592 * 2
val x597 = x596 < 0
val x598 = {
def x598thenb(): Int = {
2147483647
}
def x598elseb(): Int = {
x596
}
if (x597) {
x598thenb()
} else { 
x598elseb()
}
}
x598
}
if (x595) {
x599thenb()
} else { 
x599elseb()
}
}
if (x599 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x600 = new Array[Int](x599.toInt)
val x601 = System.arraycopy(x579,0.toInt,x600,0.toInt,x592.toInt)
val x602 = x600(x591.toInt) = x580
val x603 = __act2.x778_buf = x600
x603
}
def x607elseb(): Unit = {
val x605 = x579(x591.toInt) = x580
x605
}
if (x594) {
x607thenb()
} else { 
x607elseb()
}
}
__act2.x778_size = __act2.x778_size + 1
}
__act2.x778_conditionals = __act2.x778_conditionals + 1
}
if (x768) {
val x622 = __act2.x779_buf
val x623 = x9
if (true) {
val x634 = __act2.x779_size
val x635 = x622.length
val x636 = x635 - 1
val x637 = x634 > x636
val x650 = {
def x650thenb(): Unit = {
val x638 = x635 < 16
val x642 = {
def x642thenb(): Int = {
16
}
def x642elseb(): Int = {
val x639 = x635 * 2
val x640 = x639 < 0
val x641 = {
def x641thenb(): Int = {
2147483647
}
def x641elseb(): Int = {
x639
}
if (x640) {
x641thenb()
} else { 
x641elseb()
}
}
x641
}
if (x638) {
x642thenb()
} else { 
x642elseb()
}
}
if (x642 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x643 = new Array[java.lang.String](x642.toInt)
val x644 = System.arraycopy(x622,0.toInt,x643,0.toInt,x635.toInt)
val x645 = x643(x634.toInt) = x623
val x646 = __act2.x779_buf = x643
x646
}
def x650elseb(): Unit = {
val x648 = x622(x634.toInt) = x623
x648
}
if (x637) {
x650thenb()
} else { 
x650elseb()
}
}
__act2.x779_size = __act2.x779_size + 1
}
__act2.x779_conditionals = __act2.x779_conditionals + 1
}
}
__act2
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x778x779,x4:Int,x2_stream:generated.scala.io.DeliteFileInputStream): Unit = {
val x5 = x2_stream.readLine()
val x6 = x5.split("\\|", -1)
val x7 = x6(0.toInt)
val x8 = {
x7.toInt}
val x9 = x6(1.toInt)
val x10 = x6(2.toInt)
val x11 = {
x10.toInt}
val x768 = {
x11 > 1337}
if (x768) {
val x579 = __act.x778_buf
val x580 = x8
if (true) {
val x591 = __act.x778_size
val x592 = x579.length
val x593 = x592 - 1
val x594 = x591 > x593
val x607 = {
def x607thenb(): Unit = {
val x595 = x592 < 16
val x599 = {
def x599thenb(): Int = {
16
}
def x599elseb(): Int = {
val x596 = x592 * 2
val x597 = x596 < 0
val x598 = {
def x598thenb(): Int = {
2147483647
}
def x598elseb(): Int = {
x596
}
if (x597) {
x598thenb()
} else { 
x598elseb()
}
}
x598
}
if (x595) {
x599thenb()
} else { 
x599elseb()
}
}
if (x599 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x600 = new Array[Int](x599.toInt)
val x601 = System.arraycopy(x579,0.toInt,x600,0.toInt,x592.toInt)
val x602 = x600(x591.toInt) = x580
val x603 = __act.x778_buf = x600
x603
}
def x607elseb(): Unit = {
val x605 = x579(x591.toInt) = x580
x605
}
if (x594) {
x607thenb()
} else { 
x607elseb()
}
}
__act.x778_size = __act.x778_size + 1
}
__act.x778_conditionals = __act.x778_conditionals + 1
}
if (x768) {
val x622 = __act.x779_buf
val x623 = x9
if (true) {
val x634 = __act.x779_size
val x635 = x622.length
val x636 = x635 - 1
val x637 = x634 > x636
val x650 = {
def x650thenb(): Unit = {
val x638 = x635 < 16
val x642 = {
def x642thenb(): Int = {
16
}
def x642elseb(): Int = {
val x639 = x635 * 2
val x640 = x639 < 0
val x641 = {
def x641thenb(): Int = {
2147483647
}
def x641elseb(): Int = {
x639
}
if (x640) {
x641thenb()
} else { 
x641elseb()
}
}
x641
}
if (x638) {
x642thenb()
} else { 
x642elseb()
}
}
if (x642 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x643 = new Array[java.lang.String](x642.toInt)
val x644 = System.arraycopy(x622,0.toInt,x643,0.toInt,x635.toInt)
val x645 = x643(x634.toInt) = x623
val x646 = __act.x779_buf = x643
x646
}
def x650elseb(): Unit = {
val x648 = x622(x634.toInt) = x623
x648
}
if (x637) {
x650thenb()
} else { 
x650elseb()
}
}
__act.x779_size = __act.x779_size + 1
}
__act.x779_conditionals = __act.x779_conditionals + 1
}
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x778x779,rhs:activation_x778x779): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x778x779,lhs:activation_x778x779): Unit = {
__act.x778_offset = lhs.x778_offset+lhs.x778_size
__act.x778_conditionals = __act.x778_conditionals+lhs.x778_conditionals
__act.x779_offset = lhs.x779_offset+lhs.x779_size
__act.x779_conditionals = __act.x779_conditionals+lhs.x779_conditionals
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x778x779): Unit = {
if (__act.x778_offset > 0) {
val x581 = __act.x778_offset + __act.x778_size
val x579 = __act.x778_buf
if (x581 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x617 = new Array[Int](x581.toInt)
__act.x778_data_set(resourceInfo,x617,__act.x778_conditionals)
} else {
__act.x778_data_set(resourceInfo,__act.x778_buf,__act.x778_conditionals)
}
if (__act.x779_offset > 0) {
val x624 = __act.x779_offset + __act.x779_size
val x622 = __act.x779_buf
if (x624 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x660 = new Array[java.lang.String](x624.toInt)
__act.x779_data_set(resourceInfo,x660,__act.x779_conditionals)
} else {
__act.x779_data_set(resourceInfo,__act.x779_buf,__act.x779_conditionals)
}
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x778x779): Unit = {
if (__act.x778_data ne __act.x778_buf) {
val x581 = __act.x778_size
val x582 = __act.x778_buf
val x579 = __act.x778_data
val x583 = 0
val x584 = __act.x778_offset
val x619 = System.arraycopy(x582,x583.toInt,x579,x584.toInt,x581.toInt)
}
__act.x778_buf = null
if (__act.x779_data ne __act.x779_buf) {
val x624 = __act.x779_size
val x625 = __act.x779_buf
val x622 = __act.x779_data
val x626 = 0
val x627 = __act.x779_offset
val x662 = System.arraycopy(x625,x626.toInt,x622,x627.toInt,x624.toInt)
}
__act.x779_buf = null
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x778x779): Unit = {
var x579: Array[Int] = __act.x778_data
__act.x778_data = null
val x581 = __act.x778_conditionals
val x609 = x579.length
val x610 = x609 > x581
val x615 = {
def x615thenb(): Unit = {
if (x581 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x611 = new Array[Int](x581.toInt)
val x612 = System.arraycopy(x579,0.toInt,x611,0.toInt,x581.toInt)
val x613 = x579 = x611
x613
}
if (x610) {
x615thenb()
}
}
__act.x778 = x579
var x622: Array[java.lang.String] = __act.x779_data
__act.x779_data = null
val x624 = __act.x779_conditionals
val x652 = x622.length
val x653 = x652 > x624
val x658 = {
def x658thenb(): Unit = {
if (x624 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x654 = new Array[java.lang.String](x624.toInt)
val x655 = System.arraycopy(x622,0.toInt,x654,0.toInt,x624.toInt)
val x656 = x622 = x654
x656
}
if (x653) {
x658thenb()
}
}
__act.x779 = x622
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x778x779 = {
val act: activation_x778x779 = new activation_x778x779
act
}

}
x778x779_closure.loopStart = 0
x778x779_closure.loopSize = x3
val alloc: activation_x778x779 = x778x779_closure.alloc(resourceInfo)
var x778x779: activation_x778x779 = null
if (resourceInfo.availableThreads <= 1) {
x778x779 = x778x779_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x778x779] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x778x779](x778x779_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x778x779_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x778x779 = x778x779_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x778x779
}}

/**********/


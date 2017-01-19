package generated.scala
//activation record for fat loop
final class activation_x776x777 {
var left_act: activation_x776x777 = _
var x776: Array[Int] = _
var x776_data: Array[Int] = _
var x776_buf: Array[Int] = _
var x776_size: Int = _
var x776_offset: Int = _
var x776_conditionals: Int = _
def x776_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Int],cs:Int): Unit = {
x776_data = xs
x776_conditionals = cs
if (left_act ne null)
left_act.x776_data_set(resourceInfo,xs,cs)
}

var x777: Array[java.lang.String] = _
var x777_data: Array[java.lang.String] = _
var x777_buf: Array[java.lang.String] = _
var x777_size: Int = _
var x777_offset: Int = _
var x777_conditionals: Int = _
def x777_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[java.lang.String],cs:Int): Unit = {
x777_data = xs
x777_conditionals = cs
if (left_act ne null)
left_act.x777_data_set(resourceInfo,xs,cs)
}

}
object activation_x776x777 {
}
object kernel_x776x777 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2:Long,x1:generated.scala.io.DeliteFileInputStream): activation_x776x777 = {
val x776x777_closure = new generated.scala.DeliteOpMultiLoop[activation_x776x777] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x2
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x776x777 = {
val __act: activation_x776x777 = new activation_x776x777()
// __act.x776 stays null for now
// __act.x777 stays null for now
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x776x777,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x776x777]): activation_x776x777 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x776x777 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x776x777 = sync.get(localStart)
//post combine
if (tid != 0) postCombine(resourceInfo,act,sync.getP(tid-1))
var j: Int = localStart+1
var currentAct: activation_x776x777 = act
while (j < localEnd) {
val rhsAct: activation_x776x777 = sync.get(j)
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

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x776x777): activation_x776x777 = {
val act: activation_x776x777 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
postProcInit(resourceInfo,act)
postProcess(resourceInfo,act)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x776x777,start:Long,end:Long): activation_x776x777 = {
val x1_stream: generated.scala.io.DeliteFileInputStream = x1.openCopyAtNewLine(start)
val x1_stream_offset: Long = x1_stream.streamOffset
val isEmpty: Boolean = end <= x1_stream.position
val __act2: activation_x776x777 = init(resourceInfo,__act,-1,isEmpty,x1_stream)
while (x1_stream.position < x1_stream_offset + end) {
process(resourceInfo,__act2,-1,x1_stream)
}
x1_stream.close();
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x776x777,x3:Int,isEmpty:Boolean,x1_stream:generated.scala.io.DeliteFileInputStream): activation_x776x777 = {
val __act2: activation_x776x777 = new activation_x776x777()
val x579 = 0
if (x579 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x583 = new Array[Int](x579.toInt)
__act2.x776_buf = x583
val x622 = 0
if (x622 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x626 = new Array[java.lang.String](x622.toInt)
__act2.x777_buf = x626
if (!isEmpty) {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
val x6 = x5(0.toInt)
val x7 = {
x6.toInt}
val x8 = x5(1.toInt)
val x9 = x5(2.toInt)
val x10 = {
x9.toInt}
val x766 = {
x10 > 1337}
if (x766) {
val x577 = __act2.x776_buf
val x578 = x7
if (true) {
val x589 = __act2.x776_size
val x590 = x577.length
val x591 = x590 - 1
val x592 = x589 > x591
val x605 = {
def x605thenb(): Unit = {
val x593 = x590 < 16
val x597 = {
def x597thenb(): Int = {
16
}
def x597elseb(): Int = {
val x594 = x590 * 2
val x595 = x594 < 0
val x596 = {
def x596thenb(): Int = {
2147483647
}
def x596elseb(): Int = {
x594
}
if (x595) {
x596thenb()
} else { 
x596elseb()
}
}
x596
}
if (x593) {
x597thenb()
} else { 
x597elseb()
}
}
if (x597 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x598 = new Array[Int](x597.toInt)
val x599 = System.arraycopy(x577,0.toInt,x598,0.toInt,x590.toInt)
val x600 = x598(x589.toInt) = x578
val x601 = __act2.x776_buf = x598
x601
}
def x605elseb(): Unit = {
val x603 = x577(x589.toInt) = x578
x603
}
if (x592) {
x605thenb()
} else { 
x605elseb()
}
}
__act2.x776_size = __act2.x776_size + 1
}
__act2.x776_conditionals = __act2.x776_conditionals + 1
}
if (x766) {
val x620 = __act2.x777_buf
val x621 = x8
if (true) {
val x632 = __act2.x777_size
val x633 = x620.length
val x634 = x633 - 1
val x635 = x632 > x634
val x648 = {
def x648thenb(): Unit = {
val x636 = x633 < 16
val x640 = {
def x640thenb(): Int = {
16
}
def x640elseb(): Int = {
val x637 = x633 * 2
val x638 = x637 < 0
val x639 = {
def x639thenb(): Int = {
2147483647
}
def x639elseb(): Int = {
x637
}
if (x638) {
x639thenb()
} else { 
x639elseb()
}
}
x639
}
if (x636) {
x640thenb()
} else { 
x640elseb()
}
}
if (x640 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x641 = new Array[java.lang.String](x640.toInt)
val x642 = System.arraycopy(x620,0.toInt,x641,0.toInt,x633.toInt)
val x643 = x641(x632.toInt) = x621
val x644 = __act2.x777_buf = x641
x644
}
def x648elseb(): Unit = {
val x646 = x620(x632.toInt) = x621
x646
}
if (x635) {
x648thenb()
} else { 
x648elseb()
}
}
__act2.x777_size = __act2.x777_size + 1
}
__act2.x777_conditionals = __act2.x777_conditionals + 1
}
}
__act2
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x776x777,x3:Int,x1_stream:generated.scala.io.DeliteFileInputStream): Unit = {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
val x6 = x5(0.toInt)
val x7 = {
x6.toInt}
val x8 = x5(1.toInt)
val x9 = x5(2.toInt)
val x10 = {
x9.toInt}
val x766 = {
x10 > 1337}
if (x766) {
val x577 = __act.x776_buf
val x578 = x7
if (true) {
val x589 = __act.x776_size
val x590 = x577.length
val x591 = x590 - 1
val x592 = x589 > x591
val x605 = {
def x605thenb(): Unit = {
val x593 = x590 < 16
val x597 = {
def x597thenb(): Int = {
16
}
def x597elseb(): Int = {
val x594 = x590 * 2
val x595 = x594 < 0
val x596 = {
def x596thenb(): Int = {
2147483647
}
def x596elseb(): Int = {
x594
}
if (x595) {
x596thenb()
} else { 
x596elseb()
}
}
x596
}
if (x593) {
x597thenb()
} else { 
x597elseb()
}
}
if (x597 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x598 = new Array[Int](x597.toInt)
val x599 = System.arraycopy(x577,0.toInt,x598,0.toInt,x590.toInt)
val x600 = x598(x589.toInt) = x578
val x601 = __act.x776_buf = x598
x601
}
def x605elseb(): Unit = {
val x603 = x577(x589.toInt) = x578
x603
}
if (x592) {
x605thenb()
} else { 
x605elseb()
}
}
__act.x776_size = __act.x776_size + 1
}
__act.x776_conditionals = __act.x776_conditionals + 1
}
if (x766) {
val x620 = __act.x777_buf
val x621 = x8
if (true) {
val x632 = __act.x777_size
val x633 = x620.length
val x634 = x633 - 1
val x635 = x632 > x634
val x648 = {
def x648thenb(): Unit = {
val x636 = x633 < 16
val x640 = {
def x640thenb(): Int = {
16
}
def x640elseb(): Int = {
val x637 = x633 * 2
val x638 = x637 < 0
val x639 = {
def x639thenb(): Int = {
2147483647
}
def x639elseb(): Int = {
x637
}
if (x638) {
x639thenb()
} else { 
x639elseb()
}
}
x639
}
if (x636) {
x640thenb()
} else { 
x640elseb()
}
}
if (x640 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x641 = new Array[java.lang.String](x640.toInt)
val x642 = System.arraycopy(x620,0.toInt,x641,0.toInt,x633.toInt)
val x643 = x641(x632.toInt) = x621
val x644 = __act.x777_buf = x641
x644
}
def x648elseb(): Unit = {
val x646 = x620(x632.toInt) = x621
x646
}
if (x635) {
x648thenb()
} else { 
x648elseb()
}
}
__act.x777_size = __act.x777_size + 1
}
__act.x777_conditionals = __act.x777_conditionals + 1
}
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x776x777,rhs:activation_x776x777): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x776x777,lhs:activation_x776x777): Unit = {
__act.x776_offset = lhs.x776_offset+lhs.x776_size
__act.x776_conditionals = __act.x776_conditionals+lhs.x776_conditionals
__act.x777_offset = lhs.x777_offset+lhs.x777_size
__act.x777_conditionals = __act.x777_conditionals+lhs.x777_conditionals
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x776x777): Unit = {
if (__act.x776_offset > 0) {
val x579 = __act.x776_offset + __act.x776_size
val x577 = __act.x776_buf
if (x579 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x615 = new Array[Int](x579.toInt)
__act.x776_data_set(resourceInfo,x615,__act.x776_conditionals)
} else {
__act.x776_data_set(resourceInfo,__act.x776_buf,__act.x776_conditionals)
}
if (__act.x777_offset > 0) {
val x622 = __act.x777_offset + __act.x777_size
val x620 = __act.x777_buf
if (x622 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x658 = new Array[java.lang.String](x622.toInt)
__act.x777_data_set(resourceInfo,x658,__act.x777_conditionals)
} else {
__act.x777_data_set(resourceInfo,__act.x777_buf,__act.x777_conditionals)
}
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x776x777): Unit = {
if (__act.x776_data ne __act.x776_buf) {
val x579 = __act.x776_size
val x580 = __act.x776_buf
val x577 = __act.x776_data
val x581 = 0
val x582 = __act.x776_offset
val x617 = System.arraycopy(x580,x581.toInt,x577,x582.toInt,x579.toInt)
}
__act.x776_buf = null
if (__act.x777_data ne __act.x777_buf) {
val x622 = __act.x777_size
val x623 = __act.x777_buf
val x620 = __act.x777_data
val x624 = 0
val x625 = __act.x777_offset
val x660 = System.arraycopy(x623,x624.toInt,x620,x625.toInt,x622.toInt)
}
__act.x777_buf = null
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x776x777): Unit = {
var x577: Array[Int] = __act.x776_data
__act.x776_data = null
val x579 = __act.x776_conditionals
val x607 = x577.length
val x608 = x607 > x579
val x613 = {
def x613thenb(): Unit = {
if (x579 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x609 = new Array[Int](x579.toInt)
val x610 = System.arraycopy(x577,0.toInt,x609,0.toInt,x579.toInt)
val x611 = x577 = x609
x611
}
if (x608) {
x613thenb()
}
}
__act.x776 = x577
var x620: Array[java.lang.String] = __act.x777_data
__act.x777_data = null
val x622 = __act.x777_conditionals
val x650 = x620.length
val x651 = x650 > x622
val x656 = {
def x656thenb(): Unit = {
if (x622 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x652 = new Array[java.lang.String](x622.toInt)
val x653 = System.arraycopy(x620,0.toInt,x652,0.toInt,x622.toInt)
val x654 = x620 = x652
x654
}
if (x651) {
x656thenb()
}
}
__act.x777 = x620
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x776x777 = {
val act: activation_x776x777 = new activation_x776x777
act
}

}
x776x777_closure.loopStart = 0
x776x777_closure.loopSize = x2
val alloc: activation_x776x777 = x776x777_closure.alloc(resourceInfo)
var x776x777: activation_x776x777 = null
if (resourceInfo.availableThreads <= 1) {
x776x777 = x776x777_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x776x777] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x776x777](x776x777_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x776x777_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x776x777 = x776x777_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x776x777
}}

/**********/


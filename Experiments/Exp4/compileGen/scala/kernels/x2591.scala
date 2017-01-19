package generated.scala
//activation record for fat loop
final class activation_x2591 {
var left_act: activation_x2591 = _
var x2591: Double = _
var x2591_zero: Double = _
}
object activation_x2591 {
}
object kernel_x2591 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2:Long,x1:generated.scala.io.DeliteFileInputStream,x414:Int,x417:Int): activation_x2591 = {
val x2591_closure = new generated.scala.DeliteOpMultiLoop[activation_x2591] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x2
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x2591 = {
val __act: activation_x2591 = new activation_x2591()
__act.x2591_zero = 0.0
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2591,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x2591]): activation_x2591 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x2591 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x2591 = sync.get(localStart)
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

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2591): activation_x2591 = {
val act: activation_x2591 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2591,start:Long,end:Long): activation_x2591 = {
val x1_stream: generated.scala.io.DeliteFileInputStream = x1.openCopyAtNewLine(start)
val x1_stream_offset: Long = x1_stream.streamOffset
val isEmpty: Boolean = end <= x1_stream.position
val __act2: activation_x2591 = init(resourceInfo,__act,-1,isEmpty,x1_stream)
while (x1_stream.position < x1_stream_offset + end) {
process(resourceInfo,__act2,-1,x1_stream)
}
x1_stream.close();
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2591,x3:Int,isEmpty:Boolean,x1_stream:generated.scala.io.DeliteFileInputStream): activation_x2591 = {
val __act2: activation_x2591 = new activation_x2591()
__act2.x2591_zero = __act.x2591_zero
if (isEmpty) // stripping the first iter: only initialize to zero if empty
__act2.x2591 = __act2.x2591_zero
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
val x2537 = {
x36 >= x414}
val x2538 = {
x36 < x417}
val x2539 = {
x2537 && x2538}
val x18 = x5(6.toInt)
val x19 = {
x18.toDouble}
val x2540 = {
x19 >= 0.05}
val x2541 = {
x2539 && x2540}
val x2542 = {
x19 <= 0.07}
val x2543 = {
x2541 && x2542}
val x14 = x5(4.toInt)
val x15 = {
x14.toDouble}
val x2544 = {
x15 < 24.0}
val x2545 = {
x2543 && x2544}
val x16 = x5(5.toInt)
val x17 = {
x16.toDouble}
val x2582 = {
x17 * x19}
if (x2545) {
__act2.x2591 = x2582
} else {
__act2.x2591 = __act2.x2591_zero
}
}
__act2
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2591,x3:Int,x1_stream:generated.scala.io.DeliteFileInputStream): Unit = {
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
val x2537 = {
x36 >= x414}
val x2538 = {
x36 < x417}
val x2539 = {
x2537 && x2538}
val x18 = x5(6.toInt)
val x19 = {
x18.toDouble}
val x2540 = {
x19 >= 0.05}
val x2541 = {
x2539 && x2540}
val x2542 = {
x19 <= 0.07}
val x2543 = {
x2541 && x2542}
val x14 = x5(4.toInt)
val x15 = {
x14.toDouble}
val x2544 = {
x15 < 24.0}
val x2545 = {
x2543 && x2544}
val x16 = x5(5.toInt)
val x17 = {
x16.toDouble}
val x2582 = {
x17 * x19}
if (x2545) {
// TODO: we could optimize this check away with more convoluted runtime support if necessary
if (__act.x2591 == __act.x2591_zero) 
__act.x2591 = x2582
else {
val x938 = __act.x2591
val x939 = x2582
val x940 = {
x938 + x939}
__act.x2591 = x940
}
}
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2591,rhs:activation_x2591): Unit = {
val x938 = __act.x2591
val x939 = rhs.x2591
if (x938 == __act.x2591_zero) {
__act.x2591 = x939
}
else if (x939 != __act.x2591_zero) {
val x940 = {
x938 + x939}
__act.x2591 = x940
}
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2591,lhs:activation_x2591): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2591): Unit = {
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2591): Unit = {
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2591): Unit = {
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x2591 = {
val act: activation_x2591 = new activation_x2591
act.x2591_zero = 0.0
act
}

}
x2591_closure.loopStart = 0
x2591_closure.loopSize = x2
val alloc: activation_x2591 = x2591_closure.alloc(resourceInfo)
var x2591: activation_x2591 = null
if (resourceInfo.availableThreads <= 1) {
x2591 = x2591_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x2591] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x2591](x2591_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x2591_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x2591 = x2591_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x2591
}}

/**********/


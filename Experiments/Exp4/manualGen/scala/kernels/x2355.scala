package generated.scala
//activation record for fat loop
final class activation_x2355 {
var left_act: activation_x2355 = _
var x2355: Double = _
var x2355_zero: Double = _
}
object activation_x2355 {
}
object kernel_x2355 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2:Long,x1:generated.scala.io.DeliteFileInputStream,x424:Int,x437:Int): activation_x2355 = {
val x2355_closure = new generated.scala.DeliteOpMultiLoop[activation_x2355] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x2
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x2355 = {
val __act: activation_x2355 = new activation_x2355()
__act.x2355_zero = 0.0
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2355,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x2355]): activation_x2355 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x2355 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x2355 = sync.get(localStart)
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

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2355): activation_x2355 = {
val act: activation_x2355 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2355,start:Long,end:Long): activation_x2355 = {
val x1_stream: generated.scala.io.DeliteFileInputStream = x1.openCopyAtNewLine(start)
val x1_stream_offset: Long = x1_stream.streamOffset
val isEmpty: Boolean = end <= x1_stream.position
val __act2: activation_x2355 = init(resourceInfo,__act,-1,isEmpty,x1_stream)
while (x1_stream.position < x1_stream_offset + end) {
process(resourceInfo,__act2,-1,x1_stream)
}
x1_stream.close();
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2355,x3:Int,isEmpty:Boolean,x1_stream:generated.scala.io.DeliteFileInputStream): activation_x2355 = {
val __act2: activation_x2355 = new activation_x2355()
__act2.x2355_zero = __act.x2355_zero
if (isEmpty) // stripping the first iter: only initialize to zero if empty
__act2.x2355 = __act2.x2355_zero
if (!isEmpty) {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
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
val x2319 = {
x38 >= x424}
val x2320 = {
x38 < x437}
val x2321 = {
x2319 && x2320}
val x18 = x5(6.toInt)
val x19 = {
x18.toDouble}
val x2322 = {
x19 >= 0.05}
val x2323 = {
x2321 && x2322}
val x2324 = {
x19 <= 0.07}
val x2325 = {
x2323 && x2324}
val x14 = x5(4.toInt)
val x15 = {
x14.toDouble}
val x2326 = {
x15 < 24.0}
val x2327 = {
x2325 && x2326}
val x16 = x5(5.toInt)
val x17 = {
x16.toDouble}
val x2352 = {
x17 * x19}
if (x2327) {
__act2.x2355 = x2352
} else {
__act2.x2355 = __act2.x2355_zero
}
}
__act2
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2355,x3:Int,x1_stream:generated.scala.io.DeliteFileInputStream): Unit = {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
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
val x2319 = {
x38 >= x424}
val x2320 = {
x38 < x437}
val x2321 = {
x2319 && x2320}
val x18 = x5(6.toInt)
val x19 = {
x18.toDouble}
val x2322 = {
x19 >= 0.05}
val x2323 = {
x2321 && x2322}
val x2324 = {
x19 <= 0.07}
val x2325 = {
x2323 && x2324}
val x14 = x5(4.toInt)
val x15 = {
x14.toDouble}
val x2326 = {
x15 < 24.0}
val x2327 = {
x2325 && x2326}
val x16 = x5(5.toInt)
val x17 = {
x16.toDouble}
val x2352 = {
x17 * x19}
if (x2327) {
// TODO: we could optimize this check away with more convoluted runtime support if necessary
if (__act.x2355 == __act.x2355_zero) 
__act.x2355 = x2352
else {
val x843 = __act.x2355
val x844 = x2352
val x845 = {
x843 + x844}
__act.x2355 = x845
}
}
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2355,rhs:activation_x2355): Unit = {
val x843 = __act.x2355
val x844 = rhs.x2355
if (x843 == __act.x2355_zero) {
__act.x2355 = x844
}
else if (x844 != __act.x2355_zero) {
val x845 = {
x843 + x844}
__act.x2355 = x845
}
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2355,lhs:activation_x2355): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2355): Unit = {
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2355): Unit = {
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2355): Unit = {
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x2355 = {
val act: activation_x2355 = new activation_x2355
act.x2355_zero = 0.0
act
}

}
x2355_closure.loopStart = 0
x2355_closure.loopSize = x2
val alloc: activation_x2355 = x2355_closure.alloc(resourceInfo)
var x2355: activation_x2355 = null
if (resourceInfo.availableThreads <= 1) {
x2355 = x2355_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x2355] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x2355](x2355_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x2355_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x2355 = x2355_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x2355
}}

/**********/


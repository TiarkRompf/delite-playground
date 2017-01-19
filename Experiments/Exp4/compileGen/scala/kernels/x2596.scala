package generated.scala
//activation record for thin loop
final class activation_x2596 {
var left_act: activation_x2596 = _
var x2596: generated.scala.DeliteArrayAnon719361767 = _
var x2596_data: generated.scala.DeliteArrayAnon719361767 = _
}
object activation_x2596 {
}
object kernel_x2596 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2594:Int,x2593:Array[generated.scala.Anon719361767]): activation_x2596 = {
// a *thin* loop follows: x2596
val x2596_closure = new generated.scala.DeliteOpMultiLoop[activation_x2596] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x2594
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x2596 = {
val __act: activation_x2596 = new activation_x2596()
val x949 = (loopSize).asInstanceOf[Int]
if (x949 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2486 = new Array[Double](x949.toInt)
val x2487 = new generated.scala.DeliteArrayAnon719361767(x2486)
__act.x2596_data = x2487
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2596,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x2596]): activation_x2596 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x2596 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x2596 = sync.get(localStart)
sync.awaitBarrier
if (tid == 0) {
finalize(resourceInfo,act)
}
act
}

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2596): activation_x2596 = {
val act: activation_x2596 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2596,start:Long,end:Long): activation_x2596 = {
val isEmpty: Boolean = end-start <= 0
var idx: Int = (start).asInstanceOf[Int]
val __act2: activation_x2596 = init(resourceInfo,__act,idx,isEmpty)
idx = idx + 1
while (idx < end) {
process(resourceInfo,__act2,idx)
idx = idx + 1
}
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2596,x945:Int,isEmpty:Boolean): activation_x2596 = {
if (!isEmpty) {
process(resourceInfo,__act,x945)
}
__act
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2596,x945:Int): Unit = {
val x2595 = x2593(x945.toInt)
val x948 = x2595
val x947 = __act.x2596_data
val x2491 = x947.revenue_138
val x959 = x948.revenue_138
val x2492 = x947.revenue_138(x945.toInt) = x959
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2596,rhs:activation_x2596): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2596,lhs:activation_x2596): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2596): Unit = {
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2596): Unit = {
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2596): Unit = {
var x947: generated.scala.DeliteArrayAnon719361767 = __act.x2596_data
__act.x2596_data = null
__act.x2596 = x947
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x2596 = {
val act: activation_x2596 = new activation_x2596
act
}

}
x2596_closure.loopStart = 0
x2596_closure.loopSize = x2594
val alloc: activation_x2596 = x2596_closure.alloc(resourceInfo)
var x2596: activation_x2596 = null
if (resourceInfo.availableThreads <= 1) {
x2596 = x2596_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x2596] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x2596](x2596_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x2596_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x2596 = x2596_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x2596
}}

/**********/


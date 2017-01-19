package generated.scala
//activation record for fat loop
final class activation_x5624x5625x5626 {
var left_act: activation_x5624x5625x5626 = _
var x5624: Array[Double] = _
var x5624_data: Array[Double] = _
var x5625: Array[Double] = _
var x5625_data: Array[Double] = _
var x5626: Array[Double] = _
var x5626_data: Array[Double] = _
}
object activation_x5624x5625x5626 {
}
object kernel_x5624x5625x5626 {
def apply(resourceInfo:generated.scala.ResourceInfo,x5585:Int,x5613:Array[Double],x5615:Array[Int],x5618:Array[Double],x5621:Array[Double]): activation_x5624x5625x5626 = {
val x5624x5625x5626_closure = new generated.scala.DeliteOpMultiLoop[activation_x5624x5625x5626] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x5585
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x5624x5625x5626 = {
val __act: activation_x5624x5625x5626 = new activation_x5624x5625x5626()
val x4874 = (loopSize).asInstanceOf[Int]
if (x4874 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4878 = new Array[Double](x4874.toInt)
__act.x5624_data = x4878
val x4917 = (loopSize).asInstanceOf[Int]
if (x4917 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4921 = new Array[Double](x4917.toInt)
__act.x5625_data = x4921
val x4960 = (loopSize).asInstanceOf[Int]
if (x4960 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4964 = new Array[Double](x4960.toInt)
__act.x5626_data = x4964
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5624x5625x5626,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x5624x5625x5626]): activation_x5624x5625x5626 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x5624x5625x5626 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x5624x5625x5626 = sync.get(localStart)
sync.awaitBarrier
if (tid == 0) {
finalize(resourceInfo,act)
}
act
}

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5624x5625x5626): activation_x5624x5625x5626 = {
val act: activation_x5624x5625x5626 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5624x5625x5626,start:Long,end:Long): activation_x5624x5625x5626 = {
val isEmpty: Boolean = end-start <= 0
var idx: Int = (start).asInstanceOf[Int]
val __act2: activation_x5624x5625x5626 = init(resourceInfo,__act,idx,isEmpty)
idx = idx + 1
while (idx < end) {
process(resourceInfo,__act2,idx)
idx = idx + 1
}
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5624x5625x5626,x2289:Int,isEmpty:Boolean): activation_x5624x5625x5626 = {
if (!isEmpty) {
process(resourceInfo,__act,x2289)
}
__act
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5624x5625x5626,x2289:Int): Unit = {
val x5614 = x5613(x2289.toInt)
val x5616 = x5615(x2289.toInt)
val x5617 = {
implicitly[Fractional[Double]].div(x5614,x5616)}
val x5619 = x5618(x2289.toInt)
val x5620 = {
implicitly[Fractional[Double]].div(x5619,x5616)}
val x5622 = x5621(x2289.toInt)
val x5623 = {
implicitly[Fractional[Double]].div(x5622,x5616)}
val x4873 = x5617
val x4872 = __act.x5624_data
val x4882 = x4872(x2289.toInt) = x4873
val x4916 = x5620
val x4915 = __act.x5625_data
val x4925 = x4915(x2289.toInt) = x4916
val x4959 = x5623
val x4958 = __act.x5626_data
val x4968 = x4958(x2289.toInt) = x4959
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5624x5625x5626,rhs:activation_x5624x5625x5626): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5624x5625x5626,lhs:activation_x5624x5625x5626): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5624x5625x5626): Unit = {
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5624x5625x5626): Unit = {
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5624x5625x5626): Unit = {
var x4872: Array[Double] = __act.x5624_data
__act.x5624_data = null
__act.x5624 = x4872
var x4915: Array[Double] = __act.x5625_data
__act.x5625_data = null
__act.x5625 = x4915
var x4958: Array[Double] = __act.x5626_data
__act.x5626_data = null
__act.x5626 = x4958
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x5624x5625x5626 = {
val act: activation_x5624x5625x5626 = new activation_x5624x5625x5626
act
}

}
x5624x5625x5626_closure.loopStart = 0
x5624x5625x5626_closure.loopSize = x5585
val alloc: activation_x5624x5625x5626 = x5624x5625x5626_closure.alloc(resourceInfo)
var x5624x5625x5626: activation_x5624x5625x5626 = null
if (resourceInfo.availableThreads <= 1) {
x5624x5625x5626 = x5624x5625x5626_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x5624x5625x5626] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x5624x5625x5626](x5624x5625x5626_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x5624x5625x5626_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x5624x5625x5626 = x5624x5625x5626_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x5624x5625x5626
}}

/**********/


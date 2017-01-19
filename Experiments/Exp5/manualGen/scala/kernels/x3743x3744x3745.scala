package generated.scala
//activation record for fat loop
final class activation_x3743x3744x3745 {
var left_act: activation_x3743x3744x3745 = _
var x3743: Array[Double] = _
var x3743_data: Array[Double] = _
var x3744: Array[Double] = _
var x3744_data: Array[Double] = _
var x3745: Array[Double] = _
var x3745_data: Array[Double] = _
}
object activation_x3743x3744x3745 {
}
object kernel_x3743x3744x3745 {
def apply(resourceInfo:generated.scala.ResourceInfo,x3710:Int,x3732:Array[Double],x3734:Array[Int],x3737:Array[Double],x3740:Array[Double]): activation_x3743x3744x3745 = {
val x3743x3744x3745_closure = new generated.scala.DeliteOpMultiLoop[activation_x3743x3744x3745] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x3710
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x3743x3744x3745 = {
val __act: activation_x3743x3744x3745 = new activation_x3743x3744x3745()
val x3048 = (loopSize).asInstanceOf[Int]
if (x3048 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3052 = new Array[Double](x3048.toInt)
__act.x3743_data = x3052
val x3091 = (loopSize).asInstanceOf[Int]
if (x3091 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3095 = new Array[Double](x3091.toInt)
__act.x3744_data = x3095
val x3134 = (loopSize).asInstanceOf[Int]
if (x3134 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3138 = new Array[Double](x3134.toInt)
__act.x3745_data = x3138
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3743x3744x3745,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x3743x3744x3745]): activation_x3743x3744x3745 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x3743x3744x3745 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x3743x3744x3745 = sync.get(localStart)
sync.awaitBarrier
if (tid == 0) {
finalize(resourceInfo,act)
}
act
}

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3743x3744x3745): activation_x3743x3744x3745 = {
val act: activation_x3743x3744x3745 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3743x3744x3745,start:Long,end:Long): activation_x3743x3744x3745 = {
val isEmpty: Boolean = end-start <= 0
var idx: Int = (start).asInstanceOf[Int]
val __act2: activation_x3743x3744x3745 = init(resourceInfo,__act,idx,isEmpty)
idx = idx + 1
while (idx < end) {
process(resourceInfo,__act2,idx)
idx = idx + 1
}
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3743x3744x3745,x1516:Int,isEmpty:Boolean): activation_x3743x3744x3745 = {
if (!isEmpty) {
process(resourceInfo,__act,x1516)
}
__act
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3743x3744x3745,x1516:Int): Unit = {
val x3733 = x3732(x1516.toInt)
val x3735 = x3734(x1516.toInt)
val x3736 = {
implicitly[Fractional[Double]].div(x3733,x3735)}
val x3738 = x3737(x1516.toInt)
val x3739 = {
implicitly[Fractional[Double]].div(x3738,x3735)}
val x3741 = x3740(x1516.toInt)
val x3742 = {
implicitly[Fractional[Double]].div(x3741,x3735)}
val x3047 = x3736
val x3046 = __act.x3743_data
val x3056 = x3046(x1516.toInt) = x3047
val x3090 = x3739
val x3089 = __act.x3744_data
val x3099 = x3089(x1516.toInt) = x3090
val x3133 = x3742
val x3132 = __act.x3745_data
val x3142 = x3132(x1516.toInt) = x3133
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3743x3744x3745,rhs:activation_x3743x3744x3745): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3743x3744x3745,lhs:activation_x3743x3744x3745): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3743x3744x3745): Unit = {
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3743x3744x3745): Unit = {
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3743x3744x3745): Unit = {
var x3046: Array[Double] = __act.x3743_data
__act.x3743_data = null
__act.x3743 = x3046
var x3089: Array[Double] = __act.x3744_data
__act.x3744_data = null
__act.x3744 = x3089
var x3132: Array[Double] = __act.x3745_data
__act.x3745_data = null
__act.x3745 = x3132
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x3743x3744x3745 = {
val act: activation_x3743x3744x3745 = new activation_x3743x3744x3745
act
}

}
x3743x3744x3745_closure.loopStart = 0
x3743x3744x3745_closure.loopSize = x3710
val alloc: activation_x3743x3744x3745 = x3743x3744x3745_closure.alloc(resourceInfo)
var x3743x3744x3745: activation_x3743x3744x3745 = null
if (resourceInfo.availableThreads <= 1) {
x3743x3744x3745 = x3743x3744x3745_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x3743x3744x3745] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x3743x3744x3745](x3743x3744x3745_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x3743x3744x3745_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x3743x3744x3745 = x3743x3744x3745_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x3743x3744x3745
}}

/**********/


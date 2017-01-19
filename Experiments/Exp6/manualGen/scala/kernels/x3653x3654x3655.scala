package generated.scala
//activation record for fat loop
final class activation_x3653x3654x3655 {
var left_act: activation_x3653x3654x3655 = _
var x3653: Array[Double] = _
var x3653_data: Array[Double] = _
var x3654: Array[Double] = _
var x3654_data: Array[Double] = _
var x3655: Array[Double] = _
var x3655_data: Array[Double] = _
}
object activation_x3653x3654x3655 {
}
object kernel_x3653x3654x3655 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2956:Int,x2963:Array[Double],x3648:Array[Int],x3008:Array[Double],x3009:Array[Double]): activation_x3653x3654x3655 = {
val x3653x3654x3655_closure = new generated.scala.DeliteOpMultiLoop[activation_x3653x3654x3655] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x2956
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x3653x3654x3655 = {
val __act: activation_x3653x3654x3655 = new activation_x3653x3654x3655()
val x3051 = (loopSize).asInstanceOf[Int]
if (x3051 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3055 = new Array[Double](x3051.toInt)
__act.x3653_data = x3055
val x3094 = (loopSize).asInstanceOf[Int]
if (x3094 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3098 = new Array[Double](x3094.toInt)
__act.x3654_data = x3098
val x3137 = (loopSize).asInstanceOf[Int]
if (x3137 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3141 = new Array[Double](x3137.toInt)
__act.x3655_data = x3141
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3653x3654x3655,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x3653x3654x3655]): activation_x3653x3654x3655 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x3653x3654x3655 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x3653x3654x3655 = sync.get(localStart)
sync.awaitBarrier
if (tid == 0) {
finalize(resourceInfo,act)
}
act
}

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3653x3654x3655): activation_x3653x3654x3655 = {
val act: activation_x3653x3654x3655 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3653x3654x3655,start:Long,end:Long): activation_x3653x3654x3655 = {
val isEmpty: Boolean = end-start <= 0
var idx: Int = (start).asInstanceOf[Int]
val __act2: activation_x3653x3654x3655 = init(resourceInfo,__act,idx,isEmpty)
idx = idx + 1
while (idx < end) {
process(resourceInfo,__act2,idx)
idx = idx + 1
}
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3653x3654x3655,x1517:Int,isEmpty:Boolean): activation_x3653x3654x3655 = {
if (!isEmpty) {
process(resourceInfo,__act,x1517)
}
__act
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3653x3654x3655,x1517:Int): Unit = {
val x3041 = x2963(x1517.toInt)
val x3649 = x3648(x1517.toInt)
val x3650 = {
implicitly[Fractional[Double]].div(x3041,x3649)}
val x3044 = x3008(x1517.toInt)
val x3651 = {
implicitly[Fractional[Double]].div(x3044,x3649)}
val x3046 = x3009(x1517.toInt)
val x3652 = {
implicitly[Fractional[Double]].div(x3046,x3649)}
val x3050 = x3650
val x3049 = __act.x3653_data
val x3059 = x3049(x1517.toInt) = x3050
val x3093 = x3651
val x3092 = __act.x3654_data
val x3102 = x3092(x1517.toInt) = x3093
val x3136 = x3652
val x3135 = __act.x3655_data
val x3145 = x3135(x1517.toInt) = x3136
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3653x3654x3655,rhs:activation_x3653x3654x3655): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3653x3654x3655,lhs:activation_x3653x3654x3655): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3653x3654x3655): Unit = {
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3653x3654x3655): Unit = {
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3653x3654x3655): Unit = {
var x3049: Array[Double] = __act.x3653_data
__act.x3653_data = null
__act.x3653 = x3049
var x3092: Array[Double] = __act.x3654_data
__act.x3654_data = null
__act.x3654 = x3092
var x3135: Array[Double] = __act.x3655_data
__act.x3655_data = null
__act.x3655 = x3135
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x3653x3654x3655 = {
val act: activation_x3653x3654x3655 = new activation_x3653x3654x3655
act
}

}
x3653x3654x3655_closure.loopStart = 0
x3653x3654x3655_closure.loopSize = x2956
val alloc: activation_x3653x3654x3655 = x3653x3654x3655_closure.alloc(resourceInfo)
var x3653x3654x3655: activation_x3653x3654x3655 = null
if (resourceInfo.availableThreads <= 1) {
x3653x3654x3655 = x3653x3654x3655_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x3653x3654x3655] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x3653x3654x3655](x3653x3654x3655_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x3653x3654x3655_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x3653x3654x3655 = x3653x3654x3655_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x3653x3654x3655
}}

/**********/


package generated.scala
//activation record for fat loop
final class activation_x5794x5795x5796 {
var left_act: activation_x5794x5795x5796 = _
var x5794: Array[Double] = _
var x5794_data: Array[Double] = _
var x5795: Array[Double] = _
var x5795_data: Array[Double] = _
var x5796: Array[Double] = _
var x5796_data: Array[Double] = _
}
object activation_x5794x5795x5796 {
}
object kernel_x5794x5795x5796 {
def apply(resourceInfo:generated.scala.ResourceInfo,x5756:Int,x5784:Array[Double],x5754:Array[Int],x5788:Array[Double],x5791:Array[Double]): activation_x5794x5795x5796 = {
val x5794x5795x5796_closure = new generated.scala.DeliteOpMultiLoop[activation_x5794x5795x5796] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x5756
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x5794x5795x5796 = {
val __act: activation_x5794x5795x5796 = new activation_x5794x5795x5796()
val x4865 = (loopSize).asInstanceOf[Int]
if (x4865 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4869 = new Array[Double](x4865.toInt)
__act.x5794_data = x4869
val x4908 = (loopSize).asInstanceOf[Int]
if (x4908 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4912 = new Array[Double](x4908.toInt)
__act.x5795_data = x4912
val x4951 = (loopSize).asInstanceOf[Int]
if (x4951 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x4955 = new Array[Double](x4951.toInt)
__act.x5796_data = x4955
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5794x5795x5796,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x5794x5795x5796]): activation_x5794x5795x5796 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x5794x5795x5796 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x5794x5795x5796 = sync.get(localStart)
sync.awaitBarrier
if (tid == 0) {
finalize(resourceInfo,act)
}
act
}

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5794x5795x5796): activation_x5794x5795x5796 = {
val act: activation_x5794x5795x5796 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5794x5795x5796,start:Long,end:Long): activation_x5794x5795x5796 = {
val isEmpty: Boolean = end-start <= 0
var idx: Int = (start).asInstanceOf[Int]
val __act2: activation_x5794x5795x5796 = init(resourceInfo,__act,idx,isEmpty)
idx = idx + 1
while (idx < end) {
process(resourceInfo,__act2,idx)
idx = idx + 1
}
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5794x5795x5796,x2285:Int,isEmpty:Boolean): activation_x5794x5795x5796 = {
if (!isEmpty) {
process(resourceInfo,__act,x2285)
}
__act
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5794x5795x5796,x2285:Int): Unit = {
val x5785 = x5784(x2285.toInt)
val x5786 = x5754(x2285.toInt)
val x5787 = {
implicitly[Fractional[Double]].div(x5785,x5786)}
val x5789 = x5788(x2285.toInt)
val x5790 = {
implicitly[Fractional[Double]].div(x5789,x5786)}
val x5792 = x5791(x2285.toInt)
val x5793 = {
implicitly[Fractional[Double]].div(x5792,x5786)}
val x4864 = x5787
val x4863 = __act.x5794_data
val x4873 = x4863(x2285.toInt) = x4864
val x4907 = x5790
val x4906 = __act.x5795_data
val x4916 = x4906(x2285.toInt) = x4907
val x4950 = x5793
val x4949 = __act.x5796_data
val x4959 = x4949(x2285.toInt) = x4950
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5794x5795x5796,rhs:activation_x5794x5795x5796): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5794x5795x5796,lhs:activation_x5794x5795x5796): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5794x5795x5796): Unit = {
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5794x5795x5796): Unit = {
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5794x5795x5796): Unit = {
var x4863: Array[Double] = __act.x5794_data
__act.x5794_data = null
__act.x5794 = x4863
var x4906: Array[Double] = __act.x5795_data
__act.x5795_data = null
__act.x5795 = x4906
var x4949: Array[Double] = __act.x5796_data
__act.x5796_data = null
__act.x5796 = x4949
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x5794x5795x5796 = {
val act: activation_x5794x5795x5796 = new activation_x5794x5795x5796
act
}

}
x5794x5795x5796_closure.loopStart = 0
x5794x5795x5796_closure.loopSize = x5756
val alloc: activation_x5794x5795x5796 = x5794x5795x5796_closure.alloc(resourceInfo)
var x5794x5795x5796: activation_x5794x5795x5796 = null
if (resourceInfo.availableThreads <= 1) {
x5794x5795x5796 = x5794x5795x5796_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x5794x5795x5796] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x5794x5795x5796](x5794x5795x5796_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x5794x5795x5796_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x5794x5795x5796 = x5794x5795x5796_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x5794x5795x5796
}}

/**********/


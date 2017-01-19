package generated.scala
//activation record for fat loop
final class activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 {
var left_act: activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = _
var x3751: Array[Char] = _
var x3751_data: Array[Char] = _
var x3752: Array[Char] = _
var x3752_data: Array[Char] = _
var x3753: Array[Double] = _
var x3753_data: Array[Double] = _
var x3754: Array[Double] = _
var x3754_data: Array[Double] = _
var x3755: Array[Double] = _
var x3755_data: Array[Double] = _
var x3756: Array[Double] = _
var x3756_data: Array[Double] = _
var x3757: Array[Double] = _
var x3757_data: Array[Double] = _
var x3758: Array[Double] = _
var x3758_data: Array[Double] = _
var x3759: Array[Double] = _
var x3759_data: Array[Double] = _
var x3760: Array[Int] = _
var x3760_data: Array[Int] = _
}
object activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 {
}
object kernel_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 {
def apply(resourceInfo:generated.scala.ResourceInfo,x3710:Int,x3720:Array[Int],x3709:Array[Char],x3715:Array[Char],x3724:Array[Double],x3726:Array[Double],x3728:Array[Double],x3730:Array[Double],x3743:Array[Double],x3744:Array[Double],x3745:Array[Double],x3749:Array[Int]): activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = {
val x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760_closure = new generated.scala.DeliteOpMultiLoop[activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x3710
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = {
val __act: activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = new activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760()
val x3212 = (loopSize).asInstanceOf[Int]
if (x3212 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3216 = new Array[Char](x3212.toInt)
__act.x3751_data = x3216
val x3255 = (loopSize).asInstanceOf[Int]
if (x3255 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3259 = new Array[Char](x3255.toInt)
__act.x3752_data = x3259
val x3298 = (loopSize).asInstanceOf[Int]
if (x3298 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3302 = new Array[Double](x3298.toInt)
__act.x3753_data = x3302
val x3341 = (loopSize).asInstanceOf[Int]
if (x3341 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3345 = new Array[Double](x3341.toInt)
__act.x3754_data = x3345
val x3384 = (loopSize).asInstanceOf[Int]
if (x3384 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3388 = new Array[Double](x3384.toInt)
__act.x3755_data = x3388
val x3427 = (loopSize).asInstanceOf[Int]
if (x3427 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3431 = new Array[Double](x3427.toInt)
__act.x3756_data = x3431
val x3470 = (loopSize).asInstanceOf[Int]
if (x3470 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3474 = new Array[Double](x3470.toInt)
__act.x3757_data = x3474
val x3513 = (loopSize).asInstanceOf[Int]
if (x3513 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3517 = new Array[Double](x3513.toInt)
__act.x3758_data = x3517
val x3556 = (loopSize).asInstanceOf[Int]
if (x3556 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3560 = new Array[Double](x3556.toInt)
__act.x3759_data = x3560
val x3599 = (loopSize).asInstanceOf[Int]
if (x3599 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3603 = new Array[Int](x3599.toInt)
__act.x3760_data = x3603
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760]): activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = sync.get(localStart)
sync.awaitBarrier
if (tid == 0) {
finalize(resourceInfo,act)
}
act
}

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760): activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = {
val act: activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760,start:Long,end:Long): activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = {
val isEmpty: Boolean = end-start <= 0
var idx: Int = (start).asInstanceOf[Int]
val __act2: activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = init(resourceInfo,__act,idx,isEmpty)
idx = idx + 1
while (idx < end) {
process(resourceInfo,__act2,idx)
idx = idx + 1
}
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760,x1835:Int,isEmpty:Boolean): activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = {
if (!isEmpty) {
process(resourceInfo,__act,x1835)
}
__act
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760,x1835:Int): Unit = {
val x3721 = x3720(x1835.toInt)
val x3722 = x3709(x3721.toInt)
val x3723 = x3715(x3721.toInt)
val x3725 = x3724(x3721.toInt)
val x3727 = x3726(x3721.toInt)
val x3729 = x3728(x3721.toInt)
val x3731 = x3730(x3721.toInt)
val x3746 = x3743(x3721.toInt)
val x3747 = x3744(x3721.toInt)
val x3748 = x3745(x3721.toInt)
val x3750 = x3749(x3721.toInt)
val x3211 = x3722
val x3210 = __act.x3751_data
val x3220 = x3210(x1835.toInt) = x3211
val x3254 = x3723
val x3253 = __act.x3752_data
val x3263 = x3253(x1835.toInt) = x3254
val x3297 = x3725
val x3296 = __act.x3753_data
val x3306 = x3296(x1835.toInt) = x3297
val x3340 = x3727
val x3339 = __act.x3754_data
val x3349 = x3339(x1835.toInt) = x3340
val x3383 = x3729
val x3382 = __act.x3755_data
val x3392 = x3382(x1835.toInt) = x3383
val x3426 = x3731
val x3425 = __act.x3756_data
val x3435 = x3425(x1835.toInt) = x3426
val x3469 = x3746
val x3468 = __act.x3757_data
val x3478 = x3468(x1835.toInt) = x3469
val x3512 = x3747
val x3511 = __act.x3758_data
val x3521 = x3511(x1835.toInt) = x3512
val x3555 = x3748
val x3554 = __act.x3759_data
val x3564 = x3554(x1835.toInt) = x3555
val x3598 = x3750
val x3597 = __act.x3760_data
val x3607 = x3597(x1835.toInt) = x3598
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760,rhs:activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760,lhs:activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760): Unit = {
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760): Unit = {
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760): Unit = {
var x3210: Array[Char] = __act.x3751_data
__act.x3751_data = null
__act.x3751 = x3210
var x3253: Array[Char] = __act.x3752_data
__act.x3752_data = null
__act.x3752 = x3253
var x3296: Array[Double] = __act.x3753_data
__act.x3753_data = null
__act.x3753 = x3296
var x3339: Array[Double] = __act.x3754_data
__act.x3754_data = null
__act.x3754 = x3339
var x3382: Array[Double] = __act.x3755_data
__act.x3755_data = null
__act.x3755 = x3382
var x3425: Array[Double] = __act.x3756_data
__act.x3756_data = null
__act.x3756 = x3425
var x3468: Array[Double] = __act.x3757_data
__act.x3757_data = null
__act.x3757 = x3468
var x3511: Array[Double] = __act.x3758_data
__act.x3758_data = null
__act.x3758 = x3511
var x3554: Array[Double] = __act.x3759_data
__act.x3759_data = null
__act.x3759 = x3554
var x3597: Array[Int] = __act.x3760_data
__act.x3760_data = null
__act.x3760 = x3597
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = {
val act: activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = new activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760
act
}

}
x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760_closure.loopStart = 0
x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760_closure.loopSize = x3710
val alloc: activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760_closure.alloc(resourceInfo)
var x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760: activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = null
if (resourceInfo.availableThreads <= 1) {
x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760](x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760 = x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x3751x3752x3753x3754x3755x3756x3757x3758x3759x3760
}}

/**********/


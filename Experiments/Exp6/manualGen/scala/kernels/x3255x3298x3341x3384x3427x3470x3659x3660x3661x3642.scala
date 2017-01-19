package generated.scala
//activation record for fat loop
final class activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 {
var left_act: activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = _
var x3255: Array[Char] = _
var x3255_data: Array[Char] = _
var x3298: Array[Char] = _
var x3298_data: Array[Char] = _
var x3341: Array[Double] = _
var x3341_data: Array[Double] = _
var x3384: Array[Double] = _
var x3384_data: Array[Double] = _
var x3427: Array[Double] = _
var x3427_data: Array[Double] = _
var x3470: Array[Double] = _
var x3470_data: Array[Double] = _
var x3659: Array[Double] = _
var x3659_data: Array[Double] = _
var x3660: Array[Double] = _
var x3660_data: Array[Double] = _
var x3661: Array[Double] = _
var x3661_data: Array[Double] = _
var x3642: Array[Int] = _
var x3642_data: Array[Int] = _
}
object activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 {
}
object kernel_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2956:Int,x3188:Array[Int],x2955:Array[Char],x2957:Array[Char],x2958:Array[Double],x2959:Array[Double],x2960:Array[Double],x2961:Array[Double],x3653:Array[Double],x3654:Array[Double],x3655:Array[Double],x2962:Array[Int]): activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = {
val x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642_closure = new generated.scala.DeliteOpMultiLoop[activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x2956
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = {
val __act: activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = new activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642()
val x3215 = (loopSize).asInstanceOf[Int]
if (x3215 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3219 = new Array[Char](x3215.toInt)
__act.x3255_data = x3219
val x3258 = (loopSize).asInstanceOf[Int]
if (x3258 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3262 = new Array[Char](x3258.toInt)
__act.x3298_data = x3262
val x3301 = (loopSize).asInstanceOf[Int]
if (x3301 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3305 = new Array[Double](x3301.toInt)
__act.x3341_data = x3305
val x3344 = (loopSize).asInstanceOf[Int]
if (x3344 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3348 = new Array[Double](x3344.toInt)
__act.x3384_data = x3348
val x3387 = (loopSize).asInstanceOf[Int]
if (x3387 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3391 = new Array[Double](x3387.toInt)
__act.x3427_data = x3391
val x3430 = (loopSize).asInstanceOf[Int]
if (x3430 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3434 = new Array[Double](x3430.toInt)
__act.x3470_data = x3434
val x3473 = (loopSize).asInstanceOf[Int]
if (x3473 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3477 = new Array[Double](x3473.toInt)
__act.x3659_data = x3477
val x3516 = (loopSize).asInstanceOf[Int]
if (x3516 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3520 = new Array[Double](x3516.toInt)
__act.x3660_data = x3520
val x3559 = (loopSize).asInstanceOf[Int]
if (x3559 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3563 = new Array[Double](x3559.toInt)
__act.x3661_data = x3563
val x3602 = (loopSize).asInstanceOf[Int]
if (x3602 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3606 = new Array[Int](x3602.toInt)
__act.x3642_data = x3606
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642]): activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = sync.get(localStart)
sync.awaitBarrier
if (tid == 0) {
finalize(resourceInfo,act)
}
act
}

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642): activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = {
val act: activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642,start:Long,end:Long): activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = {
val isEmpty: Boolean = end-start <= 0
var idx: Int = (start).asInstanceOf[Int]
val __act2: activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = init(resourceInfo,__act,idx,isEmpty)
idx = idx + 1
while (idx < end) {
process(resourceInfo,__act2,idx)
idx = idx + 1
}
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642,x1836:Int,isEmpty:Boolean): activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = {
if (!isEmpty) {
process(resourceInfo,__act,x1836)
}
__act
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642,x1836:Int): Unit = {
val x3201 = x3188(x1836.toInt)
val x3202 = x2955(x3201.toInt)
val x3203 = x2957(x3201.toInt)
val x3204 = x2958(x3201.toInt)
val x3205 = x2959(x3201.toInt)
val x3206 = x2960(x3201.toInt)
val x3207 = x2961(x3201.toInt)
val x3656 = x3653(x3201.toInt)
val x3657 = x3654(x3201.toInt)
val x3658 = x3655(x3201.toInt)
val x3211 = x2962(x3201.toInt)
val x3214 = x3202
val x3213 = __act.x3255_data
val x3223 = x3213(x1836.toInt) = x3214
val x3257 = x3203
val x3256 = __act.x3298_data
val x3266 = x3256(x1836.toInt) = x3257
val x3300 = x3204
val x3299 = __act.x3341_data
val x3309 = x3299(x1836.toInt) = x3300
val x3343 = x3205
val x3342 = __act.x3384_data
val x3352 = x3342(x1836.toInt) = x3343
val x3386 = x3206
val x3385 = __act.x3427_data
val x3395 = x3385(x1836.toInt) = x3386
val x3429 = x3207
val x3428 = __act.x3470_data
val x3438 = x3428(x1836.toInt) = x3429
val x3472 = x3656
val x3471 = __act.x3659_data
val x3481 = x3471(x1836.toInt) = x3472
val x3515 = x3657
val x3514 = __act.x3660_data
val x3524 = x3514(x1836.toInt) = x3515
val x3558 = x3658
val x3557 = __act.x3661_data
val x3567 = x3557(x1836.toInt) = x3558
val x3601 = x3211
val x3600 = __act.x3642_data
val x3610 = x3600(x1836.toInt) = x3601
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642,rhs:activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642,lhs:activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642): Unit = {
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642): Unit = {
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642): Unit = {
var x3213: Array[Char] = __act.x3255_data
__act.x3255_data = null
__act.x3255 = x3213
var x3256: Array[Char] = __act.x3298_data
__act.x3298_data = null
__act.x3298 = x3256
var x3299: Array[Double] = __act.x3341_data
__act.x3341_data = null
__act.x3341 = x3299
var x3342: Array[Double] = __act.x3384_data
__act.x3384_data = null
__act.x3384 = x3342
var x3385: Array[Double] = __act.x3427_data
__act.x3427_data = null
__act.x3427 = x3385
var x3428: Array[Double] = __act.x3470_data
__act.x3470_data = null
__act.x3470 = x3428
var x3471: Array[Double] = __act.x3659_data
__act.x3659_data = null
__act.x3659 = x3471
var x3514: Array[Double] = __act.x3660_data
__act.x3660_data = null
__act.x3660 = x3514
var x3557: Array[Double] = __act.x3661_data
__act.x3661_data = null
__act.x3661 = x3557
var x3600: Array[Int] = __act.x3642_data
__act.x3642_data = null
__act.x3642 = x3600
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = {
val act: activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = new activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642
act
}

}
x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642_closure.loopStart = 0
x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642_closure.loopSize = x2956
val alloc: activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642_closure.alloc(resourceInfo)
var x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642: activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = null
if (resourceInfo.availableThreads <= 1) {
x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642](x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642 = x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x3255x3298x3341x3384x3427x3470x3659x3660x3661x3642
}}

/**********/


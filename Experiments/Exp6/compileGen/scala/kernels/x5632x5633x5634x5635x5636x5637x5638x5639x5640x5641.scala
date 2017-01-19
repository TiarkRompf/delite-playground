package generated.scala
//activation record for fat loop
final class activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 {
var left_act: activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = _
var x5632: Array[java.lang.String] = _
var x5632_data: Array[java.lang.String] = _
var x5633: Array[java.lang.String] = _
var x5633_data: Array[java.lang.String] = _
var x5634: Array[Double] = _
var x5634_data: Array[Double] = _
var x5635: Array[Double] = _
var x5635_data: Array[Double] = _
var x5636: Array[Double] = _
var x5636_data: Array[Double] = _
var x5637: Array[Double] = _
var x5637_data: Array[Double] = _
var x5638: Array[Double] = _
var x5638_data: Array[Double] = _
var x5639: Array[Double] = _
var x5639_data: Array[Double] = _
var x5640: Array[Double] = _
var x5640_data: Array[Double] = _
var x5641: Array[Long] = _
var x5641_data: Array[Long] = _
}
object activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 {
}
object kernel_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 {
def apply(resourceInfo:generated.scala.ResourceInfo,x5585:Int,x5601:Array[Int],x5584:Array[java.lang.String],x5593:Array[java.lang.String],x5605:Array[Double],x5607:Array[Double],x5609:Array[Double],x5611:Array[Double],x5624:Array[Double],x5625:Array[Double],x5626:Array[Double],x5630:Array[Int]): activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = {
val x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641_closure = new generated.scala.DeliteOpMultiLoop[activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x5585
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = {
val __act: activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = new activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641()
val x5080 = (loopSize).asInstanceOf[Int]
if (x5080 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5084 = new Array[java.lang.String](x5080.toInt)
__act.x5632_data = x5084
val x5123 = (loopSize).asInstanceOf[Int]
if (x5123 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5127 = new Array[java.lang.String](x5123.toInt)
__act.x5633_data = x5127
val x5166 = (loopSize).asInstanceOf[Int]
if (x5166 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5170 = new Array[Double](x5166.toInt)
__act.x5634_data = x5170
val x5209 = (loopSize).asInstanceOf[Int]
if (x5209 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5213 = new Array[Double](x5209.toInt)
__act.x5635_data = x5213
val x5252 = (loopSize).asInstanceOf[Int]
if (x5252 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5256 = new Array[Double](x5252.toInt)
__act.x5636_data = x5256
val x5295 = (loopSize).asInstanceOf[Int]
if (x5295 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5299 = new Array[Double](x5295.toInt)
__act.x5637_data = x5299
val x5338 = (loopSize).asInstanceOf[Int]
if (x5338 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5342 = new Array[Double](x5338.toInt)
__act.x5638_data = x5342
val x5381 = (loopSize).asInstanceOf[Int]
if (x5381 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5385 = new Array[Double](x5381.toInt)
__act.x5639_data = x5385
val x5424 = (loopSize).asInstanceOf[Int]
if (x5424 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5428 = new Array[Double](x5424.toInt)
__act.x5640_data = x5428
val x5467 = (loopSize).asInstanceOf[Int]
if (x5467 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5471 = new Array[Long](x5467.toInt)
__act.x5641_data = x5471
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641]): activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = sync.get(localStart)
sync.awaitBarrier
if (tid == 0) {
finalize(resourceInfo,act)
}
act
}

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641): activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = {
val act: activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641,start:Long,end:Long): activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = {
val isEmpty: Boolean = end-start <= 0
var idx: Int = (start).asInstanceOf[Int]
val __act2: activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = init(resourceInfo,__act,idx,isEmpty)
idx = idx + 1
while (idx < end) {
process(resourceInfo,__act2,idx)
idx = idx + 1
}
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641,x2890:Int,isEmpty:Boolean): activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = {
if (!isEmpty) {
process(resourceInfo,__act,x2890)
}
__act
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641,x2890:Int): Unit = {
val x5602 = x5601(x2890.toInt)
val x5603 = x5584(x5602.toInt)
val x5604 = x5593(x5602.toInt)
val x5606 = x5605(x5602.toInt)
val x5608 = x5607(x5602.toInt)
val x5610 = x5609(x5602.toInt)
val x5612 = x5611(x5602.toInt)
val x5627 = x5624(x5602.toInt)
val x5628 = x5625(x5602.toInt)
val x5629 = x5626(x5602.toInt)
val x5631 = x5630(x5602.toInt)
val x5079 = x5603
val x5078 = __act.x5632_data
val x5088 = x5078(x2890.toInt) = x5079
val x5122 = x5604
val x5121 = __act.x5633_data
val x5131 = x5121(x2890.toInt) = x5122
val x5165 = x5606
val x5164 = __act.x5634_data
val x5174 = x5164(x2890.toInt) = x5165
val x5208 = x5608
val x5207 = __act.x5635_data
val x5217 = x5207(x2890.toInt) = x5208
val x5251 = x5610
val x5250 = __act.x5636_data
val x5260 = x5250(x2890.toInt) = x5251
val x5294 = x5612
val x5293 = __act.x5637_data
val x5303 = x5293(x2890.toInt) = x5294
val x5337 = x5627
val x5336 = __act.x5638_data
val x5346 = x5336(x2890.toInt) = x5337
val x5380 = x5628
val x5379 = __act.x5639_data
val x5389 = x5379(x2890.toInt) = x5380
val x5423 = x5629
val x5422 = __act.x5640_data
val x5432 = x5422(x2890.toInt) = x5423
val x5466 = x5631
val x5465 = __act.x5641_data
val x5475 = x5465(x2890.toInt) = x5466
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641,rhs:activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641,lhs:activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641): Unit = {
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641): Unit = {
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641): Unit = {
var x5078: Array[java.lang.String] = __act.x5632_data
__act.x5632_data = null
__act.x5632 = x5078
var x5121: Array[java.lang.String] = __act.x5633_data
__act.x5633_data = null
__act.x5633 = x5121
var x5164: Array[Double] = __act.x5634_data
__act.x5634_data = null
__act.x5634 = x5164
var x5207: Array[Double] = __act.x5635_data
__act.x5635_data = null
__act.x5635 = x5207
var x5250: Array[Double] = __act.x5636_data
__act.x5636_data = null
__act.x5636 = x5250
var x5293: Array[Double] = __act.x5637_data
__act.x5637_data = null
__act.x5637 = x5293
var x5336: Array[Double] = __act.x5638_data
__act.x5638_data = null
__act.x5638 = x5336
var x5379: Array[Double] = __act.x5639_data
__act.x5639_data = null
__act.x5639 = x5379
var x5422: Array[Double] = __act.x5640_data
__act.x5640_data = null
__act.x5640 = x5422
var x5465: Array[Long] = __act.x5641_data
__act.x5641_data = null
__act.x5641 = x5465
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = {
val act: activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = new activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641
act
}

}
x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641_closure.loopStart = 0
x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641_closure.loopSize = x5585
val alloc: activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641_closure.alloc(resourceInfo)
var x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641: activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = null
if (resourceInfo.availableThreads <= 1) {
x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641](x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641 = x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x5632x5633x5634x5635x5636x5637x5638x5639x5640x5641
}}

/**********/


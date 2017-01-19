package generated.scala
//activation record for fat loop
final class activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 {
var left_act: activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = _
var x5802: Array[java.lang.String] = _
var x5802_data: Array[java.lang.String] = _
var x5803: Array[java.lang.String] = _
var x5803_data: Array[java.lang.String] = _
var x5804: Array[Double] = _
var x5804_data: Array[Double] = _
var x5805: Array[Double] = _
var x5805_data: Array[Double] = _
var x5806: Array[Double] = _
var x5806_data: Array[Double] = _
var x5807: Array[Double] = _
var x5807_data: Array[Double] = _
var x5808: Array[Double] = _
var x5808_data: Array[Double] = _
var x5809: Array[Double] = _
var x5809_data: Array[Double] = _
var x5810: Array[Double] = _
var x5810_data: Array[Double] = _
var x5811: Array[Long] = _
var x5811_data: Array[Long] = _
}
object activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 {
}
object kernel_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 {
def apply(resourceInfo:generated.scala.ResourceInfo,x5756:Int,x5772:Array[Int],x5755:Array[java.lang.String],x5764:Array[java.lang.String],x5776:Array[Double],x5778:Array[Double],x5780:Array[Double],x5782:Array[Double],x5794:Array[Double],x5795:Array[Double],x5796:Array[Double],x5800:Array[Int]): activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = {
val x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811_closure = new generated.scala.DeliteOpMultiLoop[activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x5756
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = {
val __act: activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = new activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811()
val x5071 = (loopSize).asInstanceOf[Int]
if (x5071 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5075 = new Array[java.lang.String](x5071.toInt)
__act.x5802_data = x5075
val x5114 = (loopSize).asInstanceOf[Int]
if (x5114 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5118 = new Array[java.lang.String](x5114.toInt)
__act.x5803_data = x5118
val x5157 = (loopSize).asInstanceOf[Int]
if (x5157 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5161 = new Array[Double](x5157.toInt)
__act.x5804_data = x5161
val x5200 = (loopSize).asInstanceOf[Int]
if (x5200 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5204 = new Array[Double](x5200.toInt)
__act.x5805_data = x5204
val x5243 = (loopSize).asInstanceOf[Int]
if (x5243 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5247 = new Array[Double](x5243.toInt)
__act.x5806_data = x5247
val x5286 = (loopSize).asInstanceOf[Int]
if (x5286 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5290 = new Array[Double](x5286.toInt)
__act.x5807_data = x5290
val x5329 = (loopSize).asInstanceOf[Int]
if (x5329 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5333 = new Array[Double](x5329.toInt)
__act.x5808_data = x5333
val x5372 = (loopSize).asInstanceOf[Int]
if (x5372 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5376 = new Array[Double](x5372.toInt)
__act.x5809_data = x5376
val x5415 = (loopSize).asInstanceOf[Int]
if (x5415 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5419 = new Array[Double](x5415.toInt)
__act.x5810_data = x5419
val x5458 = (loopSize).asInstanceOf[Int]
if (x5458 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x5462 = new Array[Long](x5458.toInt)
__act.x5811_data = x5462
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811]): activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = sync.get(localStart)
sync.awaitBarrier
if (tid == 0) {
finalize(resourceInfo,act)
}
act
}

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811): activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = {
val act: activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811,start:Long,end:Long): activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = {
val isEmpty: Boolean = end-start <= 0
var idx: Int = (start).asInstanceOf[Int]
val __act2: activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = init(resourceInfo,__act,idx,isEmpty)
idx = idx + 1
while (idx < end) {
process(resourceInfo,__act2,idx)
idx = idx + 1
}
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811,x2886:Int,isEmpty:Boolean): activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = {
if (!isEmpty) {
process(resourceInfo,__act,x2886)
}
__act
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811,x2886:Int): Unit = {
val x5773 = x5772(x2886.toInt)
val x5774 = x5755(x5773.toInt)
val x5775 = x5764(x5773.toInt)
val x5777 = x5776(x5773.toInt)
val x5779 = x5778(x5773.toInt)
val x5781 = x5780(x5773.toInt)
val x5783 = x5782(x5773.toInt)
val x5797 = x5794(x5773.toInt)
val x5798 = x5795(x5773.toInt)
val x5799 = x5796(x5773.toInt)
val x5801 = x5800(x5773.toInt)
val x5070 = x5774
val x5069 = __act.x5802_data
val x5079 = x5069(x2886.toInt) = x5070
val x5113 = x5775
val x5112 = __act.x5803_data
val x5122 = x5112(x2886.toInt) = x5113
val x5156 = x5777
val x5155 = __act.x5804_data
val x5165 = x5155(x2886.toInt) = x5156
val x5199 = x5779
val x5198 = __act.x5805_data
val x5208 = x5198(x2886.toInt) = x5199
val x5242 = x5781
val x5241 = __act.x5806_data
val x5251 = x5241(x2886.toInt) = x5242
val x5285 = x5783
val x5284 = __act.x5807_data
val x5294 = x5284(x2886.toInt) = x5285
val x5328 = x5797
val x5327 = __act.x5808_data
val x5337 = x5327(x2886.toInt) = x5328
val x5371 = x5798
val x5370 = __act.x5809_data
val x5380 = x5370(x2886.toInt) = x5371
val x5414 = x5799
val x5413 = __act.x5810_data
val x5423 = x5413(x2886.toInt) = x5414
val x5457 = x5801
val x5456 = __act.x5811_data
val x5466 = x5456(x2886.toInt) = x5457
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811,rhs:activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811,lhs:activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811): Unit = {
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811): Unit = {
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811): Unit = {
var x5069: Array[java.lang.String] = __act.x5802_data
__act.x5802_data = null
__act.x5802 = x5069
var x5112: Array[java.lang.String] = __act.x5803_data
__act.x5803_data = null
__act.x5803 = x5112
var x5155: Array[Double] = __act.x5804_data
__act.x5804_data = null
__act.x5804 = x5155
var x5198: Array[Double] = __act.x5805_data
__act.x5805_data = null
__act.x5805 = x5198
var x5241: Array[Double] = __act.x5806_data
__act.x5806_data = null
__act.x5806 = x5241
var x5284: Array[Double] = __act.x5807_data
__act.x5807_data = null
__act.x5807 = x5284
var x5327: Array[Double] = __act.x5808_data
__act.x5808_data = null
__act.x5808 = x5327
var x5370: Array[Double] = __act.x5809_data
__act.x5809_data = null
__act.x5809 = x5370
var x5413: Array[Double] = __act.x5810_data
__act.x5810_data = null
__act.x5810 = x5413
var x5456: Array[Long] = __act.x5811_data
__act.x5811_data = null
__act.x5811 = x5456
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = {
val act: activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = new activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811
act
}

}
x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811_closure.loopStart = 0
x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811_closure.loopSize = x5756
val alloc: activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811_closure.alloc(resourceInfo)
var x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811: activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = null
if (resourceInfo.availableThreads <= 1) {
x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811](x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811 = x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x5802x5803x5804x5805x5806x5807x5808x5809x5810x5811
}}

/**********/


package generated.scala
//activation record for fat loop
final class activation_x933 {
var left_act: activation_x933 = _
var all_acts: Array[activation_x933] = _
var x933_hash_pos: generated.scala.container.HashMapImpl[Int] = _
var x933_size: Int = _
var x933: generated.scala.DeliteArrayAnon1415709433 = _
var x933_hash_data: generated.scala.DeliteArrayAnon1415709433 = _
}
object activation_x933 {
}
object kernel_x933 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2:Long,x349:generated.scala.Anon1415709433,x1:generated.scala.io.DeliteFileInputStream): activation_x933 = {
val x933_closure = new generated.scala.DeliteOpMultiLoop[activation_x933] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x2
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x933 = {
val __act: activation_x933 = new activation_x933()
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x933,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x933]): activation_x933 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x933 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x933 = sync.get(localStart)
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

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x933): activation_x933 = {
val act: activation_x933 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x933,start:Long,end:Long): activation_x933 = {
val x1_stream: generated.scala.io.DeliteFileInputStream = x1.openCopyAtNewLine(start)
val x1_stream_offset: Long = x1_stream.streamOffset
val isEmpty: Boolean = end <= x1_stream.position
val __act2: activation_x933 = init(resourceInfo,__act,-1,isEmpty,x1_stream)
while (x1_stream.position < x1_stream_offset + end) {
process(resourceInfo,__act2,-1,x1_stream)
}
x1_stream.close();
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x933,x3:Int,isEmpty:Boolean,x1_stream:generated.scala.io.DeliteFileInputStream): activation_x933 = {
val __act2: activation_x933 = new activation_x933()
__act2.x933_hash_pos = new generated.scala.container.HashMapImpl[Int](512,128)
__act2.x933_size = -1
val x359: Int = 128
if (x359 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x844 = new Array[Int](x359.toInt)
if (x359 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x845 = new Array[Int](x359.toInt)
val x846 = new generated.scala.DeliteArrayAnon1415709433(x844,x845)
__act2.x933_hash_data = x846
if (!isEmpty) {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
val x9 = x5(2.toInt)
val x10 = {
x9.toInt}
val x924 = new generated.scala.Anon1415709433(x10,1)
val x925 = {
x10 > 0}
if (x925) {
// common key Block(Sym(10)) for x933
val x933_sze: Int = __act2.x933_hash_pos.size
val x933_idx: Int = __act2.x933_hash_pos.put(x10)
if (x933_idx == x933_sze) { // new key
val x361: generated.scala.DeliteArrayAnon1415709433 = __act2.x933_hash_data
val x358: generated.scala.Anon1415709433 = x924
val x861 = x933_sze
val x862 = x361.n_regionkey
val x863 = x862.length
val x864 = x863 - 1
val x865 = x861 > x864
val x885 = {
def x885thenb(): Unit = {
val x866 = x863 < 16
val x870 = {
def x870thenb(): Int = {
16
}
def x870elseb(): Int = {
val x867 = x863 * 2
val x868 = x867 < 0
val x869 = {
def x869thenb(): Int = {
2147483647
}
def x869elseb(): Int = {
x867
}
if (x868) {
x869thenb()
} else { 
x869elseb()
}
}
x869
}
if (x866) {
x870thenb()
} else { 
x870elseb()
}
}
if (x870 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x871 = new Array[Int](x870.toInt)
if (x870 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x872 = new Array[Int](x870.toInt)
val x873 = System.arraycopy(x862,0.toInt,x871,0.toInt,x863.toInt)
val x874 = x361.count
val x875 = System.arraycopy(x874,0.toInt,x872,0.toInt,x863.toInt)
val x373 = x358.n_regionkey
val x876 = x871(x861.toInt) = x373
val x376 = x358.count
val x877 = x872(x861.toInt) = x376
val x878 = new generated.scala.DeliteArrayAnon1415709433(x871,x872)
val x879 = __act2.x933_hash_data = x878
x879
}
def x885elseb(): Unit = {
val x373 = x358.n_regionkey
val x881 = x361.n_regionkey(x861.toInt) = x373
val x882 = x361.count
val x376 = x358.count
val x883 = x361.count(x861.toInt) = x376
()
}
if (x865) {
x885thenb()
} else { 
x885elseb()
}
}
} else { // existing key
val x360: Int = x933_idx
val x361: generated.scala.DeliteArrayAnon1415709433 = __act2.x933_hash_data
val x848 = x361.n_regionkey
val x849 = x361.count
val x850 = x848(x360.toInt)
val x851 = x849(x360.toInt)
val x852 = new generated.scala.Anon1415709433(x850,x851)
val x350: generated.scala.Anon1415709433 = x852
val x351: generated.scala.Anon1415709433 = x924
val x352 = x350.n_regionkey
val x354 = x350.count
val x355 = x351.count
val x356 = {
x354 + x355}
val x357 = new generated.scala.Anon1415709433(x352,x356)
val x358: generated.scala.Anon1415709433 = x357
val x854 = x361.n_regionkey
val x373 = x358.n_regionkey
val x855 = x361.n_regionkey(x360.toInt) = x373
val x856 = x361.count
val x376 = x358.count
val x857 = x361.count(x360.toInt) = x376
}
}
}
__act2
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x933,x3:Int,x1_stream:generated.scala.io.DeliteFileInputStream): Unit = {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
val x9 = x5(2.toInt)
val x10 = {
x9.toInt}
val x924 = new generated.scala.Anon1415709433(x10,1)
val x925 = {
x10 > 0}
if (x925) {
// common key Block(Sym(10)) for x933
val x933_sze: Int = __act.x933_hash_pos.size
val x933_idx: Int = __act.x933_hash_pos.put(x10)
if (x933_idx == x933_sze) { // new key
val x361: generated.scala.DeliteArrayAnon1415709433 = __act.x933_hash_data
val x358: generated.scala.Anon1415709433 = x924
val x861 = x933_sze
val x862 = x361.n_regionkey
val x863 = x862.length
val x864 = x863 - 1
val x865 = x861 > x864
val x885 = {
def x885thenb(): Unit = {
val x866 = x863 < 16
val x870 = {
def x870thenb(): Int = {
16
}
def x870elseb(): Int = {
val x867 = x863 * 2
val x868 = x867 < 0
val x869 = {
def x869thenb(): Int = {
2147483647
}
def x869elseb(): Int = {
x867
}
if (x868) {
x869thenb()
} else { 
x869elseb()
}
}
x869
}
if (x866) {
x870thenb()
} else { 
x870elseb()
}
}
if (x870 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x871 = new Array[Int](x870.toInt)
if (x870 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x872 = new Array[Int](x870.toInt)
val x873 = System.arraycopy(x862,0.toInt,x871,0.toInt,x863.toInt)
val x874 = x361.count
val x875 = System.arraycopy(x874,0.toInt,x872,0.toInt,x863.toInt)
val x373 = x358.n_regionkey
val x876 = x871(x861.toInt) = x373
val x376 = x358.count
val x877 = x872(x861.toInt) = x376
val x878 = new generated.scala.DeliteArrayAnon1415709433(x871,x872)
val x879 = __act.x933_hash_data = x878
x879
}
def x885elseb(): Unit = {
val x373 = x358.n_regionkey
val x881 = x361.n_regionkey(x861.toInt) = x373
val x882 = x361.count
val x376 = x358.count
val x883 = x361.count(x861.toInt) = x376
()
}
if (x865) {
x885thenb()
} else { 
x885elseb()
}
}
} else { // existing key
val x360: Int = x933_idx
val x361: generated.scala.DeliteArrayAnon1415709433 = __act.x933_hash_data
val x848 = x361.n_regionkey
val x849 = x361.count
val x850 = x848(x360.toInt)
val x851 = x849(x360.toInt)
val x852 = new generated.scala.Anon1415709433(x850,x851)
val x350: generated.scala.Anon1415709433 = x852
val x351: generated.scala.Anon1415709433 = x924
val x352 = x350.n_regionkey
val x354 = x350.count
val x355 = x351.count
val x356 = {
x354 + x355}
val x357 = new generated.scala.Anon1415709433(x352,x356)
val x358: generated.scala.Anon1415709433 = x357
val x854 = x361.n_regionkey
val x373 = x358.n_regionkey
val x855 = x361.n_regionkey(x360.toInt) = x373
val x856 = x361.count
val x376 = x358.count
val x857 = x361.count(x360.toInt) = x376
}
}
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x933,rhs:activation_x933): Unit = {
// common key Block(Sym(10)) for x933
if (__act.x933_size == -1) __act.x933_size = __act.x933_hash_pos.size
if (rhs.x933_size == -1) rhs.x933_size = rhs.x933_hash_pos.size
var x933rhs_idx: Int = 0
while (x933rhs_idx < rhs.x933_hash_pos.size) {
val x933_k: Int = rhs.x933_hash_pos.unsafeKeys(x933rhs_idx.toInt)
val x933_sze: Int = __act.x933_hash_pos.size
val x933_idx: Int = __act.x933_hash_pos.put(x933_k)
if (x933_idx == x933_sze) { // new key
var x361: generated.scala.DeliteArrayAnon1415709433 = rhs.x933_hash_data
val x360: Int = x933rhs_idx
val x848 = x361.n_regionkey
val x849 = x361.count
val x850 = x848(x360.toInt)
val x851 = x849(x360.toInt)
val x852 = new generated.scala.Anon1415709433(x850,x851)
x361 = __act.x933_hash_data
val x358: generated.scala.Anon1415709433 = x852
val x861 = x933_sze
val x862 = x361.n_regionkey
val x863 = x862.length
val x864 = x863 - 1
val x865 = x861 > x864
val x885 = {
def x885thenb(): Unit = {
val x866 = x863 < 16
val x870 = {
def x870thenb(): Int = {
16
}
def x870elseb(): Int = {
val x867 = x863 * 2
val x868 = x867 < 0
val x869 = {
def x869thenb(): Int = {
2147483647
}
def x869elseb(): Int = {
x867
}
if (x868) {
x869thenb()
} else { 
x869elseb()
}
}
x869
}
if (x866) {
x870thenb()
} else { 
x870elseb()
}
}
if (x870 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x871 = new Array[Int](x870.toInt)
if (x870 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x872 = new Array[Int](x870.toInt)
val x873 = System.arraycopy(x862,0.toInt,x871,0.toInt,x863.toInt)
val x874 = x361.count
val x875 = System.arraycopy(x874,0.toInt,x872,0.toInt,x863.toInt)
val x373 = x358.n_regionkey
val x876 = x871(x861.toInt) = x373
val x376 = x358.count
val x877 = x872(x861.toInt) = x376
val x878 = new generated.scala.DeliteArrayAnon1415709433(x871,x872)
val x879 = __act.x933_hash_data = x878
x879
}
def x885elseb(): Unit = {
val x373 = x358.n_regionkey
val x881 = x361.n_regionkey(x861.toInt) = x373
val x882 = x361.count
val x376 = x358.count
val x883 = x361.count(x861.toInt) = x376
()
}
if (x865) {
x885thenb()
} else { 
x885elseb()
}
}
} else { // existing key
val x361: generated.scala.DeliteArrayAnon1415709433 = rhs.x933_hash_data
val x360: Int = x933rhs_idx
val x848 = x361.n_regionkey
val x849 = x361.count
val x850 = x848(x360.toInt)
val x851 = x849(x360.toInt)
val x852 = new generated.scala.Anon1415709433(x850,x851)
val x933_v: generated.scala.Anon1415709433 = x852
val x933_reduce_block: Unit = {
val x361: generated.scala.DeliteArrayAnon1415709433 = __act.x933_hash_data
val x360: Int = x933_idx
val x848 = x361.n_regionkey
val x849 = x361.count
val x850 = x848(x360.toInt)
val x851 = x849(x360.toInt)
val x852 = new generated.scala.Anon1415709433(x850,x851)
val x350: generated.scala.Anon1415709433 = x852
val x351: generated.scala.Anon1415709433 = x933_v
val x352 = x350.n_regionkey
val x354 = x350.count
val x355 = x351.count
val x356 = {
x354 + x355}
val x357 = new generated.scala.Anon1415709433(x352,x356)
val x358: generated.scala.Anon1415709433 = x357
val x854 = x361.n_regionkey
val x373 = x358.n_regionkey
val x855 = x361.n_regionkey(x360.toInt) = x373
val x856 = x361.count
val x376 = x358.count
val x857 = x361.count(x360.toInt) = x376
}
}
x933rhs_idx = x933rhs_idx+1
}
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x933,lhs:activation_x933): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x933): Unit = {
val tid: Int = resourceInfo.groupId
if (tid > 0) {
val all_acts: Array[activation_x933] = new Array[activation_x933](resourceInfo.groupSize)
var currentAct: activation_x933 = __act
var i: Int = tid
while(i >= 0) {
all_acts(i.toInt) = currentAct
currentAct.all_acts = all_acts
currentAct = currentAct.left_act
i = i-1
}
} else {
}
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x933): Unit = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
if (__act.all_acts ne null) {
val all_acts: Array[activation_x933] = __act.all_acts
val x933_globalKeys: Array[Int] = __act.all_acts(0).x933_hash_pos.unsafeKeys
var x933_idx: Int = ((__act.all_acts(0).x933_hash_pos.size).asInstanceOf[Long] * tid / numThreads).asInstanceOf[Int]
val x933_end: Int = ((__act.all_acts(0).x933_hash_pos.size).asInstanceOf[Long] * (tid+1) / numThreads).asInstanceOf[Int]
while (x933_idx < x933_end) {
x933_idx = x933_idx + 1
}
}
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x933): Unit = {
val x933_sze: Int = __act.x933_hash_pos.size
var x361: generated.scala.DeliteArrayAnon1415709433 = __act.x933_hash_data
val x359: Int = x933_sze
val x887 = x361.n_regionkey
val x888 = x887.length
val x889 = x888 > x359
val x898 = {
def x898thenb(): Unit = {
if (x359 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x890 = new Array[Int](x359.toInt)
if (x359 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x891 = new Array[Int](x359.toInt)
val x892 = System.arraycopy(x887,0.toInt,x890,0.toInt,x359.toInt)
val x893 = x361.count
val x894 = System.arraycopy(x893,0.toInt,x891,0.toInt,x359.toInt)
val x895 = new generated.scala.DeliteArrayAnon1415709433(x890,x891)
val x896 = x361 = x895
x896
}
if (x889) {
x898thenb()
}
}
__act.x933 = x361
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x933 = {
val act: activation_x933 = new activation_x933
act.x933_hash_pos = new generated.scala.container.HashMapImpl[Int](512,128)
act
}

}
x933_closure.loopStart = 0
x933_closure.loopSize = x2
val alloc: activation_x933 = x933_closure.alloc(resourceInfo)
var x933: activation_x933 = null
if (resourceInfo.availableThreads <= 1) {
x933 = x933_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x933] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x933](x933_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x933_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x933 = x933_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x933
}}

/**********/


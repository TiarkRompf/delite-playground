package generated.scala
//activation record for fat loop
final class activation_x3174x3604x3518x3561x3346x3389x3432x3475 {
var left_act: activation_x3174x3604x3518x3561x3346x3389x3432x3475 = _
var x3174: Array[Int] = _
var x3174_data: Array[Int] = _
var x3174_buf: Array[Int] = _
var x3174_size: Int = _
var x3174_offset: Int = _
var x3174_conditionals: Int = _
def x3174_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Int],cs:Int): Unit = {
x3174_data = xs
x3174_conditionals = cs
if (left_act ne null)
left_act.x3174_data_set(resourceInfo,xs,cs)
}

var x3604: Array[Int] = _
var x3604_data: Array[Int] = _
var x3604_buf: Array[Int] = _
var x3604_size: Int = _
var x3604_offset: Int = _
var x3604_conditionals: Int = _
def x3604_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Int],cs:Int): Unit = {
x3604_data = xs
x3604_conditionals = cs
if (left_act ne null)
left_act.x3604_data_set(resourceInfo,xs,cs)
}

var x3518: Array[java.lang.String] = _
var x3518_data: Array[java.lang.String] = _
var x3518_buf: Array[java.lang.String] = _
var x3518_size: Int = _
var x3518_offset: Int = _
var x3518_conditionals: Int = _
def x3518_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[java.lang.String],cs:Int): Unit = {
x3518_data = xs
x3518_conditionals = cs
if (left_act ne null)
left_act.x3518_data_set(resourceInfo,xs,cs)
}

var x3561: Array[java.lang.String] = _
var x3561_data: Array[java.lang.String] = _
var x3561_buf: Array[java.lang.String] = _
var x3561_size: Int = _
var x3561_offset: Int = _
var x3561_conditionals: Int = _
def x3561_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[java.lang.String],cs:Int): Unit = {
x3561_data = xs
x3561_conditionals = cs
if (left_act ne null)
left_act.x3561_data_set(resourceInfo,xs,cs)
}

var x3346: Array[Double] = _
var x3346_data: Array[Double] = _
var x3346_buf: Array[Double] = _
var x3346_size: Int = _
var x3346_offset: Int = _
var x3346_conditionals: Int = _
def x3346_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Double],cs:Int): Unit = {
x3346_data = xs
x3346_conditionals = cs
if (left_act ne null)
left_act.x3346_data_set(resourceInfo,xs,cs)
}

var x3389: Array[Double] = _
var x3389_data: Array[Double] = _
var x3389_buf: Array[Double] = _
var x3389_size: Int = _
var x3389_offset: Int = _
var x3389_conditionals: Int = _
def x3389_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Double],cs:Int): Unit = {
x3389_data = xs
x3389_conditionals = cs
if (left_act ne null)
left_act.x3389_data_set(resourceInfo,xs,cs)
}

var x3432: Array[Double] = _
var x3432_data: Array[Double] = _
var x3432_buf: Array[Double] = _
var x3432_size: Int = _
var x3432_offset: Int = _
var x3432_conditionals: Int = _
def x3432_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Double],cs:Int): Unit = {
x3432_data = xs
x3432_conditionals = cs
if (left_act ne null)
left_act.x3432_data_set(resourceInfo,xs,cs)
}

var x3475: Array[Double] = _
var x3475_data: Array[Double] = _
var x3475_buf: Array[Double] = _
var x3475_size: Int = _
var x3475_offset: Int = _
var x3475_conditionals: Int = _
def x3475_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Double],cs:Int): Unit = {
x3475_data = xs
x3475_conditionals = cs
if (left_act ne null)
left_act.x3475_data_set(resourceInfo,xs,cs)
}

}
object activation_x3174x3604x3518x3561x3346x3389x3432x3475 {
}
object kernel_x3174x3604x3518x3561x3346x3389x3432x3475 {
def apply(resourceInfo:generated.scala.ResourceInfo,x3:Long,x2:generated.scala.io.DeliteFileInputStream): activation_x3174x3604x3518x3561x3346x3389x3432x3475 = {
val x3174x3604x3518x3561x3346x3389x3432x3475_closure = new generated.scala.DeliteOpMultiLoop[activation_x3174x3604x3518x3561x3346x3389x3432x3475] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x3
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x3174x3604x3518x3561x3346x3389x3432x3475 = {
val __act: activation_x3174x3604x3518x3561x3346x3389x3432x3475 = new activation_x3174x3604x3518x3561x3346x3389x3432x3475()
// __act.x3174 stays null for now
// __act.x3604 stays null for now
// __act.x3518 stays null for now
// __act.x3561 stays null for now
// __act.x3346 stays null for now
// __act.x3389 stays null for now
// __act.x3432 stays null for now
// __act.x3475 stays null for now
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3174x3604x3518x3561x3346x3389x3432x3475,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x3174x3604x3518x3561x3346x3389x3432x3475]): activation_x3174x3604x3518x3561x3346x3389x3432x3475 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x3174x3604x3518x3561x3346x3389x3432x3475 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x3174x3604x3518x3561x3346x3389x3432x3475 = sync.get(localStart)
//post combine
if (tid != 0) postCombine(resourceInfo,act,sync.getP(tid-1))
var j: Int = localStart+1
var currentAct: activation_x3174x3604x3518x3561x3346x3389x3432x3475 = act
while (j < localEnd) {
val rhsAct: activation_x3174x3604x3518x3561x3346x3389x3432x3475 = sync.get(j)
postCombine(resourceInfo,rhsAct,currentAct)
currentAct = rhsAct
j = j+1
}
if (tid == numThreads-1) postProcInit(resourceInfo,currentAct)
sync.setP(tid, currentAct)
sync.awaitBarrier
//post process
var k: Int = localStart
while (k < localEnd) {
postProcess(resourceInfo,sync.get(k))
k = k+1
}
sync.awaitBarrier
if (tid == 0) {
finalize(resourceInfo,act)
}
act
}

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3174x3604x3518x3561x3346x3389x3432x3475): activation_x3174x3604x3518x3561x3346x3389x3432x3475 = {
val act: activation_x3174x3604x3518x3561x3346x3389x3432x3475 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
postProcInit(resourceInfo,act)
postProcess(resourceInfo,act)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3174x3604x3518x3561x3346x3389x3432x3475,start:Long,end:Long): activation_x3174x3604x3518x3561x3346x3389x3432x3475 = {
val x2_stream: generated.scala.io.DeliteFileInputStream = x2.openCopyAtNewLine(start)
val x2_stream_offset: Long = x2_stream.streamOffset
val isEmpty: Boolean = end <= x2_stream.position
val __act2: activation_x3174x3604x3518x3561x3346x3389x3432x3475 = init(resourceInfo,__act,-1,isEmpty,x2_stream)
while (x2_stream.position < x2_stream_offset + end) {
process(resourceInfo,__act2,-1,x2_stream)
}
x2_stream.close();
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3174x3604x3518x3561x3346x3389x3432x3475,x4:Int,isEmpty:Boolean,x2_stream:generated.scala.io.DeliteFileInputStream): activation_x3174x3604x3518x3561x3346x3389x3432x3475 = {
val __act2: activation_x3174x3604x3518x3561x3346x3389x3432x3475 = new activation_x3174x3604x3518x3561x3346x3389x3432x3475()
val x3134 = 0
if (x3134 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3138 = new Array[Int](x3134.toInt)
__act2.x3174_buf = x3138
val x3564 = 0
if (x3564 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3568 = new Array[Int](x3564.toInt)
__act2.x3604_buf = x3568
val x3478 = 0
if (x3478 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3482 = new Array[java.lang.String](x3478.toInt)
__act2.x3518_buf = x3482
val x3521 = 0
if (x3521 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3525 = new Array[java.lang.String](x3521.toInt)
__act2.x3561_buf = x3525
val x3306 = 0
if (x3306 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3310 = new Array[Double](x3306.toInt)
__act2.x3346_buf = x3310
val x3349 = 0
if (x3349 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3353 = new Array[Double](x3349.toInt)
__act2.x3389_buf = x3353
val x3392 = 0
if (x3392 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3396 = new Array[Double](x3392.toInt)
__act2.x3432_buf = x3396
val x3435 = 0
if (x3435 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3439 = new Array[Double](x3435.toInt)
__act2.x3475_buf = x3439
if (!isEmpty) {
val x5 = x2_stream.readLine()
val x6 = x5.split("\\|", -1)
val x7 = x6(0.toInt)
val x8 = {
x7.toInt}
val x25 = x6(10.toInt)
val x26 = x25.split("-", 0)
val x27 = x26(0.toInt)
val x28 = {
x27.toInt}
val x33 = {
x28 << 9}
val x31 = x26(2.toInt)
val x32 = {
x31.toInt}
val x29 = x26(1.toInt)
val x30 = {
x29.toInt}
val x34 = {
x30 << 5}
val x35 = x34 + x32
val x36 = x33 + x35
def x37_block = { 
x36
}
val x37 = x37_block
val x23 = x6(8.toInt)
val x24 = x6(9.toInt)
val x15 = x6(4.toInt)
val x16 = {
x15.toDouble}
val x17 = x6(5.toInt)
val x18 = {
x17.toDouble}
val x19 = x6(6.toInt)
val x20 = {
x19.toDouble}
val x21 = x6(7.toInt)
val x22 = {
x21.toDouble}
val x3132 = __act2.x3174_buf
val x3133 = x8
if (true) {
val x3144 = __act2.x3174_size
val x3145 = x3132.length
val x3146 = x3145 - 1
val x3147 = x3144 > x3146
val x3160 = {
def x3160thenb(): Unit = {
val x3148 = x3145 < 16
val x3152 = {
def x3152thenb(): Int = {
16
}
def x3152elseb(): Int = {
val x3149 = x3145 * 2
val x3150 = x3149 < 0
val x3151 = {
def x3151thenb(): Int = {
2147483647
}
def x3151elseb(): Int = {
x3149
}
if (x3150) {
x3151thenb()
} else { 
x3151elseb()
}
}
x3151
}
if (x3148) {
x3152thenb()
} else { 
x3152elseb()
}
}
if (x3152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3153 = new Array[Int](x3152.toInt)
val x3154 = System.arraycopy(x3132,0.toInt,x3153,0.toInt,x3145.toInt)
val x3155 = x3153(x3144.toInt) = x3133
val x3156 = __act2.x3174_buf = x3153
x3156
}
def x3160elseb(): Unit = {
val x3158 = x3132(x3144.toInt) = x3133
x3158
}
if (x3147) {
x3160thenb()
} else { 
x3160elseb()
}
}
__act2.x3174_size = __act2.x3174_size + 1
}
__act2.x3174_conditionals = __act2.x3174_conditionals + 1
val x3562 = __act2.x3604_buf
val x3563 = x37
if (true) {
val x3574 = __act2.x3604_size
val x3575 = x3562.length
val x3576 = x3575 - 1
val x3577 = x3574 > x3576
val x3590 = {
def x3590thenb(): Unit = {
val x3578 = x3575 < 16
val x3582 = {
def x3582thenb(): Int = {
16
}
def x3582elseb(): Int = {
val x3579 = x3575 * 2
val x3580 = x3579 < 0
val x3581 = {
def x3581thenb(): Int = {
2147483647
}
def x3581elseb(): Int = {
x3579
}
if (x3580) {
x3581thenb()
} else { 
x3581elseb()
}
}
x3581
}
if (x3578) {
x3582thenb()
} else { 
x3582elseb()
}
}
if (x3582 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3583 = new Array[Int](x3582.toInt)
val x3584 = System.arraycopy(x3562,0.toInt,x3583,0.toInt,x3575.toInt)
val x3585 = x3583(x3574.toInt) = x3563
val x3586 = __act2.x3604_buf = x3583
x3586
}
def x3590elseb(): Unit = {
val x3588 = x3562(x3574.toInt) = x3563
x3588
}
if (x3577) {
x3590thenb()
} else { 
x3590elseb()
}
}
__act2.x3604_size = __act2.x3604_size + 1
}
__act2.x3604_conditionals = __act2.x3604_conditionals + 1
val x3476 = __act2.x3518_buf
val x3477 = x23
if (true) {
val x3488 = __act2.x3518_size
val x3489 = x3476.length
val x3490 = x3489 - 1
val x3491 = x3488 > x3490
val x3504 = {
def x3504thenb(): Unit = {
val x3492 = x3489 < 16
val x3496 = {
def x3496thenb(): Int = {
16
}
def x3496elseb(): Int = {
val x3493 = x3489 * 2
val x3494 = x3493 < 0
val x3495 = {
def x3495thenb(): Int = {
2147483647
}
def x3495elseb(): Int = {
x3493
}
if (x3494) {
x3495thenb()
} else { 
x3495elseb()
}
}
x3495
}
if (x3492) {
x3496thenb()
} else { 
x3496elseb()
}
}
if (x3496 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3497 = new Array[java.lang.String](x3496.toInt)
val x3498 = System.arraycopy(x3476,0.toInt,x3497,0.toInt,x3489.toInt)
val x3499 = x3497(x3488.toInt) = x3477
val x3500 = __act2.x3518_buf = x3497
x3500
}
def x3504elseb(): Unit = {
val x3502 = x3476(x3488.toInt) = x3477
x3502
}
if (x3491) {
x3504thenb()
} else { 
x3504elseb()
}
}
__act2.x3518_size = __act2.x3518_size + 1
}
__act2.x3518_conditionals = __act2.x3518_conditionals + 1
val x3519 = __act2.x3561_buf
val x3520 = x24
if (true) {
val x3531 = __act2.x3561_size
val x3532 = x3519.length
val x3533 = x3532 - 1
val x3534 = x3531 > x3533
val x3547 = {
def x3547thenb(): Unit = {
val x3535 = x3532 < 16
val x3539 = {
def x3539thenb(): Int = {
16
}
def x3539elseb(): Int = {
val x3536 = x3532 * 2
val x3537 = x3536 < 0
val x3538 = {
def x3538thenb(): Int = {
2147483647
}
def x3538elseb(): Int = {
x3536
}
if (x3537) {
x3538thenb()
} else { 
x3538elseb()
}
}
x3538
}
if (x3535) {
x3539thenb()
} else { 
x3539elseb()
}
}
if (x3539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3540 = new Array[java.lang.String](x3539.toInt)
val x3541 = System.arraycopy(x3519,0.toInt,x3540,0.toInt,x3532.toInt)
val x3542 = x3540(x3531.toInt) = x3520
val x3543 = __act2.x3561_buf = x3540
x3543
}
def x3547elseb(): Unit = {
val x3545 = x3519(x3531.toInt) = x3520
x3545
}
if (x3534) {
x3547thenb()
} else { 
x3547elseb()
}
}
__act2.x3561_size = __act2.x3561_size + 1
}
__act2.x3561_conditionals = __act2.x3561_conditionals + 1
val x3304 = __act2.x3346_buf
val x3305 = x16
if (true) {
val x3316 = __act2.x3346_size
val x3317 = x3304.length
val x3318 = x3317 - 1
val x3319 = x3316 > x3318
val x3332 = {
def x3332thenb(): Unit = {
val x3320 = x3317 < 16
val x3324 = {
def x3324thenb(): Int = {
16
}
def x3324elseb(): Int = {
val x3321 = x3317 * 2
val x3322 = x3321 < 0
val x3323 = {
def x3323thenb(): Int = {
2147483647
}
def x3323elseb(): Int = {
x3321
}
if (x3322) {
x3323thenb()
} else { 
x3323elseb()
}
}
x3323
}
if (x3320) {
x3324thenb()
} else { 
x3324elseb()
}
}
if (x3324 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3325 = new Array[Double](x3324.toInt)
val x3326 = System.arraycopy(x3304,0.toInt,x3325,0.toInt,x3317.toInt)
val x3327 = x3325(x3316.toInt) = x3305
val x3328 = __act2.x3346_buf = x3325
x3328
}
def x3332elseb(): Unit = {
val x3330 = x3304(x3316.toInt) = x3305
x3330
}
if (x3319) {
x3332thenb()
} else { 
x3332elseb()
}
}
__act2.x3346_size = __act2.x3346_size + 1
}
__act2.x3346_conditionals = __act2.x3346_conditionals + 1
val x3347 = __act2.x3389_buf
val x3348 = x18
if (true) {
val x3359 = __act2.x3389_size
val x3360 = x3347.length
val x3361 = x3360 - 1
val x3362 = x3359 > x3361
val x3375 = {
def x3375thenb(): Unit = {
val x3363 = x3360 < 16
val x3367 = {
def x3367thenb(): Int = {
16
}
def x3367elseb(): Int = {
val x3364 = x3360 * 2
val x3365 = x3364 < 0
val x3366 = {
def x3366thenb(): Int = {
2147483647
}
def x3366elseb(): Int = {
x3364
}
if (x3365) {
x3366thenb()
} else { 
x3366elseb()
}
}
x3366
}
if (x3363) {
x3367thenb()
} else { 
x3367elseb()
}
}
if (x3367 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3368 = new Array[Double](x3367.toInt)
val x3369 = System.arraycopy(x3347,0.toInt,x3368,0.toInt,x3360.toInt)
val x3370 = x3368(x3359.toInt) = x3348
val x3371 = __act2.x3389_buf = x3368
x3371
}
def x3375elseb(): Unit = {
val x3373 = x3347(x3359.toInt) = x3348
x3373
}
if (x3362) {
x3375thenb()
} else { 
x3375elseb()
}
}
__act2.x3389_size = __act2.x3389_size + 1
}
__act2.x3389_conditionals = __act2.x3389_conditionals + 1
val x3390 = __act2.x3432_buf
val x3391 = x20
if (true) {
val x3402 = __act2.x3432_size
val x3403 = x3390.length
val x3404 = x3403 - 1
val x3405 = x3402 > x3404
val x3418 = {
def x3418thenb(): Unit = {
val x3406 = x3403 < 16
val x3410 = {
def x3410thenb(): Int = {
16
}
def x3410elseb(): Int = {
val x3407 = x3403 * 2
val x3408 = x3407 < 0
val x3409 = {
def x3409thenb(): Int = {
2147483647
}
def x3409elseb(): Int = {
x3407
}
if (x3408) {
x3409thenb()
} else { 
x3409elseb()
}
}
x3409
}
if (x3406) {
x3410thenb()
} else { 
x3410elseb()
}
}
if (x3410 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3411 = new Array[Double](x3410.toInt)
val x3412 = System.arraycopy(x3390,0.toInt,x3411,0.toInt,x3403.toInt)
val x3413 = x3411(x3402.toInt) = x3391
val x3414 = __act2.x3432_buf = x3411
x3414
}
def x3418elseb(): Unit = {
val x3416 = x3390(x3402.toInt) = x3391
x3416
}
if (x3405) {
x3418thenb()
} else { 
x3418elseb()
}
}
__act2.x3432_size = __act2.x3432_size + 1
}
__act2.x3432_conditionals = __act2.x3432_conditionals + 1
val x3433 = __act2.x3475_buf
val x3434 = x22
if (true) {
val x3445 = __act2.x3475_size
val x3446 = x3433.length
val x3447 = x3446 - 1
val x3448 = x3445 > x3447
val x3461 = {
def x3461thenb(): Unit = {
val x3449 = x3446 < 16
val x3453 = {
def x3453thenb(): Int = {
16
}
def x3453elseb(): Int = {
val x3450 = x3446 * 2
val x3451 = x3450 < 0
val x3452 = {
def x3452thenb(): Int = {
2147483647
}
def x3452elseb(): Int = {
x3450
}
if (x3451) {
x3452thenb()
} else { 
x3452elseb()
}
}
x3452
}
if (x3449) {
x3453thenb()
} else { 
x3453elseb()
}
}
if (x3453 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3454 = new Array[Double](x3453.toInt)
val x3455 = System.arraycopy(x3433,0.toInt,x3454,0.toInt,x3446.toInt)
val x3456 = x3454(x3445.toInt) = x3434
val x3457 = __act2.x3475_buf = x3454
x3457
}
def x3461elseb(): Unit = {
val x3459 = x3433(x3445.toInt) = x3434
x3459
}
if (x3448) {
x3461thenb()
} else { 
x3461elseb()
}
}
__act2.x3475_size = __act2.x3475_size + 1
}
__act2.x3475_conditionals = __act2.x3475_conditionals + 1
}
__act2
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3174x3604x3518x3561x3346x3389x3432x3475,x4:Int,x2_stream:generated.scala.io.DeliteFileInputStream): Unit = {
val x5 = x2_stream.readLine()
val x6 = x5.split("\\|", -1)
val x7 = x6(0.toInt)
val x8 = {
x7.toInt}
val x25 = x6(10.toInt)
val x26 = x25.split("-", 0)
val x27 = x26(0.toInt)
val x28 = {
x27.toInt}
val x33 = {
x28 << 9}
val x31 = x26(2.toInt)
val x32 = {
x31.toInt}
val x29 = x26(1.toInt)
val x30 = {
x29.toInt}
val x34 = {
x30 << 5}
val x35 = x34 + x32
val x36 = x33 + x35
def x37_block = { 
x36
}
val x37 = x37_block
val x23 = x6(8.toInt)
val x24 = x6(9.toInt)
val x15 = x6(4.toInt)
val x16 = {
x15.toDouble}
val x17 = x6(5.toInt)
val x18 = {
x17.toDouble}
val x19 = x6(6.toInt)
val x20 = {
x19.toDouble}
val x21 = x6(7.toInt)
val x22 = {
x21.toDouble}
val x3132 = __act.x3174_buf
val x3133 = x8
if (true) {
val x3144 = __act.x3174_size
val x3145 = x3132.length
val x3146 = x3145 - 1
val x3147 = x3144 > x3146
val x3160 = {
def x3160thenb(): Unit = {
val x3148 = x3145 < 16
val x3152 = {
def x3152thenb(): Int = {
16
}
def x3152elseb(): Int = {
val x3149 = x3145 * 2
val x3150 = x3149 < 0
val x3151 = {
def x3151thenb(): Int = {
2147483647
}
def x3151elseb(): Int = {
x3149
}
if (x3150) {
x3151thenb()
} else { 
x3151elseb()
}
}
x3151
}
if (x3148) {
x3152thenb()
} else { 
x3152elseb()
}
}
if (x3152 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3153 = new Array[Int](x3152.toInt)
val x3154 = System.arraycopy(x3132,0.toInt,x3153,0.toInt,x3145.toInt)
val x3155 = x3153(x3144.toInt) = x3133
val x3156 = __act.x3174_buf = x3153
x3156
}
def x3160elseb(): Unit = {
val x3158 = x3132(x3144.toInt) = x3133
x3158
}
if (x3147) {
x3160thenb()
} else { 
x3160elseb()
}
}
__act.x3174_size = __act.x3174_size + 1
}
__act.x3174_conditionals = __act.x3174_conditionals + 1
val x3562 = __act.x3604_buf
val x3563 = x37
if (true) {
val x3574 = __act.x3604_size
val x3575 = x3562.length
val x3576 = x3575 - 1
val x3577 = x3574 > x3576
val x3590 = {
def x3590thenb(): Unit = {
val x3578 = x3575 < 16
val x3582 = {
def x3582thenb(): Int = {
16
}
def x3582elseb(): Int = {
val x3579 = x3575 * 2
val x3580 = x3579 < 0
val x3581 = {
def x3581thenb(): Int = {
2147483647
}
def x3581elseb(): Int = {
x3579
}
if (x3580) {
x3581thenb()
} else { 
x3581elseb()
}
}
x3581
}
if (x3578) {
x3582thenb()
} else { 
x3582elseb()
}
}
if (x3582 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3583 = new Array[Int](x3582.toInt)
val x3584 = System.arraycopy(x3562,0.toInt,x3583,0.toInt,x3575.toInt)
val x3585 = x3583(x3574.toInt) = x3563
val x3586 = __act.x3604_buf = x3583
x3586
}
def x3590elseb(): Unit = {
val x3588 = x3562(x3574.toInt) = x3563
x3588
}
if (x3577) {
x3590thenb()
} else { 
x3590elseb()
}
}
__act.x3604_size = __act.x3604_size + 1
}
__act.x3604_conditionals = __act.x3604_conditionals + 1
val x3476 = __act.x3518_buf
val x3477 = x23
if (true) {
val x3488 = __act.x3518_size
val x3489 = x3476.length
val x3490 = x3489 - 1
val x3491 = x3488 > x3490
val x3504 = {
def x3504thenb(): Unit = {
val x3492 = x3489 < 16
val x3496 = {
def x3496thenb(): Int = {
16
}
def x3496elseb(): Int = {
val x3493 = x3489 * 2
val x3494 = x3493 < 0
val x3495 = {
def x3495thenb(): Int = {
2147483647
}
def x3495elseb(): Int = {
x3493
}
if (x3494) {
x3495thenb()
} else { 
x3495elseb()
}
}
x3495
}
if (x3492) {
x3496thenb()
} else { 
x3496elseb()
}
}
if (x3496 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3497 = new Array[java.lang.String](x3496.toInt)
val x3498 = System.arraycopy(x3476,0.toInt,x3497,0.toInt,x3489.toInt)
val x3499 = x3497(x3488.toInt) = x3477
val x3500 = __act.x3518_buf = x3497
x3500
}
def x3504elseb(): Unit = {
val x3502 = x3476(x3488.toInt) = x3477
x3502
}
if (x3491) {
x3504thenb()
} else { 
x3504elseb()
}
}
__act.x3518_size = __act.x3518_size + 1
}
__act.x3518_conditionals = __act.x3518_conditionals + 1
val x3519 = __act.x3561_buf
val x3520 = x24
if (true) {
val x3531 = __act.x3561_size
val x3532 = x3519.length
val x3533 = x3532 - 1
val x3534 = x3531 > x3533
val x3547 = {
def x3547thenb(): Unit = {
val x3535 = x3532 < 16
val x3539 = {
def x3539thenb(): Int = {
16
}
def x3539elseb(): Int = {
val x3536 = x3532 * 2
val x3537 = x3536 < 0
val x3538 = {
def x3538thenb(): Int = {
2147483647
}
def x3538elseb(): Int = {
x3536
}
if (x3537) {
x3538thenb()
} else { 
x3538elseb()
}
}
x3538
}
if (x3535) {
x3539thenb()
} else { 
x3539elseb()
}
}
if (x3539 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3540 = new Array[java.lang.String](x3539.toInt)
val x3541 = System.arraycopy(x3519,0.toInt,x3540,0.toInt,x3532.toInt)
val x3542 = x3540(x3531.toInt) = x3520
val x3543 = __act.x3561_buf = x3540
x3543
}
def x3547elseb(): Unit = {
val x3545 = x3519(x3531.toInt) = x3520
x3545
}
if (x3534) {
x3547thenb()
} else { 
x3547elseb()
}
}
__act.x3561_size = __act.x3561_size + 1
}
__act.x3561_conditionals = __act.x3561_conditionals + 1
val x3304 = __act.x3346_buf
val x3305 = x16
if (true) {
val x3316 = __act.x3346_size
val x3317 = x3304.length
val x3318 = x3317 - 1
val x3319 = x3316 > x3318
val x3332 = {
def x3332thenb(): Unit = {
val x3320 = x3317 < 16
val x3324 = {
def x3324thenb(): Int = {
16
}
def x3324elseb(): Int = {
val x3321 = x3317 * 2
val x3322 = x3321 < 0
val x3323 = {
def x3323thenb(): Int = {
2147483647
}
def x3323elseb(): Int = {
x3321
}
if (x3322) {
x3323thenb()
} else { 
x3323elseb()
}
}
x3323
}
if (x3320) {
x3324thenb()
} else { 
x3324elseb()
}
}
if (x3324 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3325 = new Array[Double](x3324.toInt)
val x3326 = System.arraycopy(x3304,0.toInt,x3325,0.toInt,x3317.toInt)
val x3327 = x3325(x3316.toInt) = x3305
val x3328 = __act.x3346_buf = x3325
x3328
}
def x3332elseb(): Unit = {
val x3330 = x3304(x3316.toInt) = x3305
x3330
}
if (x3319) {
x3332thenb()
} else { 
x3332elseb()
}
}
__act.x3346_size = __act.x3346_size + 1
}
__act.x3346_conditionals = __act.x3346_conditionals + 1
val x3347 = __act.x3389_buf
val x3348 = x18
if (true) {
val x3359 = __act.x3389_size
val x3360 = x3347.length
val x3361 = x3360 - 1
val x3362 = x3359 > x3361
val x3375 = {
def x3375thenb(): Unit = {
val x3363 = x3360 < 16
val x3367 = {
def x3367thenb(): Int = {
16
}
def x3367elseb(): Int = {
val x3364 = x3360 * 2
val x3365 = x3364 < 0
val x3366 = {
def x3366thenb(): Int = {
2147483647
}
def x3366elseb(): Int = {
x3364
}
if (x3365) {
x3366thenb()
} else { 
x3366elseb()
}
}
x3366
}
if (x3363) {
x3367thenb()
} else { 
x3367elseb()
}
}
if (x3367 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3368 = new Array[Double](x3367.toInt)
val x3369 = System.arraycopy(x3347,0.toInt,x3368,0.toInt,x3360.toInt)
val x3370 = x3368(x3359.toInt) = x3348
val x3371 = __act.x3389_buf = x3368
x3371
}
def x3375elseb(): Unit = {
val x3373 = x3347(x3359.toInt) = x3348
x3373
}
if (x3362) {
x3375thenb()
} else { 
x3375elseb()
}
}
__act.x3389_size = __act.x3389_size + 1
}
__act.x3389_conditionals = __act.x3389_conditionals + 1
val x3390 = __act.x3432_buf
val x3391 = x20
if (true) {
val x3402 = __act.x3432_size
val x3403 = x3390.length
val x3404 = x3403 - 1
val x3405 = x3402 > x3404
val x3418 = {
def x3418thenb(): Unit = {
val x3406 = x3403 < 16
val x3410 = {
def x3410thenb(): Int = {
16
}
def x3410elseb(): Int = {
val x3407 = x3403 * 2
val x3408 = x3407 < 0
val x3409 = {
def x3409thenb(): Int = {
2147483647
}
def x3409elseb(): Int = {
x3407
}
if (x3408) {
x3409thenb()
} else { 
x3409elseb()
}
}
x3409
}
if (x3406) {
x3410thenb()
} else { 
x3410elseb()
}
}
if (x3410 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3411 = new Array[Double](x3410.toInt)
val x3412 = System.arraycopy(x3390,0.toInt,x3411,0.toInt,x3403.toInt)
val x3413 = x3411(x3402.toInt) = x3391
val x3414 = __act.x3432_buf = x3411
x3414
}
def x3418elseb(): Unit = {
val x3416 = x3390(x3402.toInt) = x3391
x3416
}
if (x3405) {
x3418thenb()
} else { 
x3418elseb()
}
}
__act.x3432_size = __act.x3432_size + 1
}
__act.x3432_conditionals = __act.x3432_conditionals + 1
val x3433 = __act.x3475_buf
val x3434 = x22
if (true) {
val x3445 = __act.x3475_size
val x3446 = x3433.length
val x3447 = x3446 - 1
val x3448 = x3445 > x3447
val x3461 = {
def x3461thenb(): Unit = {
val x3449 = x3446 < 16
val x3453 = {
def x3453thenb(): Int = {
16
}
def x3453elseb(): Int = {
val x3450 = x3446 * 2
val x3451 = x3450 < 0
val x3452 = {
def x3452thenb(): Int = {
2147483647
}
def x3452elseb(): Int = {
x3450
}
if (x3451) {
x3452thenb()
} else { 
x3452elseb()
}
}
x3452
}
if (x3449) {
x3453thenb()
} else { 
x3453elseb()
}
}
if (x3453 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3454 = new Array[Double](x3453.toInt)
val x3455 = System.arraycopy(x3433,0.toInt,x3454,0.toInt,x3446.toInt)
val x3456 = x3454(x3445.toInt) = x3434
val x3457 = __act.x3475_buf = x3454
x3457
}
def x3461elseb(): Unit = {
val x3459 = x3433(x3445.toInt) = x3434
x3459
}
if (x3448) {
x3461thenb()
} else { 
x3461elseb()
}
}
__act.x3475_size = __act.x3475_size + 1
}
__act.x3475_conditionals = __act.x3475_conditionals + 1
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3174x3604x3518x3561x3346x3389x3432x3475,rhs:activation_x3174x3604x3518x3561x3346x3389x3432x3475): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3174x3604x3518x3561x3346x3389x3432x3475,lhs:activation_x3174x3604x3518x3561x3346x3389x3432x3475): Unit = {
__act.x3174_offset = lhs.x3174_offset+lhs.x3174_size
__act.x3174_conditionals = __act.x3174_conditionals+lhs.x3174_conditionals
__act.x3604_offset = lhs.x3604_offset+lhs.x3604_size
__act.x3604_conditionals = __act.x3604_conditionals+lhs.x3604_conditionals
__act.x3518_offset = lhs.x3518_offset+lhs.x3518_size
__act.x3518_conditionals = __act.x3518_conditionals+lhs.x3518_conditionals
__act.x3561_offset = lhs.x3561_offset+lhs.x3561_size
__act.x3561_conditionals = __act.x3561_conditionals+lhs.x3561_conditionals
__act.x3346_offset = lhs.x3346_offset+lhs.x3346_size
__act.x3346_conditionals = __act.x3346_conditionals+lhs.x3346_conditionals
__act.x3389_offset = lhs.x3389_offset+lhs.x3389_size
__act.x3389_conditionals = __act.x3389_conditionals+lhs.x3389_conditionals
__act.x3432_offset = lhs.x3432_offset+lhs.x3432_size
__act.x3432_conditionals = __act.x3432_conditionals+lhs.x3432_conditionals
__act.x3475_offset = lhs.x3475_offset+lhs.x3475_size
__act.x3475_conditionals = __act.x3475_conditionals+lhs.x3475_conditionals
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3174x3604x3518x3561x3346x3389x3432x3475): Unit = {
if (__act.x3174_offset > 0) {
val x3134 = __act.x3174_offset + __act.x3174_size
val x3132 = __act.x3174_buf
if (x3134 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3170 = new Array[Int](x3134.toInt)
__act.x3174_data_set(resourceInfo,x3170,__act.x3174_conditionals)
} else {
__act.x3174_data_set(resourceInfo,__act.x3174_buf,__act.x3174_conditionals)
}
if (__act.x3604_offset > 0) {
val x3564 = __act.x3604_offset + __act.x3604_size
val x3562 = __act.x3604_buf
if (x3564 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3600 = new Array[Int](x3564.toInt)
__act.x3604_data_set(resourceInfo,x3600,__act.x3604_conditionals)
} else {
__act.x3604_data_set(resourceInfo,__act.x3604_buf,__act.x3604_conditionals)
}
if (__act.x3518_offset > 0) {
val x3478 = __act.x3518_offset + __act.x3518_size
val x3476 = __act.x3518_buf
if (x3478 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3514 = new Array[java.lang.String](x3478.toInt)
__act.x3518_data_set(resourceInfo,x3514,__act.x3518_conditionals)
} else {
__act.x3518_data_set(resourceInfo,__act.x3518_buf,__act.x3518_conditionals)
}
if (__act.x3561_offset > 0) {
val x3521 = __act.x3561_offset + __act.x3561_size
val x3519 = __act.x3561_buf
if (x3521 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3557 = new Array[java.lang.String](x3521.toInt)
__act.x3561_data_set(resourceInfo,x3557,__act.x3561_conditionals)
} else {
__act.x3561_data_set(resourceInfo,__act.x3561_buf,__act.x3561_conditionals)
}
if (__act.x3346_offset > 0) {
val x3306 = __act.x3346_offset + __act.x3346_size
val x3304 = __act.x3346_buf
if (x3306 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3342 = new Array[Double](x3306.toInt)
__act.x3346_data_set(resourceInfo,x3342,__act.x3346_conditionals)
} else {
__act.x3346_data_set(resourceInfo,__act.x3346_buf,__act.x3346_conditionals)
}
if (__act.x3389_offset > 0) {
val x3349 = __act.x3389_offset + __act.x3389_size
val x3347 = __act.x3389_buf
if (x3349 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3385 = new Array[Double](x3349.toInt)
__act.x3389_data_set(resourceInfo,x3385,__act.x3389_conditionals)
} else {
__act.x3389_data_set(resourceInfo,__act.x3389_buf,__act.x3389_conditionals)
}
if (__act.x3432_offset > 0) {
val x3392 = __act.x3432_offset + __act.x3432_size
val x3390 = __act.x3432_buf
if (x3392 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3428 = new Array[Double](x3392.toInt)
__act.x3432_data_set(resourceInfo,x3428,__act.x3432_conditionals)
} else {
__act.x3432_data_set(resourceInfo,__act.x3432_buf,__act.x3432_conditionals)
}
if (__act.x3475_offset > 0) {
val x3435 = __act.x3475_offset + __act.x3475_size
val x3433 = __act.x3475_buf
if (x3435 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3471 = new Array[Double](x3435.toInt)
__act.x3475_data_set(resourceInfo,x3471,__act.x3475_conditionals)
} else {
__act.x3475_data_set(resourceInfo,__act.x3475_buf,__act.x3475_conditionals)
}
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3174x3604x3518x3561x3346x3389x3432x3475): Unit = {
if (__act.x3174_data ne __act.x3174_buf) {
val x3134 = __act.x3174_size
val x3135 = __act.x3174_buf
val x3132 = __act.x3174_data
val x3136 = 0
val x3137 = __act.x3174_offset
val x3172 = System.arraycopy(x3135,x3136.toInt,x3132,x3137.toInt,x3134.toInt)
}
__act.x3174_buf = null
if (__act.x3604_data ne __act.x3604_buf) {
val x3564 = __act.x3604_size
val x3565 = __act.x3604_buf
val x3562 = __act.x3604_data
val x3566 = 0
val x3567 = __act.x3604_offset
val x3602 = System.arraycopy(x3565,x3566.toInt,x3562,x3567.toInt,x3564.toInt)
}
__act.x3604_buf = null
if (__act.x3518_data ne __act.x3518_buf) {
val x3478 = __act.x3518_size
val x3479 = __act.x3518_buf
val x3476 = __act.x3518_data
val x3480 = 0
val x3481 = __act.x3518_offset
val x3516 = System.arraycopy(x3479,x3480.toInt,x3476,x3481.toInt,x3478.toInt)
}
__act.x3518_buf = null
if (__act.x3561_data ne __act.x3561_buf) {
val x3521 = __act.x3561_size
val x3522 = __act.x3561_buf
val x3519 = __act.x3561_data
val x3523 = 0
val x3524 = __act.x3561_offset
val x3559 = System.arraycopy(x3522,x3523.toInt,x3519,x3524.toInt,x3521.toInt)
}
__act.x3561_buf = null
if (__act.x3346_data ne __act.x3346_buf) {
val x3306 = __act.x3346_size
val x3307 = __act.x3346_buf
val x3304 = __act.x3346_data
val x3308 = 0
val x3309 = __act.x3346_offset
val x3344 = System.arraycopy(x3307,x3308.toInt,x3304,x3309.toInt,x3306.toInt)
}
__act.x3346_buf = null
if (__act.x3389_data ne __act.x3389_buf) {
val x3349 = __act.x3389_size
val x3350 = __act.x3389_buf
val x3347 = __act.x3389_data
val x3351 = 0
val x3352 = __act.x3389_offset
val x3387 = System.arraycopy(x3350,x3351.toInt,x3347,x3352.toInt,x3349.toInt)
}
__act.x3389_buf = null
if (__act.x3432_data ne __act.x3432_buf) {
val x3392 = __act.x3432_size
val x3393 = __act.x3432_buf
val x3390 = __act.x3432_data
val x3394 = 0
val x3395 = __act.x3432_offset
val x3430 = System.arraycopy(x3393,x3394.toInt,x3390,x3395.toInt,x3392.toInt)
}
__act.x3432_buf = null
if (__act.x3475_data ne __act.x3475_buf) {
val x3435 = __act.x3475_size
val x3436 = __act.x3475_buf
val x3433 = __act.x3475_data
val x3437 = 0
val x3438 = __act.x3475_offset
val x3473 = System.arraycopy(x3436,x3437.toInt,x3433,x3438.toInt,x3435.toInt)
}
__act.x3475_buf = null
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3174x3604x3518x3561x3346x3389x3432x3475): Unit = {
var x3132: Array[Int] = __act.x3174_data
__act.x3174_data = null
val x3134 = __act.x3174_conditionals
val x3162 = x3132.length
val x3163 = x3162 > x3134
val x3168 = {
def x3168thenb(): Unit = {
if (x3134 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3164 = new Array[Int](x3134.toInt)
val x3165 = System.arraycopy(x3132,0.toInt,x3164,0.toInt,x3134.toInt)
val x3166 = x3132 = x3164
x3166
}
if (x3163) {
x3168thenb()
}
}
__act.x3174 = x3132
var x3562: Array[Int] = __act.x3604_data
__act.x3604_data = null
val x3564 = __act.x3604_conditionals
val x3592 = x3562.length
val x3593 = x3592 > x3564
val x3598 = {
def x3598thenb(): Unit = {
if (x3564 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3594 = new Array[Int](x3564.toInt)
val x3595 = System.arraycopy(x3562,0.toInt,x3594,0.toInt,x3564.toInt)
val x3596 = x3562 = x3594
x3596
}
if (x3593) {
x3598thenb()
}
}
__act.x3604 = x3562
var x3476: Array[java.lang.String] = __act.x3518_data
__act.x3518_data = null
val x3478 = __act.x3518_conditionals
val x3506 = x3476.length
val x3507 = x3506 > x3478
val x3512 = {
def x3512thenb(): Unit = {
if (x3478 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3508 = new Array[java.lang.String](x3478.toInt)
val x3509 = System.arraycopy(x3476,0.toInt,x3508,0.toInt,x3478.toInt)
val x3510 = x3476 = x3508
x3510
}
if (x3507) {
x3512thenb()
}
}
__act.x3518 = x3476
var x3519: Array[java.lang.String] = __act.x3561_data
__act.x3561_data = null
val x3521 = __act.x3561_conditionals
val x3549 = x3519.length
val x3550 = x3549 > x3521
val x3555 = {
def x3555thenb(): Unit = {
if (x3521 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3551 = new Array[java.lang.String](x3521.toInt)
val x3552 = System.arraycopy(x3519,0.toInt,x3551,0.toInt,x3521.toInt)
val x3553 = x3519 = x3551
x3553
}
if (x3550) {
x3555thenb()
}
}
__act.x3561 = x3519
var x3304: Array[Double] = __act.x3346_data
__act.x3346_data = null
val x3306 = __act.x3346_conditionals
val x3334 = x3304.length
val x3335 = x3334 > x3306
val x3340 = {
def x3340thenb(): Unit = {
if (x3306 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3336 = new Array[Double](x3306.toInt)
val x3337 = System.arraycopy(x3304,0.toInt,x3336,0.toInt,x3306.toInt)
val x3338 = x3304 = x3336
x3338
}
if (x3335) {
x3340thenb()
}
}
__act.x3346 = x3304
var x3347: Array[Double] = __act.x3389_data
__act.x3389_data = null
val x3349 = __act.x3389_conditionals
val x3377 = x3347.length
val x3378 = x3377 > x3349
val x3383 = {
def x3383thenb(): Unit = {
if (x3349 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3379 = new Array[Double](x3349.toInt)
val x3380 = System.arraycopy(x3347,0.toInt,x3379,0.toInt,x3349.toInt)
val x3381 = x3347 = x3379
x3381
}
if (x3378) {
x3383thenb()
}
}
__act.x3389 = x3347
var x3390: Array[Double] = __act.x3432_data
__act.x3432_data = null
val x3392 = __act.x3432_conditionals
val x3420 = x3390.length
val x3421 = x3420 > x3392
val x3426 = {
def x3426thenb(): Unit = {
if (x3392 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3422 = new Array[Double](x3392.toInt)
val x3423 = System.arraycopy(x3390,0.toInt,x3422,0.toInt,x3392.toInt)
val x3424 = x3390 = x3422
x3424
}
if (x3421) {
x3426thenb()
}
}
__act.x3432 = x3390
var x3433: Array[Double] = __act.x3475_data
__act.x3475_data = null
val x3435 = __act.x3475_conditionals
val x3463 = x3433.length
val x3464 = x3463 > x3435
val x3469 = {
def x3469thenb(): Unit = {
if (x3435 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x3465 = new Array[Double](x3435.toInt)
val x3466 = System.arraycopy(x3433,0.toInt,x3465,0.toInt,x3435.toInt)
val x3467 = x3433 = x3465
x3467
}
if (x3464) {
x3469thenb()
}
}
__act.x3475 = x3433
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x3174x3604x3518x3561x3346x3389x3432x3475 = {
val act: activation_x3174x3604x3518x3561x3346x3389x3432x3475 = new activation_x3174x3604x3518x3561x3346x3389x3432x3475
act
}

}
x3174x3604x3518x3561x3346x3389x3432x3475_closure.loopStart = 0
x3174x3604x3518x3561x3346x3389x3432x3475_closure.loopSize = x3
val alloc: activation_x3174x3604x3518x3561x3346x3389x3432x3475 = x3174x3604x3518x3561x3346x3389x3432x3475_closure.alloc(resourceInfo)
var x3174x3604x3518x3561x3346x3389x3432x3475: activation_x3174x3604x3518x3561x3346x3389x3432x3475 = null
if (resourceInfo.availableThreads <= 1) {
x3174x3604x3518x3561x3346x3389x3432x3475 = x3174x3604x3518x3561x3346x3389x3432x3475_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x3174x3604x3518x3561x3346x3389x3432x3475] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x3174x3604x3518x3561x3346x3389x3432x3475](x3174x3604x3518x3561x3346x3389x3432x3475_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x3174x3604x3518x3561x3346x3389x3432x3475_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x3174x3604x3518x3561x3346x3389x3432x3475 = x3174x3604x3518x3561x3346x3389x3432x3475_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x3174x3604x3518x3561x3346x3389x3432x3475
}}

/**********/


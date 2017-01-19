package generated.scala
//activation record for fat loop
final class activation_x2119x2463x2506x2291x2334x2377x2420x2549 {
var left_act: activation_x2119x2463x2506x2291x2334x2377x2420x2549 = _
var x2119: Array[Int] = _
var x2119_data: Array[Int] = _
var x2119_buf: Array[Int] = _
var x2119_size: Int = _
var x2119_offset: Int = _
var x2119_conditionals: Int = _
def x2119_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Int],cs:Int): Unit = {
x2119_data = xs
x2119_conditionals = cs
if (left_act ne null)
left_act.x2119_data_set(resourceInfo,xs,cs)
}

var x2463: Array[Char] = _
var x2463_data: Array[Char] = _
var x2463_buf: Array[Char] = _
var x2463_size: Int = _
var x2463_offset: Int = _
var x2463_conditionals: Int = _
def x2463_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Char],cs:Int): Unit = {
x2463_data = xs
x2463_conditionals = cs
if (left_act ne null)
left_act.x2463_data_set(resourceInfo,xs,cs)
}

var x2506: Array[Char] = _
var x2506_data: Array[Char] = _
var x2506_buf: Array[Char] = _
var x2506_size: Int = _
var x2506_offset: Int = _
var x2506_conditionals: Int = _
def x2506_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Char],cs:Int): Unit = {
x2506_data = xs
x2506_conditionals = cs
if (left_act ne null)
left_act.x2506_data_set(resourceInfo,xs,cs)
}

var x2291: Array[Double] = _
var x2291_data: Array[Double] = _
var x2291_buf: Array[Double] = _
var x2291_size: Int = _
var x2291_offset: Int = _
var x2291_conditionals: Int = _
def x2291_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Double],cs:Int): Unit = {
x2291_data = xs
x2291_conditionals = cs
if (left_act ne null)
left_act.x2291_data_set(resourceInfo,xs,cs)
}

var x2334: Array[Double] = _
var x2334_data: Array[Double] = _
var x2334_buf: Array[Double] = _
var x2334_size: Int = _
var x2334_offset: Int = _
var x2334_conditionals: Int = _
def x2334_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Double],cs:Int): Unit = {
x2334_data = xs
x2334_conditionals = cs
if (left_act ne null)
left_act.x2334_data_set(resourceInfo,xs,cs)
}

var x2377: Array[Double] = _
var x2377_data: Array[Double] = _
var x2377_buf: Array[Double] = _
var x2377_size: Int = _
var x2377_offset: Int = _
var x2377_conditionals: Int = _
def x2377_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Double],cs:Int): Unit = {
x2377_data = xs
x2377_conditionals = cs
if (left_act ne null)
left_act.x2377_data_set(resourceInfo,xs,cs)
}

var x2420: Array[Double] = _
var x2420_data: Array[Double] = _
var x2420_buf: Array[Double] = _
var x2420_size: Int = _
var x2420_offset: Int = _
var x2420_conditionals: Int = _
def x2420_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Double],cs:Int): Unit = {
x2420_data = xs
x2420_conditionals = cs
if (left_act ne null)
left_act.x2420_data_set(resourceInfo,xs,cs)
}

var x2549: Array[Int] = _
var x2549_data: Array[Int] = _
var x2549_buf: Array[Int] = _
var x2549_size: Int = _
var x2549_offset: Int = _
var x2549_conditionals: Int = _
def x2549_data_set(resourceInfo:generated.scala.ResourceInfo,xs:Array[Int],cs:Int): Unit = {
x2549_data = xs
x2549_conditionals = cs
if (left_act ne null)
left_act.x2549_data_set(resourceInfo,xs,cs)
}

}
object activation_x2119x2463x2506x2291x2334x2377x2420x2549 {
}
object kernel_x2119x2463x2506x2291x2334x2377x2420x2549 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2:Long,x1:generated.scala.io.DeliteFileInputStream): activation_x2119x2463x2506x2291x2334x2377x2420x2549 = {
val x2119x2463x2506x2291x2334x2377x2420x2549_closure = new generated.scala.DeliteOpMultiLoop[activation_x2119x2463x2506x2291x2334x2377x2420x2549] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x2
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x2119x2463x2506x2291x2334x2377x2420x2549 = {
val __act: activation_x2119x2463x2506x2291x2334x2377x2420x2549 = new activation_x2119x2463x2506x2291x2334x2377x2420x2549()
// __act.x2119 stays null for now
// __act.x2463 stays null for now
// __act.x2506 stays null for now
// __act.x2291 stays null for now
// __act.x2334 stays null for now
// __act.x2377 stays null for now
// __act.x2420 stays null for now
// __act.x2549 stays null for now
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2119x2463x2506x2291x2334x2377x2420x2549,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x2119x2463x2506x2291x2334x2377x2420x2549]): activation_x2119x2463x2506x2291x2334x2377x2420x2549 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x2119x2463x2506x2291x2334x2377x2420x2549 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x2119x2463x2506x2291x2334x2377x2420x2549 = sync.get(localStart)
//post combine
if (tid != 0) postCombine(resourceInfo,act,sync.getP(tid-1))
var j: Int = localStart+1
var currentAct: activation_x2119x2463x2506x2291x2334x2377x2420x2549 = act
while (j < localEnd) {
val rhsAct: activation_x2119x2463x2506x2291x2334x2377x2420x2549 = sync.get(j)
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

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2119x2463x2506x2291x2334x2377x2420x2549): activation_x2119x2463x2506x2291x2334x2377x2420x2549 = {
val act: activation_x2119x2463x2506x2291x2334x2377x2420x2549 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
postProcInit(resourceInfo,act)
postProcess(resourceInfo,act)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2119x2463x2506x2291x2334x2377x2420x2549,start:Long,end:Long): activation_x2119x2463x2506x2291x2334x2377x2420x2549 = {
val x1_stream: generated.scala.io.DeliteFileInputStream = x1.openCopyAtNewLine(start)
val x1_stream_offset: Long = x1_stream.streamOffset
val isEmpty: Boolean = end <= x1_stream.position
val __act2: activation_x2119x2463x2506x2291x2334x2377x2420x2549 = init(resourceInfo,__act,-1,isEmpty,x1_stream)
while (x1_stream.position < x1_stream_offset + end) {
process(resourceInfo,__act2,-1,x1_stream)
}
x1_stream.close();
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2119x2463x2506x2291x2334x2377x2420x2549,x3:Int,isEmpty:Boolean,x1_stream:generated.scala.io.DeliteFileInputStream): activation_x2119x2463x2506x2291x2334x2377x2420x2549 = {
val __act2: activation_x2119x2463x2506x2291x2334x2377x2420x2549 = new activation_x2119x2463x2506x2291x2334x2377x2420x2549()
val x2079 = 0
if (x2079 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2083 = new Array[Int](x2079.toInt)
__act2.x2119_buf = x2083
val x2423 = 0
if (x2423 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2427 = new Array[Char](x2423.toInt)
__act2.x2463_buf = x2427
val x2466 = 0
if (x2466 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2470 = new Array[Char](x2466.toInt)
__act2.x2506_buf = x2470
val x2251 = 0
if (x2251 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2255 = new Array[Double](x2251.toInt)
__act2.x2291_buf = x2255
val x2294 = 0
if (x2294 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2298 = new Array[Double](x2294.toInt)
__act2.x2334_buf = x2298
val x2337 = 0
if (x2337 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2341 = new Array[Double](x2337.toInt)
__act2.x2377_buf = x2341
val x2380 = 0
if (x2380 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2384 = new Array[Double](x2380.toInt)
__act2.x2420_buf = x2384
val x2509 = 0
if (x2509 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2513 = new Array[Int](x2509.toInt)
__act2.x2549_buf = x2513
if (!isEmpty) {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
val x6 = x5(0.toInt)
val x7 = {
x6.toInt}
val x22 = x5(8.toInt)
val x23 = {
x22.charAt(0)}
val x24 = x5(9.toInt)
val x25 = {
x24.charAt(0)}
val x14 = x5(4.toInt)
val x15 = {
x14.toDouble}
val x16 = x5(5.toInt)
val x17 = {
x16.toDouble}
val x18 = x5(6.toInt)
val x19 = {
x18.toDouble}
val x20 = x5(7.toInt)
val x21 = {
x20.toDouble}
val x26 = x5(10.toInt)
val x27 = x26.split("-", 0)
val x28 = x27(0.toInt)
val x29 = {
x28.toInt}
val x34 = {
x29 << 9}
val x32 = x27(2.toInt)
val x33 = {
x32.toInt}
val x30 = x27(1.toInt)
val x31 = {
x30.toInt}
val x35 = {
x31 << 5}
val x36 = x35 + x33
val x37 = x34 + x36
def x38_block = { 
x37
}
val x38 = x38_block
val x2077 = __act2.x2119_buf
val x2078 = x7
if (true) {
val x2089 = __act2.x2119_size
val x2090 = x2077.length
val x2091 = x2090 - 1
val x2092 = x2089 > x2091
val x2105 = {
def x2105thenb(): Unit = {
val x2093 = x2090 < 16
val x2097 = {
def x2097thenb(): Int = {
16
}
def x2097elseb(): Int = {
val x2094 = x2090 * 2
val x2095 = x2094 < 0
val x2096 = {
def x2096thenb(): Int = {
2147483647
}
def x2096elseb(): Int = {
x2094
}
if (x2095) {
x2096thenb()
} else { 
x2096elseb()
}
}
x2096
}
if (x2093) {
x2097thenb()
} else { 
x2097elseb()
}
}
if (x2097 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2098 = new Array[Int](x2097.toInt)
val x2099 = System.arraycopy(x2077,0.toInt,x2098,0.toInt,x2090.toInt)
val x2100 = x2098(x2089.toInt) = x2078
val x2101 = __act2.x2119_buf = x2098
x2101
}
def x2105elseb(): Unit = {
val x2103 = x2077(x2089.toInt) = x2078
x2103
}
if (x2092) {
x2105thenb()
} else { 
x2105elseb()
}
}
__act2.x2119_size = __act2.x2119_size + 1
}
__act2.x2119_conditionals = __act2.x2119_conditionals + 1
val x2421 = __act2.x2463_buf
val x2422 = x23
if (true) {
val x2433 = __act2.x2463_size
val x2434 = x2421.length
val x2435 = x2434 - 1
val x2436 = x2433 > x2435
val x2449 = {
def x2449thenb(): Unit = {
val x2437 = x2434 < 16
val x2441 = {
def x2441thenb(): Int = {
16
}
def x2441elseb(): Int = {
val x2438 = x2434 * 2
val x2439 = x2438 < 0
val x2440 = {
def x2440thenb(): Int = {
2147483647
}
def x2440elseb(): Int = {
x2438
}
if (x2439) {
x2440thenb()
} else { 
x2440elseb()
}
}
x2440
}
if (x2437) {
x2441thenb()
} else { 
x2441elseb()
}
}
if (x2441 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2442 = new Array[Char](x2441.toInt)
val x2443 = System.arraycopy(x2421,0.toInt,x2442,0.toInt,x2434.toInt)
val x2444 = x2442(x2433.toInt) = x2422
val x2445 = __act2.x2463_buf = x2442
x2445
}
def x2449elseb(): Unit = {
val x2447 = x2421(x2433.toInt) = x2422
x2447
}
if (x2436) {
x2449thenb()
} else { 
x2449elseb()
}
}
__act2.x2463_size = __act2.x2463_size + 1
}
__act2.x2463_conditionals = __act2.x2463_conditionals + 1
val x2464 = __act2.x2506_buf
val x2465 = x25
if (true) {
val x2476 = __act2.x2506_size
val x2477 = x2464.length
val x2478 = x2477 - 1
val x2479 = x2476 > x2478
val x2492 = {
def x2492thenb(): Unit = {
val x2480 = x2477 < 16
val x2484 = {
def x2484thenb(): Int = {
16
}
def x2484elseb(): Int = {
val x2481 = x2477 * 2
val x2482 = x2481 < 0
val x2483 = {
def x2483thenb(): Int = {
2147483647
}
def x2483elseb(): Int = {
x2481
}
if (x2482) {
x2483thenb()
} else { 
x2483elseb()
}
}
x2483
}
if (x2480) {
x2484thenb()
} else { 
x2484elseb()
}
}
if (x2484 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2485 = new Array[Char](x2484.toInt)
val x2486 = System.arraycopy(x2464,0.toInt,x2485,0.toInt,x2477.toInt)
val x2487 = x2485(x2476.toInt) = x2465
val x2488 = __act2.x2506_buf = x2485
x2488
}
def x2492elseb(): Unit = {
val x2490 = x2464(x2476.toInt) = x2465
x2490
}
if (x2479) {
x2492thenb()
} else { 
x2492elseb()
}
}
__act2.x2506_size = __act2.x2506_size + 1
}
__act2.x2506_conditionals = __act2.x2506_conditionals + 1
val x2249 = __act2.x2291_buf
val x2250 = x15
if (true) {
val x2261 = __act2.x2291_size
val x2262 = x2249.length
val x2263 = x2262 - 1
val x2264 = x2261 > x2263
val x2277 = {
def x2277thenb(): Unit = {
val x2265 = x2262 < 16
val x2269 = {
def x2269thenb(): Int = {
16
}
def x2269elseb(): Int = {
val x2266 = x2262 * 2
val x2267 = x2266 < 0
val x2268 = {
def x2268thenb(): Int = {
2147483647
}
def x2268elseb(): Int = {
x2266
}
if (x2267) {
x2268thenb()
} else { 
x2268elseb()
}
}
x2268
}
if (x2265) {
x2269thenb()
} else { 
x2269elseb()
}
}
if (x2269 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2270 = new Array[Double](x2269.toInt)
val x2271 = System.arraycopy(x2249,0.toInt,x2270,0.toInt,x2262.toInt)
val x2272 = x2270(x2261.toInt) = x2250
val x2273 = __act2.x2291_buf = x2270
x2273
}
def x2277elseb(): Unit = {
val x2275 = x2249(x2261.toInt) = x2250
x2275
}
if (x2264) {
x2277thenb()
} else { 
x2277elseb()
}
}
__act2.x2291_size = __act2.x2291_size + 1
}
__act2.x2291_conditionals = __act2.x2291_conditionals + 1
val x2292 = __act2.x2334_buf
val x2293 = x17
if (true) {
val x2304 = __act2.x2334_size
val x2305 = x2292.length
val x2306 = x2305 - 1
val x2307 = x2304 > x2306
val x2320 = {
def x2320thenb(): Unit = {
val x2308 = x2305 < 16
val x2312 = {
def x2312thenb(): Int = {
16
}
def x2312elseb(): Int = {
val x2309 = x2305 * 2
val x2310 = x2309 < 0
val x2311 = {
def x2311thenb(): Int = {
2147483647
}
def x2311elseb(): Int = {
x2309
}
if (x2310) {
x2311thenb()
} else { 
x2311elseb()
}
}
x2311
}
if (x2308) {
x2312thenb()
} else { 
x2312elseb()
}
}
if (x2312 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2313 = new Array[Double](x2312.toInt)
val x2314 = System.arraycopy(x2292,0.toInt,x2313,0.toInt,x2305.toInt)
val x2315 = x2313(x2304.toInt) = x2293
val x2316 = __act2.x2334_buf = x2313
x2316
}
def x2320elseb(): Unit = {
val x2318 = x2292(x2304.toInt) = x2293
x2318
}
if (x2307) {
x2320thenb()
} else { 
x2320elseb()
}
}
__act2.x2334_size = __act2.x2334_size + 1
}
__act2.x2334_conditionals = __act2.x2334_conditionals + 1
val x2335 = __act2.x2377_buf
val x2336 = x19
if (true) {
val x2347 = __act2.x2377_size
val x2348 = x2335.length
val x2349 = x2348 - 1
val x2350 = x2347 > x2349
val x2363 = {
def x2363thenb(): Unit = {
val x2351 = x2348 < 16
val x2355 = {
def x2355thenb(): Int = {
16
}
def x2355elseb(): Int = {
val x2352 = x2348 * 2
val x2353 = x2352 < 0
val x2354 = {
def x2354thenb(): Int = {
2147483647
}
def x2354elseb(): Int = {
x2352
}
if (x2353) {
x2354thenb()
} else { 
x2354elseb()
}
}
x2354
}
if (x2351) {
x2355thenb()
} else { 
x2355elseb()
}
}
if (x2355 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2356 = new Array[Double](x2355.toInt)
val x2357 = System.arraycopy(x2335,0.toInt,x2356,0.toInt,x2348.toInt)
val x2358 = x2356(x2347.toInt) = x2336
val x2359 = __act2.x2377_buf = x2356
x2359
}
def x2363elseb(): Unit = {
val x2361 = x2335(x2347.toInt) = x2336
x2361
}
if (x2350) {
x2363thenb()
} else { 
x2363elseb()
}
}
__act2.x2377_size = __act2.x2377_size + 1
}
__act2.x2377_conditionals = __act2.x2377_conditionals + 1
val x2378 = __act2.x2420_buf
val x2379 = x21
if (true) {
val x2390 = __act2.x2420_size
val x2391 = x2378.length
val x2392 = x2391 - 1
val x2393 = x2390 > x2392
val x2406 = {
def x2406thenb(): Unit = {
val x2394 = x2391 < 16
val x2398 = {
def x2398thenb(): Int = {
16
}
def x2398elseb(): Int = {
val x2395 = x2391 * 2
val x2396 = x2395 < 0
val x2397 = {
def x2397thenb(): Int = {
2147483647
}
def x2397elseb(): Int = {
x2395
}
if (x2396) {
x2397thenb()
} else { 
x2397elseb()
}
}
x2397
}
if (x2394) {
x2398thenb()
} else { 
x2398elseb()
}
}
if (x2398 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2399 = new Array[Double](x2398.toInt)
val x2400 = System.arraycopy(x2378,0.toInt,x2399,0.toInt,x2391.toInt)
val x2401 = x2399(x2390.toInt) = x2379
val x2402 = __act2.x2420_buf = x2399
x2402
}
def x2406elseb(): Unit = {
val x2404 = x2378(x2390.toInt) = x2379
x2404
}
if (x2393) {
x2406thenb()
} else { 
x2406elseb()
}
}
__act2.x2420_size = __act2.x2420_size + 1
}
__act2.x2420_conditionals = __act2.x2420_conditionals + 1
val x2507 = __act2.x2549_buf
val x2508 = x38
if (true) {
val x2519 = __act2.x2549_size
val x2520 = x2507.length
val x2521 = x2520 - 1
val x2522 = x2519 > x2521
val x2535 = {
def x2535thenb(): Unit = {
val x2523 = x2520 < 16
val x2527 = {
def x2527thenb(): Int = {
16
}
def x2527elseb(): Int = {
val x2524 = x2520 * 2
val x2525 = x2524 < 0
val x2526 = {
def x2526thenb(): Int = {
2147483647
}
def x2526elseb(): Int = {
x2524
}
if (x2525) {
x2526thenb()
} else { 
x2526elseb()
}
}
x2526
}
if (x2523) {
x2527thenb()
} else { 
x2527elseb()
}
}
if (x2527 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2528 = new Array[Int](x2527.toInt)
val x2529 = System.arraycopy(x2507,0.toInt,x2528,0.toInt,x2520.toInt)
val x2530 = x2528(x2519.toInt) = x2508
val x2531 = __act2.x2549_buf = x2528
x2531
}
def x2535elseb(): Unit = {
val x2533 = x2507(x2519.toInt) = x2508
x2533
}
if (x2522) {
x2535thenb()
} else { 
x2535elseb()
}
}
__act2.x2549_size = __act2.x2549_size + 1
}
__act2.x2549_conditionals = __act2.x2549_conditionals + 1
}
__act2
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2119x2463x2506x2291x2334x2377x2420x2549,x3:Int,x1_stream:generated.scala.io.DeliteFileInputStream): Unit = {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
val x6 = x5(0.toInt)
val x7 = {
x6.toInt}
val x22 = x5(8.toInt)
val x23 = {
x22.charAt(0)}
val x24 = x5(9.toInt)
val x25 = {
x24.charAt(0)}
val x14 = x5(4.toInt)
val x15 = {
x14.toDouble}
val x16 = x5(5.toInt)
val x17 = {
x16.toDouble}
val x18 = x5(6.toInt)
val x19 = {
x18.toDouble}
val x20 = x5(7.toInt)
val x21 = {
x20.toDouble}
val x26 = x5(10.toInt)
val x27 = x26.split("-", 0)
val x28 = x27(0.toInt)
val x29 = {
x28.toInt}
val x34 = {
x29 << 9}
val x32 = x27(2.toInt)
val x33 = {
x32.toInt}
val x30 = x27(1.toInt)
val x31 = {
x30.toInt}
val x35 = {
x31 << 5}
val x36 = x35 + x33
val x37 = x34 + x36
def x38_block = { 
x37
}
val x38 = x38_block
val x2077 = __act.x2119_buf
val x2078 = x7
if (true) {
val x2089 = __act.x2119_size
val x2090 = x2077.length
val x2091 = x2090 - 1
val x2092 = x2089 > x2091
val x2105 = {
def x2105thenb(): Unit = {
val x2093 = x2090 < 16
val x2097 = {
def x2097thenb(): Int = {
16
}
def x2097elseb(): Int = {
val x2094 = x2090 * 2
val x2095 = x2094 < 0
val x2096 = {
def x2096thenb(): Int = {
2147483647
}
def x2096elseb(): Int = {
x2094
}
if (x2095) {
x2096thenb()
} else { 
x2096elseb()
}
}
x2096
}
if (x2093) {
x2097thenb()
} else { 
x2097elseb()
}
}
if (x2097 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2098 = new Array[Int](x2097.toInt)
val x2099 = System.arraycopy(x2077,0.toInt,x2098,0.toInt,x2090.toInt)
val x2100 = x2098(x2089.toInt) = x2078
val x2101 = __act.x2119_buf = x2098
x2101
}
def x2105elseb(): Unit = {
val x2103 = x2077(x2089.toInt) = x2078
x2103
}
if (x2092) {
x2105thenb()
} else { 
x2105elseb()
}
}
__act.x2119_size = __act.x2119_size + 1
}
__act.x2119_conditionals = __act.x2119_conditionals + 1
val x2421 = __act.x2463_buf
val x2422 = x23
if (true) {
val x2433 = __act.x2463_size
val x2434 = x2421.length
val x2435 = x2434 - 1
val x2436 = x2433 > x2435
val x2449 = {
def x2449thenb(): Unit = {
val x2437 = x2434 < 16
val x2441 = {
def x2441thenb(): Int = {
16
}
def x2441elseb(): Int = {
val x2438 = x2434 * 2
val x2439 = x2438 < 0
val x2440 = {
def x2440thenb(): Int = {
2147483647
}
def x2440elseb(): Int = {
x2438
}
if (x2439) {
x2440thenb()
} else { 
x2440elseb()
}
}
x2440
}
if (x2437) {
x2441thenb()
} else { 
x2441elseb()
}
}
if (x2441 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2442 = new Array[Char](x2441.toInt)
val x2443 = System.arraycopy(x2421,0.toInt,x2442,0.toInt,x2434.toInt)
val x2444 = x2442(x2433.toInt) = x2422
val x2445 = __act.x2463_buf = x2442
x2445
}
def x2449elseb(): Unit = {
val x2447 = x2421(x2433.toInt) = x2422
x2447
}
if (x2436) {
x2449thenb()
} else { 
x2449elseb()
}
}
__act.x2463_size = __act.x2463_size + 1
}
__act.x2463_conditionals = __act.x2463_conditionals + 1
val x2464 = __act.x2506_buf
val x2465 = x25
if (true) {
val x2476 = __act.x2506_size
val x2477 = x2464.length
val x2478 = x2477 - 1
val x2479 = x2476 > x2478
val x2492 = {
def x2492thenb(): Unit = {
val x2480 = x2477 < 16
val x2484 = {
def x2484thenb(): Int = {
16
}
def x2484elseb(): Int = {
val x2481 = x2477 * 2
val x2482 = x2481 < 0
val x2483 = {
def x2483thenb(): Int = {
2147483647
}
def x2483elseb(): Int = {
x2481
}
if (x2482) {
x2483thenb()
} else { 
x2483elseb()
}
}
x2483
}
if (x2480) {
x2484thenb()
} else { 
x2484elseb()
}
}
if (x2484 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2485 = new Array[Char](x2484.toInt)
val x2486 = System.arraycopy(x2464,0.toInt,x2485,0.toInt,x2477.toInt)
val x2487 = x2485(x2476.toInt) = x2465
val x2488 = __act.x2506_buf = x2485
x2488
}
def x2492elseb(): Unit = {
val x2490 = x2464(x2476.toInt) = x2465
x2490
}
if (x2479) {
x2492thenb()
} else { 
x2492elseb()
}
}
__act.x2506_size = __act.x2506_size + 1
}
__act.x2506_conditionals = __act.x2506_conditionals + 1
val x2249 = __act.x2291_buf
val x2250 = x15
if (true) {
val x2261 = __act.x2291_size
val x2262 = x2249.length
val x2263 = x2262 - 1
val x2264 = x2261 > x2263
val x2277 = {
def x2277thenb(): Unit = {
val x2265 = x2262 < 16
val x2269 = {
def x2269thenb(): Int = {
16
}
def x2269elseb(): Int = {
val x2266 = x2262 * 2
val x2267 = x2266 < 0
val x2268 = {
def x2268thenb(): Int = {
2147483647
}
def x2268elseb(): Int = {
x2266
}
if (x2267) {
x2268thenb()
} else { 
x2268elseb()
}
}
x2268
}
if (x2265) {
x2269thenb()
} else { 
x2269elseb()
}
}
if (x2269 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2270 = new Array[Double](x2269.toInt)
val x2271 = System.arraycopy(x2249,0.toInt,x2270,0.toInt,x2262.toInt)
val x2272 = x2270(x2261.toInt) = x2250
val x2273 = __act.x2291_buf = x2270
x2273
}
def x2277elseb(): Unit = {
val x2275 = x2249(x2261.toInt) = x2250
x2275
}
if (x2264) {
x2277thenb()
} else { 
x2277elseb()
}
}
__act.x2291_size = __act.x2291_size + 1
}
__act.x2291_conditionals = __act.x2291_conditionals + 1
val x2292 = __act.x2334_buf
val x2293 = x17
if (true) {
val x2304 = __act.x2334_size
val x2305 = x2292.length
val x2306 = x2305 - 1
val x2307 = x2304 > x2306
val x2320 = {
def x2320thenb(): Unit = {
val x2308 = x2305 < 16
val x2312 = {
def x2312thenb(): Int = {
16
}
def x2312elseb(): Int = {
val x2309 = x2305 * 2
val x2310 = x2309 < 0
val x2311 = {
def x2311thenb(): Int = {
2147483647
}
def x2311elseb(): Int = {
x2309
}
if (x2310) {
x2311thenb()
} else { 
x2311elseb()
}
}
x2311
}
if (x2308) {
x2312thenb()
} else { 
x2312elseb()
}
}
if (x2312 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2313 = new Array[Double](x2312.toInt)
val x2314 = System.arraycopy(x2292,0.toInt,x2313,0.toInt,x2305.toInt)
val x2315 = x2313(x2304.toInt) = x2293
val x2316 = __act.x2334_buf = x2313
x2316
}
def x2320elseb(): Unit = {
val x2318 = x2292(x2304.toInt) = x2293
x2318
}
if (x2307) {
x2320thenb()
} else { 
x2320elseb()
}
}
__act.x2334_size = __act.x2334_size + 1
}
__act.x2334_conditionals = __act.x2334_conditionals + 1
val x2335 = __act.x2377_buf
val x2336 = x19
if (true) {
val x2347 = __act.x2377_size
val x2348 = x2335.length
val x2349 = x2348 - 1
val x2350 = x2347 > x2349
val x2363 = {
def x2363thenb(): Unit = {
val x2351 = x2348 < 16
val x2355 = {
def x2355thenb(): Int = {
16
}
def x2355elseb(): Int = {
val x2352 = x2348 * 2
val x2353 = x2352 < 0
val x2354 = {
def x2354thenb(): Int = {
2147483647
}
def x2354elseb(): Int = {
x2352
}
if (x2353) {
x2354thenb()
} else { 
x2354elseb()
}
}
x2354
}
if (x2351) {
x2355thenb()
} else { 
x2355elseb()
}
}
if (x2355 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2356 = new Array[Double](x2355.toInt)
val x2357 = System.arraycopy(x2335,0.toInt,x2356,0.toInt,x2348.toInt)
val x2358 = x2356(x2347.toInt) = x2336
val x2359 = __act.x2377_buf = x2356
x2359
}
def x2363elseb(): Unit = {
val x2361 = x2335(x2347.toInt) = x2336
x2361
}
if (x2350) {
x2363thenb()
} else { 
x2363elseb()
}
}
__act.x2377_size = __act.x2377_size + 1
}
__act.x2377_conditionals = __act.x2377_conditionals + 1
val x2378 = __act.x2420_buf
val x2379 = x21
if (true) {
val x2390 = __act.x2420_size
val x2391 = x2378.length
val x2392 = x2391 - 1
val x2393 = x2390 > x2392
val x2406 = {
def x2406thenb(): Unit = {
val x2394 = x2391 < 16
val x2398 = {
def x2398thenb(): Int = {
16
}
def x2398elseb(): Int = {
val x2395 = x2391 * 2
val x2396 = x2395 < 0
val x2397 = {
def x2397thenb(): Int = {
2147483647
}
def x2397elseb(): Int = {
x2395
}
if (x2396) {
x2397thenb()
} else { 
x2397elseb()
}
}
x2397
}
if (x2394) {
x2398thenb()
} else { 
x2398elseb()
}
}
if (x2398 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2399 = new Array[Double](x2398.toInt)
val x2400 = System.arraycopy(x2378,0.toInt,x2399,0.toInt,x2391.toInt)
val x2401 = x2399(x2390.toInt) = x2379
val x2402 = __act.x2420_buf = x2399
x2402
}
def x2406elseb(): Unit = {
val x2404 = x2378(x2390.toInt) = x2379
x2404
}
if (x2393) {
x2406thenb()
} else { 
x2406elseb()
}
}
__act.x2420_size = __act.x2420_size + 1
}
__act.x2420_conditionals = __act.x2420_conditionals + 1
val x2507 = __act.x2549_buf
val x2508 = x38
if (true) {
val x2519 = __act.x2549_size
val x2520 = x2507.length
val x2521 = x2520 - 1
val x2522 = x2519 > x2521
val x2535 = {
def x2535thenb(): Unit = {
val x2523 = x2520 < 16
val x2527 = {
def x2527thenb(): Int = {
16
}
def x2527elseb(): Int = {
val x2524 = x2520 * 2
val x2525 = x2524 < 0
val x2526 = {
def x2526thenb(): Int = {
2147483647
}
def x2526elseb(): Int = {
x2524
}
if (x2525) {
x2526thenb()
} else { 
x2526elseb()
}
}
x2526
}
if (x2523) {
x2527thenb()
} else { 
x2527elseb()
}
}
if (x2527 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2528 = new Array[Int](x2527.toInt)
val x2529 = System.arraycopy(x2507,0.toInt,x2528,0.toInt,x2520.toInt)
val x2530 = x2528(x2519.toInt) = x2508
val x2531 = __act.x2549_buf = x2528
x2531
}
def x2535elseb(): Unit = {
val x2533 = x2507(x2519.toInt) = x2508
x2533
}
if (x2522) {
x2535thenb()
} else { 
x2535elseb()
}
}
__act.x2549_size = __act.x2549_size + 1
}
__act.x2549_conditionals = __act.x2549_conditionals + 1
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2119x2463x2506x2291x2334x2377x2420x2549,rhs:activation_x2119x2463x2506x2291x2334x2377x2420x2549): Unit = {
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2119x2463x2506x2291x2334x2377x2420x2549,lhs:activation_x2119x2463x2506x2291x2334x2377x2420x2549): Unit = {
__act.x2119_offset = lhs.x2119_offset+lhs.x2119_size
__act.x2119_conditionals = __act.x2119_conditionals+lhs.x2119_conditionals
__act.x2463_offset = lhs.x2463_offset+lhs.x2463_size
__act.x2463_conditionals = __act.x2463_conditionals+lhs.x2463_conditionals
__act.x2506_offset = lhs.x2506_offset+lhs.x2506_size
__act.x2506_conditionals = __act.x2506_conditionals+lhs.x2506_conditionals
__act.x2291_offset = lhs.x2291_offset+lhs.x2291_size
__act.x2291_conditionals = __act.x2291_conditionals+lhs.x2291_conditionals
__act.x2334_offset = lhs.x2334_offset+lhs.x2334_size
__act.x2334_conditionals = __act.x2334_conditionals+lhs.x2334_conditionals
__act.x2377_offset = lhs.x2377_offset+lhs.x2377_size
__act.x2377_conditionals = __act.x2377_conditionals+lhs.x2377_conditionals
__act.x2420_offset = lhs.x2420_offset+lhs.x2420_size
__act.x2420_conditionals = __act.x2420_conditionals+lhs.x2420_conditionals
__act.x2549_offset = lhs.x2549_offset+lhs.x2549_size
__act.x2549_conditionals = __act.x2549_conditionals+lhs.x2549_conditionals
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2119x2463x2506x2291x2334x2377x2420x2549): Unit = {
if (__act.x2119_offset > 0) {
val x2079 = __act.x2119_offset + __act.x2119_size
val x2077 = __act.x2119_buf
if (x2079 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2115 = new Array[Int](x2079.toInt)
__act.x2119_data_set(resourceInfo,x2115,__act.x2119_conditionals)
} else {
__act.x2119_data_set(resourceInfo,__act.x2119_buf,__act.x2119_conditionals)
}
if (__act.x2463_offset > 0) {
val x2423 = __act.x2463_offset + __act.x2463_size
val x2421 = __act.x2463_buf
if (x2423 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2459 = new Array[Char](x2423.toInt)
__act.x2463_data_set(resourceInfo,x2459,__act.x2463_conditionals)
} else {
__act.x2463_data_set(resourceInfo,__act.x2463_buf,__act.x2463_conditionals)
}
if (__act.x2506_offset > 0) {
val x2466 = __act.x2506_offset + __act.x2506_size
val x2464 = __act.x2506_buf
if (x2466 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2502 = new Array[Char](x2466.toInt)
__act.x2506_data_set(resourceInfo,x2502,__act.x2506_conditionals)
} else {
__act.x2506_data_set(resourceInfo,__act.x2506_buf,__act.x2506_conditionals)
}
if (__act.x2291_offset > 0) {
val x2251 = __act.x2291_offset + __act.x2291_size
val x2249 = __act.x2291_buf
if (x2251 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2287 = new Array[Double](x2251.toInt)
__act.x2291_data_set(resourceInfo,x2287,__act.x2291_conditionals)
} else {
__act.x2291_data_set(resourceInfo,__act.x2291_buf,__act.x2291_conditionals)
}
if (__act.x2334_offset > 0) {
val x2294 = __act.x2334_offset + __act.x2334_size
val x2292 = __act.x2334_buf
if (x2294 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2330 = new Array[Double](x2294.toInt)
__act.x2334_data_set(resourceInfo,x2330,__act.x2334_conditionals)
} else {
__act.x2334_data_set(resourceInfo,__act.x2334_buf,__act.x2334_conditionals)
}
if (__act.x2377_offset > 0) {
val x2337 = __act.x2377_offset + __act.x2377_size
val x2335 = __act.x2377_buf
if (x2337 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2373 = new Array[Double](x2337.toInt)
__act.x2377_data_set(resourceInfo,x2373,__act.x2377_conditionals)
} else {
__act.x2377_data_set(resourceInfo,__act.x2377_buf,__act.x2377_conditionals)
}
if (__act.x2420_offset > 0) {
val x2380 = __act.x2420_offset + __act.x2420_size
val x2378 = __act.x2420_buf
if (x2380 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2416 = new Array[Double](x2380.toInt)
__act.x2420_data_set(resourceInfo,x2416,__act.x2420_conditionals)
} else {
__act.x2420_data_set(resourceInfo,__act.x2420_buf,__act.x2420_conditionals)
}
if (__act.x2549_offset > 0) {
val x2509 = __act.x2549_offset + __act.x2549_size
val x2507 = __act.x2549_buf
if (x2509 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2545 = new Array[Int](x2509.toInt)
__act.x2549_data_set(resourceInfo,x2545,__act.x2549_conditionals)
} else {
__act.x2549_data_set(resourceInfo,__act.x2549_buf,__act.x2549_conditionals)
}
}

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2119x2463x2506x2291x2334x2377x2420x2549): Unit = {
if (__act.x2119_data ne __act.x2119_buf) {
val x2079 = __act.x2119_size
val x2080 = __act.x2119_buf
val x2077 = __act.x2119_data
val x2081 = 0
val x2082 = __act.x2119_offset
val x2117 = System.arraycopy(x2080,x2081.toInt,x2077,x2082.toInt,x2079.toInt)
}
__act.x2119_buf = null
if (__act.x2463_data ne __act.x2463_buf) {
val x2423 = __act.x2463_size
val x2424 = __act.x2463_buf
val x2421 = __act.x2463_data
val x2425 = 0
val x2426 = __act.x2463_offset
val x2461 = System.arraycopy(x2424,x2425.toInt,x2421,x2426.toInt,x2423.toInt)
}
__act.x2463_buf = null
if (__act.x2506_data ne __act.x2506_buf) {
val x2466 = __act.x2506_size
val x2467 = __act.x2506_buf
val x2464 = __act.x2506_data
val x2468 = 0
val x2469 = __act.x2506_offset
val x2504 = System.arraycopy(x2467,x2468.toInt,x2464,x2469.toInt,x2466.toInt)
}
__act.x2506_buf = null
if (__act.x2291_data ne __act.x2291_buf) {
val x2251 = __act.x2291_size
val x2252 = __act.x2291_buf
val x2249 = __act.x2291_data
val x2253 = 0
val x2254 = __act.x2291_offset
val x2289 = System.arraycopy(x2252,x2253.toInt,x2249,x2254.toInt,x2251.toInt)
}
__act.x2291_buf = null
if (__act.x2334_data ne __act.x2334_buf) {
val x2294 = __act.x2334_size
val x2295 = __act.x2334_buf
val x2292 = __act.x2334_data
val x2296 = 0
val x2297 = __act.x2334_offset
val x2332 = System.arraycopy(x2295,x2296.toInt,x2292,x2297.toInt,x2294.toInt)
}
__act.x2334_buf = null
if (__act.x2377_data ne __act.x2377_buf) {
val x2337 = __act.x2377_size
val x2338 = __act.x2377_buf
val x2335 = __act.x2377_data
val x2339 = 0
val x2340 = __act.x2377_offset
val x2375 = System.arraycopy(x2338,x2339.toInt,x2335,x2340.toInt,x2337.toInt)
}
__act.x2377_buf = null
if (__act.x2420_data ne __act.x2420_buf) {
val x2380 = __act.x2420_size
val x2381 = __act.x2420_buf
val x2378 = __act.x2420_data
val x2382 = 0
val x2383 = __act.x2420_offset
val x2418 = System.arraycopy(x2381,x2382.toInt,x2378,x2383.toInt,x2380.toInt)
}
__act.x2420_buf = null
if (__act.x2549_data ne __act.x2549_buf) {
val x2509 = __act.x2549_size
val x2510 = __act.x2549_buf
val x2507 = __act.x2549_data
val x2511 = 0
val x2512 = __act.x2549_offset
val x2547 = System.arraycopy(x2510,x2511.toInt,x2507,x2512.toInt,x2509.toInt)
}
__act.x2549_buf = null
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2119x2463x2506x2291x2334x2377x2420x2549): Unit = {
var x2077: Array[Int] = __act.x2119_data
__act.x2119_data = null
val x2079 = __act.x2119_conditionals
val x2107 = x2077.length
val x2108 = x2107 > x2079
val x2113 = {
def x2113thenb(): Unit = {
if (x2079 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2109 = new Array[Int](x2079.toInt)
val x2110 = System.arraycopy(x2077,0.toInt,x2109,0.toInt,x2079.toInt)
val x2111 = x2077 = x2109
x2111
}
if (x2108) {
x2113thenb()
}
}
__act.x2119 = x2077
var x2421: Array[Char] = __act.x2463_data
__act.x2463_data = null
val x2423 = __act.x2463_conditionals
val x2451 = x2421.length
val x2452 = x2451 > x2423
val x2457 = {
def x2457thenb(): Unit = {
if (x2423 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2453 = new Array[Char](x2423.toInt)
val x2454 = System.arraycopy(x2421,0.toInt,x2453,0.toInt,x2423.toInt)
val x2455 = x2421 = x2453
x2455
}
if (x2452) {
x2457thenb()
}
}
__act.x2463 = x2421
var x2464: Array[Char] = __act.x2506_data
__act.x2506_data = null
val x2466 = __act.x2506_conditionals
val x2494 = x2464.length
val x2495 = x2494 > x2466
val x2500 = {
def x2500thenb(): Unit = {
if (x2466 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2496 = new Array[Char](x2466.toInt)
val x2497 = System.arraycopy(x2464,0.toInt,x2496,0.toInt,x2466.toInt)
val x2498 = x2464 = x2496
x2498
}
if (x2495) {
x2500thenb()
}
}
__act.x2506 = x2464
var x2249: Array[Double] = __act.x2291_data
__act.x2291_data = null
val x2251 = __act.x2291_conditionals
val x2279 = x2249.length
val x2280 = x2279 > x2251
val x2285 = {
def x2285thenb(): Unit = {
if (x2251 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2281 = new Array[Double](x2251.toInt)
val x2282 = System.arraycopy(x2249,0.toInt,x2281,0.toInt,x2251.toInt)
val x2283 = x2249 = x2281
x2283
}
if (x2280) {
x2285thenb()
}
}
__act.x2291 = x2249
var x2292: Array[Double] = __act.x2334_data
__act.x2334_data = null
val x2294 = __act.x2334_conditionals
val x2322 = x2292.length
val x2323 = x2322 > x2294
val x2328 = {
def x2328thenb(): Unit = {
if (x2294 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2324 = new Array[Double](x2294.toInt)
val x2325 = System.arraycopy(x2292,0.toInt,x2324,0.toInt,x2294.toInt)
val x2326 = x2292 = x2324
x2326
}
if (x2323) {
x2328thenb()
}
}
__act.x2334 = x2292
var x2335: Array[Double] = __act.x2377_data
__act.x2377_data = null
val x2337 = __act.x2377_conditionals
val x2365 = x2335.length
val x2366 = x2365 > x2337
val x2371 = {
def x2371thenb(): Unit = {
if (x2337 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2367 = new Array[Double](x2337.toInt)
val x2368 = System.arraycopy(x2335,0.toInt,x2367,0.toInt,x2337.toInt)
val x2369 = x2335 = x2367
x2369
}
if (x2366) {
x2371thenb()
}
}
__act.x2377 = x2335
var x2378: Array[Double] = __act.x2420_data
__act.x2420_data = null
val x2380 = __act.x2420_conditionals
val x2408 = x2378.length
val x2409 = x2408 > x2380
val x2414 = {
def x2414thenb(): Unit = {
if (x2380 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2410 = new Array[Double](x2380.toInt)
val x2411 = System.arraycopy(x2378,0.toInt,x2410,0.toInt,x2380.toInt)
val x2412 = x2378 = x2410
x2412
}
if (x2409) {
x2414thenb()
}
}
__act.x2420 = x2378
var x2507: Array[Int] = __act.x2549_data
__act.x2549_data = null
val x2509 = __act.x2549_conditionals
val x2537 = x2507.length
val x2538 = x2537 > x2509
val x2543 = {
def x2543thenb(): Unit = {
if (x2509 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2539 = new Array[Int](x2509.toInt)
val x2540 = System.arraycopy(x2507,0.toInt,x2539,0.toInt,x2509.toInt)
val x2541 = x2507 = x2539
x2541
}
if (x2538) {
x2543thenb()
}
}
__act.x2549 = x2507
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x2119x2463x2506x2291x2334x2377x2420x2549 = {
val act: activation_x2119x2463x2506x2291x2334x2377x2420x2549 = new activation_x2119x2463x2506x2291x2334x2377x2420x2549
act
}

}
x2119x2463x2506x2291x2334x2377x2420x2549_closure.loopStart = 0
x2119x2463x2506x2291x2334x2377x2420x2549_closure.loopSize = x2
val alloc: activation_x2119x2463x2506x2291x2334x2377x2420x2549 = x2119x2463x2506x2291x2334x2377x2420x2549_closure.alloc(resourceInfo)
var x2119x2463x2506x2291x2334x2377x2420x2549: activation_x2119x2463x2506x2291x2334x2377x2420x2549 = null
if (resourceInfo.availableThreads <= 1) {
x2119x2463x2506x2291x2334x2377x2420x2549 = x2119x2463x2506x2291x2334x2377x2420x2549_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x2119x2463x2506x2291x2334x2377x2420x2549] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x2119x2463x2506x2291x2334x2377x2420x2549](x2119x2463x2506x2291x2334x2377x2420x2549_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x2119x2463x2506x2291x2334x2377x2420x2549_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x2119x2463x2506x2291x2334x2377x2420x2549 = x2119x2463x2506x2291x2334x2377x2420x2549_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x2119x2463x2506x2291x2334x2377x2420x2549
}}

/**********/


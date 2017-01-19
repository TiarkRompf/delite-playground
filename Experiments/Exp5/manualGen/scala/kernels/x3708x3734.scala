package generated.scala
//activation record for fat loop
final class activation_x3708x3734 {
var left_act: activation_x3708x3734 = _
var all_acts: Array[activation_x3708x3734] = _
var x3708x3734_hash_pos: generated.scala.container.HashMapImpl[generated.scala.Tup2CharChar] = _
var x3708x3734_size: Int = _
var x3708: generated.scala.DeliteArrayAnon201185238 = _
var x3708_hash_data: generated.scala.DeliteArrayAnon201185238 = _
var x3734: Array[Int] = _
var x3734_hash_data: Array[Int] = _
}
object activation_x3708x3734 {
}
object kernel_x3708x3734 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2:Long,x1114:generated.scala.Anon201185238,x1:generated.scala.io.DeliteFileInputStream,x424:Int): activation_x3708x3734 = {
val x3708x3734_closure = new generated.scala.DeliteOpMultiLoop[activation_x3708x3734] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x2
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x3708x3734 = {
val __act: activation_x3708x3734 = new activation_x3708x3734()
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3708x3734,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x3708x3734]): activation_x3708x3734 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x3708x3734 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x3708x3734 = sync.get(localStart)
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

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3708x3734): activation_x3708x3734 = {
val act: activation_x3708x3734 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3708x3734,start:Long,end:Long): activation_x3708x3734 = {
val x1_stream: generated.scala.io.DeliteFileInputStream = x1.openCopyAtNewLine(start)
val x1_stream_offset: Long = x1_stream.streamOffset
val isEmpty: Boolean = end <= x1_stream.position
val __act2: activation_x3708x3734 = init(resourceInfo,__act,-1,isEmpty,x1_stream)
while (x1_stream.position < x1_stream_offset + end) {
process(resourceInfo,__act2,-1,x1_stream)
}
x1_stream.close();
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3708x3734,x3:Int,isEmpty:Boolean,x1_stream:generated.scala.io.DeliteFileInputStream): activation_x3708x3734 = {
val __act2: activation_x3708x3734 = new activation_x3708x3734()
__act2.x3708x3734_hash_pos = new generated.scala.container.HashMapImpl[generated.scala.Tup2CharChar](512,128)
__act2.x3708x3734_size = -1
val x1147: Int = 128
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2779 = new Array[Char](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2780 = new Array[Char](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2781 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2782 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2783 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2784 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2785 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2786 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2787 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2788 = new Array[Int](x1147.toInt)
val x2789 = new generated.scala.DeliteArrayAnon201185238(x2779,x2780,x2781,x2782,x2783,x2784,x2785,x2786,x2787,x2788)
__act2.x3708_hash_data = x2789
val x1471: Int = 128
if (x1471 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2966 = new Array[Int](x1471.toInt)
__act2.x3734_hash_data = x2966
if (!isEmpty) {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
val x14 = x5(4.toInt)
val x15 = {
x14.toDouble}
val x16 = x5(5.toInt)
val x17 = {
x16.toDouble}
val x18 = x5(6.toInt)
val x19 = {
x18.toDouble}
val x22 = x5(8.toInt)
val x23 = {
x22.charAt(0)}
val x24 = x5(9.toInt)
val x25 = {
x24.charAt(0)}
val x3647 = {
1.0 - x19}
val x3648 = {
x17 * x3647}
val x20 = x5(7.toInt)
val x21 = {
x20.toDouble}
val x3649 = {
1.0 + x21}
val x3650 = {
x3648 * x3649}
val x3651 = new generated.scala.Anon201185238(x23,x25,x15,x17,x3648,x3650,x15,x17,x19,1)
val x3646 = new generated.scala.Tup2CharChar(x23,x25)
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
val x3652 = {
x38 <= x424}
if (x3652) {
// common key Block(Sym(3646)) for x3708x3734
val x3708x3734_sze: Int = __act2.x3708x3734_hash_pos.size
val x3708x3734_idx: Int = __act2.x3708x3734_hash_pos.put(x3646)
if (x3708x3734_idx == x3708x3734_sze) { // new key
val x1149: generated.scala.DeliteArrayAnon201185238 = __act2.x3708_hash_data
val x1146: generated.scala.Anon201185238 = x3651
val x2836 = x3708x3734_sze
val x2837 = x1149.returnFlag
val x2838 = x2837.length
val x2839 = x2838 - 1
val x2840 = x2836 > x2839
val x2908 = {
def x2908thenb(): Unit = {
val x2841 = x2838 < 16
val x2845 = {
def x2845thenb(): Int = {
16
}
def x2845elseb(): Int = {
val x2842 = x2838 * 2
val x2843 = x2842 < 0
val x2844 = {
def x2844thenb(): Int = {
2147483647
}
def x2844elseb(): Int = {
x2842
}
if (x2843) {
x2844thenb()
} else { 
x2844elseb()
}
}
x2844
}
if (x2841) {
x2845thenb()
} else { 
x2845elseb()
}
}
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2846 = new Array[Char](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2847 = new Array[Char](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2848 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2849 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2850 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2851 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2852 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2853 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2854 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2855 = new Array[Int](x2845.toInt)
val x2856 = System.arraycopy(x2837,0.toInt,x2846,0.toInt,x2838.toInt)
val x2857 = x1149.lineStatus
val x2858 = System.arraycopy(x2857,0.toInt,x2847,0.toInt,x2838.toInt)
val x2859 = x1149.sumQty
val x2860 = System.arraycopy(x2859,0.toInt,x2848,0.toInt,x2838.toInt)
val x2861 = x1149.sumBasePrice
val x2862 = System.arraycopy(x2861,0.toInt,x2849,0.toInt,x2838.toInt)
val x2863 = x1149.sumDiscountedPrice
val x2864 = System.arraycopy(x2863,0.toInt,x2850,0.toInt,x2838.toInt)
val x2865 = x1149.sumCharge
val x2866 = System.arraycopy(x2865,0.toInt,x2851,0.toInt,x2838.toInt)
val x2867 = x1149.avgQty
val x2868 = System.arraycopy(x2867,0.toInt,x2852,0.toInt,x2838.toInt)
val x2869 = x1149.avgPrice
val x2870 = System.arraycopy(x2869,0.toInt,x2853,0.toInt,x2838.toInt)
val x2871 = x1149.avgDiscount
val x2872 = System.arraycopy(x2871,0.toInt,x2854,0.toInt,x2838.toInt)
val x2873 = x1149.countOrder
val x2874 = System.arraycopy(x2873,0.toInt,x2855,0.toInt,x2838.toInt)
val x1185 = x1146.returnFlag
val x2875 = x2846(x2836.toInt) = x1185
val x1188 = x1146.lineStatus
val x2876 = x2847(x2836.toInt) = x1188
val x1191 = x1146.sumQty
val x2877 = x2848(x2836.toInt) = x1191
val x1194 = x1146.sumBasePrice
val x2878 = x2849(x2836.toInt) = x1194
val x1197 = x1146.sumDiscountedPrice
val x2879 = x2850(x2836.toInt) = x1197
val x1200 = x1146.sumCharge
val x2880 = x2851(x2836.toInt) = x1200
val x1203 = x1146.avgQty
val x2881 = x2852(x2836.toInt) = x1203
val x1206 = x1146.avgPrice
val x2882 = x2853(x2836.toInt) = x1206
val x1209 = x1146.avgDiscount
val x2883 = x2854(x2836.toInt) = x1209
val x1212 = x1146.countOrder
val x2884 = x2855(x2836.toInt) = x1212
val x2885 = new generated.scala.DeliteArrayAnon201185238(x2846,x2847,x2848,x2849,x2850,x2851,x2852,x2853,x2854,x2855)
val x2886 = __act2.x3708_hash_data = x2885
x2886
}
def x2908elseb(): Unit = {
val x1185 = x1146.returnFlag
val x2888 = x1149.returnFlag(x2836.toInt) = x1185
val x2889 = x1149.lineStatus
val x1188 = x1146.lineStatus
val x2890 = x1149.lineStatus(x2836.toInt) = x1188
val x2891 = x1149.sumQty
val x1191 = x1146.sumQty
val x2892 = x1149.sumQty(x2836.toInt) = x1191
val x2893 = x1149.sumBasePrice
val x1194 = x1146.sumBasePrice
val x2894 = x1149.sumBasePrice(x2836.toInt) = x1194
val x2895 = x1149.sumDiscountedPrice
val x1197 = x1146.sumDiscountedPrice
val x2896 = x1149.sumDiscountedPrice(x2836.toInt) = x1197
val x2897 = x1149.sumCharge
val x1200 = x1146.sumCharge
val x2898 = x1149.sumCharge(x2836.toInt) = x1200
val x2899 = x1149.avgQty
val x1203 = x1146.avgQty
val x2900 = x1149.avgQty(x2836.toInt) = x1203
val x2901 = x1149.avgPrice
val x1206 = x1146.avgPrice
val x2902 = x1149.avgPrice(x2836.toInt) = x1206
val x2903 = x1149.avgDiscount
val x1209 = x1146.avgDiscount
val x2904 = x1149.avgDiscount(x2836.toInt) = x1209
val x2905 = x1149.countOrder
val x1212 = x1146.countOrder
val x2906 = x1149.countOrder(x2836.toInt) = x1212
()
}
if (x2840) {
x2908thenb()
} else { 
x2908elseb()
}
}
val x1473: Array[Int] = __act2.x3734_hash_data
val x1470: Int = 1
val x2974 = x3708x3734_sze
val x2975 = x1473.length
val x2976 = x2975 - 1
val x2977 = x2974 > x2976
val x2990 = {
def x2990thenb(): Unit = {
val x2978 = x2975 < 16
val x2982 = {
def x2982thenb(): Int = {
16
}
def x2982elseb(): Int = {
val x2979 = x2975 * 2
val x2980 = x2979 < 0
val x2981 = {
def x2981thenb(): Int = {
2147483647
}
def x2981elseb(): Int = {
x2979
}
if (x2980) {
x2981thenb()
} else { 
x2981elseb()
}
}
x2981
}
if (x2978) {
x2982thenb()
} else { 
x2982elseb()
}
}
if (x2982 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2983 = new Array[Int](x2982.toInt)
val x2984 = System.arraycopy(x1473,0.toInt,x2983,0.toInt,x2975.toInt)
val x2985 = x2983(x2974.toInt) = x1470
val x2986 = __act2.x3734_hash_data = x2983
x2986
}
def x2990elseb(): Unit = {
val x2988 = x1473(x2974.toInt) = x1470
x2988
}
if (x2977) {
x2990thenb()
} else { 
x2990elseb()
}
}
} else { // existing key
val x1148: Int = x3708x3734_idx
val x1149: generated.scala.DeliteArrayAnon201185238 = __act2.x3708_hash_data
val x2791 = x1149.returnFlag
val x2792 = x1149.lineStatus
val x2793 = x1149.sumQty
val x2794 = x1149.sumBasePrice
val x2795 = x1149.sumDiscountedPrice
val x2796 = x1149.sumCharge
val x2797 = x1149.avgQty
val x2798 = x1149.avgPrice
val x2799 = x1149.avgDiscount
val x2800 = x1149.countOrder
val x2801 = x2791(x1148.toInt)
val x2802 = x2792(x1148.toInt)
val x2803 = x2793(x1148.toInt)
val x2804 = x2794(x1148.toInt)
val x2805 = x2795(x1148.toInt)
val x2806 = x2796(x1148.toInt)
val x2807 = x2797(x1148.toInt)
val x2808 = x2798(x1148.toInt)
val x2809 = x2799(x1148.toInt)
val x2810 = x2800(x1148.toInt)
val x2811 = new generated.scala.Anon201185238(x2801,x2802,x2803,x2804,x2805,x2806,x2807,x2808,x2809,x2810)
val x1115: generated.scala.Anon201185238 = x2811
val x1116: generated.scala.Anon201185238 = x3651
val x1117 = x1115.returnFlag
val x1119 = x1115.lineStatus
val x1121 = x1115.sumQty
val x1122 = x1116.sumQty
val x1123 = {
x1121 + x1122}
val x1124 = x1115.sumBasePrice
val x1125 = x1116.sumBasePrice
val x1126 = {
x1124 + x1125}
val x1127 = x1115.sumDiscountedPrice
val x1128 = x1116.sumDiscountedPrice
val x1129 = {
x1127 + x1128}
val x1130 = x1115.sumCharge
val x1131 = x1116.sumCharge
val x1132 = {
x1130 + x1131}
val x1133 = x1115.avgQty
val x1134 = x1116.avgQty
val x1135 = {
x1133 + x1134}
val x1136 = x1115.avgPrice
val x1137 = x1116.avgPrice
val x1138 = {
x1136 + x1137}
val x1139 = x1115.avgDiscount
val x1140 = x1116.avgDiscount
val x1141 = {
x1139 + x1140}
val x1142 = x1115.countOrder
val x1143 = x1116.countOrder
val x1144 = {
x1142 + x1143}
val x1145 = new generated.scala.Anon201185238(x1117,x1119,x1123,x1126,x1129,x1132,x1135,x1138,x1141,x1144)
val x1146: generated.scala.Anon201185238 = x1145
val x2813 = x1149.returnFlag
val x1185 = x1146.returnFlag
val x2814 = x1149.returnFlag(x1148.toInt) = x1185
val x2815 = x1149.lineStatus
val x1188 = x1146.lineStatus
val x2816 = x1149.lineStatus(x1148.toInt) = x1188
val x2817 = x1149.sumQty
val x1191 = x1146.sumQty
val x2818 = x1149.sumQty(x1148.toInt) = x1191
val x2819 = x1149.sumBasePrice
val x1194 = x1146.sumBasePrice
val x2820 = x1149.sumBasePrice(x1148.toInt) = x1194
val x2821 = x1149.sumDiscountedPrice
val x1197 = x1146.sumDiscountedPrice
val x2822 = x1149.sumDiscountedPrice(x1148.toInt) = x1197
val x2823 = x1149.sumCharge
val x1200 = x1146.sumCharge
val x2824 = x1149.sumCharge(x1148.toInt) = x1200
val x2825 = x1149.avgQty
val x1203 = x1146.avgQty
val x2826 = x1149.avgQty(x1148.toInt) = x1203
val x2827 = x1149.avgPrice
val x1206 = x1146.avgPrice
val x2828 = x1149.avgPrice(x1148.toInt) = x1206
val x2829 = x1149.avgDiscount
val x1209 = x1146.avgDiscount
val x2830 = x1149.avgDiscount(x1148.toInt) = x1209
val x2831 = x1149.countOrder
val x1212 = x1146.countOrder
val x2832 = x1149.countOrder(x1148.toInt) = x1212
val x1472: Int = x3708x3734_idx
val x1473: Array[Int] = __act2.x3734_hash_data
val x2968 = x1473(x1472.toInt)
val x1467: Int = x2968
val x1468: Int = 1
val x1469 = x1467 + x1468
val x1470: Int = x1469
val x2970 = x1473(x1472.toInt) = x1470
}
}
}
__act2
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3708x3734,x3:Int,x1_stream:generated.scala.io.DeliteFileInputStream): Unit = {
val x4 = x1_stream.readLine()
val x5 = x4.split("\\|", -1)
val x14 = x5(4.toInt)
val x15 = {
x14.toDouble}
val x16 = x5(5.toInt)
val x17 = {
x16.toDouble}
val x18 = x5(6.toInt)
val x19 = {
x18.toDouble}
val x22 = x5(8.toInt)
val x23 = {
x22.charAt(0)}
val x24 = x5(9.toInt)
val x25 = {
x24.charAt(0)}
val x3647 = {
1.0 - x19}
val x3648 = {
x17 * x3647}
val x20 = x5(7.toInt)
val x21 = {
x20.toDouble}
val x3649 = {
1.0 + x21}
val x3650 = {
x3648 * x3649}
val x3651 = new generated.scala.Anon201185238(x23,x25,x15,x17,x3648,x3650,x15,x17,x19,1)
val x3646 = new generated.scala.Tup2CharChar(x23,x25)
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
val x3652 = {
x38 <= x424}
if (x3652) {
// common key Block(Sym(3646)) for x3708x3734
val x3708x3734_sze: Int = __act.x3708x3734_hash_pos.size
val x3708x3734_idx: Int = __act.x3708x3734_hash_pos.put(x3646)
if (x3708x3734_idx == x3708x3734_sze) { // new key
val x1149: generated.scala.DeliteArrayAnon201185238 = __act.x3708_hash_data
val x1146: generated.scala.Anon201185238 = x3651
val x2836 = x3708x3734_sze
val x2837 = x1149.returnFlag
val x2838 = x2837.length
val x2839 = x2838 - 1
val x2840 = x2836 > x2839
val x2908 = {
def x2908thenb(): Unit = {
val x2841 = x2838 < 16
val x2845 = {
def x2845thenb(): Int = {
16
}
def x2845elseb(): Int = {
val x2842 = x2838 * 2
val x2843 = x2842 < 0
val x2844 = {
def x2844thenb(): Int = {
2147483647
}
def x2844elseb(): Int = {
x2842
}
if (x2843) {
x2844thenb()
} else { 
x2844elseb()
}
}
x2844
}
if (x2841) {
x2845thenb()
} else { 
x2845elseb()
}
}
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2846 = new Array[Char](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2847 = new Array[Char](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2848 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2849 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2850 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2851 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2852 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2853 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2854 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2855 = new Array[Int](x2845.toInt)
val x2856 = System.arraycopy(x2837,0.toInt,x2846,0.toInt,x2838.toInt)
val x2857 = x1149.lineStatus
val x2858 = System.arraycopy(x2857,0.toInt,x2847,0.toInt,x2838.toInt)
val x2859 = x1149.sumQty
val x2860 = System.arraycopy(x2859,0.toInt,x2848,0.toInt,x2838.toInt)
val x2861 = x1149.sumBasePrice
val x2862 = System.arraycopy(x2861,0.toInt,x2849,0.toInt,x2838.toInt)
val x2863 = x1149.sumDiscountedPrice
val x2864 = System.arraycopy(x2863,0.toInt,x2850,0.toInt,x2838.toInt)
val x2865 = x1149.sumCharge
val x2866 = System.arraycopy(x2865,0.toInt,x2851,0.toInt,x2838.toInt)
val x2867 = x1149.avgQty
val x2868 = System.arraycopy(x2867,0.toInt,x2852,0.toInt,x2838.toInt)
val x2869 = x1149.avgPrice
val x2870 = System.arraycopy(x2869,0.toInt,x2853,0.toInt,x2838.toInt)
val x2871 = x1149.avgDiscount
val x2872 = System.arraycopy(x2871,0.toInt,x2854,0.toInt,x2838.toInt)
val x2873 = x1149.countOrder
val x2874 = System.arraycopy(x2873,0.toInt,x2855,0.toInt,x2838.toInt)
val x1185 = x1146.returnFlag
val x2875 = x2846(x2836.toInt) = x1185
val x1188 = x1146.lineStatus
val x2876 = x2847(x2836.toInt) = x1188
val x1191 = x1146.sumQty
val x2877 = x2848(x2836.toInt) = x1191
val x1194 = x1146.sumBasePrice
val x2878 = x2849(x2836.toInt) = x1194
val x1197 = x1146.sumDiscountedPrice
val x2879 = x2850(x2836.toInt) = x1197
val x1200 = x1146.sumCharge
val x2880 = x2851(x2836.toInt) = x1200
val x1203 = x1146.avgQty
val x2881 = x2852(x2836.toInt) = x1203
val x1206 = x1146.avgPrice
val x2882 = x2853(x2836.toInt) = x1206
val x1209 = x1146.avgDiscount
val x2883 = x2854(x2836.toInt) = x1209
val x1212 = x1146.countOrder
val x2884 = x2855(x2836.toInt) = x1212
val x2885 = new generated.scala.DeliteArrayAnon201185238(x2846,x2847,x2848,x2849,x2850,x2851,x2852,x2853,x2854,x2855)
val x2886 = __act.x3708_hash_data = x2885
x2886
}
def x2908elseb(): Unit = {
val x1185 = x1146.returnFlag
val x2888 = x1149.returnFlag(x2836.toInt) = x1185
val x2889 = x1149.lineStatus
val x1188 = x1146.lineStatus
val x2890 = x1149.lineStatus(x2836.toInt) = x1188
val x2891 = x1149.sumQty
val x1191 = x1146.sumQty
val x2892 = x1149.sumQty(x2836.toInt) = x1191
val x2893 = x1149.sumBasePrice
val x1194 = x1146.sumBasePrice
val x2894 = x1149.sumBasePrice(x2836.toInt) = x1194
val x2895 = x1149.sumDiscountedPrice
val x1197 = x1146.sumDiscountedPrice
val x2896 = x1149.sumDiscountedPrice(x2836.toInt) = x1197
val x2897 = x1149.sumCharge
val x1200 = x1146.sumCharge
val x2898 = x1149.sumCharge(x2836.toInt) = x1200
val x2899 = x1149.avgQty
val x1203 = x1146.avgQty
val x2900 = x1149.avgQty(x2836.toInt) = x1203
val x2901 = x1149.avgPrice
val x1206 = x1146.avgPrice
val x2902 = x1149.avgPrice(x2836.toInt) = x1206
val x2903 = x1149.avgDiscount
val x1209 = x1146.avgDiscount
val x2904 = x1149.avgDiscount(x2836.toInt) = x1209
val x2905 = x1149.countOrder
val x1212 = x1146.countOrder
val x2906 = x1149.countOrder(x2836.toInt) = x1212
()
}
if (x2840) {
x2908thenb()
} else { 
x2908elseb()
}
}
val x1473: Array[Int] = __act.x3734_hash_data
val x1470: Int = 1
val x2974 = x3708x3734_sze
val x2975 = x1473.length
val x2976 = x2975 - 1
val x2977 = x2974 > x2976
val x2990 = {
def x2990thenb(): Unit = {
val x2978 = x2975 < 16
val x2982 = {
def x2982thenb(): Int = {
16
}
def x2982elseb(): Int = {
val x2979 = x2975 * 2
val x2980 = x2979 < 0
val x2981 = {
def x2981thenb(): Int = {
2147483647
}
def x2981elseb(): Int = {
x2979
}
if (x2980) {
x2981thenb()
} else { 
x2981elseb()
}
}
x2981
}
if (x2978) {
x2982thenb()
} else { 
x2982elseb()
}
}
if (x2982 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2983 = new Array[Int](x2982.toInt)
val x2984 = System.arraycopy(x1473,0.toInt,x2983,0.toInt,x2975.toInt)
val x2985 = x2983(x2974.toInt) = x1470
val x2986 = __act.x3734_hash_data = x2983
x2986
}
def x2990elseb(): Unit = {
val x2988 = x1473(x2974.toInt) = x1470
x2988
}
if (x2977) {
x2990thenb()
} else { 
x2990elseb()
}
}
} else { // existing key
val x1148: Int = x3708x3734_idx
val x1149: generated.scala.DeliteArrayAnon201185238 = __act.x3708_hash_data
val x2791 = x1149.returnFlag
val x2792 = x1149.lineStatus
val x2793 = x1149.sumQty
val x2794 = x1149.sumBasePrice
val x2795 = x1149.sumDiscountedPrice
val x2796 = x1149.sumCharge
val x2797 = x1149.avgQty
val x2798 = x1149.avgPrice
val x2799 = x1149.avgDiscount
val x2800 = x1149.countOrder
val x2801 = x2791(x1148.toInt)
val x2802 = x2792(x1148.toInt)
val x2803 = x2793(x1148.toInt)
val x2804 = x2794(x1148.toInt)
val x2805 = x2795(x1148.toInt)
val x2806 = x2796(x1148.toInt)
val x2807 = x2797(x1148.toInt)
val x2808 = x2798(x1148.toInt)
val x2809 = x2799(x1148.toInt)
val x2810 = x2800(x1148.toInt)
val x2811 = new generated.scala.Anon201185238(x2801,x2802,x2803,x2804,x2805,x2806,x2807,x2808,x2809,x2810)
val x1115: generated.scala.Anon201185238 = x2811
val x1116: generated.scala.Anon201185238 = x3651
val x1117 = x1115.returnFlag
val x1119 = x1115.lineStatus
val x1121 = x1115.sumQty
val x1122 = x1116.sumQty
val x1123 = {
x1121 + x1122}
val x1124 = x1115.sumBasePrice
val x1125 = x1116.sumBasePrice
val x1126 = {
x1124 + x1125}
val x1127 = x1115.sumDiscountedPrice
val x1128 = x1116.sumDiscountedPrice
val x1129 = {
x1127 + x1128}
val x1130 = x1115.sumCharge
val x1131 = x1116.sumCharge
val x1132 = {
x1130 + x1131}
val x1133 = x1115.avgQty
val x1134 = x1116.avgQty
val x1135 = {
x1133 + x1134}
val x1136 = x1115.avgPrice
val x1137 = x1116.avgPrice
val x1138 = {
x1136 + x1137}
val x1139 = x1115.avgDiscount
val x1140 = x1116.avgDiscount
val x1141 = {
x1139 + x1140}
val x1142 = x1115.countOrder
val x1143 = x1116.countOrder
val x1144 = {
x1142 + x1143}
val x1145 = new generated.scala.Anon201185238(x1117,x1119,x1123,x1126,x1129,x1132,x1135,x1138,x1141,x1144)
val x1146: generated.scala.Anon201185238 = x1145
val x2813 = x1149.returnFlag
val x1185 = x1146.returnFlag
val x2814 = x1149.returnFlag(x1148.toInt) = x1185
val x2815 = x1149.lineStatus
val x1188 = x1146.lineStatus
val x2816 = x1149.lineStatus(x1148.toInt) = x1188
val x2817 = x1149.sumQty
val x1191 = x1146.sumQty
val x2818 = x1149.sumQty(x1148.toInt) = x1191
val x2819 = x1149.sumBasePrice
val x1194 = x1146.sumBasePrice
val x2820 = x1149.sumBasePrice(x1148.toInt) = x1194
val x2821 = x1149.sumDiscountedPrice
val x1197 = x1146.sumDiscountedPrice
val x2822 = x1149.sumDiscountedPrice(x1148.toInt) = x1197
val x2823 = x1149.sumCharge
val x1200 = x1146.sumCharge
val x2824 = x1149.sumCharge(x1148.toInt) = x1200
val x2825 = x1149.avgQty
val x1203 = x1146.avgQty
val x2826 = x1149.avgQty(x1148.toInt) = x1203
val x2827 = x1149.avgPrice
val x1206 = x1146.avgPrice
val x2828 = x1149.avgPrice(x1148.toInt) = x1206
val x2829 = x1149.avgDiscount
val x1209 = x1146.avgDiscount
val x2830 = x1149.avgDiscount(x1148.toInt) = x1209
val x2831 = x1149.countOrder
val x1212 = x1146.countOrder
val x2832 = x1149.countOrder(x1148.toInt) = x1212
val x1472: Int = x3708x3734_idx
val x1473: Array[Int] = __act.x3734_hash_data
val x2968 = x1473(x1472.toInt)
val x1467: Int = x2968
val x1468: Int = 1
val x1469 = x1467 + x1468
val x1470: Int = x1469
val x2970 = x1473(x1472.toInt) = x1470
}
}
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3708x3734,rhs:activation_x3708x3734): Unit = {
// common key Block(Sym(3646)) for x3708x3734
if (__act.x3708x3734_size == -1) __act.x3708x3734_size = __act.x3708x3734_hash_pos.size
if (rhs.x3708x3734_size == -1) rhs.x3708x3734_size = rhs.x3708x3734_hash_pos.size
var x3708x3734rhs_idx: Int = 0
while (x3708x3734rhs_idx < rhs.x3708x3734_hash_pos.size) {
val x3708x3734_k: generated.scala.Tup2CharChar = rhs.x3708x3734_hash_pos.unsafeKeys(x3708x3734rhs_idx.toInt)
val x3708x3734_sze: Int = __act.x3708x3734_hash_pos.size
val x3708x3734_idx: Int = __act.x3708x3734_hash_pos.put(x3708x3734_k)
if (x3708x3734_idx == x3708x3734_sze) { // new key
var x1149: generated.scala.DeliteArrayAnon201185238 = rhs.x3708_hash_data
val x1148: Int = x3708x3734rhs_idx
val x2791 = x1149.returnFlag
val x2792 = x1149.lineStatus
val x2793 = x1149.sumQty
val x2794 = x1149.sumBasePrice
val x2795 = x1149.sumDiscountedPrice
val x2796 = x1149.sumCharge
val x2797 = x1149.avgQty
val x2798 = x1149.avgPrice
val x2799 = x1149.avgDiscount
val x2800 = x1149.countOrder
val x2801 = x2791(x1148.toInt)
val x2802 = x2792(x1148.toInt)
val x2803 = x2793(x1148.toInt)
val x2804 = x2794(x1148.toInt)
val x2805 = x2795(x1148.toInt)
val x2806 = x2796(x1148.toInt)
val x2807 = x2797(x1148.toInt)
val x2808 = x2798(x1148.toInt)
val x2809 = x2799(x1148.toInt)
val x2810 = x2800(x1148.toInt)
val x2811 = new generated.scala.Anon201185238(x2801,x2802,x2803,x2804,x2805,x2806,x2807,x2808,x2809,x2810)
x1149 = __act.x3708_hash_data
val x1146: generated.scala.Anon201185238 = x2811
val x2836 = x3708x3734_sze
val x2837 = x1149.returnFlag
val x2838 = x2837.length
val x2839 = x2838 - 1
val x2840 = x2836 > x2839
val x2908 = {
def x2908thenb(): Unit = {
val x2841 = x2838 < 16
val x2845 = {
def x2845thenb(): Int = {
16
}
def x2845elseb(): Int = {
val x2842 = x2838 * 2
val x2843 = x2842 < 0
val x2844 = {
def x2844thenb(): Int = {
2147483647
}
def x2844elseb(): Int = {
x2842
}
if (x2843) {
x2844thenb()
} else { 
x2844elseb()
}
}
x2844
}
if (x2841) {
x2845thenb()
} else { 
x2845elseb()
}
}
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2846 = new Array[Char](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2847 = new Array[Char](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2848 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2849 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2850 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2851 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2852 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2853 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2854 = new Array[Double](x2845.toInt)
if (x2845 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2855 = new Array[Int](x2845.toInt)
val x2856 = System.arraycopy(x2837,0.toInt,x2846,0.toInt,x2838.toInt)
val x2857 = x1149.lineStatus
val x2858 = System.arraycopy(x2857,0.toInt,x2847,0.toInt,x2838.toInt)
val x2859 = x1149.sumQty
val x2860 = System.arraycopy(x2859,0.toInt,x2848,0.toInt,x2838.toInt)
val x2861 = x1149.sumBasePrice
val x2862 = System.arraycopy(x2861,0.toInt,x2849,0.toInt,x2838.toInt)
val x2863 = x1149.sumDiscountedPrice
val x2864 = System.arraycopy(x2863,0.toInt,x2850,0.toInt,x2838.toInt)
val x2865 = x1149.sumCharge
val x2866 = System.arraycopy(x2865,0.toInt,x2851,0.toInt,x2838.toInt)
val x2867 = x1149.avgQty
val x2868 = System.arraycopy(x2867,0.toInt,x2852,0.toInt,x2838.toInt)
val x2869 = x1149.avgPrice
val x2870 = System.arraycopy(x2869,0.toInt,x2853,0.toInt,x2838.toInt)
val x2871 = x1149.avgDiscount
val x2872 = System.arraycopy(x2871,0.toInt,x2854,0.toInt,x2838.toInt)
val x2873 = x1149.countOrder
val x2874 = System.arraycopy(x2873,0.toInt,x2855,0.toInt,x2838.toInt)
val x1185 = x1146.returnFlag
val x2875 = x2846(x2836.toInt) = x1185
val x1188 = x1146.lineStatus
val x2876 = x2847(x2836.toInt) = x1188
val x1191 = x1146.sumQty
val x2877 = x2848(x2836.toInt) = x1191
val x1194 = x1146.sumBasePrice
val x2878 = x2849(x2836.toInt) = x1194
val x1197 = x1146.sumDiscountedPrice
val x2879 = x2850(x2836.toInt) = x1197
val x1200 = x1146.sumCharge
val x2880 = x2851(x2836.toInt) = x1200
val x1203 = x1146.avgQty
val x2881 = x2852(x2836.toInt) = x1203
val x1206 = x1146.avgPrice
val x2882 = x2853(x2836.toInt) = x1206
val x1209 = x1146.avgDiscount
val x2883 = x2854(x2836.toInt) = x1209
val x1212 = x1146.countOrder
val x2884 = x2855(x2836.toInt) = x1212
val x2885 = new generated.scala.DeliteArrayAnon201185238(x2846,x2847,x2848,x2849,x2850,x2851,x2852,x2853,x2854,x2855)
val x2886 = __act.x3708_hash_data = x2885
x2886
}
def x2908elseb(): Unit = {
val x1185 = x1146.returnFlag
val x2888 = x1149.returnFlag(x2836.toInt) = x1185
val x2889 = x1149.lineStatus
val x1188 = x1146.lineStatus
val x2890 = x1149.lineStatus(x2836.toInt) = x1188
val x2891 = x1149.sumQty
val x1191 = x1146.sumQty
val x2892 = x1149.sumQty(x2836.toInt) = x1191
val x2893 = x1149.sumBasePrice
val x1194 = x1146.sumBasePrice
val x2894 = x1149.sumBasePrice(x2836.toInt) = x1194
val x2895 = x1149.sumDiscountedPrice
val x1197 = x1146.sumDiscountedPrice
val x2896 = x1149.sumDiscountedPrice(x2836.toInt) = x1197
val x2897 = x1149.sumCharge
val x1200 = x1146.sumCharge
val x2898 = x1149.sumCharge(x2836.toInt) = x1200
val x2899 = x1149.avgQty
val x1203 = x1146.avgQty
val x2900 = x1149.avgQty(x2836.toInt) = x1203
val x2901 = x1149.avgPrice
val x1206 = x1146.avgPrice
val x2902 = x1149.avgPrice(x2836.toInt) = x1206
val x2903 = x1149.avgDiscount
val x1209 = x1146.avgDiscount
val x2904 = x1149.avgDiscount(x2836.toInt) = x1209
val x2905 = x1149.countOrder
val x1212 = x1146.countOrder
val x2906 = x1149.countOrder(x2836.toInt) = x1212
()
}
if (x2840) {
x2908thenb()
} else { 
x2908elseb()
}
}
var x1473: Array[Int] = rhs.x3734_hash_data
val x1472: Int = x3708x3734rhs_idx
val x2968 = x1473(x1472.toInt)
x1473 = __act.x3734_hash_data
val x1470: Int = x2968
val x2974 = x3708x3734_sze
val x2975 = x1473.length
val x2976 = x2975 - 1
val x2977 = x2974 > x2976
val x2990 = {
def x2990thenb(): Unit = {
val x2978 = x2975 < 16
val x2982 = {
def x2982thenb(): Int = {
16
}
def x2982elseb(): Int = {
val x2979 = x2975 * 2
val x2980 = x2979 < 0
val x2981 = {
def x2981thenb(): Int = {
2147483647
}
def x2981elseb(): Int = {
x2979
}
if (x2980) {
x2981thenb()
} else { 
x2981elseb()
}
}
x2981
}
if (x2978) {
x2982thenb()
} else { 
x2982elseb()
}
}
if (x2982 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2983 = new Array[Int](x2982.toInt)
val x2984 = System.arraycopy(x1473,0.toInt,x2983,0.toInt,x2975.toInt)
val x2985 = x2983(x2974.toInt) = x1470
val x2986 = __act.x3734_hash_data = x2983
x2986
}
def x2990elseb(): Unit = {
val x2988 = x1473(x2974.toInt) = x1470
x2988
}
if (x2977) {
x2990thenb()
} else { 
x2990elseb()
}
}
} else { // existing key
val x1149: generated.scala.DeliteArrayAnon201185238 = rhs.x3708_hash_data
val x1148: Int = x3708x3734rhs_idx
val x2791 = x1149.returnFlag
val x2792 = x1149.lineStatus
val x2793 = x1149.sumQty
val x2794 = x1149.sumBasePrice
val x2795 = x1149.sumDiscountedPrice
val x2796 = x1149.sumCharge
val x2797 = x1149.avgQty
val x2798 = x1149.avgPrice
val x2799 = x1149.avgDiscount
val x2800 = x1149.countOrder
val x2801 = x2791(x1148.toInt)
val x2802 = x2792(x1148.toInt)
val x2803 = x2793(x1148.toInt)
val x2804 = x2794(x1148.toInt)
val x2805 = x2795(x1148.toInt)
val x2806 = x2796(x1148.toInt)
val x2807 = x2797(x1148.toInt)
val x2808 = x2798(x1148.toInt)
val x2809 = x2799(x1148.toInt)
val x2810 = x2800(x1148.toInt)
val x2811 = new generated.scala.Anon201185238(x2801,x2802,x2803,x2804,x2805,x2806,x2807,x2808,x2809,x2810)
val x3708_v: generated.scala.Anon201185238 = x2811
val x3708_reduce_block: Unit = {
val x1149: generated.scala.DeliteArrayAnon201185238 = __act.x3708_hash_data
val x1148: Int = x3708x3734_idx
val x2791 = x1149.returnFlag
val x2792 = x1149.lineStatus
val x2793 = x1149.sumQty
val x2794 = x1149.sumBasePrice
val x2795 = x1149.sumDiscountedPrice
val x2796 = x1149.sumCharge
val x2797 = x1149.avgQty
val x2798 = x1149.avgPrice
val x2799 = x1149.avgDiscount
val x2800 = x1149.countOrder
val x2801 = x2791(x1148.toInt)
val x2802 = x2792(x1148.toInt)
val x2803 = x2793(x1148.toInt)
val x2804 = x2794(x1148.toInt)
val x2805 = x2795(x1148.toInt)
val x2806 = x2796(x1148.toInt)
val x2807 = x2797(x1148.toInt)
val x2808 = x2798(x1148.toInt)
val x2809 = x2799(x1148.toInt)
val x2810 = x2800(x1148.toInt)
val x2811 = new generated.scala.Anon201185238(x2801,x2802,x2803,x2804,x2805,x2806,x2807,x2808,x2809,x2810)
val x1115: generated.scala.Anon201185238 = x2811
val x1116: generated.scala.Anon201185238 = x3708_v
val x1117 = x1115.returnFlag
val x1119 = x1115.lineStatus
val x1121 = x1115.sumQty
val x1122 = x1116.sumQty
val x1123 = {
x1121 + x1122}
val x1124 = x1115.sumBasePrice
val x1125 = x1116.sumBasePrice
val x1126 = {
x1124 + x1125}
val x1127 = x1115.sumDiscountedPrice
val x1128 = x1116.sumDiscountedPrice
val x1129 = {
x1127 + x1128}
val x1130 = x1115.sumCharge
val x1131 = x1116.sumCharge
val x1132 = {
x1130 + x1131}
val x1133 = x1115.avgQty
val x1134 = x1116.avgQty
val x1135 = {
x1133 + x1134}
val x1136 = x1115.avgPrice
val x1137 = x1116.avgPrice
val x1138 = {
x1136 + x1137}
val x1139 = x1115.avgDiscount
val x1140 = x1116.avgDiscount
val x1141 = {
x1139 + x1140}
val x1142 = x1115.countOrder
val x1143 = x1116.countOrder
val x1144 = {
x1142 + x1143}
val x1145 = new generated.scala.Anon201185238(x1117,x1119,x1123,x1126,x1129,x1132,x1135,x1138,x1141,x1144)
val x1146: generated.scala.Anon201185238 = x1145
val x2813 = x1149.returnFlag
val x1185 = x1146.returnFlag
val x2814 = x1149.returnFlag(x1148.toInt) = x1185
val x2815 = x1149.lineStatus
val x1188 = x1146.lineStatus
val x2816 = x1149.lineStatus(x1148.toInt) = x1188
val x2817 = x1149.sumQty
val x1191 = x1146.sumQty
val x2818 = x1149.sumQty(x1148.toInt) = x1191
val x2819 = x1149.sumBasePrice
val x1194 = x1146.sumBasePrice
val x2820 = x1149.sumBasePrice(x1148.toInt) = x1194
val x2821 = x1149.sumDiscountedPrice
val x1197 = x1146.sumDiscountedPrice
val x2822 = x1149.sumDiscountedPrice(x1148.toInt) = x1197
val x2823 = x1149.sumCharge
val x1200 = x1146.sumCharge
val x2824 = x1149.sumCharge(x1148.toInt) = x1200
val x2825 = x1149.avgQty
val x1203 = x1146.avgQty
val x2826 = x1149.avgQty(x1148.toInt) = x1203
val x2827 = x1149.avgPrice
val x1206 = x1146.avgPrice
val x2828 = x1149.avgPrice(x1148.toInt) = x1206
val x2829 = x1149.avgDiscount
val x1209 = x1146.avgDiscount
val x2830 = x1149.avgDiscount(x1148.toInt) = x1209
val x2831 = x1149.countOrder
val x1212 = x1146.countOrder
val x2832 = x1149.countOrder(x1148.toInt) = x1212
}
val x1473: Array[Int] = rhs.x3734_hash_data
val x1472: Int = x3708x3734rhs_idx
val x2968 = x1473(x1472.toInt)
val x3734_v: Int = x2968
val x3734_reduce_block: Unit = {
val x1473: Array[Int] = __act.x3734_hash_data
val x1472: Int = x3708x3734_idx
val x2968 = x1473(x1472.toInt)
val x1467: Int = x2968
val x1468: Int = x3734_v
val x1469 = x1467 + x1468
val x1470: Int = x1469
val x2970 = x1473(x1472.toInt) = x1470
}
}
x3708x3734rhs_idx = x3708x3734rhs_idx+1
}
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3708x3734,lhs:activation_x3708x3734): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3708x3734): Unit = {
val tid: Int = resourceInfo.groupId
if (tid > 0) {
val all_acts: Array[activation_x3708x3734] = new Array[activation_x3708x3734](resourceInfo.groupSize)
var currentAct: activation_x3708x3734 = __act
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

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3708x3734): Unit = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
if (__act.all_acts ne null) {
val all_acts: Array[activation_x3708x3734] = __act.all_acts
val x3708x3734_globalKeys: Array[generated.scala.Tup2CharChar] = __act.all_acts(0).x3708x3734_hash_pos.unsafeKeys
var x3708x3734_idx: Int = ((__act.all_acts(0).x3708x3734_hash_pos.size).asInstanceOf[Long] * tid / numThreads).asInstanceOf[Int]
val x3708x3734_end: Int = ((__act.all_acts(0).x3708x3734_hash_pos.size).asInstanceOf[Long] * (tid+1) / numThreads).asInstanceOf[Int]
while (x3708x3734_idx < x3708x3734_end) {
x3708x3734_idx = x3708x3734_idx + 1
}
}
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x3708x3734): Unit = {
val x3708x3734_sze: Int = __act.x3708x3734_hash_pos.size
var x1149: generated.scala.DeliteArrayAnon201185238 = __act.x3708_hash_data
val x1147: Int = x3708x3734_sze
val x2910 = x1149.returnFlag
val x2911 = x2910.length
val x2912 = x2911 > x1147
val x2945 = {
def x2945thenb(): Unit = {
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2913 = new Array[Char](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2914 = new Array[Char](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2915 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2916 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2917 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2918 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2919 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2920 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2921 = new Array[Double](x1147.toInt)
if (x1147 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2922 = new Array[Int](x1147.toInt)
val x2923 = System.arraycopy(x2910,0.toInt,x2913,0.toInt,x1147.toInt)
val x2924 = x1149.lineStatus
val x2925 = System.arraycopy(x2924,0.toInt,x2914,0.toInt,x1147.toInt)
val x2926 = x1149.sumQty
val x2927 = System.arraycopy(x2926,0.toInt,x2915,0.toInt,x1147.toInt)
val x2928 = x1149.sumBasePrice
val x2929 = System.arraycopy(x2928,0.toInt,x2916,0.toInt,x1147.toInt)
val x2930 = x1149.sumDiscountedPrice
val x2931 = System.arraycopy(x2930,0.toInt,x2917,0.toInt,x1147.toInt)
val x2932 = x1149.sumCharge
val x2933 = System.arraycopy(x2932,0.toInt,x2918,0.toInt,x1147.toInt)
val x2934 = x1149.avgQty
val x2935 = System.arraycopy(x2934,0.toInt,x2919,0.toInt,x1147.toInt)
val x2936 = x1149.avgPrice
val x2937 = System.arraycopy(x2936,0.toInt,x2920,0.toInt,x1147.toInt)
val x2938 = x1149.avgDiscount
val x2939 = System.arraycopy(x2938,0.toInt,x2921,0.toInt,x1147.toInt)
val x2940 = x1149.countOrder
val x2941 = System.arraycopy(x2940,0.toInt,x2922,0.toInt,x1147.toInt)
val x2942 = new generated.scala.DeliteArrayAnon201185238(x2913,x2914,x2915,x2916,x2917,x2918,x2919,x2920,x2921,x2922)
val x2943 = x1149 = x2942
x2943
}
if (x2912) {
x2945thenb()
}
}
__act.x3708 = x1149
var x1473: Array[Int] = __act.x3734_hash_data
val x1471: Int = x3708x3734_sze
val x2992 = x1473.length
val x2993 = x2992 > x1471
val x2998 = {
def x2998thenb(): Unit = {
if (x1471 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2994 = new Array[Int](x1471.toInt)
val x2995 = System.arraycopy(x1473,0.toInt,x2994,0.toInt,x1471.toInt)
val x2996 = x1473 = x2994
x2996
}
if (x2993) {
x2998thenb()
}
}
__act.x3734 = x1473
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x3708x3734 = {
val act: activation_x3708x3734 = new activation_x3708x3734
act.x3708x3734_hash_pos = new generated.scala.container.HashMapImpl[generated.scala.Tup2CharChar](512,128)
act
}

}
x3708x3734_closure.loopStart = 0
x3708x3734_closure.loopSize = x2
val alloc: activation_x3708x3734 = x3708x3734_closure.alloc(resourceInfo)
var x3708x3734: activation_x3708x3734 = null
if (resourceInfo.availableThreads <= 1) {
x3708x3734 = x3708x3734_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x3708x3734] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x3708x3734](x3708x3734_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x3708x3734_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x3708x3734 = x3708x3734_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x3708x3734
}}

/**********/


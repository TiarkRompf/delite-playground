package generated.scala
//activation record for fat loop
final class activation_x2954x3648 {
var left_act: activation_x2954x3648 = _
var all_acts: Array[activation_x2954x3648] = _
var x2954x3648_hash_pos: generated.scala.container.HashMapImpl[generated.scala.Tup2CharChar] = _
var x2954x3648_size: Int = _
var x2954: generated.scala.DeliteArrayAnon201185238 = _
var x2954_hash_data: generated.scala.DeliteArrayAnon201185238 = _
var x3648: Array[Int] = _
var x3648_hash_data: Array[Int] = _
}
object activation_x2954x3648 {
}
object kernel_x2954x3648 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2765:Int,x1115:generated.scala.Anon201185238,x2291:Array[Double],x2334:Array[Double],x2377:Array[Double],x2420:Array[Double],x2463:Array[Char],x2506:Array[Char],x2549:Array[Int],x425:Int): activation_x2954x3648 = {
val x2954x3648_closure = new generated.scala.DeliteOpMultiLoop[activation_x2954x3648] {
def size(resourceInfo:generated.scala.ResourceInfo): Long = {
x2765
}

var loopStart: Long = _
var loopSize: Long = _
def alloc(resourceInfo:generated.scala.ResourceInfo): activation_x2954x3648 = {
val __act: activation_x2954x3648 = new activation_x2954x3648()
__act
}

def main_par(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2954x3648,sync:ppl.delite.runtime.sync.MultiLoopSync[activation_x2954x3648]): activation_x2954x3648 = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
//process local
val numChunks: Int = sync.numChunks
var dIdx: Int = tid
while (dIdx < numChunks) {
val start: Long = loopStart + loopSize*dIdx/numChunks
val end: Long = loopStart + loopSize*(dIdx+1)/numChunks
val act: activation_x2954x3648 = processRange(resourceInfo,__act,start,end)
sync.set(dIdx,act)
dIdx = sync.getNextChunkIdx
}
val localStart: Int = tid*numChunks/numThreads
val localEnd: Int = (tid+1)*numChunks/numThreads
val act: activation_x2954x3648 = sync.get(localStart)
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

def main_seq(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2954x3648): activation_x2954x3648 = {
val act: activation_x2954x3648 = processRange(resourceInfo,__act,loopStart,loopStart+loopSize)
finalize(resourceInfo,act)
act
}

def processRange(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2954x3648,start:Long,end:Long): activation_x2954x3648 = {
val isEmpty: Boolean = end-start <= 0
var idx: Int = (start).asInstanceOf[Int]
val __act2: activation_x2954x3648 = init(resourceInfo,__act,idx,isEmpty)
idx = idx + 1
while (idx < end) {
process(resourceInfo,__act2,idx)
idx = idx + 1
}
__act2
}

def init(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2954x3648,x1090:Int,isEmpty:Boolean): activation_x2954x3648 = {
val __act2: activation_x2954x3648 = new activation_x2954x3648()
__act2.x2954x3648_hash_pos = new generated.scala.container.HashMapImpl[generated.scala.Tup2CharChar](512,128)
__act2.x2954x3648_size = -1
val x1148: Int = 128
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2782 = new Array[Char](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2783 = new Array[Char](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2784 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2785 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2786 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2787 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2788 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2789 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2790 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2791 = new Array[Int](x1148.toInt)
val x2792 = new generated.scala.DeliteArrayAnon201185238(x2782,x2783,x2784,x2785,x2786,x2787,x2788,x2789,x2790,x2791)
__act2.x2954_hash_data = x2792
val x1472: Int = 128
if (x1472 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2969 = new Array[Int](x1472.toInt)
__act2.x3648_hash_data = x2969
if (!isEmpty) {
val x2771 = x2291(x1090.toInt)
val x2772 = x2334(x1090.toInt)
val x2773 = x2377(x1090.toInt)
val x2774 = {
1.0 - x2773}
val x2775 = {
x2772 * x2774}
val x2776 = x2420(x1090.toInt)
val x2777 = {
1.0 + x2776}
val x2778 = {
x2775 * x2777}
val x2768 = x2463(x1090.toInt)
val x2769 = x2506(x1090.toInt)
val x2779 = new generated.scala.Anon201185238(x2768,x2769,x2771,x2772,x2775,x2778,x2771,x2772,x2773,1)
val x2770 = new generated.scala.Tup2CharChar(x2768,x2769)
val x2780 = x2549(x1090.toInt)
val x2781 = {
x2780 <= x425}
if (x2781) {
// common key Block(Sym(2770)) for x2954x3648
val x2954x3648_sze: Int = __act2.x2954x3648_hash_pos.size
val x2954x3648_idx: Int = __act2.x2954x3648_hash_pos.put(x2770)
if (x2954x3648_idx == x2954x3648_sze) { // new key
val x1150: generated.scala.DeliteArrayAnon201185238 = __act2.x2954_hash_data
val x1147: generated.scala.Anon201185238 = x2779
val x2839 = x2954x3648_sze
val x2840 = x1150.returnFlag
val x2841 = x2840.length
val x2842 = x2841 - 1
val x2843 = x2839 > x2842
val x2911 = {
def x2911thenb(): Unit = {
val x2844 = x2841 < 16
val x2848 = {
def x2848thenb(): Int = {
16
}
def x2848elseb(): Int = {
val x2845 = x2841 * 2
val x2846 = x2845 < 0
val x2847 = {
def x2847thenb(): Int = {
2147483647
}
def x2847elseb(): Int = {
x2845
}
if (x2846) {
x2847thenb()
} else { 
x2847elseb()
}
}
x2847
}
if (x2844) {
x2848thenb()
} else { 
x2848elseb()
}
}
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2849 = new Array[Char](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2850 = new Array[Char](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2851 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2852 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2853 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2854 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2855 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2856 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2857 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2858 = new Array[Int](x2848.toInt)
val x2859 = System.arraycopy(x2840,0.toInt,x2849,0.toInt,x2841.toInt)
val x2860 = x1150.lineStatus
val x2861 = System.arraycopy(x2860,0.toInt,x2850,0.toInt,x2841.toInt)
val x2862 = x1150.sumQty
val x2863 = System.arraycopy(x2862,0.toInt,x2851,0.toInt,x2841.toInt)
val x2864 = x1150.sumBasePrice
val x2865 = System.arraycopy(x2864,0.toInt,x2852,0.toInt,x2841.toInt)
val x2866 = x1150.sumDiscountedPrice
val x2867 = System.arraycopy(x2866,0.toInt,x2853,0.toInt,x2841.toInt)
val x2868 = x1150.sumCharge
val x2869 = System.arraycopy(x2868,0.toInt,x2854,0.toInt,x2841.toInt)
val x2870 = x1150.avgQty
val x2871 = System.arraycopy(x2870,0.toInt,x2855,0.toInt,x2841.toInt)
val x2872 = x1150.avgPrice
val x2873 = System.arraycopy(x2872,0.toInt,x2856,0.toInt,x2841.toInt)
val x2874 = x1150.avgDiscount
val x2875 = System.arraycopy(x2874,0.toInt,x2857,0.toInt,x2841.toInt)
val x2876 = x1150.countOrder
val x2877 = System.arraycopy(x2876,0.toInt,x2858,0.toInt,x2841.toInt)
val x1186 = x1147.returnFlag
val x2878 = x2849(x2839.toInt) = x1186
val x1189 = x1147.lineStatus
val x2879 = x2850(x2839.toInt) = x1189
val x1192 = x1147.sumQty
val x2880 = x2851(x2839.toInt) = x1192
val x1195 = x1147.sumBasePrice
val x2881 = x2852(x2839.toInt) = x1195
val x1198 = x1147.sumDiscountedPrice
val x2882 = x2853(x2839.toInt) = x1198
val x1201 = x1147.sumCharge
val x2883 = x2854(x2839.toInt) = x1201
val x1204 = x1147.avgQty
val x2884 = x2855(x2839.toInt) = x1204
val x1207 = x1147.avgPrice
val x2885 = x2856(x2839.toInt) = x1207
val x1210 = x1147.avgDiscount
val x2886 = x2857(x2839.toInt) = x1210
val x1213 = x1147.countOrder
val x2887 = x2858(x2839.toInt) = x1213
val x2888 = new generated.scala.DeliteArrayAnon201185238(x2849,x2850,x2851,x2852,x2853,x2854,x2855,x2856,x2857,x2858)
val x2889 = __act2.x2954_hash_data = x2888
x2889
}
def x2911elseb(): Unit = {
val x1186 = x1147.returnFlag
val x2891 = x1150.returnFlag(x2839.toInt) = x1186
val x2892 = x1150.lineStatus
val x1189 = x1147.lineStatus
val x2893 = x1150.lineStatus(x2839.toInt) = x1189
val x2894 = x1150.sumQty
val x1192 = x1147.sumQty
val x2895 = x1150.sumQty(x2839.toInt) = x1192
val x2896 = x1150.sumBasePrice
val x1195 = x1147.sumBasePrice
val x2897 = x1150.sumBasePrice(x2839.toInt) = x1195
val x2898 = x1150.sumDiscountedPrice
val x1198 = x1147.sumDiscountedPrice
val x2899 = x1150.sumDiscountedPrice(x2839.toInt) = x1198
val x2900 = x1150.sumCharge
val x1201 = x1147.sumCharge
val x2901 = x1150.sumCharge(x2839.toInt) = x1201
val x2902 = x1150.avgQty
val x1204 = x1147.avgQty
val x2903 = x1150.avgQty(x2839.toInt) = x1204
val x2904 = x1150.avgPrice
val x1207 = x1147.avgPrice
val x2905 = x1150.avgPrice(x2839.toInt) = x1207
val x2906 = x1150.avgDiscount
val x1210 = x1147.avgDiscount
val x2907 = x1150.avgDiscount(x2839.toInt) = x1210
val x2908 = x1150.countOrder
val x1213 = x1147.countOrder
val x2909 = x1150.countOrder(x2839.toInt) = x1213
()
}
if (x2843) {
x2911thenb()
} else { 
x2911elseb()
}
}
val x1474: Array[Int] = __act2.x3648_hash_data
val x1471: Int = 1
val x2977 = x2954x3648_sze
val x2978 = x1474.length
val x2979 = x2978 - 1
val x2980 = x2977 > x2979
val x2993 = {
def x2993thenb(): Unit = {
val x2981 = x2978 < 16
val x2985 = {
def x2985thenb(): Int = {
16
}
def x2985elseb(): Int = {
val x2982 = x2978 * 2
val x2983 = x2982 < 0
val x2984 = {
def x2984thenb(): Int = {
2147483647
}
def x2984elseb(): Int = {
x2982
}
if (x2983) {
x2984thenb()
} else { 
x2984elseb()
}
}
x2984
}
if (x2981) {
x2985thenb()
} else { 
x2985elseb()
}
}
if (x2985 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2986 = new Array[Int](x2985.toInt)
val x2987 = System.arraycopy(x1474,0.toInt,x2986,0.toInt,x2978.toInt)
val x2988 = x2986(x2977.toInt) = x1471
val x2989 = __act2.x3648_hash_data = x2986
x2989
}
def x2993elseb(): Unit = {
val x2991 = x1474(x2977.toInt) = x1471
x2991
}
if (x2980) {
x2993thenb()
} else { 
x2993elseb()
}
}
} else { // existing key
val x1149: Int = x2954x3648_idx
val x1150: generated.scala.DeliteArrayAnon201185238 = __act2.x2954_hash_data
val x2794 = x1150.returnFlag
val x2795 = x1150.lineStatus
val x2796 = x1150.sumQty
val x2797 = x1150.sumBasePrice
val x2798 = x1150.sumDiscountedPrice
val x2799 = x1150.sumCharge
val x2800 = x1150.avgQty
val x2801 = x1150.avgPrice
val x2802 = x1150.avgDiscount
val x2803 = x1150.countOrder
val x2804 = x2794(x1149.toInt)
val x2805 = x2795(x1149.toInt)
val x2806 = x2796(x1149.toInt)
val x2807 = x2797(x1149.toInt)
val x2808 = x2798(x1149.toInt)
val x2809 = x2799(x1149.toInt)
val x2810 = x2800(x1149.toInt)
val x2811 = x2801(x1149.toInt)
val x2812 = x2802(x1149.toInt)
val x2813 = x2803(x1149.toInt)
val x2814 = new generated.scala.Anon201185238(x2804,x2805,x2806,x2807,x2808,x2809,x2810,x2811,x2812,x2813)
val x1116: generated.scala.Anon201185238 = x2814
val x1117: generated.scala.Anon201185238 = x2779
val x1118 = x1116.returnFlag
val x1120 = x1116.lineStatus
val x1122 = x1116.sumQty
val x1123 = x1117.sumQty
val x1124 = {
x1122 + x1123}
val x1125 = x1116.sumBasePrice
val x1126 = x1117.sumBasePrice
val x1127 = {
x1125 + x1126}
val x1128 = x1116.sumDiscountedPrice
val x1129 = x1117.sumDiscountedPrice
val x1130 = {
x1128 + x1129}
val x1131 = x1116.sumCharge
val x1132 = x1117.sumCharge
val x1133 = {
x1131 + x1132}
val x1134 = x1116.avgQty
val x1135 = x1117.avgQty
val x1136 = {
x1134 + x1135}
val x1137 = x1116.avgPrice
val x1138 = x1117.avgPrice
val x1139 = {
x1137 + x1138}
val x1140 = x1116.avgDiscount
val x1141 = x1117.avgDiscount
val x1142 = {
x1140 + x1141}
val x1143 = x1116.countOrder
val x1144 = x1117.countOrder
val x1145 = {
x1143 + x1144}
val x1146 = new generated.scala.Anon201185238(x1118,x1120,x1124,x1127,x1130,x1133,x1136,x1139,x1142,x1145)
val x1147: generated.scala.Anon201185238 = x1146
val x2816 = x1150.returnFlag
val x1186 = x1147.returnFlag
val x2817 = x1150.returnFlag(x1149.toInt) = x1186
val x2818 = x1150.lineStatus
val x1189 = x1147.lineStatus
val x2819 = x1150.lineStatus(x1149.toInt) = x1189
val x2820 = x1150.sumQty
val x1192 = x1147.sumQty
val x2821 = x1150.sumQty(x1149.toInt) = x1192
val x2822 = x1150.sumBasePrice
val x1195 = x1147.sumBasePrice
val x2823 = x1150.sumBasePrice(x1149.toInt) = x1195
val x2824 = x1150.sumDiscountedPrice
val x1198 = x1147.sumDiscountedPrice
val x2825 = x1150.sumDiscountedPrice(x1149.toInt) = x1198
val x2826 = x1150.sumCharge
val x1201 = x1147.sumCharge
val x2827 = x1150.sumCharge(x1149.toInt) = x1201
val x2828 = x1150.avgQty
val x1204 = x1147.avgQty
val x2829 = x1150.avgQty(x1149.toInt) = x1204
val x2830 = x1150.avgPrice
val x1207 = x1147.avgPrice
val x2831 = x1150.avgPrice(x1149.toInt) = x1207
val x2832 = x1150.avgDiscount
val x1210 = x1147.avgDiscount
val x2833 = x1150.avgDiscount(x1149.toInt) = x1210
val x2834 = x1150.countOrder
val x1213 = x1147.countOrder
val x2835 = x1150.countOrder(x1149.toInt) = x1213
val x1473: Int = x2954x3648_idx
val x1474: Array[Int] = __act2.x3648_hash_data
val x2971 = x1474(x1473.toInt)
val x1468: Int = x2971
val x1469: Int = 1
val x1470 = x1468 + x1469
val x1471: Int = x1470
val x2973 = x1474(x1473.toInt) = x1471
}
}
}
__act2
}

def process(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2954x3648,x1090:Int): Unit = {
val x2771 = x2291(x1090.toInt)
val x2772 = x2334(x1090.toInt)
val x2773 = x2377(x1090.toInt)
val x2774 = {
1.0 - x2773}
val x2775 = {
x2772 * x2774}
val x2776 = x2420(x1090.toInt)
val x2777 = {
1.0 + x2776}
val x2778 = {
x2775 * x2777}
val x2768 = x2463(x1090.toInt)
val x2769 = x2506(x1090.toInt)
val x2779 = new generated.scala.Anon201185238(x2768,x2769,x2771,x2772,x2775,x2778,x2771,x2772,x2773,1)
val x2770 = new generated.scala.Tup2CharChar(x2768,x2769)
val x2780 = x2549(x1090.toInt)
val x2781 = {
x2780 <= x425}
if (x2781) {
// common key Block(Sym(2770)) for x2954x3648
val x2954x3648_sze: Int = __act.x2954x3648_hash_pos.size
val x2954x3648_idx: Int = __act.x2954x3648_hash_pos.put(x2770)
if (x2954x3648_idx == x2954x3648_sze) { // new key
val x1150: generated.scala.DeliteArrayAnon201185238 = __act.x2954_hash_data
val x1147: generated.scala.Anon201185238 = x2779
val x2839 = x2954x3648_sze
val x2840 = x1150.returnFlag
val x2841 = x2840.length
val x2842 = x2841 - 1
val x2843 = x2839 > x2842
val x2911 = {
def x2911thenb(): Unit = {
val x2844 = x2841 < 16
val x2848 = {
def x2848thenb(): Int = {
16
}
def x2848elseb(): Int = {
val x2845 = x2841 * 2
val x2846 = x2845 < 0
val x2847 = {
def x2847thenb(): Int = {
2147483647
}
def x2847elseb(): Int = {
x2845
}
if (x2846) {
x2847thenb()
} else { 
x2847elseb()
}
}
x2847
}
if (x2844) {
x2848thenb()
} else { 
x2848elseb()
}
}
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2849 = new Array[Char](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2850 = new Array[Char](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2851 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2852 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2853 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2854 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2855 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2856 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2857 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2858 = new Array[Int](x2848.toInt)
val x2859 = System.arraycopy(x2840,0.toInt,x2849,0.toInt,x2841.toInt)
val x2860 = x1150.lineStatus
val x2861 = System.arraycopy(x2860,0.toInt,x2850,0.toInt,x2841.toInt)
val x2862 = x1150.sumQty
val x2863 = System.arraycopy(x2862,0.toInt,x2851,0.toInt,x2841.toInt)
val x2864 = x1150.sumBasePrice
val x2865 = System.arraycopy(x2864,0.toInt,x2852,0.toInt,x2841.toInt)
val x2866 = x1150.sumDiscountedPrice
val x2867 = System.arraycopy(x2866,0.toInt,x2853,0.toInt,x2841.toInt)
val x2868 = x1150.sumCharge
val x2869 = System.arraycopy(x2868,0.toInt,x2854,0.toInt,x2841.toInt)
val x2870 = x1150.avgQty
val x2871 = System.arraycopy(x2870,0.toInt,x2855,0.toInt,x2841.toInt)
val x2872 = x1150.avgPrice
val x2873 = System.arraycopy(x2872,0.toInt,x2856,0.toInt,x2841.toInt)
val x2874 = x1150.avgDiscount
val x2875 = System.arraycopy(x2874,0.toInt,x2857,0.toInt,x2841.toInt)
val x2876 = x1150.countOrder
val x2877 = System.arraycopy(x2876,0.toInt,x2858,0.toInt,x2841.toInt)
val x1186 = x1147.returnFlag
val x2878 = x2849(x2839.toInt) = x1186
val x1189 = x1147.lineStatus
val x2879 = x2850(x2839.toInt) = x1189
val x1192 = x1147.sumQty
val x2880 = x2851(x2839.toInt) = x1192
val x1195 = x1147.sumBasePrice
val x2881 = x2852(x2839.toInt) = x1195
val x1198 = x1147.sumDiscountedPrice
val x2882 = x2853(x2839.toInt) = x1198
val x1201 = x1147.sumCharge
val x2883 = x2854(x2839.toInt) = x1201
val x1204 = x1147.avgQty
val x2884 = x2855(x2839.toInt) = x1204
val x1207 = x1147.avgPrice
val x2885 = x2856(x2839.toInt) = x1207
val x1210 = x1147.avgDiscount
val x2886 = x2857(x2839.toInt) = x1210
val x1213 = x1147.countOrder
val x2887 = x2858(x2839.toInt) = x1213
val x2888 = new generated.scala.DeliteArrayAnon201185238(x2849,x2850,x2851,x2852,x2853,x2854,x2855,x2856,x2857,x2858)
val x2889 = __act.x2954_hash_data = x2888
x2889
}
def x2911elseb(): Unit = {
val x1186 = x1147.returnFlag
val x2891 = x1150.returnFlag(x2839.toInt) = x1186
val x2892 = x1150.lineStatus
val x1189 = x1147.lineStatus
val x2893 = x1150.lineStatus(x2839.toInt) = x1189
val x2894 = x1150.sumQty
val x1192 = x1147.sumQty
val x2895 = x1150.sumQty(x2839.toInt) = x1192
val x2896 = x1150.sumBasePrice
val x1195 = x1147.sumBasePrice
val x2897 = x1150.sumBasePrice(x2839.toInt) = x1195
val x2898 = x1150.sumDiscountedPrice
val x1198 = x1147.sumDiscountedPrice
val x2899 = x1150.sumDiscountedPrice(x2839.toInt) = x1198
val x2900 = x1150.sumCharge
val x1201 = x1147.sumCharge
val x2901 = x1150.sumCharge(x2839.toInt) = x1201
val x2902 = x1150.avgQty
val x1204 = x1147.avgQty
val x2903 = x1150.avgQty(x2839.toInt) = x1204
val x2904 = x1150.avgPrice
val x1207 = x1147.avgPrice
val x2905 = x1150.avgPrice(x2839.toInt) = x1207
val x2906 = x1150.avgDiscount
val x1210 = x1147.avgDiscount
val x2907 = x1150.avgDiscount(x2839.toInt) = x1210
val x2908 = x1150.countOrder
val x1213 = x1147.countOrder
val x2909 = x1150.countOrder(x2839.toInt) = x1213
()
}
if (x2843) {
x2911thenb()
} else { 
x2911elseb()
}
}
val x1474: Array[Int] = __act.x3648_hash_data
val x1471: Int = 1
val x2977 = x2954x3648_sze
val x2978 = x1474.length
val x2979 = x2978 - 1
val x2980 = x2977 > x2979
val x2993 = {
def x2993thenb(): Unit = {
val x2981 = x2978 < 16
val x2985 = {
def x2985thenb(): Int = {
16
}
def x2985elseb(): Int = {
val x2982 = x2978 * 2
val x2983 = x2982 < 0
val x2984 = {
def x2984thenb(): Int = {
2147483647
}
def x2984elseb(): Int = {
x2982
}
if (x2983) {
x2984thenb()
} else { 
x2984elseb()
}
}
x2984
}
if (x2981) {
x2985thenb()
} else { 
x2985elseb()
}
}
if (x2985 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2986 = new Array[Int](x2985.toInt)
val x2987 = System.arraycopy(x1474,0.toInt,x2986,0.toInt,x2978.toInt)
val x2988 = x2986(x2977.toInt) = x1471
val x2989 = __act.x3648_hash_data = x2986
x2989
}
def x2993elseb(): Unit = {
val x2991 = x1474(x2977.toInt) = x1471
x2991
}
if (x2980) {
x2993thenb()
} else { 
x2993elseb()
}
}
} else { // existing key
val x1149: Int = x2954x3648_idx
val x1150: generated.scala.DeliteArrayAnon201185238 = __act.x2954_hash_data
val x2794 = x1150.returnFlag
val x2795 = x1150.lineStatus
val x2796 = x1150.sumQty
val x2797 = x1150.sumBasePrice
val x2798 = x1150.sumDiscountedPrice
val x2799 = x1150.sumCharge
val x2800 = x1150.avgQty
val x2801 = x1150.avgPrice
val x2802 = x1150.avgDiscount
val x2803 = x1150.countOrder
val x2804 = x2794(x1149.toInt)
val x2805 = x2795(x1149.toInt)
val x2806 = x2796(x1149.toInt)
val x2807 = x2797(x1149.toInt)
val x2808 = x2798(x1149.toInt)
val x2809 = x2799(x1149.toInt)
val x2810 = x2800(x1149.toInt)
val x2811 = x2801(x1149.toInt)
val x2812 = x2802(x1149.toInt)
val x2813 = x2803(x1149.toInt)
val x2814 = new generated.scala.Anon201185238(x2804,x2805,x2806,x2807,x2808,x2809,x2810,x2811,x2812,x2813)
val x1116: generated.scala.Anon201185238 = x2814
val x1117: generated.scala.Anon201185238 = x2779
val x1118 = x1116.returnFlag
val x1120 = x1116.lineStatus
val x1122 = x1116.sumQty
val x1123 = x1117.sumQty
val x1124 = {
x1122 + x1123}
val x1125 = x1116.sumBasePrice
val x1126 = x1117.sumBasePrice
val x1127 = {
x1125 + x1126}
val x1128 = x1116.sumDiscountedPrice
val x1129 = x1117.sumDiscountedPrice
val x1130 = {
x1128 + x1129}
val x1131 = x1116.sumCharge
val x1132 = x1117.sumCharge
val x1133 = {
x1131 + x1132}
val x1134 = x1116.avgQty
val x1135 = x1117.avgQty
val x1136 = {
x1134 + x1135}
val x1137 = x1116.avgPrice
val x1138 = x1117.avgPrice
val x1139 = {
x1137 + x1138}
val x1140 = x1116.avgDiscount
val x1141 = x1117.avgDiscount
val x1142 = {
x1140 + x1141}
val x1143 = x1116.countOrder
val x1144 = x1117.countOrder
val x1145 = {
x1143 + x1144}
val x1146 = new generated.scala.Anon201185238(x1118,x1120,x1124,x1127,x1130,x1133,x1136,x1139,x1142,x1145)
val x1147: generated.scala.Anon201185238 = x1146
val x2816 = x1150.returnFlag
val x1186 = x1147.returnFlag
val x2817 = x1150.returnFlag(x1149.toInt) = x1186
val x2818 = x1150.lineStatus
val x1189 = x1147.lineStatus
val x2819 = x1150.lineStatus(x1149.toInt) = x1189
val x2820 = x1150.sumQty
val x1192 = x1147.sumQty
val x2821 = x1150.sumQty(x1149.toInt) = x1192
val x2822 = x1150.sumBasePrice
val x1195 = x1147.sumBasePrice
val x2823 = x1150.sumBasePrice(x1149.toInt) = x1195
val x2824 = x1150.sumDiscountedPrice
val x1198 = x1147.sumDiscountedPrice
val x2825 = x1150.sumDiscountedPrice(x1149.toInt) = x1198
val x2826 = x1150.sumCharge
val x1201 = x1147.sumCharge
val x2827 = x1150.sumCharge(x1149.toInt) = x1201
val x2828 = x1150.avgQty
val x1204 = x1147.avgQty
val x2829 = x1150.avgQty(x1149.toInt) = x1204
val x2830 = x1150.avgPrice
val x1207 = x1147.avgPrice
val x2831 = x1150.avgPrice(x1149.toInt) = x1207
val x2832 = x1150.avgDiscount
val x1210 = x1147.avgDiscount
val x2833 = x1150.avgDiscount(x1149.toInt) = x1210
val x2834 = x1150.countOrder
val x1213 = x1147.countOrder
val x2835 = x1150.countOrder(x1149.toInt) = x1213
val x1473: Int = x2954x3648_idx
val x1474: Array[Int] = __act.x3648_hash_data
val x2971 = x1474(x1473.toInt)
val x1468: Int = x2971
val x1469: Int = 1
val x1470 = x1468 + x1469
val x1471: Int = x1470
val x2973 = x1474(x1473.toInt) = x1471
}
}
}

def combine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2954x3648,rhs:activation_x2954x3648): Unit = {
// common key Block(Sym(2770)) for x2954x3648
if (__act.x2954x3648_size == -1) __act.x2954x3648_size = __act.x2954x3648_hash_pos.size
if (rhs.x2954x3648_size == -1) rhs.x2954x3648_size = rhs.x2954x3648_hash_pos.size
var x2954x3648rhs_idx: Int = 0
while (x2954x3648rhs_idx < rhs.x2954x3648_hash_pos.size) {
val x2954x3648_k: generated.scala.Tup2CharChar = rhs.x2954x3648_hash_pos.unsafeKeys(x2954x3648rhs_idx.toInt)
val x2954x3648_sze: Int = __act.x2954x3648_hash_pos.size
val x2954x3648_idx: Int = __act.x2954x3648_hash_pos.put(x2954x3648_k)
if (x2954x3648_idx == x2954x3648_sze) { // new key
var x1150: generated.scala.DeliteArrayAnon201185238 = rhs.x2954_hash_data
val x1149: Int = x2954x3648rhs_idx
val x2794 = x1150.returnFlag
val x2795 = x1150.lineStatus
val x2796 = x1150.sumQty
val x2797 = x1150.sumBasePrice
val x2798 = x1150.sumDiscountedPrice
val x2799 = x1150.sumCharge
val x2800 = x1150.avgQty
val x2801 = x1150.avgPrice
val x2802 = x1150.avgDiscount
val x2803 = x1150.countOrder
val x2804 = x2794(x1149.toInt)
val x2805 = x2795(x1149.toInt)
val x2806 = x2796(x1149.toInt)
val x2807 = x2797(x1149.toInt)
val x2808 = x2798(x1149.toInt)
val x2809 = x2799(x1149.toInt)
val x2810 = x2800(x1149.toInt)
val x2811 = x2801(x1149.toInt)
val x2812 = x2802(x1149.toInt)
val x2813 = x2803(x1149.toInt)
val x2814 = new generated.scala.Anon201185238(x2804,x2805,x2806,x2807,x2808,x2809,x2810,x2811,x2812,x2813)
x1150 = __act.x2954_hash_data
val x1147: generated.scala.Anon201185238 = x2814
val x2839 = x2954x3648_sze
val x2840 = x1150.returnFlag
val x2841 = x2840.length
val x2842 = x2841 - 1
val x2843 = x2839 > x2842
val x2911 = {
def x2911thenb(): Unit = {
val x2844 = x2841 < 16
val x2848 = {
def x2848thenb(): Int = {
16
}
def x2848elseb(): Int = {
val x2845 = x2841 * 2
val x2846 = x2845 < 0
val x2847 = {
def x2847thenb(): Int = {
2147483647
}
def x2847elseb(): Int = {
x2845
}
if (x2846) {
x2847thenb()
} else { 
x2847elseb()
}
}
x2847
}
if (x2844) {
x2848thenb()
} else { 
x2848elseb()
}
}
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2849 = new Array[Char](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2850 = new Array[Char](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2851 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2852 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2853 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2854 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2855 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2856 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2857 = new Array[Double](x2848.toInt)
if (x2848 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2858 = new Array[Int](x2848.toInt)
val x2859 = System.arraycopy(x2840,0.toInt,x2849,0.toInt,x2841.toInt)
val x2860 = x1150.lineStatus
val x2861 = System.arraycopy(x2860,0.toInt,x2850,0.toInt,x2841.toInt)
val x2862 = x1150.sumQty
val x2863 = System.arraycopy(x2862,0.toInt,x2851,0.toInt,x2841.toInt)
val x2864 = x1150.sumBasePrice
val x2865 = System.arraycopy(x2864,0.toInt,x2852,0.toInt,x2841.toInt)
val x2866 = x1150.sumDiscountedPrice
val x2867 = System.arraycopy(x2866,0.toInt,x2853,0.toInt,x2841.toInt)
val x2868 = x1150.sumCharge
val x2869 = System.arraycopy(x2868,0.toInt,x2854,0.toInt,x2841.toInt)
val x2870 = x1150.avgQty
val x2871 = System.arraycopy(x2870,0.toInt,x2855,0.toInt,x2841.toInt)
val x2872 = x1150.avgPrice
val x2873 = System.arraycopy(x2872,0.toInt,x2856,0.toInt,x2841.toInt)
val x2874 = x1150.avgDiscount
val x2875 = System.arraycopy(x2874,0.toInt,x2857,0.toInt,x2841.toInt)
val x2876 = x1150.countOrder
val x2877 = System.arraycopy(x2876,0.toInt,x2858,0.toInt,x2841.toInt)
val x1186 = x1147.returnFlag
val x2878 = x2849(x2839.toInt) = x1186
val x1189 = x1147.lineStatus
val x2879 = x2850(x2839.toInt) = x1189
val x1192 = x1147.sumQty
val x2880 = x2851(x2839.toInt) = x1192
val x1195 = x1147.sumBasePrice
val x2881 = x2852(x2839.toInt) = x1195
val x1198 = x1147.sumDiscountedPrice
val x2882 = x2853(x2839.toInt) = x1198
val x1201 = x1147.sumCharge
val x2883 = x2854(x2839.toInt) = x1201
val x1204 = x1147.avgQty
val x2884 = x2855(x2839.toInt) = x1204
val x1207 = x1147.avgPrice
val x2885 = x2856(x2839.toInt) = x1207
val x1210 = x1147.avgDiscount
val x2886 = x2857(x2839.toInt) = x1210
val x1213 = x1147.countOrder
val x2887 = x2858(x2839.toInt) = x1213
val x2888 = new generated.scala.DeliteArrayAnon201185238(x2849,x2850,x2851,x2852,x2853,x2854,x2855,x2856,x2857,x2858)
val x2889 = __act.x2954_hash_data = x2888
x2889
}
def x2911elseb(): Unit = {
val x1186 = x1147.returnFlag
val x2891 = x1150.returnFlag(x2839.toInt) = x1186
val x2892 = x1150.lineStatus
val x1189 = x1147.lineStatus
val x2893 = x1150.lineStatus(x2839.toInt) = x1189
val x2894 = x1150.sumQty
val x1192 = x1147.sumQty
val x2895 = x1150.sumQty(x2839.toInt) = x1192
val x2896 = x1150.sumBasePrice
val x1195 = x1147.sumBasePrice
val x2897 = x1150.sumBasePrice(x2839.toInt) = x1195
val x2898 = x1150.sumDiscountedPrice
val x1198 = x1147.sumDiscountedPrice
val x2899 = x1150.sumDiscountedPrice(x2839.toInt) = x1198
val x2900 = x1150.sumCharge
val x1201 = x1147.sumCharge
val x2901 = x1150.sumCharge(x2839.toInt) = x1201
val x2902 = x1150.avgQty
val x1204 = x1147.avgQty
val x2903 = x1150.avgQty(x2839.toInt) = x1204
val x2904 = x1150.avgPrice
val x1207 = x1147.avgPrice
val x2905 = x1150.avgPrice(x2839.toInt) = x1207
val x2906 = x1150.avgDiscount
val x1210 = x1147.avgDiscount
val x2907 = x1150.avgDiscount(x2839.toInt) = x1210
val x2908 = x1150.countOrder
val x1213 = x1147.countOrder
val x2909 = x1150.countOrder(x2839.toInt) = x1213
()
}
if (x2843) {
x2911thenb()
} else { 
x2911elseb()
}
}
var x1474: Array[Int] = rhs.x3648_hash_data
val x1473: Int = x2954x3648rhs_idx
val x2971 = x1474(x1473.toInt)
x1474 = __act.x3648_hash_data
val x1471: Int = x2971
val x2977 = x2954x3648_sze
val x2978 = x1474.length
val x2979 = x2978 - 1
val x2980 = x2977 > x2979
val x2993 = {
def x2993thenb(): Unit = {
val x2981 = x2978 < 16
val x2985 = {
def x2985thenb(): Int = {
16
}
def x2985elseb(): Int = {
val x2982 = x2978 * 2
val x2983 = x2982 < 0
val x2984 = {
def x2984thenb(): Int = {
2147483647
}
def x2984elseb(): Int = {
x2982
}
if (x2983) {
x2984thenb()
} else { 
x2984elseb()
}
}
x2984
}
if (x2981) {
x2985thenb()
} else { 
x2985elseb()
}
}
if (x2985 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2986 = new Array[Int](x2985.toInt)
val x2987 = System.arraycopy(x1474,0.toInt,x2986,0.toInt,x2978.toInt)
val x2988 = x2986(x2977.toInt) = x1471
val x2989 = __act.x3648_hash_data = x2986
x2989
}
def x2993elseb(): Unit = {
val x2991 = x1474(x2977.toInt) = x1471
x2991
}
if (x2980) {
x2993thenb()
} else { 
x2993elseb()
}
}
} else { // existing key
val x1150: generated.scala.DeliteArrayAnon201185238 = rhs.x2954_hash_data
val x1149: Int = x2954x3648rhs_idx
val x2794 = x1150.returnFlag
val x2795 = x1150.lineStatus
val x2796 = x1150.sumQty
val x2797 = x1150.sumBasePrice
val x2798 = x1150.sumDiscountedPrice
val x2799 = x1150.sumCharge
val x2800 = x1150.avgQty
val x2801 = x1150.avgPrice
val x2802 = x1150.avgDiscount
val x2803 = x1150.countOrder
val x2804 = x2794(x1149.toInt)
val x2805 = x2795(x1149.toInt)
val x2806 = x2796(x1149.toInt)
val x2807 = x2797(x1149.toInt)
val x2808 = x2798(x1149.toInt)
val x2809 = x2799(x1149.toInt)
val x2810 = x2800(x1149.toInt)
val x2811 = x2801(x1149.toInt)
val x2812 = x2802(x1149.toInt)
val x2813 = x2803(x1149.toInt)
val x2814 = new generated.scala.Anon201185238(x2804,x2805,x2806,x2807,x2808,x2809,x2810,x2811,x2812,x2813)
val x2954_v: generated.scala.Anon201185238 = x2814
val x2954_reduce_block: Unit = {
val x1150: generated.scala.DeliteArrayAnon201185238 = __act.x2954_hash_data
val x1149: Int = x2954x3648_idx
val x2794 = x1150.returnFlag
val x2795 = x1150.lineStatus
val x2796 = x1150.sumQty
val x2797 = x1150.sumBasePrice
val x2798 = x1150.sumDiscountedPrice
val x2799 = x1150.sumCharge
val x2800 = x1150.avgQty
val x2801 = x1150.avgPrice
val x2802 = x1150.avgDiscount
val x2803 = x1150.countOrder
val x2804 = x2794(x1149.toInt)
val x2805 = x2795(x1149.toInt)
val x2806 = x2796(x1149.toInt)
val x2807 = x2797(x1149.toInt)
val x2808 = x2798(x1149.toInt)
val x2809 = x2799(x1149.toInt)
val x2810 = x2800(x1149.toInt)
val x2811 = x2801(x1149.toInt)
val x2812 = x2802(x1149.toInt)
val x2813 = x2803(x1149.toInt)
val x2814 = new generated.scala.Anon201185238(x2804,x2805,x2806,x2807,x2808,x2809,x2810,x2811,x2812,x2813)
val x1116: generated.scala.Anon201185238 = x2814
val x1117: generated.scala.Anon201185238 = x2954_v
val x1118 = x1116.returnFlag
val x1120 = x1116.lineStatus
val x1122 = x1116.sumQty
val x1123 = x1117.sumQty
val x1124 = {
x1122 + x1123}
val x1125 = x1116.sumBasePrice
val x1126 = x1117.sumBasePrice
val x1127 = {
x1125 + x1126}
val x1128 = x1116.sumDiscountedPrice
val x1129 = x1117.sumDiscountedPrice
val x1130 = {
x1128 + x1129}
val x1131 = x1116.sumCharge
val x1132 = x1117.sumCharge
val x1133 = {
x1131 + x1132}
val x1134 = x1116.avgQty
val x1135 = x1117.avgQty
val x1136 = {
x1134 + x1135}
val x1137 = x1116.avgPrice
val x1138 = x1117.avgPrice
val x1139 = {
x1137 + x1138}
val x1140 = x1116.avgDiscount
val x1141 = x1117.avgDiscount
val x1142 = {
x1140 + x1141}
val x1143 = x1116.countOrder
val x1144 = x1117.countOrder
val x1145 = {
x1143 + x1144}
val x1146 = new generated.scala.Anon201185238(x1118,x1120,x1124,x1127,x1130,x1133,x1136,x1139,x1142,x1145)
val x1147: generated.scala.Anon201185238 = x1146
val x2816 = x1150.returnFlag
val x1186 = x1147.returnFlag
val x2817 = x1150.returnFlag(x1149.toInt) = x1186
val x2818 = x1150.lineStatus
val x1189 = x1147.lineStatus
val x2819 = x1150.lineStatus(x1149.toInt) = x1189
val x2820 = x1150.sumQty
val x1192 = x1147.sumQty
val x2821 = x1150.sumQty(x1149.toInt) = x1192
val x2822 = x1150.sumBasePrice
val x1195 = x1147.sumBasePrice
val x2823 = x1150.sumBasePrice(x1149.toInt) = x1195
val x2824 = x1150.sumDiscountedPrice
val x1198 = x1147.sumDiscountedPrice
val x2825 = x1150.sumDiscountedPrice(x1149.toInt) = x1198
val x2826 = x1150.sumCharge
val x1201 = x1147.sumCharge
val x2827 = x1150.sumCharge(x1149.toInt) = x1201
val x2828 = x1150.avgQty
val x1204 = x1147.avgQty
val x2829 = x1150.avgQty(x1149.toInt) = x1204
val x2830 = x1150.avgPrice
val x1207 = x1147.avgPrice
val x2831 = x1150.avgPrice(x1149.toInt) = x1207
val x2832 = x1150.avgDiscount
val x1210 = x1147.avgDiscount
val x2833 = x1150.avgDiscount(x1149.toInt) = x1210
val x2834 = x1150.countOrder
val x1213 = x1147.countOrder
val x2835 = x1150.countOrder(x1149.toInt) = x1213
}
val x1474: Array[Int] = rhs.x3648_hash_data
val x1473: Int = x2954x3648rhs_idx
val x2971 = x1474(x1473.toInt)
val x3648_v: Int = x2971
val x3648_reduce_block: Unit = {
val x1474: Array[Int] = __act.x3648_hash_data
val x1473: Int = x2954x3648_idx
val x2971 = x1474(x1473.toInt)
val x1468: Int = x2971
val x1469: Int = x3648_v
val x1470 = x1468 + x1469
val x1471: Int = x1470
val x2973 = x1474(x1473.toInt) = x1471
}
}
x2954x3648rhs_idx = x2954x3648rhs_idx+1
}
}

def postCombine(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2954x3648,lhs:activation_x2954x3648): Unit = {
__act.left_act = lhs
}

def postProcInit(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2954x3648): Unit = {
val tid: Int = resourceInfo.groupId
if (tid > 0) {
val all_acts: Array[activation_x2954x3648] = new Array[activation_x2954x3648](resourceInfo.groupSize)
var currentAct: activation_x2954x3648 = __act
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

def postProcess(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2954x3648): Unit = {
val tid: Int = resourceInfo.groupId
val numThreads: Int = resourceInfo.groupSize
if (__act.all_acts ne null) {
val all_acts: Array[activation_x2954x3648] = __act.all_acts
val x2954x3648_globalKeys: Array[generated.scala.Tup2CharChar] = __act.all_acts(0).x2954x3648_hash_pos.unsafeKeys
var x2954x3648_idx: Int = ((__act.all_acts(0).x2954x3648_hash_pos.size).asInstanceOf[Long] * tid / numThreads).asInstanceOf[Int]
val x2954x3648_end: Int = ((__act.all_acts(0).x2954x3648_hash_pos.size).asInstanceOf[Long] * (tid+1) / numThreads).asInstanceOf[Int]
while (x2954x3648_idx < x2954x3648_end) {
x2954x3648_idx = x2954x3648_idx + 1
}
}
}

def finalize(resourceInfo:generated.scala.ResourceInfo,__act:activation_x2954x3648): Unit = {
val x2954x3648_sze: Int = __act.x2954x3648_hash_pos.size
var x1150: generated.scala.DeliteArrayAnon201185238 = __act.x2954_hash_data
val x1148: Int = x2954x3648_sze
val x2913 = x1150.returnFlag
val x2914 = x2913.length
val x2915 = x2914 > x1148
val x2948 = {
def x2948thenb(): Unit = {
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2916 = new Array[Char](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2917 = new Array[Char](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2918 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2919 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2920 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2921 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2922 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2923 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2924 = new Array[Double](x1148.toInt)
if (x1148 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2925 = new Array[Int](x1148.toInt)
val x2926 = System.arraycopy(x2913,0.toInt,x2916,0.toInt,x1148.toInt)
val x2927 = x1150.lineStatus
val x2928 = System.arraycopy(x2927,0.toInt,x2917,0.toInt,x1148.toInt)
val x2929 = x1150.sumQty
val x2930 = System.arraycopy(x2929,0.toInt,x2918,0.toInt,x1148.toInt)
val x2931 = x1150.sumBasePrice
val x2932 = System.arraycopy(x2931,0.toInt,x2919,0.toInt,x1148.toInt)
val x2933 = x1150.sumDiscountedPrice
val x2934 = System.arraycopy(x2933,0.toInt,x2920,0.toInt,x1148.toInt)
val x2935 = x1150.sumCharge
val x2936 = System.arraycopy(x2935,0.toInt,x2921,0.toInt,x1148.toInt)
val x2937 = x1150.avgQty
val x2938 = System.arraycopy(x2937,0.toInt,x2922,0.toInt,x1148.toInt)
val x2939 = x1150.avgPrice
val x2940 = System.arraycopy(x2939,0.toInt,x2923,0.toInt,x1148.toInt)
val x2941 = x1150.avgDiscount
val x2942 = System.arraycopy(x2941,0.toInt,x2924,0.toInt,x1148.toInt)
val x2943 = x1150.countOrder
val x2944 = System.arraycopy(x2943,0.toInt,x2925,0.toInt,x1148.toInt)
val x2945 = new generated.scala.DeliteArrayAnon201185238(x2916,x2917,x2918,x2919,x2920,x2921,x2922,x2923,x2924,x2925)
val x2946 = x1150 = x2945
x2946
}
if (x2915) {
x2948thenb()
}
}
__act.x2954 = x1150
var x1474: Array[Int] = __act.x3648_hash_data
val x1472: Int = x2954x3648_sze
val x2995 = x1474.length
val x2996 = x2995 > x1472
val x3001 = {
def x3001thenb(): Unit = {
if (x1472 > Int.MaxValue) throw new RuntimeException("Allocation size too large for 32-bit runtime")
val x2997 = new Array[Int](x1472.toInt)
val x2998 = System.arraycopy(x1474,0.toInt,x2997,0.toInt,x1472.toInt)
val x2999 = x1474 = x2997
x2999
}
if (x2996) {
x3001thenb()
}
}
__act.x3648 = x1474
}

def initAct(resourceInfo:generated.scala.ResourceInfo): activation_x2954x3648 = {
val act: activation_x2954x3648 = new activation_x2954x3648
act.x2954x3648_hash_pos = new generated.scala.container.HashMapImpl[generated.scala.Tup2CharChar](512,128)
act
}

}
x2954x3648_closure.loopStart = 0
x2954x3648_closure.loopSize = x2765
val alloc: activation_x2954x3648 = x2954x3648_closure.alloc(resourceInfo)
var x2954x3648: activation_x2954x3648 = null
if (resourceInfo.availableThreads <= 1) {
x2954x3648 = x2954x3648_closure.main_seq(resourceInfo,alloc)
} else {
val sync: ppl.delite.runtime.sync.MultiLoopSync[activation_x2954x3648] = new ppl.delite.runtime.sync.MultiLoopSync[activation_x2954x3648](x2954x3648_closure.loopSize,0,resourceInfo)
var i: Int = 1
while (i < sync.numThreads) {
val r: generated.scala.ResourceInfo = sync.getThreadResource(i)
val executable = new ppl.delite.runtime.executor.DeliteExecutable {
      def run() = x2954x3648_closure.main_par(r,alloc,sync)
    }
    ppl.delite.runtime.Delite.executor.runOne(r.threadId, executable)
i = i+1
}
x2954x3648 = x2954x3648_closure.main_par(sync.getThreadResource(0),alloc,sync)
}

x2954x3648
}}

/**********/


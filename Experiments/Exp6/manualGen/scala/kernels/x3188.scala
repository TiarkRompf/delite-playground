package generated.scala
object kernel_x3188 {
def apply(resourceInfo:generated.scala.ResourceInfo,x2956:Int,x2955:Array[Char],x2957:Array[Char]): Array[Int] = {
val x3188 = {
val len = x2956.toInt
val comp = new generated.scala.container.IntComparator {
def compare(o1: Int, o2: Int): Int = {
val x1796 = o1
val x1797 = o2
val x3180 = x2955(x1796.toInt)
val x3181 = x2955(x1797.toInt)
val x3182 = x3180 - x3181
val x3183 = x3182 == 0
val x3187 = {
def x3187thenb(): Int = {
val x3184 = x2957(x1796.toInt)
val x3185 = x2957(x1797.toInt)
val x3186 = x3184 - x3185
x3186
}
def x3187elseb(): Int = {
x3182
}
if (x3183) {
x3187thenb()
} else { 
x3187elseb()
}
}
x3187.toInt
} }
val d = new Array[Int](len)
var i = 0; while(i < len) { d(i) = i; i += 1 }
generated.scala.container.SortingImpl.sort(d,comp)
d
}

x3188
}}

/**********/


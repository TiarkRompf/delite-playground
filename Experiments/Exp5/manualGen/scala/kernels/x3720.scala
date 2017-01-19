package generated.scala
object kernel_x3720 {
def apply(resourceInfo:generated.scala.ResourceInfo,x3710:Int,x3709:Array[Char],x3715:Array[Char]): Array[Int] = {
val x3720 = {
val len = x3710.toInt
val comp = new generated.scala.container.IntComparator {
def compare(o1: Int, o2: Int): Int = {
val x1795 = o1
val x1796 = o2
val x3711 = x3709(x1795.toInt)
val x3712 = x3709(x1796.toInt)
val x3713 = x3711 - x3712
val x3714 = x3713 == 0
val x3719 = {
def x3719thenb(): Int = {
val x3716 = x3715(x1795.toInt)
val x3717 = x3715(x1796.toInt)
val x3718 = x3716 - x3717
x3718
}
def x3719elseb(): Int = {
x3713
}
if (x3714) {
x3719thenb()
} else { 
x3719elseb()
}
}
x3719.toInt
} }
val d = new Array[Int](len)
var i = 0; while(i < len) { d(i) = i; i += 1 }
generated.scala.container.SortingImpl.sort(d,comp)
d
}

x3720
}}

/**********/


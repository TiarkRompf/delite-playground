package generated.scala
object kernel_x5772 {
def apply(resourceInfo:generated.scala.ResourceInfo,x5756:Int,x5755:Array[java.lang.String],x5764:Array[java.lang.String]): Array[Int] = {
val x5772 = {
val len = x5756.toInt
val comp = new generated.scala.container.IntComparator {
def compare(o1: Int, o2: Int): Int = {
val x2840 = o1
val x2841 = o2
val x5757 = x5755(x2840.toInt)
val x5758 = x5755(x2841.toInt)
val x5759 = {
x5757 < x5758}
val x5762 = {
def x5762thenb(): Int = {
-1
}
def x5762elseb(): Int = {
val x5760 = {
x5757 > x5758}
val x5761 = {
def x5761thenb(): Int = {
1
}
def x5761elseb(): Int = {
0
}
if (x5760) {
x5761thenb()
} else { 
x5761elseb()
}
}
x5761
}
if (x5759) {
x5762thenb()
} else { 
x5762elseb()
}
}
val x5763 = x5762 == 0
val x5771 = {
def x5771thenb(): Int = {
val x5765 = x5764(x2840.toInt)
val x5766 = x5764(x2841.toInt)
val x5767 = {
x5765 < x5766}
val x5770 = {
def x5770thenb(): Int = {
-1
}
def x5770elseb(): Int = {
val x5768 = {
x5765 > x5766}
val x5769 = {
def x5769thenb(): Int = {
1
}
def x5769elseb(): Int = {
0
}
if (x5768) {
x5769thenb()
} else { 
x5769elseb()
}
}
x5769
}
if (x5767) {
x5770thenb()
} else { 
x5770elseb()
}
}
x5770
}
def x5771elseb(): Int = {
x5762
}
if (x5763) {
x5771thenb()
} else { 
x5771elseb()
}
}
x5771.toInt
} }
val d = new Array[Int](len)
var i = 0; while(i < len) { d(i) = i; i += 1 }
generated.scala.container.SortingImpl.sort(d,comp)
d
}

x5772
}}

/**********/


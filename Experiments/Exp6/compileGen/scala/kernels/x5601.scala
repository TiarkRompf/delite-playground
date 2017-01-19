package generated.scala
object kernel_x5601 {
def apply(resourceInfo:generated.scala.ResourceInfo,x5585:Int,x5584:Array[java.lang.String],x5593:Array[java.lang.String]): Array[Int] = {
val x5601 = {
val len = x5585.toInt
val comp = new generated.scala.container.IntComparator {
def compare(o1: Int, o2: Int): Int = {
val x2844 = o1
val x2845 = o2
val x5586 = x5584(x2844.toInt)
val x5587 = x5584(x2845.toInt)
val x5588 = {
x5586 < x5587}
val x5591 = {
def x5591thenb(): Int = {
-1
}
def x5591elseb(): Int = {
val x5589 = {
x5586 > x5587}
val x5590 = {
def x5590thenb(): Int = {
1
}
def x5590elseb(): Int = {
0
}
if (x5589) {
x5590thenb()
} else { 
x5590elseb()
}
}
x5590
}
if (x5588) {
x5591thenb()
} else { 
x5591elseb()
}
}
val x5592 = x5591 == 0
val x5600 = {
def x5600thenb(): Int = {
val x5594 = x5593(x2844.toInt)
val x5595 = x5593(x2845.toInt)
val x5596 = {
x5594 < x5595}
val x5599 = {
def x5599thenb(): Int = {
-1
}
def x5599elseb(): Int = {
val x5597 = {
x5594 > x5595}
val x5598 = {
def x5598thenb(): Int = {
1
}
def x5598elseb(): Int = {
0
}
if (x5597) {
x5598thenb()
} else { 
x5598elseb()
}
}
x5598
}
if (x5596) {
x5599thenb()
} else { 
x5599elseb()
}
}
x5599
}
def x5600elseb(): Int = {
x5591
}
if (x5592) {
x5600thenb()
} else { 
x5600elseb()
}
}
x5600.toInt
} }
val d = new Array[Int](len)
var i = 0; while(i < len) { d(i) = i; i += 1 }
generated.scala.container.SortingImpl.sort(d,comp)
d
}

x5601
}}

/**********/


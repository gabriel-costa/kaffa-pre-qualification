import geometric.forms.Point
import geometric.forms.Rectangle
import kotlin.math.abs

fun main() {

    // to test, just change the values on the points below and it will print
    // "true" if they intersect or "false" if not
    // first rectangle
    val p1 = Point(7, 2)
    val p2 = Point(13, 7)

    // second rectangle
    val p3 = Point(10, 10)
    val p4 = Point(14, 13)

    // calculating height and width for the first rectangle
    var height = abs(p1.y - p2.y)
    var width = abs(p1.x - p2.x)
    val rect1 = getRectangle(p1, p2, height, width)

    // calculating height and width for the second rectangle
    height = abs(p3.y - p4.y)
    width = abs(p3.x - p4.x)
    val rect2 = getRectangle(p3, p4, height, width)

    println(rect1.areaOfIntersection(rect2))
}
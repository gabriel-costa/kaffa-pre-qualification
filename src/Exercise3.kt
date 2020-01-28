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

    // calculating height and width
    var height = abs(p1.y - p2.y)
    var width = abs(p1.x - p2.x)

    val rect1 = getRectangle(p1, p2, height, width)
    val rect2 = getRectangle(p3, p4, height, width)

    println(rect1.intersects(rect2))
}

// this function finds out the "pos" point, as illustrated in Rectangle.kt, given the two points forming a rectangle
fun getRectangle(p1: Point, p2: Point, height: Int, width: Int): Rectangle =
        if (p1.x < p2.x) {
            if (p1.y > p2.y) {
                Rectangle(p1, height, width)
            } else {
                Rectangle(Point(p1.x, p1.y + height), height, width)
            }
        } else {
            if (p2.y > p1.y) {
                Rectangle(p2, height, width)
            } else {
                Rectangle(Point(p2.x, p2.y + height), height, width)
            }
        }
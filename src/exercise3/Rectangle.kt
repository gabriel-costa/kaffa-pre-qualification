package exercise3

class Rectangle(private val pos: Point, private val height: Int, private val width: Int) {

    fun intersects(rect: Rectangle): Boolean {
        return !((pos.x > rect.pos.x+rect.width) || (pos.x+width < rect.pos.x) || (pos.y < rect.pos.y-height) || (pos.y-height > rect.pos.y))
    }
}

// i'm fixing pos(ition) to make the comparison easier
//. pos
//.  +-------+
//10 |       |
//.  |       |
//.  |   A   |
//.  |       |
//.  |       |
//5  +-------+
//.    .    .
//0....5....10.

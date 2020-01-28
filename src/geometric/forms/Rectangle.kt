package geometric.forms

class Rectangle(private val pos: Point, private val height: Int, private val width: Int) {

    fun intersects(rect: Rectangle): Boolean {
        // checking if there aren't possible collision on any side
        return !((pos.x > rect.pos.x + rect.width) || (pos.x + width < rect.pos.x) || (pos.y < rect.pos.y - height) || (pos.y - height > rect.pos.y))
    }

    fun areaOfIntersection(rect: Rectangle): Int {
        if (!intersects(rect))
            return 0
        var area: Int = 0
        if (pos.x + width > rect.pos.x && pos.x < rect.pos.x) {
            if (pos.y > rect.pos.y - height && pos.y < rect.pos.y) {
                area = (pos.y - (rect.pos.y - rect.height) + 1) * ((pos.x + width) - rect.pos.x + 1)
            } else if (pos.y - height < rect.pos.y) {
                area = (rect.pos.y - (pos.y - height) + 1) * ((pos.x + width) - rect.pos.x + 2)
            }
        } else if (pos.x < rect.pos.x + rect.width) {
            if (pos.y - height < rect.pos.y && pos.y - height > rect.pos.y - height) {
                area = (rect.pos.y - (pos.y - height) + 1) * ((rect.pos.x + rect.width) - pos.x + 1)
            } else if (pos.y > rect.pos.y - height) {
                area = (pos.y - (rect.pos.y - rect.height) + 1) * ((rect.pos.x + rect.width) - pos.x + 2)
            }
        }
        return area
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


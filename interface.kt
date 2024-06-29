fun main() {
    var square = Square(5)
    var triangle = Triangle(4,3)
    square.drawInfo()   
    triangle.drawInfo() 
}
interface Drawable {
    fun drawInfo()
}
class Square(var side: Int) : Drawable {
    override fun drawInfo() 
    {
        println("Square with side $side")
    }
}
class Triangle(var base: Int, var height: Int) : Drawable {
    override fun drawInfo()
    {
        println("Triangle with base $base and height $height")
    }
}

fun main() {
    var rectangle=Rectangle(5.0,3.0)
    println("arae of rectangle is ${rectangle.area()} ")
    println("perimeter of rectangle is ${rectangle.perimeter()} ")
    var circle=Circle(5.0)
    println("arae of circle is ${circle.area()} ")
    println("perimeter of circle is ${circle.perimeter()} ")
}
abstract class shape
{
    abstract fun area() : Double
}
class Rectangle(var length : Double, var breadth : Double ): shape()
{
    override fun area() : Double 
    {
    	return length*breadth
    }
    fun perimeter(): Double{
        return 2*(length+breadth)
    }
}
class Circle(var radius : Double ): shape()
{
    override fun area() : Double 
    {
    	return 3.14*radius*radius
    }
    fun perimeter(): Double{
        return 2*3.14*radius
    }
}

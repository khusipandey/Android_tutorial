fun main() {
    println(adder(5)(10))
}
fun adder(num: Int): (Int) -> Int {
    return { x: Int -> x + num }
}

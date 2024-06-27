fun main() {
    // Upper triangle
    var star= 1
    var space= (9 - star) / 2
    for (i in 1..5) {
        for (j in 1..space) {
            print(" ")
        }
        for (j in 1..star) {
            print("*")
        }
        println()
        star+=2
        space=(9 - star) / 2
    }

    // Lower triangle 
    star= 9
    space= (9 - star) / 2
    for (i in 9 downTo 1) {
        for (j in 1..space) {
            print(" ")
        }
        for (j in 1..star) {
            print("*")
        }
        println()
        star-= 2
        space=(9 - star) / 2
    }
}

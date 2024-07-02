fun main() {
    val names = mutableListOf("keshav" to 31,"Sanjay" to 23,"suhani" to 27)
    val sortedNames = sortByNameLength(names)
    sortedNames.forEach { (name, age) ->println("$name - $age")}
}
fun sortByNameLength(names: MutableList<Pair<String, Int>>): List<Pair<String, Int>> {
    val n = names.size
   	for (i in 0 until n-1) {
        for (j in 0 until n-i-1) {
            if (names[j].second>names[j + 1].second) {
                val temp = names[j]
                names[j] = names[j + 1]
                names[j + 1] = temp
            }
        }
    }
    return names
}

class Person constructor(val name: String, val age: Int)
fun main() {
    val people = listOf(Person("Nayan", 25),Person("abhi", 30),Person("roy", 23),Person("shagun", 30))
	val sortedPeople = sortPeople(people)
	for (person in sortedPeople) {
        println(" Name= ${person.name}, Age= ${person.age}")
    }
}
fun sortPeople(people: List<Person>): List<Person> {
    val sortedList = people.toMutableList()
    for (i in 0 until sortedList.size - 1) {
        for (j in 0 until sortedList.size - i - 1) {
            if (sortedList[j].age > sortedList[j + 1].age) {
                val temp = sortedList[j]
                sortedList[j] = sortedList[j + 1]
                sortedList[j + 1] = temp
            }
            else if (sortedList[j].age == sortedList[j + 1].age && sortedList[j].name > sortedList[j + 1].name) 
            {
                val tmp = sortedList[j]
                sortedList[j] = sortedList[j + 1]
                sortedList[j + 1] = tmp
            }
        }
    }
    return sortedList.toList()
}
class Person(
    val name: String,
    val age: Int,
    val mother: Person?,
    val father: Person?,
    val siblings: MutableList<Person>
) {
    init {
        // Being siblings works in both ways, doesn't it?
        // Maybe you should even add all the siblings of already given siblings, since they are your far relatives
        siblings.forEach {
            it.addSibling(this)
        }

    }

    val numOfRelatives: Int
        get() {
            var result = 0
            result += siblings.size
            if (mother != null) result += 1 + mother.numOfRelatives
            if (father != null) result += 1 + father.numOfRelatives
            return result
        }

    val isAdult: Boolean
        get() = age >= 18

    private fun addSibling(person: Person) {
        if (person !in siblings) siblings.add(person)
    }

}

fun main(args: Array<String>) {
    val me = getMe()
    println("I'm an adult: ${maNigga.isAdult}")
    println("I have ${maNigga.numOfRelatives} relatives")
}

fun getMe(): Person {
    val babushkaM = Person(
        "babushkaM",
        99,
        null,
        null,
        mutableListOf()
    )
    val dedushkaM = Person(
        "dedushkaM",
        101,
        null,
        null,
        mutableListOf()
    )
    val sisterM = Person(
        "sisterM",
        40,
        null,
        null,
        mutableListOf()
    )
    val babushkaP = Person(
        "babushkaP",
        100,
        null,
        null,
        mutableListOf()
    )
    val dedushkaP = Person(
        "dedushkaP",
        103,
        null,
        null,
        mutableListOf()
    )
    val mama = Person(
        "mama",
        43,
        babushkaM,
        dedushkaM,
        mutableListOf(sisterM)
    )
    val papa = Person(
        "papa",
        45,
        babushkaP,
        dedushkaP,
        mutableListOf()
    )
    val brother1 = Person(
        "brother1",
        21,
        null,
        null,
        mutableListOf()
    )
    val brother2 = Person(
        "brother2",
        9,
        null,
        null,
        mutableListOf()
    )

    val sister1 = Person(
        "sister1",
        14,
        null,
        null,
        mutableListOf()
    )
    val sister2 = Person(
        "sister2",
        5,
        null,
        null,
        mutableListOf()
    )
    return Person(
        "Nazar",
        16,
        mama,
        papa,
        mutableListOf(brother1, brother2, sister1, sister2)
    )
}

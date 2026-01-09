import java.lang.Exception

fun main(args: Array<String>) {
    println("Hello World!")
    val aChar = 'a'
    println("This is the char: $aChar")
    val number1 = 10
    val number2 = 54
    val result = number1 + number2
    println("$number1 + $number2 = $result")
    var counter = 0
    var hasRun10Times = false
    while (!hasRun10Times){
        counter ++
        println("The loop run $counter Times")
        if(counter == 10) {
            hasRun10Times = true
        }
    }
    println("Loop successfully terminated after running $counter times!")
    for(i in 0..10){
        println(i)
    }
    val text = "This is a string!"
    println(text)
    val randomArray = arrayOf(0,1,2,3,4,5,6,7,8,9,10)
    for (i in randomArray){
        println(randomArray[i])
    }
    val randomValue = (0..1).random()
    if (randomValue == 1) {
        println("You win!")
    }
    else {
        println("You lose!")
    }
    print("Enter a Number between 1 and 7: ")
    while (true){
        try {
            val day = when(readln().toInt()){
                1 -> "Monday"
                2 -> "Tuesday"
                3 -> "Wednesday"
                4 -> "Thursday"
                5 -> "Friday"
                6 -> "Saturday"
                7 -> "Sunday"
                else -> "invalid Input"
            }
            if(day != "invalid Input") {
                println("Your random Day is $day")
                break
            }
            else {
                println("Your input was invalid, please try again!")
            }
        }
        catch (e:Exception){
            throw e
        }
    }

}
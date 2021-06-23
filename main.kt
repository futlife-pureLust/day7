const val  TAVERN_NAME = "Taerny's Folly"
fun main(args: Array<String>) {
    placeOrder("shandy ,Dragon's Breath, 5.91")
    placeOrder("elixir ,Shirley's Temple, 4.12")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")){
        when (it.value){
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            "A" -> "4"
            "E" -> "3"
            "I" -> "1"
            "O" -> "0"
            "U" -> "|_|"
            else -> it.value
        }
    }

private  fun placeOrder(menuData: String){
    val indexOfAppstrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfAppstrophe)
    println("Madrigal對 $tavernMaster 說了他們訂的酒水。 ")

    val (type,name,price) = menuData.split(',')
    val message = "Madrigal 買了一杯 $name ($type) 花了 $price."
    println(message)

    val phrase = if (name == "Dragon's Breath"){
        "Madrigal 喝下後喊出: ${toDragonSpeak("IT'S GOT WHAT ADVENTURERS CRAVE!")}"
    } else {
        "Madrigal 說道: 感謝 $name ."
    }
    println(phrase)
}
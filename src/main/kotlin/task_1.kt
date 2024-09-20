fun main() {
    agoToText(30)          // был(а) только что
    agoToText(120)         // был(а) 2 минуты назад
    agoToText(3_600)       // был(а) 60 минут назад
    agoToText(7_200)       // был(а) 2 часа назад
    agoToText(86_400)      // был(а) 24 часа назад
    agoToText(172_800)     // был(а) вчера
    agoToText(60_000_000)  // был(а) давно
}

fun agoToText(seconds: Int) {
    when {
        seconds in 0..60 -> println("был(а) только что")
        seconds in 61..3600 -> {
            val minutes = seconds / 60
            println("был(а) ${minutes} ${getMinuteForm(minutes)} назад")
        }
        seconds in 3601..86400 -> {
            val hours = seconds / 3600
            println("был(а) ${hours} ${getHourForm(hours)} назад")
        }
        seconds in 86401..172800 -> println("был(а) вчера")
        seconds in 172801..259200 -> println("был(а) позавчера")
        else -> println("был(а) давно")
    }
}
// Функция определения правильной формы "минута"
fun getMinuteForm(minutes: Int): String {
    return when {
        minutes % 10 == 1 && minutes % 100 != 11 -> "минуту"
        minutes % 10 in 2..4 && (minutes % 100 < 10 || minutes % 100 > 20) -> "минуты"
        else -> "минут"
    }
}
// Функция определения правильной формы "час"
fun getHourForm(hours: Int): String {
    return when {
        hours % 10 == 1 && hours % 100 != 11 -> "час"
        hours % 10 in 2..4 && (hours % 100 < 10 || hours % 100 > 20) -> "часа"
        else -> "часов"
    }
}
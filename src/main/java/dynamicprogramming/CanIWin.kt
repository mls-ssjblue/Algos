package dynamicprogramming

fun main() {
     val maxChoosableInteger = readLine()!!.toInt()
     val desiredTotal = readLine()!!.toInt()

     println(canIWin(maxChoosableInteger, desiredTotal))
}

fun canIWin(maxChoosableInteger: Int, desiredTotal: Int): Boolean {

    return false
}
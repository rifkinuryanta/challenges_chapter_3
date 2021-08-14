import kotlin.system.exitProcess

object BaseGame {
    fun startGame() {
        menuGame()

        print(Constant.msgInput1)
        val input1 = readLine()?.toLowerCase()
        inputCheck(input1)
        println(Constant.msgChoose + input1)

        print(Constant.msgInput2)
        val input2 = readLine()?.toLowerCase()
        inputCheck(input2)
        println(Constant.msgChoose + input2)

        result(input1, input2)
    }

    private fun menuGame() {
        print(Constant.intro)
        print(Constant.menu)
        val inputMenu = readLine()!!

        if (isInteger(inputMenu)) {
            when (inputMenu.toInt()) {
                1 -> println(Constant.playGame)
                2 -> {
                    println(Constant.exitGame)
                    exitProcess(0)
                }
                else -> {
                    wrongInput()
                }
            }
        } else {
            wrongInput()
        }
    }

    private fun result(input1: String?, input2: String?) {
        when (input1) {
            Constant.gunting -> {
                when (input2) {
                    Constant.kertas -> {
                        messageResult(Constant.playerOneWin)
                    }
                    Constant.batu -> {
                        messageResult(Constant.playerTwoWin)
                    }
                    else -> messageResult(Constant.draw)
                }
            }
            Constant.kertas -> {
                when (input2) {
                    Constant.gunting -> {
                        messageResult(Constant.playerTwoWin)
                    }
                    Constant.batu -> {
                        messageResult(Constant.playerOneWin)
                    }
                    else -> messageResult(Constant.draw)
                }
            }
            Constant.batu -> {
                when (input2) {
                    Constant.gunting -> {
                        messageResult(Constant.playerOneWin)
                    }
                    Constant.kertas -> {
                        messageResult(Constant.playerTwoWin)
                    }
                    else -> messageResult(Constant.draw)
                }
            }
        }
    }

    private fun inputCheck(value: String?): Boolean {
        return if (value.equals(Constant.gunting) || value.equals(Constant.kertas) || value.equals(Constant.batu)) {
            true
        } else {
            wrongInput()
        }
    }

    private fun messageResult(value: String) {
        println(Constant.msgResult + value)
    }

    private fun isInteger(input: String): Boolean {
        val integerChars = '0'..'9'
        return input.all { it in integerChars }
    }

    private fun wrongInput(): Boolean {
        println(Constant.msgWrongInput)
        exitProcess(0)
    }
}
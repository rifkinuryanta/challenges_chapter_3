class Main {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            do {
                BaseGame.startGame()
                print(Constant.playAgain)
                val value = readLine()?.toUpperCase()
            } while (value == Constant.charY)
        }
    }
}


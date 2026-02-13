import kotlin.random.Random
import java.io.BufferedReader
import java.io.InputStreamReader

class SnakeGame {
    private val width = 25          // Width of the game board
    private val height = 15         // Height of the game board

    private var snake = mutableListOf(Pair(5, 5))  // Initial snake position
    private var direction = Pair(1, 0)            // Initial moving right
    private var food = spawnFood()                // Initial food position
    private var score = 0
    private var running = true

    fun start() {
        // Reset game state for multiple runs
        snake = mutableListOf(Pair(5, 5))
        direction = Pair(1, 0)
        food = spawnFood()
        score = 0
        running = true

        val reader = BufferedReader(InputStreamReader(System.`in`))
        println("Controls: W A S D | Press Q to quit")

        while (running) {
            // Ask for input
            println("\nEnter move (W/A/S/D) or Q to quit:")
            val input = reader.readLine()?.lowercase()

            when (input) {
                "w" -> if (direction != Pair(0, 1)) direction = Pair(0, -1)
                "s" -> if (direction != Pair(0, -1)) direction = Pair(0, 1)
                "a" -> if (direction != Pair(1, 0)) direction = Pair(-1, 0)
                "d" -> if (direction != Pair(-1, 0)) direction = Pair(1, 0)
                "q" -> running = false
            }

            // Move snake & check collisions
            if (!update()) break

            // Clear the console (scroll old output off screen)
            clearConsole()
            draw()
        }

        println("\nGame Over! Score: $score")
    }

    private fun update(): Boolean {
        val head = snake.first()
        val newHead = Pair(head.first + direction.first, head.second + direction.second)

        // Collision check: walls or snake body
        if (newHead.first !in 0 until width || newHead.second !in 0 until height || snake.contains(newHead))
            return false

        snake.add(0, newHead) // Move snake forward

        if (newHead == food) {
            score++
            food = spawnFood() // Spawn new food
        } else {
            snake.removeLast() // Remove tail if no food eaten
        }

        return true
    }

    private fun draw() {
        println("Score: $score")
        for (y in 0 until height) {
            for (x in 0 until width) {
                when {
                    Pair(x, y) == snake.first() -> print("O") // Head
                    snake.contains(Pair(x, y)) -> print("o")  // Body
                    Pair(x, y) == food -> print("X")          // Food
                    else -> print("·")                        // Empty space
                }
            }
            println()
        }
    }

    private fun spawnFood(): Pair<Int, Int> {
        var pos: Pair<Int, Int>
        do {
            pos = Pair(Random.nextInt(width), Random.nextInt(height))
        } while (snake.contains(pos)) // Ensure food does not spawn on snake
        return pos
    }

    private fun clearConsole() {
        repeat(height + 3) { println() } // Scroll previous frame off the screen
    }
}
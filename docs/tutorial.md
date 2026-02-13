---

## title: Real-Time Snake Game in Kotlin (Console)

# Goal

In this tutorial, you'll build a **real-time console Snake game in Kotlin**. Unlike simple turn-based versions, the snake moves automatically and reacts instantly to your input.

You'll learn how to:

* Create a **grid-based game**
* Move the snake **in real-time**
* Spawn **food** and grow the snake
* Detect **collisions**
* Clear the console smoothly
* Handle **multiple game runs**

**Placeholder Image:**
`![Snake game final look](path-to-image.png)`
*Show the final game in the console.*

---

## Previous Knowledge

You should already know:

* Kotlin basics (variables, functions, classes)
* Lists (`MutableList`)
* Loops (`while`, `for`)
* Conditionals (`if` / `when`)

No prior game development experience is required.

---

## Concepts You'll Learn

1. **Game Loop** – Repeats game updates every frame.
2. **Thread-based Input** – Handles user input in real-time without pausing the game.
3. **Grid Coordinates** – (x, y) positions on the board.
4. **Collision Detection** – Detects if the snake hits walls or itself.
5. **Console Refreshing** – Moves cursor to top-left instead of clearing the console to reduce flicker.
6. **Resetting Game State** – Ensures multiple plays without restarting the program.

**Placeholder Image:**
`![Game loop diagram](path-to-image.png)`
*Visualize the game loop and input thread concept.*

---

# Tutorial

## 1. Create the SnakeGame class

```kotlin
class SnakeGame {
}
```

**Comment:** This class contains all game logic and state variables.

---

## 2. Define Game Variables

```kotlin
private val width = 25
private val height = 15
private var snake = mutableListOf(Pair(5, 5))
private var direction = Pair(1, 0)
private var food = spawnFood()
private var score = 0
private var running = true
@Volatile private var nextDirection: Pair<Int, Int> = direction
```

**Comment:** `nextDirection` allows thread-safe direction updates from input.

**Placeholder Image:**
`![Initial snake and food placement](path-to-image.png)`

---

## 3. Start the Game Loop and Handle Input

```kotlin
fun start() {
    // Reset state for multiple runs
    snake = mutableListOf(Pair(5, 5))
    direction = Pair(1, 0)
    nextDirection = direction
    food = spawnFood()
    score = 0
    running = true

    val reader = BufferedReader(InputStreamReader(System.`in`))
    println("Controls: W A S D | Press Q to quit")
    Thread.sleep(500)

    // Input thread handles real-time movement
    val inputThread = thread(start = true) {
        while (running) {
            if (reader.ready()) {
                when (reader.readLine().lowercase()) {
                    "w" -> if (direction != Pair(0, 1)) nextDirection = Pair(0, -1)
                    "s" -> if (direction != Pair(0, -1)) nextDirection = Pair(0, 1)
                    "a" -> if (direction != Pair(1, 0)) nextDirection = Pair(-1, 0)
                    "d" -> if (direction != Pair(-1, 0)) nextDirection = Pair(1, 0)
                    "q" -> running = false
                }
            }
        }
    }

    while (running) {
        direction = nextDirection // Apply input from thread
        if (!update()) break // Move snake and check collisions

        clearConsole()
        draw()

        Thread.sleep(150) // Game speed
    }

    running = false
    inputThread.join()
    println("\nGame Over! Score: $score")
}
```

**Comment:** Explains why a separate thread is used for input and why game state is reset each run.

**Placeholder GIF:**
`![Snake moving gif](path-to-gif.gif)`
*Snake reacts instantly to user input.*

---

## 4. Update Snake Position and Handle Collisions

```kotlin
private fun update(): Boolean {
    val head = snake.first()
    val newHead = Pair(head.first + direction.first, head.second + direction.second)

    if (newHead.first !in 0 until width || newHead.second !in 0 until height || snake.contains(newHead))
        return false

    snake.add(0, newHead)

    if (newHead == food) {
        score++
        food = spawnFood()
    } else {
        snake.removeLast()
    }

    return true
}
```

**Comment:** Checks collisions before adding the new head and only removes the tail if no food is eaten.

---

## 5. Draw the Board

```kotlin
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
```

**Comment:** Head and body distinction ensures the snake is drawn correctly.

**Placeholder Image:**
`![Board drawing example](path-to-image.png)`

---

## 6. Spawn Food

```kotlin
private fun spawnFood(): Pair<Int, Int> {
    var pos: Pair<Int, Int>
    do {
        pos = Pair(Random.nextInt(width), Random.nextInt(height))
    } while (snake.contains(pos))
    return pos
}
```

**Comment:** Ensures food does not spawn on the snake.

---

## 7. Clear the Console

```kotlin
private fun clearConsole() {
    print("\u001b[H") // Move cursor to top-left for smooth refresh
    System.out.flush()
}
```

**Comment:** Using ANSI escape codes reduces flicker compared to clearing the console entirely.

---

## 8. Run the Game

```kotlin
fun main() {
    SnakeGame().start()
}
```

---

# Result

* Smooth, real-time Snake game
* Snake grows when eating food
* Collisions end the game
* Multiple plays allowed without restarting
* Score tracking

**Placeholder GIF:**
`![Final gameplay gif](path-to-gif.gif)`

---

# Tips / What Could Go Wrong?

* Ensure your terminal supports ANSI codes.
* Avoid reversing direction instantly.
* Adjust `Thread.sleep(150)` to change game speed.

---

# Optional Enhancements

* Change symbols for snake and food (`*`, `#`, etc.)
* Add walls or obstacles
* Increase speed over time
* Save high scores to a file
* Add colors using ANSI escape codes

---

**Congratulations!** You now have a smooth, real-time Snake game in Kotlin with multiple rounds and responsive controls.
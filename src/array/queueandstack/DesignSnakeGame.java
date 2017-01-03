package array.queueandstack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a Snake game that is played on a device with screen size = width x height.
 * Play the game online if you are not familiar with the game.

 The snake is initially positioned at the top left corner (0,0) with length = 1 unit.

 You are given a list of food's positions in row-column order. When a snake eats the food,
 its length and the game's score both increase by 1.

 Each food appears one by one on the screen.
 For example, the second food will not appear until the first food was eaten by the snake.

 When a food does appear on the screen, it is guaranteed that it will not appear on a block occupied by the snake.

 Example:
 Given width = 3, height = 2, and food = [[1,2],[0,1]].

 Snake snake = new Snake(width, height, food);

 Initially the snake appears at position (0,0) and the food at (1,2).

 |S| | |
 | | |F|

 snake.move("R"); -> Returns 0

 | |S| |
 | | |F|

 snake.move("D"); -> Returns 0

 | | | |
 | |S|F|

 snake.move("R"); -> Returns 1 (Snake eats the first food and right after that, the second food appears at (0,1) )

 | |F| |
 | |S|S|

 snake.move("U"); -> Returns 1

 | |F|S|
 | | |S|

 snake.move("L"); -> Returns 2 (Snake eats the second food)

 | |S|S|
 | | |S|

 snake.move("U"); -> Returns -1 (Game over because snake collides with border)
 */
public class DesignSnakeGame {
    int[][] food;
    int width;
    int height;
    int x;
    int y;
    int index;
    Queue<int[] > queue;


    public DesignSnakeGame(int width, int height, int[][] food) {
        this.food = food;
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.index = 0;
        queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
    }

    public int move(String direction) {
        switch(direction) {
            case "U":
                x--;
                break;
            case "D":
                x++;
                break;
            case "L":
                y--;
                break;
            case "R":
                y++;
                break;
        }
        if (!isValid()) {
            return -1;
        }
        return process();
    }

    private boolean isValid() {
        return x >= 0 && x < height && y >= 0 && y < width;
    }

    private int process() {
        if (index == food.length) { // All the food has been eaten.
            queue.poll();
        }
        if (x == food[index][0] && y == food[index][1]) {
            index++;
        } else {
            queue.poll();
        }

        for (int[] position : queue) {
            if (position[0] == x && position[1] == y) {
                return -1;
            }
        }

        queue.offer(new int[]{x, y});
        return index + 1;
    }
}

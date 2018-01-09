package com.cl.javaNote.reusing;//: reusing/Chess.java
// Inheritance, constructors and arguments.

import static com.cl.javaNote.util.Print.print;


class Game {
    Game(int i) {
        print("Game constructor");
    }
}

class BoardGame extends Game {
    BoardGame(int i) {
        super(i);
        print("BoardGame constructor");
    }
}

/**
 * 带参数的构造器
 * 在没有默认的基类构造器的情况下，或者说想要调用一个带参数的基类构造器
 * 必须用关键字super显示的编写基类构造器的语句，并且配以适当的参数列表
 */
public class Chess extends BoardGame {
    Chess() {
        super(11);
        print("Chess constructor");
    }

    public static void main(String[] args) {
        Chess x = new Chess();
    }
} /* Output:
Game constructor
BoardGame constructor
Chess constructor
*///:~

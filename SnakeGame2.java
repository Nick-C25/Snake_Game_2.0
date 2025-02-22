package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, YourGameName is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;

import game.Fruit.FruitScores;

/**
 * SnakeGame2 is the controller the creators use to create the game SnakeGame2
 * extends the game class making it a subclass of game that creates the game
 * board
 */
class SnakeGame2 extends Game {
	static int counter = 0;
	static int bananaCounter = 0;
	private Snake snake;
	private Bomb bomb;
	private Fruit apple;
	private Fruit apple2;
	private Fruit apple3;
	private Fruit apple4;
	private Fruit apple5;
	private Fruit orange, orange2, orange3;
	private Fruit banana;
	private Fruit fruit;
	private Bomb.Lives lives;
	private FruitScores fruitScores;

	/**
	 * Creates the object of SnakeGame2. Creates every element such as a bomb,
	 * snake, and multiple fruits
	 */
	public SnakeGame2() {
		super("SnakeGame2!", 800, 600);
		this.setFocusable(true);
		this.requestFocus();
		Point[] snakePoints = new Point[5];
		Point[] bombPoints = new Point[4];

		Point[] fruitPoints = new Point[4];
		Point[] fruitPoints2 = new Point[4];
		Point[] fruitPoints3 = new Point[4];
		Point[] fruitPoints4 = new Point[4];
		Point[] fruitPoints5 = new Point[4];
		Point[] fruitPoints6 = new Point[4];
		Point[] fruitPoints7 = new Point[4];
		Point[] fruitPoints8 = new Point[4];
		Point[] fruitPoints9 = new Point[4];

		Point start = new Point(400, 300);

		Point fruitStart = new Point(200, 384);
		Point fruitStart2 = new Point(761, 470);
		Point fruitStart3 = new Point(650, 184);
		Point fruitStart4 = new Point(549, 240);
		Point fruitStart5 = new Point(700, 69);
		Point fruitStart6 = new Point(321, 169);
		Point fruitStart7 = new Point(480, 243);
		Point fruitStart8 = new Point(285, 380);
		Point fruitStart9 = new Point(150, 129);

		Point bombStart = new Point(100, 100);

		Point Spoint1 = new Point(20, 20);
		Point Spoint2 = new Point(20, 40);
		Point Spoint3 = new Point(40, 40);
		Point Spoint5 = new Point(40, 20);
		Point Spoint4 = new Point(60, 30);

		Point Bpoint1 = new Point(300, 300);
		Point Bpoint2 = new Point(300, 340);
		Point Bpoint3 = new Point(340, 340);
		Point Bpoint4 = new Point(340, 300);

		Point Fpoint1 = new Point(200, 200);
		Point Fpoint2 = new Point(200, 220);
		Point Fpoint3 = new Point(220, 220);
		Point Fpoint4 = new Point(220, 200);

		snakePoints[0] = Spoint1;
		snakePoints[1] = Spoint2;
		snakePoints[2] = Spoint3;
		snakePoints[3] = Spoint4;
		snakePoints[4] = Spoint5;

		bombPoints[0] = Bpoint1;
		bombPoints[1] = Bpoint2;
		bombPoints[2] = Bpoint3;
		bombPoints[3] = Bpoint4;

		fruitPoints[0] = Fpoint1;
		fruitPoints[1] = Fpoint2;
		fruitPoints[2] = Fpoint3;
		fruitPoints[3] = Fpoint4;

		this.snake = new Snake(snakePoints, start, 0);

		Bomb bomb = new Bomb(bombPoints, bombStart, 0);
		this.bomb = bomb;
		Fruit apple = new Fruit("Apple", 1, 0, fruitPoints, fruitStart, 0, 101);
		Fruit apple2 = new Fruit("Apple", 1, 0, fruitPoints, fruitStart2, 0, 200);
		Fruit apple3 = new Fruit("Apple", 1, 0, fruitPoints, fruitStart3, 0, 301);
		Fruit apple4 = new Fruit("Apple", 1, 0, fruitPoints, fruitStart4, 0, 400);
		Fruit apple5 = new Fruit("Apple", 1, 0, fruitPoints, fruitStart5, 0, 500);

		Fruit orange = new Fruit("Orange", 2, 1, fruitPoints, fruitStart6, 0, 6010);
		Fruit orange2 = new Fruit("Orange", 2, 1, fruitPoints, fruitStart7, 0, 5010);
		Fruit orange3 = new Fruit("Orange", 2, 1, fruitPoints, fruitStart8, 0, 2010);

		Fruit banana = new Fruit("Banana", 3, 2, fruitPoints, fruitStart9, 0, 70000);
		this.apple = apple;
		this.apple2 = apple2;
		this.apple3 = apple3;
		this.apple4 = apple4;
		this.apple5 = apple5;

		this.orange = orange;
		this.orange2 = orange2;
		this.orange3 = orange3;

		this.banana = banana;
		Bomb.Lives lives = bomb.new Lives();
		this.lives = lives;
		FruitScores fruitScores = new FruitScores();
		this.fruitScores = fruitScores;
		this.addKeyListener(snake);
	}

	/**
	 * The getter for the final score of the game
	 * 
	 * @return the end score
	 */
	public int getFinalScore() {

		Score FruitScore = new Score() {
			@Override
			public int getScore(String type) {

				return fruitScores.getScore(fruit.getName());
			}
		};
		return FruitScore.getScore(fruit.getName()) + bomb.getGamePoints();
	}

	/**
	 * Creates the game board and puts everything onto it the counter is a timer
	 * that manipulates the spawning and removal of different elements in accordance
	 * with the time
	 */
	public void paint(Graphics brush) {

		brush.setColor(Color.black);
		brush.fillRect(0, 0, width, height);
		brush.setColor(Color.white);
		brush.drawRect(0, 0, 799, 570);
		brush.setColor(Color.black);

		snake.move();

		apple.paint(brush);
		apple2.paint(brush);
		apple3.paint(brush);
		apple4.paint(brush);
		apple5.paint(brush);

		orange.paint(brush);
		orange2.paint(brush);
		orange3.paint(brush);

		bomb.paint(brush);

		if (counter % 500 == 0 && counter != 0) {
			apple.selfDestruct(brush);
			apple2.selfDestruct(brush);
			apple3.selfDestruct(brush);
			apple4.selfDestruct(brush);
			apple5.selfDestruct(brush);
		}
		if (bananaCounter <= 1000) {
			banana.paint(brush);
		}
		if (bananaCounter > 1000) {
			banana.selfDestruct(brush);
		}
		if (bananaCounter == 2000) {
			bananaCounter = 0;
		}

		if (counter % 500 == 0 && counter != 0) {
			bomb.selfDestruct(brush);
		}

		snake.paint(brush);
		if (snake.collide(bomb) == true) {
			bomb.selfDestruct(brush);
			lives.loseLife();
		}
		if (snake.collide(apple) == true || snake.collide(apple2) == true || snake.collide(apple3) == true
				|| snake.collide(apple4) == true || snake.collide(apple5) == true) {
			snake.increaseScore(apple);
		}
		if (snake.collide(apple)) {
			apple.selfDestruct(brush);
		}
		if (snake.collide(apple2)) {
			apple2.selfDestruct(brush);
		}
		if (snake.collide(apple3)) {
			apple3.selfDestruct(brush);
		}
		if (snake.collide(apple4)) {
			apple4.selfDestruct(brush);
		}
		if (snake.collide(apple5)) {
			apple5.selfDestruct(brush);
		}
		if (snake.collide(orange) == true || snake.collide(orange2) == true || snake.collide(orange3) == true) {
			snake.increaseScore(orange);
		}
		if (snake.collide(orange)) {
			orange.selfDestruct(brush);
		}
		if (snake.collide(orange2)) {
			orange2.selfDestruct(brush);
		}
		if (snake.collide(orange3)) {
			orange3.selfDestruct(brush);
		}
		if (snake.collide(banana) == true) {
			snake.increaseScore(banana);
		}
		if (snake.collide(banana)) {
			banana.selfDestruct(brush);
		}

		for (int i = 0; i < snake.getPoints().length; i++) {
			if (snake.getPoints()[i].x > 800 ||
				snake.getPoints()[i].y > 600 || 
				snake.getPoints()[i].y < 0 || 
				snake.getPoints()[i].x < 0) {
				lives.loseLife();
				lives.loseLife();
				lives.loseLife();
			}
		}
		// sample code for printing message for debugging
		// counter is incremented and this message printed
		// each time the canvas is repainted
		counter++;
		bananaCounter++;
		brush.setColor(Color.white);
		brush.drawString("Score is " + snake.getScore(), 10, 15);
		brush.drawString("Lives: " + lives.getTotalLives(), 745, 15);

		if (lives.isGameOver()) {
			brush.setColor(Color.white);
			brush.drawString("Game Over! Final Score: ", 300, 300);
			System.exit(0);

		}
	}

	public static void main(String[] args) {
		SnakeGame2 a = new SnakeGame2();
		a.repaint();

	}
}
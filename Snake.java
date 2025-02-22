package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * A snake in the game the only element the user can manually move
 */
public class Snake extends Polygon implements KeyListener {

	private Point[] inShape;
	private Point inPosition;
	private double inRotation;
	public int startX = 400;
	public int startY = 300;
	boolean up, down, left, right;
	private Graphics brush;
	private static int SPEED = 5;
	private int score = 0;

	/**
	 * Creates the snake element
	 *
	 * @param inShape    the array of points that creates the shape of the snake
	 * @param inPosition the snake origin on the game board
	 * @param inRotation the rotation of the snake in the game
	 */
	public Snake(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		this.inShape = inShape;
		this.inPosition = inPosition;
		this.inRotation = inRotation;
	}

	/**
	 * Creates the snake image on the screen
	 * 
	 * @param the brush used to create the image
	 */
	public void paint(Graphics brush) {
		this.brush = brush;
		brush.setColor(Color.green);
		int[] xPoints = new int[5];
		int[] yPoints = new int[5];

		xPoints[0] = (int) getPoints()[0].x;
		xPoints[1] = (int) getPoints()[1].x;
		xPoints[2] = (int) getPoints()[2].x;
		xPoints[3] = (int) getPoints()[3].x;
		xPoints[4] = (int) getPoints()[4].x;

		yPoints[0] = (int) getPoints()[0].y;
		yPoints[1] = (int) getPoints()[1].y;
		yPoints[2] = (int) getPoints()[2].y;
		yPoints[3] = (int) getPoints()[3].y;
		yPoints[4] = (int) getPoints()[4].y;

		brush.setColor(Color.green);
		brush.drawPolygon(xPoints, yPoints, 5);
		brush.fillPolygon(xPoints, yPoints, 5);

	}

	/**
	 * Depending on what the user inputs the snake will move accordingly due to this
	 * method
	 */
	public void move() {
		while (up) {
			inPosition.setY(inPosition.getY() - SPEED);
			break;
		}
		while (down) {
			inPosition.setY(inPosition.getY() + SPEED);
			break;
		}
		while (left) {

			inPosition.setX(inPosition.getX() - SPEED);
			break;
		}
		while (right) {
			inPosition.setX(inPosition.getX() + SPEED);
			break;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * Gets the corresponding motion with the input the user puts in to move the
	 * snake
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_UP) {
			super.rotation = 270;
			inShape = this.getPoints();
			up = true;
			down = false;
			left = false;
			right = false;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			super.rotation = 90;
			inShape = this.getPoints();
			up = false;
			down = true;
			left = false;
			right = false;
		}
		if (keyCode == KeyEvent.VK_LEFT) {
			super.rotation = 180;
			inShape = this.getPoints();
			up = false;
			down = false;
			left = true;
			right = false;
		}
		if (keyCode == KeyEvent.VK_RIGHT) {
			super.rotation = 0;
			inShape = this.getPoints();
			up = false;
			down = false;
			left = false;
			right = true;
		}

	}

	/**
	 * Increases the score in accordance to the point value of a fruit
	 *
	 * @param any fruit object
	 * @return the new score with the fruit's value added to it
	 */
	public int increaseScore(Fruit fruit) {
		score += fruit.getScore();
		return score;
	}

	/**
	 * Gets the score the user has acquired
	 *
	 * @return the current score
	 */
	public int getScore() {
		return score;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

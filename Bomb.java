package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

/**
 * A representation of a bomb element.
 */

public class Bomb extends Polygon {
	private int gamePoints;
	private Random random;
	int randomX, randomY, seed = -1000000;
	private Point[] inShape;
	private int[] xPoints = new int[4];
	private int[] yPoints = new int[4];
	private Point inPosition;

	/**
	 * Constructs a bomb object with the specified parameters.
	 *
	 * @param inShape    the array of points that creates the shape of the bomb
	 * @param inPosition the bombs origin on the game board
	 * @param inRotation the rotation of the bomb in the game
	 */
	public Bomb(Point[] inShape, Point inPosition, double inRotation) {
		super(inShape, inPosition, inRotation);
		this.gamePoints = -1;
		this.inShape = inShape;
		this.inPosition = inPosition;

	}

	/**
	 * returns the amount of points lost if the bomb is touched.
	 * 
	 * @return the amount of points lost
	 */
	public int getGamePoints() {
		return gamePoints;
	}

	/**
	 * Destroys the bomb off the board and changes spawn location
	 */
	public void selfDestruct(Graphics brush) {
		brush.setColor(Color.BLUE);
		if(inPosition.getY() + randomY < 500 && inPosition.getX() + randomX < 700) {
		inPosition.setY(inPosition.getY() + randomY);
		inPosition.setX(inPosition.getX() + randomX);
		}
		if(inPosition.getY() + randomY > 500 && inPosition.getX() + randomX > 700) {
			inPosition.setY(inPosition.getY() - randomY);
			inPosition.setX(inPosition.getX() - randomX);
			}
		if(inPosition.getY() + randomY > 500 && inPosition.getX() + randomX < 700) {
			inPosition.setY(inPosition.getY() + randomY);
			inPosition.setX(inPosition.getX() - randomX);
			}
		if(inPosition.getY() + randomY < 500 && inPosition.getX() + randomX > 700) {
			inPosition.setY(inPosition.getY() - randomY);
			inPosition.setX(inPosition.getX() + randomX);
			}
		brush.setColor(Color.BLUE);
		seed++;
	}

	/**
	 * Creates the bombs image on the screen
	 * 
	 * @param the brush used to create the image
	 */
	public void paint(Graphics brush) {
		this.random = new Random(seed);
		randomX = random.nextInt(400);
		randomY = random.nextInt(300);
	
		brush.setColor(Color.blue);

		xPoints[0] = (int) getPoints()[0].x;
		xPoints[1] = (int) getPoints()[1].x;
		xPoints[2] = (int) getPoints()[2].x;
		xPoints[3] = (int) getPoints()[3].x;

		yPoints[0] = (int) getPoints()[0].y;
		yPoints[1] = (int) getPoints()[1].y;
		yPoints[2] = (int) getPoints()[2].y;
		yPoints[3] = (int) getPoints()[3].y;

		brush.drawPolygon(xPoints, yPoints, 4);
		brush.fillPolygon(xPoints, yPoints, 4);
		brush.setColor(Color.BLUE);
//		brush.drawRect(randomX, randomY, 40, 40);
//		brush.fillRect(randomX, randomY, 40, 40);
		// dont use draw rect use draw polygon

	}

	/**
	 * Shows the logic of lives you have
	 */
	class Lives {
		private int maxLives = 3;
		private int livesLost = 0;

		/**
		 * gets the amount of lives you currently have
		 * 
		 * @return the number of livs you have
		 */
		public int getTotalLives() {
			return maxLives - livesLost;
		}

		/**
		 * removes a life if you have touched a bomb
		 */
		public void loseLife() {
			livesLost++;
		}

		/**
		 * If the amount of lives you have lost is the same as the amount of lives you
		 * had at the beginning of the game the game is over
		 * 
		 * @return a boolean that is true if you have lost all your lives
		 */
		public boolean isGameOver() {
			return maxLives == livesLost ? true : false;
		}

	}
}

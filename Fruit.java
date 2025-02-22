package game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Fruit extends Polygon {
	private String name;
	private int gamePoints;
	int color, randomX, randomX2, randomX3, randomY, randomY2, randomY3;
	int seed, seed2, seed3;
	private int[] xPoints = new int[4];
	private int[] yPoints = new int[4];
	private Point inPosition;

	/**
	 * Creats a fruit object with the parameters shown below.
	 *
	 * @param name       the name of the fruit
	 * @param gamePoints the amount of points a fruit is worth
	 * @param color      the number associated with a color of a fruit
	 * @param inShape    the array of points that create the shape of a fruit
	 * @param inPosition the origin of the fruit
	 * @param inRotation the rotation of the fruit in degrees
	 * @param seed       the seed that generates random spawn points
	 */
	public Fruit(String name, int gamePoints, int color, Point[] inShape, Point inPosition, double inRotation,
			int seed) {
		super(inShape, inPosition, inRotation);
		this.name = name;
		this.gamePoints = gamePoints;
		this.color = color;
		this.inPosition = inPosition;

		if (this.name == "Apple") {
			this.seed = seed;
		}
		if (this.name == "Orange") {
			this.seed2 = seed;
		}
		if (this.name == "Banana") {
			this.seed3 = seed;
		}
		
	}

	/**
	 * Returns the name associated with a fruit.
	 *
	 * @return the fruits name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Returns the game points associated with a fruit.
	 *
	 * @return the fruits game points.
	 */
	public int getScore() {
		return gamePoints;
	}

	/**
	 * Gets the score associated with a fruit.
	 *
	 * @return the game points of a fruit.
	 */
	public int getGamePoints() {
		FruitScores score = new FruitScores();
		return score.getScore(name);
	}

	/**
	 * Destroys the fruit shown in the game and changes the next spawn point
	 */
	public void selfDestruct(Graphics brush) {
		if (color == 0) {
			brush.setColor(Color.red);
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
			seed++;
		}
		if (color == 1) {
			brush.setColor(Color.orange);
			if(inPosition.getY() + randomY2 < 500 && inPosition.getX() + randomX2 < 700) {
				inPosition.setY(inPosition.getY() + randomY2);
				inPosition.setX(inPosition.getX() + randomX2);
				}
				if(inPosition.getY() + randomY2 > 500 && inPosition.getX() + randomX2 > 700) {
					inPosition.setY(inPosition.getY() - randomY2);
					inPosition.setX(inPosition.getX() - randomX2);
					}
				if(inPosition.getY() + randomY2 > 500 && inPosition.getX() + randomX2 < 700) {
					inPosition.setY(inPosition.getY() + randomY2);
					inPosition.setX(inPosition.getX() - randomX2);
					}
				if(inPosition.getY() + randomY2 < 500 && inPosition.getX() + randomX2 > 700) {
					inPosition.setY(inPosition.getY() - randomY2);
					inPosition.setX(inPosition.getX() + randomX2);
					}
			seed2++;
		}
		if (color == 2) {
			brush.setColor(Color.yellow);
			if(inPosition.getY() + randomY3 < 500 && inPosition.getX() + randomX3 < 700) {
				inPosition.setY(inPosition.getY() + randomY3);
				inPosition.setX(inPosition.getX() + randomX3);
				}
				if(inPosition.getY() + randomY3 > 500 && inPosition.getX() + randomX3 > 700) {
					inPosition.setY(inPosition.getY() - randomY3);
					inPosition.setX(inPosition.getX() - randomX3);
					}
				if(inPosition.getY() + randomY3 > 500 && inPosition.getX() + randomX3 < 700) {
					inPosition.setY(inPosition.getY() + randomY3);
					inPosition.setX(inPosition.getX() - randomX3);
					}
				if(inPosition.getY() + randomY3 < 500 && inPosition.getX() + randomX3 > 700) {
					inPosition.setY(inPosition.getY() - randomY3);
					inPosition.setX(inPosition.getX() + randomX3);
					}
			seed3++;
		}
	}

	/**
	 * Paints a fruit on the game board
	 *
	 * @param brush that is used to draw the fruit
	 */
	public void paint(Graphics brush) {
		
		Random random = new Random(seed);
		Random random2 = new Random(seed2);
		Random random3 = new Random(seed3);

		randomX = random.nextInt(50);
		randomY = random.nextInt(50);

		randomX2 = random2.nextInt(50);
		randomY2 = random2.nextInt(50);

		randomX3 = random3.nextInt(50);
		randomY3 = random3.nextInt(50);
		
		if (color == 0) {
			brush.setColor(Color.red);
			xPoints[0] = (int) getPoints()[0].x;
			xPoints[1] = (int) getPoints()[1].x;
			xPoints[2] = (int) getPoints()[2].x;
			xPoints[3] = (int) getPoints()[3].x;

			yPoints[0] = (int) getPoints()[0].y;
			yPoints[1] = (int) getPoints()[1].y ;
			yPoints[2] = (int) getPoints()[2].y ;
			yPoints[3] = (int) getPoints()[3].y ;
			brush.drawPolygon(xPoints, yPoints, 4);
			brush.fillPolygon(xPoints, yPoints, 4);
		}
		if (color == 1) {
			brush.setColor(Color.orange);
			xPoints[0] = (int) getPoints()[0].x ;
			xPoints[1] = (int) getPoints()[1].x ;
			xPoints[2] = (int) getPoints()[2].x ;
			xPoints[3] = (int) getPoints()[3].x ;

			yPoints[0] = (int) getPoints()[0].y ;
			yPoints[1] = (int) getPoints()[1].y ;
			yPoints[2] = (int) getPoints()[2].y ;
			yPoints[3] = (int) getPoints()[3].y ;
			brush.drawPolygon(xPoints, yPoints, 4);
			brush.fillPolygon(xPoints, yPoints, 4);
		}
		if (color == 2) {
			brush.setColor(Color.yellow);
			xPoints[0] = (int) getPoints()[0].x ;
			xPoints[1] = (int) getPoints()[1].x ;
			xPoints[2] = (int) getPoints()[2].x ;
			xPoints[3] = (int) getPoints()[3].x ;

			yPoints[0] = (int) getPoints()[0].y ;
			yPoints[1] = (int) getPoints()[1].y ;
			yPoints[2] = (int) getPoints()[2].y ;
			yPoints[3] = (int) getPoints()[3].y ;
			brush.drawPolygon(xPoints, yPoints, 4);
			brush.fillPolygon(xPoints, yPoints, 4);
		}

	}

	/**
	 * Shows the way to get scores for different types of fruit. static inner class
	 */
	public static class FruitScores implements Score {
		/**
		 * Gets the score associated with a fruit
		 *
		 * @param The fruits name
		 * @return the score for the fruit with the right name
		 */
		public int getScore(String type) {
			Score scores = x -> {
				if (x.equals("apple")) {
					return 1; // * appleCounter
				} else if (x.equals("orange")) {
					return 2; // * orangeCounter
				} else {
				}
				return 3; // * bannanaCounter
			};
			return scores.getScore(type);
		}

	}
}

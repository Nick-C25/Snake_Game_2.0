package game;

public interface Score {
	/**
     * Gets the score associated with a fruit
     *
     * @param The fruits name
     * @return the score for the fruit with the right name
     */
	public int getScore(String type);
}

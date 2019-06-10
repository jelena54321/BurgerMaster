package hr.fer.zavrsniRad.BurgerMaster.domain;

import java.util.List;

/**
 * Class which presents single game. 
 * <br>
 * Detailed fields' descriptions are specified below:
 * <ul>
 * 		<li><code>sleepInterval</code><br>
 * 		time interval between two customer orders</li>
 * 		<li><code>orders</code><br>
 * 		customers' orders which will be included in the game</li>
 * 		<li><code>results</code><br>
 * 		user's finished orders</li>
 * 		<li><code>totalTime</code><br>
 * 		time which took user to finish all provided orders</li>
 * </ul>
 * 
 * @author Jelena Šarić
 *
 */
public class Game {
		
	/** Sleep interval. */
	private int sleepInterval;
	
	/** Shift orders. */
	private List<Burger> orders;
	
	/** Shift results. */
	private List<Burger> results;
	
	/** Total shift time. */
	private long totalTime;

	/**
	 * Gets shift's orders.
	 * 
	 * @return shift orders
	 */
	public List<Burger> getOrders() {
		return orders;
	}

	/**
	 * Sets shift's orders.
	 * 
	 * @param orders shift's orders
	 */
	public void setOrders(List<Burger> orders) {
		this.orders = orders;
	}

	/**
	 * Gets shift's results.
	 * 
	 * @return shift's results
	 */
	public List<Burger> getResults() {
		return results;
	}

	/**
	 * Sets shift's results.
	 * 
	 * @param results shift's results
	 */
	public void setResults(List<Burger> results) {
		this.results = results;
	}

	/**
	 * Gets total shift time. 
	 * 
	 * @return total shift time
	 */
	public long getTotalTime() {
		return totalTime;
	}

	/**
	 * Sets total shift time.
	 * 
	 * @param totalTime total shift time
	 */
	public void setTotalTime(long totalTime) {
		this.totalTime = totalTime;
	}

	/**
	 * Gets sleep interval.
	 * 
	 * @return sleep interval
	 */
	public int getSleepInterval() {
		return sleepInterval;
	}

	/**
	 * Sets sleep interval.
	 * 
	 * @param sleepInterval sleep interval
	 */
	public void setSleepInterval(int sleepInterval) {
		this.sleepInterval = sleepInterval;
	}
}

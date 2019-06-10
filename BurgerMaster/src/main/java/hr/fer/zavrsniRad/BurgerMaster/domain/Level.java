package hr.fer.zavrsniRad.BurgerMaster.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 * Class which presents game level.
 * <br>
 * Detailed fields' descriptions are specified below:
 * <ul>
 * 		<li><code>level</code><br>
 * 		level's value</li>
 * 		<li><code>ordersCount</code><br>
 * 		number of orders which will be expected on this level</li>
 * 		<li><code>sleepInterval</code><br>
 * 		interval between two orders on this level</li>
 * 		<li><code>threshold</code><br>
 * 		minimal amount of points required in order to be able to pass this level</li>
 * 		<li><code>burgers</code><br>
 * 		burgers which will be included in orders on this level</li>
 * </ul>
 * 
 * @author Jelena Šarić
 *
 */
@Entity
public class Level {
	
	/** Level value. */
	@Id
	private int level;
	
	/** Number of orders. */
	@Column(nullable = false)
	private int ordersCount;
	
	/** Sleep interval. */
	@Column(nullable = false)
	private int sleepInterval;
	
	/** Level's threshold. */
	@Column(nullable = false)
	private int threshold;
	
	/** List of burgers. */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<Burger> burgers;

	/**
	 * Gets level's value.
	 * 
	 * @return level's value
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets level's value. 
	 * 
	 * @param level level's value
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Gets burgers for this level.
	 * 
	 * @return list of level's burgers
	 */
	public List<Burger> getBurgers() {
		return burgers;
	}

	/**
	 * Sets this level's burgers.
	 * 
	 * @param burgers list of level's burgers
	 */
	public void setBurgers(List<Burger> burgers) {
		this.burgers = burgers;
	}

	/**
	 * Gets number of orders.
	 * 
	 * @return number of orders
	 */
	public int getOrdersCount() {
		return ordersCount;
	}

	/**
	 * Sets number of orders.
	 * 
	 * @param ordersCount number of orders
	 */
	public void setOrdersCount(int ordersCount) {
		this.ordersCount = ordersCount;
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

	/**
	 * Gets level's threshold.
	 * 
	 * @return level's threshold
	 */
	public int getThreshold() {
		return threshold;
	}

	/**
	 * Sets level's threshold.
	 * 
	 * @param threshold level's threshold
	 */
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}
}

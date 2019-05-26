package hr.fer.zavrsniRad.BurgerMaster.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 * Class which presents object representation of user's stats.
 * 
 * @author Jelena Šarić
 */

@Entity
@SequenceGenerator(name = "generator", initialValue = 100, allocationSize = 100)
public class UserStats {
	
	/** User's stats id. */
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator")
	private int id;
	
	/** User's id. */
	@Column
	private int userId;
	
	/** User's level. */
	@Column
	private int level;

	/** User's points. */
	@Column
	private int points;

	/**
	 * Gets user's stats id.
	 * 
	 * @return user's stats id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets user's stats id.
	 * 
	 * @param id user's stats id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * Get's user's id.
	 * 
	 * @return user's id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets user's id.
	 * 
	 * @param userId user's id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets user's level.
	 * 
	 * @return user's level
	 */
	public int getLevel() {
		return level;
	}

	/**
	 * Sets user's level.
	 * 
	 * @param level user's level
	 */
	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * Gets user's points.
	 * 
	 * @return user's points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Sets user's points.
	 * 
	 * @param points user's points
	 */
	public void setPoints(int points) {
		this.points = points;
	}
}

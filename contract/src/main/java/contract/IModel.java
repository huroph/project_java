package contract;

import java.util.Observable;


import entity.Map;
import entity.Player;

import javax.swing.*;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	/**
	 * Gets the map
	 *
	 * @return the map entity
	 */
	Map getMap();

	/**
	 * Load the map
	 *
	 * @param id
	 * 			the id
	 */
	void loadMap(int id);

	/**
	 * Gets the hello world.
	 *
	 * @return the helloworld entity
	 */


	/**
	 * Load the message.
	 *
	 * @param code
	 *          the code
	 */



	int RealPos(int index);
	public int IndexPos(int realPos);

	public void setPlayer(final Player player);
	public Player getPlayer();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	void timer();

	int getTimer();

	public void verticalMove(int sens);
	public void horizontalMove(int sens);
	public void dig();
	public void scanFall();
}

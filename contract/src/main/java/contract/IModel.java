package contract;

import java.util.Observable;


import entity.Map;
import entity.Player;

import javax.swing.*;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 * @version $Id: $Id
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
	 * @param index a int.
	 * @return a int.
	 */
	int RealPos(int index);
	/**
	 * <p>IndexPos.</p>
	 *
	 * @param realPos a int.
	 * @return a int.
	 */
	public int IndexPos(int realPos);

	/**
	 * <p>setPlayer.</p>
	 *
	 * @param player a {@link entity.Player} object.
	 */
	public void setPlayer(final Player player);
	/**
	 * <p>getPlayer.</p>
	 *
	 * @return a {@link entity.Player} object.
	 */
	public Player getPlayer();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();

	/**
	 * <p>timer.</p>
	 */
	void timer();
	/**
	 * <p>score.</p>
	 */
	void score();
	/**
	 * <p>endGame.</p>
	 */
	void endGame();



	/**
	 * <p>getTimer.</p>
	 *
	 * @return a int.
	 */
	int getTimer();
	/**
	 * <p>getscore.</p>
	 *
	 * @return a int.
	 */
	int getscore();
	/**
	 * <p>getendGame.</p>
	 *
	 * @return a int.
	 */
	int getendGame();


	/**
	 * <p>verticalMove.</p>
	 *
	 * @param sens a int.
	 */
	public void verticalMove(int sens);
	/**
	 * <p>horizontalMove.</p>
	 *
	 * @param sens a int.
	 */
	public void horizontalMove(int sens);
	/**
	 * <p>dig.</p>
	 */
	public void dig();

	//public void scanFall();





	//public void score();

}

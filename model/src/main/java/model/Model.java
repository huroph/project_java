package model;

import java.sql.SQLException;
import java.util.Observable;

import contract.IModel;
import entity.HelloWorld;
import entity.Map;
import entity.Player;

import javax.swing.*;
import javax.swing.text.View;

import static java.lang.Thread.sleep;
import sun.audio.*;

/**
 * The Class Model.
 *
 * @author Jean-Aymeric Diet
 */
public final class Model extends Observable implements IModel {
	private final int OFFSET = 16;



	/** The helloWorld. */
	private HelloWorld helloWorld;

	private Map map;
	private int mapID = 3;
	private Player player;
	private int startX = RealPos(2);
	private int startY = RealPos(1);
	private int timer = 500;
	private int sleep;

	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.helloWorld = new HelloWorld();
		this.loadMap(mapID);
		this.player = new Player(startX,startY);
	}

	/**
     * Gets the hello world.
     *
     * @return the hello world
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getMessage()
	 */
	public HelloWorld getHelloWorld() {
		return this.helloWorld;
	}

	/**
     * Sets the hello world.
     *
     * @param helloWorld
     *            the new hello world
     */
	private void setHelloWorld(final HelloWorld helloWorld) {
		this.helloWorld = helloWorld;
		this.setChanged();
		this.notifyObservers();
	}


	public void loadHelloWorld(final String code) {
		try {
			final DAOHelloWorld daoHelloWorld = new DAOHelloWorld(DBConnection.getInstance().getConnection());
			this.setHelloWorld(daoHelloWorld.find(code));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
	}



	public Map getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map
	 *            the new map
	 */
	private void setMap(final Map map) {
		this.map = map;
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Load the map.
	 *
	 *@param id
	 *            the map id
	 */
	public void loadMap(final int id){
		try {
			final DAOMap daoMap = new DAOMap(DBConnection.getInstance().getConnection());
			this.setMap(daoMap.find(id));
		} catch (final SQLException e) {
			e.printStackTrace();
		}
		timer();
	}


	/**
     * Gets the observable.
     *
     * @return the observable
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IModel#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}

	public int RealPos(int index){ return index*OFFSET;}
	public int IndexPos(int realPos){ return realPos/OFFSET;}

	public Player getPlayer(){return this.player;}
	/**
	 * Sets the player.
	 *
	 * @param player
	 *            the new player
	 */
	public void setPlayer(Player player){this.player = player;}


	public void timer() {
		new Thread(() -> {
			for (int i = 500; i >= 0; i--) {


				try {
					Thread.sleep(1000);
					timer--;
					this.setTimer(timer);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}


	public void setTimer(int timer) {
		this.timer = timer;
	}

	public int getTimer() {
		return timer;
	}
// méthode music

	public static void music()
	{
		public static void music()
		{
			AudioPlayer MGP = AudioPlayer.player;
			AudioStream BGM;
			AudioData MD;

			ContinuousAudioDataStream loop = null;

			try
			{
				InputStream test = new FileInputStream("C:\\Music1.wmv");
				BGM = new AudioStream(test);
				AudioPlayer.player.start(BGM);
				//MD = BGM.getData();
				//loop = new ContinuousAudioDataStream(MD);

			}
			catch(FileNotFoundException e){
				System.out.print(e.toString());
			}
			catch(IOException error)
			{
				System.out.print(error.toString());
			}
			MGP.start(loop);
		}


	}
	}
}

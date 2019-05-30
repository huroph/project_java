package model;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import contract.IModel;

import entity.*;

import javax.swing.*;
import javax.swing.text.View;

import static java.lang.Thread.sleep;
import sun.audio.*;

public final class Model extends Observable implements IModel {
	private final int OFFSET = 16;
	
	private Map map;
	private int mapID = 2;
	private Player player;
	private int startX = RealPos(2);
	private int startY = RealPos(1);
	private int timer = 500;
	private int score = 0;
	private int sleep;
	/**
	 * Instantiates a new model.
	 */
	public Model() {
		this.loadMap(mapID);
		this.player = new Player(startX,startY);
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
			System.out.println(map.getLenght()+","+map.getHeight());
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

	@Override
	public void score() {

	}

	/*public void score(){
		if(player.getPosX() && player.getPosY() == BlockType.DIAMOND){
			int i = score++;
		}
	}*/


	public void setTimer(int timer) {
		this.timer = timer;
	}
	public void setscore(int score) {
		this.score = score;
	}

	public int getTimer() {
		return timer;
	}

	@Override
	public int getscore() {
		return 0;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// méthode music


	//Deplacements
	public void verticalMove( int sens){
		if (!this.getMap().getBlockTypeAt(this.IndexPos(this.getPlayer().getPosX()), this.IndexPos(this.getPlayer().getPosY() + sens)).isOpaque()) {
			System.out.println(this.IndexPos((int) this.getPlayer().getPosX()) + " : " + this.IndexPos(this.getPlayer().getPosY() + sens));
			System.out.println(this.getPlayer().getPosY() + sens);
			this.getPlayer().setPosY(this.getPlayer().getPosY() + sens);
			System.out.println(this.getPlayer().getPosY());
		}
	}

	public void horizontalMove(int sens){
		if (!this.getMap().getBlockTypeAt(this.IndexPos(this.getPlayer().getPosX() + sens), this.IndexPos(this.getPlayer().getPosY())).isOpaque()) {
			System.out.println(this.IndexPos((int) this.getPlayer().getPosX() + sens) + " : " + this.IndexPos(this.getPlayer().getPosY()));
			System.out.println(this.getPlayer().getPosX() + sens);
			this.getPlayer().setPosX(this.getPlayer().getPosX() + sens);
			System.out.println(this.getPlayer().getPosX());
		}
	}
	/*public void score() {
		for (int y = 0; y < getMap().getHeight(); y++) {
			for (int x = 0; x < getMap().getLenght(); x++) {
				if ((getMap().getBlockTypeAt(x, y).equals(BlockType.DIAMOND)))
					if (this.IndexPos(this.getPlayer().getPosX()) == x && this.IndexPos(this.getPlayer().getPosY()) == y) {
						System.out.println("bb");
						score++;
					}

			}

		}


}*/
	//creuser-récuppérer
	public void dig(){
		if (this.getMap().getBlockTypeAt(this.IndexPos(this.getPlayer().getPosX()), this.IndexPos(this.getPlayer().getPosY())) == BlockType.DIAMOND) {
			score++;
			this.setscore(score);
			System.out.println(score);
			if ( score == 5 && ){
			System.out.println("bb");



			}
		}
		this.getMap().setBlockTypeAt(this.IndexPos(this.getPlayer().getPosX()), this.IndexPos(this.getPlayer().getPosY()), BlockType.EMPTY);
	}
	//falling
	public void scanFall(){
				for(int y = 0; y<getMap().getHeight(); y++){
					for(int x = 0;x<getMap().getLenght();x++){
						if( (getMap().getBlockTypeAt(x,y).isFall()) && getMap().getBlockTypeAt(x,y+1).equals(BlockType.EMPTY) ){

						    if(this.IndexPos(this.getPlayer().getPosX()) != x || this.IndexPos(this.getPlayer().getPosY()) != y+1) {

                                getMap().setBlockTypeAt(x, y+1, getMap().getBlockTypeAt(x,y));
                                getMap().setBlockTypeAt(x, y, BlockType.EMPTY);

                            }

						}
					}
				}
	}





}
package view;

import entity.Block;
import entity.Map;
import entity.Player;


import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;



class ViewPanel extends JPanel implements Observer {


	private ViewFrame viewFrame;



	private static final long	serialVersionUID	= -998294702363713521L;


	/**
	 * <p>Constructor for ViewPanel.</p>
	 *
	 * @param viewFrame a {@link view.ViewFrame} object.
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
	}


	private ViewFrame getViewFrame() {
		return this.viewFrame;
	}

	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/** {@inheritDoc} */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}


	/** {@inheritDoc} */
	@Override
	protected void paintComponent(final Graphics graphics) {
		Graphics2D g2 = (Graphics2D)graphics;

		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());

		Map map = viewFrame.getModel().getMap();
		Block[][] blocks = map.getBlocks();
		for(int y = 0; y<map.getHeight(); y++){
			for(int x = 0;x<map.getLenght();x++){
				//Affichage des sprites
				switch (blocks[y][x].type){
					case WALL:
						graphics.drawImage(viewFrame.getModel().getMap().getSprites(0),blocks[y][x].getPosX(),blocks[y][x].getPosY(), this);
						break;
					case DIRT:
						graphics.drawImage(viewFrame.getModel().getMap().getSprites(1),blocks[y][x].getPosX(),blocks[y][x].getPosY(), this);
						break;
					case EMPTY:
						graphics.drawImage(viewFrame.getModel().getMap().getSprites(2),blocks[y][x].getPosX(),blocks[y][x].getPosY(), this);
						break;
					case ROCK:
						graphics.drawImage(viewFrame.getModel().getMap().getSprites(3),blocks[y][x].getPosX(),blocks[y][x].getPosY(), this);
					break;
					case DIAMOND:
						graphics.drawImage(viewFrame.getModel().getMap().getSprites(4),blocks[y][x].getPosX(),blocks[y][x].getPosY(), this);
						break;
					case ENDLOCK:
						graphics.drawImage(viewFrame.getModel().getMap().getSprites(5),blocks[y][x].getPosX(),blocks[y][x].getPosY(), this);
						break;
				}
			}
		}


		graphics.drawImage(viewFrame.getModel().getPlayer().getPlayerSprites(0),viewFrame.getModel().getPlayer().getPosX(),viewFrame.getModel().getPlayer().getPosY(), this);
		Font font = new Font ("Courier",Font.BOLD,20);
		graphics.setFont(font);
		graphics.drawString("timer:"+viewFrame.getModel().getTimer(),10,340);
		graphics.drawString("Score:"+viewFrame.getModel().getscore(),10,360) ;

		if(viewFrame.getModel().getendGame() ==1){
			viewFrame.printMessage("C'est gagner!!!");
			viewFrame.dispose();
		}

		if( (viewFrame.getModel().getTimer()<=0) || (viewFrame.getModel().isDead()) ) {
			viewFrame.printMessage("Game Over");
			viewFrame.dispose();
		}

		/*
		if(viewFrame.getModel().getdead()==1){
			viewFrame.printMessage("Game Over");
			viewFrame.dispose();
		}*/



		repaint();


	}




}

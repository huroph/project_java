package view;

import entity.Block;
import entity.Map;
import entity.Player;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;



class ViewPanel extends JPanel implements Observer {


	private ViewFrame					viewFrame;

	private static final long	serialVersionUID	= -998294702363713521L;


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

	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}

	//((this.getHeight()/2)-(map.getHeight()/2))
	//((this.getWidth()/2)-(map.getLenght()/2))

	@Override
	protected void paintComponent(final Graphics graphics) {
		Graphics2D g2 = (Graphics2D)graphics;

		graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		//for each blocks in the map
		Map map = viewFrame.getModel().getMap();
		Block[][] blocks = map.getBlocks();
		for(int y = 0; y<map.getHeight(); y++){
			for(int x = 0;x<map.getLenght();x++){
				switch (blocks[y][x].getType()){
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
				}
			}
		}

		//ImageIcon img = new ImageIcon("src")
		System.out.println(viewFrame.getModel().getPlayer().getPosY());
		graphics.drawImage(viewFrame.getModel().getPlayer().getPlayerSprites(0),viewFrame.getModel().getPlayer().getPosX(),viewFrame.getModel().getPlayer().getPosY(), this);
		repaint();
		Font font = new Font ("Courier",Font.BOLD,20);
		graphics.setFont(font);

		graphics.drawString("timer:"+viewFrame.getModel().getTimer(),10,340);
	}


}

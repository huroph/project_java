package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;
import entity.BlockType;
import entity.Player;

/**
 * The Class Controller.
 */
public final class Controller implements IController {

	/** The view. */
	private IView		view;

	/** The model. */
	private IModel	model;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view
	 *          the view
	 * @param model
	 *          the model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);

		control();
	}

	/**
     * Control.
     */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#control()
	 */
	public void control() {
		this.view.printMessage("Appuyer sur les flèches HAUT, BAS, GAUCHE, DROITE, pour déplacer le personnage.");
	}

	/**
     * Sets the view.
     *
     * @param pview
     *            the new view
     */
	private void setView(final IView pview) {
		this.view = pview;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}
	public void orderPerform(final ControllerOrder controllerOrder) {
		Player p = model.getPlayer();
		switch (controllerOrder) {
			case UP:
				//changement de block

				//model.getMap().getBlocks(model.IndexPos(p.getPosX()),model.IndexPos(model.IndexPos(p.getPosY()))).getType()
				//verifier le block sur lequel il doit de deplacer
				System.out.println(model.IndexPos((int) p.getPosX()) + " : " + model.IndexPos(p.getPosY() - 16));
				System.out.println(p.getPosY() - 16);
				p.setPosY(p.getPosY() - 16);
				//model.RealPos(1)
				System.out.println(p.getPosY());

				if(this.model.getMap().getBlockTypeAt(model.IndexPos(model.getPlayer().getPosX()), model.IndexPos(model.getPlayer().getPosY())) == BlockType.WALL){
					p.setPosY(p.getPosY()+16);
				}
				break;
			case DOWN:
				System.out.println(model.IndexPos((int) model.getPlayer().getPosX()) + " : " + model.IndexPos(model.getPlayer().getPosY() -16));
				System.out.println(model.getMap().getBlocks(model.IndexPos((int) model.getPlayer().getPosX()), model.IndexPos(model.getPlayer().getPosY() + model.RealPos(1))).getType());
				model.getPlayer().setPosY(model.getPlayer().getPosY() + 16);
				if(this.model.getMap().getBlockTypeAt(model.IndexPos(model.getPlayer().getPosX()), model.IndexPos(model.getPlayer().getPosY())) == BlockType.WALL){
					p.setPosY(p.getPosY()-16);
				}
				break;
			case LEFT:
				System.out.println(model.IndexPos((int) model.getPlayer().getPosX()) + " : " + model.IndexPos(model.getPlayer().getPosY() - 16));
				System.out.println(model.getMap().getBlocks(model.IndexPos((int) model.getPlayer().getPosX() - model.RealPos(1)), model.IndexPos(model.getPlayer().getPosY())).getType());
				model.getPlayer().setPosX(model.getPlayer().getPosX() - 16);
				if(this.model.getMap().getBlockTypeAt(model.IndexPos(model.getPlayer().getPosX()), model.IndexPos(model.getPlayer().getPosY())) == BlockType.WALL){
					p.setPosX(p.getPosX()+16);
				}
				break;


			case RIGHT:
				System.out.println(model.IndexPos((int) model.getPlayer().getPosX()) + " : " + model.IndexPos(model.getPlayer().getPosY() - 16));
				System.out.println(model.getMap().getBlocks(model.IndexPos((int) model.getPlayer().getPosX() + 16), model.IndexPos(model.getPlayer().getPosY())).getType());
				model.getPlayer().setPosX(model.getPlayer().getPosX() + 16);
				if(this.model.getMap().getBlockTypeAt(model.IndexPos(model.getPlayer().getPosX()), model.IndexPos(model.getPlayer().getPosY())) == BlockType.WALL){
					p.setPosX(p.getPosX()-16);
				}
				break;
			case NOTHING:
				break;
		}
	}

}

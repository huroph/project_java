package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <p>Player class.</p>
 *
 * @author 33660
 * @version $Id: $Id
 */
public class Player extends Entity {
    private int posX, posY;
    private BufferedImage spriteSheet;
    private Image[] sprites;
    private int activeSprite;

    /**
     * <p>Constructor for Player.</p>
     *
     * @param x a int.
     * @param y a int.
     */
    public Player(final int x, final int y) {
        setPosX(x);
        setPosY(y);
        /** ? Entity or Model ? **/
        try {
            spriteSheet = ImageIO.read(new File("src/player.png"));
            sprites = new Image[5];
            // Perso à l'arrêt
            sprites[0] = spriteSheet.getSubimage(0*16, 0 * 16, 16, 16);
           // Déplacement vers la gauche

            sprites[1] = spriteSheet.getSubimage(0*16, 1 * 16, 16, 16);

            //Déplacement vers la droite

            sprites[2] = spriteSheet.getSubimage(0*16, 3 * 16, 16, 16);
            //Monter

            sprites[3] = spriteSheet.getSubimage(2*16,  5* 16, 16, 16);

            // Décendre
            sprites[4] = spriteSheet.getSubimage(0*16, 4 * 16, 16, 16);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Instantiates a new map.
     */
    public Player() {
        this(0,0);
    }
    /**
     * Getters.
     *
     * @return the id
     * @param index a int.
     */
    public Image getPlayerSprites(int index) {
        return sprites[index];
    }
    /**
     * <p>Getter for the field <code>posX</code>.</p>
     *
     * @return a int.
     */
    public int getPosX() {
        return posX;
    }

    /**
     * <p>Setter for the field <code>posX</code>.</p>
     *
     * @param posX a int.
     */
    public void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * <p>Getter for the field <code>posY</code>.</p>
     *
     * @return a int.
     */
    public int getPosY() {
        return posY;
    }

    /**
     * <p>Setter for the field <code>posY</code>.</p>
     *
     * @param posY a int.
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }




    /**
     * <p>Setter for the field <code>sprites</code>.</p>
     *
     * @param sprites an array of {@link java.awt.Image} objects.
     */
    public void setSprites(Image[] sprites) {
        this.sprites = sprites;
    }

    /**
     * <p>Setter for the field <code>sprites</code>.</p>
     *
     * @param index a int.
     * @param spritesImg a {@link java.awt.Image} object.
     */
    public void setSprites(int index, Image spritesImg) {
        this.sprites[index] =  spritesImg;
    }

    /**
     * <p>setSpriteSize.</p>
     *
     * @param size a int.
     */
    public void setSpriteSize(int size){
        this.sprites = new Image[size];
    }

    /**
     * <p>Getter for the field <code>sprites</code>.</p>
     *
     * @param index a int.
     * @return a {@link java.awt.Image} object.
     */
    public Image getSprites(int index) {
        return sprites[index];
    }




}

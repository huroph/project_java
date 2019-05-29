package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player extends Entity {
    private int posX, posY;
    private BufferedImage spriteSheet;
    private Image[] sprites;
    private int activeSprite;

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
     */
    public Image getPlayerSprites(int index) {
        return sprites[index];
    }
    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }




    public void setSprites(Image[] sprites) {
        this.sprites = sprites;
    }

    public void setSprites(int index, Image spritesImg) {
        this.sprites[index] =  spritesImg;
    }

    public void setSpriteSize(int size){
        this.sprites = new Image[size];
    }

    public Image getSprites(int index) {
        return sprites[index];
    }




}

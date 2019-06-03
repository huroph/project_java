package entity;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * <p>Map class.</p>
 *
 * @author 33660
 * @version $Id: $Id
 */
public class Map extends Entity {

    private int	mapID;
    private int height;
    private int lenght;
    private String[] schema;
    private BufferedImage spriteSheet;
    private Image[] sprites;

    private Block[][] blocks;

    /**
     * Instantiates a new hello map.
     * the id
     *  * @param height a int.
     * @param lenght a int.
     */
    public Map(final int mapID, final int height, final int lenght) {
        this.setmapID(mapID);
        this.lenght = lenght; // x
        this.height = height; // y
        schema = new String[height];
        blocks = new Block[height][lenght];

        // fill sprites array
        try {
            spriteSheet = ImageIO.read(new File("src/level.png"));
            sprites = new Image[6];
            // Wall

            sprites[0] = spriteSheet.getSubimage(0*16, 0 * 16, 16, 16);
            // Dirt
            sprites[1] = spriteSheet.getSubimage(1*16, 0 * 16, 32, 16);
            // Empty
            sprites[2] = spriteSheet.getSubimage(2*16, 0 * 16, 16, 16);
            // Rock
            sprites[3] = spriteSheet.getSubimage(3*16, 0 * 16, 16, 16);
            // DIAMOND
            sprites[4] = spriteSheet.getSubimage(5*16,  0* 16, 16, 16);
            //sortieverrouiller
            sprites[5] = spriteSheet.getSubimage(8*16, 0 * 16, 16, 16);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Instantiates a new map.
     */
    public Map() {
        this(0,0,0);
    }

    /**
     * Gets the id.
     *
     * @return the id
     */
    public int getmapID() {
        return this.mapID;
    }

    /**
     * Sets the id.
     *
     * @param id
     *          the new id
     */
    public void setmapID(final int mapID) {
        this.mapID = mapID;
    }

    /**
     * <p>Getter for the field <code>height</code>.</p>
     *
     * @return a int.
     */
    public int getHeight() {
        return height;
    }

    /**
     * <p>Setter for the field <code>height</code>.</p>
     *
     * @param n_line a int.
     */
    public void setHeight(int n_line) {
        this.height = n_line;
    }

    /**
     * <p>Getter for the field <code>lenght</code>.</p>
     *
     * @return a int.
     */
    public int getLenght() {
        return lenght;
    }

    /**
     * <p>Setter for the field <code>lenght</code>.</p>
     *
     * @param lenght a int.
     */
    public void setLenght(int lenght) {
        this.lenght = lenght;
    }

    /**
     * Gets the schema.
     *
     * @return the schema
     * @param index a int.
     */
    public String getSchema(int index) {
        return this.schema[index];
    }

    /**
     * Sets the message.
     *
     * @param content
     *          the new message
     * @param index a int.
     */
    public void setSchema(final int index, final String content) {
        this.schema[index] = content;
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

    /**
     * <p>Getter for the field <code>blocks</code>.</p>
     *
     * @return an array of {@link entity.Block} objects.
     */
    public Block[][] getBlocks() {
        return blocks;
    }
    /**
     * <p>Getter for the field <code>blocks</code>.</p>
     *
     * @param x a int.
     * @param y a int.
     * @return a {@link entity.Block} object.
     */
    public Block getBlocks(int x, int y) {
        return blocks[y][x];
    }

    /**
     * <p>getBlockTypeAt.</p>
     *
     * @param x a int.
     * @param y a int.
     * @return a {@link entity.BlockType} object.
     */
    public BlockType getBlockTypeAt(int x, int y){
        return this.blocks[y][x].type;
    }

    /**
     * <p>setBlockTypeAt.</p>
     *
     * @param x a int.
     * @param y a int.
     * @param t a {@link entity.BlockType} object.
     */
    public void setBlockTypeAt(int x, int y, BlockType t){
        this.blocks[y][x].type = t;
    }


    /**
     * <p>Setter for the field <code>blocks</code>.</p>
     *
     * @param blocks an array of {@link entity.Block} objects.
     */
    public void setBlocks(Block[][] blocks) {
        this.blocks = blocks;
    }

    /**
     * <p>Setter for the field <code>blocks</code>.</p>
     *
     * @param y a int.
     * @param x a int.
     * @param block a {@link entity.Block} object.
     */
    public void setBlocks(int y, int x, Block block){
        this.blocks[y][x] = block;
    }

    /**
     * <p>setBlocksSize.</p>
     *
     * @param lenght a int.
     * @param height a int.
     */
    public void setBlocksSize(int lenght, int height) {
        this.blocks = new Block[height][lenght];
    }
}

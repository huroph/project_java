package entity;

/**
 * <p>Block class.</p>
 *
 * @author 33660
 * @version $Id: $Id
 */
public class Block extends Map{
    private int posX, posY;
    public BlockType type;

    /**
     * <p>Constructor for Block.</p>
     *
     * @param x a int.
     * @param y a int.
     * @param t a {@link entity.BlockType} object.
     */
    public Block(int x, int y, BlockType t){
        this.posX = x;
        this.posY = y;
        this.type = t;
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
     * <p>Getter for the field <code>posY</code>.</p>
     *
     * @return a int.
     */
    public int getPosY() {
        return posY;
    }



}

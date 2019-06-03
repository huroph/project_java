package entity;



/**
 * <p>BlockType class.</p>
 *
 * @author 33660
 * @version $Id: $Id
 */
public enum BlockType {
    WALL(true,false),
    DIRT(false,false),
    EMPTY(false,false),
    ROCK(true,true),
    DIAMOND(false,true),
    ENDLOCK(false,false);
 private final boolean opaque, fall;

    BlockType(boolean opaque, boolean fall){
        this.opaque = opaque;
        this.fall = fall;
    }

    /**
     * <p>isOpaque.</p>
     *
     * @return a boolean.
     */
    public boolean isOpaque() { return opaque; }
    /**
     * <p>isFall.</p>
     *
     * @return a boolean.
     */
    public boolean isFall() {
        return fall;
    }

}

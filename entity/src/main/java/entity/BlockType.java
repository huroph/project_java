package entity;

public enum BlockType {
    WALL(true,false),
    DIRT(false,false),
    EMPTY(false,false),
    ROCK(true,true),
    DIAMOND(true,true),
    ENDLOCK(true,false);
 private final boolean opaque, fall;

    BlockType(boolean opaque, boolean fall){
        this.opaque = opaque;
        this.fall = fall;
    }

    public boolean isOpaque() {
        return opaque;
    }

    public boolean isFall() {
        return fall;
    }

}

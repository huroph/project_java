package model;

import entity.BlockType;
import entity.Map;
import entity.Player;

public class Fall implements Runnable {

    private final int OFFSET = 16;
    private Map map;
    private Player player;

    public Map getMap() {
        return this.map;
    }
    public Player getPlayer(){return this.player;}
    public int IndexPos(int realPos){ return realPos/OFFSET;}

    @Override
    public void run(){
        while(true){
            for(int y = 0; y<getMap().getHeight(); y++){
                for(int x = 0;x<getMap().getLenght();x++){
                    if( (getMap().getBlockTypeAt(x,y).isFall()) && getMap().getBlockTypeAt(x,y+1).equals(BlockType.EMPTY) ){

                        //si block en dessus d'un rocher ou diament est vide, alors rocher ou diamant tombe
                        if(this.IndexPos(this.getPlayer().getPosX()) != x || this.IndexPos(this.getPlayer().getPosY()) != y+1) {

                            getMap().setBlockTypeAt(x, y+1, getMap().getBlockTypeAt(x,y));
                            getMap().setBlockTypeAt(x, y, BlockType.EMPTY);

                        }

                        //si un joueur est deux block en dessous du rocher alors il meurt mais je crois que c'est pas ouf
                        if(this.IndexPos(this.getPlayer().getPosX()) != x || this.IndexPos(this.getPlayer().getPosY()) != y+2) {

                            //En gros il meurt mais je le ferai plus tard

                        }

                    }

                    //conditions pour que les glissades des blocks
                    if( (getMap().getBlockTypeAt(x,y).isFall()) && getMap().getBlockTypeAt(x+1,y).equals(BlockType.EMPTY) && getMap().getBlockTypeAt(x+1,y+1).equals(BlockType.EMPTY) && (getMap().getBlockTypeAt(x,y+1).isFall()) ){
                        getMap().setBlockTypeAt(x+1, y, getMap().getBlockTypeAt(x,y));
                        getMap().setBlockTypeAt(x, y, BlockType.EMPTY);
                    }
                    if( (getMap().getBlockTypeAt(x,y).isFall()) && getMap().getBlockTypeAt(x-1,y).equals(BlockType.EMPTY) && getMap().getBlockTypeAt(x-1,y+1).equals(BlockType.EMPTY) && (getMap().getBlockTypeAt(x,y+1).isFall()) ){
                        getMap().setBlockTypeAt(x-1, y, getMap().getBlockTypeAt(x,y));
                        getMap().setBlockTypeAt(x, y, BlockType.EMPTY);
                    }

                }
            }
        }
    }
}

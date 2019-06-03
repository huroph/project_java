package model;

import entity.BlockType;

public class Fall implements Runnable {
    private Model model;


    @Override
    public void run(){
        while(true){
            for(int y = 0; y<model.getMap().getHeight(); y++){
                for(int x = 0;x<model.getMap().getLenght();x++){
                    if( (model.getMap().getBlockTypeAt(x,y).isFall()) && model.getMap().getBlockTypeAt(x,y+1).equals(BlockType.EMPTY) ){

                        //si block en dessus d'un rocher ou diament est vide, alors rocher ou diamant tombe
                        if(model.IndexPos(model.getPlayer().getPosX()) != x || model.IndexPos(model.getPlayer().getPosY()) != y+1) {

                            model.getMap().setBlockTypeAt(x, y+1, model.getMap().getBlockTypeAt(x,y));
                            model.getMap().setBlockTypeAt(x, y, BlockType.EMPTY);

                        }

                        //si un joueur est deux block en dessous du rocher alors il meurt mais je crois que c'est pas ouf
                        if(model.IndexPos(model.getPlayer().getPosX()) != x || model.IndexPos(model.getPlayer().getPosY()) != y+2) {

                            //En gros il meurt mais je le ferai plus tard

                        }

                    }

                    //conditions pour que les glissades des blocks
                    if( (model.getMap().getBlockTypeAt(x,y).isFall()) && model.getMap().getBlockTypeAt(x+1,y).equals(BlockType.EMPTY) && model.getMap().getBlockTypeAt(x+1,y+1).equals(BlockType.EMPTY) && (model.getMap().getBlockTypeAt(x,y+1).isFall()) ){
                        model.getMap().setBlockTypeAt(x+1, y, model.getMap().getBlockTypeAt(x,y));
                        model.getMap().setBlockTypeAt(x, y, BlockType.EMPTY);
                    }
                    if( (model.getMap().getBlockTypeAt(x,y).isFall()) && model.getMap().getBlockTypeAt(x-1,y).equals(BlockType.EMPTY) && model.getMap().getBlockTypeAt(x-1,y+1).equals(BlockType.EMPTY) && (model.getMap().getBlockTypeAt(x,y+1).isFall()) ){
                        model.getMap().setBlockTypeAt(x-1, y, model.getMap().getBlockTypeAt(x,y));
                        model.getMap().setBlockTypeAt(x, y, BlockType.EMPTY);
                    }

                }
            }
        }
    }
}

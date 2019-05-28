/*package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;


//J'importe la classe en question
import com.sun.media.sound.JavaSoundAudioClip;


public class Music extends JavaSoundAudioClip {

    public Music(InputStream son) throws IOException {
        super(son);
    }

    public static void main(){
        String str = "..\\..\\..\\..\\..\\..\\project_java\\src\\YouSpinMeRound.mp3";
        FileInputStream fic;
        try {
            fic = new FileInputStream(str);
            Music son = new Music(fic);
            son.loop();
        }
        catch (FileNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
*/

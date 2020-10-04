import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.net.URL;

public class PlayAudio {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://ww.domain.com/sound.mp3");
            Clip clip = AudioSystem.getClip();
            AudioInputStream ais = AudioSystem.getAudioInputStream(url);
            clip.open(ais);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

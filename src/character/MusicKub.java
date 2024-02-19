package src.character;


import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class MusicKub {

     public static void music(String soundFilePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                MusicKub.class.getResourceAsStream(soundFilePath));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

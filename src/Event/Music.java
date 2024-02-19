package src.Event ;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
    private static Clip clipBK;
    // private static Clip clipJM;
    // private static Clip clipCR;

    public void playBackgroundSound() {
        try {
            File soundFile = new File("Effact/game-music-loop-7-145285.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            clipBK = AudioSystem.getClip();
            clipBK.open(audioInputStream);
            clipBK.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    public  void stopBackgroundSound() {

        if (clipBK != null && clipBK.isRunning()) {
            clipBK.stop();
        }

    }

    //--------------------------- JUMP -------------------------------
    public  void JMSound() {
        try {
            File soundFile = new File("Effact/jump_c_02-102843.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clipJM = AudioSystem.getClip();
            clipJM.open(audioInputStream);
            clipJM.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    //---------------------------- crash ----------------------------------
    public  void crashSound() {
        try {
            File soundFile = new File("Effact/punch-2-123106.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clipCR = AudioSystem.getClip();
            clipCR.open(audioInputStream);
            clipCR.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

}

package vagi2_1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.Timer;

public class JBuilders {
	
	public static boolean mute = true;

	public static JCheckBox cIestatijumi(String teksts) {
		Font checkBoxFonts = new Font("Dialog", Font.BOLD, 25);
		JCheckBox box = new JCheckBox(teksts);
		box.setForeground(Color.white);
        box.setBackground(new Color(50, 50, 50));
        box.setFont(checkBoxFonts);
        box.setFocusable(false);

		return box;
		
	}
	
	public static void playSound(String path, float volume) {
        // volume: 0.0f = silent, 1.0f = max
        new Thread(() -> {
            try {
                File soundFile = new File(path);
                AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile.toURI().toURL());
                Clip clip = AudioSystem.getClip();
                clip.open(audioIn);

                // Adjust volume
                FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

                // Convert linear 0.0-1.0 volume to decibels
                float dB = 20f * (float) Math.log10(volume <= 0 ? 0.0001 : volume);
                gainControl.setValue(dB);
                
                if(mute)
                	clip.start();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }).start();
    }
	
    public static JButton pSakumaMenu(String teksts) {
        Font startaPoguFonts = new Font("Dialog", Font.BOLD, 35);
        JButton poga = new JButton();

        poga.setText(teksts);
        poga.setBackground(Color.BLACK);
        poga.setForeground(Color.WHITE);
        poga.setPreferredSize(new Dimension(250, 70));
        poga.setFont(startaPoguFonts);
        poga.setFocusable(false);
        poga.setBorder(BorderFactory.createEmptyBorder());
        poga.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Animation colors
        Color startColor = Color.BLACK;
        Color endColor = new Color(210, 210, 210);

        final int duration = 200; // Animation duration in ms
        final int steps = 20;     // Steps for animation

        poga.addMouseListener(new MouseAdapter() {
            private Timer timer;
            private long startTime;

            // Track last time the sound was played
            private long lastSoundTime = 0;
            private final long SOUND_COOLDOWN = 700; // 2 seconds

            @Override
            public void mouseEntered(MouseEvent e) {
                // Play sound only if cooldown passed
                long currentTime = System.currentTimeMillis();
                if (currentTime - lastSoundTime >= SOUND_COOLDOWN) {
                    lastSoundTime = currentTime;
                    playSound("sounds/soundStartButtonClick.wav", 0.2f);
                }

                // Start hover animation
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }

                startTime = System.currentTimeMillis();
                timer = new Timer(duration / steps, _ -> {
                    long elapsed = System.currentTimeMillis() - startTime;
                    float progress = Math.min(1.0f, (float) elapsed / duration);

                    int red = (int) (startColor.getRed() * (1 - progress) + endColor.getRed() * progress);
                    int green = (int) (startColor.getGreen() * (1 - progress) + endColor.getGreen() * progress);
                    int blue = (int) (startColor.getBlue() * (1 - progress) + endColor.getBlue() * progress);

                    poga.setBackground(new Color(red, green, blue));

                    if (progress >= 1.0f) {
                        timer.stop();
                    }
                });
                timer.start();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if (timer != null && timer.isRunning()) {
                    timer.stop();
                }
                // Revert to original color
                poga.setBackground(startColor);
            }
        });

        return poga;
    }
}

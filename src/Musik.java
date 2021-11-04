
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Musik {
	static Clip clip;
//		static AudioInputStream input;

	public static synchronized void musik(String welcheMusik) {
		Hauptklasse.musikaktivierbar = false;
		new Thread(new Runnable() {

			public void run() {
				while (!Hauptklasse.musikläuft) {
					try {
						
						//welche musik starten
						if(welcheMusik=="unterbrechung") {
							System.out.println(11);
						}
						
						if(welcheMusik=="torheim") {
							System.out.println(11);
						}
						
						if(welcheMusik=="torgast") {
							System.out.println(11);
						}
						
						if(welcheMusik=="strafe") {
							System.out.println(11);
						}
						
						if(welcheMusik=="einlaufheim") {
							System.out.println(11);
						}
						
						
						clip = AudioSystem.getClip();
						
						BufferedInputStream bis = new BufferedInputStream(
								getClass().getClassLoader().getResourceAsStream("./Larspacex.wav"));
//						BufferedInputStream bis = new BufferedInputStream(getClass().getClassLoader().getResourceAsStream(path));
				
					
						
						AudioInputStream input = AudioSystem.getAudioInputStream(bis);
						clip.open(input);
						Hauptklasse.musikläuft = true;
						FloatControl gaincontrol = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
						gaincontrol.setValue(-20.0f);
						clip.loop(Clip.LOOP_CONTINUOUSLY);
						Thread.sleep(clip.getMicrosecondLength() / 1000);

					} catch (Exception e) {
						e.printStackTrace();

					}

				}
			}

		}).start();
	}

	public static synchronized void musikbeenden() {
		clip.close();
		Hauptklasse.musikaktivierbar = true;
		Hauptklasse.musikläuft = false;
	}
}

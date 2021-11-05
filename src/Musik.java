
import java.io.BufferedInputStream;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Musik {
	static Clip clip;
	static int zufallsLieder = 12;
//		static AudioInputStream input;

	public static boolean pathExists(String pfad) {
		boolean existiert;

		if (new File(pfad).exists()) {
			existiert = true;
		} else {
			existiert = false;
		}

		System.out.println(existiert);
		return existiert;
	}

	public static synchronized void musik(String welcheMusik) {

		Hauptklasse.musikaktivierbar = false;
		String pfad = "fehler";
		String[] pfadezufallslieder = new String[zufallsLieder];
		for (int i = 0; i < zufallsLieder; i++) {
			pfadezufallslieder[i] = "./zufallslied" + i;
		}

		// welche musik starten
		if (welcheMusik == "unterbrechung") {
			pfad = pfadezufallslieder[new Random().nextInt(zufallsLieder)];
		} else if (welcheMusik == "torheim") {
			pfad = "./torheim.wav";
		} else if (welcheMusik == "torgast") {
			pfad = "./torgast.wav";
		} else if (welcheMusik == "strafe") {
			pfad = "./strafe.wav";
		} else if (welcheMusik == "einlaufheim") {
			pfad = "./Larspacex.wav";
		}
		if (pathExists(pfad)) {
			musikStarten(pfad);
		} else {
			Hauptklasse.musikaktivierbar = true;
		}

	}

	private static void musikStarten(String pfad) {
		new Thread(new Runnable() {

			public void run() {
				while (!Hauptklasse.musikläuft) {
					try {
						Hauptklasse.musikläuft = true;
						BufferedInputStream bis = null;

						clip = AudioSystem.getClip();

						try {
							bis = new BufferedInputStream(getClass().getClassLoader().getResourceAsStream(pfad));
						} catch (Exception e) {
							System.out.println("fehler");
							musikbeenden();
						}
						AudioInputStream input = AudioSystem.getAudioInputStream(bis);
						clip.open(input);

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
		if (Hauptklasse.musikläuft) {
			clip.close();
			Hauptklasse.musikaktivierbar = true;
			Hauptklasse.musikläuft = false;
		}

	}
}

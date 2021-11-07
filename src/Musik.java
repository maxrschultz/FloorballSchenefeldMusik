
import java.io.BufferedInputStream;
import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Musik {
	static Clip clip;
	static int zufallsLieder = 46;

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

		// welche musik starten
		if (welcheMusik == "unterbrechung") {
			pfad = "./Unterbrechungsmusik/zufallslied" + new Random().nextInt(zufallsLieder) + ".wav";
		} else if (welcheMusik == "torheim") {
			pfad = "./Spezial/torheim.wav";
		} else if (welcheMusik == "startingsix") {
			pfad = "./Spezial/startingsix.wav";
		} else if (welcheMusik == "strafe") {
			pfad = "./Spezial/strafegast.wav";
		} else if (welcheMusik == "einlaufenheim") {
			pfad = "./Spezial/einlaufenheim.wav";
		} else if (welcheMusik == "auszeit") {
			pfad = "./Spezial/auszeit.wav";
		} else if (welcheMusik == "blauundweiﬂeinlebenlang") {
			pfad = "./Spezial/blauundweiﬂeinlebenlang.wav";
		} else if (welcheMusik == "hochimnorden") {
			pfad = "./Spezial/hochimnorden.wav";
		} else if (welcheMusik == "einlaufengegner") {
			pfad = "./Spezial/einlaufengegner.wav";
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
				while (!Hauptklasse.musikl‰uft) {
					try {
						Hauptklasse.musikl‰uft = true;
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

					} catch (Exception e) {
						e.printStackTrace();

					}

				}
			}

		}).start();

	}

	public static synchronized void musikbeenden() {
		if (Hauptklasse.musikl‰uft) {
			clip.close();
			Hauptklasse.musikaktivierbar = true;
			Hauptklasse.musikl‰uft = false;
		}

	}
}

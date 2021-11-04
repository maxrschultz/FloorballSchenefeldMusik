import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Gui {
	private int screenhight = 500;
	private int screenwidth = 1000;
	private JFrame jf;

	private ActionListener musikStoppen, musikBeiUnterbrechung, musikBeiEinlaufHeim, musikBeiTorHeim, musikBeiTorGast,
			musikBeiStrafe, musikBeiAuszeit, test;

	public Gui() {
		actionListenerErzeugen();
		guiErzeugen();
	}

	private void einenActionListenerErzeugen(ActionListener a, String befehl) {

		a = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(3);

				if (Hauptklasse.musikaktivierbar) {
					Musik.musik(befehl);
				} else {
					Musik.musikbeenden();

				}

			}
		};
	}

	private void actionListenerErzeugen() {
		musikStoppen = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Musik.musikbeenden();
			}
		};
//		test = new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("test");
//				
//			}
//		};
		einenActionListenerErzeugen(test, "test");

		musikBeiUnterbrechung = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(3);

				if (Hauptklasse.musikaktivierbar) {
					Musik.musik("unterbrechung");
				} else {
					Musik.musikbeenden();

				}

			}
		};
		
		
		einenActionListenerErzeugen(musikBeiUnterbrechung, "unterbrechung");
		einenActionListenerErzeugen(musikBeiAuszeit, "auszeit");
		einenActionListenerErzeugen(musikBeiEinlaufHeim, "einlaufheim");
		einenActionListenerErzeugen(musikBeiStrafe, "strafe");
		einenActionListenerErzeugen(musikBeiTorGast, "torgast");
		einenActionListenerErzeugen(musikBeiTorHeim, "torheim");

	}

	private void guiErzeugen() {
		FensterErzeugen();
		actionListenerErzeugen();
		buttonErzeugen("Einlauf BW96", musikBeiEinlaufHeim);
		buttonErzeugen("Tor BW96", musikBeiTorHeim);
		buttonErzeugen("Tor Gast", musikBeiTorGast);
		buttonErzeugen("Strafe", musikBeiStrafe);
		buttonErzeugen("Auszeit 30sek", musikBeiAuszeit);
		buttonErzeugen("Unterbrechung", musikBeiUnterbrechung);
		buttonErzeugen("Musik Stopp", musikStoppen);

	}

	public void buttonErzeugen(String text, ActionListener aL) {
		JButton jb = new JButton(text);
		jb.setBackground(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
		jb.setFocusable(false);
		jb.addActionListener(aL);
		jf.add(jb);

	}

	public void FensterErzeugen() {
		jf = new JFrame("Floorball BW96 Schenefeld Musik");
		jf.setSize(screenwidth, screenhight);
		jf.setLayout(new GridLayout(5, 0, 5, 5));
		jf.setLocationRelativeTo(null);
		jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

}

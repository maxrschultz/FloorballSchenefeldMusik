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
			musikBeiStrafe, musikBeiAuszeit;

	public Gui() {
		actionListenerErzeugen();
		guiErzeugen();
	}

	private void actionListenerErzeugen() {
		musikStoppen = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Musik.musikbeenden();
			}
		};
		musikBeiUnterbrechung = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Hauptklasse.musikaktivierbar) {
					Musik.musik("unterbrechung");
				}

			}
		};

		musikBeiEinlaufHeim = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Hauptklasse.musikaktivierbar) {
					Musik.musik("einlaufheim");
				}
			}
		};

		musikBeiAuszeit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Hauptklasse.musikaktivierbar) {
					Musik.musik("auszeit");
				}
			}
		};
		musikBeiStrafe = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Hauptklasse.musikaktivierbar) {
					Musik.musik("strafe");
				}
			}
		};
		musikBeiTorGast = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Hauptklasse.musikaktivierbar) {
					Musik.musik("torgast");
				}
			}
		};
		musikBeiTorHeim = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Hauptklasse.musikaktivierbar) {
					Musik.musik("torheim");
				}
			}
		};

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

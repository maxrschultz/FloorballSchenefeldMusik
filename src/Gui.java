import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class Gui {
	private int screenhight = 500;
	private int screenwidth = 1000;
	private JFrame jf;

	private ActionListener musikStoppen, musikBeiUnterbrechung, musikBeiEinlaufHeim, musikBeiTorHeim, musikStartingSix,
			musikBeiStrafe, musikBeiAuszeit,musikBeiEinlaufGast,musikHochImNorden,musikblauundweiﬂeinlebenlang;

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
					Musik.musik("einlaufenheim");
				}
			}
		};
		
		musikBeiEinlaufGast = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Hauptklasse.musikaktivierbar) {
					Musik.musik("einlaufengegner");
				}
			}
		};
		
		musikHochImNorden = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Hauptklasse.musikaktivierbar) {
					Musik.musik("hochimnorden");
				}
			}
		};
		
		musikblauundweiﬂeinlebenlang = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Hauptklasse.musikaktivierbar) {
					Musik.musik("blauundweiﬂeinlebenlang");
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
		musikStartingSix = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (Hauptklasse.musikaktivierbar) {
					Musik.musik("startingsix");
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
		buttonErzeugen("Einlauf BW96", musikBeiEinlaufHeim,Color.blue);
		buttonErzeugen("Einlauf Gast", musikBeiEinlaufGast,Color.white);
		
		buttonErzeugen("Starting Six", musikStartingSix,Color.blue);
		buttonErzeugen("Auszeit 30sek", musikBeiAuszeit,Color.white);
		
		buttonErzeugen("Tor BW96", musikBeiTorHeim,Color.blue);		
		buttonErzeugen("Strafe Gast", musikBeiStrafe,Color.white);
		
		buttonErzeugen("Hoch im Norden", musikHochImNorden,Color.blue);
		buttonErzeugen("Blau und Weiﬂ ein Leben lang", musikblauundweiﬂeinlebenlang,Color.white);
		
		buttonErzeugen("Unterbrechung", musikBeiUnterbrechung,Color.green);
		buttonErzeugen("Musik Stopp", musikStoppen,Color.red);
		

	}

	public void buttonErzeugen(String text, ActionListener aL, Color c) {
		JButton jb = new JButton();
		jb.setFont(new Font("Sans Serif", Font.BOLD, 30));
		jb.setForeground(Color.black);
		jb.setText(text);
		jb.setBackground(c);
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

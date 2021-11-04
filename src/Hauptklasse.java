
public class Hauptklasse {

	public static boolean musikläuft =false;
	public static boolean musikaktivierbar =true;
	
	public Hauptklasse() {
		Gui gui = new Gui();
		Musik musik = new Musik();
	}
	
	
	public static void main(String[] args) {
		Hauptklasse h = new Hauptklasse();
	}

}

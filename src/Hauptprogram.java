
public class Hauptprogram {

	public Hauptprogram() {
	}
	public static void main(String[] args) {
		Huehnerfarm farm = new Huehnerfarm(30);
		Ostereifabrik fabrik = new Ostereifabrik();
		try {
			fabrik.wareneingang(farm.liefereEier(120));
			for (int i = 0; i < fabrik.getAnzahlEierkartons(); i++) {
				fabrik.kocheEier(i);
				fabrik.faerbeEier(i, Osterei.farbe.ugly);
				
			}
		} catch (KartonIndexOutOfBoundsException | Eggception | FarmDeliveryQuantityException e) {
			// TODO Auto-generated catch block
			System.out.println("D:");
		}
		fabrik.printGestapelteEierkartons();
	}

}

/**
 * <img src="https://i2.wp.com/www.elkeskindergeschichten.de/wp-content/uploads/2017/03/Fr%C3%BChlingsspa%C3%9F-im-H%C3%BChnerhof-%C2%A9-klimkinpixabay-cock-2522623_1920.jpg?resize=1360%2C765&ssl=1" width ="100" height ="70">
 * @author student
 *
 */
public class Huehnerfarm {
	int mindestBestellmenge = 30;
	Huehnerfarm(int mindestBestellmenge){
		this.mindestBestellmenge = mindestBestellmenge > 5000 ? this.mindestBestellmenge : mindestBestellmenge < this.mindestBestellmenge ? this.mindestBestellmenge : mindestBestellmenge;
	}
	Huehnerfarm(){
	}
	private Eierkarton[] erstelleEierkartonstapel(int anzahlEier) throws KartonIndexOutOfBoundsException, Eggception {
		anzahlEier = anzahlEier > 5000 ? 5000 : anzahlEier < mindestBestellmenge ? mindestBestellmenge : anzahlEier;
		Eierkarton[] eierkartonStapel = new Eierkarton[anzahlEier/30 + (anzahlEier % 30 == 0 ? 0 : 1)];
		for (int i = 0; i < eierkartonStapel.length; i++) {
			eierkartonStapel[i] = new Eierkarton();
			
		}
		for(int i = 0; i < eierkartonStapel.length; i++) {
			for(int j = 0; j < eierkartonStapel[0].getSize(); j++) {
				if(i*30 + j >= anzahlEier) return eierkartonStapel;
				eierkartonStapel[i].putEiInKarton(new Ei(10));
			}
		}
		return eierkartonStapel;
	}
	public Eierkarton[] liefereEier(int menge) throws KartonIndexOutOfBoundsException, Eggception, FarmDeliveryQuantityException {
		if(menge > 5000) throw new FarmDeliveryQuantityException();
		return erstelleEierkartonstapel((int)(menge * 1.05));
	}
	public Eierkarton[] liefereEier(int menge, int ausschuss) throws KartonIndexOutOfBoundsException, Eggception, FarmDeliveryQuantityException {
		if(menge > 5000) throw new FarmDeliveryQuantityException();
		return (ausschuss < 0 || ausschuss > 100) ? erstelleEierkartonstapel((int)(menge * 1.05)) :  erstelleEierkartonstapel((int)(menge * 1+ ausschuss/100));
	}
}

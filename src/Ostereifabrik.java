/**
 * <img src="https://www.news.at/_storage/asset/4640346/storage/newsat:key-visual/file/62947459/ostern-ostereier-fabrik-herstellung.jpg" width="100" heigth="70">
 * @author student
 *
 */
public class Ostereifabrik {
	Eierkarton[] eierInProduktion;
	public void wareneingang(Eierkarton[] eierkartonStapel) throws KartonIndexOutOfBoundsException {
		eierInProduktion = new Eierkarton[eierkartonStapel.length];
		for(int i = 0; i < eierInProduktion.length; i++) {
			eierInProduktion[i] = new Eierkarton();
		}
		for(int i = 0; i < eierkartonStapel.length; i++) {
			//for(int j = 0; j < eierkartonStapel[i].getSize(); j++) {
			int j = 0;
			while(eierkartonStapel[i].getEiercounter() > 0)	{		
				eierInProduktion[i].putEiInKarton(new Osterei(eierkartonStapel[i].getEi(j)));
				j++;
			}
		}
		eierInProduktion = eierkartonStapel;
	}
	int getAnzahlEierkartons() {
		return eierInProduktion.length;
	}
	void vernichteKarton(int kartonid) {
		if(kartonid < 0 || kartonid >= eierInProduktion.length) return;
		eierInProduktion[kartonid] = null;
	}
	void printGestapelteEierkartons() {
		for(Eierkarton karton :  eierInProduktion) {
			for(int i = 0; i < karton.getSize(); i++) 
				try{
					System.out.print(" " + karton.getOsterei(i).getFarbe() + " ");
				}catch(NullPointerException e) {
					System.out.println("au");
				}
			System.out.println();
		}
	}
	void kocheEier(int kartonid) {
		if(kartonid < 0 || kartonid >= eierInProduktion.length) return;
			for(int i = 0; i < eierInProduktion[kartonid].getSize(); i++) {
				try {
					eierInProduktion[kartonid].getOsterei(i).kochen();
				} catch (EggCrackException e) {
					vernichteKarton(kartonid);
					return;
				}catch(NullPointerException ne) {
					
				}
			}
		
	}
	void faerbeEier(int kartonid, Osterei.farbe farbe) {
		if(kartonid < 0 || kartonid >= eierInProduktion.length) return;
		Osterei egg;
		for(int i = 0; i < eierInProduktion[kartonid].getSize(); i++) {

			try {
				egg = eierInProduktion[kartonid].getOsterei(i);
				if(!egg.isGekocht()) throw new EggNotBoiledException();
				egg.faerben(farbe);
				if(egg.getFarbe() == Osterei.farbe.ugly) throw new EggColoredException();
			}catch(NullPointerException ne) {
				
			} catch (EggColoredException | EggNotBoiledException e) {
				vernichteKarton(kartonid);
				return;
			} 
			
		}
	}
}

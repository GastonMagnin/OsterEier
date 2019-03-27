/**
 * <img src="http://footage.framepool.com/shotimg/qf/403981596-eierkarton-huehnerei-zutat-braun.jpg" height="90" width="90">
 * @author GastonMagnin
 **/
public class Eierkarton {
	Ei[] eier = new Ei[30];
	Osterei[] ostereier = new Osterei[30];
	private int eiercounter = 0;
	public int getEiercounter() {
		return eiercounter;
	}
	public int getSize() {
		return eier.length;
	}
	public Ei getEi(int index) {
		if(index < 0 || index >= eier.length) return null;
		Ei output = eier[index];
		eier[index] = null;
		if(output != null) eiercounter--;
		return output;
	}
	public void putEiInKarton(Ei ei) throws KartonIndexOutOfBoundsException {
		if(eiercounter >= eier.length) throw new KartonIndexOutOfBoundsException("Karton voll :(");
		int i = 0;
		while(eier[i] != null) i++;
		eier[i] = ei;
		eiercounter++;
	}
	public void putEiInKarton(Osterei ei) throws KartonIndexOutOfBoundsException {
		if(eiercounter >= ostereier.length) throw new KartonIndexOutOfBoundsException("Karton voll :(");
		int i = 0;
		while(ostereier[i] != null) i++;
		ostereier[i] = ei;
		eiercounter++;
	}
	public Osterei getOsterei(int index) {
		if(index < 0 || index >= ostereier.length) return null;
		Osterei output = ostereier[index];
		ostereier[index] = null;
		if(output != null) eiercounter--;
		return output;
	}
}

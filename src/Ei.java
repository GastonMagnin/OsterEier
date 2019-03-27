import java.util.Date;
/**
 * <img src="https://www.laendle.at/file/2017/03/NaturkosmetikEi-400x480.jpg" height="90" width="90">
 * @author GastonMagnin
 **/
public class Ei {
	public static void main(String[] args) throws Eggception {
		Ei e = new Ei(3);
		System.out.println(e.getGewicht() + " " + e.getGroesse());
	}
	protected int gewicht;
	protected Date legedatum;
	protected boolean defekt;
	private enum size { S, M, L, XL};
	public Ei(int defectProbability) throws Eggception {
		gewicht = 40 + (int)(Math.random() * 41);
		legedatum = new Date();
		if(defectProbability < 0 || defectProbability > 100) throw new Eggception("Defect Probability out of range");
		defekt = Math.random() * 100  < (defectProbability);
		
	}
	public Ei(Ei egg) {
		this.gewicht = egg.gewicht;
		this.legedatum = egg.legedatum;
		this.defekt = egg.defekt;
	}
	public size getGroesse() {
		//One Line to rule them all,One Line to find them,One Line to bring them all and in the darkness bind them
		return gewicht < 53 ?  size.S : gewicht < 63 ? size.M : gewicht < 74 ? size.L : size.XL;
	}
	public int getGewicht() {
		return gewicht;
	}
	public Date getLegedatum() {
		return legedatum;
	}
	public boolean isDefekt() {
		return defekt;
	}
	public void setDefekt(boolean defekt) {
		if(defekt) this.defekt = defekt;
	}
}

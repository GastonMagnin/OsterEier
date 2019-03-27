/**
 * * <img src="https://d2gg9evh47fn9z.cloudfront.net/thumb_COLOURBOX8827759.jpg" height="90" width="90">
 * @author student
 *
 */
public class Osterei extends Ei{
	
	static enum farbe{blau, gelb, grün, rot, ugly, eifarben};
	private farbe farbe = null;
	private boolean gekocht = false;
	public Osterei(Ei egg){
		super(egg);
	}
	public void kochen() throws EggCrackException {
		gekocht = (gekocht || defekt) ? crack() : true;
	}
	boolean crack() throws EggCrackException {
		throw new EggCrackException();
	}
	public void faerben(farbe farbe) {
		this.farbe = this.farbe != null ? farbe.ugly : farbe;
	}
	public farbe getFarbe() {
		return this.farbe;
	}
	public boolean isGekocht() {
		return gekocht;
	}
}

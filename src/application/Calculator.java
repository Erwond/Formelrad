package application;

/**
 * Berechnet das Formelrad
 * @author Peter Rutschmann
 * @version 13.09.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	
	public Calculator(double leistung, double spannung, double strom, double widerstand) {
		super();
		this.leistung = leistung;
		this.spannung = spannung;
		this.strom = strom;
		this.widerstand = widerstand;
	}
	
	public double getLeistung() {
		return leistung;
	}
	
	public double getSpannung() {
		return spannung;
	}

	public double getStrom() {
		return strom;
	}

	public double getWiderstand() {
		return widerstand;
	}

	@Override
	public String toString() {
		return "Calculator [leistung=" + leistung + 
				", spannung=" + spannung + 
				", strom=" + strom + 
				", widerstand="	+ widerstand + "]";
	}

	public void calculate() {
		if (this.leistung != Double.NaN){
			if(this.spannung != Double.NaN){
			  if(this.widerstand != Double.NaN){
				this.strom = IFromPAndU(this.leistung, this.spannung);
				this.strom = IFromUAndR(this.spannung, this.widerstand);
				this.strom = IFromPAndR(this.leistung, this.widerstand);
			  }
			}
		}
	}
	
	public double IFromPAndU (double P, double U){
		double I = P/U;
		return I;
	}
	
	public double IFromUAndR (double U, double R){
		double I = U/R;
		return I;
	}
	public double IFromPAndR (double P, double R){   
		double I = Math.sqrt(P/R);
		return I;
	}
}

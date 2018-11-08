package application;

/**
 * Berechnet das Formelrad
 * 
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
		return "Calculator [leistung=" + leistung + ", spannung=" + spannung + ", strom=" + strom + ", widerstand="
				+ widerstand + "]";
	}

	public void calculate() {
		Double nan = new Double(Double.NaN);
		if (!nan.equals(this.strom)) {
			if (!nan.equals(this.widerstand)) {
				this.spannung = UFromRAndI(this.widerstand, this.strom);
			} else if (!nan.equals(this.leistung)) {
				this.spannung = UFromPAndI(this.leistung, this.strom);
				this.widerstand = RFromPAndI(this.leistung, this.strom);
			}
		}
		if (!nan.equals(this.widerstand)) {
			if(!nan.equals(this.leistung)){
				this.spannung = UFromPAndR(this.leistung, this.widerstand);
			}
		}
	}

	public double UFromRAndI(double R, double I) {
		double U = R * I;
		return U;
	}

	public double UFromPAndI(double P, double I) {
		double U = P / I;
		return U;
	}

	public double UFromPAndR(double P, double R) {
		double U = Math.sqrt(P * R);
		return U;
	}
	
	public double RFromPAndI(double P, double I) {
		double R = P / Math.pow(I, 2);
		return R;
	}
	
	/*
	 * Hier die Methoden mit den Formlen hinzufügen
	 */

}

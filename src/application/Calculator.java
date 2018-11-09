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
				this.leistung = PFromRandI(this.widerstand, this.strom);
			} else if (!nan.equals(this.leistung)) {
				this.spannung = UFromPAndI(this.leistung, this.strom);
				this.widerstand = RFromPAndI(this.leistung, this.strom);
			} else if (!nan.equals(this.spannung)) {
				this.widerstand = RFromUAndI(this.spannung, this.strom);
				this.leistung = PFromUAndI(this.spannung, this.strom);
			}
		}
		if (!nan.equals(this.widerstand)) {
			if (!nan.equals(this.leistung)) {
				this.strom = IFromPAndR(this.leistung, this.widerstand);
				this.spannung = UFromPAndR(this.leistung, this.widerstand);
			}
			else if(!nan.equals(this.spannung)){
				this.leistung = PFromUAndR(this.spannung, this.widerstand);
				this.strom = IFromUAndR(this.spannung, this.widerstand);
			}
		}
		if(!nan.equals(this.leistung)){
			if(!nan.equals(this.spannung)){
				this.widerstand = RFromUAndP(this.spannung, this.leistung);
				this.strom = IFromPAndU(this.leistung, this.spannung);
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

	public double RFromUAndI(double U, double I) {
		double R = U / I;
		return R;
	}
	
	public double RFromUAndP(double U, double P) {
		double R = Math.pow(U, 2) / P;
		return R;
	}
	
	public double PFromRandI(double R, double I){
		double P = R * Math.pow(I, 2);
		return P;
	}
	
	public double PFromUAndI(double U, double I){
		double P = U * I;
		return P;
	}
	
	public double PFromUAndR(double U, double R){
		double P = Math.pow(U, 2) * R;
		return P;
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
	/*
	 * Hier die Methoden mit den Formlen hinzufügen
	 */

}

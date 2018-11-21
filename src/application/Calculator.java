package application;

import javafx.scene.paint.Color;

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
	private Color leistungColor = Color.web("Black");
	private Color spannungColor = Color.web("Black");
	private Color stromColor = Color.web("Black");
	private Color widerstandColor = Color.web("Black");

	
	
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



	public void setLeistung(double leistung) {
		this.leistung = leistung;
	}



	public double getSpannung() {
		return spannung;
	}



	public void setSpannung(double spannung) {
		this.spannung = spannung;
	}



	public double getStrom() {
		return strom;
	}



	public void setStrom(double strom) {
		this.strom = strom;
	}



	public double getWiderstand() {
		return widerstand;
	}



	public void setWiderstand(double widerstand) {
		this.widerstand = widerstand;
	}



	public Color getLeistungColor() {
		return leistungColor;
	}



	public void setLeistungColor(Color leistungColor) {
		this.leistungColor = leistungColor;
	}



	public Color getSpannungColor() {
		return spannungColor;
	}



	public void setSpannungColor(Color spannungColor) {
		this.spannungColor = spannungColor;
	}



	public Color getStromColor() {
		return stromColor;
	}



	public void setStromColor(Color stromColor) {
		this.stromColor = stromColor;
	}



	public Color getWiderstandColor() {
		return widerstandColor;
	}



	public void setWiderstandColor(Color widerstandColor) {
		this.widerstandColor = widerstandColor;
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
				return;
			} else if (!nan.equals(this.leistung)) {
				this.spannung = UFromPAndI(this.leistung, this.strom);
				this.widerstand = RFromPAndI(this.leistung, this.strom);
				return;
			} else if (!nan.equals(this.spannung)) {
				this.widerstand = RFromUAndI(this.spannung, this.strom);
				this.leistung = PFromUAndI(this.spannung, this.strom);
				return;
			}
		}
		else if (!nan.equals(this.widerstand)) {
			if (!nan.equals(this.leistung)) {
				this.strom = IFromPAndR(this.leistung, this.widerstand);
				this.spannung = UFromPAndR(this.leistung, this.widerstand);
				return;
			}
			else if(!nan.equals(this.spannung)){
				this.leistung = PFromUAndR(this.spannung, this.widerstand);
				this.strom = IFromUAndR(this.spannung, this.widerstand);
				return;
			}
		}
		else if(!nan.equals(this.leistung)){
			if(!nan.equals(this.spannung)){
				this.widerstand = RFromUAndP(this.spannung, this.leistung);
				this.strom = IFromPAndU(this.leistung, this.spannung);
				return;
			}
		}
	}

	public double UFromRAndI(double R, double I) {
		System.out.println("Calculate U from R and I");
		double U = R * I;
		this.spannungColor = Color.web("Red");
		return U;
	}

	public double UFromPAndI(double P, double I) {
		System.out.println("Calculate U from P and I");
		double U = P / I;
		this.spannungColor = Color.web("Red");
		return U;
	}

	public double UFromPAndR(double P, double R) {
		System.out.println("Calculate U from R and P");
		double U = Math.sqrt(P * R);
		this.spannungColor = Color.web("Red");
		return U;
	}

	public double RFromPAndI(double P, double I) {
		System.out.println("Calculate R from P and I");
		double R = P / Math.pow(I, 2);
		this.widerstandColor = Color.web("Red");
		return R;
	}

	public double RFromUAndI(double U, double I) {
		System.out.println("Calculate R from U and I");
		double R = U / I;
		this.widerstandColor = Color.web("Red");
		return R;
	}
	
	public double RFromUAndP(double U, double P) {
		System.out.println("Calculate R from U and P");
		double R = Math.pow(U, 2) / P;
		this.widerstandColor = Color.web("Red");
		return R;
	}
	
	public double PFromRandI(double R, double I){
		System.out.println("Calculate P from R and I");
		double P = R * Math.pow(I, 2);
		this.leistungColor = Color.web("Red");
		return P;
	}
	
	public double PFromUAndI(double U, double I){
		System.out.println("Calculate P from U and I");
		double P = U * I;
		this.leistungColor = Color.web("Red");
		return P;
	}
	
	public double PFromUAndR(double U, double R){
		System.out.println("Calculate P from R and U");
		double P = Math.pow(U, 2) * R;
		this.leistungColor = Color.web("Red");
		return P;
	}
	
	public double IFromPAndU (double P, double U){
		System.out.println("Calculate I from P and U");
		double I = P/U;
		this.stromColor = Color.web("Red");
		return I;
	}
	
	public double IFromUAndR (double U, double R){
		System.out.println("Calculate I from R and U");
		double I = U/R;
		this.stromColor = Color.web("Red");
		return I;
	}
	public double IFromPAndR (double P, double R){
		System.out.println("Calculate I from P and R");
		double I = Math.sqrt(P/R);
		this.stromColor = Color.web("Red");
		return I;
	}
	/*
	 * Hier die Methoden mit den Formlen hinzufügen
	 */

}

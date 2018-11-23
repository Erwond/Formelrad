package application;

import javafx.scene.paint.Color;

/**
 * Berechnet das Formelrad
 * 
 * @author Peter Rutschmann / Eric Walker / Nils Wyss
 * @version 23.11.2018
 */
public class Calculator {
	private double leistung;
	private double spannung;
	private double strom;
	private double widerstand;
	private boolean leistungColor;
	private boolean spannungColor;
	private boolean stromColor;
	private boolean widerstandColor;

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

	public boolean isLeistungColor() {
		return leistungColor;
	}

	public void setLeistungColor(boolean leistungColor) {
		this.leistungColor = leistungColor;
	}

	public boolean isSpannungColor() {
		return spannungColor;
	}

	public void setSpannungColor(boolean spannungColor) {
		this.spannungColor = spannungColor;
	}

	public boolean isStromColor() {
		return stromColor;
	}

	public void setStromColor(boolean stromColor) {
		this.stromColor = stromColor;
	}

	public boolean isWiderstandColor() {
		return widerstandColor;
	}

	public void setWiderstandColor(boolean widerstandColor) {
		this.widerstandColor = widerstandColor;
	}

	public void DivisionByZero(boolean divisionIsZero) {

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
		} else if (!nan.equals(this.widerstand)) {
			if (!nan.equals(this.leistung)) {
				this.strom = IFromPAndR(this.leistung, this.widerstand);
				this.spannung = UFromPAndR(this.leistung, this.widerstand);
				return;
			} else if (!nan.equals(this.spannung)) {
				this.leistung = PFromUAndR(this.spannung, this.widerstand);
				this.strom = IFromUAndR(this.spannung, this.widerstand);
				return;
			}
		} else if (!nan.equals(this.leistung)) {
			if (!nan.equals(this.spannung)) {
				this.widerstand = RFromUAndP(this.spannung, this.leistung);
				this.strom = IFromPAndU(this.leistung, this.spannung);
				return;
			}
		}
	}

	public double UFromRAndI(double R, double I) {
		System.out.println("Calculate U from R and I");
		double U = R * I;
		this.spannungColor = true;
		return U;
	}

	public double UFromPAndI(double P, double I) {
		System.out.println("Calculate U from P and I");
		this.spannungColor = true;
		if (I != 0) {
			double U = P / I;
			return U;
		} else {
			return 0;
		}
	}

	public double UFromPAndR(double P, double R) {
		System.out.println("Calculate U from R and P");
		double U = Math.sqrt(P * R);
		this.spannungColor = true;
		return U;
	}

	public double RFromPAndI(double P, double I) {
		System.out.println("Calculate R from P and I");
		if (I != 0) {
			double R = P / Math.pow(I, 2);
			this.widerstandColor = true;
			return R;
		} else {
			this.widerstandColor = true;
			return 0;
		}
	}

	public double RFromUAndI(double U, double I) {
		System.out.println("Calculate R from U and I");
		if (I != 0) {
			double R = U / I;
			this.widerstandColor = true;
			return R;
		} else {
			this.widerstandColor = true;
			return 0;
		}
	}

	public double RFromUAndP(double U, double P) {
		System.out.println("Calculate R from U and P");
		if (P != 0) {
			double R = Math.pow(U, 2) / P;
			this.widerstandColor = true;
			return R;
		} else {
			this.widerstandColor = true;
			return 0;
		}

	}

	public double PFromRandI(double R, double I) {
		System.out.println("Calculate P from R and I");
		double P = R * Math.pow(I, 2);
		this.leistungColor = true;
		return P;
	}

	public double PFromUAndI(double U, double I) {
		System.out.println("Calculate P from U and I");
		double P = U * I;
		this.leistungColor = true;
		return P;
	}

	public double PFromUAndR(double U, double R) {
		System.out.println("Calculate P from R and U");
		double P = Math.pow(U, 2) * R;
		this.leistungColor = true;
		return P;
	}

	public double IFromPAndU(double P, double U) {
		System.out.println("Calculate I from P and U");
		if (U != 0) {
			double I = P / U;
			this.stromColor = true;
			return I;
		} else {
			this.stromColor = true;
			return 0;
		}
	}

	public double IFromUAndR(double U, double R) {
		System.out.println("Calculate I from R and U");
		if (R != 0) {
			double I = U / R;
			this.stromColor = true;
			return I;
		} else {
			this.stromColor = true;
			return 0;
		}
	}

	public double IFromPAndR(double P, double R) {
		System.out.println("Calculate I from P and R");
		if (R != 0) {
			double I = Math.sqrt(P / R);
			this.stromColor = true;
			return I;
		} else {
			this.stromColor = true;
			return 0;
		}
	}

}

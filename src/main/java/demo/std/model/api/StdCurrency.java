package demo.std.model.api;

import javax.persistence.Embeddable;

@Embeddable
public class StdCurrency {
	
	private String code;
	private double fxRate;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getFxRate() {
		return fxRate;
	}
	public void setFxRate(double fxRate) {
		this.fxRate = fxRate;
	}
	

}

package demo_api.demoapi.entity;

import java.util.Date;

public class ExchangeRate {
	
	private Date rateDate;
	
	private String currency;
	
	private double rate;
	
	
	public ExchangeRate(Date rateDate, String currency, double rate) {
		super();
		this.rateDate = rateDate;
		this.currency = currency;
		this.rate = rate;
	}

	public Date getRateDate() {
		return rateDate;
	}

	public void setRateDate(Date rateDate) {
		this.rateDate = rateDate;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

}

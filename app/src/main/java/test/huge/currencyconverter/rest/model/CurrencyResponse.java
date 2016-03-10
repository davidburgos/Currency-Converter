package test.huge.currencyconverter.rest.model;

/**
 * Created by David Alejandro Burgos on 3/10/16 11:14 AM.
 *
 */

public class CurrencyResponse {

    private String base;
    private String date;
    private Rates rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

}
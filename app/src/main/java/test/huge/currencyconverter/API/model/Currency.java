package test.huge.currencyconverter.API.model;

/**
 * Created by David Alejandro Burgos on 3/10/16 10:42 AM.
 *
 */

public class Currency {

    private String mCurrencyType;
    private String mAmount;

    public Currency() {
    }

    public String getCurrencyType() {
        return mCurrencyType;
    }

    public void setCurrencyType(String currencyType) {
        mCurrencyType = currencyType;
    }

    public String getAmount() {
        return mAmount;
    }

    public void setAmount(String amount) {
        mAmount = amount;
    }
}

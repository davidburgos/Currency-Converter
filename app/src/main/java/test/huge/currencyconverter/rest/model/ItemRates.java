package test.huge.currencyconverter.rest.model;

/**
 * Created by David Alejandro Burgos on 3/10/16 11:55 AM.
 *
 */

public class ItemRates {

    private String mCurrencyType;
    private String mAmount;
    private int mAmountInt;
    private Float mResult = 0F;

    public ItemRates() {
    }

    public ItemRates(String currencyType, String amount) {
        this.mCurrencyType = currencyType;
        this.mAmount = amount;
    }

    public String getAmount() {
        return mAmount;
    }

    public Float getAmountInt() {

        if(this.getAmount() != null && !getAmount().isEmpty()){
            return Float.valueOf(getAmount());
        }
        return 0F;
    }

    public void setAmount(String amount) {
        mAmount = amount;
    }

    public String getCurrencyType() {
        return mCurrencyType;
    }

    public void setCurrencyType(String currencyType) {
        mCurrencyType = currencyType;
    }

    public void setResult(Float result) {
        this.mResult = result;
    }

    public Number getResult() {
        return mResult;
    }
}

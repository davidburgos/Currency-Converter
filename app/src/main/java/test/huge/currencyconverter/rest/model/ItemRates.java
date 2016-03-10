package test.huge.currencyconverter.rest.model;

/**
 * Created by David Alejandro Burgos on 3/10/16 11:55 AM.
 *
 */

public class ItemRates {

    private String mCurrencyType;
    private String mAmount;
    private int mAmountInt;
    private int mResult;

    public ItemRates() {
    }

    public ItemRates(String currencyType, String amount) {
        this.mCurrencyType = currencyType;
        this.mAmount = amount;
    }

    public String getAmount() {
        return mAmount;
    }

    public int getAmountInt() {

        if(this.getAmount() != null && !getAmount().isEmpty()){
            return Integer.valueOf(getAmount());
        }
        return 0;
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

    public void setResult(int result) {
        this.mResult = result;
    }

    public int getResult() {
        return mResult;
    }
}

package moneycalculator;

public class ExchangeRate {
    private final String actualCurrency;
    private final String fromCurrency;
    private final float rate;
    
    public ExchangeRate(String actualCurrency, float rate, String fromCurrency) {
        this.actualCurrency = actualCurrency;
        this.fromCurrency = fromCurrency;
        this.rate = rate;
    }

    public String getActualCurrency() {
        return actualCurrency;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public Number getRate() {
        return rate;
    }
    
}

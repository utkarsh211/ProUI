package com.example.radiusassignment.Model;

public class Cost{
    private String value;
    private String currency;
    private String currency_symbol;

    public Cost(String value, String currency, String currency_symbol) {
        this.value = value;
        this.currency = currency;
        this.currency_symbol = currency_symbol;
    }

    public String getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    public String getCurrency_symbol() {
        return currency_symbol;
    }
}

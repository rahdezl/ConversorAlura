package com.conversor.conversor.DTO;

public class ConverterDTO {
    private String from;
    private String to;
    private String amount;

    public ConverterDTO(String from, String to, String amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getAmount() {
        return amount;
    }
}

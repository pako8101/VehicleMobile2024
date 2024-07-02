package Vehiclemobile2024.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name = "ex_rates")
public class ExRateEntity extends BaseEntity{

    private String currency;
    private BigDecimal rate;

    public ExRateEntity() {
    }

    public String getCurrency() {
        return currency;
    }

    public ExRateEntity setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public ExRateEntity setRate(BigDecimal rate) {
        this.rate = rate;
        return this;
    }

    @Override
    public String toString() {
        return "ExRateEntity{" +
                "currency='" + currency + '\'' +
                ", rate=" + rate +
                '}';
    }
}

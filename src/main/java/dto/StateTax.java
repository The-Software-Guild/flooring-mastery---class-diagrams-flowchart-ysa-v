package dto;

import java.math.BigDecimal;

public class StateTax {

    private String stateAbbreviation;
    private String stateName;
    private BigDecimal taxRate;

    public StateTax(String stateAbbreviation, String stateName, BigDecimal taxRate) {
        this.stateAbbreviation = stateAbbreviation;
        this.stateName = stateName;
        this.taxRate = taxRate;
    }

    public String getStateAbbreviation() {
        return stateAbbreviation;
    }

    public String getStateName() {
        return stateName;
    }

    public BigDecimal getTaxRate() {
        return taxRate;
    }
}

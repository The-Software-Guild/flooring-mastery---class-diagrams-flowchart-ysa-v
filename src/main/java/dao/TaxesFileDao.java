package dao;

import dto.Product;
import dto.StateTax;

import java.util.Map;

public interface TaxesFileDao {

    public StateTax unmarshallStateTax(String line);

    public Map<String, StateTax> loadStateTax(String file) throws FlooringMasteryException;
}

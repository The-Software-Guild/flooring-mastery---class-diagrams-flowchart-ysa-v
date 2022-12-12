package dao;

import dto.StateTax;

import java.util.Map;

public class TaxesFileDaoImpl implements TaxesFileDao{
    @Override
    public StateTax unmarshallStateTax(String line) {
        return null;
    }

    @Override
    public Map<String, StateTax> loadStateTax(String file) throws FlooringMasteryException {
        return null;
    }
}

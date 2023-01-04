package br.com.fbm.calculadora.fbmcalculadora.repositories;

import org.springframework.stereotype.Service;

@Service
public class ConverterNumber {
    
    public boolean isNumeric(String pNumber){
        if(pNumber == null) return false;
        String convertNumber = pNumber.replace(",", ".");
        return convertNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    public Double convertToDouble(String pNumber){
        
        if(pNumber == null) return 0D;

        String convertNumber = pNumber.replace(",", ".");

        if(isNumeric(convertNumber)) return Double.parseDouble(convertNumber);

        return 0D;

    }

}

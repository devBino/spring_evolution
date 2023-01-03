package br.com.fbm.calculadora.fbmcalculadora.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fbm.calculadora.fbmcalculadora.exception.UnsupportedCalcException;

import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class CalcController {
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
        method=RequestMethod.GET)
    public Double sum(
        @PathVariable(value="numberOne") String pNumberOne,
        @PathVariable(value="numberTwo") String pNumberTwo)
            throws Exception, UnsupportedCalcException {

        if(!isNumeric(pNumberOne)){
            throw new UnsupportedCalcException("Please set a numeric value");
        }

        if(!isNumeric(pNumberTwo)){
            throw new Exception("Please set a numeric value");
        }

        return convertToDouble(pNumberOne)  + convertToDouble(pNumberTwo);

    }

    private boolean isNumeric(String pNumber){
        if(pNumber == null) return false;
        String convertNumber = pNumber.replace(",", ".");
        return convertNumber.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private Double convertToDouble(String pNumber){
        
        if(pNumber == null) return 0D;

        String convertNumber = pNumber.replace(",", ".");

        if(isNumeric(convertNumber)) return Double.parseDouble(convertNumber);

        return 0D;

    }

}

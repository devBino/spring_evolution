package br.com.fbm.calculadora.fbmcalculadora.controllers;

import java.util.Arrays;
import java.util.List;

import javax.print.attribute.standard.Media;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fbm.calculadora.fbmcalculadora.exception.UnsupportedCalcException;
import br.com.fbm.calculadora.fbmcalculadora.model.ResultModel;
import br.com.fbm.calculadora.fbmcalculadora.repositories.ConverterNumber;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class CalcController {

    private static final String MSG_ERRO_NUMEROS = "Please set a numeric value";

    @Autowired
    private ConverterNumber converter;

    @RequestMapping(value = "/list/{size}", 
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<ResultModel> listNumbers(
        @PathVariable(value = "size") int pSize
    ){
        
        List<ResultModel> results = Arrays.asList(
            new ResultModel(10D, 10D, 20D, '+'),
            new ResultModel(10D, 10D, 0D, '-')
        );

        return results;
        
    }
    
    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}",
        method=RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE)
    public ResultModel sum(
        @PathVariable(value="numberOne") String pNumberOne,
        @PathVariable(value="numberTwo") String pNumberTwo)
            throws Exception, UnsupportedCalcException {

        Double calc = executeCalc(pNumberOne, pNumberTwo, '+');

        ResultModel result = new ResultModel(converter.convertToDouble(pNumberOne), 
            converter.convertToDouble(pNumberTwo), calc, '+');

        return result;

    }

    @RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sub(
        @PathVariable(value = "numberOne") String pNumberOne,
        @PathVariable(value = "numberTwo") String pNumberTwo
    ) throws UnsupportedCalcException {

        return executeCalc(pNumberOne, pNumberTwo, '-');

    }

    @RequestMapping(value = "/div/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double div(
        @PathVariable(value = "numberOne") String pNumberOne,
        @PathVariable(value = "numberTwo") String pNumberTwo
    ) throws UnsupportedCalcException {
    
        return executeCalc(pNumberOne, pNumberTwo, '/');
        
    }

    @RequestMapping(value = "/mul/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double mul(
        @PathVariable(value = "numberOne") String pNumberOne,
        @PathVariable(value = "numberTwo") String pNumberTwo
    ) throws UnsupportedCalcException {

        return executeCalc(pNumberOne, pNumberTwo, '*');

    }

    private Double executeCalc(String pNumberOne, String pNumberTwo, char pSinal){

        if( !converter.isNumeric(pNumberOne) || !converter.isNumeric(pNumberTwo) ){
            throw new UnsupportedCalcException(MSG_ERRO_NUMEROS);
        }
        
        Double result = 0D;

        switch(pSinal){

            case '+':
                result = converter.convertToDouble(pNumberOne) + converter.convertToDouble(pNumberTwo);
                break;
            case '-':
                result = converter.convertToDouble(pNumberOne) - converter.convertToDouble(pNumberTwo);
                break;
            case '/':
                result = converter.convertToDouble(pNumberOne) / converter.convertToDouble(pNumberTwo);
                break;
            case '*':
                result = converter.convertToDouble(pNumberOne) * converter.convertToDouble(pNumberTwo);
                break;

        }

        return result;

    }

}

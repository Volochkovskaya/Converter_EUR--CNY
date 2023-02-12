package com.example.converter;

import com.example.converter.controller.ConverterController;
import com.example.converter.controller.ParseRatesController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConverterControllerTests {

    @Test
    public void inputCheck(){
        ConverterController converterController = new ConverterController();
        Assertions.assertEquals(converterController.convertCNYtoEUR("TEST VALUE"),"Необходимо ввести числовое значение!");
        Assertions.assertTrue(converterController.convertEURtoCNY("2").matches("\\d+ EUR = \\d+.\\d{6} CNY"));
    }

    @Test
    public void getRatesCheck(){
        ParseRatesController prc = new ParseRatesController();
        String[] ratesArr = prc.getRates();
        try {
            for (String s : ratesArr) {
                Double.parseDouble(s);
            }
        }catch (NumberFormatException e){
            Assertions.fail();
        }


    }
}

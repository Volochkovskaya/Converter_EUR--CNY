package com.example.converter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class ConverterController {
    private ParseRatesController prc = new ParseRatesController();

    @GetMapping("/convert/EURtoCNY/{EUR}")
    public String convertEURtoCNY(@PathVariable(name = "EUR") String EURvalue) {
        String[] rates = prc.getRates();
        double rate0 = Double.parseDouble(rates[0]);
        double rate1 = Double.parseDouble(rates[1]);
        try {
            double value = Double.parseDouble(EURvalue) * rate0;
            return EURvalue + " EUR = " + String.format("%.6f", value / rate1) + " CNY";
        }catch (NumberFormatException e){
            return "Необходимо ввести числовое значение!";
        }
    }

    @GetMapping("/convert/CNYtoEUR/{CNY}")
    public String convertCNYtoEUR(@PathVariable(name = "CNY") String CNYvalue) {
        String[] rates = prc.getRates();
        double rate0 = Double.parseDouble(rates[0]);
        double rate1 = Double.parseDouble(rates[1]);
        try {
            double value = Double.parseDouble(CNYvalue) * rate1;
            return CNYvalue + " CNY = " + String.format("%.6f", value / rate0) + " EUR";
        }catch (NumberFormatException e){
            return "Необходимо ввести числовое значение!";
        }
    }
}

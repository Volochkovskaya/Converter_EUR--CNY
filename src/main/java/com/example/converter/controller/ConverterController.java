package com.example.converter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/converter")
public class ConverterController {

    @GetMapping("/convert/EURtoCNY/{EUR}")
    public String convertEURtoCNY(@PathVariable(name = "EUR") String EURvalue) {
        double rate0 = 1;
        double rate1 = 2;
        double value = Double.parseDouble(EURvalue) * rate0;
        return EURvalue + " EUR = " + String.format("%.6f", value / rate1) + " CNY";
    }
}

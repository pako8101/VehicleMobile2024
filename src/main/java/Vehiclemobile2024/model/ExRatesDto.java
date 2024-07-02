package Vehiclemobile2024.model;

import java.math.BigDecimal;
import java.util.Map;

public record ExRatesDto(String base ,
                         Map<String, BigDecimal> rates) {
//    {
//
//            "base": "USD",
//            "rates": {
//
//
//
//                "BGN": 1.8287,
//
//
//
//
//                "EUR": 0.933778,
//
//    }

}

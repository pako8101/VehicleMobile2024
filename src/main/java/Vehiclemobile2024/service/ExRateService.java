package Vehiclemobile2024.service;

import Vehiclemobile2024.model.ExRatesDto;

public interface ExRateService {

    boolean hasInitializedExRates();

    ExRatesDto fetchExRates();

    void updateRats(ExRatesDto exRatesDto);



}

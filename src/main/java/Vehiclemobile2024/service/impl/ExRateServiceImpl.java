package Vehiclemobile2024.service.impl;

import Vehiclemobile2024.config.ForexApiConfig;
import Vehiclemobile2024.model.ExRatesDto;
import Vehiclemobile2024.model.repository.ExRateRepository;
import Vehiclemobile2024.service.ExRateService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class ExRateServiceImpl implements ExRateService {

    private final ExRateRepository exRateRepository;
    private final ForexApiConfig forexApiConfig;
    private final RestClient restClient;

    public ExRateServiceImpl(ExRateRepository exRateRepository,
                             RestClient restClient,
                             ForexApiConfig forexApiConfig) {
        this.exRateRepository = exRateRepository;
        this.forexApiConfig = forexApiConfig;
        this.restClient = restClient;
    }

    @Override
    public boolean hasInitializedExRates() {
      return   this.exRateRepository.count() >0;


    }

    @Override
    public ExRatesDto fetchExRates() {
        restClient
                .get()
                .uri(forexApiConfig.getUrl(),forexApiConfig.getKey())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(ExRatesDto.class);

        return null;
    }

    @Override
    public void updateRats(ExRatesDto exRatesDto) {

    }
}

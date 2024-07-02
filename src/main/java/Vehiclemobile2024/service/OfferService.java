package Vehiclemobile2024.service;

import Vehiclemobile2024.model.AddOfferDto;
import Vehiclemobile2024.model.OfferDetailsDto;
import Vehiclemobile2024.model.OfferSummaryDto;

import java.util.List;

public interface OfferService {

    long createOrder(AddOfferDto addOfferDto);

    OfferDetailsDto getOfferDetails(Long id);

    List<OfferSummaryDto> getAllOffersSummary();

    void deleteOffer(long id);
}

package Vehiclemobile2024.service;

import Vehiclemobile2024.model.AddOfferDto;
import Vehiclemobile2024.model.OfferDetailsDto;

public interface OfferService {

    long createOrder(AddOfferDto addOfferDto);

    OfferDetailsDto getOfferDetails(Long id);
}

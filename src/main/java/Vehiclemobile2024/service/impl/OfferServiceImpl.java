package Vehiclemobile2024.service.impl;

import Vehiclemobile2024.model.AddOfferDto;
import Vehiclemobile2024.model.OfferDetailsDto;
import Vehiclemobile2024.model.OfferSummaryDto;
import Vehiclemobile2024.model.entity.OfferEntity;
import Vehiclemobile2024.model.repository.OfferRepository;
import Vehiclemobile2024.service.OfferService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;

    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }
    @Override
    public long createOrder(AddOfferDto addOfferDto) {

      return  offerRepository.save(map(addOfferDto)).getId();

    }

    @Override
    public OfferDetailsDto getOfferDetails(Long id) {

        this.offerRepository.findById(id)
                .map(OfferServiceImpl::toofferDetailsDto)
                .orElseThrow();

        return null;
    }

    @Override
    public List<OfferSummaryDto> getAllOffersSummary() {
        return offerRepository.findAll()
                .stream()
                .map(OfferServiceImpl::toOfferSummaryDto)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteOffer(long id) {
        offerRepository.deleteById(id);
    }

    private static OfferSummaryDto toOfferSummaryDto(OfferEntity offerEntity){
        return new OfferSummaryDto(offerEntity.getId(),
                offerEntity.getDescription(),
                offerEntity.getMileage(),
                offerEntity.getEngine());
    }

    private static OfferDetailsDto toofferDetailsDto(OfferEntity offerEntity){
        return new OfferDetailsDto(offerEntity.getId(),
                offerEntity.getDescription(),
                offerEntity.getMileage(),
                offerEntity.getEngine());
    }

    public static OfferEntity map(AddOfferDto addOfferDto){
        return  new OfferEntity()
                .setDescription(addOfferDto.description())
                .setEngine(addOfferDto.engineType())
                .setMileage(addOfferDto.mileage());
    }
}

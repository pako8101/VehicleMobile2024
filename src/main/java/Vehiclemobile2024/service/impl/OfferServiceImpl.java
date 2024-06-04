package Vehiclemobile2024.service.impl;

import Vehiclemobile2024.model.AddOfferDto;
import Vehiclemobile2024.model.OfferDetailsDto;
import Vehiclemobile2024.model.entity.OfferEntity;
import Vehiclemobile2024.model.repository.OfferRepository;
import Vehiclemobile2024.service.OfferService;
import org.springframework.stereotype.Service;

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

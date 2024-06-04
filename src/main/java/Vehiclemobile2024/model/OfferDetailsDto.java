package Vehiclemobile2024.model;

import Vehiclemobile2024.model.enums.EngineTypeEnum;

public record OfferDetailsDto(
        Long id,
        String description,
        Integer mileage,
        EngineTypeEnum engineType
) {
}

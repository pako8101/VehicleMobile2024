package Vehiclemobile2024.model;

import Vehiclemobile2024.model.enums.EngineTypeEnum;
import jakarta.validation.constraints.*;

public record AddOfferDto(
       @NotEmpty (message = "{add.offer.description.not.empty}")
       @Size(message = "Description must be between 5  and 500 symbols."
               ,min = 5,max = 500) String description,
       @NotNull @PositiveOrZero Integer mileage,
       @NotNull EngineTypeEnum engineType
) {
    public static AddOfferDto empty(){
        return new AddOfferDto(null,56,null);
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public EngineTypeEnum engineType() {
        return engineType;
    }
}

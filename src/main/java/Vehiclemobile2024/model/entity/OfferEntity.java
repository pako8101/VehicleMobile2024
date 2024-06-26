package Vehiclemobile2024.model.entity;

import Vehiclemobile2024.model.enums.EngineTypeEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "offers")
public class OfferEntity extends BaseEntity{


    private String description;
    private int mileage;

    @Enumerated(EnumType.STRING)
    private EngineTypeEnum engine;

    public OfferEntity() {
    }

    public int getMileage() {
        return mileage;
    }

    public OfferEntity setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }



    public String getDescription() {
        return description;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineTypeEnum getEngine() {
        return engine;
    }

    public OfferEntity setEngine(EngineTypeEnum engine) {
        this.engine = engine;
        return this;
    }
}

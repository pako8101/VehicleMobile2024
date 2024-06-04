package Vehiclemobile2024.model.repository;

import Vehiclemobile2024.model.entity.OfferEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity,Long> {
}

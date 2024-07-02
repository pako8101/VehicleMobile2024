package Vehiclemobile2024.model.repository;

import Vehiclemobile2024.model.entity.ExRateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExRateRepository extends JpaRepository<ExRateEntity,Long> {




}

package org.example.lm.tinnova.test.exercise_5.repository;

import org.example.lm.tinnova.test.exercise_5.domain.Vehicle;
import org.example.lm.tinnova.test.exercise_5.dto.VehicleByDecadeOfManufactureResponseDTO;
import org.example.lm.tinnova.test.exercise_5.dto.VehicleByManufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    Long countBySoldFalse();

    @Query("select new org.example.lm.tinnova.test.exercise_5.dto.VehicleByManufacturer(vehicle.brand, count(*) as qtde) " +
            " from org.example.lm.tinnova.test.exercise_5.domain.Vehicle vehicle " +
            " group by vehicle.brand " +
            " order by vehicle.brand ")
    List<VehicleByManufacturer> getVehicleByManufacturer();

    List<Vehicle> findByCreatedGreaterThanEqual(final LocalDateTime localDateTime);

    @Query(value = " select left(to_char(v.created::date, 'yyyy'), 3) as decada, count(*) as qtde " +
            " from vehicle v " +
            " group by decada " +
            " order by decada ", nativeQuery = true)
    List<VehicleByDecadeOfManufactureResponseDTO> getVehiclesByDecadeOfManufacture();
}

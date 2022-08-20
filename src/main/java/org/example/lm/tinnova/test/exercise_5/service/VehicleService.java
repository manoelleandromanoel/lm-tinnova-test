package org.example.lm.tinnova.test.exercise_5.service;

import org.example.lm.tinnova.test.exercise_5.domain.Brand;
import org.example.lm.tinnova.test.exercise_5.domain.Vehicle;
import org.example.lm.tinnova.test.exercise_5.dto.*;
import org.example.lm.tinnova.test.exercise_5.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public VehiclesResponseDTO getVehicles() {
        return VehicleHelper.toVehiclesResponseDTO(vehicleRepository.findAll());
    }

    public VehicleResponseDTO getVehicleById(final Long vehicleId) {
        return VehicleHelper.toVehicleResponseDTO(vehicleRepository.findById(vehicleId).orElse(null));
    }

    public VehicleResponseDTO postOrUpdateVehicle(final Long vehicleId, final VehicleRequestDTO vehicleRequestDTO) {
        if (vehicleId == null) {
            return VehicleHelper.toVehicleResponseDTO(
                    vehicleRepository.save(
                            Vehicle.builder()
                                    .model(vehicleRequestDTO.getModel())
                                    .brand(Brand.forAlias(vehicleRequestDTO.getBrand()))
                                    .year(vehicleRequestDTO.getYear())
                                    .description(vehicleRequestDTO.getDescription())
                                    .sold(vehicleRequestDTO.getSold())
                                    .created(LocalDateTime.now())
                                    .build()
                    )
            );
        } else {
            Vehicle vehicle = vehicleRepository.getById(vehicleId);
            vehicle.setModel(vehicleRequestDTO.getModel());
            vehicle.setBrand(Brand.forAlias(vehicleRequestDTO.getBrand()));
            vehicle.setYear(vehicleRequestDTO.getYear());
            vehicle.setDescription(vehicleRequestDTO.getDescription());
            vehicle.setSold(vehicleRequestDTO.getSold());
            vehicle.setUpdated(LocalDateTime.now());

            return VehicleHelper.toVehicleResponseDTO(vehicleRepository.save(vehicle));
        }
    }

    public VehicleResponseDTO patchVehicle(final Long vehicleId, final PatchVehicleRequestDTO patchVehicleRequestDTO) throws Exception {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElseThrow(() -> new Exception("Veículo não encontrado!"));

        vehicle.setDescription(patchVehicleRequestDTO.getDescription());
        vehicle.setSold(patchVehicleRequestDTO.getSold());

        return VehicleHelper.toVehicleResponseDTO(vehicleRepository.save(vehicle));
    }

    public void deleteVehicle(final Long vehicleId) throws Exception {
        try {
            vehicleRepository.deleteById(vehicleId);
        } catch (Exception e) {
            throw new Exception("Veículo não encontrado!");
        }
    }

    public Long getVehiclesAvailable() {
        return vehicleRepository.countBySoldFalse();
    }

    public VehiclesByDecadeOfManufactureResponseDTO getVehiclesByDecadeOfManufacture() {
        var vehiclesByDecadeOfManufacture = vehicleRepository.getVehiclesByDecadeOfManufacture();

        var newVehicleList = vehiclesByDecadeOfManufacture.stream()
                .map(vehicleByDecadeOfManufactureResponseDTO ->
                        VehicleByDecadeOfManufactureResponseDTO.builder()
                                .decade(vehicleByDecadeOfManufactureResponseDTO.getDecade().concat("0"))
                                .amount(vehicleByDecadeOfManufactureResponseDTO.getAmount())
                                .build()
                ).collect(Collectors.toList());

        return VehiclesByDecadeOfManufactureResponseDTO.builder()
                .vehiclesByDecadeOfManufactureResponseDTOList(newVehicleList)
                .build();
    }

    public VehiclesByManufacturer getVehiclesByManufacturer() {
        return VehiclesByManufacturer.builder()
                .vehicleByManufacturerList(vehicleRepository.getVehicleByManufacturer())
                .build();
    }

    public VehiclesResponseDTO getVehiclesRegisteredInTheLastWeek() {
        return VehicleHelper.toVehiclesResponseDTO(
                vehicleRepository.findByCreatedGreaterThanEqual(LocalDateTime.now().minusDays(7))
        );
    }
}

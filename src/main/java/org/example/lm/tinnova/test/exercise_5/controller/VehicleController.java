package org.example.lm.tinnova.test.exercise_5.controller;

import org.example.lm.tinnova.test.exercise_5.VehicleResource;
import org.example.lm.tinnova.test.exercise_5.dto.*;
import org.example.lm.tinnova.test.exercise_5.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VehicleController implements VehicleResource {

    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public ResponseEntity<VehiclesResponseDTO> getVehicles() {
        return ResponseEntity.ok(vehicleService.getVehicles());
    }

    @Override
    public ResponseEntity<VehicleResponseDTO> getVehicleById(final Long vehicleId) {
        var ret = vehicleService.getVehicleById(vehicleId);

        if (ret == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(ret);
        }
    }

    @Override
    public ResponseEntity<VehicleResponseDTO> postVehicle(final VehicleRequestDTO vehicleRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(vehicleService.postOrUpdateVehicle(null, vehicleRequestDTO));
    }

    @Override
    public ResponseEntity<VehicleResponseDTO> putVehicle(final Long vehicleId, final VehicleRequestDTO vehicleRequestDTO) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehicleService.postOrUpdateVehicle(vehicleId, vehicleRequestDTO));
    }

    @Override
    public ResponseEntity<VehicleResponseDTO> patchVehicle(final Long vehicleId, final PatchVehicleRequestDTO patchVehicleRequestDTO) throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(vehicleService.patchVehicle(vehicleId, patchVehicleRequestDTO));
    }

    @Override
    public ResponseEntity<Void> deleteVehicle(final Long vehicleId) throws Exception {
        vehicleService.deleteVehicle(vehicleId);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Long> getVehiclesAvailable() {
        return ResponseEntity.ok(vehicleService.getVehiclesAvailable());
    }

    @Override
    public ResponseEntity<VehiclesByDecadeOfManufactureResponseDTO> getVehiclesByDecadeOfManufacture() {
        return ResponseEntity.ok(vehicleService.getVehiclesByDecadeOfManufacture());
    }

    @Override
    public ResponseEntity<VehiclesByManufacturer> getVehiclesByManufacturer() {
        return ResponseEntity.ok(vehicleService.getVehiclesByManufacturer());
    }

    @Override
    public ResponseEntity<VehiclesResponseDTO> getVehiclesRegisteredInTheLastWeek() {
        return ResponseEntity.ok(vehicleService.getVehiclesRegisteredInTheLastWeek());
    }
}

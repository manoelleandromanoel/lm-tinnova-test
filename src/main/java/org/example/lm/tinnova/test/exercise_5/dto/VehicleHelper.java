package org.example.lm.tinnova.test.exercise_5.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.example.lm.tinnova.test.exercise_5.domain.Vehicle;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class VehicleHelper {

    public static VehiclesResponseDTO toVehiclesResponseDTO(final List<Vehicle> vehicleList) {
        return VehiclesResponseDTO.builder()
                .vehicleResponseDTOList(vehicleList.stream().map(VehicleHelper::toVehicleResponseDTO).collect(Collectors.toList()))
                .build();
    }

    public static VehicleResponseDTO toVehicleResponseDTO(final Vehicle vehicle) {
        return vehicle == null ? null :
                VehicleResponseDTO.builder()
                        .id(vehicle.getId())
                        .model(vehicle.getModel())
                        .brand(vehicle.getBrand().toAlias())
                        .year(vehicle.getYear())
                        .description(vehicle.getDescription())
                        .sold(vehicle.getSold())
                        .created(vehicle.getCreated())
                        .updated(vehicle.getUpdated())
                        .build();
    }
}

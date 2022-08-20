package org.example.lm.tinnova.test.exercise_5.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class VehiclesByManufacturer implements Serializable {

    @JsonProperty("veiculosFabricante")
    private List<VehicleByManufacturer> vehicleByManufacturerList;
}

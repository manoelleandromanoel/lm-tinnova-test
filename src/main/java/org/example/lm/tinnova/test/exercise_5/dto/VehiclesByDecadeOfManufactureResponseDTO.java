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
public class VehiclesByDecadeOfManufactureResponseDTO implements Serializable {

    @JsonProperty("veiculosDecadaFabricacao")
    List<VehicleByDecadeOfManufactureResponseDTO> vehiclesByDecadeOfManufactureResponseDTOList;
}

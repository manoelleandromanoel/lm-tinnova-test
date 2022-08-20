package org.example.lm.tinnova.test.exercise_5.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class PatchVehicleRequestDTO implements Serializable {

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("vendido")
    private Boolean sold;
}

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
public class VehicleRequestDTO implements Serializable {

    @JsonProperty("modelo")
    private String model;

    @JsonProperty("marca")
    private String brand;

    @JsonProperty("ano")
    private Integer year;

    @JsonProperty("descricao")
    private String description;

    @JsonProperty("vendido")
    private Boolean sold;
}

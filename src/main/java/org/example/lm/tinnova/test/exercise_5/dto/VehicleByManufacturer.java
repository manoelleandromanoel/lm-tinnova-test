package org.example.lm.tinnova.test.exercise_5.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.example.lm.tinnova.test.exercise_5.domain.Brand;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class VehicleByManufacturer implements Serializable {

    @JsonProperty("marca")
    private Brand brand;

    @JsonProperty("quantidade")
    private long amount;
}

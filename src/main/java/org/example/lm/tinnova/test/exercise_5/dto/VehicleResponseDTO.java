package org.example.lm.tinnova.test.exercise_5.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
public class VehicleResponseDTO implements Serializable {

    private Long id;

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

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("criado")
    private LocalDateTime created;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    @JsonProperty("atualizado")
    private LocalDateTime updated;
}

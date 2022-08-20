package org.example.lm.tinnova.test.exercise_5.domain;

import lombok.*;
import org.example.lm.tinnova.test.exercise_5.domain.converter.BrandConverter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_id_seq")
    @SequenceGenerator(name = "vehicle_id_seq", allocationSize = 1)
    private Long id;

    private String model;

    @Convert(converter = BrandConverter.class)
    private Brand brand;

    private Integer year;

    private String description;

    private Boolean sold;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime created;

    @LastModifiedDate
    private LocalDateTime updated;
}

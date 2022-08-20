package org.example.lm.tinnova.test.exercise_5.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum Brand {

    AUDI(1, "Audi"),
    BMW(2, "BMW"),
    BYD(3, "BYD"),
    CHERY(4, "Chery"),
    CHEVROLET(5, "Chevrolet"),
    CITROEN(6, "Citroen"),
    DODGE(7, "Dodge"),
    FERRARI(8, "Ferrari"),
    FIAT(9, "Fiat"),
    FORD(10, "Ford"),
    HONDA(11, "Honda"),
    HYUNDAI(12, "Hyundai"),
    IVECO(13, "Iveco"),
    JAC(14, "JAC"),
    JAGUAR(15, "Jaguar"),
    JEEP(16, "Jeep"),
    KIA(17, "KIA"),
    LAND_ROVER(18, "Land Rover"),
    LEXUS(19, "Lexus"),
    MERCEDES_BENZ(20, "Mercedes-Benz"),
    MINI(21, "MINI"),
    MITSUBISHI(22, "Mitsubishi"),
    NISSAN(23, "Nissan"),
    PEUGEOT(24, "Peugeot"),
    PORSCHE(25, "Porsche"),
    RAM(26, "RAM"),
    RENAULT(27, "Renault"),
    SMART(28, "SMART"),
    SUBARU(29, "Subaru"),
    SUZUKI(30, "Suzuki"),
    TESLA(31, "Tesla"),
    TOYOTA(32, "Toyota"),
    TROLLER(33, "Troller"),
    VOLKSWAGEN(34, "Volkswagen"),
    VOLVO(35, "Volvo");

    private final Integer code;
    private final String alias;

    public static Brand valueOf(final Integer code) {
        return Stream.of(values())
                .filter(brand -> code.equals(brand.getCode()))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    @JsonCreator
    public static Brand forAlias(final String alias) {
        return Arrays.stream(values())
                .filter(brand -> alias.equalsIgnoreCase(brand.getAlias()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(
                        String.format("Marca desconhecida: %s, marcas disponíveis são: %s", alias, Arrays.toString(values()))
                ));
    }

    @JsonValue
    public String toAlias() {
        return this.alias;
    }
}

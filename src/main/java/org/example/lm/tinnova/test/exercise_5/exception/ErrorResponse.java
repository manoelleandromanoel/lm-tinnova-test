package org.example.lm.tinnova.test.exercise_5.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@EqualsAndHashCode
@ToString
public class ErrorResponse implements Serializable {

    @JsonProperty("dataHora")
    private ZonedDateTime timestamp;

    @JsonProperty("erro")
    private String error;

    @JsonProperty("mensagem")
    private String message;

    @JsonProperty("detalhes")
    private Set<String> details;

    public ErrorResponse(final Exception exception) {
        this(exception.getMessage(), exception.getClass().getSimpleName());
    }

    public ErrorResponse(final String message, final String error) {
        this.message = message;
        this.error = error;
        this.timestamp = ZonedDateTime.now();
        this.details = new HashSet();
    }
}
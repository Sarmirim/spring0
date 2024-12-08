package org.example.spring0.config.exception;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HumanResponse {
    private String message;

    @JsonIgnore
    private String traceInfo;

    public HumanResponse(String message, String traceInfo) {
        this.message = message;
        this.traceInfo = traceInfo;
    }
}

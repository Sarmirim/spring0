package org.example.spring0.config.human;

import jakarta.validation.constraints.NotBlank;

public record HumanDTO(
        @NotBlank(message = "name cannot be blank") String name,
        @NotBlank(message = "email cannot be blank") String email,
        int age
) {
}

package org.example.spring0.config.human;

import lombok.Value;

/**
 * DTO for {@link Human}
 */
@Value
public class HumanResponseDto {
    String name;
    int age;
}
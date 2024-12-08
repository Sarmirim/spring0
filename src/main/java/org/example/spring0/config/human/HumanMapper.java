package org.example.spring0.config.human;

import org.springframework.stereotype.Component;

@Component
public class HumanMapper {
    public Human humanDTOtoHuman(HumanDTO humanDTO) {
        Human human = Human.builder().build();
        human.setName(humanDTO.name());
        human.setEmail(humanDTO.email());
        human.setAge(humanDTO.age());
        return human;
    }

    public HumanDTO humanToHumanDTO(Human human) {
        return new HumanDTO(human.getName(), human.getEmail(), human.getAge());
    }
}

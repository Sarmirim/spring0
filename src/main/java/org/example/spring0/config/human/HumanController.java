package org.example.spring0.config.human;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/humans")
public class HumanController {
    final private HumanService humanService;

    public HumanController(HumanService humanService) {
        this.humanService = humanService;
    }

    //    @GetMapping("${humanId}")
//    public Human getHumanById(@RequestParam("humanId") Long humanId) {
//        Optional<Human> human = humanService.getHumanById(humanId);
//        return human.orElse(null);
//    }
    @GetMapping
    @CrossOrigin
    public List<Human> getAllHumans() {
        return humanService.getAllHumans();
    }

    @PostMapping
    public void addHuman(@RequestBody HumanDTO humanDTO) {
        System.out.println(humanDTO);
        humanService.saveHuman(humanDTO);
    }
}

package org.example.spring0.config.human;

import org.example.spring0.config.exception.HumanResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HumanService {
    private final HumanRepository humanRepository;
    private final HumanMapper humanMapper;

    public HumanService(HumanRepository humanRepository, HumanMapper humanMapper) {
        this.humanRepository = humanRepository;
        this.humanMapper = humanMapper;
    }

    public List<Human> getAllHumans() {
        return humanRepository.findAll();
    }

//    public Optional<Human> getHumanById(Long id) {
//        return humanRepository.getHumanById(id);
//    }

    public void saveHuman(HumanDTO humanDTO) {
        humanRepository.save(humanMapper.humanDTOtoHuman(humanDTO));
//        return new HumanResponse("some data", "");
    }

//    public Human updateHuman(Long humanId, Human human) {
//        return humanRepository.updateHumanById(humanId, human);
//    }
    
    public void deleteHuman(Long id) {
        humanRepository.deleteById(id);
    }
}

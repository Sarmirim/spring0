package org.example.spring0.config.human;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@EnableJpaRepositories
public interface HumanRepository extends JpaRepository<Human, Long> {

//    Human updateHumanById(Long humanId, Human human);

//    Optional<Human> getHumanById(Long id);
}


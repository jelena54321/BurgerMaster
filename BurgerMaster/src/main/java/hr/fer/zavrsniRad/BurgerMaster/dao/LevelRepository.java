package hr.fer.zavrsniRad.BurgerMaster.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.fer.zavrsniRad.BurgerMaster.domain.Level;

@Repository
public interface LevelRepository extends JpaRepository<Level, Integer> {

}

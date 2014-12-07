package demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.model.CValue;

public interface CValueRepository extends JpaRepository<CValue, Long> {

}

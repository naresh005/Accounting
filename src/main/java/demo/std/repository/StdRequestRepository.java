package demo.std.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.std.model.api.StdRequestImpl;

@Repository
public interface StdRequestRepository extends JpaRepository<StdRequestImpl, Long>{

}

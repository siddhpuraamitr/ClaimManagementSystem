package claim.management.system.crudrestfulwebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import claim.management.system.crudrestfulwebservice.model.Claim;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Long> {

}

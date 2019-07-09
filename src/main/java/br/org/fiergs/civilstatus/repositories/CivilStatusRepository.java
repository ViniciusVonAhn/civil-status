package br.org.fiergs.civilstatus.repositories;

import br.org.fiergs.civilstatus.entities.CivilStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CivilStatusRepository extends JpaRepository<CivilStatus, Long> {

    Optional<CivilStatus> findByNameContainingIgnoreCase(String name);

    Optional<CivilStatus> findByNameContainingIgnoreCaseAndIdIsNot(String name, Long id);
}

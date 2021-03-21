package sn.isi.m2gl.repository;

import sn.isi.m2gl.domain.SituationCovid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SituationCovid entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SituationCovidRepository extends JpaRepository<SituationCovid, Long> {

    @Query("select c  from SituationCovid c where c.id=:id")
    SituationCovid getCovidInfoById(Long id);
}

package sn.isi.m2gl.repository;

import sn.isi.m2gl.domain.SituationCovid;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SituationCovid entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SituationCovidRepository extends JpaRepository<SituationCovid, Long> {
}

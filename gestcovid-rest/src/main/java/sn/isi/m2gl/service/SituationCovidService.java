package sn.isi.m2gl.service;

import sn.isi.m2gl.domain.SituationCovid;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing {@link SituationCovid}.
 */
public interface SituationCovidService {

    /**
     * Save a situationCovid.
     *
     * @param situationCovid the entity to save.
     * @return the persisted entity.
     */
    SituationCovid save(SituationCovid situationCovid);

    /**
     * Get all the situationCovids.
     *
     * @return the list of entities.
     */
    List<SituationCovid> findAll();


    /**
     * Get the "id" situationCovid.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<SituationCovid> findOne(Long id);

    /**
     * Delete the "id" situationCovid.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}

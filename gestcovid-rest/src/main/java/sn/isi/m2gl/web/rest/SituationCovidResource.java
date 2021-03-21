package sn.isi.m2gl.web.rest;

import sn.isi.m2gl.domain.SituationCovid;
import sn.isi.m2gl.service.SituationCovidService;
import sn.isi.m2gl.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link sn.isi.m2gl.domain.SituationCovid}.
 */
@RestController
@RequestMapping("/api")
public class SituationCovidResource {

    private final Logger log = LoggerFactory.getLogger(SituationCovidResource.class);

    private static final String ENTITY_NAME = "appRestSituationCovid";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final SituationCovidService situationCovidService;

    public SituationCovidResource(SituationCovidService situationCovidService) {
        this.situationCovidService = situationCovidService;
    }

    /**
     * {@code POST  /situation-covids} : Create a new situationCovid.
     *
     * @param situationCovid the situationCovid to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new situationCovid, or with status {@code 400 (Bad Request)} if the situationCovid has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/situation-covids")
    public ResponseEntity<SituationCovid> createSituationCovid(@RequestBody SituationCovid situationCovid) throws URISyntaxException {
        log.debug("REST request to save SituationCovid : {}", situationCovid);
        if (situationCovid.getId() != null) {
            throw new BadRequestAlertException("A new situationCovid cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SituationCovid result = situationCovidService.save(situationCovid);
        return ResponseEntity.created(new URI("/api/situation-covids/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /situation-covids} : Updates an existing situationCovid.
     *
     * @param situationCovid the situationCovid to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated situationCovid,
     * or with status {@code 400 (Bad Request)} if the situationCovid is not valid,
     * or with status {@code 500 (Internal Server Error)} if the situationCovid couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/situation-covids")
    public ResponseEntity<SituationCovid> updateSituationCovid(@RequestBody SituationCovid situationCovid) throws URISyntaxException {
        log.debug("REST request to update SituationCovid : {}", situationCovid);
        if (situationCovid.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        SituationCovid result = situationCovidService.save(situationCovid);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, situationCovid.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /situation-covids} : get all the situationCovids.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of situationCovids in body.
     */
    @GetMapping("/situation-covids")
    public List<SituationCovid> getAllSituationCovids() {
        log.debug("REST request to get all SituationCovids");
        return situationCovidService.findAll();
    }

    /**
     * {@code GET  /situation-covids/:id} : get the "id" situationCovid.
     *
     * @param id the id of the situationCovid to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the situationCovid, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/situation-covids/{id}")
    public ResponseEntity<SituationCovid> getSituationCovid(@PathVariable Long id) {
        log.debug("REST request to get SituationCovid : {}", id);
        Optional<SituationCovid> situationCovid = situationCovidService.findOne(id);
        return ResponseUtil.wrapOrNotFound(situationCovid);
    }

    /**
     * {@code DELETE  /situation-covids/:id} : delete the "id" situationCovid.
     *
     * @param id the id of the situationCovid to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/situation-covids/{id}")
    public ResponseEntity<Void> deleteSituationCovid(@PathVariable Long id) {
        log.debug("REST request to delete SituationCovid : {}", id);
        situationCovidService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}

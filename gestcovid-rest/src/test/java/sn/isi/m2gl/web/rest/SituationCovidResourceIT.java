package sn.isi.m2gl.web.rest;

import sn.isi.m2gl.AppRestApp;
import sn.isi.m2gl.config.TestSecurityConfiguration;
import sn.isi.m2gl.domain.SituationCovid;
import sn.isi.m2gl.repository.SituationCovidRepository;
import sn.isi.m2gl.service.SituationCovidService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link SituationCovidResource} REST controller.
 */
@SpringBootTest(classes = { AppRestApp.class, TestSecurityConfiguration.class })
@AutoConfigureMockMvc
@WithMockUser
public class SituationCovidResourceIT {

    private static final Integer DEFAULT_NBRE_CAS = 1;
    private static final Integer UPDATED_NBRE_CAS = 2;

    private static final Integer DEFAULT_NBRE_CAS_POSITIF = 1;
    private static final Integer UPDATED_NBRE_CAS_POSITIF = 2;

    private static final Integer DEFAULT_NBRE_CAS_NEGATIF = 1;
    private static final Integer UPDATED_NBRE_CAS_NEGATIF = 2;

    private static final Integer DEFAULT_NBRE_DECES = 1;
    private static final Integer UPDATED_NBRE_DECES = 2;

    private static final Integer DEFAULT_NBRE_GUERIS = 1;
    private static final Integer UPDATED_NBRE_GUERIS = 2;

    private static final LocalDate DEFAULT_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private SituationCovidRepository situationCovidRepository;

    @Autowired
    private SituationCovidService situationCovidService;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restSituationCovidMockMvc;

    private SituationCovid situationCovid;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SituationCovid createEntity(EntityManager em) {
        SituationCovid situationCovid = new SituationCovid()
            .nbreCas(DEFAULT_NBRE_CAS)
            .nbreCasPositif(DEFAULT_NBRE_CAS_POSITIF)
            .nbreCasNegatif(DEFAULT_NBRE_CAS_NEGATIF)
            .nbreDeces(DEFAULT_NBRE_DECES)
            .nbreGueris(DEFAULT_NBRE_GUERIS)
            .date(DEFAULT_DATE);
        return situationCovid;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static SituationCovid createUpdatedEntity(EntityManager em) {
        SituationCovid situationCovid = new SituationCovid()
            .nbreCas(UPDATED_NBRE_CAS)
            .nbreCasPositif(UPDATED_NBRE_CAS_POSITIF)
            .nbreCasNegatif(UPDATED_NBRE_CAS_NEGATIF)
            .nbreDeces(UPDATED_NBRE_DECES)
            .nbreGueris(UPDATED_NBRE_GUERIS)
            .date(UPDATED_DATE);
        return situationCovid;
    }

    @BeforeEach
    public void initTest() {
        situationCovid = createEntity(em);
    }

    @Test
    @Transactional
    public void createSituationCovid() throws Exception {
        int databaseSizeBeforeCreate = situationCovidRepository.findAll().size();
        // Create the SituationCovid
        restSituationCovidMockMvc.perform(post("/api/situation-covids").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(situationCovid)))
            .andExpect(status().isCreated());

        // Validate the SituationCovid in the database
        List<SituationCovid> situationCovidList = situationCovidRepository.findAll();
        assertThat(situationCovidList).hasSize(databaseSizeBeforeCreate + 1);
        SituationCovid testSituationCovid = situationCovidList.get(situationCovidList.size() - 1);
        assertThat(testSituationCovid.getNbreCas()).isEqualTo(DEFAULT_NBRE_CAS);
        assertThat(testSituationCovid.getNbreCasPositif()).isEqualTo(DEFAULT_NBRE_CAS_POSITIF);
        assertThat(testSituationCovid.getNbreCasNegatif()).isEqualTo(DEFAULT_NBRE_CAS_NEGATIF);
        assertThat(testSituationCovid.getNbreDeces()).isEqualTo(DEFAULT_NBRE_DECES);
        assertThat(testSituationCovid.getNbreGueris()).isEqualTo(DEFAULT_NBRE_GUERIS);
        assertThat(testSituationCovid.getDate()).isEqualTo(DEFAULT_DATE);
    }

    @Test
    @Transactional
    public void createSituationCovidWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = situationCovidRepository.findAll().size();

        // Create the SituationCovid with an existing ID
        situationCovid.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restSituationCovidMockMvc.perform(post("/api/situation-covids").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(situationCovid)))
            .andExpect(status().isBadRequest());

        // Validate the SituationCovid in the database
        List<SituationCovid> situationCovidList = situationCovidRepository.findAll();
        assertThat(situationCovidList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllSituationCovids() throws Exception {
        // Initialize the database
        situationCovidRepository.saveAndFlush(situationCovid);

        // Get all the situationCovidList
        restSituationCovidMockMvc.perform(get("/api/situation-covids?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(situationCovid.getId().intValue())))
            .andExpect(jsonPath("$.[*].nbreCas").value(hasItem(DEFAULT_NBRE_CAS)))
            .andExpect(jsonPath("$.[*].nbreCasPositif").value(hasItem(DEFAULT_NBRE_CAS_POSITIF)))
            .andExpect(jsonPath("$.[*].nbreCasNegatif").value(hasItem(DEFAULT_NBRE_CAS_NEGATIF)))
            .andExpect(jsonPath("$.[*].nbreDeces").value(hasItem(DEFAULT_NBRE_DECES)))
            .andExpect(jsonPath("$.[*].nbreGueris").value(hasItem(DEFAULT_NBRE_GUERIS)))
            .andExpect(jsonPath("$.[*].date").value(hasItem(DEFAULT_DATE.toString())));
    }
    
    @Test
    @Transactional
    public void getSituationCovid() throws Exception {
        // Initialize the database
        situationCovidRepository.saveAndFlush(situationCovid);

        // Get the situationCovid
        restSituationCovidMockMvc.perform(get("/api/situation-covids/{id}", situationCovid.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(situationCovid.getId().intValue()))
            .andExpect(jsonPath("$.nbreCas").value(DEFAULT_NBRE_CAS))
            .andExpect(jsonPath("$.nbreCasPositif").value(DEFAULT_NBRE_CAS_POSITIF))
            .andExpect(jsonPath("$.nbreCasNegatif").value(DEFAULT_NBRE_CAS_NEGATIF))
            .andExpect(jsonPath("$.nbreDeces").value(DEFAULT_NBRE_DECES))
            .andExpect(jsonPath("$.nbreGueris").value(DEFAULT_NBRE_GUERIS))
            .andExpect(jsonPath("$.date").value(DEFAULT_DATE.toString()));
    }
    @Test
    @Transactional
    public void getNonExistingSituationCovid() throws Exception {
        // Get the situationCovid
        restSituationCovidMockMvc.perform(get("/api/situation-covids/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateSituationCovid() throws Exception {
        // Initialize the database
        situationCovidService.save(situationCovid);

        int databaseSizeBeforeUpdate = situationCovidRepository.findAll().size();

        // Update the situationCovid
        SituationCovid updatedSituationCovid = situationCovidRepository.findById(situationCovid.getId()).get();
        // Disconnect from session so that the updates on updatedSituationCovid are not directly saved in db
        em.detach(updatedSituationCovid);
        updatedSituationCovid
            .nbreCas(UPDATED_NBRE_CAS)
            .nbreCasPositif(UPDATED_NBRE_CAS_POSITIF)
            .nbreCasNegatif(UPDATED_NBRE_CAS_NEGATIF)
            .nbreDeces(UPDATED_NBRE_DECES)
            .nbreGueris(UPDATED_NBRE_GUERIS)
            .date(UPDATED_DATE);

        restSituationCovidMockMvc.perform(put("/api/situation-covids").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedSituationCovid)))
            .andExpect(status().isOk());

        // Validate the SituationCovid in the database
        List<SituationCovid> situationCovidList = situationCovidRepository.findAll();
        assertThat(situationCovidList).hasSize(databaseSizeBeforeUpdate);
        SituationCovid testSituationCovid = situationCovidList.get(situationCovidList.size() - 1);
        assertThat(testSituationCovid.getNbreCas()).isEqualTo(UPDATED_NBRE_CAS);
        assertThat(testSituationCovid.getNbreCasPositif()).isEqualTo(UPDATED_NBRE_CAS_POSITIF);
        assertThat(testSituationCovid.getNbreCasNegatif()).isEqualTo(UPDATED_NBRE_CAS_NEGATIF);
        assertThat(testSituationCovid.getNbreDeces()).isEqualTo(UPDATED_NBRE_DECES);
        assertThat(testSituationCovid.getNbreGueris()).isEqualTo(UPDATED_NBRE_GUERIS);
        assertThat(testSituationCovid.getDate()).isEqualTo(UPDATED_DATE);
    }

    @Test
    @Transactional
    public void updateNonExistingSituationCovid() throws Exception {
        int databaseSizeBeforeUpdate = situationCovidRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restSituationCovidMockMvc.perform(put("/api/situation-covids").with(csrf())
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(situationCovid)))
            .andExpect(status().isBadRequest());

        // Validate the SituationCovid in the database
        List<SituationCovid> situationCovidList = situationCovidRepository.findAll();
        assertThat(situationCovidList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteSituationCovid() throws Exception {
        // Initialize the database
        situationCovidService.save(situationCovid);

        int databaseSizeBeforeDelete = situationCovidRepository.findAll().size();

        // Delete the situationCovid
        restSituationCovidMockMvc.perform(delete("/api/situation-covids/{id}", situationCovid.getId()).with(csrf())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<SituationCovid> situationCovidList = situationCovidRepository.findAll();
        assertThat(situationCovidList).hasSize(databaseSizeBeforeDelete - 1);
    }
}

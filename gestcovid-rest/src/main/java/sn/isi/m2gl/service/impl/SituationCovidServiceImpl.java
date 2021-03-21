package sn.isi.m2gl.service.impl;

import sn.isi.m2gl.service.SituationCovidService;
import sn.isi.m2gl.domain.SituationCovid;
import sn.isi.m2gl.repository.SituationCovidRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link SituationCovid}.
 */
@Service
@Transactional
public class SituationCovidServiceImpl implements SituationCovidService {

    private final Logger log = LoggerFactory.getLogger(SituationCovidServiceImpl.class);

    private final SituationCovidRepository situationCovidRepository;

    public SituationCovidServiceImpl(SituationCovidRepository situationCovidRepository) {
        this.situationCovidRepository = situationCovidRepository;
    }

    @Override
    public SituationCovid save(SituationCovid situationCovid) {
        log.debug("Request to save SituationCovid : {}", situationCovid);
        return situationCovidRepository.save(situationCovid);
    }

    @Override
    @Transactional(readOnly = true)
    public List<SituationCovid> findAll() {
        log.debug("Request to get all SituationCovids");
        return situationCovidRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<SituationCovid> findOne(Long id) {
        log.debug("Request to get SituationCovid : {}", id);
        return situationCovidRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete SituationCovid : {}", id);
        situationCovidRepository.deleteById(id);
    }
}

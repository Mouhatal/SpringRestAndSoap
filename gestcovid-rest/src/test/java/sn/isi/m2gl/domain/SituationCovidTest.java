package sn.isi.m2gl.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import sn.isi.m2gl.web.rest.TestUtil;

public class SituationCovidTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(SituationCovid.class);
        SituationCovid situationCovid1 = new SituationCovid();
        situationCovid1.setId(1L);
        SituationCovid situationCovid2 = new SituationCovid();
        situationCovid2.setId(situationCovid1.getId());
        assertThat(situationCovid1).isEqualTo(situationCovid2);
        situationCovid2.setId(2L);
        assertThat(situationCovid1).isNotEqualTo(situationCovid2);
        situationCovid1.setId(null);
        assertThat(situationCovid1).isNotEqualTo(situationCovid2);
    }
}

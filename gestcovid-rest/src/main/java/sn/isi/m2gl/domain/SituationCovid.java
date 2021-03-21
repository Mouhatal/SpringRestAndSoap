package sn.isi.m2gl.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A SituationCovid.
 */
@Entity
@Table(name = "situation_covid")
public class SituationCovid implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nbre_cas")
    private Integer nbreCas;

    @Column(name = "nbre_cas_positif")
    private Integer nbreCasPositif;

    @Column(name = "nbre_cas_negatif")
    private Integer nbreCasNegatif;

    @Column(name = "nbre_deces")
    private Integer nbreDeces;

    @Column(name = "nbre_gueris")
    private Integer nbreGueris;

    @Column(name = "date")
    private LocalDate date;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNbreCas() {
        return nbreCas;
    }

    public SituationCovid nbreCas(Integer nbreCas) {
        this.nbreCas = nbreCas;
        return this;
    }

    public void setNbreCas(Integer nbreCas) {
        this.nbreCas = nbreCas;
    }

    public Integer getNbreCasPositif() {
        return nbreCasPositif;
    }

    public SituationCovid nbreCasPositif(Integer nbreCasPositif) {
        this.nbreCasPositif = nbreCasPositif;
        return this;
    }

    public void setNbreCasPositif(Integer nbreCasPositif) {
        this.nbreCasPositif = nbreCasPositif;
    }

    public Integer getNbreCasNegatif() {
        return nbreCasNegatif;
    }

    public SituationCovid nbreCasNegatif(Integer nbreCasNegatif) {
        this.nbreCasNegatif = nbreCasNegatif;
        return this;
    }

    public void setNbreCasNegatif(Integer nbreCasNegatif) {
        this.nbreCasNegatif = nbreCasNegatif;
    }

    public Integer getNbreDeces() {
        return nbreDeces;
    }

    public SituationCovid nbreDeces(Integer nbreDeces) {
        this.nbreDeces = nbreDeces;
        return this;
    }

    public void setNbreDeces(Integer nbreDeces) {
        this.nbreDeces = nbreDeces;
    }

    public Integer getNbreGueris() {
        return nbreGueris;
    }

    public SituationCovid nbreGueris(Integer nbreGueris) {
        this.nbreGueris = nbreGueris;
        return this;
    }

    public void setNbreGueris(Integer nbreGueris) {
        this.nbreGueris = nbreGueris;
    }

    public LocalDate getDate() {
        return date;
    }

    public SituationCovid date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SituationCovid)) {
            return false;
        }
        return id != null && id.equals(((SituationCovid) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SituationCovid{" +
            "id=" + getId() +
            ", nbreCas=" + getNbreCas() +
            ", nbreCasPositif=" + getNbreCasPositif() +
            ", nbreCasNegatif=" + getNbreCasNegatif() +
            ", nbreDeces=" + getNbreDeces() +
            ", nbreGueris=" + getNbreGueris() +
            ", date='" + getDate() + "'" +
            "}";
    }
}

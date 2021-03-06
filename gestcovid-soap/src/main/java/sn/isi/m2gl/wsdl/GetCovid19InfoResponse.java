//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.0.5-b02-fcs
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2021.02.17 at 11:50:24 PM UTC
//


package sn.isi.m2gl.wsdl;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nbreCas" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="nbreCasPositif" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="nbreCasNegatif" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="nbreDeces" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="rnbreGueris" type="{http://www.w3.org/2001/XMLSchema}integer"/>
 *         &lt;element name="datejoure" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "nbreCas",
    "nbreCasPositif",
    "nbreCasNegatif",
    "nbreDeces",
    "rnbreGueris",
    "datejoure"
})
@XmlRootElement(name = "getCovid19InfoResponse")
public class GetCovid19InfoResponse {

    @XmlElement(required = true)
    protected Integer nbreCas;
    @XmlElement(required = true)
    protected Integer nbreCasPositif;
    @XmlElement(required = true)
    protected Integer nbreCasNegatif;
    @XmlElement(required = true)
    protected Integer nbreDeces;
    @XmlElement(required = true)
    protected Integer rnbreGueris;
    @XmlElement(required = true)
    protected XMLGregorianCalendar datejoure;

    /**
     * Gets the value of the nbreCas property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public Integer getNbreCas() {
        return nbreCas;
    }

    /**
     * Sets the value of the nbreCas property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setNbreCas(Integer value) {
        this.nbreCas = value;
    }

    /**
     * Gets the value of the nbreCasPositif property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public Integer getNbreCasPositif() {
        return nbreCasPositif;
    }

    /**
     * Sets the value of the nbreCasPositif property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setNbreCasPositif(Integer value) {
        this.nbreCasPositif = value;
    }

    /**
     * Gets the value of the nbreCasNegatif property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public Integer getNbreCasNegatif() {
        return nbreCasNegatif;
    }

    /**
     * Sets the value of the nbreCasNegatif property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setNbreCasNegatif(Integer value) {
        this.nbreCasNegatif = value;
    }

    /**
     * Gets the value of the nbreDeces property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public Integer getNbreDeces() {
        return nbreDeces;
    }

    /**
     * Sets the value of the nbreDeces property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setNbreDeces(Integer value) {
        this.nbreDeces = value;
    }

    /**
     * Gets the value of the rnbreGueris property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public Integer getRnbreGueris() {
        return rnbreGueris;
    }

    /**
     * Sets the value of the rnbreGueris property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setRnbreGueris(Integer value) {
        this.rnbreGueris = value;
    }

    /**
     * Gets the value of the datejoure property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDatejoure() {
        return datejoure;
    }

    /**
     * Sets the value of the datejoure property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDatejoure(XMLGregorianCalendar value) {
        this.datejoure = value;
    }

}

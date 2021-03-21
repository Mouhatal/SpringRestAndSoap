package sn.isi.m2gl.web.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import sn.isi.m2gl.domain.SituationCovid;
import sn.isi.m2gl.repository.SituationCovidRepository;
import sn.isi.m2gl.wsdl.GetCovid19InfoRequest;
import sn.isi.m2gl.wsdl.GetCovid19InfoResponse;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.GregorianCalendar;
import java.util.Optional;

@Endpoint
public class SituationCovidEndpoint {

    @Autowired
    SituationCovidRepository situationCovidRepository;

    DatatypeFactory datatypeFactory;

    {
        try {
            datatypeFactory = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
    }

    GregorianCalendar calendarExpected = new GregorianCalendar(2018, 6, 28);
    XMLGregorianCalendar expectedXMLGregorianCalendar = datatypeFactory
        .newXMLGregorianCalendar(calendarExpected);

    LocalDate localDate = LocalDate.of(2019, 4, 25);

    XMLGregorianCalendar xmlGregorianCalendar =
        datatypeFactory.newXMLGregorianCalendar(localDate.toString());




    @PayloadRoot(namespace = "http://ws.groupeisi.com",localPart = "getCovid19InfoRequest")
    public @ResponsePayload
    GetCovid19InfoResponse getCovid19InfoRequest (@RequestPayload GetCovid19InfoRequest request) throws DatatypeConfigurationException {
        GetCovid19InfoResponse covidresponse= new GetCovid19InfoResponse();
        long bb = Long.parseLong(request.getInput());
        System.out.println("Input");
        System.out.println(bb);
        //Sencovid sencovid = sencovidRepository.getCovidInfoById((long)11);
        Optional<SituationCovid> sencovid = situationCovidRepository.findById(bb);
        XMLGregorianCalendar dateFormat =
            datatypeFactory.newXMLGregorianCalendar(sencovid.get().getDate().toString());
        covidresponse.setNbreCas(sencovid.get().getNbreCas());
        covidresponse.setNbreCasPositif(sencovid.get().getNbreCasPositif());
        covidresponse.setNbreCasNegatif(sencovid.get().getNbreCasNegatif());
        covidresponse.setNbreDeces(sencovid.get().getNbreDeces());
        covidresponse.setRnbreGueris(sencovid.get().getNbreGueris());
        covidresponse.setDatejoure(dateFormat);
        return covidresponse;
    }

}

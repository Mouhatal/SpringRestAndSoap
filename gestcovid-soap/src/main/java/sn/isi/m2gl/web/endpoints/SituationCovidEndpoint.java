package sn.isi.m2gl.web.endpoints;

import sn.isi.m2gl.domain.SituationCovid;
import sn.isi.m2gl.repository.SituationCovidRepository;
import sn.isi.m2gl.wsdl.GetCovid19InfoRequest;
import sn.isi.m2gl.wsdl.GetCovid19InfoResponse;
import sn.isi.m2gl.wsdl.GetInfoRequest;
import sn.isi.m2gl.wsdl.GetInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;


import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.util.GregorianCalendar;

@Endpoint
public class SituationCovidEndpoint {

    @Autowired
    SituationCovidRepository situationCovidRepository;
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8081/api/situation-covids";
    String accessToken = "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJRRzAtQXlTT3BrMmRMUUIyYnpqbTJCd29OUTJ1eDh5aURLODFBTDdDVzI0In0.eyJleHAiOjE2MTYyMzM0NDYsImlhdCI6MTYxNjIzMzE0NiwianRpIjoiYzg4MDY0YzItNTQ3YS00NzQxLWEyNzktYmM2N2QzYzMzODBiIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo5MDgwL2F1dGgvcmVhbG1zL2poaXBzdGVyIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjRjOTczODk2LTU3NjEtNDFmYy04MjE3LTA3YzVkMTNhMDA0YiIsInR5cCI6IkJlYXJlciIsImF6cCI6ImpoaXBzdGVyLXJlZ2lzdHJ5Iiwic2Vzc2lvbl9zdGF0ZSI6ImZhYTdiMWU1LWZjYmItNDI1Yi04YzZhLWY3OWIwM2IxN2IwZSIsImFjciI6IjEiLCJhbGxvd2VkLW9yaWdpbnMiOlsiaHR0cDovLzEyNy4wLjAuMTo4NzYxIiwiaHR0cDovL2xvY2FsaG9zdDo4NzYxIl0sInJlYWxtX2FjY2VzcyI6eyJyb2xlcyI6WyJST0xFX1VTRVIiLCJvZmZsaW5lX2FjY2VzcyIsIlJPTEVfQURNSU4iLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7ImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoib3BlbmlkIGpoaXBzdGVyIGVtYWlsIHByb2ZpbGUiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicm9sZXMiOlsiUk9MRV9VU0VSIiwib2ZmbGluZV9hY2Nlc3MiLCJST0xFX0FETUlOIiwidW1hX2F1dGhvcml6YXRpb24iXSwibmFtZSI6IkFkbWluIEFkbWluaXN0cmF0b3IiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJhZG1pbiIsImdpdmVuX25hbWUiOiJBZG1pbiIsImZhbWlseV9uYW1lIjoiQWRtaW5pc3RyYXRvciIsImVtYWlsIjoiYWRtaW5AbG9jYWxob3N0In0.WTc7_5dJp32JjCBT4XrFaw8Imc-n_WAEBTW78Z5fbUg6Qvl7mUlhD1lWXQyhAgMsvVNCwlbeN1BmpUEZRP5ca6dny1nE5AQ3HMIEMeE-xzXV_bTqA0RbG7ulKBcF5_CNmZ7Q3YgoiJMQmnHIbv-hy07imd4x_9pXdK05-IWrLJyee3NMSaH_tVYxHjbagXM0ScAkrx7LeiFLaZ_CLnw83DszSK8Ejt2ZXdunx3H5L_SLjep1fgZzHZl42mZnShY8Hv4mwxB7lvjE8HU18BkDdAMIKX3WXl7xZTfJttwH835ddQWPN4SMjO0JhRbBsenn0SUMO6nLNzznK-epwjuLPQ";
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


    @PayloadRoot(namespace = "http://ws.groupeisi.com",localPart = "getInfoRequest")
    public @ResponsePayload
    GetInfoResponse getInfoRequest (@RequestPayload GetInfoRequest request) {
        GetInfoResponse response= new GetInfoResponse();
        response.setOutput("Bonjour M2GL "+ request.getInput());
        return response;
    }

    @PayloadRoot(namespace = "http://ws.groupeisi.com",localPart = "getCovid19InfoRequest")
    public @ResponsePayload
    GetCovid19InfoResponse getCovid19InfoRequest (@RequestPayload GetCovid19InfoRequest request) throws DatatypeConfigurationException {
        GetCovid19InfoResponse covidresponse= new GetCovid19InfoResponse();
        long bb = Long.parseLong(request.getInput());
        System.out.println("Input");
        System.out.println(bb);
        //SituationCovid sencovid = sencovidRepository.getCovidInfoById((long)11);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer "+accessToken);
        HttpEntity<SituationCovid[]> entity = new HttpEntity<SituationCovid[]>(headers);

        ResponseEntity<SituationCovid[]> response = restTemplate.exchange(url, //
            HttpMethod.GET, entity, SituationCovid[].class);

        HttpStatus statusCode = response.getStatusCode();
        System.out.println("Response Satus Code: " + statusCode);

        // Status Code: 200
        if (statusCode == HttpStatus.OK) {
            // Response Body Data
            SituationCovid[] list = response.getBody();

            if (list != null) {
                for (SituationCovid e : list) {
                    System.out.println("Covid: " + e.getNbreCas() + " - " + e.getNbreGueris());
                    XMLGregorianCalendar dateFormat =
                        datatypeFactory.newXMLGregorianCalendar(e.getDate().toString());
                    covidresponse.setNbreCas(e.getNbreCas());
                    covidresponse.setNbreCasPositif(e.getNbreCasPositif());
                    covidresponse.setNbreCasNegatif(e.getNbreCasNegatif());
                    covidresponse.setNbreDeces(e.getNbreDeces());
                    covidresponse.setRnbreGueris(e.getNbreGueris());
                    covidresponse.setDatejoure(dateFormat);
                }
            }
        }

        return covidresponse;
    }

    /*public Date StringToDate(String s){

        Date result = null;
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            result  = dateFormat.parse(s);
        }

        catch(ParseException e){
            e.printStackTrace();

        }
        return result ;
    }*/
}



## Spring Rest AND Soap

# Technonologie/Framework
* Jhipster
* Keycloack
* Jhipster-registry

# Obtain token
* Post : http://localhost:9080/auth/realms/jhipster/protocol/openid-connect/token

* Body :
 - client_id:jhipster-registry
 - grant_type:password
 - client_secret:jhipster-registry
 - scope:openid
 - username:admin
 - password:admin

After post copy value of access_token and past the value in
../gestcovid-soap/src/main/java/sn/isi/m2gl/web/endpoints/SituationCovidEndpoint.java line 31 String acces_token

# URI
* Rest: http://localhost:8081/api/situation-covids
* Soap: http://localhost:8082/ws/covid19infos.wsdl ====> for obtain envelope
        http://localhost:8082/ws/

# Team

* Mouhamadou TALL
* Mouhamadou Makhtar CISSE
* Aboubakar KABA
* Nouhoum TAMBOURA
* Adama GASSAMA
* Nappal Ousmane ADDA

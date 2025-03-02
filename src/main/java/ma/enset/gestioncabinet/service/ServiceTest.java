package ma.enset.gestioncabinet.service;

import ma.enset.gestioncabinet.Dao.ConsultationDao;
import ma.enset.gestioncabinet.Dao.PatientDao;
import ma.enset.gestioncabinet.entities.Consultation;
import ma.enset.gestioncabinet.entities.Patient;

import java.util.List;

public class ServiceTest {

    public static void main(String[] args) {
        ICabinetService service = new CabinetService(new PatientDao(),new ConsultationDao());
      /*  Patient patient = new Patient();
        patient.setNom("nassar");
        patient.setPrenom("esraa");
        patient.setTel("06791221122");
        service.addPatient(patient);
        List<Patient> patients =service.getPatients();
        patients.forEach(patient-> System.out.println(patient));*/
        Patient patient = service.getPatient(1L);
        //System.out.println(patient);
        patient.setTel("1234567890");
        service.updatePatient(patient);



    }
}

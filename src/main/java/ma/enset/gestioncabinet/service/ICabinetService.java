package ma.enset.gestioncabinet.service;

import ma.enset.gestioncabinet.entities.Consultation;
import ma.enset.gestioncabinet.entities.Patient;

import java.util.List;

public interface ICabinetService {

    void  addPatient(Patient patient);
    void updatePatient(Patient patient);
    void deletePatient(Patient patient);
    List<Patient> getPatients();
    Patient getPatient(Long id);
    List<Patient> SearchPatientbyQuery(String query);
    void AddConsultation(Consultation consultation);
    void deleteConsultation(Consultation consultation);
    void updateConsultation(Consultation consultation);
    List<Consultation> getConsultations();
    Consultation getConsultation(Long id);


}

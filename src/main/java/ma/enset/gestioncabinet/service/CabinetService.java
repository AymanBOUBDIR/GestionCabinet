package ma.enset.gestioncabinet.service;

import ma.enset.gestioncabinet.Dao.ConsultationDao;
import ma.enset.gestioncabinet.Dao.IConsultationDao;
import ma.enset.gestioncabinet.Dao.IPatientDao;
import ma.enset.gestioncabinet.Dao.PatientDao;
import ma.enset.gestioncabinet.entities.Consultation;
import ma.enset.gestioncabinet.entities.Patient;

import java.sql.SQLException;
import java.util.List;

public class CabinetService implements ICabinetService {
    private IPatientDao patientDao;
    private IConsultationDao consultationDao;

    public CabinetService( IPatientDao patientDao, IConsultationDao consultationDao) {
        this.patientDao = new PatientDao();
        this.consultationDao = new ConsultationDao();
    }

    @Override

    public void addPatient(Patient patient) {
        try {
            patientDao.create(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updatePatient(Patient patient) {

        try {
            patientDao.update(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deletePatient(Patient patient) {

        try {
            patientDao.delete(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Patient> getPatients() {
        List<Patient> patients ;
        try {
           patients= patientDao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patients;
    }

    @Override
    public Patient getPatient(Long id) {
        Patient patient ;
        try {
            patient=patientDao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return patient;
    }

    @Override
    public List<Patient> SearchPatientbyQuery(String query) {
       return patientDao.StringQuery(query);
    }

    @Override
    public void AddConsultation(Consultation consultation) {
        try {
            consultationDao.create(consultation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void deleteConsultation(Consultation consultation) {
        try {
            consultationDao.delete(consultation);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void updateConsultation(Consultation consultation) {

    }

    @Override
    public List<Consultation> getConsultations() {
        List<Consultation> consultations ;
        try {
            consultations= consultationDao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return consultations;
    }

    @Override
    public Consultation getConsultation(Long id) {
        Consultation consultation ;
        try {
            consultation=consultationDao.findById(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return consultation;
    }
}

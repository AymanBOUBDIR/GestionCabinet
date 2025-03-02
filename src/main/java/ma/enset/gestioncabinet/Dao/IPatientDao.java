package ma.enset.gestioncabinet.Dao;

import ma.enset.gestioncabinet.entities.Patient;

import java.util.List;

public interface IPatientDao extends Dao<Patient, Long> {

    List<Patient> StringQuery(String query);

}

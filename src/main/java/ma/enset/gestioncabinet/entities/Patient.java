package ma.enset.gestioncabinet.entities;

import java.util.List;

public class Patient {
    private  long id;
    private String  Nom;
    private String  Prenom;
    private String  tel;

    public List<ma.enset.gestioncabinet.entities.Consultation> getConsultation() {
        return Consultation;
    }

    public void setConsultation(List<ma.enset.gestioncabinet.entities.Consultation> consultation) {
        Consultation = consultation;
    }

    public void setId(long id) {
        this.id = id;
    }

    private List<Consultation>  Consultation;

    public String getPrenom() {
        return Prenom;
    }

    public String getTel() {
        return tel;
    }

    public String getNom() {
        return Nom;
    }

    public long getId() {
        return id;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
    public Patient(){
    }

    public Patient( String nom, String prenom, String tel) {
        Nom = nom;
        Prenom = prenom;
        this.tel = tel;
    }

    @Override
    public String toString() {
        return  Nom +" "+  Prenom ;

    }
}

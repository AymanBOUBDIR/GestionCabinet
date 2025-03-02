package ma.enset.gestioncabinet.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.gestioncabinet.Dao.ConsultationDao;
import ma.enset.gestioncabinet.Dao.PatientDao;
import ma.enset.gestioncabinet.entities.Consultation;
import ma.enset.gestioncabinet.entities.Patient;
import ma.enset.gestioncabinet.service.CabinetService;
import ma.enset.gestioncabinet.service.ICabinetService;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class ConsultationController implements Initializable {

    @FXML private TableColumn columnID;
    @FXML private TableColumn columnDateConsultation;
    @FXML private TableColumn columnDescription;
    @FXML private TableColumn columnPatient;
    @FXML  private TableView<Consultation> tableConsultation;

    private ICabinetService cabinetService;
    private ObservableList<Patient> patients= FXCollections.observableArrayList();
    private ObservableList<Consultation> consultations= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cabinetService=new CabinetService(new PatientDao(),new ConsultationDao());
        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnDateConsultation.setCellValueFactory(new PropertyValueFactory<>("dateConsultation"));
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));
        columnPatient.setCellValueFactory(new PropertyValueFactory<>("patient"));
        comboPatient.setItems(patients);
        patients.setAll(cabinetService.getPatients());
        LoadConsultations();
        tableConsultation.setItems(consultations);


    }

    @FXML private DatePicker dateConsultation;
    @FXML private  Button addConsultation;
    @FXML private  Button delConsultation;
    @FXML private ComboBox<Patient> comboPatient;
    @FXML private TextArea textfieldDescription;

    public void addconsultation(){
    Consultation consultation=new Consultation();
    consultation.setPatient(comboPatient.getSelectionModel().getSelectedItem());
    consultation.setDateConsultation(Date.valueOf(dateConsultation.getValue()));
    consultation.setDescription(textfieldDescription.getText());
    cabinetService.AddConsultation(consultation);
    LoadConsultations();

    }
    public void delconsultation(){
        Consultation consultation = tableConsultation.getSelectionModel().getSelectedItem();
        cabinetService.deleteConsultation(consultation);
        LoadConsultations();



    }
    public void LoadConsultations() {
        consultations.setAll(cabinetService.getConsultations());
    }

}

package ma.enset.gestioncabinet.controllers;

import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.gestioncabinet.Dao.ConsultationDao;
import ma.enset.gestioncabinet.Dao.PatientDao;
import ma.enset.gestioncabinet.entities.Patient;
import ma.enset.gestioncabinet.service.CabinetService;
import ma.enset.gestioncabinet.service.ICabinetService;

import javax.security.sasl.SaslException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class PatientController implements Initializable {


    private ICabinetService cabinetService;
    private Patient SelectedPatient;
    private ObservableList<Patient> patients= FXCollections.observableArrayList();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cabinetService=new CabinetService(new PatientDao(),new ConsultationDao());
        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        columnPrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        columnTel.setCellValueFactory(new PropertyValueFactory<>("tel"));
        LoadPatients();
        tablePatients.setItems(patients);
        textfieldSearch.textProperty().addListener((observable, oldValue, newValue) -> {
                patients.setAll( cabinetService.SearchPatientbyQuery(newValue));
        });
        tablePatients.getSelectionModel().selectedItemProperty().addListener((observable, oldPatient, newPatient) -> {
            if (newPatient != null) {  textfieldNom.setText(newPatient.getNom());
                textfieldPrenom.setText(newPatient.getPrenom());
                textfieldTel.setText(newPatient.getTel());
                SelectedPatient=newPatient;}

        });

    }

    @FXML private  TextField textfieldNom;
    @FXML private  TextField textfieldPrenom;
    @FXML private  TextField textfieldTel;
    @FXML private  TableView<Patient> tablePatients;
    @FXML private TableColumn<Patient,Long> columnID;
    @FXML private  TableColumn<Patient,String> columnNom;
    @FXML private  TableColumn<Patient,String> columnPrenom;
    @FXML private  TableColumn<Patient,String> columnTel;
    @FXML private Label LabelSuccess;
    @FXML private TextField textfieldSearch;

public void addPatient() {
Patient patient = new Patient();
patient.setNom(textfieldNom.getText());
patient.setPrenom(textfieldPrenom.getText());
patient.setTel(textfieldTel.getText());
cabinetService.addPatient(patient);
    LabelSuccess.setText("patient bien ajoute");
    LoadPatients();
}
public void delPatient() {
    Patient patient = tablePatients.getSelectionModel().getSelectedItem();
    cabinetService.deletePatient(patient);
    LoadPatients();
    LabelSuccess.setText("patient bien supprimé");

}
public void LoadPatients() {
    patients.setAll(cabinetService.getPatients());
}

 public void updatePatient() {
   SelectedPatient.setNom(textfieldNom.getText());
   SelectedPatient.setPrenom(textfieldPrenom.getText());
   SelectedPatient.setTel(textfieldTel.getText());
   cabinetService.updatePatient(SelectedPatient);
   LoadPatients();
    }
}

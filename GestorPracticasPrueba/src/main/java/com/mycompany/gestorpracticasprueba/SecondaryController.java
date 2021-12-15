package com.mycompany.gestorpracticasprueba;

import Hibernate.HibernateUtil;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Actividad;
import models.Alumno;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SecondaryController implements Initializable {

    @FXML
    private TextField nombreTxt;
    @FXML
    private TextField horasTxt;
    @FXML
    private DatePicker fechaTxt;
    @FXML
    private TextArea observacionesTxt;
    @FXML
    private Button anadirBtn;
    @FXML
    private Button salirBtn;
    @FXML
    private TableView<Actividad> tabla;
    @FXML
    private TableColumn<Actividad, Long> cId;
    @FXML
    private TableColumn<Actividad, String> cNombre;
    @FXML
    private TableColumn<Actividad, Integer> cHoras;
    @FXML
    private TableColumn<Actividad, Date> cFecha;
    @FXML
    private TableColumn<Actividad, String> cObservaciones;
    @FXML
    private Button eliminarBtn;

    private void switchToPrimary() throws IOException {
        App.setRoot(" ");
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObservableList<Actividad> contenido = FXCollections.observableArrayList();
        tabla.setItems(contenido);

        cId.setCellValueFactory(new PropertyValueFactory<>("id"));
        cNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        cHoras.setCellValueFactory(new PropertyValueFactory<>("horas"));
        cFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        cObservaciones.setCellValueFactory(new PropertyValueFactory<>("incidencias"));

        Session s = HibernateUtil.getSessionFactory().openSession();
        Alumno a = s.load(Alumno.class, SessionData.getAlumnoActual().getId());
        SessionData.setAlumnoActual(a);

        contenido.addAll(a.getActividades());

    }

    @FXML
    private void seleccionar(ActionEvent event) {
        Actividad a = tabla.getSelectionModel().getSelectedItem();

    }

    @FXML
    private void eliminar(ActionEvent event) {
        Session s = HibernateUtil.getSessionFactory().openSession();
        Transaction tr = s.beginTransaction();
        s.remove(SessionData.getActividadActual());
        tr.commit();

    }

    @FXML
    private void salir(ActionEvent event) {
        Stage stage = (Stage) this.salirBtn.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void añadir(ActionEvent event) {
        Actividad a = SessionData.getActividadActual();
        if (a != null) {
            SessionData.getActividadActual().setNombre(nombreTxt.getText());

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            s.update(SessionData.getActividadActual());
            tr.commit();
            
        } else {

            a = new Actividad();
            a.setNombre(nombreTxt.getText());
            //a.setHoras( horas.getValue());
            a.setAlumno(SessionData.getAlumnoActual());

            Session s = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = s.beginTransaction();
            s.save(a);
            tr.commit();

        }

    }
}

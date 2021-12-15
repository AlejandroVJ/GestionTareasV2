package com.mycompany.gestorpracticasprueba;

import Hibernate.HibernateUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import models.Alumno;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class PrimaryController implements Initializable {

    public static String usuario = null;

    @FXML
    private Label lUsuario;
    @FXML
    private Label lContraseña;
    @FXML
    private TextField Usuariotxt;
    @FXML
    private PasswordField Contraseñatxt;
    @FXML
    private Button IniciarSesion;
    @FXML
    private Button Cancelar;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    private void Cancelar(ActionEvent event) {
        Stage stage = (Stage) this.Cancelar.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void IniciarSesion(ActionEvent event) {

        System.out.println("Botón Iniciar Sesión");
        System.out.println(lUsuario.getText());
        System.out.println(lContraseña.getText());

        Session s = HibernateUtil.getSessionFactory().openSession();
        Query q = s.createQuery("FROM Alumno a WHERE a.nombre=:nombre AND a.contraseña=:contraseña ");
        q.setParameter("nombre", lUsuario.getText());
        q.setParameter("contraseña", lContraseña.getText());

        if (q.list().size() > 0) {

            Alumno a = (Alumno) q.list().get(0);

            System.out.println(a);
            //System.out.println(a.);

            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Aceptar");
            alerta.setHeaderText("Nuevo login");
            alerta.setContentText("El usuario " + lUsuario.getText()
                    + " con contraseña " + lContraseña.getText() + " ha iniciado sesión.");
            alerta.showAndWait();
            //System.out.println("");

            SessionData.setAlumnoActual(a);

            try {
                App.setRoot("secondary");
            } catch (IOException ex) {
                Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("Usuario no válido");
            alerta.setContentText("El usuario " + lUsuario.getText()
                    + " no existe ");
            alerta.showAndWait();

        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Session s = HibernateUtil.getSessionFactory().openSession();

        Query q = s.createQuery("FROM alumno");
        q.list().forEach((e) -> System.out.println(e));

        Query qq = s.createQuery("FROM actividad");
        qq.list().forEach((e) -> System.out.println(e));
    }

}

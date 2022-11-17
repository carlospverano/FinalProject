package com.example.iniciosesion;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import model.Disponibilidad;
import model.Propiedad;
import model.Propietario;

import java.util.List;

import static com.example.iniciosesion.AppController.INSTANCE;

public class RegistrarPropiedad {

    @FXML
    private TextField area;

    @FXML
    private TextField direccion;

    @FXML
    private TextField disponibilidad;

    @FXML
    private TextField propietario;

    @FXML
    private Button registrar;

    @FXML
    private Label resultado;
    @FXML
    private TableView<Propiedad>  tblpropiedades;

    @FXML
    private TableColumn<Propiedad, Double> tableArea;

    @FXML
    private TableColumn<Propiedad,String> tableDireccion;

    @FXML
    private TableColumn<Propiedad, Disponibilidad> tableDisponibilidad;

    @FXML
    private TableColumn<Propiedad, Propietario> tablePropietario;

    @FXML
    private TableColumn<Propiedad, Double> tableValor;

    @FXML
    private TextField valor;

    @FXML
    public void initialize (){
    llenarTabla(INSTANCE.getFincaRaiz().buscarPropiedad(null));
    tableDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
    tableValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    tableArea.setCellValueFactory(new PropertyValueFactory<>("area"));
    tablePropietario.setCellValueFactory(new PropertyValueFactory<>("propietario"));
    tableDisponibilidad.setCellValueFactory(new PropertyValueFactory<>("disponibilidad"));
    
    tblpropiedades.getSelectionModel().selectedItemProperty()
            .addListener((observable,oldValue,newValue) -> llenarCampos(newValue));
    tableDireccion.setTextFormatter(new TextFormatter<>(RegistrarPropiedad::upperCaseFormat));
    }

    public RegistrarPropiedad() {

    }

    @FXML
    void buttonActionregistrar(ActionEvent event) {

    }

    @FXML
    void eventKey(KeyEvent event) {

    }
    private void llenarTabla(List<Propiedad> propiedades) {
        tblpropiedades.setItems(FXCollections.observableArrayList(propiedades));
        tblpropiedades.refresh();
    }

    private void llenarCampos(Propiedad propiedad) {
        if (propiedad != null) {
            tableDireccion.setText(propiedad.getDirecion());
            tableValor.setText(String.valueOf(propiedad.getValor()));
            tableArea.setText(String.valueOf(propiedad.getArea()));
            tablePropietario.setText(String.valueOf(propiedad.getPropietario()));
            tableDisponibilidad.setText(String.valueOf(propiedad.getDisponibilidad()));
        }
    }
    public static TextFormatter.Change upperCaseFormat(TextFormatter.Change change){
        change.setText(change.getText().toUpperCase());
        return change;
    }

    public static TextFormatter.Change integerFormat(TextFormatter.Change change){
        if (change.getText().matches("[0-9]*")) {
            return change;
        }
        return null;
    }
}


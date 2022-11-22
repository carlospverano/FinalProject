package com.example.iniciosesion;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import static com.example.iniciosesion.AppController.INSTANCE;
import model.*;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public class EmpleadoController implements Initializable {
    Propiedad propiedadSeleccionado;
    @FXML
    private ObservableList<Propiedad> propiedades = FXCollections.observableArrayList(); //Lista para mostrar en la tabla
    @FXML
    private ObservableList<Propietario> propietarios = FXCollections.observableArrayList();
    @FXML
    private ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    @FXML
    private TextField nombre;

    @FXML
    private TextField id;

    FincaRaiz finca = INSTANCE.getModel();

    @FXML
    private TextField nombreCliente;
    @FXML
    private TextField idCliente;
    @FXML
    private TextField direccion;
    @FXML
    private TextField valor;
    @FXML
    private TextField area;
    @FXML
    private  ComboBox<Propiedad> comboTipoPropiedad;
    @FXML
    private ComboBox <Propietario> combopropietario;
    @FXML
    private TableView<Propiedad> tablaPropiedades;

    @FXML
    private TableColumn<Propiedad,  Double> columnaArea;

    @FXML
    private TableColumn<Propiedad, String> columnaDireccion;

    @FXML
    private TableColumn<Disponibilidad, Enum> columnaDisponibilidad;

    @FXML
    private TableColumn<Propiedad, Propietario> columnaPropietario;

    @FXML
    private TableColumn<Propiedad, Double> columnaValor;

    @FXML
    private TableColumn<Propiedad, Propiedad> columnaTipoPropiedad;





    @FXML
    private TableView<Propietario> tablaPropietarios;
    @FXML
    private TableColumn<Propietario, String> columnaName;
    @FXML
    private TableColumn<Propietario, String> columnaIdPropietario;
    @FXML
    private TableView<Cliente> tablaClientes;
    @FXML
    private TableColumn<Cliente,  String> columnaNameCliente;

    @FXML
    private TableColumn<Cliente, String> columnaIdentificacionCliente;
    @FXML
    private ComboBox <Propiedad> comboSelectPropiedad;
    @FXML
    private ComboBox <Cliente> comboSelectCliente;

    @FXML
    private void comboboxEvents(ActionEvent e){}

    public void eventKey(KeyEvent keyEvent) {
    }
    public void eventAction(ActionEvent actionEvent) {
    }
    public void registrar() {

        String direccionRegistrada = direccion.getText();

        String valorPropiedad = (valor.getText());

        String areaPropiedad = area.getText();

        Propietario propietarioP= combopropietario.getValue();
        Propiedad tipoPropiedad = comboTipoPropiedad.getValue();

        Propiedad propiedad= new Propiedad(direccionRegistrada,Double.parseDouble(valorPropiedad),Double.parseDouble(areaPropiedad),propietarioP,Disponibilidad.DISPONIBLE);
        propiedades.add(propiedad);
        tablaPropiedades.setItems(propiedades);
        tablaPropiedades.refresh(); //Actualiza la tabla

        try {
            finca.registrarPropiedad(propiedad);
        }
        catch (Exception e){
            e.getMessage();
        }
    }

    public void registrarPropietario () throws Exception {

        String nombrePropietario = nombre.getText();
        String identificacionPropietario= id.getText();

        Propietario propietario1 = new Propietario(nombrePropietario,identificacionPropietario);
        propietarios.add(propietario1);
        tablaPropietarios.setItems(propietarios);
        tablaPropietarios.refresh(); //Actualiza la tabla

        try {
            finca.registrarPropietario(propietario1, finca.getEmpleados().get(0));
            combopropietario.getItems().addAll(finca.getPropietarios());
        }
        catch (Exception e){
            e.getMessage();
        }

    }

    public void registrarCliente () throws Exception {

        String nombreCliente1 = nombreCliente.getText();
        String identificacionCliente= idCliente.getText();

        Cliente cliente = new Cliente(nombreCliente1,identificacionCliente);
        clientes.add(cliente);
        tablaClientes.setItems(clientes);
        tablaClientes.refresh(); //Actualiza la tabla
        try {
            finca.registrarCliente(cliente, finca.getEmpleados().get(0));

        }
        catch (Exception e){
            e.getMessage();
        }

    }

    public void alquilar() {
        Propiedad propiedad = comboSelectPropiedad.getValue();
        Cliente cliente = comboSelectCliente.getValue();
        propiedades.add(propiedad);
        clientes.add(cliente);
        finca.alquiler(finca.getEmpleados().get(0), cliente, propiedad);
        comboSelectPropiedad.getItems().addAll(finca.getPropiedades());

    }

    public void vender() {
        Propiedad propiedad = comboSelectPropiedad.getValue();
        Cliente cliente = comboSelectCliente.getValue();
        propiedades.add(propiedad);
        clientes.add(cliente);
        finca.vender(finca.getEmpleados().get(0),cliente,propiedad );
        comboSelectCliente.getItems().addAll(finca.getClientes());


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        combopropietario.getItems().addAll(finca.getPropietarios());
        this.columnaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        this.columnaDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        this.columnaArea.setCellValueFactory(new PropertyValueFactory<>("area"));
        this.columnaPropietario.setCellValueFactory(new PropertyValueFactory<>("propietario"));
        this.columnaDisponibilidad.setCellValueFactory(new PropertyValueFactory<>("disponibilidad"));
        this.columnaTipoPropiedad.setCellValueFactory(new PropertyValueFactory<>("tipoDePropiedad"));
        this.columnaName.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnaIdPropietario.setCellValueFactory(new PropertyValueFactory<>("id"));
        this.columnaNameCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        this.columnaIdentificacionCliente.setCellValueFactory(new PropertyValueFactory<>("id"));
        comboSelectPropiedad.getItems().addAll(finca.getPropiedades());
        comboTipoPropiedad.getItems().addAll(finca.getPropiedades());


        comboSelectCliente.getItems().addAll(finca.getClientes());

        }

    private void llenarTabla(List<Propiedad> propiedadList) {
        tablaPropiedades.setItems(FXCollections.observableArrayList(propiedadList));
        tablaPropiedades.refresh();
    }
    }

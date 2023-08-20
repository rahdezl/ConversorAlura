package com.conversor.conversor.Controller;

import com.conversor.conversor.ConversorApplication;
import com.conversor.conversor.DTO.ConverterDTO;
import com.conversor.conversor.Util.Divisas;
import com.conversor.conversor.Util.InputValidation;
import com.conversor.conversor.Util.ApiQueryConverter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class CoversorDivisasController implements Initializable {

    @FXML
    private TextField TextFieldAmount;

    @FXML
    private Button btnAtras;

    @FXML
    private Button btnConvertir;

    @FXML
    private ComboBox<Divisas> comboBoxFrom;

    @FXML
    private ComboBox<Divisas> comboBoxTo;

    @FXML
    private Label txtresultado;
    @FXML
    private Button btnLimpiar;


    @FXML
    protected void Consultar() throws IOException {
        String txtcantidad= TextFieldAmount.getText();
        String txtFrom= comboBoxFrom.getValue().name();
        String txtTo=comboBoxTo.getValue().name();
        boolean validation = new InputValidation().inputValidate(txtcantidad,txtFrom,txtTo);
        if (validation== true){
            ApiQueryConverter requestApi = new ApiQueryConverter();
            ConverterDTO converterDTO=new ConverterDTO(txtFrom,txtTo,txtcantidad);
            String resp=requestApi.requestApi(converterDTO);
            txtresultado.setText(txtTo+" " + resp);
        } else {
            Alert alert= new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText(null);
            alert.setContentText("Los datos no son validos");
            alert.showAndWait();
        }
    }


    public void getPrincipalView(ActionEvent event) throws IOException {
        ConversorApplication.setStage("MainView");
    }

    @FXML
    void limpiar(ActionEvent event) {
        TextFieldAmount.setText("");
        txtresultado.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Divisas> divisasList= Divisas.getAllDivisas();
        ObservableList<Divisas> divisas = FXCollections.observableArrayList(divisasList).sorted();
        comboBoxFrom.setItems(divisas);

        comboBoxTo.setItems(divisas);

    }
}


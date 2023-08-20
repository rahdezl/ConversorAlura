package com.conversor.conversor.Controller;

import com.conversor.conversor.ConversorApplication;
import com.conversor.conversor.Util.ConversionTemperatura;
import com.conversor.conversor.Util.InputValidation;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConversorTemperaturaController implements Initializable {
    @FXML
    private ComboBox<String> cbFromTemperatura;
    @FXML
    private Button btnConvertir;

    @FXML
    private ComboBox<String> comboboxTo;
    @FXML
    private Label labelResultado;
    @FXML
    private TextField txtCantidad;

    @FXML
    private Button btnLimpiar;
    @FXML
    public void convertir(ActionEvent event){
        ConversionTemperatura conversion = new ConversionTemperatura();
        String cantidad= txtCantidad.getText();
        String txtFrom= cbFromTemperatura.getValue();
        String txtTo= comboboxTo.getValue();
        String texto= txtCantidad.getText();
        boolean validation= new InputValidation().inputValidate(cantidad,txtFrom,txtTo);
        if(validation==true){
            if (txtFrom.equals(txtTo)){
                labelResultado.setText(texto);
            }else {
                switch (txtFrom+txtTo){
                    case "celsiusfahrenheit":
                        labelResultado.setText(String.valueOf((conversion.celciusToFahrenheit(Double.parseDouble(texto)))));
                        break;
                    case "celsiuskelvin":
                        labelResultado.setText(String.valueOf((conversion.celciusToKelvin(Double.parseDouble(texto)))));
                        break;
                    case "kelvinfahrenheit":
                        labelResultado.setText(String.valueOf((conversion.kelvinToFahrenheit(Double.parseDouble(texto)))));
                        break;
                    case "kelvincelsius":
                        labelResultado.setText(String.valueOf((conversion.kelvinToCelcius(Double.parseDouble(texto)))));
                        break;
                    case "fahrenheitcelsius":
                        labelResultado.setText(String.valueOf((conversion.fahrenheitToCelsuis(Double.parseDouble(texto)))));
                        break;
                    case "fahrenheitkelvin":
                        labelResultado.setText(String.valueOf
                                (Math.round(conversion.fahrenheitToKelvin(Double.parseDouble(texto)))));
                        break;
                }
            }
        }else {
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
        txtCantidad.setText("");
        labelResultado.setText("");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cbFromTemperatura.getItems().addAll("celsius","fahrenheit", "kelvin");
        comboboxTo.getItems().addAll("celsius","fahrenheit", "kelvin");

    }
}


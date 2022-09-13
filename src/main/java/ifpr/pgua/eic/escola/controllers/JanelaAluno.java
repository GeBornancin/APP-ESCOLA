package ifpr.pgua.eic.escola.controllers;

import java.time.LocalDate;

import ifpr.pgua.eic.escola.App;
import ifpr.pgua.eic.escola.models.Escola;
import ifpr.pgua.eic.escola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class JanelaAluno {
    

    @FXML
    private void carregaTelaListarAluno(ActionEvent event){
        App.changeScreenRegion("LISTARALUNO", BorderPaneRegion.CENTER);
    }
    @FXML
    private void carregaTelaCadastrarAluno(ActionEvent event){
        App.changeScreenRegion("CADASTRARALUNO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaMatricularAluno(ActionEvent event){
        App.changeScreenRegion("MATRICULARALUNO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaDesmatricularAluno(ActionEvent event){
        App.changeScreenRegion("DESMATRICULARALUNO", BorderPaneRegion.CENTER);
    }
    
}

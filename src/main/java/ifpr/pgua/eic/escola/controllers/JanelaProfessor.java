package ifpr.pgua.eic.escola.controllers;

import ifpr.pgua.eic.escola.App;
import ifpr.pgua.eic.escola.models.Escola;
import ifpr.pgua.eic.escola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;


public class JanelaProfessor {
    @FXML
    private void carregaTelaCadastrarProfessor(ActionEvent event){
        App.changeScreenRegion("CADASTRARPROFESSOR", BorderPaneRegion.CENTER);
    }
    

    @FXML
    private void carregaTelaListarProfessor(ActionEvent event){
        App.changeScreenRegion("LISTARPROFESSOR", BorderPaneRegion.CENTER);
    }
    


    

}

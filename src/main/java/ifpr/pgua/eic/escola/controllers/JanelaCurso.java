package ifpr.pgua.eic.escola.controllers;



import ifpr.pgua.eic.escola.App;

import ifpr.pgua.eic.escola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;



public class JanelaCurso {


    @FXML
    private void carregaTelaCadastrarCurso(ActionEvent event){
        App.changeScreenRegion("CADASTRARCURSO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaListarCurso(ActionEvent event){

        App.changeScreenRegion("LISTARCURSO", BorderPaneRegion.CENTER);
    }
    @FXML
    private void carregaTelaAlunosMatriculados(ActionEvent event){
        App.changeScreenRegion("ALUNOMATRICULADO", BorderPaneRegion.CENTER);
    }

    
}

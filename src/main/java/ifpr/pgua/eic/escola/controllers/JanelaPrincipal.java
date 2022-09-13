package ifpr.pgua.eic.escola.controllers;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import ifpr.pgua.eic.escola.App;
import ifpr.pgua.eic.escola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.awt.*;
import javafx.scene.control.Hyperlink;

public class JanelaPrincipal {
    
    @FXML
    private void carregaTelaAluno(){
        App.changeScreenRegion("ALUNO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaCurso(){
        App.changeScreenRegion("CURSO", BorderPaneRegion.CENTER);
    }

    @FXML
    private void carregaTelaProfessor(){
        App.changeScreenRegion("PROFESSOR", BorderPaneRegion.CENTER);
    }
    
    @FXML
    private Hyperlink hyperlink;

    @FXML
    void openLink(ActionEvent event) throws URISyntaxException, IOException{

        Desktop.getDesktop().browse(new URI("https://github.com/GeBornancin"));
    }
    
}

package ifpr.pgua.eic.escola.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.plaf.multi.MultiViewportUI;

import ifpr.pgua.eic.escola.models.Aluno;
import ifpr.pgua.eic.escola.models.Curso;
import ifpr.pgua.eic.escola.models.Escola;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class AlunosMatriculados implements Initializable {
    private Escola escola;

    public AlunosMatriculados(Escola escola){
        this.escola = escola;
    }
    @FXML
    private TextArea taDetalhes;

    @FXML
    private ListView<Curso> lvCursos;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        lvCursos.getItems().addAll(escola.listarCursos());
        
    }
    @FXML
    private void mostraDetalhes(MouseEvent evento){
        taDetalhes.clear();

        Curso curso = lvCursos.getSelectionModel().getSelectedItem();

            taDetalhes.appendText("Nome: "+curso.getAlunos()+"\n");
    }

  


}

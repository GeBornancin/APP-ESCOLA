package ifpr.pgua.eic.escola.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.escola.models.Curso;
import ifpr.pgua.eic.escola.models.Escola;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class ListaCurso implements Initializable{
    
    private Escola escola;

    public ListaCurso(Escola escola){
        this.escola = escola;
    }
    
    @FXML
    private ListView<Curso> ltvCursos;
    
 
    
    @FXML
    private TextArea taDetalhes;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        ltvCursos.getItems().addAll(escola.listarCursos());
        
    }

    @FXML
    private void mostraDetalhes(MouseEvent evento){
        taDetalhes.clear();

        Curso curso = ltvCursos.getSelectionModel().getSelectedItem();

        if(curso != null){
            taDetalhes.appendText("Codigo: "+curso.getCodigo()+"\n");
            taDetalhes.appendText("Nome: "+curso.getNome()+"\n");
            taDetalhes.appendText("Descrição: "+curso.getDescricao()+"\n");
            taDetalhes.appendText("Carga horaria: "+curso.getCargaHoraria()+"\n");
            taDetalhes.appendText("Professor: "+curso.getProfessor()+"\n");
            

        }
    }

    
}

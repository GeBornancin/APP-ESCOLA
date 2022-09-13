package ifpr.pgua.eic.escola.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import ifpr.pgua.eic.escola.models.Aluno;
import ifpr.pgua.eic.escola.models.Curso;
import ifpr.pgua.eic.escola.models.Escola;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Alert.AlertType;

public class DesmatricularAlunos implements Initializable{

    private Escola escola;

    public DesmatricularAlunos(Escola escola){

        this.escola = escola;
    }

    @FXML
    private ComboBox<Aluno> cbAluno;

    @FXML
    private ComboBox<Curso> cbCurso;

    @FXML
    private void desmatricular(){

        Aluno aluno = cbAluno.getSelectionModel().getSelectedItem();
        Curso curso = cbCurso.getSelectionModel().getSelectedItem();
    
        if(escola.desmatricularAluno(aluno, curso)==true){
            escola.salvarArquivoTexto();
            Alert alert = new Alert(AlertType.INFORMATION,"Realizado!");
            alert.showAndWait();
           

        } else{
            Alert alert = new Alert(AlertType.INFORMATION,"Erro ao desmatricular");
            alert.showAndWait();           
        
        }
    
    }

    
    




    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        
        cbAluno.getItems().addAll(escola.listarAlunos());
        cbCurso.getItems().addAll(escola.listarCursos());
    }
    
}

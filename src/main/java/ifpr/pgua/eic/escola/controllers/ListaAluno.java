package ifpr.pgua.eic.escola.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import ifpr.pgua.eic.escola.models.Aluno;
import ifpr.pgua.eic.escola.models.Escola;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ListaAluno  implements Initializable {

    private Escola escola;

    public ListaAluno(Escola escola){
        this.escola = escola;
    }
    
    @FXML
    private ListView<Aluno> ltvAlunos;
    
    @FXML
    private TextField tfBusca;
    
    @FXML
    private TextArea taDetalhes;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println(escola.listarAlunos());
        ltvAlunos.getItems().addAll(escola.listarAlunos());
        
    }

    @FXML
    private void mostraDetalhes(MouseEvent evento){
        taDetalhes.clear();

        Aluno aluno = ltvAlunos.getSelectionModel().getSelectedItem();

        if(aluno != null){
            taDetalhes.appendText("Cpf: "+aluno.getCpf()+"\n");
            taDetalhes.appendText("Nome: "+aluno.getNome()+"\n");
            taDetalhes.appendText("Telefone: "+aluno.getTelefone()+"\n");
            taDetalhes.appendText("E-mail: "+aluno.getEmail()+"\n");
            taDetalhes.appendText("Data de Matricula: "+aluno.getDataMatricula()+"\n");

        }
    }

    @FXML
    private void buscar(){

       
    }
}

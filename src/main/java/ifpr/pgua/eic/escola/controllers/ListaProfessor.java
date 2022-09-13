package ifpr.pgua.eic.escola.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import ifpr.pgua.eic.escola.models.Escola;
import ifpr.pgua.eic.escola.models.Professor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ListaProfessor implements Initializable{

    private Escola escola;

    public ListaProfessor(Escola escola){
        this.escola = escola;
    }
    
    @FXML
    private ListView<Professor> ltvProfessores;
    
    @FXML
    private TextField tfBusca;
    
    @FXML
    private TextArea taDetalhes;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        System.out.println(escola.listarProfessores());
        ltvProfessores.getItems().addAll(escola.listarProfessores());
        
    }

    @FXML
    private void mostraDetalhes(MouseEvent evento){
        taDetalhes.clear();

        Professor professor = ltvProfessores.getSelectionModel().getSelectedItem();

        if(professor != null){
            taDetalhes.appendText("Cpf: "+professor.getCpf()+"\n");
            taDetalhes.appendText("Nome: "+professor.getNome()+"\n");
            taDetalhes.appendText("Telefone: "+professor.getTelefone()+"\n");
            taDetalhes.appendText("E-mail: "+professor.getEmail()+"\n");
            taDetalhes.appendText("Salario: "+professor.getSalario()+"\n");

        }
    }

    @FXML
    private void buscar(){

       
    }

}
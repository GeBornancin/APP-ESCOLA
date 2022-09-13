package ifpr.pgua.eic.escola.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import ifpr.pgua.eic.escola.models.Escola;
import ifpr.pgua.eic.escola.models.Professor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastrarCurso implements Initializable{
    private Escola escola;

    public CadastrarCurso(Escola escola){
        this.escola = escola;
    }
        
    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfDescricao;

    @FXML
    private TextField tfCargaHoraria;
    
    @FXML
    private ComboBox<Professor> cbProfessor;


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        cbProfessor.getItems().addAll(escola.listarProfessores());
        
    }
    


    @FXML
    private void cadastrar(){

        int codigo = Integer.valueOf(tfCodigo.getText());
        String nome = tfNome.getText();
        String descricao = tfDescricao.getText();
        int cargaHoraria = Integer.valueOf(tfCargaHoraria.getText());
        Professor professor = cbProfessor.getSelectionModel().getSelectedItem();

        if(escola.cadastrarCurso(codigo, nome, descricao, cargaHoraria, professor)){

            Alert alert = new Alert(AlertType.INFORMATION,"Cadastro realizado!");
            alert.showAndWait();
            limpar();

        } else {
            Alert alert = new Alert(AlertType.INFORMATION,"Cadastro não realizado");
            alert.showAndWait();
            
        }
   }
    private void limpar(){
        tfCodigo.clear();
        tfNome.clear();
        tfDescricao.clear();
        tfCargaHoraria.clear();
        cbProfessor.setValue(null);
    }

    
}

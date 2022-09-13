package ifpr.pgua.eic.escola.controllers;

import ifpr.pgua.eic.escola.App;
import ifpr.pgua.eic.escola.models.Escola;
import ifpr.pgua.eic.escola.models.Professor;
import ifpr.pgua.eic.escola.utils.BorderPaneRegion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastrarProfessor {

    private Escola escola;
    
    public CadastrarProfessor(Escola escola){
        this.escola = escola;
    }

    @FXML
    private TextField tfCpf;

    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfTelefone;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfSalario;

   

    
    @FXML
    private void cadastrar() throws NumberFormatException{
        String cpf = tfCpf.getText();
        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();
        String email = tfEmail.getText();
        Double salario = Double.valueOf(tfSalario.getText());

    
        if(tfCpf.getText().length() > 0 && tfNome.getText().length() > 0 && tfTelefone.getText().length() > 0 && tfEmail.getText().length() > 0 && salario != null){
            
            if (escola.cadastrarProfessor(cpf, nome, telefone, email, salario)){

                Alert alert = new Alert(AlertType.INFORMATION,"Cadastro realizado!");
                alert.showAndWait();
                limpar();

            } else {
                Alert alert = new Alert(AlertType.INFORMATION," Erro ao cadastrar!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(AlertType.INFORMATION,"Erro ao cadastrar!");
            alert.showAndWait();
        }
    

    }

    
    

    private void limpar(){
        tfCpf.clear();
        tfNome.clear();
        tfEmail.clear();
        tfTelefone.clear();
        tfSalario.clear();
    }
    
}

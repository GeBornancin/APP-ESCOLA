package ifpr.pgua.eic.escola.controllers;

import java.time.LocalDate;

import ifpr.pgua.eic.escola.models.Escola;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class CadastrarAluno {
    private Escola escola;
    
    public CadastrarAluno(Escola escola){
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
    private void cadastrar(){
        String cpf = tfCpf.getText();
        String nome = tfNome.getText();
        String telefone = tfTelefone.getText();
        String email = tfEmail.getText();
        LocalDate dataMatricula = LocalDate.now();

        if(tfCpf.getText().length() > 0  && tfNome.getText().length() > 0 && tfTelefone.getText().length() > 0 && tfEmail.getText().length() > 0){
            if (escola.cadastrarAluno(cpf, nome, telefone, email, dataMatricula)){

                Alert alert = new Alert(AlertType.INFORMATION,"Cadastro realizado!");
                alert.showAndWait();
                limpar();

            } else {
                Alert alert = new Alert(AlertType.INFORMATION,"Cadastro não realizado!");
                alert.showAndWait();
            }
            
        }
        else {
            Alert alert = new Alert(AlertType.INFORMATION,"Cadastro não realizado!");
            alert.showAndWait();
        }
    }

    private void limpar(){
        tfCpf.clear();
        tfNome.clear();
        tfEmail.clear();
        tfTelefone.clear();
    }

    
}

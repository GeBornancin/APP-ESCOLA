package ifpr.pgua.eic.escola.models;

import java.time.LocalDate;

public class Aluno extends Pessoa {
    
    private  LocalDate dataMatricula;

    public Aluno(String cpf, String nome, String email, String telefone, LocalDate dataMatricula) {
        super(cpf, nome, email, telefone);
        this.dataMatricula = dataMatricula;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public String passaTexto(){
        return super.passaTexto()+"; Data-Matricula:"+dataMatricula;
    }

    public static Aluno parse(String dataMatricula) {
        return null;
    }
}

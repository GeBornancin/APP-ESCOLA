package ifpr.pgua.eic.escola.models;

public class Professor extends Pessoa {

    private double salario;

    public Professor(String cpf, String nome, String email, String telefone, double salario) {
        super(cpf, nome, email, telefone);
        this.salario = salario;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String passaTexto(){
        return super.passaTexto()+"; Salario:"+salario;
    }
    
    public static Professor parse(String professor) {
        return null;
    }
  

}
    


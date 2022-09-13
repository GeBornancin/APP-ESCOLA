package ifpr.pgua.eic.escola.models;

public class Pessoa {

    private String cpf;
    private String nome;
    private String email;
    private String telefone;

    public Pessoa(String cpf, String nome, String email, String telefone) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String toString() {

        String str = "";

        str = str + nome;

        return str;

    }

    public String passaTexto() {
        return "Nome:" + nome + "; Cpf:" + cpf + "; Email:" + email + "; Telefone:" + telefone;
    }
}

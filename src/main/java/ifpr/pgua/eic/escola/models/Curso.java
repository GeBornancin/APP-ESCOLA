package ifpr.pgua.eic.escola.models;

import java.util.ArrayList;

public class Curso {
    
    private int codigo;
    private String nome;
    private String descricao;
    private int cargaHoraria;
    private Professor professor;
    private ArrayList<Aluno> alunos;

    public Curso(int codigo, String nome, String descricao, int cargaHoraria, Professor professor) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
        alunos = new ArrayList<>();
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public  boolean matricula(Aluno aluno){
        
        
         if(alunos.contains(aluno)){
                 
           return false;
        }
        alunos.add(aluno);
        return true;
        
    }
    public boolean desmatricula(String cpf){
        
        Aluno aux = alunos.stream().filter((aluno)->aluno.getCpf().equals(cpf)).findFirst().orElse(null);

        if(aux != null){
            alunos.remove(aux);
            return true;
        }

    
        return false;

    }
    public String toString(){

        String str = "";

        str = str + nome;

        return str;

    }
    
    
    public String passaTexto(){
        return "Nome:" +nome+"; Codigo:"+codigo+"; Descricao:"+descricao+"; Carga-Horaria:"+cargaHoraria+"; Professor:"+professor;
    }
}

package ifpr.pgua.eic.escola.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Escola {

    private String nome;
    private String telefone;
    private ArrayList<Aluno> alunos;
    private ArrayList<Professor> professores;
    private ArrayList<Curso> cursos;
    LocalDate teste = LocalDate.now();

    public Escola(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        alunos = new ArrayList<>();
        professores = new ArrayList<>();
        cursos = new ArrayList<>();
        
        criaFakes();

    }

    private void criaFakes() {
        // cadastrarAluno("123", "Zé", "111-1111", "ze@teste.com", teste);
        // cadastrarAluno("1234","Zé Leoncio", "111-2222", "zeleoncio@teste.com",
        // teste);
        // cadastrarAluno("1235","Zéro Berto", "111-3333", "zero@teste.com", teste);
        // cadastrarAluno("1236","Maria", "111-4444", "maria@teste.com",teste);
        // cadastrarAluno("1237","Chico", "111-5555", "chico@teste.com",teste);
        // cadastrarProfessor("6969", "Geovane", "6969", "Geovane@Bornancin",teste);

    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // ***ALUNO***

    public boolean cadastrarAluno(String cpf, String nome, String telefone, String email, LocalDate dataMatricula) {

        if (buscarAlunoCpf(cpf) == null) {

            Aluno aluno = new Aluno(cpf, nome, email, telefone, dataMatricula);
            alunos.add(aluno);
            salvarArquivoTexto();
            return true;
        }
        return false;
    }

    public Aluno buscarAlunoCpf(String cpf) {
        return alunos.stream().filter((aluno) -> aluno.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    public ArrayList<Aluno> listarAlunos() {
        return alunos;
    }

    public  boolean matricularAluno(Aluno aluno, Curso curso) {

        if (curso.matricula(aluno) == true) {

            return true;
        }
        return false;
    }

    public  boolean desmatricularAluno(Aluno aluno, Curso curso) {
        if (curso.desmatricula(aluno.getCpf())) {
            return true;

        }
        return false;
    }

    // ***PROFESSOR***

    public boolean cadastrarProfessor(String cpf, String nome, String telefone, String email, Double salario) {

        if (buscarProfessorCpf(cpf) == null && nome != "") {
            Professor professor = new Professor(cpf, nome, email, telefone, salario);
            professores.add(professor);
            salvarArquivoTexto();
            return true;
        }
        return false;
    }

    public Professor buscarProfessorCpf(String cpf) {
        return professores.stream().filter((professor) -> professor.getCpf().equals(cpf)).findFirst().orElse(null);
    }

    public ArrayList<Professor> listarProfessores() {
        return professores;
    }

    // ***CURSO ***

    public boolean cadastrarCurso(int codigo, String nome, String descricao, int cargaHoraria, Professor professor) {
        if (buscarCurso(nome) == null) {
            Curso curso = new Curso(codigo, nome, descricao, cargaHoraria, professor);
            cursos.add(curso);
            salvarArquivoTexto();
            return true;

        }
        return false;

    }

    public Curso buscarCurso(String nome) {
        return cursos.stream().filter((curso) -> curso.getNome().equals(nome)).findFirst().orElse(null);
    }

    public List<Curso> listarCursos() {
        return cursos;
    }

    public void salvarArquivoTexto() {
        Gson gson = new Gson();

        String aluno = gson.toJson(alunos);
        String professor = gson.toJson(professores);
        String curso = gson.toJson(cursos);

        try (FileWriter out = new FileWriter("aluno.json")) {
            out.write(aluno);
            out.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar json");
        }

        try (FileWriter out = new FileWriter("professor.json")) {
            out.write(professor);
            out.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar json");
        }

        try (FileWriter out = new FileWriter("curso.json")) {
            out.write(curso);
            out.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar json");
        }

    }

    public void carregarArquivoTexto() {
        Gson gson = new Gson();

        Type listaAluno = new TypeToken<ArrayList<Aluno>>() {
        }.getType();
        Type listaProfessor = new TypeToken<ArrayList<Professor>>() {
        }.getType();
        Type listaCurso = new TypeToken<ArrayList<Curso>>() {
        }.getType();

        try (FileReader in = new FileReader("aluno.json");
                BufferedReader bin = new BufferedReader(in)) {

            String json = bin.readLine();
            ArrayList<Aluno> temp = gson.fromJson(json, listaAluno);

            if (temp != null) {
                this.alunos = temp;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader in = new FileReader("professor.json");
                BufferedReader bin = new BufferedReader(in)) {

            String json = bin.readLine();
            ArrayList<Professor> temp = gson.fromJson(json, listaProfessor);

            if (temp != null) {
                this.professores = temp;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader in = new FileReader("curso.json");
                BufferedReader bin = new BufferedReader(in)) {

            String json = bin.readLine();
            ArrayList<Curso> temp = gson.fromJson(json, listaCurso);

            if (temp != null) {
                this.cursos = temp;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // *** Arquivo Texto ***

    // public void salvarArquivoTexto(String nomeArquivo) throws IOException{

    // File arq = new File(nomeArquivo);
    // FileWriter fw= new FileWriter(arq);
    // BufferedWriter bw = new BufferedWriter(fw);

    // bw.write("[ALUNO]\n");
    // for(Aluno aluno:alunos){
    // bw.write("\t"+aluno.passaTexto());
    // bw.newLine();
    // }

    // bw.write("[PROFESSORES]\n");
    // for(Professor professor:professores){
    // bw.write("\t"+professor.passaTexto());
    // bw.newLine();
    // }

    // bw.write("[CURSOS]\n");
    // for(Curso curso:cursos){
    // bw.write("\t"+curso.passaTexto());
    // bw.newLine();
    // }

    // bw.close();
    // fw.close();

    // }

    // public void carregarArquivoTexto(String nomeArquivo) throws
    // NumberFormatException, IOException {

    // File arq = new File(nomeArquivo);
    // FileReader fr = new FileReader(arq);
    // BufferedReader br = new BufferedReader(fr);
    // int tipo = 0;

    // String linha;

    // while((linha=br.readLine())!=null){

    // if(linha.contains("[ALUNOS]")){
    // tipo = 0;
    // }else if(linha.contains("[PROFESSORES]")){
    // tipo = 1;
    // }else if(linha.contains("[CURSOS]")){
    // tipo = 2;
    // }
    // if(!linha.contains("[")){
    // linha = linha.replace("\t", "");
    // String[] pedacos = linha.split(";");

    // if(tipo == 0){

    // String cpf = pedacos[0].split(":")[1];
    // String nome = pedacos[1].split(":")[1];
    // String email = pedacos[2].split(":")[1];
    // String numero = pedacos[3].split(":")[1];
    // String dataMatricula = pedacos[4].split(":")[1];
    // LocalDate dataMatriculaDate = LocalDate.parse(dataMatricula);

    // Aluno aluno = new Aluno(nome, cpf, email, numero, dataMatriculaDate);
    // this.alunos.add(aluno);

    // }else if(tipo == 1){
    // String cpf = pedacos[0].split(":")[1];
    // String nome = pedacos[1].split(":")[1];
    // String email = pedacos[2].split(":")[1];
    // String numero = pedacos[3].split(":")[1];
    // String salario = pedacos[4].split(":")[1];
    // Double salarioD = Double.valueOf(salario).doubleValue();

    // Professor professor = new Professor(nome, cpf, email, numero, salarioD);
    // this.professores.add(professor);
    // }else if(tipo == 2){

    // String nome = pedacos[0].split(":")[1];
    // String codigo = pedacos[1].split(":")[1];
    // int codigoD = Integer.valueOf(codigo).intValue();
    // String descricao = pedacos[2].split(":")[1];
    // String cargaHoraria = pedacos[3].split(":")[1];
    // int cargaHorariaD = Integer.valueOf(cargaHoraria).intValue();
    // String professor = pedacos[4].split(":")[1];
    // Professor professorD = professores.stream().filter((professor_aux) ->
    // professor_aux.getNome().equals(professor)).findFirst().orElse(null);

    // Curso curso = new Curso(codigoD, nome, descricao, cargaHorariaD, professorD);

    // this.cursos.add(curso);

    // }
    // }

    // }

    // }

}

package ifpr.pgua.eic.escola;

import ifpr.pgua.eic.escola.controllers.AlunosMatriculados;
import ifpr.pgua.eic.escola.controllers.CadastrarAluno;
import ifpr.pgua.eic.escola.controllers.CadastrarCurso;
import ifpr.pgua.eic.escola.controllers.CadastrarProfessor;
import ifpr.pgua.eic.escola.controllers.DesmatricularAlunos;
import ifpr.pgua.eic.escola.controllers.JanelaAluno;
import ifpr.pgua.eic.escola.controllers.JanelaCurso;
import ifpr.pgua.eic.escola.controllers.JanelaPrincipal;
import ifpr.pgua.eic.escola.controllers.JanelaProfessor;
import ifpr.pgua.eic.escola.controllers.ListaAluno;
import ifpr.pgua.eic.escola.controllers.ListaCurso;
import ifpr.pgua.eic.escola.controllers.ListaProfessor;
import ifpr.pgua.eic.escola.controllers.MatricularAluno;
import ifpr.pgua.eic.escola.models.Escola;
import ifpr.pgua.eic.escola.utils.BaseAppNavigator;
import ifpr.pgua.eic.escola.utils.ScreenRegistryFXML;

/**
 * JavaFX App
 */
public class App extends BaseAppNavigator {

    
    
    public static void main(String[] args) {
        launch();
    }


    @Override
    public void init() throws Exception{
        super.init();
        escola.carregarArquivoTexto();

    }
    
    public void stop() throws Exception{
        super.stop();
        //escola.salvarArquivoTexto("dados.txt");
    }
    @Override
    public String getHome() {
        // TODO Auto-generated method stub
        return "PRINCIPAL";
    }

    @Override
    public String getAppTitle() {
        // TODO Auto-generated method stub
        return "IFPR";
    }

    @Override
    public void registrarTelas() {
        registraTela("PRINCIPAL", new ScreenRegistryFXML(App.class, "fxml/principal.fxml", o->new JanelaPrincipal()));
        registraTela("ALUNO", new ScreenRegistryFXML(App.class, "fxml/aluno.fxml", o->new JanelaAluno()));
        registraTela("CURSO", new ScreenRegistryFXML(App.class, "fxml/curso.fxml", o->new JanelaCurso()));
        registraTela("PROFESSOR", new ScreenRegistryFXML(App.class, "fxml/professor.fxml", o->new JanelaProfessor()));
        registraTela("CADASTRARALUNO", new ScreenRegistryFXML(App.class, "fxml/cadastraraluno.fxml", o->new CadastrarAluno(escola)));
        registraTela("CADASTRARCURSO", new ScreenRegistryFXML(App.class, "fxml/cadastrarcurso.fxml", o->new CadastrarCurso(escola)));
        registraTela("CADASTRARPROFESSOR", new ScreenRegistryFXML(App.class, "fxml/cadastrarprofessor.fxml", o->new CadastrarProfessor(escola)));
        registraTela("LISTARPROFESSOR", new ScreenRegistryFXML(App.class, "fxml/listarprofessor.fxml", o->new ListaProfessor(escola)));
        registraTela("LISTARALUNO", new ScreenRegistryFXML(App.class, "fxml/listaraluno.fxml", o->new ListaAluno(escola)));
        registraTela("LISTARCURSO", new ScreenRegistryFXML(App.class, "fxml/listarcurso.fxml", o->new ListaCurso(escola)));
        registraTela("MATRICULARALUNO", new ScreenRegistryFXML(App.class, "fxml/matricularaluno.fxml", o->new MatricularAluno(escola)));
        registraTela("ALUNOMATRICULADO", new ScreenRegistryFXML(App.class, "fxml/alunomatriculado.fxml", o->new AlunosMatriculados(escola)));
        registraTela("DESMATRICULARALUNO", new ScreenRegistryFXML(App.class, "fxml/desmatricularaluno.fxml", o->new DesmatricularAlunos(escola)));
        

    }
    
    @Override
    public void atualizaEstilo() {
        adicionarArquivoEstilo(getClass().getResource("css/estilo_principal.css").toExternalForm());
        
    }

}
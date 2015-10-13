
package consultoriomedico;

import util.DateUtil;
import util.Console;
import model.Medicamento;
import model.Paciente;
import repositorio.RepositorioMedicamentos;
import repositorio.RepositorioPacientes;
import java.text.ParseException;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 771400163
 */
public class ConsultorioMedico {

    static RepositorioPacientes repositorioPacientes = new RepositorioPacientes();
    static RepositorioMedicamentos repositorioMedicamentos = new RepositorioMedicamentos();
    
    public static void menuP() {
        int op = 0;

        while (op != 6) {

            System.out.println(".: Consultório Médido - Menu :.");
            System.out.println("1 - Cadastro de Pacientes");
            System.out.println("2 - Cadastro de Medicamentos");
            System.out.println("3 - Agendamento de Consultas");
            System.out.println("4 - Registro de Consultas");
            System.out.println("5 - Histórico");
            System.out.println("6 - Sair");

            op = Console.scanInt("Escolha uma opção: ");

            switch (op) {

                case 1:
                    menuCP();

                    break;
                case 2:
                    menuCM();

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:
                    System.out.println("Finalizado pelo usuário");

                    break;
                default:
                    throw new AssertionError();
            }
        }
    }

        public static void menuCP() {

        int op = 0;
        System.out.println("1 - Adicionar Paciente");
        System.out.println("2 - Visualizar todos Pacientes");
        System.out.println("3 - Atualizar Paciente");
        System.out.println("4 - Voltar");
        op = Console.scanInt("Escolha uma opção: ");

        switch (op) {
            case 1:
                //try {
                String nome = Console.scanString("Nome: ");
                String cpf = Console.scanString("CPF: ");
                String dtNasc = Console.scanString("Data Nascimento (dd/mm/aaaa): ");

                String sql = "insert into paciente (nome, cpf, dtnasc) values ('" + nome + "','" + cpf + "','" + dtNasc + "');";

                try {
                    try {
                        Class.forName("org.postgresql.Driver");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ConsultorioMedico.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String url = "jdbc:postgresql://localhost:5432/ConsultorioMedico";
                    Connection conexao = DriverManager.getConnection(url, "postgres", "jferraz");
                    Statement comando;
                    comando = conexao.createStatement();
                    int linhasAfetadas = comando.executeUpdate(sql);
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultorioMedico.class.getName()).log(Level.SEVERE, null, ex);
                }
                    //Date dtNascDate = DateUtil.stringToDate(dtNasc);
                //Paciente paciente = new Paciente(nome, cpf, dtNascDate);
                    /*repositorioPacientes.adicionar(paciente);
                 } catch (ParseException ex) {
                 System.out.println("Formato de data errado! Operação cancelada!");
                 }*/
                break;
            case 2:
                System.out.println("\nLista de pacientes");
                try {

                    Class.forName("org.postgresql.Driver");

                    String url = "jdbc:postgresql://localhost:5432/ConsultorioMedico";
                    Connection conexao = DriverManager.getConnection(url, "postgres", "jferraz");

                    if (conexao != null) {
                        System.out.println("conectado");

                        sql = "select id, nome, cpf, dtnasc from paciente order by id";
                        ResultSet resultado;
                        try (Statement comando = conexao.createStatement()) {
                            resultado = comando.executeQuery(sql);
                            while (resultado.next()) {
                            System.out.println("IdPaciente: " + resultado.getInt("id"));
                            System.out.println("Nome: " + resultado.getString("nome"));
                            System.out.println("CPF: " + resultado.getString("cpf"));
                            System.out.println("Data Nasc.: " + resultado.getString("dtnasc"));
                            System.out.println("---------------------------------");
                        }

                        }
                    }

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ConsultorioMedico.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultorioMedico.class.getName()).log(Level.SEVERE, null, ex);
                }

                /*if (!repositorioPacientes.temPacientes()) {
                    System.out.println("Nenhum paciente foi cadastrado!");
                } 
                else {
                    System.out.print(String.format("%-10s", "RG"));
                    System.out.print(String.format("%-20s", "NOME"));
                    System.out.println(String.format("%-10s", "NASCIMENTO"));
                    for (Paciente p : repositorioPacientes.getListaPacientes()) {
                        System.out.print(String.format("%-10s", p.getCpf()));
                        System.out.print(String.format("%-20s", p.getNome()));
                        System.out.println(String.format("%-10s", DateUtil.dateToString(p.getDtNascimento())));
                    }
                }*/
                break;
            case 3:
                System.out.println("Atualizar Paciente");
                cpf = Console.scanString("Informe o CPF: ");
                nome=Console.scanString("Informe nome: ");
                
                sql="update paciente set nome='"+nome+"' where cpf='"+cpf+"'";
                
                try {
                    try {
                        Class.forName("org.postgresql.Driver");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ConsultorioMedico.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    String url = "jdbc:postgresql://localhost:5432/ConsultorioMedico";
                    Connection conexao = DriverManager.getConnection(url, "postgres", "jferraz");
                    Statement comando;
                    comando = conexao.createStatement();
                    int linhasAfetadas = comando.executeUpdate(sql);
                    comando.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ConsultorioMedico.class.getName()).log(Level.SEVERE, null, ex);
                }
                        

                break;
            case 4:
                

                break;
            default:
                throw new AssertionError();
        }
    }

   
    public static void menuCM() {
        int op = 0;
        System.out.println("1 - Adicionar Medicamentos");
        System.out.println("2 - Visualizar todos Medicamentos");
        System.out.println("3 - Voltar");
        op = Console.scanInt("Escolha uma opção: ");
        switch (op) {
            case 1:
                
                    int cod = Console.scanInt("Código: ");
                    String med = Console.scanString("Nome Medicamento: ");
                    String descMedicamento = Console.scanString("Descrição Medicamento: ");
                    Medicamento medicamento = new Medicamento(cod, med, descMedicamento);
                    repositorioMedicamentos.adicionar(medicamento);
                break;
            case 2:
                System.out.println("\nLista de medicamentos");
                if (!repositorioMedicamentos.temMedicamentos()) {
                    System.out.println("Nenhum medicamento foi cadastrado!");
                } else {
                    System.out.print(String.format("%-10s", "Cod. "));
                    System.out.print(String.format("%-20s", "Medicamento"));
                    System.out.println(String.format("%-10s", "Desc. Medicamento"));
                    for (Medicamento m : repositorioMedicamentos.getListaMedicamentos()) {
                        System.out.print(String.format("%-10s", m.getCodMedicamento()));
                        System.out.print(String.format("%-20s", m.getMedicamento()));
                        System.out.println(String.format("%-10s", m.getDescMedicamento()));                   
                    }
                }
                break;
            case 3:
                break;
            default:
                throw new AssertionError();
        }
    }

    public static void main(String[] args) {
        // TODO code application logic here

        menuP();
    }
}

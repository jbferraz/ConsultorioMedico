package repositorio;


import model.Paciente;
import java.util.ArrayList;

/**
 *
 * @author lhries
 */
public class RepositorioPacientes {
    private ArrayList<Paciente> listaPacientes;
    
    public RepositorioPacientes(){
        listaPacientes= new ArrayList<Paciente>();        
    }
    
    public void adicionar(Paciente paciente){
        listaPacientes.add(paciente);
    }

    public ArrayList<Paciente> getListaPacientes() {
        return listaPacientes;
    }
    
    public Paciente buscarPacientePorCpf(String cpf)
    {
        for(Paciente p: listaPacientes)
        {
            if(p.getCpf().equals(cpf))
            {
                return(p);
            }
        }
        return(null);
    }
    
    public boolean existePaciente(String cpf){
        if(this.buscarPacientePorCpf(cpf)!=null)
            return true;
        else
            return false;
            
    }
    
    public Paciente buscarPacientePorNome(String nome)
    {
        for(Paciente p: listaPacientes)
        {
            if(p.getNome().equals(nome))
            {
                return(p);
            }
        }
        return(null);
    }
    
    public boolean temPacientes(){
        return !listaPacientes.isEmpty();
    }
    
}

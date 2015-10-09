package repositorio;


import model.Medicamento;
import java.util.ArrayList;

/**
 *
 * @author lhries
 */
public class RepositorioMedicamentos {
    private ArrayList<Medicamento> listaMedicamentos;
    
    public RepositorioMedicamentos(){
        listaMedicamentos= new ArrayList<Medicamento>();        
    }
    
    public void adicionar(Medicamento medicamento){
        listaMedicamentos.add(medicamento);
    }

    public ArrayList<Medicamento> getListaMedicamentos() {
        return listaMedicamentos;
    }
    
    public Medicamento buscarMedicamentoPorCod(int cod)
    {
        for(Medicamento m: listaMedicamentos)
        {
            if(m.getCodMedicamento()==(cod))
            {
                return(m);
            }
        }
        return(null);
    }
    
    public boolean existeMedicamento(int cod){
        if(this.buscarMedicamentoPorCod(cod)!=null)
            return true;
        else
            return false;
            
    }
    
    public Medicamento buscarMedicamentoPorNomeMedicamento(String NomeMedicamento)
    {
        for(Medicamento m: listaMedicamentos)
        {
            if(m.getMedicamento().equals(NomeMedicamento))
            {
                return(m);
            }
        }
        return(null);
    }
    
    public boolean temMedicamentos(){
        return !listaMedicamentos.isEmpty();
    }
    
}

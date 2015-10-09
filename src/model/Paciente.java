
package model;

import java.util.Date;

public class Paciente {
    private String nome;
    private String cpf;
    private Date DtNascimento;

    public Paciente(String nome, String cpf, Date DtNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.DtNascimento = DtNascimento;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
  
    public Date getDtNascimento() {
        return DtNascimento;
    }
    
}

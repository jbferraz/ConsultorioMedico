
package model;


public class Medicamento {
    private int codMedicamento;
    private String medicamento;
    private String descMedicamento;


    public Medicamento(int codigo, String medicamento, String desc) {
        this.codMedicamento=codigo;
        this.medicamento = medicamento;
        this.descMedicamento = desc;
    }

    public int getCodMedicamento() {
        return codMedicamento;
    }

    public String getMedicamento() {
        return medicamento;
    }


    public String getDescMedicamento() {
        return descMedicamento;
    }

}

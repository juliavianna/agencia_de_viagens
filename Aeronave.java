import java.util.ArrayList;
import java.util.List;

public class Aeronave {
    private int maximoPassageiros;
    private double maximoCarga;
    private int[] assentos = new int[6];
    private int qtdFileiras;
    private String[] fileiras = new String[qtdFileiras];
    private List<Aeronave> aeronaves = new ArrayList<>();

    public Aeronave(int maximoPassageiros, double maximoCarga, int qtdFileiras) {
        this.maximoPassageiros = maximoPassageiros;
        this.maximoCarga = maximoCarga;
        this.qtdFileiras = qtdFileiras;

        aeronaves.add(this);
    }

    public int getQtdFileiras() {
        return qtdFileiras;
    }
    public int getMaximoPassageiros() {
        return maximoPassageiros;
    }
    public double getMaximoCarga() {
        return maximoCarga;
    }
    public List<Aeronave> getAeronaves() {
        return aeronaves;
    }
    public int[] getAssentos() {
        return assentos;
    }
    public String[] getFileiras() {
        return fileiras;
    }

    public void setQtdFileiras(int qtdFileiras) {
        this.qtdFileiras = qtdFileiras;
    }
    public void setMaximoCarga(double maximoCarga) {
        this.maximoCarga = maximoCarga;
    }
    public void setMaximoPassageiros(int maximoPassageiros) {
        this.maximoPassageiros = maximoPassageiros;
    }

    /*public bool verificaDisponibilidadeTotal(){

    }*/


}

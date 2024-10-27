import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Aeronave {
    private String nome;
    private int maximoPassageiros;
    private double maximoCarga;
    private List<Aeronave> aeronaves = new ArrayList<>();
    private boolean[][] assentos;
    private HashMap<Character, Integer> fileiras = new HashMap<>();

    public Aeronave(String nome, int maximoPassageiros, double maximoCarga, int qtdFileiras) {
        this.nome = nome;
        assentos = new boolean[6][qtdFileiras];
        this.maximoPassageiros = maximoPassageiros;
        this.maximoCarga = maximoCarga;
        aeronaves.add(this);
    }

    public String getNome() {
        return nome;
    }

    public int getMaximoPassageiros() {
        return maximoPassageiros;
    }

    public double getMaximoCarga() {
        return maximoCarga;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMaximoCarga(double maximoCarga) {
        this.maximoCarga = maximoCarga;
    }

    public void setMaximoPassageiros(int maximoPassageiros) {
        this.maximoPassageiros = maximoPassageiros;
    }

    public void reservarAssento(String assento) { // 3d
        int fila = assento.charAt(0) - '0';
        int fileira = fileiras.get(assento.charAt(1));
        assentos[fila][fileira] = false; // seta pra ocupado
    }

    public void mostrarAssentosLivres() {
        int valor = 140;
        for (int i = 0; i < assentos.length; i++) {
            for (int j = 0; j < assentos[i].length; j++) {
                if (assentos[i][j] == true) {
                    System.out.println("Assento: " + i + "" + (char) valor);
                    valor++;
                }
            }
        }
    }
}

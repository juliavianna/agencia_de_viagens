
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Passagem {
    private String aeropOrigem;
    private String aeropDestino;
    private static final String moeda = "real";
    private double valorTotal;
    private double taxaComissaoAgencia= 0.09;
    public List<Voo> voos = new ArrayList<>();
    private int tipoPassagem;
    
    public Passagem(String aeropOrigem, String aeropDestino, double valorTotal){
        this.aeropOrigem= aeropOrigem;
        this.aeropDestino = aeropDestino;
        //this.moeda = moeda; //????
        this.valorTotal = valorTotal;
        //this.taxaComissaoAgencia = taxaComissaoAgencia;
    }
    
    public String getAeropOrigem() {
        return aeropOrigem;
    }

    public String getAeropDestino() {
        return aeropDestino;
    }

    public static String getMoeda() {
        return moeda;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public double getTaxaComissaoAgencia() {
        return taxaComissaoAgencia;
    }
    public int getTipoPassagem() {
        return tipoPassagem;
    }

    public void setAeropOrigem(String aeropOrigem) {
        this.aeropOrigem = aeropOrigem;
    }

    public void setAeropDestino(String aeropDestino) {
        this.aeropDestino = aeropDestino;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setTaxaComissaoAgencia(double taxaComissaoAgencia) {
        this.taxaComissaoAgencia = taxaComissaoAgencia;
    }
    public void setTipoPassagem(int tipoPassagem) {
        this.tipoPassagem = tipoPassagem;
    }

    public void adicionarVoo(Voo voo) {
        voos.add(voo); 
    }

    public void listarVoos() {
        System.out.println("Voos nessa passagem:");
        for (Voo voo : voos) {
            System.out.println(voo.getInfosVoo());
        }
    }

    public double somaValorVoos(List<Voo> voos, int tipo){ 
        double valorVoo = 0;
        if (tipo == 1){
            for (Voo voo : voos) {
                valorVoo += voo.getValorBasico();
            }
        }
        else if (tipo == 2){
            for (Voo voo : voos) {
                valorVoo += voo.getValorBusiness();
            }
        }
        else {
            for (Voo voo : voos) {
                valorVoo += voo.getValorPremium();
            }
        }
        
        return valorVoo;
    }

    public void escolherTipoPassagem(){ 
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selecione o tipo de passagem: ");
        System.out.println("1- Básica | 2- Business | 3- Premium");
        int escolha = scanner.nextInt(); 

        setTipoPassagem(escolha);
        somaValorVoos(voos, escolha);

        scanner.close();
    }
/* 

    public static void main(String[] args) {

        // Criando algumas passagens
        Passagem p1 = new Passagem("GRU", "BPS", 540.99);
        Passagem p2 = new Passagem("SDU", "GRU", 270);
        Passagem p3 = new Passagem("CNF", "FEN", 1020.00);
        
        // Adicionando as passagens em uma lista
        List<Passagem> todasPassagens = new ArrayList<>();
        todasPassagens.add(p1);
        todasPassagens.add(p2);
        todasPassagens.add(p3);
    }

 */
}

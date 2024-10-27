import java.util.ArrayList;
import java.util.List;

public class PassagemAerea {
    private String aeroportoOrigem;
    private String aeroportoDestino;
    private String dataHoraVoo;
    private String codigoVoo;
    private String companhiaAerea;
    private double tarifaBasica;
    private double tarifaBusiness;
    private double tarifaPremium;
    private double valorPrimeiraBagagem;
    private double valorBagagensAdicionais;
    private String moeda;
    private static List<PassagemAerea> passagens = new ArrayList<>();
    private List<Voo> voos;

    public PassagemAerea(String aeroportoOrigem, String aeroportoDestino, String dataHoraVoo, String companhiaAerea, double tarifaBasica, double tarifaBusiness, double tarifaPremium, double valorPrimeiraBagagem, double valorBagagensAdicionais) {
        this.aeroportoOrigem = aeroportoOrigem.toLowerCase();
        this.aeroportoDestino = aeroportoDestino.toLowerCase();
        this.dataHoraVoo = dataHoraVoo;
        this.codigoVoo = Utils.gerarCodigoVoo();
        this.companhiaAerea = companhiaAerea;
        this.tarifaBasica = tarifaBasica;
        this.tarifaBusiness = tarifaBusiness;
        this.tarifaPremium = tarifaPremium;
        this.moeda = "BRL";
        
        if(CompanhiaAerea.buscarCompanhiaAerea(companhiaAerea)== null){
            this.valorPrimeiraBagagem = 0;
            this.valorBagagensAdicionais = 0;
        }
        else{
            this.valorPrimeiraBagagem = CompanhiaAerea.buscarCompanhiaAerea(companhiaAerea).getValorPrimeiraBagagem();
            this.valorBagagensAdicionais = CompanhiaAerea.buscarCompanhiaAerea(companhiaAerea).getValorBagagensAdicionais();
        }
        
        this.voos = new ArrayList<>();

        passagens.add(this);
    }

    public void adicionarVoo(Voo voo) {
        this.voos.add(voo);
    }

    public double calcularTarifaTotal() {
        double tarifaTotal = 0;
        for (Voo voo : voos) {
            tarifaTotal += voo.getValorBasico();
        }
        return tarifaTotal;
    }

    public double calcularRemuneracaoAgencia() {
        return calcularTarifaTotal() * AgenciaDeViagem.getTaxaFixa();
    }

    public List<Voo> getVoos() {
        return voos;
    }

    public static List<PassagemAerea> getPassagens() {
        return passagens;
    }

    public String getCodigoVoo() {
        return this.codigoVoo;
    }

    public String getAeroportoOrigem() {
        return aeroportoOrigem;
    }

    public String getAeroportoDestino() {
        return aeroportoDestino;
    }

    public String getDataHoraVoo() {
        return dataHoraVoo;
    }

    public String getCompanhiaAerea() {
        return companhiaAerea;
    }

    public double getTarifaBasica() {
        return tarifaBasica;
    }

    public double getTarifaBusiness() {
        return tarifaBusiness;
    }

    public double getTarifaPremium() {
        return tarifaPremium;
    }

    public double getValorPrimeiraBagagem() {
        return CompanhiaAerea.buscarCompanhiaAerea(companhiaAerea).getValorPrimeiraBagagem();
    }

    public double getValorBagagensAdicionais() {
        CompanhiaAerea companhia = CompanhiaAerea.buscarCompanhiaAerea(companhiaAerea);
        if (companhia == null) {
            return 0;
        }
        else {
            return companhia.getValorBagagensAdicionais();
        }
    }

    public String getMoeda() {
        return moeda;
    }

    public void setAeroportoOrigem(String aeroportoOrigem) {
        this.aeroportoOrigem = aeroportoOrigem;
    }

    public void setAeroportoDestino(String aeroportoDestino) {
        this.aeroportoDestino = aeroportoDestino;
    }

    public void setDataHoraVoo(String dataHoraVoo) {
        this.dataHoraVoo = dataHoraVoo;
    }

    public void setCodigoVoo(String codigoVoo) {
        this.codigoVoo = codigoVoo;
    }

    public void setCompanhiaAerea(String companhiaAerea) {
        this.companhiaAerea = companhiaAerea;
    }

    public void setTarifaBasica(double tarifaBasica) {
        this.tarifaBasica = tarifaBasica;
    }

    public void setTarifaBusiness(double tarifaBusiness) {
        this.tarifaBusiness = tarifaBusiness;
    }

    public void setTarifaPremium(double tarifaPremium) {
        this.tarifaPremium = tarifaPremium;
    }

    public void setMoeda(String moeda) {
        this.moeda = moeda;
    }

    public static void adicionarPassagem(PassagemAerea passagemAerea) {
        passagens.add(passagemAerea);
    }

    public static String buscarPassagensIda(String origem, String destino, String dataHora) {
        List<PassagemAerea> passagensEncontradas = new ArrayList<>();
        System.out.println("---------------------------");
       // System.out.println(passagens.toString());
        for (PassagemAerea passagem : passagens) {
          //  System.out.println("AAAAAAA"+passagem);
            if (passagem.getAeroportoOrigem().equalsIgnoreCase(origem)){
                if (passagem.getAeroportoDestino().equalsIgnoreCase(destino)){
                    if (passagem.getDataHoraVoo().equals(dataHora)){
                        passagensEncontradas.add(passagem);
                        return passagensEncontradas.toString();
                        
                    }
                }
            }
            else{
                return "Nenhuma passagem encontrada";
            }
        }
        return "---------------------------";
    }

    @Override
    public String toString() {
        return "\n-----Passagem Aérea:-----" +
                "\n Origem: " + aeroportoOrigem +
                "\n Destino: " + aeroportoDestino +
                "\n Código: " + codigoVoo +
                "\n Data e Hora: " + dataHoraVoo +
                "\n Tarifa Básica: " + tarifaBasica +
                "\n Tarifa Business: " + tarifaBusiness +
                "\n Tarifa Premium: " + tarifaPremium +
                "\n Valor da Primeira Bagagem: " + getValorPrimeiraBagagem() +
                "\n Valor das Bagagens Adicionais: " + getValorBagagensAdicionais() +
                "\n Moeda: " + moeda;
    }

    public String toStringDetalhado() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nPassagem Aérea:");
        for (Voo voo : voos) {
            sb.append("\n").append(voo.getInfosVoo());
        }
        sb.append("\n Tarifa Total: ").append(calcularTarifaTotal());
        sb.append("\n Remuneração da Agência: ").append(calcularRemuneracaoAgencia());
        return sb.toString();
    }
    
}
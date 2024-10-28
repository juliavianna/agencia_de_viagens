import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Voo  {
    private String origem;
    private String destino;
    private String dtHr;
    private String codigo;
    private CompanhiaAerea companhia;
    private Aeronave aeronave;
    private double valorBasico;
    private double valorBusiness;
    private double valorPremium;
    private boolean ativo = true;
    private LocalDate dataCriacao;
    private LocalDate dataLimite;
    private static List<Voo> voos = new ArrayList<>();
    
                        
    public Voo(String origem, String destino, String dtHr, String codigo, String companhia, double valorBasico, double valorBusiness, double valorPremium, Aeronave aeronave) {
        this.origem = origem;
        this.destino = destino;
        this.dtHr = dtHr;
        this.codigo = Utils.gerarCodigoVoo();
        this.companhia = CompanhiaAerea.buscarCompanhiaAerea(companhia);
        this.valorBasico = valorBasico;
        this.valorBusiness = valorBusiness;
        this.valorPremium = valorPremium;
        this.aeronave = aeronave;
        if (aeronave == null) {
            aeronave = new Aeronave("padrao", 100, 1000, 6);
        }

        this.dataCriacao = LocalDate.now();
        this.dataLimite = dataCriacao.plusDays(30);     

        voos.add(this);
    }
    


    public Voo(){
        voos.add(this);
    }

    public void adicionarVoo(Voo voo) {
        this.voos.add(voo);
    }

    public List<Voo> getVoos() {
        return voos;
    }
        
    public String getCodigoVoo(){
        return codigo;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
}

    public String getDataHora() {
        return dtHr;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCompanhia() {
        return getCompanhia();
    }
    
    public double getValorBasico() {
        return valorBasico;
    }

    public double getValorBusiness() {
        return valorBusiness;
    }

    public double getValorPremium() {
        return valorPremium;
    }

    public int getMaximoPassageiros() {
        return aeronave.getMaximoPassageiros();
    }


    public void setDataHora(String horario) {
        this.dtHr = horario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
/* 
    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }*/
    public void setValorBasico(double valorBasico) {
        this.valorBasico = valorBasico;
    }

    public void setValorBusiness(double valorBusiness) {
        this.valorBusiness = valorBusiness;
    }

    public void setValorPremium(double valorPremium) {
        this.valorPremium = valorPremium;
    }
    
    public void inativarVoo(Voo voo) {
        LocalDate dataAtual = LocalDate.now();
        if (dataAtual.isAfter(voo.dataLimite)) {
            ativo = false;
        }
    }

    public int decrementarAssentos(Voo voo) {
        return aeronave.getMaximoPassageiros() - 1;
    }

    public static Voo buscarVoo(String codigo) {
        for (Voo voo : voos) {
            if (voo.getCodigo().toLowerCase().equals(codigo.toLowerCase())) {
                return voo;
            }
        }
        return null;
    }

    public String getInfosVoo() {
        return "Voo de " + origem + " para " + destino + " às " + dtHr;
    }



    public Object getAeronave() {
        return aeronave;
    }



}

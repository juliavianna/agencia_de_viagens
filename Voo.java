import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Voo  {
    String origem;
    String destino;
    Date dtHr;
    String codigo;
    CompanhiaAerea companhia;
    Aeronave aeronave;
    private double valorBasico;
    private double valorBusiness;
    private double valorPremium;
    private boolean ativo = true;
    private LocalDate dataCriacao;
    private LocalDate dataLimite;
    private List<Voo> voos = new ArrayList<>();
    

    public Voo(String origem, String destino, Date dtHr, String codigo, CompanhiaAerea companhia, double valorBasico, double valorBusiness, double valorPremium) {
        this.origem = origem;
        this.destino = destino;
        this.dtHr = dtHr;
        this.codigo = codigo;
        this.companhia = companhia;
        this.valorBasico = valorBasico;
        this.valorBusiness = valorBusiness;
        this.valorPremium = valorPremium;

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
    public Date getDataHora() {
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


    public void setDataHora(Date horario) {
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
    
/* 
    public Voo(String origem, String destino, String dthr, String codigo, CompanhiaAerea companhiaAerea, double valorBasico, double valorBusiness, double valorPremium){
        this.dtHr = dtHr;
        this.codigo = codigo;
        
    }
*/
    public void inativarVoo(Voo voo) {
        LocalDate dataAtual = LocalDate.now();
        if (dataAtual.isAfter(voo.dataLimite)) {
            ativo = false;
        }
    }


    public String getInfosVoo() {
        return "Voo de " + origem + " para " + destino + " às " + dtHr;
    }

}

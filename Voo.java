import java.util.Date;

public class Voo  {
    String origem;
    String destino;
    Date dtHr;
    String codigo;
    CompanhiaAerea companhia;
    private double valorBasico;
    private double valorBusiness;
    private double valorPremium;

    public Date getDataHora() {
        return dtHr;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCompanhia() {
        return companhia;
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

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }
    public void setValorBasico(double valorBasico) {
        this.valorBasico = valorBasico;
    }

    public void setValorBusiness(double valorBusiness) {
        this.valorBusiness = valorBusiness;
    }

    public void setValorPremium(double valorPremium) {
        this.valorPremium = valorPremium;
    }
    

    public Voo(String origem, String destino, String dthr, String codigo, CompanhiaAerea companhiaAerea, double valorBasico, double valorBusiness, double valorPremium){
        this.dtHr = dtHr;
        this.codigo = codigo;
        this.companhia = companhia;
    }


    public String getInfosVoo() {
        return "Voo de " + origem + " para " + destino + " às " + dtHr;
    }

}

import java.util.Date;

public class Voo  {
    Date data;
    Date horario;
    String codigo;
    String companhia;

    public Date getData() {
        return data;
    }

    public Date getHorario() {
        return horario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getCompanhia() {
        return companhia;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCompanhia(String companhia) {
        this.companhia = companhia;
    }

    public Voo(Date data, Date horario, String codigo, String companhia){
        this.data = data;
        this.horario = horario;
        this.codigo = codigo;
        this.companhia = companhia;
    }
}

import java.util.Date;

public class HistoricoVoos {
    private String cidadeDestino;
    private String cidadeOrigem;
    private Date dataSaida;
    private Date dataChegada;

    public String getCidadeDestino() {
        return cidadeDestino;
    }

    public String getCidadeOrigem() {
        return cidadeOrigem;
    }

    public Date getDataSaida() {
        return dataSaida;
    }

    public Date getDataChegada() {
        return dataChegada;
    }

    public void setCidadeDestino(String cidadeDestino) {
        this.cidadeDestino = cidadeDestino;
    }

    public void setCidadeOrigem(String cidadeOrigem) {
        this.cidadeOrigem = cidadeOrigem;
    }

    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }

    public void setDataChegada(Date dataChegada) {
        this.dataChegada = dataChegada;
    }

    public HistoricoVoos(String cidadeDestino, String cidadeOrigem, Date dataSaida, Date dataChegada){
        this.cidadeDestino = cidadeDestino;
        this.cidadeOrigem = cidadeOrigem;
        this.dataSaida = dataSaida;
        this.dataChegada = dataChegada;
    }
}

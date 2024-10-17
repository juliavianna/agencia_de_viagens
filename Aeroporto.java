import java.util.ArrayList;
import java.util.List;

public class Aeroporto  {
    private String nome;
    private String sigla;
    private String cidade;
    private String estado;
    private String pais;
    private static List<Aeroporto> aeroportos = new ArrayList<>();

    public Aeroporto(String nome, String sigla, String cidade, String estado, String pais){
        this.nome = nome;
        this.sigla = sigla;
        this.cidade = cidade;
        this.estado = estado;
        this.pais = pais;

        aeroportos.add(this);    
    }

    public String getNome() {
        return nome;
    }

    public String getSigla() {
        return sigla;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public static boolean verificaAeroporto(String sigla) {
        for (Aeroporto aeroporto : aeroportos) {
            if (aeroporto.getSigla().equals(sigla)) {
                return true;
            }
        }
        return false;
    }

    public static List<Aeroporto> getAeroportos() {
        return aeroportos;
    }
}

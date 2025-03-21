import java.util.List;

public class Produto {
    private String id;
    private String descricao;
    private double preco;
    private List<String> cores;
    private List<String> tamanhos;

    public Produto(String id, String descricao, double preco, List<String> cores, List<String> tamanhos) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.cores = cores;
        this.tamanhos = tamanhos;
    }

    public String getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public List<String> getCores() {
        return cores;
    }

    public List<String> getTamanhos() {
        return tamanhos;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id='" + id + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                ", cores=" + cores +
                ", tamanhos=" + tamanhos +
                '}';
    }
}
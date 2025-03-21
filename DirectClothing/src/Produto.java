import java.util.List;

public class Produto {
    private final String id;
    private final String descricao;
    private final double preco;
    private final List<String> cores; // Lista de cores disponíveis
    private final List<String> tamanhos; // Lista de tamanhos disponíveis

    public Produto(String id, String descricao, double preco, List<String> cores, List<String> tamanhos) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.cores = cores;
        this.tamanhos = tamanhos;
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

    public String getId() {
        return "";
    }
}
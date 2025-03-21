import java.util.HashMap;
import java.util.Map;

public class Estoque {
    private Map<String, Integer> produtosEmEstoque; // Mapa de ID do produto para quantidade

    public Estoque() {
        this.produtosEmEstoque = new HashMap<>();
    }

    public void adicionarProduto(String idProduto, int quantidade) {
        produtosEmEstoque.put(idProduto, quantidade);
    }

    public boolean verificarDisponibilidade(String idProduto, int quantidadeDesejada) {
        return produtosEmEstoque.containsKey(idProduto) && produtosEmEstoque.get(idProduto) >= quantidadeDesejada;
    }

    public void atualizarEstoque(String idProduto, int quantidadeVendida) {
        if (verificarDisponibilidade(idProduto, quantidadeVendida)) {
            produtosEmEstoque.put(idProduto, produtosEmEstoque.get(idProduto) - quantidadeVendida);
        } else {
            System.out.println("Produto " + idProduto + " não disponível em quantidade suficiente.");
        }
    }
}
import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Produto> produtos;

    public Catalogo() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void exibirCatalogo() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
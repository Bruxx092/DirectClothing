import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private final List<Produto> produtos; // Lista de Produto

    public Catalogo() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void exibirCatalogo() {
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }
}
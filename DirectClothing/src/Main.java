import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Criando produtos
        Produto camisa1 = new Produto("001", "Camisa Polo", 59.90, Arrays.asList("Azul", "Vermelho"), Arrays.asList("P", "M", "G"));
        Produto camisa2 = new Produto("002", "Camisa Social", 99.90, Arrays.asList("Branca", "Preta"), Arrays.asList("M", "G"));

        // Criando catálogo
        Catalogo catalogo = new Catalogo();
        catalogo.adicionarProduto(camisa1);
        catalogo.adicionarProduto(camisa2);

        // Exibindo catálogo
        System.out.println("==================== CATÁLOGO DE PRODUTOS ====================");
        catalogo.exibirCatalogo();
        System.out.println("=============================================================");

        // Criando cliente
        Cliente cliente = new Cliente("João Silva", "Rua das Flores, 123", "11999999999");

        // Criando vendedor (para pedidos via telefone)
        Vendedor vendedor = new Vendedor("Maria Souza", "V001");

        // Criando estoque
        Estoque estoque = new Estoque();
        estoque.adicionarProduto("001", 10);
        estoque.adicionarProduto("002", 5);

        // Pedido online
        System.out.println("\n==================== PROCESSANDO PEDIDO ONLINE ====================");
        Pedido pedidoOnline = new Pedido("P001", cliente, null, Arrays.asList(camisa1, camisa2), "Cartão de Crédito");
        processarPedido(pedidoOnline, estoque);

        // Pedido via telefone
        System.out.println("\n==================== PROCESSANDO PEDIDO VIA TELEFONE ====================");
        Pedido pedidoTelefone = new Pedido("P002", cliente, vendedor, List.of(camisa1), "Cheque");
        processarPedido(pedidoTelefone, estoque);
    }

    // Método para processar um pedido
    public static void processarPedido(Pedido pedido, Estoque estoque) {
        System.out.println("\n--------------------- DETALHES DO PEDIDO ---------------------");
        System.out.println("ID do Pedido: " + pedido.getIdPedido());
        System.out.println("Cliente: " + pedido.getCliente().getNome());
        if (pedido.getVendedor() != null) {
            System.out.println("Vendedor: " + pedido.getVendedor().getNome() + " (ID: " + pedido.getVendedor().getIdVendedor() + ")");
        } else {
            System.out.println("Vendedor: Pedido online (sem vendedor)");
        }
        System.out.println("Método de Pagamento: " + pedido.getMetodoPagamento());
        System.out.println("\nItens do Pedido:");
        for (Produto produto : pedido.getProdutos()) {
            System.out.println("- " + produto.getDescricao() + " (ID: " + produto.getId() + ")");
        }
        System.out.println("-------------------------------------------------------------");

        // Verifica disponibilidade dos produtos no estoque
        boolean disponivel = true;
        for (Produto produto : pedido.getProdutos()) {
            if (!estoque.verificarDisponibilidade(produto.getId(), 1)) {
                disponivel = false;
                System.out.println("⚠️ Produto " + produto.getId() + " (" + produto.getDescricao() + ") indisponível.");
            }
        }

        if (disponivel) {
            pedido.processarPagamento();
            pedido.enviarParaEntrega();

            // Atualiza o estoque
            for (Produto produto : pedido.getProdutos()) {
                estoque.atualizarEstoque(produto.getId(), 1);
            }
        } else {
            System.out.println("❌ Pedido não pode ser processado devido à falta de estoque.");
        }
    }
}
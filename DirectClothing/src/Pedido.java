import java.util.List;

public class Pedido {
    private final String idPedido;
    private final Cliente cliente;
    private final Vendedor vendedor; // Pode ser null para pedidos online
    private final List<Produto> produtos;
    private final String metodoPagamento;
    private boolean pago;

    public Pedido(String idPedido, Cliente cliente, Vendedor vendedor, List<Produto> produtos, String metodoPagamento) {
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.produtos = produtos;
        this.metodoPagamento = metodoPagamento;
        this.pago = false;
    }

    public void processarPagamento() {
        this.pago = true;
        System.out.println("Pagamento processado para o pedido " + idPedido);
    }

    public void enviarParaEntrega() {
        if (pago) {
            System.out.println("Pedido " + idPedido + " enviado para entrega no endereço: " + cliente.getEndereco());
        } else {
            System.out.println("Pedido " + idPedido + " aguardando pagamento.");
        }
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "idPedido='" + idPedido + '\'' +
                ", cliente=" + cliente +
                ", vendedor=" + vendedor +
                ", produtos=" + produtos +
                ", metodoPagamento='" + metodoPagamento + '\'' +
                ", pago=" + pago +
                '}';
    }

    public Produto[] getProdutos() {
        return new Produto[0];
    }
}
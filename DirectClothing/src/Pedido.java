import java.util.List;

public class Pedido {
    private String idPedido;
    private Cliente cliente; // Cliente não pode ser null
    private Vendedor vendedor; // Vendedor pode ser null (para pedidos online)
    private List<Produto> produtos;
    private String metodoPagamento;
    private boolean pago;

    public Pedido(String idPedido, Cliente cliente, Vendedor vendedor, List<Produto> produtos, String metodoPagamento) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser null.");
        }
        this.idPedido = idPedido;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.produtos = produtos;
        this.metodoPagamento = metodoPagamento;
        this.pago = false;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public boolean isPago() {
        return pago;
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
}
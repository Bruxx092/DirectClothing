public class Vendedor {
    private final String nome;
    private final String idVendedor;

    public Vendedor(String nome, String idVendedor) {
        this.nome = nome;
        this.idVendedor = idVendedor;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "nome='" + nome + '\'' +
                ", idVendedor='" + idVendedor + '\'' +
                '}';
    }
}
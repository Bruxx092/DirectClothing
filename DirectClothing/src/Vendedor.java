public class Vendedor {
    private String nome;
    private String idVendedor;

    public Vendedor(String nome, String idVendedor) {
        this.nome = nome;
        this.idVendedor = idVendedor;
    }

    public String getNome() {
        return nome;
    }

    public String getIdVendedor() {
        return idVendedor;
    }

    @Override
    public String toString() {
        return "Vendedor{" +
                "nome='" + nome + '\'' +
                ", idVendedor='" + idVendedor + '\'' +
                '}';
    }
}
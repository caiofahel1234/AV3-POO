import java.util.ArrayList;

public class Pedido {
    private Usuario usuario; // Usuário que realizou o pedido
    private ArrayList<ItemCarrinho> carrinho_de_compras; // Lista de itens comprados
    private double precoTotal; // Valor total do pedido

    // Construtor que recebe o usuário e o carrinho de compras, calcula o preço total
    public Pedido(Usuario usuario, ArrayList<ItemCarrinho> carrinho_de_compras) {
        this.usuario = usuario;
        this.carrinho_de_compras = carrinho_de_compras;
        this.precoTotal = calcularTotal(); // Calcula o total ao criar o pedido
    }

    // Método privado que soma os preços dos itens no carrinho para calcular o total do pedido
    private double calcularTotal() {
        double soma = 0;
        for (ItemCarrinho item : carrinho_de_compras) {
            soma += item.calcularPreco();
        }
        return soma;
    }

    // Método que retorna um resumo detalhado do pedido, com produtos, quantidades e total
    public String getResumoPedido() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido de ").append(usuario.getNome()).append(":\n");
        for (ItemCarrinho item : carrinho_de_compras) {
            sb.append(item.getProduto().getNome())
              .append(" x").append(item.getQuantidade())
              .append(" - R$ ").append(item.calcularPreco()).append("\n");
        }
        sb.append("Total: R$ ").append(precoTotal).append("\n");
        return sb.toString();
    }
}

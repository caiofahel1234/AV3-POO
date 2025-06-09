
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Usuario usuario;
    private ArrayList<ItemCarrinho> carrinho_de_compras;
    private double precoTotal;
    private LocalDateTime dataHora;


    public Pedido(Usuario usuario, ArrayList<ItemCarrinho> carrinho_de_compras) {
        this.usuario = usuario;
        this.carrinho_de_compras = carrinho_de_compras;
        this.dataHora = LocalDateTime.now();
        this.precoTotal = calcularTotal();
    
    }

    private double calcularTotal() {
        double soma = 0;
        for (ItemCarrinho item : carrinho_de_compras) {
            soma += item.calcularPreco();
        }
        return soma;
    }

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

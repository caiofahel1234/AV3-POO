import java.util.ArrayList;
public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private CarteiraVirtual carteira  = new CarteiraVirtual();

    ArrayList<ItemCarrinho> carrinho_de_compras = new ArrayList<>();

 
    public Usuario(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public String escolherFormaPagamento(String entrada){
        FormaPagamento formaEscolhida = FormaPagamento.NAO_CADASTRADO;
        boolean valido = false;
        while (!valido) {
         entrada = entrada.trim().toLowerCase();
        for (FormaPagamento f : FormaPagamento.values()) {
        if (f.getDescricao().equalsIgnoreCase(entrada)) {
            formaEscolhida = f;
            valido = true;
            carteira.setFormaPagamento(formaEscolhida);
            break;
        }
    }

    if (!valido) {
        return "Forma de pagamento inválida. Tente novamente.";
    }
}
 return "Você escolheu: " + formaEscolhida.getDescricao();
    }

    public void adicionarNoCarrinho(Produtos produto, Integer quantidade){
        Boolean encontrado = false;
        for(ItemCarrinho item : carrinho_de_compras){
           if(item.getProduto().getNome().equals(produto.getNome())){
            item.adicionarQuantidade(quantidade);;
            encontrado = true;
            break;
           }
        }
        if(!encontrado){
          carrinho_de_compras.add(new ItemCarrinho(produto, quantidade));  
        }
    }

    public String verCarrinho(){
        if(carrinho_de_compras.isEmpty() == true){
            return "Carrinho de compras vazio";
        }
        double precoTotal = 0.0;
        StringBuilder sb = new StringBuilder();
        
        sb.append("Itens no carrinho: \n");
        for(ItemCarrinho item : carrinho_de_compras){
            sb.append(String.format("%s,%d - R$ %.2f\n", item.getProduto().getNome(), item.getQuantidade(), item.calcularPreco()));
            precoTotal += item.calcularPreco();
        }
        sb.append(String.format("Total: %.2f", precoTotal));
        return sb.toString();

        }

    public String finalizarCompra(){
            if (carrinho_de_compras.isEmpty()) {
        return "Carrinho vazio. Adicione produtos antes de finalizar.";
    }

    Pedido pedido = new Pedido(this, carrinho_de_compras);
    return pedido.getResumoPedido();

    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public CarteiraVirtual getCarteira() {
        return carteira;
    }
    public void setCarteira(CarteiraVirtual carteira) {
        this.carteira = carteira;
    }


    @Override
    public String toString() {
        return "Cliente [id = " + id + ", nome = "  + nome + ", email = " + email + "] " + "\n" +  carteira.toString() ;
    }

}

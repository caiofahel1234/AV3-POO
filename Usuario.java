import java.util.ArrayList;
public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private CarteiraVirtual carteira  = new CarteiraVirtual();
    private ArrayList<ItemCarrinho> carrinho_de_compras = new ArrayList<>();

 
    public Usuario(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public ArrayList<ItemCarrinho> getCarrinho(){
        return carrinho_de_compras;
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


    public String adicionarNoCarrinho(Produtos produto, Integer quantidade){
        Boolean encontrado = false;

          if (quantidade == null || quantidade <= 0) {
        return "Quantidade inválida";
    }

        for(int i = 0; i<carrinho_de_compras.size(); i++){
            ItemCarrinho item = carrinho_de_compras.get(i);
             if(item.getProduto().getNome().equals(produto.getNome())){
            item.adicionarQuantidade(quantidade);;
            encontrado = true;
            break;
           }
        }

          if(!encontrado){
          carrinho_de_compras.add(new ItemCarrinho(produto, quantidade));  
        }
         return "Adicionado com sucesso";
    }


    public String removerDoCarrinho(ItemCarrinho item, Integer quantidade){

          if (quantidade == null || quantidade <= 0) {
        return "Quantidade inválida";
    }
        Boolean encontrado = false;

        for(int i = 0; i<carrinho_de_compras.size(); i++){
            ItemCarrinho itens = carrinho_de_compras.get(i);
            if(item.getProduto().getNome().equals(itens.getProduto().getNome())){
                if(quantidade >= itens.getQuantidade()){
                    carrinho_de_compras.remove(itens);
            }else{
                itens.removerQuantidade(quantidade);;
            }
            encontrado = true;
            break;
           }
        }

        if(!encontrado){
            return "Produto não encontrado!";
        }
         return "Removido com sucesso";
    }


    public String verCarrinho(){
        if(carrinho_de_compras.isEmpty() == true){
            return "Carrinho de compras vazio";

        }
        double precoTotal = 0.0;
        int contador = 1;
        StringBuilder sb = new StringBuilder();
        
        sb.append("Itens no carrinho: \n");
        for(ItemCarrinho item : carrinho_de_compras){
            sb.append(String.format("%d- %s,%d - R$ %.2f\n", contador, item.getProduto().getNome(), item.getQuantidade(), item.calcularPreco()));
            precoTotal += item.calcularPreco();
            contador++;
        }
        sb.append(String.format("Total: %.2f", precoTotal));
        return sb.toString();

        }


    public String finalizarCompra(){
            if (carrinho_de_compras.isEmpty()) {
        return "Carrinho vazio. Adicione produtos antes de finalizar.";
    }

    Pedido pedido = new Pedido(this, carrinho_de_compras);
     carrinho_de_compras.clear();
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

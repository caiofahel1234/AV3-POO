public class ItemCarrinho implements GerenciavelNoCarrinho {
    private Produtos produto;       // Produto que está neste item do carrinho de compras
    private Integer quantidade;     // Quantidade deste produto no carrinho de compras

    // Construtor que recebe o produto e a quantidade inicial
    public ItemCarrinho(Produtos produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    // Getters e setters padrão para produto e quantidade
    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    // Implementação do método da interface que calcula o preço total deste item
    @Override
    public Double calcularPreco(){
        return produto.getPreco() * quantidade;
    }

    // Incrementa a quantidade deste item no carrinho
    @Override
    public void adicionarQuantidade(int quantidade){
        this.quantidade += quantidade;
    }

    // Diminui a quantidade deste item no carrinho
    @Override
    public void removerQuantidade(int quantidade){
        this.quantidade -= quantidade;
    }
}

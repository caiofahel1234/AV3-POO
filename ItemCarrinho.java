public class ItemCarrinho implements GerenciavelNoCarrinho {
    private Produtos produto;
    private Integer quantidade;

    public ItemCarrinho(Produtos produto, Integer quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

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
    @Override
    public Double calcularPreco(){
        return produto.getPreco() * quantidade;
    }
    @Override
    public void adicionarQuantidade(int quantidade){

    }
    @Override
    public void removerQuantidade(int quantidade){

    }
    

    

}

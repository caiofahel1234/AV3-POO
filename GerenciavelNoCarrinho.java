public interface GerenciavelNoCarrinho {
    void adicionarQuantidade(int quantidade);
    void removerQuantidade(int quantidade);
    Integer getQuantidade();
    Double calcularPreco();
}


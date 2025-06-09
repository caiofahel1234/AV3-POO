public interface GerenciavelNoCarrinho {
    void adicionarQuantidade(int quantidade);  // Adiciona uma quantidade ao item
    void removerQuantidade(int quantidade);   // Remove uma quantidade do item
    Integer getQuantidade();                   // Retorna a quantidade atual do item
    Double calcularPreco();                    // Calcula o preço total do item (quantidade * preço unitário)
}

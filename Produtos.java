public abstract class Produtos {
    private Integer id;           // Identificador único do produto
    private String nome;          // Nome do produto
    private String descricao;     // Descrição do produto
    private Double preco;         // Preço do produto
    
    // Construtor para inicializar os atributos do produto
    public Produtos(Integer id, String nome, String descricao, Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    // Getters e setters para acessar e modificar os atributos
    
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    // Método toString sobrescrito para retornar uma representação legível do produto
    @Override
    public String toString() {
        return "Produtos [ id = " + id + ", nome = " + nome + ", descricao = " + descricao
                + ", preco = " + preco + " R$" + "]";
    }
}

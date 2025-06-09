public class Bebidas extends Produtos {
    private Boolean alcoolica; // Indica se a bebida é alcoólica (true) ou não (false)

    // Construtor que inicializa os atributos da classe pai e o atributo especifico
    public Bebidas(Integer id, String nome, String descricao, Double preco, Boolean alcoolica) {
        super(id, nome, descricao, preco); // Inicializa os atributos herdados
        this.alcoolica = alcoolica;         // Inicializa o atributo alcoolica
    }

    // Getter para verificar se a bebida é alcoólica
    public Boolean getAlcoolica() {
        return alcoolica;
    }

    // Setter para definir se a bebida é alcoólica
    public void setAlcoolica(Boolean alcoolica) {
        this.alcoolica = alcoolica;
    }
    
    // Sobrescreve o método toString para incluir informação sobre álcool
    @Override
    public String toString() {
        return super.toString() + ", alcoolica = " + (alcoolica ? "Sim" : "Não");
    }
}

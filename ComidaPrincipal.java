public class ComidaPrincipal extends Produtos {
    private Boolean vegetariano;    // Indica se o prato é vegetariano (true/false)
    private Integer tempoPreparo;   // Tempo estimado para preparo do prato, em minutos
    
    // Construtor que inicializa os atributos da classe pai (Produtos) e os novos atributos específicos
    public ComidaPrincipal(Integer id, String nome, String descricao, Double preco,
            Boolean vegetariano, Integer tempoPreparo) {
        super(id, nome, descricao, preco);  // Inicializa os atributos herdados
        this.vegetariano = vegetariano;     // Inicializa se é vegetariano ou não
        this.tempoPreparo = tempoPreparo;   // Inicializa o tempo de preparo
    }

    // Getter para verificar se o prato é vegetariano
    public Boolean getVegetariano() {
        return vegetariano;
    }

    // Setter para definir se o prato é vegetariano
    public void setVegetariano(Boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    // Getter do tempo estimado de preparo
    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    // Setter para definir o tempo estimado de preparo
    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }
}

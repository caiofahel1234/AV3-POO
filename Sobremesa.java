public class Sobremesa extends Produtos {
    private Boolean contemAcucar; // Indica se a sobremesa contém açúcar (true/false)

    // Construtor que inicializa os atributos da classe pai e o atributo específico
    public Sobremesa(Integer id, String nome, String descricao, Double preco, boolean contemAcucar) {
        super(id, nome, descricao, preco);  // Inicializa os atributos herdados
        this.contemAcucar = contemAcucar;   // Inicializa o atributo contemAcucar
    }

    // Getter que indica se a sobremesa contém açúcar
    public boolean isContemAcucar() {
        return contemAcucar;
    }

    // Setter para definir se a sobremesa contém açúcar
    public void setContemAcucar(boolean contemAcucar) {
        this.contemAcucar = contemAcucar;
    }
}

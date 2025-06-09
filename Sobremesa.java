public class Sobremesa extends Produtos {
    private Boolean contemAcucar;

    public Sobremesa(Integer id, String nome, String descricao, Double preco, boolean contemAcucar) {
        super(id, nome, descricao, preco);
        this.contemAcucar = contemAcucar;
    }

    public boolean isContemAcucar() {
        return contemAcucar;
    }

    public void setContemAcucar(boolean contemAcucar) {
        this.contemAcucar = contemAcucar;
    }

    
}

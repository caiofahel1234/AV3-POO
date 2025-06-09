public class Bebidas extends Produtos {
    private Boolean alcoolica;


    public Bebidas(Integer id, String nome, String descricao, Double preco, Boolean alcoolica) {
        super(id, nome, descricao, preco);
        this.alcoolica = alcoolica;
    }

    public Boolean getAlcoolica() {
        return alcoolica;
    }

    public void setAlcoolica(Boolean alcoolica) {
        this.alcoolica = alcoolica;
    }


    
}

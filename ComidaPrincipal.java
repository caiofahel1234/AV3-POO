public class ComidaPrincipal extends Produtos {
    private Boolean vegetariano;
    private Integer tempoPreparo;
    
    public ComidaPrincipal(Integer id, String nome, String descricao, Double preco,
            Boolean vegetariano, Integer tempoPreparo) {
        super( id, nome, descricao, preco);
        this.vegetariano = vegetariano;
        this.tempoPreparo = tempoPreparo;
    }

    public Boolean getVegetariano() {
        return vegetariano;
    }

    public void setVegetariano(Boolean vegetariano) {
        this.vegetariano = vegetariano;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    



    
}

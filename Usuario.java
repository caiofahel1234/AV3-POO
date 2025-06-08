import java.util.ArrayList;
public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private CarteiraVirtual carteira;

    ArrayList<Produtos> carrinho_de_compras = new ArrayList<>();

 
    public Usuario(Integer id, String nome, String email, CarteiraVirtual carteira) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.carteira = new CarteiraVirtual();
    }


    public void finalizarCompra(){

    }

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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public CarteiraVirtual getCarteira() {
        return carteira;
    }
    public void setCarteira(CarteiraVirtual carteira) {
        this.carteira = carteira;
    }


    @Override
    public String toString() {
        return "Cliente [id = " + id + ", nome = "  + nome + ", email = " + email + "] " + "\n" +  carteira.toString() ;
    }


}

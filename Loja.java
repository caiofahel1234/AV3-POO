import java.util.ArrayList;
import java.util.Comparator;

public class Loja {
    private ArrayList<Produtos> catalogo = new ArrayList<>();

    public Loja() {
        // Inicializa a lista com diversos produtos: ComidaPrincipal, Sobremesa, Bebidas
        catalogo.add(new ComidaPrincipal(5, "Hambúrguer Artesanal", "Hambúrguer com queijo, bacon e molho especial", 28.0, false, 20));
        catalogo.add(new ComidaPrincipal(1, "Lasanha Bolonhesa", "Lasanha com carne e queijo", 25.0, false, 30));
        catalogo.add(new ComidaPrincipal(2, "Salada Caesar", "Salada com alface e frango", 18.0, true, 10));
        catalogo.add(new Sobremesa(3, "Pudim de Leite", "Pudim cremoso", 8.0, true));
        catalogo.add(new Sobremesa(9, "Sorvete Diet", "Sorvete sem açúcar, sabor baunilha", 15.0, false));
        catalogo.add(new Bebidas(15, "Suco de Laranja", "Suco natural de laranja", 7.0, false));
        catalogo.add(new Bebidas(4, "Vinho branco", "Vinho branco suave", 12.0, true));
    }

    public String mostrarCatalogo() {
        // Ordena o catálogo pelo preço em ordem crescente
        catalogo.sort(Comparator.comparingDouble(Produtos::getPreco));
        
        StringBuilder sb = new StringBuilder();
        sb.append("Catalogos de produtos\n");
        
        int contador = 1;
        for (Produtos produtos : catalogo) {
            // Aqui, chama o toString() de cada produto para mostrar detalhes. 
            sb.append(String.format("%d - ", contador)).append(produtos.toString()).append("\n");
            contador++;
        }
        return sb.toString();
    }

    public ArrayList<Produtos> getCatalogo() {
        // Retorna a lista de produtos
        return catalogo;
    }
}

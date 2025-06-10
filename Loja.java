
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

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

    public ArrayList<Produtos> mostrarCatalogo() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Produtos> listaOrdenada = new ArrayList<>(catalogo); // Cópia da lista original

        int opcao = 0;

        do {
            System.out.println();
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ 1 - Ordenação Crescente de Preço   ║");
            System.out.println("║ 2 - Ordenação Decrescente de Preço ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.println();
            System.out.printf("Escolha um número: ");

            opcao = sc.nextInt();
            sc.nextLine();
        } while (opcao != 1 && opcao != 2);

        if (opcao == 1) {
            listaOrdenada.sort(Comparator.comparingDouble(Produtos::getPreco)); //Ordena em ordem crescente de preços
        } else {
            listaOrdenada.sort(Comparator.comparingDouble(Produtos::getPreco).reversed()); //Ordena em ordem decrescente de preços
        }

        System.out.println("Catálogo de produtos:"); //Imprime o catalogo
        int contador = 1;
        for (Produtos produto : listaOrdenada) {
            System.out.printf("%d - %s\n", contador++, produto.toString());
        }

        return listaOrdenada;
    }

    public ArrayList<Produtos> getCatalogo() {
        // Retorna a lista de produtos
        return catalogo;
    }
}

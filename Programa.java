import java.util.ArrayList;
import java.util.Scanner;
public class Programa
{
	public static void main(String[] args) {
		ArrayList<Produtos> catalogo = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		Loja loja = new Loja();

		catalogo = loja.getCatalogo();
	

		System.out.println();
		System.out.println("BEM VINDO A LOJA!!!");

		System.out.println("Qual o seu nome?");
		String nome = sc.nextLine();
		System.out.println("Qual o seu ID?");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Qual o seu email?");
		String email = sc.nextLine();

Usuario c = new Usuario(id, nome, email);

	System.out.println();
System.out.println("╔════════════════════════════════════╗");
System.out.println("║             M E N U                ║");
System.out.println("╠════════════════════════════════════╣");
System.out.println("║ 1 - Adicionar saldo                ║");
System.out.println("║ 2 - Retirar saldo                  ║");
System.out.println("║ 3 - Adicionar forma de pagamento   ║");
System.out.println("║ 4 - Adicionar produtos ao carrinho ║");
System.out.println("║ 5 - Remover produtos do carrinho   ║");
System.out.println("║ 6 - Finalizar o pedido             ║");
System.out.println("║ 7 - Ver o carrinho de compras      ║");
System.out.println("║ 8 - Ver dados da conta             ║");
System.out.println("║ 9 - Sair                           ║");
System.out.println("╚════════════════════════════════════╝");
System.out.println();

int opcao = 0;
do{

System.out.printf("Escolha um número: ");
 opcao = sc.nextInt();
sc.nextLine();

if(opcao == 1){
	System.out.println("Qual o valor que gostaria de adicionar no saldo?");
	double valor = sc.nextDouble();
	c.getCarteira().adicionarSaldo(valor);
	System.out.println();
}else if(opcao == 2){
	System.out.println("Qual o valor que gostaria de retirar do saldo?");
	double valor = sc.nextDouble();
	c.getCarteira().descontarSaldo(valor);
	System.out.println();
}else if(opcao == 3){
System.out.print("Digite a forma de pagamento (ex: pix, cartao de credito): ");
String entrada = sc.nextLine();
System.out.println(c.escolherFormaPagamento(entrada));
System.out.println();
}else if(opcao == 4){
	System.out.println(loja.mostrarCatalogo());
	System.out.print("Escolha o número do produto: ");
    int escolha = sc.nextInt();

    while (escolha < 1 || escolha > catalogo.size()) {
        System.out.println("Opção inválida. Tente novamente");
        escolha = sc.nextInt();
    }

    Produtos escolhido = catalogo.get(escolha - 1);

	System.out.print("Digite a quantidade de produtos: ");
	int quantidade = sc.nextInt();

	c.adicionarNoCarrinho(escolhido, quantidade);

	System.out.println();
}else if(opcao == 5){
	System.out.println(c.verCarrinho());
	if(!c.getCarrinho().isEmpty()){
	System.out.print("Escolha o número do produto: ");
    int escolha = sc.nextInt();

    while (escolha < 1 || escolha > c.getCarrinho().size()) {
        System.out.println("Opção inválida. Tente novamente");
        escolha = sc.nextInt();
    }

    ItemCarrinho escolhido = c.getCarrinho().get(escolha - 1);

	System.out.print("Digite a quantidade de produtos: ");
	int quantidade = sc.nextInt();

	c.removerDoCarrinho(escolhido, quantidade);
	}

	System.out.println();
}else if(opcao == 6){
	System.out.println(c.finalizarCompra());
	System.out.println();
}else if(opcao == 7){
System.out.println(c.verCarrinho());
System.out.println();
}else if(opcao == 8){
	System.out.println(c.toString());
	System.out.println();
}else if(opcao == 9){
	System.out.println("Saindo....");
}else{
	System.out.println("Escolha invalida. Tente outra vez");
	opcao = sc.nextInt();
}

  }while(opcao!=9);

  sc.close();
}
}
import java.util.ArrayList;
import java.util.Scanner;
public class Programa
{
	public static void main(String[] args) {
		ArrayList<Produtos> carrinho_de_compras = new ArrayList<>();
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("BEM VINDO A LOJA!!!");

		System.out.println("Qual o seu nome?");
		String nome = sc.nextLine();
		System.out.println("Qual o seu ID?");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Qual o seu email?");
		String email = sc.nextLine();

Usuario c = new Usuario(id, nome, email, null);

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

System.out.printf("Escolha um número: ");
int opcao = sc.nextInt();
sc.nextLine();

if(opcao == 1){
	System.out.println("Qual o valor que gostaria de adicionar no saldo? ");
	double valor = sc.nextDouble();
	c.getCarteira().setSaldo(c.getCarteira().getSaldo() + valor);
}else if(opcao == 2){
	System.out.println("Qual o valor que gostaria de retirar do saldo? ");
	double valor = sc.nextDouble();
	c.getCarteira().setSaldo(c.getCarteira().getSaldo() - valor);
}else if(opcao == 3){
FormaPagamento formaEscolhida = FormaPagamento.NAO_CADASTRADO;
boolean valido = false;
while (!valido) {
    System.out.print("Digite a forma de pagamento (ex: pix, cartao de credito): ");
    String entrada = sc.nextLine().trim().toLowerCase();

    for (FormaPagamento f : FormaPagamento.values()) {
        if (f.getDescricao().equalsIgnoreCase(entrada)) {
            formaEscolhida = f;
            valido = true;
            break;
        }
    }

    if (!valido) {
        System.out.println("Forma de pagamento inválida. Tente novamente.");
    }
}
System.out.println("Você escolheu: " + formaEscolhida.getDescricao());
}else if(opcao == 4){
	
}else if(opcao == 5){
	
}else if(opcao == 6){
	
}else if(opcao == 7){

}else if(opcao == 8){
	System.out.println(c.toString());
}else if(opcao == 9){
	
}else{
	System.out.println("Escolha invalida. Tente outra vez");
}




		    }
}
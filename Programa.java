
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {

    public static void main(String[] args) {
        ArrayList<Produtos> catalogo = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        Loja loja = new Loja();

        catalogo = loja.getCatalogo();
        // Pega a lista de produtos da loja. A Loja já tem um catálogo inicializado.

        System.out.println();
        System.out.println("BEM VINDO A LOJA!!!");

        // Pede dados do usuário via console
        System.out.println("Qual o seu nome?");
        String nome = sc.nextLine();
        System.out.println("Qual o seu ID?");
        int id = sc.nextInt();
        sc.nextLine();
        // Consumir o '\n' que fica após nextInt para não quebrar o próximo nextLine

        System.out.println("Qual o seu email?");
        String email = sc.nextLine();

        Usuario usuario = new Usuario(id, nome, email);
        // Cria um objeto Usuario com os dados informados

        int opcao = 0;
        do {
            // Menu fixo exibido para o usuário
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
            opcao = sc.nextInt();
            sc.nextLine();
            // Lê a opção do usuário, depois consome o '\n' deixado pelo nextInt()

            if (opcao == 1) {
                System.out.println("Qual o valor que gostaria de adicionar no saldo?");
                double valor = sc.nextDouble();
                System.out.println(usuario.getCarteira().adicionarSaldo(valor));
                System.out.println();
                // Adiciona saldo à carteira do usuário e imprime o resultado (presumivelmente uma mensagem)
            } else if (opcao == 2) {
                System.out.println("Qual o valor que gostaria de retirar do saldo?");
                double valor = sc.nextDouble();
                System.out.println(usuario.getCarteira().descontarSaldo(valor));
                System.out.println();
                // Retira saldo da carteira e imprime o resultado
            } else if (opcao == 3) {
                System.out.print("Digite a forma de pagamento (ex: pix, cartao de credito): ");
                String entrada = sc.nextLine();
                System.out.println(usuario.escolherFormaPagamento(entrada));
                System.out.println();
                // Adiciona uma forma de pagamento e exibe resultado
            } else if (opcao == 4) {
                ArrayList<Produtos> catalogoOrdenado = loja.mostrarCatalogo(); // Puxa a lista do catalogo de acordo com ordenação
                System.out.print("Escolha o número do produto: ");
                int escolha = sc.nextInt();

                while (escolha < 1 || escolha > catalogoOrdenado.size()) { //Valida se o usuáro digitou valor válido
                    System.out.println("Opção inválida. Tente novamente");
                    escolha = sc.nextInt();
                }

                Produtos escolhido = catalogoOrdenado.get(escolha - 1); //Seleciona o produto

                System.out.print("Digite a quantidade de produtos: ");
                int quantidade = sc.nextInt();

                usuario.adicionarNoCarrinho(escolhido, quantidade);
                // Adiciona o produto selecionado ao carrinho do usuário com a quantidade informada

                System.out.println();
            } else if (opcao == 5) {
                System.out.println(usuario.verCarrinho());
                if (!usuario.getCarrinho().isEmpty()) {
                    System.out.print("Escolha o número do produto: ");
                    int escolha = sc.nextInt();

                    while (escolha < 1 || escolha > usuario.getCarrinho().size()) {
                        System.out.println("Opção inválida. Tente novamente");
                        escolha = sc.nextInt();
                    }

                    ItemCarrinho escolhido = usuario.getCarrinho().get(escolha - 1);

                    System.out.print("Digite a quantidade de produtos: ");
                    int quantidade = sc.nextInt();

                    usuario.removerDoCarrinho(escolhido, quantidade);
                    // Remove a quantidade especificada do produto escolhido no carrinho
                }

                System.out.println();
            } else if (opcao == 6) {
                System.out.println(usuario.finalizarCompra());
                System.out.println();
                // Finaliza a compra e imprime o resultado do pedido
            } else if (opcao == 7) {
                System.out.println(usuario.verCarrinho());
                System.out.println();
                // Mostra os produtos no carrinho
            } else if (opcao == 8) {
                System.out.println(usuario.toString());
                System.out.println();
                // Mostra os dados da conta do usuário 
            } else if (opcao == 9) {
                System.out.println("Saindo....");
                // Sai do loop e encerra o programa
            } else {
                System.out.println("Escolha invalida. Tente outra vez");
                // Caso digite uma opção inválida, avisa e volta para pedir de novo
                // *Detalhe:* aqui poderia melhorar para evitar bugs (ex: repetir leitura)
            }
        } while (opcao != 9);

        sc.close();
        // Fecha o scanner para liberar recurso do sistema
    }
}

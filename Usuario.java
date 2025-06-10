import java.util.ArrayList;

public class Usuario {
    private Integer id;
    private String nome;
    private String email;
    private CarteiraVirtual carteira  = new CarteiraVirtual();
    private ArrayList<ItemCarrinho> carrinho_de_compras = new ArrayList<>();
    // Declara os atributos principais:
    // carteira virtual para controle financeiro,
    // carrinho de compras que guarda os itens que o usuário quer comprar.

    // Construtor recebe os dados básicos para criar um usuário
    public Usuario(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    // Retorna a lista de itens do carrinho (permite acesso para outras classes)
    public ArrayList<ItemCarrinho> getCarrinho(){
        return carrinho_de_compras;
    }

    // Método para o usuário escolher forma de pagamento passando a string da forma (ex: "pix")
    public String escolherFormaPagamento(String entrada){
        FormaPagamento formaEscolhida = FormaPagamento.NAO_CADASTRADO;
        boolean valido = false;

        // Enquanto não for válido, tenta encontrar correspondência na enum FormaPagamento
        while (!valido) {
            entrada = entrada.trim().toLowerCase(); // limpa espaços e padroniza minuscula
            
            // Percorre todas as formas disponíveis para comparar
            for (FormaPagamento f : FormaPagamento.values()) {
                if (f.getDescricao().equalsIgnoreCase(entrada)) {
                    formaEscolhida = f;
                    valido = true;
                    carteira.setFormaPagamento(formaEscolhida); // define na carteira
                    break;
                }
            }

            if (!valido) {
                return "Forma de pagamento inválida. Tente novamente.";
                // Se não encontrar forma válida, retorna mensagem e sai do método.
            }
        }
        // Retorna confirmação da forma escolhida
        return "Você escolheu: " + formaEscolhida.getDescricao();
    }

    // Adiciona produto e quantidade ao carrinho
    public String adicionarNoCarrinho(Produtos produto, Integer quantidade){
        Boolean encontrado = false;

        // Verifica se quantidade é válida
        if (quantidade == null || quantidade <= 0) {
            return "Quantidade inválida";
        }

        // Procura no carrinho se já existe o produto para apenas somar a quantidade
        for(int i = 0; i < carrinho_de_compras.size(); i++){
            ItemCarrinho item = carrinho_de_compras.get(i);
            if(item.getProduto().getNome().equals(produto.getNome())){
                item.adicionarQuantidade(quantidade);
                encontrado = true;
                break;
            }
        }

        // Se não encontrou, cria um novo item e adiciona na lista
        if(!encontrado){
            carrinho_de_compras.add(new ItemCarrinho(produto, quantidade));  
        }
        return "Adicionado com sucesso";
    }

    // Remove uma quantidade de um item do carrinho
    public String removerDoCarrinho(ItemCarrinho item, Integer quantidade){

        if (quantidade == null || quantidade <= 0) {
            return "Quantidade inválida";
        }
        Boolean encontrado = false;

        // Percorre o carrinho para achar o item com o mesmo produto
        for(int i = 0; i < carrinho_de_compras.size(); i++){
            ItemCarrinho itens = carrinho_de_compras.get(i);
            if(item.getProduto().getNome().equals(itens.getProduto().getNome())){
                if(quantidade >= itens.getQuantidade()){
                    // Se quer remover igual ou mais do que tem, remove o item do carrinho
                    carrinho_de_compras.remove(itens);
                } else {
                    // Caso contrário, diminui a quantidade do item
                    itens.removerQuantidade(quantidade);
                }
                encontrado = true;
                break;
            }
        }

        if(!encontrado){
            return "Produto não encontrado!";
        }
        return "Removido com sucesso";
    }

    // Mostra os itens do carrinho e o preço total
    public String verCarrinho(){
        if(carrinho_de_compras.isEmpty() == true){
            return "Carrinho de compras vazio";
        }
        double precoTotal = 0.0;
        int contador = 1;
        StringBuilder sb = new StringBuilder();

        sb.append("Itens no carrinho: \n");
        // Percorre todos os itens do carrinho e formata a saída
        for(ItemCarrinho item : carrinho_de_compras){
            sb.append(String.format("%d- %s, Quantidade: %d - Subtotal: R$ %.2f\n", 
                contador, 
                item.getProduto().getNome(), 
                item.getQuantidade(), 
                item.calcularPreco()));
            precoTotal += item.calcularPreco();
            contador++;
        }
        sb.append(String.format("Total: %.2f", precoTotal));
        return sb.toString();
    }

    // Finaliza a compra, gera o pedido e limpa o carrinho
    public String finalizarCompra(){
        if (carrinho_de_compras.isEmpty()) {
            return "Carrinho vazio. Adicione produtos antes de finalizar.";
        }

        Pedido pedido = new Pedido(this, new ArrayList<>(carrinho_de_compras));
        carrinho_de_compras.clear();
        // Cria um pedido com os itens atuais do carrinho e depois esvazia o carrinho

        return pedido.getResumoPedido(); 
        // Retorna um resumo (string) do pedido finalizado
    }

    // Métodos get/set padrão para os atributos da classe
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

    // Método para facilitar a impressão do objeto Usuario como string (id, nome, email e carteira)
    @Override
    public String toString() {
        return "Cliente [id = " + id + ", nome = "  + nome + ", email = " + email + "] " + "\n" +  carteira.toString() ;
    }
}

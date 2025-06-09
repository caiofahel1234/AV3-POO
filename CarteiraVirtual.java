public class CarteiraVirtual {
    // Atributo que armazena o saldo disponível na carteira
    private Double saldo;
    // Atributo que guarda a forma de pagamento escolhida pelo usuário
    private FormaPagamento formaPagamento;

    // Construtor padrão inicializa saldo como 0 e forma de pagamento como não cadastrada
    public CarteiraVirtual() {
        this.saldo = 0.0;
        this.formaPagamento = FormaPagamento.NAO_CADASTRADO;
    }

    // Método para adicionar valor ao saldo da carteira
    public String adicionarSaldo(double valor) {
        if(valor < 0){
            // Não permite adicionar valores negativos
            return "Valor invalido";
        }
        // Soma o valor ao saldo atual
        saldo = this.saldo + valor;
        return "Valor adicionado com sucesso";
    }

    // Método para descontar valor do saldo da carteira
    public String descontarSaldo(double valor) {
        if(valor < 0){
            // Não permite valores negativos para desconto
            return "Valor invalido";
        } else if(valor > this.saldo){
            // Verifica se o saldo é suficiente para realizar o desconto
            return "Valor maior que o saldo existente";
        }
        // Subtrai o valor do saldo atual
        saldo = this.saldo - valor;
        return "Valor retirado com sucesso";
    }

    // Getter para saldo
    public Double getSaldo() {
        return saldo;
    }

    // Setter para saldo (atenção: não há validação aqui, cuidado ao usar diretamente)
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    // Getter para forma de pagamento
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    // Setter para forma de pagamento
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    // Método toString para representar a carteira em formato texto
    @Override
    public String toString() {
        return "CarteiraVirtual [saldo = " + saldo + " R$" + ", formaPagamento = " + formaPagamento.getDescricao() + "]";
    }
}

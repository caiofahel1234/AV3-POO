public enum FormaPagamento {
    // Valores possíveis da enumeração com suas descrições correspondentes
    NAO_CADASTRADO("não cadastrado"),   // Valor padrão quando não há forma cadastrada
    PIX("pix"),                         // Forma de pagamento via Pix
    CARTAO_DEBITO("cartao de debito"), // Pagamento com cartão de débito
    CARTAO_CREDITO("cartao de credito"), // Pagamento com cartão de crédito
    DINHEIRO("dinheiro");               // Pagamento em dinheiro

    // Atributo que armazena a descrição da forma de pagamento
    private String descricao;

    // Construtor da enum que associa a descrição a cada constante
    FormaPagamento(String descricao){
        this.descricao = descricao;
    }

    // Método getter para acessar a descrição da forma de pagamento
    public String getDescricao(){
        return descricao;
    }
}

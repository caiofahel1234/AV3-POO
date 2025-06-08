public enum FormaPagamento {
    NAO_CADASTRADO("não cadastrado"),
    PIX("pix"),
    CARTAO_DEBITO("cartao de debito"),
    CARTAO_CREDITO("cartao de credito"),
    DINHEIRO("dinheiro");

    private String descricao;

    FormaPagamento(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao(){
        return descricao;
    }

}

public class CarteiraVirtual {
    private Double saldo;
    private FormaPagamento formaPagamento;

    
    public CarteiraVirtual() {
        this.saldo = 0.0;
        this.formaPagamento = FormaPagamento.NAO_CADASTRADO;
    }

    public void adicionarSaldo(double valor) {
        saldo = this.saldo + valor;
    }

    
    public void descontarSaldo(double valor) {
        if(valor > saldo){
            saldo = 0.0;
        }
        saldo = this.saldo - valor;
    }

    public Double getSaldo() {
        return saldo;
    }
    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    @Override
    public String toString() {
        return "CarteiraVirtual [saldo = " + saldo + ", formaPagamento = " + formaPagamento.getDescricao() + "]";
    }
    



}

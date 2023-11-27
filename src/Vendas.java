import java.time.LocalDate;

public class Vendas {
    private String qtd;
    private double valor;
    private String item;
    private LocalDate hora;
    private String pagamento;

    public Vendas(String qtd, double valor, String item, LocalDate hora, String pagamento){
        setQtd(qtd);
        setValor(valor);
        setItem(item);
        setHora(hora);
        setPagamento(pagamento);
    }
    public void listar(){
        System.out.println("------------");
        System.out.println("Momento da compra: " + this.getHora());
        System.out.println("Itens: " + this.getItem());
        System.out.println("Quantidade: " + this.getQtd());
        System.out.println("Total: " + this.getValor());
        System.out.println("Método de pagamento: " + this.getPagamento());
        System.out.println("-------------------");
    }

    public void setQtd(String qtd){
        this.qtd = qtd;
    }
    public String getQtd(){
        return qtd;
    }
    public void setValor(double valor){
        this.valor = valor;
    }
    public double getValor(){
        return valor;
    }
    public void setItem(String item){
        this.item = item;
    }
    public String getItem(){
        return item;
    }
    public void setHora(LocalDate hora){
        this.hora = hora;
    }
    public LocalDate getHora(){
        return hora;
    }
    public void setPagamento(String pagamento){
        this.pagamento = pagamento;
    }
    public String getPagamento(){
        return pagamento;
    }
}

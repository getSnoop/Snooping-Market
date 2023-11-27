import java.time.LocalDate;

public class Vendas {
    private String qtd;
    private double valor;
    private String item;
    private LocalDate data;
    private String pagamento;

    public Vendas(String qtd, double valor, String item, LocalDate data, String pagamento){
        setQtd(qtd);
        setValor(valor);
        setItem(item);
        setData(data);
        setPagamento(pagamento);
    }
    public void listar(){
        System.out.println("------------");
        System.out.println("Momento da compra: " + this.getData());
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
    public void setData(LocalDate data){
        this.data = data;
    }
    public LocalDate getData(){
        return data;
    }
    public void setPagamento(String pagamento){
        this.pagamento = pagamento;
    }
    public String getPagamento(){
        return pagamento;
    }
}

public class Produtos {
    private String nome;
    private double valor;
    private int unidades;
    private int codigo;
    private String categoria;

    public Produtos(String n, double v, int u, int c, String ca){
        this.setNome(n);
        this.setValor(v);
        this.setUnidades(u);
        this.setCodigo(c);
        this.setCategoria(ca);
    }

    public void listar(){
        System.out.println("-----" + this.getNome() + "-----");
        System.out.println("Valor: " + this.getValor());
        System.out.println("Código: " + this.getCodigo());
        System.out.println("Categoria: " + this.getCategoria());
        System.out.println("Restante no estoque: " + this.getUnidades());
        System.out.println("------------------------");
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return nome;
    }
    public void setValor(double valor){
        this.valor = valor;
    }
    public double getValor(){
        return valor;
    }
    public void setUnidades(int unidades){
        this.unidades = unidades;
    }
    public int getUnidades(){
        return unidades;
    }
    public void setCodigo(int codigo){
        this.codigo = codigo;
    }
    public int getCodigo(){
        return codigo;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public String getCategoria(){
        return categoria;
    }
}

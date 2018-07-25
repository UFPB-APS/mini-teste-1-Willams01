public class CustoGenerico implements Custo{
    
    private String nome;
    private double taxa;
    
    public CustoGenerico(){}
    
    public CustoGenerico(String nome, double taxa){
        this.nome = nome;
        this.taxa = taxa;
    }
    
    public double calcularCusto(String tipo,Venda venda){
        if(tipo.equals("Seguro")){
            return venda.getTotal() * taxa;
        }else if(tipo.equals("Imposto Sobre Venda")){
            return venda.getTotal() * 0.05;
        }else{
            return venda.getTotal();
        }
    }
}
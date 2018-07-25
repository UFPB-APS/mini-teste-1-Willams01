public class LogicaVenda {

    private Custo iv = new CustoGenerico();
    private Custo seguro;

    public Custo getSeguro() {
        return seguro;
    }
    
    public void setSeguro(Custo seguro) {
        this.seguro = seguro;
    }

    public double calcularTotal(String tipo,Venda venda) {
        venda.setTotal(0.0);
        
        for (ItemVenda item: venda.getItens()) {
            if (item != null) {
                venda.setTotal(venda.getTotal() + item.getSubTotal());
            }
        }
        
        if ( this.iv != null) {
            venda.setTotal(venda.getTotal() + this.iv.calcularCusto(tipo,venda));
        }
        
        if ( this.seguro != null) {
            venda.setTotal(venda.getTotal() + this.seguro.calcularCusto(tipo, venda));
        }
        
        return venda.getTotal();
    }
}

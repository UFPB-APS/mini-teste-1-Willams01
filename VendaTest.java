

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class VendaTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class VendaTest
{
    private LogicaVenda logica = new LogicaVenda();

    /**
     * Default constructor for test class VendaTest
     */
    public VendaTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }


    @Test
    public void totalVenda()
    {
        Venda venda1 = new Venda();

        Produto produto1 = new Produto(1, "iPhone", 1000);
        ItemVenda itemVend1 = new ItemVenda();
        itemVend1.setProduto(produto1);
        itemVend1.setQuantidade(2);
        venda1.addNoCarrinho(itemVend1, 0);

        Produto produto2 = new Produto(2, "S8", 500);
        ItemVenda itemVend2 = new ItemVenda();
        itemVend2.setProduto(produto2);
        itemVend2.setQuantidade(1);
        venda1.addNoCarrinho(itemVend2, 1);
        String tipo = "Imposto Sobre Venda";

        assertEquals(2625.0, logica.calcularTotal(tipo,venda1), 0.1);
    }
    
    @Test
    public void vendaComSeguro()
    {
        Venda venda1 = new Venda();
        Produto produto1 = new Produto(1, "Banana", 0.1);
        ItemVenda itemVend1 = new ItemVenda();
        itemVend1.setProduto(produto1);
        itemVend1.setQuantidade(100);
        venda1.addNoCarrinho(itemVend1, 0);

        CustoGenerico seguro1 = new CustoGenerico("Porto Seguro", 0.02);
        logica.setSeguro(seguro1);
        String tipo = "Seguro";
        assertEquals(10.2, logica.calcularTotal(tipo,venda1), 0.1);
      
        
        CustoGenerico seguro2 = new CustoGenerico("Mapfre", 0.015);
        logica.setSeguro(seguro2);
      
        assertEquals(10.15, logica.calcularTotal(tipo,venda1), 0.1);
    }

    @Test
    public void testeIrmaoDeFagner()
    {
        Venda venda2 = new Venda();
        Produto produto1 = new Produto(1, "CG 150", 7000);
        ItemVenda itemVend1 = new ItemVenda();
        itemVend1.setProduto(produto1);
        itemVend1.setQuantidade(10);
        venda2.addNoCarrinho(itemVend1, 0);
        String tipo = "Imposto Sobre Venda";
        assertEquals(73500, logica.calcularTotal(tipo,venda2), 0.1);
    }

}





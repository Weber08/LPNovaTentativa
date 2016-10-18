package modelo;

import dao.ProdutoDAO;
import java.util.List;

public class Produto {
    
    private int codProd;
    private String nome;

    public Produto(int codProd, String nome) {
        this.codProd = codProd;
        this.nome = nome;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    /**
     *
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Produto> obterProdutos() throws ClassNotFoundException{
        return ProdutoDAO.obterProdutos();
    }
}
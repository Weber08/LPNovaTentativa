package modelo;

import dao.ProdutoDAO;
import java.util.List;

public class Produto {
    
    private int codProd;
    private String nomeProd;

    public Produto() {
    }

    public Produto(int codProd, String nomeProd) {
        this.codProd = codProd;
        this.nomeProd = nomeProd;
    }

    public int getCodProd() {
        return codProd;
    }

    public void setCodProd(int codProd) {
        this.codProd = codProd;
    }

    public String getNomeProd() {
        return nomeProd;
    }

    public void setNomeProd(String nomeProd) {
        this.nomeProd = nomeProd;
    }
    
        public static List<Produto> obterProduto() throws ClassNotFoundException{
        return ProdutoDAO.obterProduto();
    }
}
package modelo;

import dao.EstoqueDAO;
import java.sql.SQLException;
import java.util.List;

public class Estoque {

    private int codigo;
    private String nome;
    private float preco;
    private float quantidade;
    private Unidade unidade;
    private String marca;
    private String fornecedor;
    private int dataDeCompra;
    private int vencimento;
    private int codigoUnidade;

    public Estoque(int codigo, String nome, float preco, float quantidade, Unidade unidade, String marca, String fornecedor, int dataDeCompra, int vencimento) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.unidade = unidade;
        this.marca = marca;
        this.fornecedor = fornecedor;
        this.dataDeCompra = dataDeCompra;
        this.vencimento = vencimento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public int getDataDeCompra() {
        return dataDeCompra;
    }

    public void setDataDeCompra(int data) {
        this.dataDeCompra = dataDeCompra;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public int getVencimento() {
        return vencimento;
    }

    public void setVencimento(int vencimento) {
        this.vencimento = vencimento;
    }

    public int getCodigoUnidade() {
        return codigoUnidade;
    }

    public void setCodigoUnidade(int codigoUnidade) {
        this.codigoUnidade = codigoUnidade;
    }

    public static Estoque obterEstoque(int codigo) throws ClassNotFoundException {
        return EstoqueDAO.obterEstoque(codigo);
    }

    public static List<Estoque> obterEstoques() throws ClassNotFoundException {
        return EstoqueDAO.obterEstoques();
    }

    public void gravar() throws SQLException, ClassNotFoundException {
        EstoqueDAO.gravar(this);
    }

    public void alterar() throws SQLException, ClassNotFoundException {
        EstoqueDAO.alterar(this);
    }

    public void excluir() throws SQLException, ClassNotFoundException {
        EstoqueDAO.excluir(this);
    }

}

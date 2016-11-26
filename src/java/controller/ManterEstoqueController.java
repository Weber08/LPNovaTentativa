package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Estoque;
import modelo.Fornecedor;
import modelo.Unidade;

public class ManterEstoqueController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request, response);
        } else if (acao.equals("confirmarEditar")) {
            confirmarEditar(request, response);
        } else if (acao.equals("prepararExcluir")) {
            prepararExcluir(request, response);
        } else if (acao.equals("confirmarExcluir")) {
            confirmarExcluir(request, response);
        }
    }

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("estoques", Estoque.obterEstoques());
            request.setAttribute("unidades", Unidade.obterUnidades());
            request.setAttribute("fornecedores", Fornecedor.obterFornecedores());
            RequestDispatcher view = request.getRequestDispatcher("/manterEstoque.jsp");
            view.forward(request, response);
        } catch (ServletException | IOException | ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String nome = request.getParameter("txtNome");
        float preco = Float.parseFloat(request.getParameter("txtPreco"));
        float quantidade = Float.parseFloat(request.getParameter("txtQuantidade"));
        int codigoUnidade = Integer.parseInt(request.getParameter("optUnidade"));
        String marca = request.getParameter("txtMarca");
        int codigoFornecedor = Integer.parseInt(request.getParameter("optFornecedor"));
        int dataDeCompra = Integer.parseInt(request.getParameter("txtDataDeCompra"));
        int vencimento = Integer.parseInt(request.getParameter("txtVencimento"));

        try {
            Unidade unidade = null;
            Fornecedor fornecedor = null;
            if (codigoUnidade != 0) {
                unidade = Unidade.obterUnidade(codigoUnidade);
            }
            if (codigoFornecedor != 0) {
                fornecedor = Fornecedor.obterFornecedor(codigoFornecedor);
            }
            Estoque estoque = new Estoque(codigo, nome, preco, quantidade, unidade, marca, fornecedor, dataDeCompra, vencimento);
            estoque.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisarEstoqueController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Editar");
            request.setAttribute("unidades", Unidade.obterUnidades());
            request.setAttribute("estoques", Estoque.obterEstoques());
            request.setAttribute("fornecedores", Fornecedor.obterFornecedores());
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Estoque estoque = Estoque.obterEstoque(codigo);
            request.setAttribute("estoque", estoque);
            RequestDispatcher view = request.getRequestDispatcher("/manterEstoque.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String nome = request.getParameter("txtNome");
        float preco = Float.parseFloat(request.getParameter("txtPreco"));
        float quantidade = Float.parseFloat(request.getParameter("txtQuantidade"));
        int codigoUnidade = Integer.parseInt(request.getParameter("optUnidade"));
        String marca = request.getParameter("txtMarca");
        int codigoFornecedor = Integer.parseInt(request.getParameter("optFornecedor"));
        int dataDeCompra = Integer.parseInt(request.getParameter("txtDataDeCompra"));
        int vencimento = Integer.parseInt(request.getParameter("txtVencimento"));

        try {
            Unidade unidade = null;
            Fornecedor fornecedor = null;
            if (codigoUnidade != 0) {
                unidade = Unidade.obterUnidade(codigoUnidade);
            }
            if (codigoFornecedor != 0) {
                fornecedor = Fornecedor.obterFornecedor(codigoFornecedor);
            }
            Estoque estoque = new Estoque(codigo, nome, preco, quantidade, unidade, marca, fornecedor, dataDeCompra, vencimento);
            estoque.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisarEstoqueController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    public void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Excluir");
            request.setAttribute("estoques", Estoque.obterEstoques());
            request.setAttribute("unidades", Unidade.obterUnidades());
            request.setAttribute("fornecedores", Fornecedor.obterFornecedores());
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Estoque estoque = Estoque.obterEstoque(codigo);
            request.setAttribute("estoque", estoque);
            RequestDispatcher view = request.getRequestDispatcher("/manterEstoque.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }

    }

    public void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String nome = request.getParameter("txtNome");
        float preco = Float.parseFloat(request.getParameter("txtPreco"));
        float quantidade = Float.parseFloat(request.getParameter("txtQuantidade"));
        int codigoUnidade = Integer.parseInt(request.getParameter("optUnidade"));
        String marca = request.getParameter("txtMarca");
        int codigoFornecedor = Integer.parseInt(request.getParameter("optFornecedor"));
        int dataDeCompra = Integer.parseInt(request.getParameter("txtDataDeCompra"));
        int vencimento = Integer.parseInt(request.getParameter("txtVencimento"));

        try {
            Unidade unidade = null;
            Fornecedor fornecedor = null;
            if (codigoUnidade != 0) {
                unidade = Unidade.obterUnidade(codigoUnidade);
            }
            if (codigoFornecedor != 0) {
                fornecedor = Fornecedor.obterFornecedor(codigoFornecedor);
            }
            Estoque estoque = new Estoque(codigo, nome, preco, quantidade, unidade, marca, fornecedor, dataDeCompra, vencimento);
            estoque.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisarEstoqueController");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        } catch (SQLException ex) {
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

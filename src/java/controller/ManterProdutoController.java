package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Produto;

public class ManterProdutoController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararIncluir")) {
            prepararIncluir(request, response);
        } else if (acao.equals("confirmarIncluir")) {
            confirmarIncluir(request, response);
        } else if (acao.equals("prepararEditar")) {
            prepararEditar(request , response);
        } else if (acao.equals("confirmarEditar")) {
            //confirmarEditar(request , response);
        } else if (acao.equals("prepararExcluir")) {
            //prepararExcluir(request , response);
        } else if (acao.equals("confirmarExcluir")) {
            //confirmarExcluir(request , response);
        }
    }

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setAttribute("operacao", "Incluir");
            request.setAttribute("produtos", Produto.obterProdutos());
            RequestDispatcher view = request.getRequestDispatcher("/manterProduto.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex) {
        }
    }

    public void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) {
        int codigo = Integer.parseInt(request.getParameter("txtCodigo"));
        String nome = request.getParameter("txtNome");
        float preco = Float.parseFloat(request.getParameter("txtPreco"));
        float quantidade = Float.parseFloat(request.getParameter("txtQuantidade"));
        
        try {
            /*  caso seja necessário
            Professor professor = null;
            if (coordenador != 0) {
                professor = Professor.obterProfessor(coordenador);
        }
             */
            Produto produto = new Produto(codigo, nome , preco , quantidade);
            produto.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisarProdutoController");
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
            request.setAttribute("produtos", Produto.obterProdutos());
            int codigo = Integer.parseInt(request.getParameter("codigo"));
            Produto produto = Produto.obterProduto(codigo);
            request.setAttribute("produto", produto);
            RequestDispatcher view = request.getRequestDispatcher("/manterProduto.jsp");
            view.forward(request, response);
        } catch (ServletException ex) {
        } catch (IOException ex) {
        } catch (ClassNotFoundException ex){
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

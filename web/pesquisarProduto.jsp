<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Produtos</title>
    </head>
    <body>
        <h1>Pesquisar Produtos</h1>
        <table border="1">
            <tr>
                <th>Codigo </th>
                <th>Nome</th> 
                <th>Preco</th>
                <th>Quantidade</th>
                <th colspan="2">Ação</th>  
            </tr>
            <c:forEach items="${produtos}" var="produto">
                <tr>
                    <td> <c:out value="${produto.codigo}" /></td>
                    <td> <c:out value="${produto.nome}" /></td>
                    <td> <c:out value="${produto.preco}" /></td>
                    <td> <c:out value="${produto.quantidade}" /></td>
                    <td><a href="ManterProdutoController?acao=prepararEditar&codigo=<c:out value="${produto.codigo}"/>">Editar</a></td>
                    <td><a href="ManterProdutoController?acao=prepararExcluir&codigo=<c:out value="${produto.codigo}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
         </table>
       
        <form action="ManterProdutoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="incluir"/>
        </form>
        <br><a href="index.jsp"><button>Inicio</button></a>
    </body>
</html>

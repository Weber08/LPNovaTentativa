<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Estoques</title>
    </head>
    <body>
        <h1>Pesquisar Estoques</h1>
        <table border="1">
            <tr>
                <th>Codigo </th>
                <th>Nome</th> 
                <th>Preco</th>
                <th>Quantidade</th>
                <th>Unidade</th>
                <th>Marca</th>
                <th>Fornecedor</th>
                <th>Data De Compra</th>
                <th>Vencimento</th>
                <th colspan="2">Ação</th>  
            </tr>
            <c:forEach items="${estoques}" var="estoque">
                <tr>
                    <td> <c:out value="${estoque.codigo}" /></td>
                    <td> <c:out value="${estoque.nome}" /></td>
                    <td> <c:out value="${estoque.preco}" /></td>
                    <td> <c:out value="${estoque.quantidade}" /></td>
                    <td> <c:out value="${estoque.unidade.descricao}" /></td>
                    <td> <c:out value="${estoque.marca}" /></td>
                    <td> <c:out value="${estoque.fornecedor.descricao}" /></td>
                    <td> <c:out value="${estoque.dataDeCompra}" /></td>
                    <td> <c:out value="${estoque.vencimento}" /></td>
                    <td><a href="ManterEstoqueController?acao=prepararEditar&codigo=<c:out value="${estoque.codigo}"/>">Editar</a></td>
                    <td><a href="ManterEstoqueController?acao=prepararExcluir&codigo=<c:out value="${estoque.codigo}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </table>

        <form action="ManterEstoqueController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="incluir"/>
        </form>
        <br><a href="index.jsp"><button>Inicio</button></a>
    </body>
</html>

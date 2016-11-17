<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Fornecedores</title>
    </head>
    <body>
        <h1>Pesquisar Fornecedores</h1>
        <table border="1">
            <tr>
                <th>Codigo </th>
                <th>Descricao</th> 
                <th colspan="2">Ação</th>  
            </tr>
            <c:forEach items="${fornecedores}" var="fornecedor">
                <tr>
                    <td> <c:out value="${fornecedor.codigo}" /></td>
                    <td> <c:out value="${fornecedor.descricao}" /></td>
                    <td><a href="ManterFornecedorController?acao=prepararEditar&codigo=<c:out value="${fornecedor.codigo}"/>">Editar</a></td>
                    <td><a href="ManterFornecedorController?acao=prepararExcluir&codigo=<c:out value="${fornecedor.codigo}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
         </table>
       
        <form action="ManterFornecedorController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="incluir"/>
        </form>
        <br><a href="index.jsp"><button>Inicio</button></a>
    </body>
</html>

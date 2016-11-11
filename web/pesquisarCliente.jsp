<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisar Clientes</title>
    </head>
    <body>
        <h1>Pesquisar Clientes</h1>
        <table border="1">
            <tr>
                <th>Codigo </th>
                <th>Nome</th> 
                <th colspan="2">Ação</th>  
            </tr>
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td> <c:out value="${cliente.codigo}" /></td>
                    <td> <c:out value="${cliente.nome}" /></td>
                    <td><a href="ManterClienteController?acao=prepararEditar&codigo=<c:out value="${cliente.codigo}"/>">Editar</a></td>
                    <td><a href="ManterClienteController?acao=prepararExcluir&codigo=<c:out value="${cliente.codigo}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
         </table>
       
        <form action="ManterClienteController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="incluir"/>
        </form>
        <br><a href="index.jsp"><button>Inicio</button></a>
    </body>
</html>

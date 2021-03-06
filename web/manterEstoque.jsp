<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Estoque</title>
    </head>
    <body>
        <h1>Manter Estoque - ${operacao}</h1>

        <form action="ManterEstoqueController?acao=confirmar${operacao}" method="post" name="frmManterEstoque" onsubmit="return validarFormulario(this)">
            <table>
                <tr>
                    <td>Código:</td> 
                    <td><input type="text" name="txtCodigo" value="${estoque.codigo}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>              
                        <td>Nome:</td> 
                        <td><input type="text" name="txtNome" value="${estoque.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td>Preco:</td> 
                        <td><input type="text" name="txtPreco" value="${estoque.preco}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        <td>Quantidade:</td> 
                        <td><input type="text" name="txtQuantidade" value="${estoque.quantidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    <tr>
                        <td>Unidade:</td>
                        <td>
                            <select name="optUnidade" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${estoque.unidade.codigo == null}"> selected</c:if>> </option>  
                            <c:forEach items="${unidades}" var="unidade">
                                <option value="${unidade.codigo}" <c:if test="${estoque.unidade.codigo == unidade.codigo}"> selected</c:if>>${unidade.descricao}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr> 
                <td>Marca:</td> 
                <td><input type="text" name="txtMarca" value="${estoque.marca}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                                       <tr>
                        <td>Unidade:</td>
                        <td>
                            <select name="optFornecedor" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${estoque.fornecedor.codigo == null}"> selected</c:if>> </option>  
                            <c:forEach items="${fornecedores}" var="fornecedor">
                                <option value="${fornecedor.codigo}" <c:if test="${estoque.fornecedor.codigo == fornecedor.codigo}"> selected</c:if>>${fornecedor.descricao}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr> 
                    <td>Data de Compra:</td> 
                    <td><input type="text" name="txtDataDeCompra" value="${estoque.dataDeCompra}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                    <td>Vencimento:</td> 
                    <td><input type="text" name="txtVencimento" value="${estoque.vencimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
        <SCRIPT language="JavaScript">
            <!--
            
            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++)
                {
                    umCaracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(umCaracter) == -1)
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) {
                var mensagem;
                mensagem = "";
                if (form.txtCodCurso.value == "") {
                    mensagem = mensagem + "Informe o Código do Curso\n";
                }
                if (form.txtNomeCurso.value == "") {
                    mensagem = mensagem + "Informe o Nome do Curso\n";
                }
                if (form.txtTotalPeriodos.value == "") {
                    mensagem = mensagem + "Informe o Total de Períodos\n";
                }
                if (form.txtCargaHoraria.value == "") {
                    mensagem = mensagem + "Informe a Carga Horária\n";
                }
                if (!campoNumerico(form.txtCodCurso.value)) {
                    mensagem = mensagem + "Código do Curso deve ser numérico\n";
                }
                if (!campoNumerico(form.txtTotalPeriodos.value)) {
                    mensagem = mensagem + "Total de Períodos deve ser numérico\n";
                }
                if (!campoNumerico(form.txtCargaHoraria.value)) {
                    mensagem = mensagem + "Carga Horária deve ser numérica\n";
                }
                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
            //-->
        </SCRIPT>        
    </body>
</html>

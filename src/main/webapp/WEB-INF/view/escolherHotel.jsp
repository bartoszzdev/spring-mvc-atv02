<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri=http://java.sun.com/jsp/jstl/core prefix="c"%>
<jsp:useBean id="User" type="br.com.fiap.atv02.atividade02.model.Usuario" scope="session" />
<jsp:useBean id="Hoteis" type="java.util.ArrayList" scope="request" />
<!DOCTYPE html>
<html>
<head>
<title>.: Confira seus Hotéis :.</title>
</head>
<body>
    <h1> Olá! <c:out value="${User.nome}" /></h1>
    <hr/>
    <p>Os hotéis da categoria selecionada são:</p>
    <c:forEach items="${Hoteis}" var="hotel">
       Hotel <c:out value="${hotel.nome}"/> <br>
       Endereco <c:out value="${hotel.endereco}"/> <br>
       Valor da Diaria 
              <c:out value="${hotel.valorDiaria}"/> <br>
       Classificacao 
              <c:out value="${hotel.classificacao}"/> 
              estrelas <br>
       <hr>
    </c:forEach>

</body>
</html>
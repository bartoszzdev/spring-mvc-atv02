<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="User" type="br.com.fiap.atv02.atividade02.model.Usuario" scope="session"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>.: Busque seu hotel pela classificacao :.</title>
</head>
<body>
<h1> Escolha seu Hotel!</h1>
<hr/>
Olá <c:out value="${User.nome}"/> 
   (<c:out value="${User.email}"/>) seja bem vindo! <br/>
<hr>
Selecione a classificação que você deseja:
<form action="escolherHotel" method="post">
   <select name="selectClassif">
      <option value=1>1 Estrela</option>
      <option value=2>2 Estrelas</option>
      <option value=3>3 Estrelas</option>
      <option value=4>4 Estrelas</option>
      <option value=5>5 Estrelas</option>
   </select>
   <br>
   <input type="submit" value="Escolher">
</form>
</body>
</html>
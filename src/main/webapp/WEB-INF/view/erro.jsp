<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--declarando o uso das TagLIBS -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- declarando o uso da propriede"Mensagem" que vamos 
     receber do controller -->
<jsp:useBean id="Mensagem" type="java.lang.String" scope="request" />
<!DOCTYPE html>
<html>
<head>
	<title>.: Erro :.</title>
</head>
<body>
	<h1>Erro!</h1>
	<hr>
	Mensagem de Erro: <c:out value="${Mensagem}" />
	<br>
	<a href="./index.jsp">Voltar ao Inicio</a>
</body>
</html>
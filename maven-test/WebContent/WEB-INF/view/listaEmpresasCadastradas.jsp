<%@ page
	import="java.util.List,br.com.alura.gerenciador.model.Empresa"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:url value="/entrada?acao=MostraEmpresa&id=" var="linkEntradaEditServlet"/>
<c:url value="/entrada?acao=RemoveEmpresa&id=" var="linkEntradaRemoveServlet"/>  

<title>Java Standard TagLibrary</title>

</head>
<body>
	
	Usuario Logado: ${usuarioLogado.login }
	<c:import url="logout-parcial.jsp"></c:import>
	
	<c:if test="${not empty empresa }">
		Empresa ${empresa.nome } cadastrada com sucesso!
	</c:if>
	
	Lista de empresas:
	<br />
	<ul>
		<c:forEach items="${empresas }" var="empresa">
			<li>
			${empresa.nome } - <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" />
			<a href="${linkEntradaEditServlet }${empresa.id }">editar</a>
			<a href="${linkEntradaRemoveServlet }${empresa.id }">remover</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>

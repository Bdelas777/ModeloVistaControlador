<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import ="java.util.* , Bernardo.products.*"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<style>
		.cabecera{
		font-size:1.2em;
		font-weight:bold;
		color:#FFFFFF;
		background-color: #08088A;
		}
		
		.filas{
		text-align:center;
		background-color: #5882FA;
		}
		
		table{
			float:left;
		}
		
		#contendorBoton{
			margin-left:1100px;
		}
	
	</style>
	
	<body>
		<table>
			<tr >
			<th class="cabecera">Código Artículo</th>
			<th  class="cabecera">Sección</th>
			<th  class="cabecera">Nombre Artículo</th>
			<th  class="cabecera">Fecha</th>
			<th  class="cabecera">Precio</th>
			<th  class="cabecera">Importado</th>
			<th  class="cabecera">País de origen</th>
			<th  class="cabecera">Acción</th>
			</tr>
			<c:forEach var="temproduc" items="$(listproducts)">
			
				<!-- Link para actualizar cada producto con campo clave -->
				<c:url var="linkTemp" value="ControlProducts">
					<c:param name="instruction" value="cargar"> </c:param>
					<c:param name="CArticulo" value="$(temproduc.codarticle"></c:param>
				</c:url>
				
				<!-- Link para elimianar cada producto con campo clave -->
				<c:url var="linkTempEliminar" value="ControlProducts">
					<c:param name="instruction" value="eliminar"> </c:param>
					<c:param name="CArt" value="$(temproduc.codarticle"></c:param>
				</c:url>
				
				<tr class="cabecera">
				<th  class="filas"> $(temproduc.codarticle)</th>
				<th class="filas"> $(temproduc.seccion)</th>
				<th class="filas"> $(temproduc.narticle)</th>
				<th class="filas"> $(temproduc.date)</th>
				<th class="filas"> $(temproduc.price)</th>
				<th class="filas"> $(temproduc.importado)</th>
				<th class="filas"> $(temproduc.origincountry)</th>
				<th class="filas"> <a href="$(linkTemp)">Actualiza</a>
				&nsbp;&nsbp;<a href="$(linkTempEliminar)">Eliminar</th>
				</tr>
			</c:forEach>
		</table>
		<div id="contendorBoton">
			<input type="button" value="insertar registro" 
				onclick="window.location.href='inserta.jsp'">
			
		</div>
	</body>
</html>
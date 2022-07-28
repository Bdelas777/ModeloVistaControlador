<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1 style="text-align:center">Inserta Registro</h1>
		<form name="form1" method="get" action="ControlProducts">
		<input type="hidden" name="instruction" action="insertaBBDD">
			<table width="50$" border="0">
				<tr>
					<th width="27$"> Código Artículo </th>
					<th width="73$"> <label for="CArt" ></label>
					<input type="text" name="CArt" id="CArt"> </th>
				</tr>
				<tr>
					<th > Sección </th>
					<th > <label for="seccion" ></label>
					<input type="text" name="seccion" id="seccion"> </th>
				</tr>
				<tr>
					<th width="279"> Nombre Artículo </th>
					<th width="739"> <label for="NArt" ></label>
					<input type="text" name="NArt" id="NArt"> </th>
				</tr>
				<tr>
					<th > Fecha </th>
					<th > <label for="fecha" ></label>
					<input type="text" name="fecha" id="fecha"> </th>
				</tr>
				<tr>
					<th > Precio </th>
					<th > <label for="precio" ></label>
					<input type="text" name="precio" id="precio"> </th>
				</tr>
				<tr>
					<th > Importado </th>
					<th > <label for="importado" ></label>
					<input type="text" name="importado" id="importado"> </th>
				</tr>
				<tr>
					<th > País de origen </th>
					<th > <label for="POrig" ></label>
					<input type="text" name="POrig" id="POrig"> </th>
				</tr>
				<td> <input type="submit" name="envio" id="envio" value="Enviar"></td>
				<td> <input type="reset" name="borrar" id="borrar" value="Reestablecer"></td>
			</table>
		</form>
			
	</body>
</html>
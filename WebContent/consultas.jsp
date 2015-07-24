<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="css/bootstrap.min.css" rel="stylesheet" type='text/css' />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

<title>Consultar empleados de un departamento here</title>
<!-- Favicon -->
<link rel="apple-touch-icon" sizes="57x57" href="img/icon/apple-icon-57x57.png">
<link rel="apple-touch-icon" sizes="60x60" href="img/icon/apple-icon-60x60.png">
<link rel="apple-touch-icon" sizes="72x72" href="img/icon/apple-icon-72x72.png">
<link rel="apple-touch-icon" sizes="76x76" href="img/icon/apple-icon-76x76.png">
<link rel="apple-touch-icon" sizes="114x114" href="img/icon/apple-icon-114x114.png">
<link rel="apple-touch-icon" sizes="120x120" href="img/icon/apple-icon-120x120.png">
<link rel="apple-touch-icon" sizes="144x144" href="img/icon/apple-icon-144x144.png">
<link rel="apple-touch-icon" sizes="152x152" href="img/icon/apple-icon-152x152.png">
<link rel="apple-touch-icon" sizes="180x180" href="img/icon/apple-icon-180x180.png">
<link rel="icon" type="image/png" sizes="192x192"  href="img/icon/android-icon-192x192.png">
<link rel="icon" type="image/png" sizes="32x32" href="img/icon/favicon-32x32.png">
<link rel="icon" type="image/png" sizes="96x96" href="img/icon/favicon-96x96.png">
<link rel="icon" type="image/png" sizes="16x16" href="img/icon/favicon-16x16.png">
<link rel="manifest" href="img/icon/manifest.json">
<meta name="msapplication-TileColor" content="#ffffff">
<meta name="msapplication-TileImage" content="/ms-icon-144x144.png">
<meta name="theme-color" content="#ffffff">
<!-- fin Favicon -->

<!-- JavaScript -->
	<script language="javascript">

          function addRow(tableID) {//añade filas y columnas dinamicamente

        	  var table = document.getElementById(tableID);

                var rowCount = table.rows.length;

               var row = table.insertRow(rowCount);


               var cell1 = row.insertCell(0);

               var element1 = document.createElement("input");

               element1.type = "checkbox";

               cell1.appendChild(element1);

 

               var cell2 = row.insertCell(1);

               var element2 = document.createElement("input");

               element2.type = "text";

               cell2.appendChild(element2);

          }
 

          function deleteRow(tableID) {//elimina filas y columnas dinamicamente

               try {

               var table = document.getElementById(tableID);

               var rowCount = table.rows.length;

 

               for(var i=0; i<rowCount; i++) {

                    var row = table.rows[i];

                    var chkbox = row.cells[0].childNodes[0];

                    if(null != chkbox && true == chkbox.checked) {

                         table.deleteRow(i);

                         rowCount--;

                         i--;
                    }
               }
               }catch(e) {

                    alert(e);
               }
          }
          </script>


</head>


<body class="container-fluid">
	<form class="form-control" method="GET" action="ListarEmpleadosServlet">
		<select name="departamento">
			<c:forEach items="${departamentos}" var="item">
				<option name="${item.departmentId}">${item.departmentName}</option>
			</c:forEach>
		</select> <input type="submit" value="Obtener Empleados" />
	</form>
	
	
	
	
	
	
	
<table>
	<tr>
		<td>
			<select id="departamentos" onchange="listarTrabajadores();">
   			
			</select>
		</td>
		
		<td>
			<select id="empleados" ></select>
		</td>
	</tr>
	
	<tr>
		<td>
			<input type="submit" value="Buscar Departamentos" onclick="rellenaCaja();">
		</td>
	
	</tr>
</table>
	
	
	
</body>
<footer>

	<!-- JavaScript -->
	
	<script>
	
	var xmlHttp = null;
	
	function iniciaObjetoRequest ()
	{
		
	return new XMLHttpRequest();
	}
	
	function rellenaCaja()
	{
		xmlHttp = iniciaObjetoRequest();
		xmlHttp.onreadystatechange = procesarEventos;
		xmlHttp.open('GET', 'CargaMenuSelect?num=30', true); //indicamos como vamos a enviar los datos, en este caso con el metodo GET al archivo meses.php?num= el valor que le indiquemos en el textbox
		xmlHttp.send(null);
		
	}
	
	function procesarEventos()
	{
	   //Obtenemos el control del TAG que contendrá la respuesta
	  if(xmlHttp.readyState==4) //ya hemos recibido respuesta del servidor
	  {
	      if(xmlHttp.status==200)// y el código de la cabecera http es bueno
	          {
				alert("He recibido " + xmlHttp.responseText);
				//document.getElementById("cajatexto").value = xmlHttp.responseText;
				
				
	          	var lista_dptos = xmlHttp.responseXML.getElementsByTagName("departamento");
	          	var nelementos = lista_dptos.length;
	          	var opcion;
	          	var desplegable = document.getElementById("departamentos");
	          	
	          	var id = null;
	          	var nombre = null;
	      
				for (var i= 0; i < nelementos; i++) {
					
					
					/*var id = lista_dptos[i].children[0].textContent;
					var nombre = lista_dptos[i].children[1].textContent;*/ //FORMA MÁS ELEGANTE Y LÓGICA, PERO NO COMPATIBLE CON IE :S
					
					var elementoId= lista_dptos[i].getElementsByTagName("id")[0];
					var elementoNombre = lista_dptos[i].getElementsByTagName("nombre")[0];
					
					
					id = elementoId.childNodes[0].data; //también podría usar firstChild
					nombre = elementoNombre.childNodes[0].data;//en vez de childNodes[0]
					
					
					opcion = new Option(nombre, id);//Creo la opción
					desplegable.options[desplegable.options.length] = opcion;//la seteo. POdría haber usado como índice [i]
					 
					
				}
	          }
	      else
	      {
	          alert("Ha ocurrido un error"+ xmlHttp.status +":"+ xmlHttp.statusText);
	      }
	  }
	
	}
	
	
	function procesarTrabajadores()
	{
	   //Obtenemos el control del TAG que contendrá la respuesta
	  if(xmlHttp.readyState==4) //ya hemos recibido respuesta del servidor
	  {
	      if(xmlHttp.status==200)// y el código de la cabecera http es bueno
	          {
				alert(listarTrabajadores.length);
				
				var parser = new DOMParser();
				var xmlDoc = parser.parseFromString(xmlHttp.responseText, "application/xml");
				
	        	var lista_empleados = xmlDoc.getElementsByTagName("empleado");
	          	var nelementos = lista_empleados.length;
	          	var opcion;
	          	var desplegable = document.getElementById("empleados");
	          	
	          	var id = null;
	          	var nombre = null;
	      		var longitudDesplegable = desplegable.length;
	          	
	          	for (var j=0; j <  longitudDesplegable; j++)
	          	{
	          		desplegable.remove(0);
	          	}
	          	
				for (var i= 0; i < nelementos; i++) {
					
					
					/*var id = lista_dptos[i].children[0].textContent;
					var nombre = lista_dptos[i].children[1].textContent;*/ //FORMA MÁS ELEGANTE Y LÓGICA, PERO NO COMPATIBLE CON IE :S
					
					 nombre = lista_empleados[i].childNodes[0].data;//en vez de childNodes[0]
					
					
					opcion = new Option(nombre, nombre);//Creo la opción
					desplegable.options[i] = opcion;//la seteo. POdría haber usado como índice [i]
					 
					
				}
	          }
	      else
	      {
	          alert("Ha ocurrido un error"+ xmlHttp.status +":"+ xmlHttp.statusText);
	      }
	  }
	
	}
	
	function listarTrabajadores(tableID)
	{
		var desplegable = document.getElementById("departamentos");
		//alert ('Ha seleccionado el valor ' + desplegable[desplegable.selectedIndex].value);
		//alert ('Del departamento nombre' + desplegable[desplegable.selectedIndex].text);
		var dpto = desplegable[desplegable.selectedIndex].value;
		
		xmlHttp = new XMLHttpRequest();
		xmlHttp.onreadystatechange = procesarTrabajadores;
		xmlHttp.open('GET', 'CargarTrabajadores?dpto='+dpto, true); //indicamos como vamos a enviar los datos, en este caso con el metodo GET al archivo meses.php?num= el valor que le indiquemos en el textbox
		xmlHttp.send(null);
		
		
	}
	
	
	</script>


</footer>


</html>
<!DOCTYPE html>
<%@ page isELIgnored = "false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conta criado com Sucesso!</title>
</head>
<body>
   <h1>Conta criado com Sucesso!</h1>
   
   
   
   <table title="Registrar empresa" border="0">
   		<tr>
   	      <td width="350" align="right"><b>ID:</b></td>
   	      <td width="300" align="left">
   	      	${idEmpresa}
	      </td>
   	      <td></td>
   	   </tr>  
   	   <tr>
   	      <td width="350" align="right"><b>Nome:</b></td>
   	      <td width="300" align="left">
   	      	${nmEmpresa}
	      </td>
   	      <td></td>
   	   </tr>   	
   	   <tr>
   	      <td width="350" align="right"><b>Ramo de atividade:</b></td>
   	      <td width="300" align="left">
   	      	${cdRamoAtividade}
		  </td>
   	      <td></td>
   	   </tr>
   	   <tr>
   	      <td width="350" align="right"><b>E-mail:</b></td>
   	      <td width="300" align="left">
   	      	${deEmail}</td>
   	      <td></td>
   	   </tr>
   </table>
   
</body>
</html>
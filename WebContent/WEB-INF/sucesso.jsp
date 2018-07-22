<!DOCTYPE html>
<%@ page isELIgnored = "false" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Conta criado com Sucesso!</title>
</head>
<body>
   <h1>Conta criado com Sucesso!</h1>
   <br>
   <h2>Dados da Empresa</h2>
   <table title="Registrar empresa">
   		<tr>
   	      <td width="350" align="right"><b>ID:</b></td>
   	      <td width="300" align="left">
   	      	${idEmpresa}
	      </td>
   	      <td></td>
   	   </tr>  
   	   <tr>
   	      <td width="350" align="right"><b>Nome:</b></td>
   	      <td width="300" align="left" id="tdNmEmpresa">
   	      	${nmEmpresa}
	      </td>
   	      <td></td>
   	   </tr>   	
   	   <tr>
   	      <td width="350" align="right"><b>Ramo de atividade:</b></td>
   	      <td width="300" align="left" id="tdCdRamoAtividade">
   	      	${cdRamoAtividade}
		  </td>
   	      <td></td>
   	   </tr>
   	   <tr>
   	      <td width="350" align="right"><b>E-mail:</b></td>
   	      <td width="300" align="left" id="tdDeEmail">
   	      	${deEmail}</td>
   	      <td></td>
   	   </tr>
   </table>
   <br>
   <h2>Dados do Usuário</h2>
   <table title="Registrar empresa">
   		<tr>
   	      <td width="350" align="right"><b>ID:</b></td>
   	      <td width="300" align="left" id="idUsuario">
   	      	${idUsuario}
	      </td>
   	      <td></td>
   	   </tr>  
   	   <tr>
   	      <td width="350" align="right"><b>E-mail ID:</b></td>
   	      <td width="300" align="left" id="tdEmailId">
   	      	${emailId}
	      </td>
   	      <td></td>
   	   </tr>   	
   	   <tr>
   	      <td width="350" align="right"><b>Senha:</b></td>
   	      <td width="300" align="left" id="tdDeSenha">
   	      	${deSenha}
		  </td>
   	      <td></td>
   	   </tr>
   	  <tr>
   	      <td width="350" align="right"><b>ID Empresa:</b></td>
   	      <td width="300" align="left" id="idEmpresaUsuario">
   	      	${idEmpresaUsuario}
	      </td>
   	      <td></td>
   	   </tr>  
   </table>
   
</body>
</html>
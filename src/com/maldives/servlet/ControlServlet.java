package com.maldives.servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.maldives.model.Empresa;
import com.maldives.model.Usuario;
import com.maldives.resources.PacoteRecurso;
import com.maldives.service.EmpresaService;
import com.maldives.service.SignUpService;
import com.maldives.service.UsuarioService;

/**
 * Servlet implementation class RegisterCompanyServlet
 */
@WebServlet("/RegisterCompanyServlet")
public class ControlServlet extends HttpServlet {
	
	private SignUpService signUpService;
	private EmpresaService empresaService;
	private UsuarioService usuarioService;
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */

  @Override
	public void init(ServletConfig config) throws ServletException {
	   super.init(config);
	   WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
	   this.empresaService = (EmpresaService)ctx.getBean("empresaServiceBean");
	   this.signUpService	 = (SignUpService)ctx.getBean("signUpServiceBean");
	   this.usuarioService	 = (UsuarioService)ctx.getBean("usuarioServiceBean");
	   Locale.setDefault(new Locale(PacoteRecurso.LOCALE_PORTUGUES_BRASIL));
  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nmEmpresa = (String)request.getParameter("nmEmpresa");
		Integer cdRamoAtividade = Integer.parseInt(request.getParameter("cdRamoAtividade"));
		String deEmail = (String) request.getParameter("deEmail");
		String deSenha = (String)request.getParameter("deSenha");
		Boolean flAceiteTermos = Boolean.parseBoolean(request.getParameter("flAceiteTermos"));
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa(nmEmpresa);
		empresa.setCdRamoAtividade(cdRamoAtividade);
		empresa.setDeEmail(deEmail);
		
		Usuario usuario = new Usuario();
		usuario.setDeEmailId(empresa.getDeEmail());
		usuario.setDeSenha(deSenha);
		
		signUpService.registrarEmpresa(empresa, usuario, flAceiteTermos);
		
		Empresa empresaSalva = empresaService.findByEmail(deEmail);
		
		request.setAttribute("idEmpresa", empresaSalva.getIdEmpresa());
		request.setAttribute("nmEmpresa", empresaSalva.getNmEmpresa());
		request.setAttribute("deEmail", empresaSalva.getDeEmail());
		request.setAttribute("cdRamoAtividade", empresa.getCdRamoAtividade());
		
		Usuario usuarioSalvo = usuarioService.findByEmail(deEmail);
		
		request.setAttribute("idUsuario", usuarioSalvo.getIdUsuario());
		request.setAttribute("emailId", usuarioSalvo.getDeEmailId());
		request.setAttribute("deSenha", usuarioSalvo.getDeSenha());
		request.setAttribute("idEmpresaUsuario", usuario.getIdEmpresa());
		
		request.getRequestDispatcher("/WEB-INF/sucesso.jsp").forward(request, response);
			
	}

}

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

import com.maldives.domain.Company;
import com.maldives.domain.User;
import com.maldives.service.CompanyService;
import com.maldives.service.UserService;
import com.maldives.util.PacoteRecurso;

/**
 * Servlet implementation class RegisterCompanyServlet
 */
@WebServlet("/RegisterCompanyServlet")
public class ControlServlet extends HttpServlet {
	
	private CompanyService companyService;
	private UserService userService;
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */

  @Override
	public void init(ServletConfig config) throws ServletException {
	   super.init(config);
	   WebApplicationContext ctx = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
	   this.companyService = (CompanyService)ctx.getBean("companyService");
	   this.userService	 = (UserService)ctx.getBean("userService");
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
		
		Company company = new Company();
		company.setCompanyName(nmEmpresa);
		company.setLineBusiness(cdRamoAtividade);
		company.setEmail(deEmail);
		
		User user = new User();
		user.setEmailId(company.getEmail());
		user.setPassword(deSenha);
		
		userService.signUpCompany(company, user, flAceiteTermos);
		
		Company savedCompany = companyService.findByEmail(deEmail);
		
		request.setAttribute("idEmpresa", savedCompany.getCompanyId());
		request.setAttribute("nmEmpresa", savedCompany.getCompanyName());
		request.setAttribute("deEmail", savedCompany.getEmail());
		request.setAttribute("cdRamoAtividade", company.getLineBusiness());
		request.setAttribute("idUsuarioEmpresa", company.getUserId());
		
		User savedUser = userService.findByEmail(deEmail);
		
		request.setAttribute("idUsuario", savedUser.getUserId());
		request.setAttribute("emailId", savedUser.getEmailId());
		request.setAttribute("deSenha", savedUser.getPassword());
		request.setAttribute("userType", savedUser.getUserType());
		
		request.getRequestDispatcher("/WEB-INF/sucesso.jsp").forward(request, response);
			
	}

}

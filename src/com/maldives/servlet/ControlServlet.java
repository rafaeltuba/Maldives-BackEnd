package com.maldives.servlet;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.maldives.model.Empresa;
import com.maldives.repository.EmpresaDB;
import com.maldives.resources.PacoteRecurso;
import com.maldives.service.EmpresaService;
import com.maldives.service.SignUpService;

/**
 * Servlet implementation class RegisterCompanyServlet
 */
@WebServlet("/RegisterCompanyServlet")
public class ControlServlet extends HttpServlet {
	
	private SignUpService signUpService;
	
	@Autowired
	private EmpresaService empresaService;
	
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
	
	@Autowired
    public ControlServlet(SignUpService signUpService) {
        Locale.setDefault(new Locale(PacoteRecurso.LOCALE_PORTUGUES_BRASIL));
        this.signUpService = signUpService;
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
		
		signUpService.inscreverEmpresa(empresa, flAceiteTermos, deSenha);
		
		Empresa empresaSalva = empresaService.findByEmail(deEmail);
		
		request.setAttribute("idEmpresa", empresaSalva.getIdEmpresa());
		request.setAttribute("nmEmpresa", empresaSalva.getNmEmpresa());
		request.setAttribute("deEmail", empresaSalva.getDeEmail());
		request.setAttribute("cdRamoAtividade", empresa.getCdRamoAtividade());
		
		request.getRequestDispatcher("/WEB-INF/sucesso.jsp").forward(request, response);
			
	}

}

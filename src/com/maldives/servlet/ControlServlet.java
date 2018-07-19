package com.maldives.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.maldives.model.Empresa;
import com.maldives.resources.PacoteRecurso;
import com.maldives.service.EmpresaService;

/**
 * Servlet implementation class RegisterCompanyServlet
 */
@WebServlet("/RegisterCompanyServlet")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ControlServlet() {
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
		
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa(nmEmpresa);
		empresa.setCdRamoAtividade(cdRamoAtividade);
		empresa.setDeEmail(deEmail);
		empresa.setDeSenha(deSenha);
		
		new EmpresaService().registrarNovaEmpresa(empresa);	
		request.getRequestDispatcher("/WEB-INF/sucesso.html").forward(request, response);
			
	}

}

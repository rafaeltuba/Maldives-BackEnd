package com.maldives.repository;

import com.maldives.model.Empresa;

public interface EmpresaRepository {
	
	public boolean insert(Empresa empresa);
	 
	public Empresa findByEmail(final String email);
	
	/*public boolean save(Empresa empresa) {
		
		Connection connection = DBConnection.getConnection();
		try {
			String insertSql = "insert into empresa (nmEmpresa, deEmail, cdRamoAtividade) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertSql);
			statement.setString(1, empresa.getNmEmpresa());
			statement.setString(2, empresa.getDeEmail());
			statement.setInt(3, empresa.getCdRamoAtividade());
			statement.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Empresa findByEmail(final String email) {
		Connection connection = DBConnection.getConnection();
		Empresa empresaReturn = null;
		try {
			String selectSql = "select e.idEmpresa, e.deEmail, e.cdRamoAtividade, e.nmEmpresa from empresa e where e.deEmail = ?";
			
			PreparedStatement selectStatement = connection.prepareStatement(selectSql);
			selectStatement.setString(1, email);
			ResultSet resultSet = selectStatement.executeQuery();
			
			while (resultSet.next()) {
				empresaReturn = new Empresa();
				empresaReturn.setIdEmpresa(resultSet.getInt(1));
				empresaReturn.setDeEmail(resultSet.getString(2));
				empresaReturn.setCdRamoAtividade(resultSet.getInt(3));
				empresaReturn.setNmEmpresa(resultSet.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return empresaReturn;
	}*/
	
	/*public void deleteAll() throws SQLException {
		
		Connection connection = DBConnection.getConnection();
		try {
			String sql = "delete from empresa";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			System.out.println(statement);
		} finally {
			connection.close();
		}
	}
	
	public static void main(String[] args) {
		Empresa empresa = new Empresa();
		empresa.setNmEmpresa("Resultados Virtuais");
		empresa.setDeEmail("rafael@resultadosvirtuais.com");
		empresa.setCdRamoAtividade(1);
		new EmpresaRepository().save(empresa);
	}*/
	
	/*public List<Expense> listAllExpenses() throws SQLException {
		
		Connection connection = this.getConnection();
		List<Expense> expenses = new ArrayList<>();
		try {
			String selectSql = "select e.id, e.description, e.date, e.cost, te.description from expenses e join expensetype te on e.idexpensetype = te.id order by e.id";
			
			PreparedStatement selectStatement = connection.prepareStatement(selectSql);
			ResultSet resultSet = selectStatement.executeQuery();
			
			while (resultSet.next()) {
				Expense expense = new Expense();
				expense.setExpenseType(new ExpenseType());
				expense.setId(resultSet.getInt(1));
				expense.setDescription(resultSet.getString(2));
				expense.setDate(resultSet.getDate(3));
				expense.setCost(resultSet.getBigDecimal(4));
				expense.getExpenseType().setDescription(resultSet.getString(5));
				expenses.add(expense);
			}
		} finally {
			connection.close();
		}
		return expenses;
	}
	
	public Expense find(final Expense expense) throws SQLException {
		Connection connection = this.getConnection();
		Expense expenseReturn = null;
		try {
			String selectSql = "select e.id, e.description, e.date, e.cost, te.description from expenses e join expensetype te on e.idexpensetype = te.id where e.id = " + expense.getId();
			
			PreparedStatement selectStatement = connection.prepareStatement(selectSql);
			ResultSet resultSet = selectStatement.executeQuery();
			
			while (resultSet.next()) {
				expenseReturn = new Expense();
				expenseReturn.setExpenseType(new ExpenseType());
				expenseReturn.setId(resultSet.getInt(1));
				expenseReturn.setDescription(resultSet.getString(2));
				expenseReturn.setDate(resultSet.getDate(3));
				expenseReturn.setCost(resultSet.getBigDecimal(4));
				expenseReturn.getExpenseType().setDescription(resultSet.getString(5));
			}
		} finally {
			connection.close();
		}
		return expenseReturn;
	}
	
	public void registerExpense(final List<Expense> expenses) throws SQLException {
		for (Expense expense : expenses) {
			registerExpense(expense);
		} 
	}
	
	public void updateExpense(final Expense expense) throws SQLException {
		
		if ( expense == null ) throw new IllegalArgumentException("Object expense is null.");
		if ( expense.getId() == null ) throw new IllegalArgumentException("Field id is null.");
		if ((expense.getExpenseType() != null && expense.getExpenseType().getId() == null) &&
		   ( expense.getDescription() == null || "".equals(expense.getDescription())) &&
		   ( expense.getCost() == null ) &&
		   ( expense.getDate() == null )) 
				throw new IllegalArgumentException("All fields of the expense are null or empty.");
		
		
		
		Connection connection = this.getConnection();
		try {
			StringBuffer updateSql = new StringBuffer();
			if (expense.getExpenseType() != null && expense.getExpenseType().getId() != null) {
				updateSql.append(" idexpensetype = ? ");
			}
			if ( ! (expense.getDescription() == null || "".equals(expense.getDescription()))) {
				if (updateSql.length() > 0) updateSql.append(", ");
				updateSql.append(" description = ? ");
			}
			if ( expense.getCost() != null ) {
				if (updateSql.length() > 0) updateSql.append(", ");
				updateSql.append(" cost = ? ");
			}
			if ( expense.getDate() != null ) {
				if (updateSql.length() > 0) updateSql.append(", ");
				updateSql.append(" date = ? ");
			}
			
			PreparedStatement statement = connection.prepareStatement("update expenses set " + updateSql);
			System.out.println("update expense set " + updateSql);
			int paramIndex = 0;
			if (expense.getExpenseType() != null && expense.getExpenseType().getId() != null) {
				statement.setInt(++paramIndex, expense.getExpenseType().getId());
			}
			if ( ! (expense.getDescription() == null || "".equals(expense.getDescription()))) {
				statement.setString(++paramIndex, expense.getDescription());
			}
			if ( expense.getCost() != null ) {
				statement.setDouble(++paramIndex, expense.getCost().doubleValue());
			}
			if ( expense.getDate() != null ) {
				statement.setDate(++paramIndex, new java.sql.Date(expense.getDate().getTime()));
			}
			statement.execute();
		} finally {
			connection.close();
		}
	}
	
	public void deleteExpense(int idexpense) throws SQLException {
		Connection connection = this.getConnection();
		try {
			PreparedStatement deleteStatement = connection.prepareStatement("delete from expenses where id = " + idexpense);
			deleteStatement.execute();
		} finally {
			connection.close();
		}
	}


	
	public void cleanExpenses() throws SQLException {
		Connection connection = this.getConnection();
		try {
			String sql = "delete from expenses";
			Statement statement = connection.prepareStatement(sql);
			statement.execute(sql);
		} finally {
			connection.close();
		}
	}*/
}

package com.maldives.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompanyDB {

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/Maldives";
	
	//  Database credentials
    static final String USER = "root";
    static final String PASSWORD = "#Rafael01";
    
    private Connection getConnection() {
    	Connection conn = null;
        try {
           Class.forName("com.mysql.jdbc.Driver");
           conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
        } catch(SQLException se){
           se.printStackTrace();
        } catch(Exception e){
           e.printStackTrace();
        }
		return conn;
    }
    
    	
	public void registerExpense() throws SQLException {
		
		Connection connection = this.getConnection();
		try {
			String insertSql = "insert into country (idcountry, nmcountry) values (?,?)";
			PreparedStatement statement = connection.prepareStatement(insertSql);
			statement.setInt(1, 1);
			statement.setString(2, "Brasil");
			statement.execute();
		} finally {
			connection.close();
		}
	}
	
	public static void main(String[] args) {
		try {
			new CompanyDB().registerExpense();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
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

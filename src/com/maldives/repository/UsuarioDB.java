package com.maldives.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.maldives.model.Usuario;

public class UsuarioDB {

	public void save(Usuario usuario) throws SQLException {
		
		Connection connection = DBConnection.getConnection();
		try {
			String insertSql = "insert into usuario (deSenha, deEmailId, idEmpresa) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertSql);
			statement.setString(1, usuario.getDeSenha());
			statement.setString(2, usuario.getDeEmailId());
			statement.setInt(3, usuario.getIdEmpresa());
			statement.execute();
		} finally {
			connection.close();
		}
	}
	
	public void deleteAll() throws SQLException {
		
		Connection connection = DBConnection.getConnection();
		try {
			String sql = "delete from usuario";
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			System.out.println(statement);
		} finally {
			connection.close();
		}
	}
	
}

package com.maldives.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.maldives.model.Usuario;

public class UsuarioRepository {

	public boolean save(Usuario usuario) {
		
		Connection connection = DBConnection.getConnection();
		try {
			String insertSql = "insert into usuario (deSenha, deEmailId, idEmpresa) values (?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insertSql);
			statement.setString(1, usuario.getDeSenha());
			statement.setString(2, usuario.getDeEmailId());
			statement.setInt(3, usuario.getIdEmpresa());
			statement.execute();
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			try {
				connection.close();	
			}catch (SQLException e) {
				e.printStackTrace();
			}
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

	public Usuario findByEmail(String email) {
		Connection connection = DBConnection.getConnection();
		Usuario usuarioReturn = null;
		try {
			String selectSql = "select u.idEmpresa, u.deEmailId, u.deSenha, u.idUsuario from usuario u where u.deEmailId = ?";
			PreparedStatement selectStatement = connection.prepareStatement(selectSql);
			selectStatement.setString(1, email);
			
			System.out.println(selectStatement);
			ResultSet resultSet = selectStatement.executeQuery();
			
			while (resultSet.next()) {
				usuarioReturn = new Usuario();
				usuarioReturn.setIdEmpresa(resultSet.getInt(1));
				usuarioReturn.setDeEmailId(resultSet.getString(2));
				usuarioReturn.setDeSenha(resultSet.getString(3));
				usuarioReturn.setIdUsuario(resultSet.getInt(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return usuarioReturn;
	}
	
}

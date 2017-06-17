package com.santivallejo.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	/** Parametros de conexion */
	static String bd = "geo_localizacion_bbdd";
	static String login = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost/" + bd;

	Connection connection = null;

	/**
	 * Constructor de DbConnection
	 *
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public DbConnection() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		connection = DriverManager.getConnection(url, login, password);

	}

	/** Permite retornar la conexi�n */
	public Connection getConnection() {
		return connection;
	}

	public void desconectar() {
		connection = null;
	}
}

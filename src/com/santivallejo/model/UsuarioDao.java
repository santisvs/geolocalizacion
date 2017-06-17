package com.santivallejo.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.santivallejo.pojo.GeoException;
import com.santivallejo.pojo.Usuario;

public class UsuarioDao implements Persistable<Usuario> {

	@Override
	public int insert(Usuario p) throws GeoException {
		int resul = -1;
		DbConnection conn = null;
		PreparedStatement pst = null;
		try {
			conn = new DbConnection();

			String sql = "INSERT INTO `usuarios` (`nombre`) VALUES ( ? );";
			pst = conn.getConnection().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, p.getNombre());
			if (pst.executeUpdate() == 1) {

				ResultSet generatedKeys = pst.getGeneratedKeys();
				if (generatedKeys.next()) {
					p.setId(generatedKeys.getInt(1));
					resul = p.getId();
					sql = "INSERT INTO `detalles` (`usuario_id`,`cp`,`ciudad`) VALUES ( (select id from `usuarios` where nombre = ?), ?, ? );";
					pst = conn.getConnection().prepareStatement(sql,
							PreparedStatement.RETURN_GENERATED_KEYS);
					pst.setString(1, p.getNombre());
					pst.setString(2, p.getCp());
					pst.setString(3, p.getGeo());
					if (pst.executeUpdate() == 1) {
						generatedKeys = pst.getGeneratedKeys();
						if (generatedKeys.next()) {
							p.setId(generatedKeys.getInt(1));
							resul = p.getId();
						}
					} else {
						throw new GeoException(404,
								"No se ha podido incluir la ciudad en la base de datos");
					}
				} else {
					throw new GeoException(404,
							"No se ha podido incluir el usuario en la base de datos");
				}

			} else {
				throw new GeoException(404,
						"No se ha podido ejecutar la operacion en la base de datos");
			}
		} catch (ClassNotFoundException e1) {
			throw new GeoException(-1,
					"No se encuentra el driver necesario para conectar con la base de datos");
		} catch (SQLException e2) {
			throw new GeoException(404,
					"El usuario ya existe. Por favor incluye otro nombre de usuario.");
		}
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		conn.desconectar();
		return resul;
	}

	@Override
	public Usuario get(Usuario p) throws GeoException {
		
		DbConnection conn = null;
		PreparedStatement pst = null;
		try {
			conn = new DbConnection();

			String sql = "SELECT * FROM `detalles` WHERE `id` = ( SELECT `id` FROM `usuarios` WHERE `nombre` = ? );";
			
			pst = conn.getConnection().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, p.getNombre());
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()){
				p.setId(rs.getInt("id"));
				p.setCp(rs.getString("cp"));
			}
			
		} catch (ClassNotFoundException e1) {
			throw new GeoException(-1,
					"No se encuentra el driver necesario para conectar con la base de datos");
		} catch (SQLException e2) {
			throw new GeoException(404,
					"El usuario ya existe. Por favor incluye otro nombre de usuario.");
		}
		if (pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		conn.desconectar();
		return p;
	}
}
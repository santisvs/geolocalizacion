package com.santivallejo.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.santivallejo.pojo.Descuento;
import com.santivallejo.pojo.GeoException;
import com.santivallejo.pojo.Usuario;


public class DescuentoDao implements Persistable<Descuento>{

	@Override
	public int insert(Descuento persistable) throws GeoException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Descuento get(Descuento persistable) throws GeoException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Descuento set(Descuento descuento, Usuario usuario) throws GeoException {
		Descuento resul = null;
		DbConnection conn = null;
		PreparedStatement pst = null;
		try {
			conn = new DbConnection();

			String sql = "INSERT INTO `descuentos` (`usuario_id`,`porcentaje`,`area`) VALUES ( (select id from `usuarios` where nombre = ?), ?, ? );";
			pst = conn.getConnection().prepareStatement(sql,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setString(1, usuario.getNombre());
			pst.setDouble(2, descuento.getPorcentaje());
			pst.setString(3, descuento.getArea());
			if (pst.executeUpdate() == 1) {

				ResultSet generatedKeys = pst.getGeneratedKeys();
				if (generatedKeys.next()) {
					
					descuento.setId(usuario.getId());
					resul = descuento;
					
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

}

package com.santivallejo.service;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.santivallejo.model.DescuentoDao;
import com.santivallejo.model.UsuarioDao;
import com.santivallejo.pojo.Descuento;
import com.santivallejo.pojo.GeoException;
import com.santivallejo.pojo.Mensaje;
import com.santivallejo.pojo.Usuario;
import com.santivallejo.utils.CargaReglaDescuento;
import com.santivallejo.utils.CargaReglaUsuario;
import com.santivallejo.utils.ConvertJson;

@Path("/")
public class DroolsService {

	@GET
	@Path("/ciudad/{usuario}/{cp}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCodigoPostal(@PathParam("usuario") String usuario, @PathParam("cp") String cp) {

		Mensaje msj = null;
		Response res = null;
		UsuarioDao dao = null;

		Usuario usu = new Usuario(usuario, cp);

		if (usu.getCp() != null) {

			// Consumir regla de negocio
			CargaReglaUsuario.Load(usu, "SetCiudad.drl");

			// Capa de transaccion
			dao = new UsuarioDao();

			try {
				dao.insert(usu);
				msj = new Mensaje(200, "La ciudad del usuario " + usu.getNombre() + " es " + usu.getGeo() + ".");
				String json = ConvertJson.convertMensajeToJson(msj);

				res = Response.ok(json, MediaType.APPLICATION_JSON).build();
			} catch (GeoException e) {
				msj = new Mensaje(e.getStatusCode(), e.getMsjException());
				String json = ConvertJson.convertMensajeToJson(msj);
				res = Response.status(Status.BAD_REQUEST).entity(json).build();
			}
		} else {
			msj = new Mensaje(0, "El codigo postal es incorrecto.");
			String json = ConvertJson.convertMensajeToJson(msj);
			res = Response.status(Status.BAD_REQUEST).entity(json).build();
		}

		return res;

	}

	@GET
	@Path("/cp/{usuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuario(@PathParam("usuario") String usuario) {

		Mensaje msj = null;
		Response res = null;
		UsuarioDao dao = null;

		Usuario usu = new Usuario();

		usu.setNombre(usuario);

		// TODO Recuperar Cp de usuario de BBDD
		dao = new UsuarioDao();

		try {
			usu = dao.get(usu);
		} catch (GeoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Asignarle la ciudad teniendo en cuenta el CP
		// Consumir regla de negocio
		CargaReglaUsuario.Load(usu, "SetCiudad.drl");

		// TODO entregar el usuario en JSON
		msj = new Mensaje(200, "La ciudad del usuario " + usu.getNombre() + " es " + usu.getGeo()
				+ ". Con código postal " + usu.getCp());

		String json = ConvertJson.convertMensajeToJson(msj);

		res = Response.ok(json, MediaType.APPLICATION_JSON).build();

		return res;

	}

	@POST
	@Path("/porcentaje/{usuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response setPorcentaje(@PathParam("usuario") String usuario) {

		Mensaje msj = null;
		Response res = null;
		UsuarioDao daoUsu = null;
		DescuentoDao daoDes = null;

		Usuario usu = new Usuario();
		usu.setNombre(usuario);

		// Recuperar Cp de usuario de BBDD
		daoUsu = new UsuarioDao();

		try {
			usu = daoUsu.get(usu);
		} catch (GeoException e) {
			e.printStackTrace();
		}

		// Asignarle la ciudad teniendo en cuenta el CP
		CargaReglaUsuario.Load(usu, "SetCiudad.drl");

		Descuento des = new Descuento();

		// TODO Asignar porcentaje de descuento
		CargaReglaDescuento.Load(usu, des, "SetDescuento.drl");
		
		// Set info en BBDD
		daoDes = new DescuentoDao();
		try {
			des = daoDes.set(des, usu);
		} catch (GeoException e) {
			e.printStackTrace();
		}

		// TODO entregar el usuario en JSON
		msj = new Mensaje(200, "La ciudad del usuario " + usu.getNombre() + " es " + usu.getGeo()
				+ ". Con código postal " + usu.getCp() + ". El descuento es de " +des.getPorcentaje()+ " para el área de " + des.getArea());

		String json = ConvertJson.convertMensajeToJson(msj);

		res = Response.ok(json, MediaType.APPLICATION_JSON).build();

		return res;

	}

}
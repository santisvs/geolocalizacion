package com.santivallejo.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.glassfish.jersey.client.ClientConfig;

import com.santivallejo.model.UsuarioDao;
import com.santivallejo.pojo.GeoException;
import com.santivallejo.pojo.Mensaje;
import com.santivallejo.pojo.PostalCodes;
import com.santivallejo.pojo.Usuario;
import com.santivallejo.utils.ConvertJson;

@Path("/")
public class GeoService {

	@GET
	@Path("/add/{usuario}/{cp}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCodigoPostal(@PathParam("usuario") String usuario,
			@PathParam("cp") String cp) {

		Mensaje msj = null;
		Response res = null;
		UsuarioDao dao = null;

		Usuario usu = new Usuario(usuario, cp);

		if (usu.getCp() != null) {

			ClientConfig config = new ClientConfig();

			Client client = ClientBuilder.newClient(config);

			WebTarget target = client
					.target("http://api.geonames.org/postalCodeLookupJSON?postalcode="
							+ cp + "&country=ES&username=santi07");

			String response = target.request(MediaType.APPLICATION_JSON).get(
					String.class);

			PostalCodes lista = ConvertJson.convertJsonToPostalCodes(response);

			usu.setGeo(lista.get(0).getAdminName1());

			dao = new UsuarioDao();

			try {
				dao.insert(usu);
				msj = new Mensaje(200, "La ciudad del usuario "
						+ usu.getNombre() + " es " + usu.getGeo() + ".");
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
}

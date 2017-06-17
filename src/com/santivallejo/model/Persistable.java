package com.santivallejo.model;

import com.santivallejo.pojo.GeoException;

/**
 * Interfaz para dar la habilidad de que sean Persistables los DAOs.<br>
 * Se encarga de que se implementen las operaciones mas basicas de CRUD.
 *
 * @param <P>
 *            Clase generica la que luego sustituimos por nuestra clase
 *            concreta, por ejemplo <code>Persona</code>
 *
 * @author ur00
 *
 */
public interface Persistable<P> {

	/**
	 * Inserta un nuevo objeto
	 *
	 * @param persistable
	 *            {@code P} Objeto a insertar
	 * @return {@code int} identificador del objeto insertado, -1 en caso
	 *         contrario
	 * @throws GeoException
	 */
	int insert(P persistable) throws GeoException;
	
	P get(P persistable) throws GeoException;

}
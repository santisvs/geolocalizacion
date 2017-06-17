package com.santivallejo.pojo;

import java.util.ArrayList;
import java.util.List;

public class PostalCodes extends ArrayList<PostalC> {

	private static final long serialVersionUID = 5859767328449522758L;

	public PostalCodes() {
		new ArrayList<PostalC>();
	}

	public PostalCodes(List<PostalC> lista) {
		this.addAll(lista);
	}
}

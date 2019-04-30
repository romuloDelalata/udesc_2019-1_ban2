package com.udesc.rotas;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/api/teste")
public class TesteResource {
	
	@GET
	@Path("teste")
	public String buscaAnimais() {
		System.out.println("teste rest");
		return "miraceli";
	}
}

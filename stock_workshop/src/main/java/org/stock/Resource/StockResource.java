package org.stock.Resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/stock")
@Produces(MediaType.APPLICATION_JSON)
public class StockResource {
	@Inject
	ProduitService produitService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @GET
    @Path("findByCode/{code}")
    public Response findByCode(@PathParam("code")String code)
    {
    	
    	Produit prod=produitService.findByCode(code);
    	if(prod!=null)
    		return Response.ok(prod).build();
    	return Response.noContent().build();
    	
    }
}
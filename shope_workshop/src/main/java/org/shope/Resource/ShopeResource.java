package org.shope.Resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import net.bytebuddy.implementation.bytecode.Throw;


@Path("/api/shope")
public class ShopeResource {
	

	@Inject
	@RestClient
	ShopeService ShopeService;
	
	@Inject
	@RestClient
	CompteService compteService;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello";
    }
    
    @Path("shope/{code}/{rib}/{qte}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByCode(@PathParam("code")String code,@PathParam("rib") Long rib,@PathParam("qte") int qte)
    {
    	
    	Produit p=ShopeService.findByCode(code);
    	if(p==null)
    		return Response.serverError().build();
    		
    		
    	else
    		{Compte cp =compteService.findByRib(rib);
    		if(cp==null)
        	return 	Response.serverError().build();
    		
    		else
    			if(p.prix*qte>cp.mantant)
    	    	return	Response.serverError().build();
    			else
    			return 	Response.ok(new Commande(p.nom,p.prix*qte, qte)).build();

    		}
    		
    		
    	
    }
    

    
}
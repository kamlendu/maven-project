/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testclient;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import token.GenerateToken;

/**
 *
 * @author root
 */
@RegisterRestClient(configKey = "myclient1")
public interface MyRestClient {
     @GET
      @ClientHeaderParam(name="authorization", value="{generateJWTToken}")
    @Produces(MediaType.TEXT_PLAIN)
    public String get();
    
    default String generateJWTToken()
    {
        Config config = ConfigProvider.getConfig();
        // Testing with the jwtenizer. The token generated is copied in jwt-string key
         //String token ="Bearer "+config.getValue("jwt-string", String.class) ;
       // Token dynamically generated
         String token ="Bearer "+ GenerateToken.generateJWT();
         System.out.println("Token = "+token);
         return token;
    }
}

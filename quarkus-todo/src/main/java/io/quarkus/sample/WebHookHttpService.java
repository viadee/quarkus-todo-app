package io.quarkus.sample;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Path("/")
@RegisterRestClient(configKey = "webhook")
public interface WebHookHttpService {
  @POST
  void call(WebHookMessage message);
}

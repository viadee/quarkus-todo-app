package io.quarkus.sample;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/")
public interface WebHookHttpService {
  @POST
  void call(WebHookMessage message);
}

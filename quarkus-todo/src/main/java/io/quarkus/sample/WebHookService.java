package io.quarkus.sample;

import java.net.MalformedURLException;
import java.net.URL;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.RestClientDefinitionException;

@ApplicationScoped
public class WebHookService {
  @Inject
  private WebHookConfig config;

  public void callWebHook(String message) {
    if (!config.url().startsWith("http")) {
      return;
    }
    var messageObject = WebHookMessage.builder().message(message).build();
    try {
      getWebHookHttpService().call(messageObject);
    } catch (IllegalStateException | RestClientDefinitionException | MalformedURLException e) {
      e.printStackTrace();
    }
  }

  private WebHookHttpService getWebHookHttpService() throws IllegalStateException, RestClientDefinitionException, MalformedURLException {
    return RestClientBuilder.newBuilder()
      .baseUrl(new URL(config.url()))
      .build(WebHookHttpService.class);
  }
}

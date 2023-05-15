package io.quarkus.sample;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.rest.client.inject.RestClient;

@ApplicationScoped
public class WebHookService {
  @RestClient
  private WebHookHttpService webHookHttpService;

  public void callWebHook(String message) {
    var messageObject = WebHookMessage.builder().message(message).build();
    try {
      webHookHttpService.call(messageObject);
    } catch (RuntimeException e) {
      e.printStackTrace();
    }
  }
}

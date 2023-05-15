package io.quarkus.sample;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;

@QuarkusTest
public class WebHookServiceTest {
  @Inject
  private WebHookService webHookService;

  @InjectMock
  private WebHookHttpService webHookHttpService;

  @Test
  void testCallWebHook() {
    var captor = ArgumentCaptor.forClass(WebHookMessage.class);
    webHookService.callWebHook("test");
    verify(webHookHttpService).call(captor.capture());
    assertEquals("test", captor.getValue().getMessage());
  }
}

package io.quarkus.sample;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebHookMessage {
  private String message;
}

package io.quarkus.sample;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

@ConfigMapping(prefix = "webhook")
public interface WebHookConfig {
  @WithDefault("none")
  String url();
}

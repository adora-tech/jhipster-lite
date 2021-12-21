package tech.jhipster.lite.generator.server.sonar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import tech.jhipster.lite.UnitTest;

@UnitTest
public class SonarTest {

  @Test
  void shouldGetMavenPluginVersion() {
    assertThat(Sonar.getMavenPluginVersion()).isEqualTo("3.9.1.2184");
  }

  @Test
  void shouldGetSonarqubeDockerVersion() {
    assertThat(Sonar.getSonarqubeDockerVersion()).isEqualTo("9.2.4-community");
  }
}

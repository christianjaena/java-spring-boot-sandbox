package com.christianjaena;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.runner.ApplicationContextRunner;

import static org.assertj.core.api.Assertions.assertThat;

class AppConfigTest {

    private final ApplicationContextRunner contextRunner =
            new ApplicationContextRunner()
                    .withUserConfiguration(AppConfig.class);

    @Test
    void myServiceBeanIsPresent() {
        contextRunner.run((context) -> assertThat(context).hasSingleBean(MyService.class));
    }

    @Test
    void facialLoginBeanIsNotPresent() {
        contextRunner.withPropertyValues("feature.facial-login.enabled=false")
                .run(context -> {
                    assertThat(context).doesNotHaveBean(FacialLogin.class);
                    assertThat(context).doesNotHaveBean(Login.class);
                });
    }

    @Test
    void facialLoginBeanIsPresent() {
        contextRunner.withPropertyValues("feature.facial-login.enabled=true")
                .run(context -> {
                    assertThat(context).hasSingleBean(FacialLogin.class);
                    assertThat(context).hasSingleBean(Login.class);
                });
    }

}
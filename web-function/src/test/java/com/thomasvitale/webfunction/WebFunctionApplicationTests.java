package com.thomasvitale.webfunction;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebFunctionApplicationTests {

    @Autowired
    private WebTestClient webClient;

    @Test
    void testFunctionDefinitionApi() {
        String expectedSkill = "I can play the PIANO";
        webClient.post()
                .bodyValue("piano")
                .exchange()
                .expectBody(String.class)
                .isEqualTo(expectedSkill);
    }

}

package guru.springframework.joke.jokeapp.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class JokeServiceImplIT {

    @Autowired
    ChuckNorrisQuotes chuckNorrisQuotes;

    @Test
    void testJoke() {
        assertThat(chuckNorrisQuotes.getRandomQuote()).isNotNull()
            .containsIgnoringCase("Chuck")
            .containsIgnoringCase("Norris");
    }

}
package guru.springframework.joke.jokeapp.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JokeServiceImplTest {

    @Test
    void testJoke() {
        ChuckNorrisQuotes chuckNorrisQuotes = new ChuckNorrisQuotes();
        assertThat(chuckNorrisQuotes.getRandomQuote())
            .isNotNull()
            .containsIgnoringCase("Chuck")
            .containsIgnoringCase("Norris");
    }
}
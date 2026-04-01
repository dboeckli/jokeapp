package guru.springframework.joke.jokeapp.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JokeServiceImplTest {

    @Test
    void testJoke() {
        ChuckNorrisQuotes chuckNorrisQuotes = new ChuckNorrisQuotes();
        String joke = chuckNorrisQuotes.getRandomQuote();
        assertThat(joke).isNotNull()
            .satisfiesAnyOf(j -> assertThat(j).containsIgnoringCase("Chuck").containsIgnoringCase("Norris"),
                    j -> assertThat(j).containsIgnoringCase("Superman"));
    }

    @RepeatedTest(200)
    void testJokeRepeated() {
        ChuckNorrisQuotes chuckNorrisQuotes = new ChuckNorrisQuotes();
        String joke = chuckNorrisQuotes.getRandomQuote();
        assertThat(joke).isNotNull()
            .satisfiesAnyOf(j -> assertThat(j).containsIgnoringCase("Chuck").containsIgnoringCase("Norris"),
                    j -> assertThat(j).containsIgnoringCase("Superman"));
    }

}
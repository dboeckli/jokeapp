package guru.springframework.joke.jokeapp.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JokeServiceImplTest {

    @Test
    void testJoke() {
        JokeService jokeService = new JokeServiceImpl(new ChuckNorrisQuotes());
        assertValidJoke(jokeService.getJoke());
    }

    @RepeatedTest(200)
    void testJokeRepeated() {
        String joke = new ChuckNorrisQuotes().getRandomQuote();
        assertValidJoke(joke);
    }

    private void assertValidJoke(String joke) {
        assertThat(joke).isNotNull()
            .satisfiesAnyOf(j -> assertThat(j).containsIgnoringCase("Chuck").containsIgnoringCase("Norris"),
                    j -> assertThat(j).containsIgnoringCase("Superman"));
    }

}
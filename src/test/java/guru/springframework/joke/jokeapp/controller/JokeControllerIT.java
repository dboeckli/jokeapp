package guru.springframework.joke.jokeapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import static guru.springframework.joke.jokeapp.controller.JokeController.ATTRIBUTE_NAME;
import static guru.springframework.joke.jokeapp.controller.JokeController.CHUCK_NORRIS_JOKE_VIEW;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
class JokeControllerIT {

    @Autowired
    JokeController controller;

    @Test
    void testJoke() {
        // Given
        Model model = new ExtendedModelMap();

        String viewName = controller.showJoke(model);
        String joke = (String)model.getAttribute(ATTRIBUTE_NAME);

        // Then
        assertEquals(CHUCK_NORRIS_JOKE_VIEW, viewName);
        assertThat(joke)
            .isNotNull()
            .contains("Chuck Norris");
    }
}
package guru.springframework.joke.jokeapp.controller;

import guru.springframework.joke.jokeapp.service.JokeService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.List;

import static guru.springframework.joke.jokeapp.controller.JokeController.ATTRIBUTE_NAME;
import static guru.springframework.joke.jokeapp.controller.JokeController.CHUCK_NORRIS_JOKE_VIEW;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

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
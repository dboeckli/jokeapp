package guru.springframework.joke.jokeapp.controller;

import guru.springframework.joke.jokeapp.service.JokeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.ui.Model;

import static guru.springframework.joke.jokeapp.controller.JokeController.ATTRIBUTE_NAME;
import static guru.springframework.joke.jokeapp.controller.JokeController.CHUCK_NORRIS_JOKE_VIEW;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class JokeControllerTest {

    @Mock
    JokeService jokeService;

    @Mock
    Model model;

    JokeController controller;

    @BeforeEach
    void setUp() {
        openMocks(this);
        controller = new JokeController(jokeService);
    }

    @Test
    void testJoke() {
        when(jokeService.getJoke()).thenReturn("this is a moked joke");

        String viewName = controller.showJoke(model);

        assertEquals(CHUCK_NORRIS_JOKE_VIEW, viewName);
        verify(model).addAttribute(ATTRIBUTE_NAME, "this is a moked joke");
    }

}
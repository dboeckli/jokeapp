package guru.springframework.joke.jokeapp.controller;

import guru.springframework.joke.jokeapp.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
public class JokeController {

    private final JokeService jokeService;

    public static final String CHUCK_NORRIS_JOKE_VIEW = "chucknorris";

    public static final String ATTRIBUTE_NAME = "joke";

    @RequestMapping({"/", ""})
    public String showJoke(Model model) {
        model.addAttribute(ATTRIBUTE_NAME, jokeService.getJoke());
        return CHUCK_NORRIS_JOKE_VIEW;
    }
}

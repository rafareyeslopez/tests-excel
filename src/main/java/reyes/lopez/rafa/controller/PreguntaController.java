package reyes.lopez.rafa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import reyes.lopez.rafa.model.Pregunta;
import reyes.lopez.rafa.repository.UserRepository;

@Controller
public class PreguntaController {

	@Autowired
	private UserRepository preguntaRepository;

	@GetMapping("/signup")
	public String showSignUpForm(Pregunta pregunta) {
		return "crear-pregunta";
	}

	@PostMapping("/crearpregunta")
	public String addUser(@Valid Pregunta pregunta, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "crear-pregunta";
		}

		preguntaRepository.save(pregunta);
		model.addAttribute("preguntas", preguntaRepository.findAll());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		final Pregunta pregunta = preguntaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalido pregunta Id:" + id));

		model.addAttribute("pregunta", pregunta);
		return "actualizar-pregunta";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid Pregunta pregunta, BindingResult result, Model model) {
		if (result.hasErrors()) {
			pregunta.setId(id);
			return "actualizar-pregunta";
		}

		preguntaRepository.save(pregunta);
		model.addAttribute("preguntas", preguntaRepository.findAll());
		return "index";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		final Pregunta user = preguntaRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		preguntaRepository.delete(user);
		model.addAttribute("preguntas", preguntaRepository.findAll());
		return "index";
	}
}
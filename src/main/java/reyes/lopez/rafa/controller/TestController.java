/*
 * Copyright (C) IDB Mobile Technology S.L. - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */
package reyes.lopez.rafa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import reyes.lopez.rafa.model.Test;
import reyes.lopez.rafa.repository.TestRepository;

@Controller
public class TestController {

	@Autowired
	private TestRepository testRepository;

	@GetMapping("/")
	public String showTests(final Model model) {
		model.addAttribute("tests", testRepository.findAll());
		return "index";
	}

	@GetMapping("/signup")
	public String showSignUpForm(final Test test) {
		return "crear-test";
	}

	@PostMapping("/creartest")
	public String addUser(@Valid final Test test, final BindingResult result, final Model model) {
		if (result.hasErrors()) {
			return "crear-test";
		}

		testRepository.save(test);
		model.addAttribute("tests", testRepository.findAll());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") final long id, final Model model) {
		final Test test = testRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalido test Id:" + id));

		model.addAttribute("test", test);
		return "actualizar-test";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") final long id, @Valid final Test test, final BindingResult result,
			final Model model) {
		if (result.hasErrors()) {
			test.setId(id);
			return "actualizar-test";
		}

		testRepository.save(test);
		model.addAttribute("tests", testRepository.findAll());
		return "index";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") final long id, final Model model) {
		final Test test = testRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid test Id:" + id));
		testRepository.delete(test);
		model.addAttribute("tests", testRepository.findAll());
		return "index";
	}
}
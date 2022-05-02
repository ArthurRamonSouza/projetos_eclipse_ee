package com.myrepository.lojavirtual.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myrepository.lojavirtual.model.Funcionario;
import com.myrepository.lojavirtual.repository.FuncionarioRepository;


@Controller
@RequestMapping("funcionario")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@GetMapping("cadastrar")
	public ModelAndView cadastrar(Funcionario funcionario) {
		ModelAndView mv = new ModelAndView("admin/funcionario/cadastro");
		mv.addObject(funcionario);
		return mv;
	}
	
	@GetMapping("listar")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("admin/funcionario/lista");
		mv.addObject("listaFuncionarios", funcionarioRepository.findAll());
		return mv;
	}
	
	@PostMapping("salvar")
	public ModelAndView salvar(@Valid Funcionario funcionario, BindingResult result) {
		ModelAndView mv = new ModelAndView("admin/home");
		if(result.hasErrors()) {
			return cadastrar(funcionario);
		} else {
			funcionarioRepository.saveAndFlush(funcionario);
		}
			return mv;
		}
		
	@GetMapping("editar/{id}")
	public ModelAndView editar(@PathVariable(name = "id") Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		return cadastrar(funcionario.get());
	}
	
	@GetMapping("excluir/{id}")
	public ModelAndView excluir(@PathVariable(name = "id") Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		funcionarioRepository.delete(funcionario.get());
		return listar();
	}
	
}

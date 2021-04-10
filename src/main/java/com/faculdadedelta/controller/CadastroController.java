package com.faculdadedelta.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.faculdadedelta.model.Fornecedor;
import com.faculdadedelta.repository.FornecedorRepository;


@Controller
public class CadastroController {
	
	@Autowired
	private FornecedorRepository fr;
		
		@RequestMapping(value="cadastrofornecedor", method = RequestMethod.GET )
		public String form() {
			return "formulario";
		}
		

		
		@RequestMapping(value="cadastrofornecedor", method = RequestMethod.POST)
		public String form(Fornecedor fornecedor) {
			
			LocalDateTime agora = LocalDateTime.now();
			DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			String date = formato.format(agora);
			fornecedor.setDtCadastro(date);
			
			fornecedor.setStatus("ativo");
			
			fr.save(fornecedor);
			return "formulario";
		}
		
		@RequestMapping ("/listaCadastroFornecedor")
		public ModelAndView listar() {
			ModelAndView mv = new ModelAndView("lista");
			Iterable<Fornecedor> fornecedores = fr.findAll();	
			
			mv.addObject("fornecedores", fornecedores);
			
			return mv;
		}		
		
		@GetMapping("/delete/{id}")
		public String delForn(@PathVariable("id") int id) {
			Fornecedor fornecedor = fr.findById(id);
			fr.delete(fornecedor);
			return "redirect:/listaCadastroFornecedor";
		}
		
}


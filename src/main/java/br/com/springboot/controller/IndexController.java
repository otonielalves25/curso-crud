package br.com.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.modelo.Usuario;
import br.com.springboot.repository.UsuarioRepository;

@RestController
public class IndexController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@GetMapping("/lista")
	@ResponseBody
	public ResponseEntity<List<Usuario>> list() {
		List<Usuario> listagem = usuarioRepository.findAll();
		return new ResponseEntity<>(listagem, HttpStatus.OK);
	}

	@PostMapping("/salvar")
	@ResponseBody
	public ResponseEntity<Usuario> salve(@RequestBody Usuario usuario) {
		Usuario user = usuarioRepository.save(usuario);
		return new ResponseEntity<Usuario>(user, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete")
	@ResponseBody
	public ResponseEntity<String> deletar(@RequestParam Long id) {
		usuarioRepository.deleteById(id);
		return new ResponseEntity<String>("Deletado com sucesso", HttpStatus.OK);
	}


	
	@GetMapping("/procuranome")
	@ResponseBody
	public ResponseEntity<List<Usuario>> procuranome(@RequestParam(name = "nome") String nome) {
		List<Usuario> listagem = usuarioRepository.findByNameLike(nome);
		return new ResponseEntity<>(listagem, HttpStatus.OK);
	}

}

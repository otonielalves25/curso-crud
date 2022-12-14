package br.com.springboot.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.springboot.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	
	@Query("SELECT u FROM Usuario u WHERE u.nome LIKE %?1%")
	List<Usuario> findByNameLike(String procura);
	


}

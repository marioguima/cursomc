package br.com.guimassolucoes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guimassolucoes.domain.Categoria;
import br.com.guimassolucoes.repositories.CategoriaRepository;
import br.com.guimassolucoes.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria buscar(Integer id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Categoria não encontrada! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

}

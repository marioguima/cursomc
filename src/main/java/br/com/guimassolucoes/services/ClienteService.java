package br.com.guimassolucoes.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.guimassolucoes.domain.Cliente;
import br.com.guimassolucoes.repositories.ClienteRepository;
import br.com.guimassolucoes.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository ClienteRepository;

	public Cliente buscar(Integer id) {
		Optional<Cliente> Cliente = ClienteRepository.findById(id);
		return Cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Cliente não encontrada! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

}

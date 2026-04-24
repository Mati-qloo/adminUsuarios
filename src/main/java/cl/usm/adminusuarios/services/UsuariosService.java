package cl.usm.adminusuarios.services;

import cl.usm.adminusuarios.entities.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuariosService {
    Usuario createUser(Usuario usuario);
    List<Usuario> getAll();
    Optional<Usuario> findByEmail(String email);
}

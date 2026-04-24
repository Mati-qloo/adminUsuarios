package cl.usm.adminusuarios.repositories;

import cl.usm.adminusuarios.entities.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UsuariosRepository extends MongoRepository<Usuario,String> {
}

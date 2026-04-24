package cl.usm.adminusuarios.controllers;

import cl.usm.adminusuarios.entities.Usuario;
import cl.usm.adminusuarios.services.UsuariosService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/usuarios")
    public ResponseEntity<List<Usuario>> getAll(@RequestParam(required = false) String q){
        try{
            if (q != null && !q.isEmpty()){
                List<Usuario> filtrados = this.usuariosService.filter(q);
                return ResponseEntity.ok(filtrados);
            }
            List<Usuario> usuarios = this.usuariosService.getAll();
            return ResponseEntity.ok(usuarios);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/usuarios")
     public ResponseEntity<?> createUser(@Valid @RequestBody Usuario usuario){
        Usuario res=this.usuariosService.createUser(usuario);
        if (res != null){
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/usuarios/{email}")
    public ResponseEntity<Usuario> finByEmail(@PathVariable String email){
        try {
            Optional<Usuario> usuario = this.usuariosService.findByEmail(email);
            if (usuario.isEmpty()) {
                return ResponseEntity.notFound().build();
            }
            Usuario usuarioObtenido = usuario.get();
            return ResponseEntity.ok(usuarioObtenido);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }

    }
}

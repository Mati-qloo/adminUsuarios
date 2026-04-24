package cl.usm.adminusuarios.controllers;

import cl.usm.adminusuarios.entities.Usuario;
import cl.usm.adminusuarios.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuariosController {

    @Autowired
    private UsuariosService usuariosService;

    @GetMapping("/usuarios")
    ResponseEntity<List<Usuario>> getAll(){
        try{
            List<Usuario> usuarios = this.usuariosService.getAll();
            return ResponseEntity.ok(usuarios);
        }catch (Exception ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/usuarios")
    ResponseEntity<?> createUser(@RequestBody Usuario usuario){
        Usuario res=this.usuariosService.createUser(usuario);
        if (res != null){
            return ResponseEntity.ok(usuario);
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("/usuarios/{email}")
    public ResponseEntity<?> finByEmail(@PathVariable String email){
        return null;

    }
}

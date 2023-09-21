package com.hiberus.controladores;

import com.hiberus.dto.PizzaDto;
import com.hiberus.dto.UsuarioDto;
import com.hiberus.modelos.Usuario;
import com.hiberus.servicios.ServicioPizzas;
import com.hiberus.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/usuarios")
public class ControladorUsuario {

    @Autowired
    ServicioUsuarios servicioUsuarios;

    @Autowired
    ServicioPizzas servicioPizzas;

    @PostMapping(value = "/crearUsuario")
    public ResponseEntity<UsuarioDto> crearUsuario(@RequestBody Map<String,ArrayList<String>> body){
    	//Se convierte el body a un array de integer
    	ArrayList<String> pizzasFavoritas = body.get("pizzasFavoritas");
    	ArrayList<Integer> pizzasFavoritasUsuario = new ArrayList<Integer>();
    	for(String pizza : pizzasFavoritas) {
    		pizzasFavoritasUsuario.add(Integer.parseInt(pizza));
    	}
		Usuario usuario = servicioUsuarios.crearUsuario(body.get("nombre").get(0),pizzasFavoritasUsuario);
    	UsuarioDto usuarioDto = new UsuarioDto(usuario.getId(),usuario.getNombre(),usuario.getPizzasFavoritas());
    	return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
	
    }
    
    @PutMapping(value = "/modificarUsuario/{id}")
    public ResponseEntity<UsuarioDto> modificarUsuario(@PathVariable Integer id,@RequestBody Map<String,ArrayList<String>> body) {
    	Optional<Usuario> usuario = servicioUsuarios.obtenerUsuarioPorId(id);
    	if(usuario.isEmpty()) { //no existe
    		return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_FOUND);
    	}else {
    		ArrayList<String> pizzasFavoritas = body.get("pizzasFavoritas");
        	ArrayList<Integer> pizzasFavoritasUsuario = new ArrayList<Integer>();
        	for(String pizza : pizzasFavoritas) {
        		pizzasFavoritasUsuario.add(Integer.parseInt(pizza));
        	}
        	usuario.get().setNombre(body.get("nombre").get(0));
    		usuario.get().setPizzasFavoritas(pizzasFavoritasUsuario);
    		if(servicioUsuarios.modificarUsuario(usuario) != null){
    			UsuarioDto usuarioDto = new UsuarioDto(usuario.get().getId(),usuario.get().getNombre(),usuario.get().getPizzasFavoritas()); 
        		return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
    		}else { //falla la modificacion
    			return new ResponseEntity<UsuarioDto>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    	}
    }
    
    @DeleteMapping(value = "/eliminarUsuario/{id}")
    public ResponseEntity<String> eliminarUsuario(@PathVariable Integer id){
    	Optional<Usuario> usuario = servicioUsuarios.obtenerUsuarioPorId(id);
    	if(usuario.isEmpty()) { //no existe
    		return new ResponseEntity<String>("No existe el usuario",HttpStatus.NOT_FOUND);
    	}else {
    		servicioUsuarios.eliminarUsuario(id);
    		return new ResponseEntity<String>("Usuario con nombre " + usuario.get().getNombre() + " eliminado",HttpStatus.OK);
    	}
    }
    
    
    @GetMapping(value = "/obtenerUsuarios")
    public ResponseEntity<List<UsuarioDto>> obtenerUsuarios(){
        List<Usuario> listaUsuarios = servicioUsuarios.obtenerUsuarios();
        if(listaUsuarios != null) {
        	List<UsuarioDto> listaUsuariosDto = new ArrayList<>();
            for(Usuario usuario : listaUsuarios){
            	UsuarioDto usuarioDto = new UsuarioDto(usuario.getId(),usuario.getNombre(),usuario.getPizzasFavoritas());
                listaUsuariosDto.add(usuarioDto);
            }
            return new ResponseEntity<>(listaUsuariosDto, HttpStatus.OK);
        }else {
        	return new ResponseEntity<List<UsuarioDto>>(HttpStatus.NOT_FOUND);
        }
        
    }

    
   
    @PutMapping(value = "/marcarPizzasFavoritasUsuario/{id}")
    public ResponseEntity<UsuarioDto> marcarPizzasFavoritasUsuario(@PathVariable Integer id,@RequestBody Integer idPizzaFavorita) {
    	Optional<Usuario> usuario = servicioUsuarios.obtenerUsuarioPorId(id);
    	if(usuario.isEmpty()) { //no existe
    		return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_FOUND);
    	}else {
    		//Se comprueba que la pizza NO se encuentra en el listado
    		if(usuario.get().getPizzasFavoritas().contains(idPizzaFavorita)) {
    			return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_FOUND);
    		}
    		//Se comprueba que la pizza existe, llamar desde usuario a pizza-read
    		List<Integer> idsPizzasExistentes = servicioPizzas.obtenerIdsPizzas();
    		if(!(idsPizzasExistentes.contains(idPizzaFavorita))) {
    			return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_FOUND);
    		}
    		
    		usuario.get().getPizzasFavoritas().add(idPizzaFavorita);
    		if(servicioUsuarios.modificarUsuario(usuario) != null){
    			UsuarioDto usuarioDto = new UsuarioDto(usuario.get().getId(),usuario.get().getNombre(),usuario.get().getPizzasFavoritas()); 
        		return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
    		}else { //falla la modificacion
    			return new ResponseEntity<UsuarioDto>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    	}
    }
    
    
    @PutMapping(value = "/desmarcarPizzasFavoritasUsuario/{id}")
    public ResponseEntity<UsuarioDto> desmarcarPizzasFavoritasUsuario(@PathVariable Integer id,@RequestBody Integer idPizzaFavorita) {
    	Optional<Usuario> usuario = servicioUsuarios.obtenerUsuarioPorId(id);
    	if(usuario.isEmpty()) { //no existe
    		return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_FOUND);
    	}else {
    		//Se comprueba que la pizza SI se encuentra en el listado
    		if(!(usuario.get().getPizzasFavoritas().contains(idPizzaFavorita))){
    			return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_FOUND);
    		}
    		
    		usuario.get().getPizzasFavoritas().remove(idPizzaFavorita);
    		if(servicioUsuarios.modificarUsuario(usuario) != null){
    			UsuarioDto usuarioDto = new UsuarioDto(usuario.get().getId(),usuario.get().getNombre(),usuario.get().getPizzasFavoritas()); 
        		return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
    		}else { //falla la modificacion
    			return new ResponseEntity<UsuarioDto>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    	}
    }
}

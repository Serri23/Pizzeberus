package com.hiberus.controladores;

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
    	Usuario usuario = servicioUsuarios.crearUsuario(body.get("nombre").get(0),body.get("pizzasFavoritas"));
    	UsuarioDto usuarioDto = new UsuarioDto(usuario.getId(),usuario.getNombre(),usuario.getPizzasFavoritas());
    	return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
    }
    
    @PutMapping(value = "/modificarUsuario/{id}")
    public ResponseEntity<UsuarioDto> modificarUsuario(@PathVariable Integer id,@RequestBody Map<String,ArrayList<String>> body) {
    	Optional<Usuario> usuario = servicioUsuarios.obtenerUsuarioPorId(id);
    	if(usuario.isEmpty()) { //no existe
    		return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_FOUND);
    	}else {
    		//Comprobar que nada es null
    		usuario.get().setNombre(body.get("nombre").get(0));
    		usuario.get().setPizzasFavoritas(body.get("pizzasFavoritas"));
    		if(servicioUsuarios.modificarUsuario(usuario) != null){
    			UsuarioDto usuarioDto = new UsuarioDto(usuario.get().getId(),usuario.get().getNombre(),usuario.get().getPizzasFavoritas()); 
        		return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
    		}else { //falla la modificacion
    			return new ResponseEntity<UsuarioDto>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    	}
    }
    
    @DeleteMapping(value = "/eliminarUsuario/{id}")
    public ResponseEntity<UsuarioDto> eliminarUsuario(@PathVariable Integer id){
    	Optional<Usuario> usuario = servicioUsuarios.obtenerUsuarioPorId(id);
    	if(usuario.isEmpty()) { //no existe
    		return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_FOUND);
    	}else {
    		servicioUsuarios.eliminarUsuario(id);
    		return new ResponseEntity<UsuarioDto>(HttpStatus.OK);
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

    
    //Marcar pizzas favoritas
    @PutMapping(value = "/marcarPizzasFavoritasUsuario/{id}")
    public ResponseEntity<UsuarioDto> marcarPizzasFavoritasUsuario(@PathVariable Integer id,@RequestBody Map<String,ArrayList<String>> body) {
    	Optional<Usuario> usuario = servicioUsuarios.obtenerUsuarioPorId(id);
    	if(usuario.isEmpty()) { //no existe
    		return new ResponseEntity<UsuarioDto>(HttpStatus.NOT_FOUND);
    	}else {
    		//Comprobar que nada es null
    		ArrayList<String> pizzasFavoritas = body.get("pizzasFavoritas");
    		//Comprobar si alguna de esas pizzas a añadir ya estan en pizzas fav
    		
    		for(int j = 0 ; j < usuario.get().getPizzasFavoritas().size(); j++) {
    			for(int i = 0 ; i < pizzasFavoritas.size(); i++) {
    				if(usuario.get().getPizzasFavoritas().get(j).equals(pizzasFavoritas.get(j))) {
    					
    				}
    			}
    		}
    		
    		//Comprobar si la pizza existe, llamar desde usuario a pizza-read
    		if(servicioUsuarios.modificarUsuario(usuario) != null){
    			UsuarioDto usuarioDto = new UsuarioDto(usuario.get().getId(),usuario.get().getNombre(),usuario.get().getPizzasFavoritas()); 
        		return new ResponseEntity<UsuarioDto>(usuarioDto, HttpStatus.OK);
    		}else { //falla la modificacion
    			return new ResponseEntity<UsuarioDto>(HttpStatus.INTERNAL_SERVER_ERROR);
    		}
    	}
    }
    

    //Desmarcar pizzas favoritas
//    @GetMapping(value = "/obtenerPizzasUsuario")
//    public ResponseEntity <List<PizzaDto>> obtenerPizzasUsuario(@RequestParam Integer idUsuario){
//        List<PizzaDto> listaPizzasUsuario = servicioPizzas.obtenerPizzasPorUsuario(idUsuario);
//        return new ResponseEntity<>(listaPizzasUsuario,HttpStatus.OK);
//    }
}

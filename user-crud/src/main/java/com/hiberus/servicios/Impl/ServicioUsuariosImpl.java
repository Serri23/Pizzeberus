package com.hiberus.servicios.Impl;

import com.hiberus.modelos.Usuario;
import com.hiberus.repositorios.RepositorioUsuario;
import com.hiberus.servicios.ServicioUsuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServicioUsuariosImpl implements ServicioUsuarios {
	
     @Autowired
    RepositorioUsuario repositorioUsuario;
     
    public List<Usuario> obtenerUsuarios(){
        return repositorioUsuario.findAll();
    }

	@Override
	public Usuario crearUsuario(String nombre, ArrayList<String> pizzasFavoritas) {
		Usuario usuario= new Usuario();
		usuario.setNombre(nombre);
		usuario.setPizzasFavoritas(pizzasFavoritas);
		return repositorioUsuario.save(usuario);
	}

	@Override
	public Optional<Usuario> obtenerUsuarioPorId(Integer id) {
		return repositorioUsuario.findById(id);
	}

	@Override
	public Usuario modificarUsuario(Optional<Usuario> usuario) {
		return repositorioUsuario.save(usuario.get());
	}

	@Override
	public void eliminarUsuario(Integer id) {
		repositorioUsuario.deleteById(id);
	}
}

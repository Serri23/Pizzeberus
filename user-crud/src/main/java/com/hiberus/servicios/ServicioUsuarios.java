package com.hiberus.servicios;

import com.hiberus.modelos.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface ServicioUsuarios {
    List<Usuario> obtenerUsuarios();

	Usuario crearUsuario(String nombre, ArrayList<String> pizzasFavoritas);

	Optional<Usuario> obtenerUsuarioPorId(Integer id);

	Usuario modificarUsuario(Optional<Usuario> usuario);

	void eliminarUsuario(Integer id);
}

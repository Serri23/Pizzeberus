package com.hiberus.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.hiberus.dto.UsuarioDto;
import com.hiberus.modelos.Usuario;

@Mapper
public interface UsuarioMapper {

	UsuarioMapper INSTANCIA= Mappers.getMapper(UsuarioMapper.class);
	  
	UsuarioDto usuarioToUsuarioDto(Usuario usuario);
	
}

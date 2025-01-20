package Usuarios.Usuarios.service;

import java.util.List;

import Usuarios.Usuarios.model.UsuarioModel;

public interface IUsuService {

    List<UsuarioModel> findAll();

    UsuarioModel findById(Long id);

    UsuarioModel createUser(UsuarioModel usuarioModel);

    UsuarioModel updateUser(UsuarioModel usuarioModel);

    void deleteUser(Long id);
}
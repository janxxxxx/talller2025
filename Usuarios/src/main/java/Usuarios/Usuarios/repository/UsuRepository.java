package Usuarios.Usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Usuarios.Usuarios.model.UsuarioModel;

@Repository
public interface UsuRepository extends JpaRepository<UsuarioModel, Long> {
}

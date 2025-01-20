package Usuarios.Usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Usuarios.Usuarios.model.UsuarioModel;
import Usuarios.Usuarios.repository.UsuRepository;
import jakarta.transaction.Transactional;

@Service
public class UsuService implements IUsuService {

    private final UsuRepository usuarioRepository;

    @Autowired
    public UsuService(UsuRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioModel> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioModel findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public UsuarioModel createUser(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    @Override
    @Transactional
    public UsuarioModel updateUser(UsuarioModel usuarioModel) {
        return usuarioRepository.save(usuarioModel);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        usuarioRepository.deleteById(id);
    }
}

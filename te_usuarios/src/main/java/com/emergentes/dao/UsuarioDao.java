
package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import java.util.List;

public interface UsuarioDao {
    public void insert(Usuario aviso) throws Exception;
    public void update(Usuario aviso) throws Exception;
    public void delete(int id) throws Exception;
    public List<Usuario> getAll() throws Exception;
    public Usuario getById(int id) throws Exception;
}

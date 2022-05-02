
package com.emergentes.dao;

import com.emergentes.modelo.Usuario;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoimpl extends ConexionBD implements UsuarioDao{

    @Override
    public void insert(Usuario aviso) throws Exception {
        String sql = "insert into usuarios (nombre,correo,clave) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, aviso.getNombre());
        ps.setString(2, aviso.getCorreo());
        ps.setString(3, aviso.getClave());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Usuario aviso) throws Exception {
        String sql = "update usuarios set nombre=?, correo=?, clave=? where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,aviso.getNombre());
        ps.setString(2,aviso.getCorreo());
        ps.setString(3,aviso.getClave());
        ps.setInt(4, aviso.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from usuarios where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public List<Usuario> getAll() throws Exception {
        List<Usuario> lista = null;
        String sql = "select * from usuarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<Usuario>();
        while(rs.next()){
            Usuario avi = new Usuario();
            
            avi.setId(rs.getInt("id"));
            avi.setNombre(rs.getString("nombre"));
            avi.setCorreo(rs.getString("correo"));
            avi.setClave(rs.getString("clave"));
            
            lista.add(avi);
        }
        this.desconectar();
        return lista;
    }

    @Override
    public Usuario getById(int id) throws Exception {
            Usuario avi = new Usuario();
        try {
            String sql = "select * from usuarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            avi.setId(rs.getInt("id"));
            avi.setNombre(rs.getString("clave"));
            avi.setCorreo(rs.getString("correo"));
            avi.setClave(rs.getString("clave"));
            }
        } catch (SQLException e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return avi;
    }
}

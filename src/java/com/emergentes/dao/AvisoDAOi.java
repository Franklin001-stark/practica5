
package com.emergentes.dao;

import com.emergentes.modelo.Aviso;
import com.emergentes.utiles.Conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



    public class AvisoDAOi extends Conexion  implements AvisoDAO{

    @Override
    public void insert(Aviso aviso) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT into productos (descripcion, stock) values(?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, aviso.getDescripcion());
             ps.setInt(2, aviso.getStock());
            //ejecutar la consulta 
            ps.executeUpdate();
        } catch(Exception e) {
            throw e;
            
        }finally{
            this.desconectar();        }
  
    }

    @Override
    public void update(Aviso aviso) throws Exception {
       
    try {
            this.conectar();
            String sql = "UPDATE productos set descripcion = ?, stock = ? where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setString(1, aviso.getDescripcion());
             ps.setInt(2, aviso.getStock());
             ps.setInt(3, aviso.getId());
            //ejecutar la consulta 
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
            
        }finally{
            this.desconectar();        }
    
    }

    @Override
    public void delete(int id) throws Exception {
    try {
            this.conectar();
            String sql = "DELETE from productos where id =?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
           ps.setInt(1, id);
            //ejecutar la consulta 
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
            
        }finally{
            this.desconectar();        }
       
    
    }

    @Override
    public Aviso getById(int id) throws Exception {
        Aviso avi = new Aviso();
        try {
            this.conectar();
            String sql = "Select * from productos  where id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
           ps.setInt(1, id);
           
           ResultSet rs = ps.executeQuery();
           if(rs.next()){
               avi.setId(rs.getInt("id"));
               avi.setDescripcion(rs.getString("descripcion"));
               avi.setStock(rs.getInt("stock"));
           }
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
    return avi;
    }

    @Override
    public List<Aviso> getAll() throws Exception {
       List<Aviso> lista = null;
        try {
            this.conectar();
            String sql = "select * from productos";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Aviso>();
            while(rs.next()){
                Aviso avi  = new Aviso();
                 avi.setId(rs.getInt("id"));
               avi.setDescripcion(rs.getString("descripcion"));
                 avi.setStock(rs.getInt("stock"));
                //adicionar  a la colecion
               lista.add(avi);
               
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw e;
        }finally{
            this.desconectar();
        }
        return lista;
    }
    
}



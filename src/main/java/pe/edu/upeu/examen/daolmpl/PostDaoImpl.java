/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.examen.daolmpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.upeu.examen.config.Conexion;
import pe.edu.upeu.examen.dao.PostDao;
import pe.edu.upeu.examen.model.Post;

/**
 *
 * @author jhone
 */
public class PostDaoImpl implements PostDao {
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cx;
    @Override
    public int create(Post post) {
        String SQL = "INSERT INTO post(titulo,descripcion) VALUES(?,?)";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, post.getTitulo());
            ps.setString(2, post.getDescripcion());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;  
    }

    @Override
    public int update(Post post) {
        String SQL = "UPDATE post SET titulo=?, descripcion=? WHERE idpost=?";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setString(1, post.getTitulo());
            ps.setString(2, post.getDescripcion());
            ps.setInt(3, post.getIdpost());
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public int delate(int id) {
        String SQL = "DELETE FROM post WHERE idpost=?";
        int x = 0;
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            x = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return x;
    }

    @Override
    public Post read(int id) {
        String SQL = "SELECT *FROM post WHERE idpost=?";
        Post post = new Post();
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                post.setIdpost(rs.getInt("idpost"));
                post.setTitulo(rs.getString("titulo"));
                post.setDescripcion(rs.getString("descripcion"));
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return post;
    }

    @Override
    public List<Post> readAll() {
        String SQL = "SELECT *FROM post";
        List<Post> lista = new ArrayList<>();
        try {
            cx = Conexion.getConex();
            ps = cx.prepareStatement(SQL);
            rs = ps.executeQuery();
            while(rs.next()){
                Post post = new Post();
                post.setIdpost(rs.getInt("idpost"));
                post.setTitulo(rs.getString("titulo"));
                post.setDescripcion(rs.getString("descripcion"));
                lista.add(post);
            }
        } catch (SQLException e) {
            System.out.println("Error: "+e);
        }
        return lista;
    }
    
    
}

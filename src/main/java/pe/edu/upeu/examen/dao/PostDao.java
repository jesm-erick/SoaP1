/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.edu.upeu.examen.dao;

import java.util.List;
import pe.edu.upeu.examen.model.Post;

/**
 *
 * @author jhone
 */
public interface PostDao {
    int create(Post post);
    int update(Post post);
    int delate(int id);
    Post read(int id);
    List<Post> readAll();
}

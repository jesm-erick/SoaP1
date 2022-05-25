/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.edu.upeu.examen.ws;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import pe.edu.upeu.examen.dao.PostDao;
import pe.edu.upeu.examen.daolmpl.PostDaoImpl;
import pe.edu.upeu.examen.model.Post;

/**
 *
 * @author jhone
 */
@WebService(serviceName = "PostWebService")
public class PostWebService {
   
    PostDao postdao =new PostDaoImpl();
    @WebMethod(operationName = "crear")
    public int crear(@WebParam(name = "titulo") String titulo, @WebParam(name = "descripcion") String descripcion) {
        //TODO write your implementation code here:
        return postdao.create(new Post (0,titulo, descripcion));
    }
    
    
    @WebMethod(operationName = "editar")
    public int editar(@WebParam(name = "idpost") int idpost, @WebParam(name = "titulo") String titulo, @WebParam(name = "descripcion")String descripcion) {
        //TODO write your implementation code here:
        return postdao.update(new Post (idpost ,titulo ,descripcion));
    }
    
    
      @WebMethod(operationName = "eleminar")
    public int eleminar(@WebParam(name = "idpost") int id) {
        //TODO write your implementation code here:
        return postdao.delate(id);
    }
    
    @WebMethod(operationName = "operation")
    public Post operation(@WebParam(name = "idpost") int id) {
        //TODO write your implementation code here:
        return postdao.read(id);
    }

    @WebMethod(operationName = "readAll")
    public List<Post> readAll() {
        //TODO write your implementation code here:
        return postdao.readAll();
    }
}

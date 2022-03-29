
package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "MainServlet", urlPatterns = {"/MainServlet"})
public class MainServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String t = request.getParameter("t");
        
        if (t.equals("vaciar")){
            HttpSession ses = request.getSession();
            ses.invalidate();
            response.sendRedirect("index.jsp");
        }
        if (t.equals("eliminar")) {
            int pos = -1;
            int buscado = -1;
            int id = Integer.parseInt(request.getParameter("id"));
            // eliminar el producto
            HttpSession ses = request.getSession();
            ArrayList<Almacen> lista = (ArrayList<Almacen>)ses.getAttribute("almacen");
            
            for(Almacen p : lista){
                pos++;
                if (p.getId() == id) {
                    buscado = pos;
                }
                
            }
            lista.remove(buscado);
            response.sendRedirect("index.jsp");
        }
 
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String tarea = request.getParameter("tarea");
       
        
        Almacen prod = new Almacen();
        prod.setId(id);
        prod.setTarea(tarea);
        
        
        HttpSession ses = request.getSession();
        
        ArrayList<Almacen> lista = (ArrayList<Almacen>)ses.getAttribute("almacen");
        
        lista.add(prod);
        
        response.sendRedirect("index.jsp");
    }
    }

    




package com.emergentes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "VisitasServlet", urlPatterns = {"/VisitasServlet"})
public class VisitasServlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int contador = 0;
       
       Cookie[] cukis = request.getCookies();
       
       if(cukis != null){
           for(Cookie c : cukis){
               if (c.getName().equals("visitas")){
                   contador = Integer.parseInt(c.getValue());
               }
           }
       }
       contador ++;
       Cookie c = new Cookie("visitas",Integer.toString(contador));
       // establecer eltiempo de la cookie en seguindos 
       c.setMaxAge(3600);
       response.addCookie(c);
       
       response.setContentType("text/html");
       PrintWriter out = response.getWriter();
       out.print("Visitante No: "+ contador);
    
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

  

}

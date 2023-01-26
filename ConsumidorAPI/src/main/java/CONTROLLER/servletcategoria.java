/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package CONTROLLER;

import MODEL.categoria;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Pc gamer
 */
public class servletcategoria extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        URL url = new URL("http://localhost:8090/api/categoria");
	HttpURLConnection connect = (HttpURLConnection) url.openConnection();
	connect.setRequestMethod("GET");
	connect.setRequestProperty("Accept", "application/json");
        String Salida="";
        if (connect.getResponseCode()==200) {
            InputStreamReader entrada = new InputStreamReader(connect.getInputStream());
            BufferedReader lectura = new BufferedReader(entrada);
            Salida= lectura.readLine();
        }else{
            System.out.println("Algo paso" + connect.getResponseCode());
        }
        connect.disconnect();
        
        ArrayList<categoria> catlist= new ArrayList();
        JSONArray catjson = new JSONArray(Salida);
        for (int i = 0; i < catjson.length(); i++) {
            JSONObject catobject = catjson.getJSONObject(i);
            categoria cat = new categoria();
            cat.setId(catobject.getInt("id"));
            cat.setNombre(catobject.getString("nombre"));
            catlist.add(cat);
             
        }
        String tableopen = "<table class=\"table table-striped table-dark\"><thead><th scope=\"col\">ID</th> <th scope=\"col\">Nombre</th></thead>";
        String openrow = "<tr>";
        String opendato = "<td>";
        String closedato = "</td>";
        String closerow = "</tr>";
        String tableclose = "</table>";
        String tabla = "";
        
        for (categoria categoria: catlist) {
            tabla += openrow + opendato + categoria.getId() + closedato + opendato + categoria.getNombre()+ closerow;
            
        }
        
        String tabladatos = tableopen + tabla + tableclose;
        request.setAttribute("datos", tabladatos);
        request.getRequestDispatcher("categoria.jsp").forward(request,response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}


package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import modelo.Modelo_DAO;
import modelo.Modelo_producto;

/**
 *
 * @author TIVE
 */
@WebServlet(name = "Producto_controller", urlPatterns = {"/Producto_controller"})
public class Producto_controller extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */

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
        Modelo_DAO productosDAO = new Modelo_DAO();
        String enlace;
        RequestDispatcher dispatcher = null;
        enlace = request.getParameter("enlace");
        
        if(enlace == null || enlace.isEmpty()){
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Modelo_producto> listaProductos = productosDAO.listaProductos();
            request.setAttribute("lista", listaProductos);
        }else if("nuevo_producto".equals(enlace)){
            dispatcher = request.getRequestDispatcher("Productos/nuevo_producto.jsp");
        }else if("insertar".equals(enlace)){
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            
            Modelo_producto productos = new Modelo_producto(0, codigo, nombre, precio, stock);
            productosDAO.insertarProductos(productos);
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Modelo_producto> listaProductos = productosDAO.listaProductos();
            request.setAttribute("lista", listaProductos);
        }else if("modificar_producto".equals(enlace)){
            dispatcher = request.getRequestDispatcher("Productos/modificar_producto.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Modelo_producto productos = productosDAO.mostrarProducto(id);
            request.setAttribute("productos", productos);
        }else if("actualizar".equals(enlace)){
            int id = Integer.parseInt(request.getParameter("id"));
            String codigo = request.getParameter("codigo");
            String nombre = request.getParameter("nombre");
            double precio = Double.parseDouble(request.getParameter("precio"));
            int stock = Integer.parseInt(request.getParameter("stock"));
            
            Modelo_producto productos = new Modelo_producto(id, codigo, nombre, precio, stock);
            productosDAO.actualizarProducto(productos);
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Modelo_producto> listaProductos = productosDAO.listaProductos();
            request.setAttribute("lista", listaProductos);
        }else if("eliminar".equals(enlace)){
            int valor = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el producto?", "Eliminar producto", 
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(valor == 0){
            int id = Integer.parseInt(request.getParameter("id"));
            productosDAO.eliminarProducto(id);
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Modelo_producto> listaProductos = productosDAO.listaProductos();
            request.setAttribute("lista", listaProductos);
            }else{
                dispatcher = request.getRequestDispatcher("Productos/index.jsp");
                List<Modelo_producto> listaProductos = productosDAO.listaProductos();
                request.setAttribute("lista", listaProductos);
            }
        }else if("cancelar".equals(enlace)){
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Modelo_producto> listaProductos = productosDAO.listaProductos();
            request.setAttribute("lista", listaProductos);
        }else{
            dispatcher = request.getRequestDispatcher("Productos/index.jsp");
            List<Modelo_producto> listaProducto = productosDAO.listaProductos();
            request.setAttribute("lista",listaProducto);
        }
        dispatcher.forward(request, response);
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
        doGet(request, response);
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

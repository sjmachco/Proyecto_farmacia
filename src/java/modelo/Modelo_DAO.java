
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author TIVE
 */
public class Modelo_DAO {
    Connection conexion;
    
    public Modelo_DAO(){
        Conexion cn = new Conexion();
        conexion = cn.getConexion();
    }
    
    public List<Modelo_producto> listaProductos(){
        PreparedStatement ps;
        ResultSet rs;
        
        List<Modelo_producto> lista = new ArrayList<>();
        try {
            ps = conexion.prepareStatement("select * from producto");
            rs = ps.executeQuery();
            
            while(rs.next()){
                int id, stock;
                String codigo, nombre;
                double precio;
                id = rs.getInt("id");
                codigo = rs.getString("codigo");
                nombre = rs.getString("nombre");
                precio = rs.getDouble("precio");
                stock = rs.getInt("stock");
                Modelo_producto producto = new Modelo_producto(id, codigo, nombre, precio, stock);
                lista.add(producto);
            }
            return lista;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }  
    }
    
    public boolean insertarProductos(Modelo_producto producto){
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("insert into producto(codigo, nombre, precio, stock) values(?, ?, ?, ?)");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }        
    }
    
    public Modelo_producto mostrarProducto(int _id){
        PreparedStatement ps;
        ResultSet rs;
        
        Modelo_producto producto = null;
        try {
            ps = conexion.prepareStatement("select id, codigo, nombre, precio, stock from producto where id = ?");
            ps.setInt(1, _id);
            rs = ps.executeQuery();
            while(rs.next()){
                int id, stock;
                String codigo, nombre;
                double precio;
                id = rs.getInt("id");
                codigo = rs.getString("codigo");
                nombre = rs.getString("nombre");
                precio = rs.getDouble("precio");
                stock = rs.getInt("stock");
                producto = new Modelo_producto(id, codigo, nombre, precio, stock);
            }
            return producto;
            
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
    
    public boolean actualizarProducto(Modelo_producto producto){
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("update producto set codigo = ?, nombre = ?, precio = ?, stock = ? where id = ?");
            ps.setString(1, producto.getCodigo());
            ps.setString(2, producto.getNombre());
            ps.setDouble(3, producto.getPrecio());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getId());
            ps.execute();
            return true;
        }  catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
    
    public boolean eliminarProducto(int id){
        PreparedStatement ps;
        try {
            ps = conexion.prepareStatement("delete from producto where id = ?");
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}

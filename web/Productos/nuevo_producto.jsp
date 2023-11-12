<%-- 
    Document   : Nuevo_producto
    Created on : 23 abr. 2023, 11:59:11
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
        
    </head>
    <center>
    <body style="background-color:#DC7633; font-family:Arial">
        <h2>Registrar producto</h2>
        <form action = "Producto_controller?enlace=insertar" method = "post" autocomplete = "off">
            <table style="font-size:120%">
                <tr>
                    <td>Código:</td>
                    <td><input id = "codigo" type = "text" name = "codigo"></td>
                </tr>
                <tr>
                    <td>Nombre:</td>
                    <td><input id = "nombre" type = "text" name = "nombre"></td>
                </tr>
                <tr>
                    <td>Precio:</td>
                    <td><input id= "precio" type = "text" name = "precio"></td>
                </tr>
                <tr>
                    <td>Stock</td>
                    <td><input id= "stock" type = "text" name = "stock"></td>
                </tr>
            </table>
            <br>
            <table>
                <tr>
                    <td><button type = "submit" name = "btnGuardar">Guardar</button></td>
                    <td><input type="button" name="cancelar" value="Cancelar" onClick="location.href='Producto_controller?enlace=cancelar'"></td>
                </tr>            
            </table>
        </form>
    </body>
    </center>
</html>

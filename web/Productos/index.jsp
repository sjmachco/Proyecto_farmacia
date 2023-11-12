<%-- 
    Document   : index
    Created on : 23 abr. 2023, 11:57:00
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Farmacia</title>
        <link rel="stylesheet" type = "text/css" href="estilos.css"/>
    </head>
    <center>
    <body style="background-color:#DC7633; font-family:Arial">
        <h1>Medicamentos</h1>
        <a href = "Producto_controller?enlace=nuevo_producto" style="font-size:120%">Nuevo producto</a>
        <p></p>
        <table border = "1" style="background-color:white">
            <thead style="font-size:120%">
                <tr style="color:white; background-color:#800000">    
                    <th width = "200">Código producto</th>
                    <th width = "300">Nombre</th>
                    <th width = "150">Precio</th>
                    <th width = "150">Stock</th>
                    <th width = "250">Solicita</th>
                    <th width = "250">Solicita</th>
                </tr>
            </thead>
            <tbody style="font-size:115%">
                <c:forEach var = "producto" items = "${lista}">
                    <tr>
                        <td><c:out value = "${producto.codigo}"/></td>
                        <td><c:out value = "${producto.nombre}"/></td>
                        <td><c:out value = "${producto.precio}"/></td>
                        <td><c:out value = "${producto.stock}"/></td>
                        <td><a href = "Producto_controller?enlace=modificar_producto&id=<c:out value = "${producto.id}"/>">Modificar producto</a></td>
                        <td><a href = "Producto_controller?enlace=eliminar&id=<c:out value = "${producto.id}"/>">Eliminar producto</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
    </center>
</html>

package tp3prog3b;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

public class GestorComputadora extends Gestor{

    BaseDeDatos bd = new BaseDeDatos();
    Connection conexion = bd.estableceConexion();

    public GestorComputadora() {
        sesion = ConfigHibernate.openSession();
    }
    
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public void insertarComputadora(String perfil) {
        try {
            PreparedStatement ps = conexion.prepareStatement("INSERT INTO perfil (denominacion) VALUES (?)");
            // Se establecen los parámetros y se ejecuta la sentencia.
            ps.setString(1, perfil);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(GestorComputadora.class.getName()).log(Level.SEVERE, null, ex);
        }

    }*/

    public void insertarHQL(Object o) {
        try {
            this.guardar(o);
           
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}

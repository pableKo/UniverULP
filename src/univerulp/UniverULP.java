
package univerulp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class UniverULP {

   
    public static void main(String[] args) {
        
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conexion =DriverManager.getConnection("jdbc:mariadb://localhost:3306/universidadulp", "root","");
            /*String sql = "INSERT INTO alumno (dni, `apellido`, `nombre`, fechaNacimiento, `estado`)"
                    + " VALUES (22222222,'Messa', 'Leonel', '1995-03-02', '1'), (33333333,'Messe', 'Luonel',"
                    + " '1995-03-01', '1') ";*/
            String sql = "INSERT INTO materia ('nombre', año, estado)"
                    + " VALUES ('geografia',1, 1), ('historia',2, 1), ('matematica',3, 1)";
          
                   
            PreparedStatement ps = conexion.prepareStatement(sql);
            int registros = ps.executeUpdate();
            System.out.println(registros);
            
                    } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error en la carga"+ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la cnx en la BBDD"+ex.getMessage());
        }
        
    }
    
}

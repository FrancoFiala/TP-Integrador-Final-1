
import java.sql.Connection;
import java.sql.ResultSet;

import java.sql.PreparedStatement; 
import java.sql.DriverManager; 
import java.sql.SQLException; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
import java.sql.ResultSetMetaData; 


public class Persistencia {
    
    private Connection cn;
    private ResultSet rs;
    private PreparedStatement ps;
    private Statement s;
    private ResultSetMetaData rsm;

    public String servidor, basededatos, usuario, clave, ejecutar;
    
    public Connection conectarse(){
    
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        
        
        servidor="localhost:3306/";
        basededatos="cacproyecto";
        usuario="root";
        clave="";
        
        cn= (Connection) DriverManager.getConnection("jdbc:mysql://" + servidor + 
                basededatos+"?autoReconnect=true&useSSL=false", usuario, clave);
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return cn;
        
    }
    
    //***********************************************
    
    public ResultSet consultaSQL(String busqueda){
        
        try {
            ps= conectarse().prepareStatement(busqueda);
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            rs= (ResultSet) ps.executeQuery();
        
        rsm= rs.getMetaData();
        
        } catch (SQLException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    
  


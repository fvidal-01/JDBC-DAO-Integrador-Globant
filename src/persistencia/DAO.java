package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DAO {
    protected Connection conexion = null;
    protected ResultSet resultSet = null;
    protected Statement statement = null;

    private final String HOST = "127.0.0.1";
    private final String PORT = "3306";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "estancias_exterior";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";

    protected void conectarDataBase() throws SQLException, ClassNotFoundException{
        try {
            Class.forName(DRIVER);
            String url = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE;
            conexion = DriverManager.getConnection(url, USER, PASSWORD);
            System.out.println("Conexión éxitosa a la base de datos.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e;
        }
    }

    protected void desconectarBase() throws SQLException, ClassNotFoundException{
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(conexion != null){
                conexion.close();
            }
        } catch(Exception e){
            System.out.println(e.getMessage());
            throw e;
        }
    }

    protected void insertarModificarEliminarDataBase(String sql) throws Exception{
        try {
            conectarDataBase();
            statement = conexion.createStatement();
            statement.executeUpdate(sql);
            
        } catch (SQLException | ClassNotFoundException se){
            System.out.println(se.getMessage());
            throw se;
        } finally{
            desconectarBase();
        }
    }

    protected void consultarDataBase(String sql) throws Exception{
        try {
           conectarDataBase(); 
           statement = conexion.createStatement();
           resultSet = statement.executeQuery(sql);

        } catch (SQLException | ClassNotFoundException se){
            System.out.println(se.getMessage());
            throw se;
        }
    }
}
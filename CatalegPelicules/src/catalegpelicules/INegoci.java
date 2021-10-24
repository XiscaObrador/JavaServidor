package catalegpelicules;

import java.sql.SQLException;
import java.util.ArrayList;

public interface INegoci {
    public void addPelicula(Pelicules p)throws SQLException;
    public void llegirID(String id) throws SQLException;
    public ArrayList<Object[]> llegirTotes()throws SQLException;
    public void modificarPelicula(String id,String valor , String nouValor )throws SQLException;
    public void eliminarPelicula(String id) throws SQLException;
}

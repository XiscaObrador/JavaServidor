package catalegpelicules;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ICRUDPelicules{

    public void createPelicules(Pelicules p) throws SQLException;
    public ArrayList<Object[]> readPelicules()throws SQLException;
    public void updatePelicules(String id , String valor, String nouValor)throws SQLException;
    public void deletePelicules(String id)throws SQLException;
    public boolean existeix(String id) throws SQLException;
    public void readID( String id) throws SQLException;

}

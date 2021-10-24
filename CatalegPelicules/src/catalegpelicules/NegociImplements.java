package catalegpelicules;

import java.sql.SQLException;
import java.util.ArrayList;

public class NegociImplements implements INegoci{
    CRUDPeliculesImplement  CRUD = new CRUDPeliculesImplement();
    @Override
    public void addPelicula(Pelicules p) throws SQLException {
        CRUD.createPelicules(p);
    }

    @Override
    public void llegirID(String id) throws SQLException {
        if(CRUD.existeix(id) == true){
            CRUD.readID(id);
        }else{
            System.out.println("La pelicula no existeix");
        }
    }

    @Override
    public ArrayList<Object[]> llegirTotes() throws SQLException {
        return CRUD.readPelicules();
    }

    @Override
    public void modificarPelicula(String id, String valor , String nouValor ) throws SQLException {
        if(CRUD.existeix(id)){
            CRUD.updatePelicules(id,valor,nouValor);
        }
    }

    @Override
    public void eliminarPelicula(String id) throws SQLException {
        if (CRUD.existeix(id)){
            CRUD.deletePelicules(id);
        }
    }

}

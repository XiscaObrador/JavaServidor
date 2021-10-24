package catalegpelicules;

import com.mysql.cj.x.protobuf.MysqlxCrud;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;


public class CRUDPeliculesImplement implements ICRUDPelicules{

    private String user = "root";
    private String password = "ona1992";
    private String url = "jdbc:mysql://localhost:3306/catalegpelicules";
    private Connection bd;
    private Statement conexio;
    private ResultSet resultat;
    private Scanner teclat = new Scanner(System.in);

    public void conection() throws SQLException {
        bd = DriverManager.getConnection(url,user,password);
    }
    public void closeConection() throws SQLException{
        bd.close();
        conexio.close();
    }
    @Override
    public void createPelicules(Pelicules p) throws SQLException {
        conection();
        conexio = bd.createStatement();
        conexio.executeUpdate("INSERT into pelicules (nom,any,director,genere) values ('"+p.getTitol()+"','"+p.getAny()+"','"+p.getDirector()+"','"+p.getGenere()+"');");
        closeConection();
    }

    @Override
    public ArrayList<Object[]> readPelicules()  throws SQLException{
        conection();
        conexio = bd.createStatement();
        resultat = conexio.executeQuery("SELECT * FROM pelicules");
        ArrayList<Object[]> dades =  new ArrayList<>();
        ResultSetMetaData m = resultat.getMetaData();
        while (resultat.next()){
            Object [] fila = new Object [m.getColumnCount()];
            for (int i = 0; i < fila.length; i++) {
                   fila[i] = resultat.getObject(i + 1);
            }
            dades.add(fila);
        }
        closeConection();
        return dades;
    }

    @Override
    public void updatePelicules(String id,String valor, String nouValor)  throws SQLException{
        conection();
        conexio = bd.createStatement();
        conexio.executeUpdate("update pelicules set "+valor+" ='"+nouValor+"' where id='"+id+"';");
        closeConection();
    }

    @Override
    public void deletePelicules(String id)  throws SQLException {
        conection();
        conexio = bd.createStatement();
        conexio.executeUpdate("delete from pelicules where id = '"+id+"';");
        closeConection();
    }

    @Override
    public boolean existeix(String id) throws SQLException {
        boolean exist = true;
        conection();
        conexio = bd.createStatement();
        resultat = conexio.executeQuery("SELECT id from pelicules where id = '"+id+"'");
        while (resultat.next()){
            String i = resultat.getString("id");
            if( ! i.equals(id)) {
                exist = false;
            }
        }
        closeConection();
        return exist;
    }

    @Override
    public void readID(String id) throws SQLException {
        conection();
        conexio = bd.createStatement();
        resultat = conexio.executeQuery("SELECT * from pelicules where id = '"+id+"'");
        while (resultat.next()) {
            Pelicules p = new Pelicules();
            p.setId(resultat.getString("id"));
            p.setTitol(resultat.getString("nom"));
            p.setAny(resultat.getString("any"));
            p.setDirector(resultat.getString("director"));
            p.setGenere(resultat.getString("genere"));
            System.out.println(p.toString());
        }
        closeConection();
    }
}

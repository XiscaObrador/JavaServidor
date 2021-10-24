
package catalegpelicules;

import java.util.Scanner;


import java.sql.*;
import java.util.*;
public class CatalegPelicules {

    public static void main(String[] args) throws SQLException {
        Scanner teclat = new Scanner(System.in);
        NegociImplements CRUD = new NegociImplements();
        Menu m = new Menu();

        System.out.println("CRUD BD Pelicules");
        System.out.println();
        String id;
        String valor;
        String nouValor;

        boolean sortir = false;
        while (!sortir){
            m.m();
            try{
                int opcio = teclat.nextInt();
                switch (opcio){
                    case 1:
                        CRUD.llegirTotes();
                        m.m();
                        opcio = teclat.nextInt();
                        break;
                    case 2:
                        Pelicules pelicula = new Pelicules();
                        System.out.println("Estriu el titol de la pelicula");
                        pelicula.setTitol(teclat.next());
                        System.out.println("Any de pelicula");
                        pelicula.setAny(teclat.next());
                        System.out.println("Nom de director");
                        pelicula.setDirector(teclat.next());
                        System.out.println("Genere de Pelicula");
                        pelicula.setGenere(teclat.next());
                        CRUD.addPelicula(pelicula);
                        m.m();
                        opcio = teclat.nextInt();
                        break;
                    case 3:
                        System.out.println("Introdueix ID pelicula");
                        id = teclat.next();
                        CRUD.llegirID(id);
                        m.m();
                        opcio = teclat.nextInt();
                        break;
                    case 4:
                        System.out.println("Introdueix ID pelicula");
                        id = teclat.next();
                        System.out.println("Instrodueix columna que vols modificar");
                        valor = teclat.next();
                        System.out.println("Nou valor");
                        nouValor = teclat.next();
                        CRUD.modificarPelicula(id,valor,nouValor);
                        m.m();
                        opcio = teclat.nextInt();
                        break;
                    case 5:
                        System.out.println("Introdueix ID pelicula");
                        id = teclat.next();
                        CRUD.eliminarPelicula(id);
                        m.m();
                        opcio = teclat.nextInt();
                        break;
                    case 6:
                        sortir = true;
                        break;
                    default:
                        System.out.println("--");
                        System.out.println("El nombre introduit no està al menu!");
                }

            }catch (InputMismatchException ex) {
                System.out.println("--");
                System.out.println("Has d'introduir obligatòriament un nombre sencer.");
                teclat.next();

            }

        }


        //// NOVA PELICULA//
       /*Pelicules pelicula = new Pelicules();
        System.out.println("Estriu el titol de la pelicula");
        pelicula.setTitol(teclat.next());
        System.out.println("Any de pelicula");
        pelicula.setAny(teclat.next());
        System.out.println("Nom de director");
        pelicula.setDirector(teclat.next());
        System.out.println("Genere de Pelicula");
        pelicula.setGenere(teclat.next());

        CRUD.createPelicules(pelicula);
        ///////////////////////

        //// BORRAR PELICULA PER ID ////
        CRUD.deletePelicules(4);
        ///////////////////

        //// MODIFICAR PELICULA PER ID ///
       System.out.printf("ID de la pelicula que vols modificar");
        String id = teclat.next();
        System.out.println("Escriu el nom de la columna que vols modificar");
        String valor = teclat.next();
        System.out.println("El nou valor");
        String nouValor = teclat.next();
        CRUD.updatePelicules(id,valor,nouValor);

        ///////////////////////////////////

        ////// LLEGIR PELICULES ////
        CRUD.readPelicules();
        /////////////////////
           */


    }
    
}


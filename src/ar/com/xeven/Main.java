package ar.com.xeven;

import com.sun.org.apache.xpath.internal.axes.AttributeIterator;
import jdk.management.resource.internal.inst.FileOutputStreamRMHooks;

import javax.xml.bind.SchemaOutputResolver;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Disco> discos = new ArrayList<Disco>();

        //agrego discos a la lista de discos
        discos.add(new Disco("GASA41","Wim Mertenens","Maximazing the Audience","instrumental",50));
        discos.add(new Disco("FGHQ64","Metallica","Black Album","hard rock",46));
        discos.add(new Disco("TYUI89","Supersubmarina","Viento de Cara","pop rock",42));

        Scanner sc = new Scanner(System.in);

        //variables
        int opcion;
        int opcionListado;
        String autorIntroducido;
        String generoIntroducido;
        int limiteInferior;
        int limiteSuperior;
        String codigoIntroducido;
        String tituloIntroducido;
        int duracionIntroducida;
        int i;
        String duracionIntroducidaString;


        //MENU
        do {
            System.out.println("\n\nCOLECCION DE DISCOS");
            System.out.println("======================");
            System.out.println("1.Listado de discos");
            System.out.println("2.Agregar un nuevo disco");
            System.out.println("3.Modificar");
            System.out.println("4.Borrar");
            System.out.println("5.Salir");
            System.out.print("Introduzca una opcion: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                //OPCION1: LISTADO DE DISCOS////////////////////////////////////////////////////////////
                case 1:
                    do {
                        System.out.println("\nLISTADO\n===================");
                        System.out.println("1.Completo");
                        System.out.println("2.Por Autor");
                        System.out.println("3.Por Genero");
                        System.out.println("4.En un rango de duracion");
                        System.out.println("5.Menu Principal");
                        System.out.print("Introduzca una opcion: ");
                        opcionListado = Integer.parseInt(sc.nextLine());

                        switch (opcionListado){
                            case 1: // LISTADO COMPLETO ////////
                                for (Disco disco:discos)
                                    System.out.println(disco);
                                break;
                            case 2: // LISTADO POR AUTOR/////////
                                System.out.print("Introduzca el autor: ");
                                autorIntroducido = sc.nextLine();

                                for (Disco disco:discos){
                                    if (disco.getAutor().equals(autorIntroducido))
                                        System.out.println(disco);
                                }
                                break;
                            case 3: //LISTADO POR GENERO
                                System.out.print("Introduza el genero: ");
                                generoIntroducido = sc.nextLine();

                                for (Disco disco:discos){
                                    if (disco.getGenero().equals(generoIntroducido))
                                        System.out.println(disco);
                                }
                                break;
                            case 4: //LISTADO POR RANGO DE DURACION////////////////////////////////////////////
                                System.out.println("Establezca el intervalo para la duracion");
                                System.out.print("Introduzca el limite inferior de duracion en minutos: ");
                                limiteInferior = Integer.parseInt(sc.nextLine());
                                System.out.print("Introduzca el limite superior de duracion en minutos: ");
                                limiteSuperior = Integer.parseInt(sc.nextLine());

                                for (Disco disco:discos){
                                    if ((disco.getDuracion() <= limiteSuperior) && (disco.getDuracion() >= limiteInferior))
                                        System.out.println(disco);
                                }
                                break;
                            default:
                                System.out.println("Introduzca una opcion entre 1 y 5");
                                break;
                        }
                    } while (opcionListado != 5);
                    break;

                    //OPCION 2: AGREGAR NUEVO DISCO//////////////////////////////////////////////////////////////////////////////
                case 2:
                    System.out.println("\nNUEVO DISCO\n=======================");
                    System.out.println("Introduzca los datos del disco.");
                    System.out.print("Codigo: ");
                    codigoIntroducido = sc.nextLine();

                    while (discos.contains(new Disco(codigoIntroducido,"","","",0))){
                        System.out.println("Ese codigo ya existe en la base de datos.");
                        System.out.print("Introduzca otro codigo: ");
                        codigoIntroducido = sc.nextLine();
                    }

                    System.out.print("Autor: ");
                    autorIntroducido = sc.nextLine();
                    System.out.print("Titulo: ");
                    tituloIntroducido = sc.nextLine();
                    System.out.print("Genero: ");
                    generoIntroducido = sc.nextLine();
                    System.out.print("Duracion: ");
                    duracionIntroducida = Integer.parseInt(sc.nextLine());

                    //agrego el nuevo disco a la lista de discos
                    discos.add(new Disco(codigoIntroducido,autorIntroducido,tituloIntroducido,generoIntroducido,duracionIntroducida));

                    break;

                    //OPCION 3: MODIFICAR ////////////////////////////////////////////////////////////
                case 3:
                    System.out.println("\nMOFIFICAR\n==============================");

                    System.out.print("Por favor introduzca el codigo del disco, cuyos datos desea cambiar: ");
                    codigoIntroducido = sc.nextLine();
                    while (!discos.contains(new Disco(codigoIntroducido,"","","",0))){
                        System.out.print("Ese codigo no existe.\nIntroduzca otro codigo: ");
                        codigoIntroducido = sc.nextLine();
                    }
                    i = discos.indexOf(new Disco(codigoIntroducido,"","","",0)); //el codigo que introduje me trae este disco

                    System.out.println("Introduzca los nuevos datos del disco o INTRO para dejarlos igual.");

                    //modifica codigo
                    System.out.println("Codigo: "+discos.get(i).getCodigo());
                    System.out.print("Nuevo Codigo: ");
                    codigoIntroducido = sc.nextLine();
                    if (!codigoIntroducido.equals("")){
                        discos.get(i).setCodigo(codigoIntroducido);
                    }

                    //modifica autor
                    System.out.println("Autor: "+discos.get(i).getAutor());
                    System.out.print("Nuevo Autor: ");
                    autorIntroducido = sc.nextLine();
                    if (!autorIntroducido.equals("")){
                        discos.get(i).setAutor(autorIntroducido);
                    }

                    //modifica titulo
                    System.out.println("Titulo: "+discos.get(i).getTitulo());
                    System.out.print("Nuevo Titulo: ");
                    tituloIntroducido = sc.nextLine();
                    if (!tituloIntroducido.equals("")){
                        discos.get(i).setTitulo(tituloIntroducido);
                    }

                    //modifica genero
                    System.out.println("Genero: "+discos.get(i).getGenero());
                    System.out.println("Nuevo Genero: ");
                    generoIntroducido = sc.nextLine();
                    if (!generoIntroducido.equals("")){
                        discos.get(i).setGenero(generoIntroducido);
                    }

                    //modifica duracion
                    System.out.println("Duracion: "+discos.get(i).getDuracion());
                    System.out.println("Nueva duracion: ");
                    duracionIntroducidaString = sc.nextLine();
                    if (!duracionIntroducidaString.equals("")){
                        discos.get(i).setDuracion(Integer.parseInt(duracionIntroducidaString));
                    }
                    break;

                    //OPCION 4 BORRAR ///////////////////////////////////
                case 4:
                    System.out.println("\nBorrar\n==========================================");

                    System.out.print("Por favor, introduzca el codigo del disco que desea borrar: ");
                    codigoIntroducido = sc.nextLine();

                    if (!discos.contains(new Disco(codigoIntroducido,"","","",0))){
                        System.out.println("Ese codigo no existe.");
                    } else {
                        discos.remove(discos.indexOf(new Disco(codigoIntroducido,"","","",0)));
                        System.out.println("Disco borrado.");
                    }
                    break;



            } //fin switch

        } while (opcion != 5);

    }
}

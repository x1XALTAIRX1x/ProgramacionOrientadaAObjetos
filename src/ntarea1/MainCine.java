package ntarea1;
import java.util.Scanner;
/**
 *
 * @author Pato-Note
 */
public class MainCine {
    
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        boolean salir = false;
        int opcion,x=0,con,cinecreado=0;
        String y;
        Cine c = new Cine("");
        
        System.out.println("\nBienvenido");
        while(!salir){
            System.out.println("1.Crear cine");
            System.out.println("2.Vender entradas");
            System.out.println("3.Ver ocupación de sala");
            System.out.println("4.Ver ocupación de sala por rango de filas");
            System.out.println("5.Obtener informe de recaudación");
            System.out.println("6.Mostrar datos de cine");
            System.out.println("7.Agregar nueva sala");
            System.out.println("8.Salir");
            System.out.println("Elija una de las opciones");
            opcion = t.nextInt();
            if(cinecreado==0){
                switch(opcion){
                    case 1:
                        System.out.println("\nUsted a elegido crear cine");
                        System.out.println("ingrese nombre del cine");
                        c.setNombre(t.next());
                        while(x<=0){
                            System.out.println("Ingrese cantidad de salas");
                            x=t.nextInt();
                        }
                        for(con=0;con<x;con++){
                            String nom;
                            byte fil=0,col=0;
                            short val=0;
                            System.out.println("Sala "+(con+1));
                            System.out.println("Ingrese nombre");
                            nom=t.next();
                            while(fil<3 || fil>15){
                                System.out.println("Ingrese cantidad de filas");
                                fil=t.nextByte();
                            }
                            while(col<5 || col>12){
                                System.out.println("Ingrese cantidad de columnas");
                                col=t.nextByte();
                            }
                            while(val<1000){
                                System.out.println("Ingrese valor de la entrada");
                                val=t.nextShort();
                            }
                            Asiento asiento[][]= null;
                            for(int j=0;j<fil;j++){
                                char a=(char) ('a'+j);
                                for(int f=0;f<col;f++){
                                    Asiento n= new Asiento();
                                    n.setFila(a);
                                    n.setColumna((byte) f);  
                                }              
                            }             
                            Sala s = new Sala(nom,fil,asiento,col,val);    
                            if(c.agregarSala(s)==true)
                            System.out.println("Felicidades sala "+(con+1)+" completa");          
                        };
                        cinecreado=1;
                        break;
                    case 8:
                        System.out.println("\nEsta por salir");
                        salir = true;
                        break;
                    default:
                        System.out.println("\nDebe crear cine");
                }
            }else{   
                switch(opcion){  
                    case 1:
                        System.out.println("\nCine ya fue creado");
                        break;
                    case 2:
                        x=0;
                        System.out.println("\nUsted a elegido vender entradas");
                        while(x<=0){
                            System.out.println("Ingrese cantidad de entradas:");
                            x=t.nextInt();
                        }
                        System.out.println("Ingrese Sala:");
                        y=t.next();
                        for(int i=0;i<x;i++){
                            System.out.println("\nEliga asientos");
                            System.out.println(c.buscaSalaPorNombre(y).mostrarOcupacion());
                            System.out.println("\nIngrese asiento(ejemplo a2): ");
                            String a=t.next();
                            Asiento as = new Asiento(a.charAt(0),(byte)Integer.parseInt(a.substring(1)));
                            if(c.venderAsiento(c.buscaSalaPorNombre(a), as)){
                                System.out.println("\nVenta exitosa");
                            }else{
                                System.out.println("\nHa ocurrido un error, intente nuevamente");
                                i--;
                            };
                        }
                        break;
                    case 3:
                        System.out.println("\nUsted a elegido ver ocupacion de salas");
                        for(Sala algo: c.getSalas()){
                            System.out.println("\nSala: "+algo.getNombre());
                            System.out.println(algo.mostrarDatos());;
                        }
                        break;
                    case 4:
                        System.out.println("\nUsted a elegido ver ocupacion de sala por rango de filas");
                        System.out.println("Ingrese sala");
                        break;
                    case 5:
                        System.out.println("\nUsted a elegido obtener informe de recaudacion");
                        break;
                    case 6:
                        System.out.println("\nUsted a elegido mostrar datos de cine");
                        break;
                    case 7:
                        System.out.println("\nUsted a elegido agregar nueva sala");
                        break;
                    case 8:
                        System.out.println("\nEsta por salir");
                        salir = true;
                        break;
                    default:
                        System.out.println("\nElegir numeros entre 1 y 8");
                }
            }
        }
    }
    
    public static boolean validaAsiento(Sala s, String a){
        if(a.toLowerCase().charAt(0)<=(s.getTotalColumnas()+95)){
            if(Integer.parseInt(a.substring(1))<=s.getTotalFilas()){
                return true;
            }
        }
        return false;
    }
}

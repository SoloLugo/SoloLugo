import java.util.*;

public class TareaNivel1 {

    public static void main(String[] tarea) {
        new TareaNivel1();
    }
    public TareaNivel1(){
        this.datos();
    }
    private void datos(){
        Scanner leer = new Scanner(System.in);
        //cuantos datos quiere ingresar el usuario
        System.out.println("¿cuantos datos decimales quiere ingresar? (escriba su respuesta con numeros enteros)");
        int n = leer.nextInt();
        //crea el array si n>0
        if (n<=0){
            //si n<0. le pide ingresar otro número al usuario
            while (n<=0){
                System.out.println("ingrese números mayores a 0...");
                n = leer.nextInt();
            }
        }
        else {
            float[] decimales = new float[n];
            float[] maM = new float[n];
            float[] Mam = new float[n];
            float[] dve = new float[n];
            //pedir los elementos del array
            for (int i=0;i<decimales.length;i++){
                System.out.println("ingrese el elemento "+(i+1)+": (decimal)");
                float a = leer.nextFloat();
                decimales[i] += a;
                maM[i] += a;
                Mam[i] += a;
                dve[i] += a;
            }
            System.out.println("\n");
            float nmayor = decimales[0];
            float nmenor = decimales[0];
            //mostrar "El listado de datos original"
            System.out.println("Listado de datos: (original)");
            for (int i=0;i<decimales.length;i++){
                System.out.print(decimales[i]+", ");
                //numero mayor y menor de decimales[]
                if (decimales[i]>nmayor){
                    nmayor=decimales[i];
                }
                if (decimales[i]<nmenor){
                    nmenor=decimales[i];
                }//esto se usa más adelante XD
            }
            System.out.println("\n");

            //lista de menor a mayor
            for (int i = 0; i < maM.length; i++) {
                //toma el elemento 0 de decimales[]
                for (int j = (i+1); j < maM.length; j++) {
                    //comprara el elemento anterio con el resto de los elementos del array
                    if (maM[j]<maM[i]){
                        float aux1 = maM[i];
                        float aux2 = maM[j];
                        maM[i]=aux2;
                        maM[j]=aux1;
                    }
                }
            }
            System.out.println("menor a mayor");
            for (int i = 0; i < maM.length; i++) {
                System.out.print(maM[i]+", ");
            }
            System.out.println("\n");

            //lista mayor a menor
            for (int i = 0; i < Mam.length; i++) {
                //toma el elemento 0 de decimales[]
                for (int j = (i+1); j < Mam.length; j++) {
                    //comprara el elemento anterio con el resto de los elementos del array
                    if (Mam[j]>Mam[i]){
                        float aux1 = Mam[i];
                        float aux2 = Mam[j];
                        Mam[i]=aux2;
                        Mam[j]=aux1;
                    }
                }
            }
            System.out.println("mayor a menor");
            for (int i = 0; i < Mam.length; i++) {
                System.out.print(Mam[i]+", ");
            }
            System.out.println("\n");

            //promedio de los elemntos de decimales[]
            float prom,p1=0;
            for (int i = 0; i < decimales.length; i++) {
                p1 += decimales[i];
            }
            prom = p1/n;// prom AKA media sirve para calcular la desviación estandar XD
            System.out.println("el promedio de los elementos es: "+prom);
            System.out.println("\n");

            //numero mayor y menor
            System.out.println("el numero mayor es: "+nmayor);
            System.out.println("el número menor es: "+nmenor);
            System.out.println("\n");

            //desviación estandar de los elementos decimales[]
            //se calcula la media... que es lo mismo que el promedio
            //calcular la varianza
            float varianza=0, sumatoria;
            for (int i = 0; i < dve.length; i++) {
                sumatoria = (float) Math.pow((dve[i]-prom),2);//a cada elemento de dve[] se le resta la media y se eleva al cuadrado
                varianza += sumatoria;
            }
            varianza = varianza/(n-1); //todo lo anterior se debe dividir entre la cantidad de elementos menos uno (no entiendo porque sale esto en amarillo)
            //desviación estandar
            float desv = (float) Math.sqrt(varianza);//luego se le saca la raiz cuadrada de la varianza para saber la desviación estandar
            System.out.println("la desviación estandar de loes elementos es: "+desv);
            System.out.println("\n");

            // n números mayores de Mam[]
            System.out.println("¿cuántos números mayores le gustaría ver? (recuerde que tiene "+n+" en su lista)");
            int n1 = leer.nextInt();
            if (n1>n || n1<0){
                while (n1>n || n1<=0){
                    System.out.println("ingrese un número que se encuentre entre 1 y "+n);
                    n1 = leer.nextInt();
                }
            }
            else {
                if (n1>1 && n1<n){
                    for (int i = 0; i < n1; i++) {
                        System.out.print(Mam[i]+" ");
                    }
                }
                if (n1==1){
                    System.out.println("solo puedo mostrarte el número mayor de la lista... "+nmayor);
                }
                if (n1==n){
                    System.out.println("te muestro la lista de elementos de mayor a menor...");
                    for (int i = 0; i < Mam.length; i++) {
                        System.out.print(Mam[i]+" ");
                    }
                }
            }
            System.out.println("\n");

            // n números menoras de maM[]
            System.out.println("¿cuántos números menores le gustaría ver? (recuerde que tiene "+n+" en su lista)");
            int n2 = leer.nextInt();
            if (n2>n || n2<0){
                while (n2>n || n2<=0){
                    System.out.println("ingrese un número que se encuentre entre 1 y "+n);
                    n2 = leer.nextInt();
                }
            }
            else {
                if (n2>1 && n2<n){
                    for (int i = 0; i < n2; i++) {
                        System.out.print(maM[i]+" ");
                    }
                }
                if (n2==1){
                    System.out.println("solo puedo mostrarte el número menor de la lista... "+nmenor);
                }
                if (n2==n){
                    System.out.println("te muestro la lista de elementos de menor a mayor...");
                    for (int i = 0; i < maM.length; i++) {
                        System.out.print(maM[i]+" ");
                    }
                }
            }
            System.out.println("\n");
        }
    }
}

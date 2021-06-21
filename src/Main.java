public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String[] lineas = ManejadorArchivosGenerico.leerArchivo("src/palabras.txt");
        int cantElementos = lineas.length;
        int[] frecExito = new int [cantElementos+1];
        String[] claves = new String[cantElementos+1];
        int contador = 0;

        CalculadorMatricesOptimo calculadorABO = new CalculadorMatricesOptimo(cantElementos);
        
        for (String l: lineas){
          contador++;
          String[] datos = l.split(" ");
          claves[contador] = datos[0];
          frecExito[contador] = Integer.parseInt(datos[1]);
        }
        System.out.println("terminada carga inicial y comienza la insercion al pricipio de las tres listas");

        // cargar CLAVES y FRECUENCIAS DE BUSQUEDAS EXITOSAS
        
        
        String[] lineas2 = ManejadorArchivosGenerico.leerArchivo("src/nopalabras.txt");
        int[] frecNoExito = new int[lineas2.length];
        // cargar FRECUENCIAS DE BUSQUEDAS NO EXITOSAS
        int cont =0;
        for (String t: lineas){
          cont++;
          frecNoExito[cont] = Integer.parseInt(t);
        }

        calculadorABO.encontrarOptimo(cantElementos, frecExito, frecNoExito);

        // IMPRIMIR RAIZ A PARTIR DE MATRIZ R
        // R[0][cantElementos]
        System.out.println(calculadorABO.R[0][cantElementos]);
        //
        // MOSTRAR MATRIZ R
        System.out.println("Matriz R: ");
       Util.imprimirMatriz(calculadorABO.R);
         // MOSTRAR MATRIZ P
       System.out.println("Matriz P: ");
        Util.imprimirMatriz(calculadorABO.P);
         // MOSTRAR MATRIZ W
        System.out.println("Matriz W: ");
       Util.imprimirMatriz(calculadorABO.W);

       // IMPRIMIR COSTO DEL ARBOL OPTIMO A PARTIR DE VALOR DE LA MATRIZ P
        //
        
        // AHORA ARMAR EL ARBOL BINARIO DE BUSQUEDA CORRESPONDIENTE
        TArbolBB elABO = new TArbolBB();

        calculadorABO.armarArbolBinario(0, cantElementos, claves, elABO);
       
        
        // MOSTRAR PREORDEN DEL ARBOL BB RESULTANTE
        
        // COMPROBAR EL COSTO HALLADO EN LA MATRIZ P CON LA EJECUCION DEL METODO DE CALCULAR COSTO DEL ARBOL

        System.out.println("costo del arbol iterando: " + elABO.calcularCosto(frecExito, frecNoExito));


    }
    }



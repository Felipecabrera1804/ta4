/**
 *
 * @author Ernesto
 */
    public class CalculadorMatricesOptimo implements ICalculadorMatricesOptimo{

    int[][] W;
    int[][] P;
    int[][] R;

    /**
     *
     * @param cantElem
     * @param FrecExito
     * @param FrecNoExito
     */
    @Override
    public void encontrarOptimo(int cantElem, int[] FrecExito, int[] FrecNoExito) {
        int i, j, k, kraiz, h;
        int min, PesoSubArboles;

       
        /* Paso 1, para h = 0, 
            wii = bii y pii = wii
            y completar la matriz W:  wij = wij-1+ aj + bj 
       
        completa las sentencias necesarias
	         
        
        */
        h = 0;
        
        for ( i =0; i <=cantElem; i++) {
            this.W[i][i] = FrecNoExito[i];
            this.P[i][i] = this.W[i][i];
            for (j =i +1; j <=cantElem; j++) {
                this.W[i][j] = this.W[i][j-1] + FrecExito[j] + FrecNoExito[j];
            }
        }
       /* Paso 2,  para h = 1 
        pij = wij + pii + pjj 
        
        completa las sentencias necesarias
       */
        h=1;
        for ( i =0; i <=cantElem; i++) {
            j = i+1;
            if (j<=cantElem) {
                this.P[i][j] = this.W[i][j] + this.P[i][i] + this.P[j][j];
                this.R[i][j] = j;
            }
        }
        
       
       /* Paso 3   para h = 2 hasta h = N
        
        completa las sentencias necesarias 
        
      */
        h=2;
        kraiz=0;
        for ( i =0; i <=cantElem; i++) {
            for (j =i +2; j <=cantElem; j++) {
                h= j - i;
                min =0;
                for (k= j - h + 1; k <= j; k++) {
                    if (min==0 || W[i][j]+this.P[i][k-1]+this.P[k][j] < min) {
                        min = W[i][j]+this.P[i][k-1]+this.P[k][j];
                        kraiz =k;
                    }
                }
                this.P[i][j] = min;
                this.R[i][j] = kraiz;
            }
        }

    }

  
   

    public CalculadorMatricesOptimo(int cantElem) {
        crearMatrices(cantElem);
    }

    private void crearMatrices(int cantElem) {
        W = new int[cantElem+1][cantElem+1];
        P = new int[cantElem+1][cantElem+1];
        R = new int[cantElem+1][cantElem+1];
    }

    @Override
    public void armarArbolBinario(int i, int j, String[] Claves, TArbolBB elArbolBB) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}

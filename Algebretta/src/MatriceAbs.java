public abstract class MatriceAbs implements Matrice {

    @Override
    public String toString() {
       StringBuilder str = new StringBuilder("[");
       int i,j=0;
       for (i=0;i<dim();i++){
           for (j=0;j< dim()-1;j++){
                str.append(val(i,j)+", ");
           }
           if (i!=dim()-1) str.append(val(i,j)+"; ");
           else str.append(val(i,j)+"]");
        }
       return str.toString();
    }
}

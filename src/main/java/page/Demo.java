package page;

public class Demo {

    public static void main(String[] args) {

        logicPattern(5);

    }

    public static void logicPattern(int n){

        for(int i=1; i<=n; i++){
            int p='A';
            for(int j=1; j<=i; j++){
                System.out.print((char)p++ +" ");
            }

            System.out.println();
        }
    }


}

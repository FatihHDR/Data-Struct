public class Segitiga<N> {
    private N alas;
    private N tinggi;

    public Segitiga(N alas, N tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public N getAlas(){
        return alas;
    }

    public N getTinggi(){
        return tinggi;
    }

    public int getResultAsInt() {
        int result =  (Integer)getTinggi() * (Integer)getAlas() / 2;
        return result;
    }

    public double getResultAsDouble() {
        double result = (Double)getTinggi() * (Double)getAlas() / 2;
        return result;
    }
}
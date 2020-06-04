package ec.edu.espe.FlowControlAndDataTypes.model;

public class Triangle {

    private int cateto1;
    private int cateto2;

    public Triangle(int cateto1, int cateto2) {
        this.cateto1 = cateto1;
        this.cateto2 = cateto2;
    }

    /**
     * @return the cateto1
     */
    public int getCateto1() {
        return cateto1;
    }

    /**
     * @param cateto1 the cateto1 to set
     */
    public void setCateto1(int cateto1) {
        this.cateto1 = cateto1;
    }

    /**
     * @return the cateto2
     */
    public int getCateto2() {
        return cateto2;
    }

    /**
     * @param cateto2 the cateto2 to set
     */
    public void setCateto2(int cateto2) {
        this.cateto2 = cateto2;
    }

}

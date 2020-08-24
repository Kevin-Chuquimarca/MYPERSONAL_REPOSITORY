
package ec.edu.espe.mongodb.model;

public class Customer {
    private String name;
    private String lastName;
    private String direction;

    public Customer(String name, String lastName, String direction) {
        this.name = name;
        this.lastName = lastName;
        this.direction = direction;
    }

    public Customer(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String nombres) {
        this.name = nombres;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String apellidos) {
        this.lastName = apellidos;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direccion) {
        this.direction = direccion;
    }
}

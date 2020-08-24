
package ec.edu.espe.mongodb.model;

public class Date {
    private String day;
    private String month;
    private String year;

    public Date(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String dia) {
        this.day = dia;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String fecha) {
        this.month = fecha;
    }

    public String getYear() {
        return year;
    }

    public void setAnio(String anio) {
        this.year = anio;
    }

    @Override
    public String toString() {
        return day+"/"+month+"/"+year;
    }
    
    
}

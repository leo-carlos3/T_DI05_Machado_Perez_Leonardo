package machado.leonardo.t_di05_machado_perez_leonardo.plantillasDB_Reports;

public class Entity {
    private int id;
    private String nombre;

    @Override
    public String toString() {
        return nombre;
    }
    public Entity(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setId(int id) {
        this.id = id;
    }
}

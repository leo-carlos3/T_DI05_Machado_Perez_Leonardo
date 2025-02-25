package machado.leonardo.t_di05_machado_perez_leonardo.artistas;

public class Artista {
    int id;
    String nombre;
    public Artista(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return nombre;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
}

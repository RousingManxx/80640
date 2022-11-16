package mx.uv;

public class usuario {
    String id;
    String nombre;
    String password;
    
    public usuario(String id, String nombre, String password) {
        this.id = id;
        this.nombre = nombre;
        this.password = password;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


}

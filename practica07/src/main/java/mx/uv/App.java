package mx.uv;
import static spark.Spark.*;

import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

public class App 
{

    public static Gson gson = new Gson();
    //Base de datos en memoria
    // public static Map<String, usuario> usuarios = new HashMap<>();
    
    public static void main( String[] args )
    {
        // AXIOS
        options("/*", (request, response) -> {
            String accessControlRequestHeaders = request.headers("Access-Control-Request-Headers");
            if (accessControlRequestHeaders != null) {
                response.header("Access-Control-Allow-Headers", accessControlRequestHeaders);
            }
            String accessControlRequestMethod = request.headers("Access-Control-Request-Method");
            if (accessControlRequestMethod != null) {
                response.header("Access-Control-Allow-Methods", accessControlRequestMethod);
            }
            return "OK";
        });
        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));
        // 

        port(80);
        // Inicializacion de datos
        // usuario u1 = new usuario("1", "pablo", "1234");
        // usuario u2 = new usuario("2", "ana", "1234");
        // usuarios.put(u1.getId(), u1);
        // usuarios.put(u2.getId(), u2);
        System.out.println( "Hello World!" );
        before((req,res)-> res.type("application/json"));
        // get("/usuario", (req,res)-> gson.toJson(u1));
        // get("/usuarios", (req,res)-> gson.toJson(usuarios));
        get("/usuarios", (req,res)-> gson.toJson(DAO.listaUsuario()));
        post("/", (req,res)->{
            String datosFormulario = req.body();
            usuario u = gson.fromJson(datosFormulario, usuario.class);
            // usuarios.put(u.getId(), u);
            // return "Usuario agregado";
            return DAO.crearUsuario(u);
        });
    }
}

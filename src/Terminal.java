import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

public class Terminal {

    Path path = Path.of(System.getProperty("user.dir"));
    private String lastComand;

    public void ejecuta(){

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String comandos;
        boolean salir = false;

        do{
            try {
                System.out.print(path.toAbsolutePath()+": ");
                comandos = reader.readLine();
                switch (comandos){
                    case "exit" -> salir= true;
                    case "last-command" -> System.out.println(lastComand);
                    default -> {
                        if(comandos.contains(">"))
                            System.out.println(new Command(comandos));
                        else{
                            System.out.println("Escriba la ruta del archivo de salida: ");
                            redirecciona(comandos,reader.readLine());
                        }
                    }
                }
                lastComand = comandos;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!salir);
    }
    private static void redirecciona(String comandos, String path) {
        String[] a = comandos.split(" ");
        System.out.println(new Command(a,path).toString());
    }

}

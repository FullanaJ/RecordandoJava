import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

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
                            System.out.println(new Command(comandos).toString());
                        else{
                            redirecciona(comandos);
                        }
                    }
                }
                lastComand = comandos;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }while(!salir);
    }
    private static void redirecciona(String comandos) {

        String[] a = comandos.split(" ");

        System.out.println(new Command(a,a[a.length-1]).toString());
    }

}

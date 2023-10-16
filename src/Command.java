import java.io.IOException;
import java.nio.file.Path;
import java.util.Arrays;

public class Command {

    private static float pid;
    private static String comando;
    private static String[] parametros;
    private final int cantidadParamentros;

    private static ProcessBuilder processBuilder = null;

    public static void main(String[] args) {
        try {
            Process process = processBuilder.start();
            pid = process.pid();
            System.out.println(process.exitValue());
        }catch (Exception e){

        }

    }
    public Command(String[] args,String path) {

        processBuilder = new ProcessBuilder(args);
        for (String arg : args) {
            comando += arg;
        }
        if (!path.equals(" ")){
            processBuilder.redirectOutput(Path.of(path).toFile());
            comando+=" "+path;
        }
        cantidadParamentros = args.length;
        parametros = args;
    }

    public Command(String args){
        parametros =args.substring(0,args.indexOf(">")).split(" ");
        processBuilder = new ProcessBuilder(parametros);
        processBuilder.redirectOutput(Path.of(args.substring(args.indexOf(">"))).toFile());
        comando = args;
        cantidadParamentros = parametros.length;
    }

    @Override
    public String toString() {
        return "PID: "+ pid+
                "\nCOMANDO: "+ comando+
                "\nCANTIDADES DE PARAMETROS: "+cantidadParamentros+
                "\nPARAMENTOS: "+parametros.toString();
    }
}

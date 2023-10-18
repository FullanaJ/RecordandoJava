import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Command {

    private static float pid;
    private String comando = "";
    private final String parametros;
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
        ArrayList<String> l= new ArrayList<>(Arrays.asList(args));
        l.add(0,"C:\\Windows\\System32\\WindowsPowerShell\\v1.0\\powershell.exe");
        processBuilder = new ProcessBuilder(l);
        if (path.isEmpty())
            processBuilder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        else
            processBuilder.redirectOutput(Path.of(path).toFile());

        for (int i = 0,size=args.length; i<size ; i++) {
            comando += args[i];
        }
        if (!path.equals(" ")){
            processBuilder.redirectOutput(Path.of(path).toFile());
            comando+=" "+path;
        }
        cantidadParamentros = args.length;
        parametros = String.join(",",args);
        try {
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Command(String args){
        String[] l = args.substring(0,args.indexOf(">")).split(" ");
        parametros = l.toString();
        processBuilder = new ProcessBuilder(parametros);
        processBuilder.redirectOutput(Path.of(args.substring(args.indexOf(">"))).toFile());
        comando = args;
        cantidadParamentros = l.length;
        try {
            processBuilder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "PID: "+ pid+
                "\nCOMANDO: "+ comando+
                "\nCANTIDADES DE PARAMETROS: "+cantidadParamentros+
                "\nPARAMENTOS: "+parametros.toString();
    }
}

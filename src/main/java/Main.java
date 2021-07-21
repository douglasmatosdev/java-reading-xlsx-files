import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        ReadFile read = new ReadFile();

        List<Table> tables = read.create();

        read.loggerTableValues(tables);
    }
}

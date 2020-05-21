import ru.geekbrains.SCV.lesson_2.AppData;
import org.junit.Test;

public class AppDataTest {
    @Test
    public void AppDataTest() {
        AppData appData = new AppData("MyNewFile.txt");
        appData.printAllData();
        appData.allDataToFile("MyNewFile11.txt");
    }
}

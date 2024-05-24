import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Backup {
    public static void backupFilesInDirectory(String directoryPath) {
        File directory = new File(directoryPath);
        File backupDirectory = new File("./backup");

        // Создаем новую папку для резервной копии
        if (!backupDirectory.exists()) {
            backupDirectory.mkdir();
        }

        if(directory.isDirectory()) {
            File[] files = directory.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Files.copy(file.toPath(), new File(backupDirectory.getPath() + "/" + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                        System.out.println("Создана резервная копия файла: " + file.getName());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("Резервная копия всех файлов создана в папке: " + backupDirectory.getPath());
        } else {
            System.out.println("Указанный путь не является директорией.");
        }
    }

    public static void main(String[] args) {
        String directoryPath = ".";
        backupFilesInDirectory(directoryPath);
    }
}
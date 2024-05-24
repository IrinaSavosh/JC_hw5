import java.io.File;

public class Tree {

    /**
     * Метод print для печати содержимого директорий и файлов
     * @param args
     */
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent, boolean isLast){
        System.out.print(indent);
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        if(file.isDirectory()){ // Проверяем, является ли файл директорией
            File[] files = file.listFiles(); // Получаем список файлов и поддиректорий

            int subDirTotal = 0;
            for (int i = 0; i < files.length; i++){
                if (files[i].isDirectory())
                {
                    subDirTotal++;
                }
            }

            int subDirCounter = 0;
            for (int i = 0; i < files.length; i++){
                if (files[i].isDirectory())
                {
                    print(files[i], indent, subDirTotal == ++subDirCounter);
                } else {
                    print(files[i], indent, subDirTotal == subDirCounter); // Вызываем print для файлов
                }
            }
        }
    }
}

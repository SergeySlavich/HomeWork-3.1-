import java.io.*;

public class Main {
    public static void main(String[] args) {
        String path = "C://Games";

        //Для сохранения лога используйте экземпляр класса StringBuilder.
        // Добавляйте в него всю информацию о создании файлов и каталогов.
        StringBuilder log = new StringBuilder();
        File games = new File(path);
        if(games.mkdir()) log.append("Каталог " + path + " создан.\n\n");

        //1. В папке Games создайте несколько директорий: src, res, savegames, temp.
        File src = new File(path + "/src");
        if(src.mkdir()) log.append("Каталог " + path + "/src" + " создан.\n");
        File res = new File(path + "/res");
        if(res.mkdir()) log.append("Каталог " + path + "/res" + " создан.\n");
        File savedgames = new File(path + "/savedgames");
        if(savedgames.mkdir()) log.append("Каталог " + path + "/savedgames" + " создан.\n");
        File temp = new File(path + "/temp");
        if(temp.mkdir()) log.append("Каталог " + path + "/temp" + " создан.\n\n");

        //2. В каталоге src создайте две директории: main, test.
        File main = new File(path + "/src/main");
        if(main.mkdir()) log.append("Каталог " + path + "/src/main" + " создан.\n");
        File test = new File(path + "/src/test");
        if(test.mkdir()) log.append("Каталог " + path + "/src/test" + " создан.\n\n");

        //3. В подкаталоге main создайте два файла: Main.java, Utils.java.
        File mainJava = new File(path + "/src/main", "Main.java");
        File utilsJava = new File(path + "/src/main", "Utils.java");
        try{
            if(mainJava.createNewFile()) log.append("Файл main.java в каталоге " + path + "/src/main" + " создан.\n");
            if(utilsJava.createNewFile()) log.append("Файл utils.java в каталоге " + path + "/src/main" + " создан.\n\n");
        }catch (IOException ex) {
            log.append(ex.getMessage());
        }

        //4. В каталог res создайте три директории: drawables, vectors, icons.
        File drawables = new File(path + "/res/drawables");
        if(drawables.mkdir()) log.append("Каталог " + path + "/res/drawables" + " создан.\n");
        File vectors = new File(path + "/res/vectors");
        if(vectors.mkdir()) log.append("Каталог " + path + "/res/vectors" + " создан.\n");
        File icons = new File(path + "/res/icons");
        if(icons.mkdir()) log.append("Каталог " + path + "/res/icons" + " создан.\n\n");

        //5. В директории temp создайте файл temp.txt.
        File tempTxt = new File(path + "/temp", "temp.txt");
        try{
            if(tempTxt.createNewFile()) log.append("Файл temp.txt в каталоге " + path + "/temp" + " создан.\n\n");
        }catch (IOException ex) {
            log.append(ex.getMessage());
        }
        // Далее возьмите из него текст и запишите его в файл temp.txt с помощью класса FileWriter.
        try(FileWriter writer = new FileWriter(tempTxt)){
            writer.write(String.valueOf(log));
            writer.flush();
        } catch (IOException ex) {
            log.append(ex.getMessage());
        }

        //В результате выполнения программы, на жестком диске комьютера в папке Games должны появиться вышеуказанные
        // файлы и директории. Файл temp.txt должен содержать информацию о том, что все файлы были созданы успешно.
    }
}

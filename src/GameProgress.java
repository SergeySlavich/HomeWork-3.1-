import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int health;
    private final int weapons;
    private final int lvl;
    private final double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    //2. Сохранить сериализованные объекты GameProgress в папку savegames из предыдущей задачи.
    public void saveGame(String saveTo, GameProgress gameProgress, int i){
        try (FileOutputStream fos = new FileOutputStream(saveTo + "/savegames/save" + i + ".dat");
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    //3. Созданные файлы сохранений из папки savegames запаковать в архив zip.
    public void zipFiles(String saveToArchiv, ArrayList<String> list){
        try(ZipOutputStream zout = new ZipOutputStream(new  FileOutputStream(saveToArchiv))){
            Iterator<String> i = list.iterator();
            while(i.hasNext()) {
                ZipEntry entry = new ZipEntry(i.next());
                zout.putNextEntry(entry);
                try(FileInputStream fis = new FileInputStream(saveToArchiv)) {
                    byte[] buffer = new byte[fis.available()];
                    fis.read(buffer);
                    zout.write(buffer);
                    zout.closeEntry();
                } catch(Exception ex){
                    System.out.println(ex.getMessage());
                }
            }
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
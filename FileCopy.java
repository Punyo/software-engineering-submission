import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileCopy {

    private static final String SECRET_FILE = "./secrets.txt";

    public static void main(String[] args) {
        String source =  SECRET_FILE;
        String destination = "./copy_of_secrets_changed.txt";

        try {
            DataInputStream stream = new DataInputStream(new java.io.FileInputStream(source));
            DataOutputStream out = new DataOutputStream(new java.io.FileOutputStream(destination));
            while (stream.available() > 0) {
                byte b = stream.readByte();
                out.writeByte(b);
            }
        } catch (IOException e) {
            System.out.println("ファイルのコピー中にエラーが発生しました。");
            e.printStackTrace();
        }
    }
}

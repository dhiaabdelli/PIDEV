package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;
import javafx.util.Duration;
import javafx.scene.paint.Color;
public class Utils {

    public static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public static void copyFileUsingJava7Files(File source, File dest) throws IOException {
        Files.copy(source.toPath(), dest.toPath());
    }

    public static void showTrayNotification(NotificationType type, String title, String header, String text, String photoNameInServer, int time) {
        TrayNotification tray = new TrayNotification();
        tray.setNotificationType(type);
        tray.setTitle(title);
        tray.setMessage(text);
        tray.setAnimationType(AnimationType.POPUP);
        tray.showAndDismiss(Duration.millis(time));
        tray.setRectangleFill(Color.valueOf("#1e90ff"));
    }
}

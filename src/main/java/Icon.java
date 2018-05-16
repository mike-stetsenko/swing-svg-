import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Icon {
    private JPanel jpanel;

    public static void main (String[] args) throws IOException {

        JPanel mypanel = new Icon().jpanel;

        JFrame frame = new JFrame("Icon");
        frame.setContentPane(mypanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        JLabel iconLabel = new JLabel();
        URL url = Icon.class.getResource("account.xml");

        File file = new File("account.xml");
        FileUtils.copyURLToFile(url, file);

        File file2 = VdXmlToSvg.INSTANCE.vdXmlToSvg(file);

        ImageIcon resizedImage = new ImageIcon(ImageIO.read(file2).getScaledInstance(200, 200, Image.SCALE_DEFAULT));

        iconLabel.setIcon(resizedImage);

        mypanel.add(iconLabel);
    }
}

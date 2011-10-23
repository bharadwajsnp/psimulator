package psimulator.userInterface.Editor.Components;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import psimulator.userInterface.Editor.Enums.HwTypeEnum;
import psimulator.userInterface.Editor.ZoomManager;
import psimulator.userInterface.imageFactories.AbstractImageFactory;

/**
 *
 * @author Martin
 */
public class HwComponent extends AbstractHwComponent {

    private HwTypeEnum hwComponentType;
    private String imagePath;

    public HwComponent(AbstractImageFactory imageFactory, ZoomManager zoomManager, 
            HwTypeEnum hwComponentType, int interfacesCount, String imagePath, String name) {
        super(imageFactory, zoomManager, interfacesCount);

        this.hwComponentType = hwComponentType;
        this.imagePath = imagePath;
        
        bi = imageFactory.getImage(hwComponentType, imagePath, zoomManager.getIconSize(), false);
    }
    

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
     
        if (isMarked()) {
            bi = imageFactory.getImage(hwComponentType, imagePath, zoomManager.getIconSize(), true);
        } else {
            bi = imageFactory.getImage(hwComponentType, imagePath, zoomManager.getIconSize(), false);
        }

        g2.drawImage(bi, xPos, yPos, null);
    }
}

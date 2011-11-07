package psimulator.userInterface.Editor.DrawPanel.SwingComponents;

import java.util.List;
import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import psimulator.dataLayer.DataLayerFacade;
import psimulator.userInterface.Editor.DrawPanel.Components.AbstractHwComponent;
import psimulator.userInterface.Editor.DrawPanel.DrawPanelInnerInterface;
import psimulator.userInterface.Editor.DrawPanel.Enums.DrawPanelAction;

/**
 *
 * @author Martin
 */
public class PopupMenuAbstractHwComponent extends JPopupMenu {

    private DataLayerFacade dataLayer;
    private DrawPanelInnerInterface drawPanel;
    private JMenuItem jItemAlignToGrid;
    private JMenuItem jItemComponentProperties;
    private JMenuItem jItemSelectAll;
    private JMenuItem jItemDeleteComponent;
    private JMenuItem jItemFitToSize;

    public PopupMenuAbstractHwComponent(DrawPanelInnerInterface drawPanel, DataLayerFacade dataLayer, int components) {
        this.dataLayer = dataLayer;
        this.drawPanel = drawPanel;

        jItemComponentProperties = new JMenuItem(dataLayer.getString("PROPERTIES"));
        jItemAlignToGrid = new JMenuItem(dataLayer.getString("ALIGN_TO_GRID"));
        jItemDeleteComponent = new JMenuItem(dataLayer.getString("DELETE"));
        jItemSelectAll = new JMenuItem(dataLayer.getString("SELECT_ALL"));
        jItemFitToSize = new JMenuItem(dataLayer.getString("FIT_TO_SIZE"));

        jItemAlignToGrid.addActionListener(drawPanel.getAbstractAction(DrawPanelAction.ALIGN_COMPONENTS_TO_GRID));
        jItemDeleteComponent.addActionListener(drawPanel.getAbstractAction(DrawPanelAction.DELETE));
        jItemSelectAll.addActionListener(drawPanel.getAbstractAction(DrawPanelAction.SELECT_ALL));
        jItemFitToSize.addActionListener(drawPanel.getAbstractAction(DrawPanelAction.FIT_TO_SIZE));

        if (components == 1) {
            createOneComponentMenu();
        } else if (components == 0) {
            createAllComponentsMenu();
        } else {
            createMoreComponentsMenu();
        }

    }

    private void createOneComponentMenu() {
        this.add(jItemComponentProperties);
        this.addSeparator();
        this.add(jItemAlignToGrid);
        this.add(jItemDeleteComponent);
    }

    private void createMoreComponentsMenu() {
        this.add(jItemAlignToGrid);
        this.add(jItemDeleteComponent);
    }

    private void createAllComponentsMenu() {
        this.add(jItemAlignToGrid);
        this.add(jItemSelectAll);
        this.add(jItemFitToSize);
    }

    public void show(DrawPanelInnerInterface drawPanel, int x, int y) {
        super.show((JComponent) drawPanel, x, y);
    }
}

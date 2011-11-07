package psimulator.userInterface.Editor.DrawPanel.Actions;

import java.awt.event.ActionEvent;
import javax.swing.undo.UndoManager;
import psimulator.userInterface.Editor.DrawPanel.DrawPanelInnerInterface;
import psimulator.userInterface.Editor.DrawPanel.Graph.GraphOuterInterface;
import psimulator.userInterface.MainWindowInnerInterface;

/**
 *
 * @author Martin
 */
public class ActionSelectAll extends AbstractDrawPanelAction {

    public ActionSelectAll(GraphOuterInterface graph, UndoManager undoManager, DrawPanelInnerInterface drawPanel, MainWindowInnerInterface mainWindow) {
        super(graph, undoManager, drawPanel, mainWindow);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // unmark all
        graph.doUnmarkAllComponents();
        // mark all
        graph.doMarkAllComponents();
        // repaint graph
        drawPanel.repaint();
    }
}

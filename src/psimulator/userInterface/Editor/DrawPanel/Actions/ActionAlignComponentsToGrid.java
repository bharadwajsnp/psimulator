package psimulator.userInterface.Editor.DrawPanel.Actions;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import javax.swing.event.UndoableEditEvent;
import javax.swing.undo.UndoManager;
import psimulator.userInterface.Editor.DrawPanel.Components.AbstractHwComponent;
import psimulator.userInterface.Editor.DrawPanel.DrawPanelInnerInterface;
import psimulator.userInterface.Editor.DrawPanel.Graph.GraphOuterInterface;
import psimulator.userInterface.Editor.DrawPanel.UndoCommands.UndoableAlignComponentsToGrid;
import psimulator.userInterface.MainWindowInnerInterface;

/**
 *
 * @author Martin
 */
public class ActionAlignComponentsToGrid extends AbstractDrawPanelAction {

    public ActionAlignComponentsToGrid(GraphOuterInterface graph, UndoManager undoManager, DrawPanelInnerInterface drawPanel, MainWindowInnerInterface mainWindow) {
        super(graph, undoManager, drawPanel, mainWindow);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // align components to grid
        HashMap<AbstractHwComponent, Dimension> movedComponentsMap;
        
        if(graph.getMarkedAbstractHWComponentsCount() > 0){
            movedComponentsMap = graph.doAlignMarkedComponentsToGrid();
        }else{
            movedComponentsMap = graph.doAlignComponentsToGrid();
        }
        
        graph.doUnmarkAllComponents();
        
        // if map not empty set undoable edit
        if (!movedComponentsMap.isEmpty()) {
            // add to undo manager
            undoManager.undoableEditHappened(new UndoableEditEvent(this,
                    new UndoableAlignComponentsToGrid(graph, movedComponentsMap)));

            // update Undo and Redo buttons
            mainWindow.updateUndoRedoButtons();

            
        }
        // repaint draw Panel
        drawPanel.repaint();
        
    }
}

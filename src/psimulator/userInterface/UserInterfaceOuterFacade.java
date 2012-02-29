package psimulator.userInterface;

import psimulator.logicLayer.ControllerFacade;
import psimulator.userInterface.SimulatorEditor.AnimationPanel.AnimationPanelOuterInterface;

/**
 *
 * @author Martin Švihlík <svihlma1 at fit.cvut.cz>
 */
public interface UserInterfaceOuterFacade {
    /**
     * inits view and calls setVisible(true)
     * @param controller 
     */
    public void initView(ControllerFacade controller);
    
    public AnimationPanelOuterInterface getAnimationPanelOuterInterface();
}

package psimulator.dataLayer.Simulator;

import psimulator.dataLayer.Enums.SimulatorPlayerCommand;
import psimulator.dataLayer.SimulatorEvents.SerializedComponents.SimulatorEvent;
import psimulator.dataLayer.SimulatorEvents.SerializedComponents.SimulatorEventsWrapper;
import psimulator.dataLayer.SimulatorEvents.SimulatorEventWithDetails;

/**
 *
 * @author Martin Švihlík <svihlma1 at fit.cvut.cz>
 */
public interface SimulatorManagerInterface {

    public void addSimulatorEvent(SimulatorEvent simulatorEvent) throws ParseSimulatorEventException;
    public void deleteAllSimulatorEvents();

    public void doConnect();
    public void doDisconnect();
    
    public void connected();
    public void disconnected();
    public void connectingFailed();
    public void connectionFailed();
    
    public void recievedWrongPacket();
    
    // -------------------- SETTERS --------------------------
    public void setPlayerSpeed(int speed);
    
    public void setPlayerFunctionActivated(SimulatorPlayerCommand simulatorPlayerState);
    public void setConcreteRawSelected(int row);
    
    public void setRecordingActivated();
    public void setRecordingDeactivated();
    
    public void setRealtimeActivated();
    public void setRealtimeDeactivated();
    
    public void setPlayingActivated();
    public void setPlayingStopped();
    
    public void setPlayingSequentially();
    public void setPlayingByTimestamps();
   
    public SimulatorEventsWrapper getSimulatorEventsCopy();
    public void setSimulatorEvents(SimulatorEventsWrapper simulatorEvents) throws ParseSimulatorEventException;
    
    // -------------------- GETTERS --------------------------
    public EventTableModel getEventTableModel();
    public boolean isConnectedToServer();
    //
    public int getSimulatorPlayerSpeed();
    public boolean isRecording();
    public boolean isPlaying();
    public boolean isRealtime();
    public boolean isPlayingSequentially();
    public boolean isPlayingByTimestamps();
    
    public int getCurrentPositionInList();
    public int getListSize();
    
    public boolean hasEvents();
    
    public void moveToNextEvent();
    public void moveToEvent(final int index);
    public SimulatorEventWithDetails moveToLastEventAndReturn();
    
    public SimulatorEventWithDetails getSimulatorEventAtCurrentPosition();
    
    public SimulatorEventWithDetails getNextEvent();
     
    public boolean isTimeReset();
    
    public boolean isInTheList();
    
    public boolean hasAllEventsItsComponentsInModel();
    
}

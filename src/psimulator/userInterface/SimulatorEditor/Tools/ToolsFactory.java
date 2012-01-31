package psimulator.userInterface.SimulatorEditor.Tools;

import java.util.ArrayList;
import java.util.List;
import psimulator.AbstractNetwork.HwTypeEnum;
import psimulator.userInterface.SimulatorEditor.DrawPanel.DrawPanelToolChangeOuterInterface;
import psimulator.userInterface.SimulatorEditor.DrawPanel.Enums.MainTool;
import psimulator.userInterface.imageFactories.AbstractImageFactory;

/**
 *
 * @author Martin
 */
public class ToolsFactory {
    
    public static List<AbstractTool> getTools(MainTool tool, AbstractImageFactory imageFactory, DrawPanelToolChangeOuterInterface toolChangeInterface) {
        List<AbstractTool> tools = new ArrayList<AbstractTool>();
        
        String path;
        
        switch(tool){
            case HAND:
                path = AbstractImageFactory.TOOL_HAND_PATH;
                
                tools.add(new ManipulationTool(tool, "hand", imageFactory.getImageIconForToolbar(tool, path), toolChangeInterface));
                break;
            case ADD_ROUTER:
                path = AbstractImageFactory.TOOL_ROUTER_PATH;
                
                tools.add(new AddDeviceTool(tool, "Router Linux Generic", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.LINUX_ROUTER, path, 2));
                tools.add(new AddDeviceTool(tool, "Router Linux Generic", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.LINUX_ROUTER, path, 4));
                tools.add(new AddDeviceTool(tool, "Router Cisco Generic", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface,HwTypeEnum.CISCO_ROUTER, path, 2));
                tools.add(new AddDeviceTool(tool, "Router Cisco Generic", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface,HwTypeEnum.CISCO_ROUTER, path, 4));
                break;
            case ADD_SWITCH:
                path = AbstractImageFactory.TOOL_SWITCH_PATH;
                
                tools.add(new AddDeviceTool(tool, "Switch Linux Generic", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.LINUX_SWITCH, path, 4));
                tools.add(new AddDeviceTool(tool, "Switch Linux Generic", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.LINUX_SWITCH, path, 8));
                tools.add(new AddDeviceTool(tool, "Switch Linux Generic", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.LINUX_SWITCH, path, 16));
                tools.add(new AddDeviceTool(tool, "Switch Cisco Generic", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.CISCO_SWITCH, path, 4));
                tools.add(new AddDeviceTool(tool, "Switch Cisco Generic", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.CISCO_SWITCH, path, 8));
                tools.add(new AddDeviceTool(tool, "Switch Cisco Generic", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.CISCO_SWITCH, path, 16));
                break;
            case ADD_END_DEVICE:
                path = AbstractImageFactory.TOOL_END_DEVICE_PC_PATH;
                tools.add(new AddDeviceTool(tool, "PC", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.END_DEVICE_PC, path, 1));
                
                path = AbstractImageFactory.TOOL_END_DEVICE_NOTEBOOK_PATH;
                tools.add(new AddDeviceTool(tool, "Notebook", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.END_DEVICE_NOTEBOOK, path, 1));
                
                path = AbstractImageFactory.TOOL_END_DEVICE_WORKSTATION_PATH;
                tools.add(new AddDeviceTool(tool, "Workstation", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.END_DEVICE_WORKSTATION, path, 4));
                break;
            case ADD_REAL_PC:
                path = AbstractImageFactory.TOOL_REAL_PC_PATH;
                
                tools.add(new AddDeviceTool(tool, "Real PC", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.REAL_PC, path, 1));
                break;
            case ADD_CABLE:
                path = AbstractImageFactory.TOOL_CABLE_PATH;
                
                tools.add(new CreateCableTool(tool, "Ethernet cable", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.CABLE_ETHERNET, path, 10));
                tools.add(new CreateCableTool(tool, "Optics cable", imageFactory.getImageIconForToolbar(tool, path), 
                        toolChangeInterface, HwTypeEnum.CABLE_OPTIC, path, 5));
                break;
            default:
                break;
        }
        
        return tools;
    }
}

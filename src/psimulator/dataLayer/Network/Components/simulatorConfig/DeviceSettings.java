/*
 * Erstellt am 2.3.2012.
 */
package psimulator.dataLayer.Network.Components.simulatorConfig;

/**
 *
 * @author Tomas Pitrinec
 */
public class DeviceSettings {

    private NetworkModuleType netModType;
    private RoutingTableConfig routingTabConfig;
    private NatConfig natConfig;

    public DeviceSettings() {
    }

    public NatConfig getNatConfig() {
        return natConfig;
    }

    public void setNatConfig(NatConfig natConfig) {
        this.natConfig = natConfig;
    }

    public NetworkModuleType getNetModType() {
        return netModType;
    }

    public RoutingTableConfig getRoutingTabConfig() {
        return routingTabConfig;
    }

    public void setNetModType(NetworkModuleType netModType) {
        this.netModType = netModType;
    }

    public void setRoutingTabConfig(RoutingTableConfig routingTabConfig) {
        this.routingTabConfig = routingTabConfig;
    }

    public enum NetworkModuleType {

        tcp_ip_netmod,
        simple_switch_netMod,}
}

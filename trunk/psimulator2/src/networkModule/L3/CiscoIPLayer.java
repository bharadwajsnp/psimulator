/*
 * created 13.3.2012
 */

package networkModule.L3;

import commands.cisco.WrapperOfRoutingTable;
import dataStructures.IpPacket;
import dataStructures.L4Packet;
import dataStructures.ipAddresses.IPwithNetmask;
import dataStructures.ipAddresses.IpAddress;
import logging.Logger;
import logging.LoggingCategory;
import networkModule.L3.RoutingTable.Record;
import networkModule.TcpIpNetMod;

/**
 * Cisco-specific IPLayer.
 *
 * @author Stanislav Rehak <rehaksta@fit.cvut.cz>
 */
public class CiscoIPLayer extends IPLayer {

	public final WrapperOfRoutingTable wrapper;

	public CiscoIPLayer(TcpIpNetMod netMod) {
		super(netMod);
		this.ttl = 255;
		wrapper = new WrapperOfRoutingTable(netMod.getDevice(), this);
	}

	/**
	 * Na ciscu, kdyz se odesila novy packet (ze shora), tak se nejdrive kontroluje RT, pokud neni zadny zaznam,
	 * tak se clovek ani nedopingne na sve rozhrani s IP.
	 * @param packet
	 * @param dst
	 */
	@Override
	public void handleSendPacket(L4Packet packet, IpAddress dst) {

		Record record = routingTable.findRoute(dst);
		if (record == null) { // kdyz nemam zaznam na v RT, tak zahodim
			Logger.log(this, Logger.INFO, LoggingCategory.NET, "Zahazuji tento packet, protoze nejde zaroutovat", packet);
			return;
		}

		IpPacket p = new IpPacket(record.rozhrani.getIpAddress().getIp(), dst, this.ttl, packet);

		if (isItMyIpAddress(dst)) {
			handleReceivePacket(p, null); // rovnou ubsluz v mem vlakne
			return;
		}

		processPacket(p, record, null);
	}

	@Override
	public void changeIpAddressOnInterface(NetworkInterface iface, IPwithNetmask ipAddress) {
		super.changeIpAddressOnInterface(iface, ipAddress);
		wrapper.update();
	}
}

/*
 * Erstellt am 27.10.2011.
 */

package dataStructures;

/**
 *
 * @author neiss
 */
public abstract class L3Packet {

    L2Packet l2packet;
    L4Packet data;

	int getSize() {
		int sum = 0;
		// TODO: pridat velikost tohoto paketu
		return sum + (data != null ? data.getSize() : 0);
	}

}

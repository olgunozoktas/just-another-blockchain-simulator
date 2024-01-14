package jabs.network.p2p;

import jabs.network.networks.Network;
import jabs.network.node.nodes.Node;

/**
 * A P2P connection for the Snow consensus algorithm
 */
public class SnowP2P extends AbstractP2PConnections {
    /**
     * @param network The network to connect to
     */
    public void connectToNetwork(Network network) {
        this.peerNeighbors.addAll(network.getAllNodes());
        node.getNodeNetworkInterface().connectNetwork(network, network.getRandom());
    }

    /**
     * @param node The node to connect to
     * @return Whether the connection was successful
     */
    @Override
    public boolean requestConnection(Node node) {
        return false;
    }
}

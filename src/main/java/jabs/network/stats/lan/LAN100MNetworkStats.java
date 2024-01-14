package jabs.network.stats.lan;

import jabs.network.stats.NetworkStats;
import jabs.simulator.randengine.RandomnessEngine;

public class LAN100MNetworkStats implements NetworkStats<SingleNodeType> {
    protected final RandomnessEngine randomnessEngine;
    /**
     * This is the average latency of a LAN network in seconds.
     */
    protected static final double LAN_AVERAGE_LATENCY = 0.02; // 20 milli seconds
    /**
     * This is the shape parameter of the Pareto distribution. It is the same as the shape parameter of the Zipf distribution.
     */
    protected static final double LATENCY_PARETO_SHAPE = 5;
    /**
     * This is the average bandwidth of a LAN network in bytes per second.
     */
    protected static final long LAN_AVERAGE_BANDWIDTH = 100000000;


    public LAN100MNetworkStats(RandomnessEngine randomnessEngine) {
        this.randomnessEngine = randomnessEngine;
    }

    /**
     * @param fromPosition The position of the node in the network
     * @param toPosition   The position of the node in the network
     * @return The latency between the two nodes in seconds
     */
    @Override
    public double getLatency(SingleNodeType fromPosition, SingleNodeType toPosition) {
        double scale = ((LATENCY_PARETO_SHAPE - 1) / LATENCY_PARETO_SHAPE) * LAN_AVERAGE_LATENCY;
        return randomnessEngine.sampleParetoDistribution(scale, LATENCY_PARETO_SHAPE);
    }

    /**
     * @param position The position of the node in the network
     * @return The download bandwidth of the node in bytes per second
     */
    @Override
    public long sampleDownloadBandwidth(SingleNodeType position) {
        return LAN_AVERAGE_BANDWIDTH;
    }

    /**
     * @param position The position of the node in the network
     * @return The upload bandwidth of the node in bytes per second
     */
    @Override
    public long sampleUploadBandwidth(SingleNodeType position) {
        return LAN_AVERAGE_BANDWIDTH;
    }
}

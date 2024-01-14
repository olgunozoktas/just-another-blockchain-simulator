package jabs.log;

import jabs.ledgerdata.Vote;
import jabs.ledgerdata.pbft.PBFTCommitVote;
import jabs.ledgerdata.pbft.PBFTPrePrepareVote;
import jabs.ledgerdata.pbft.PBFTPrepareVote;
import jabs.network.message.Packet;
import jabs.network.message.VoteMessage;
import jabs.simulator.event.Event;
import jabs.simulator.event.PacketDeliveryEvent;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;

public class RanklyCSVLogger extends AbstractCSVLogger {
    /**
     * creates an abstract CSV logger
     *
     * @param writer this is output CSV of the logger
     */
    public RanklyCSVLogger(Writer writer) {
        super(writer);
    }

    /**
     * creates an abstract CSV logger
     *
     * @param path this is output path of CSV file
     */
    public RanklyCSVLogger(Path path) throws IOException {
        super(path);
    }

    @Override
    protected String csvStartingComment() {
        return String.format("Rankly Simulation with %d nodes on %s network", this.scenario.getNetwork().getAllNodes().size(), this.scenario.getNetwork().getClass().getSimpleName());
    }

    @Override
    protected boolean csvOutputConditionBeforeEvent(Event event) {
        return false;
    }

    @Override
    protected boolean csvOutputConditionAfterEvent(Event event) {
        if (event instanceof PacketDeliveryEvent) {
            PacketDeliveryEvent deliveryEvent = (PacketDeliveryEvent) event;
            Packet packet = deliveryEvent.packet;
            return packet.getMessage() instanceof VoteMessage;
        }
        return false;
    }

    @Override
    protected boolean csvOutputConditionFinalPerNode() {
        return false;
    }

    @Override
    protected String[] csvHeaderOutput() {
        return new String[]{"Simulation time, Vote message type", "Voter ID", "From Node", "To Node"};
    }

    @Override
    protected String[] csvEventOutput(Event event) {
        Packet packet = ((PacketDeliveryEvent) event).packet;
        Vote vote = ((VoteMessage) packet.getMessage()).getVote();

        String voteType = "";
        if (vote instanceof PBFTCommitVote) {
            voteType = "COMMIT";
        } else if (vote instanceof PBFTPrepareVote) {
            voteType = "PREPARE";
        } else if (vote instanceof PBFTPrePrepareVote) {
            voteType = "PREPREPARE";
        }

        return new String[]{Double.toString(this.scenario.getSimulator().getSimulationTime()), voteType, Integer.toString(vote.getVoter().nodeID), Integer.toString(packet.getFrom().nodeID), Integer.toString(packet.getTo().nodeID)};
    }
}

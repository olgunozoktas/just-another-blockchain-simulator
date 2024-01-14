package jabs.scenario;

public class ScenarioTemplate extends AbstractScenario {

    public final double stopTime;
    public final double averageBlockInterval;

    /**
     * creates a network by using your scenario parameters close to real-world but excluding transaction simulation for
     * better simulation speed
     *
     * @param name                 determines the name of simulation scenario
     * @param seed                 this value gives the simulation seed value for randomness engine
     * @param stopTime             this determines how many seconds of simulation world time should it last.
     * @param averageBlockInterval This determines the interval between two block generations in seconds.
     */
    public ScenarioTemplate(String name, long seed, long stopTime, double averageBlockInterval) {
        super(name, seed);
        this.stopTime = stopTime;
        this.averageBlockInterval = averageBlockInterval;
    }

    @Override
    protected void createNetwork() {

    }

    @Override
    protected void insertInitialEvents() {

    }

    @Override
    protected boolean simulationStopCondition() {
        return false;
    }
}

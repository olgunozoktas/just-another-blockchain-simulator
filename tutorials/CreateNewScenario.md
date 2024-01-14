In order to create a new scenario follow these steps:

# How to create a new scenario

To Create a new scenario file under `src/main/java/jabs/scenarios` folder.

- You can use `src/main/java/jabs/scenarios/ScenarioTemplate.java` as a template.
- Put your scenario file under `src/main/java/jabs/scenario` folder.
- In every scenario there must be a createNetwork method which creates the network and returns the network object.
- In every scenario there must be a insertInitialEvents method which inserts the initial events to the network.

## How to create a Network for your scenario

Network is necessary for every blockchain simulation and it is the main class that holds all the information about the network such as;

- [x] Nodes
- [x] NodeTypes
- [x] NetworkStats such as latency, bandwidth, etc.
- [x] RandomnessEngine 
- [ ] NetworkEvents
- [ ] NetworkEventQueue
- [ ] NetworkEventExecutor
- [ ] NetworkEventLogger
- [ ] NetworkEventStats

In order to create a network you need to create a new class that extends `Network` class.

- You can use `src/main/java/networks/NetworkTemplate.java` as a template.

- Network class has a constructor which takes a `RandomnessEngine` and `NetworkStats` as an argument.
    - You can use any stats class that extends `NetworkStats` class or if you have data you can create your own
      under `src/main/java/jabs/stats` folder.
    - As default `NetworkTemplate` uses `LAN100MNetworkStats` which is a network stats class for 100M LAN network.
    - You can use any randomness engine that extends `RandomnessEngine` class or if you like you can create your
      own under `src/main/java/jabs/simulator/randengine` folder.
    - As default `RandomnessEngine` uses MersenneTwister algorithm which is a fast and good random number generator in
      simulation.


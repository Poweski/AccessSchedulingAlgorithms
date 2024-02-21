# AccessSchedulingAlgorithms

The program is intended to simulate the operation of processor access planning algorithms for reporting processes. Examine
average waiting time of processes for different scheduling algorithms:
1. FCFS
2. SJF (no preemption)
3.SRTF (SJF with pre-emption)
4. rotational (with the option of selecting a time quantum)

Algorithms should be checked for the same test data (i.e. the same sequences of reporting processes).

There should be more test strings (20? 50?); the result will be average values.

In each sequence there will be N processes with random processor phase lengths (select the phase length distribution to suit
situations in a real system where it is not uniform), occurring at random times (choose
parameters so that a queue of processes waiting for processor allocation can be created).

Possible process representation: class (number, processor phase length, reporting moment, waiting time /initially equal to 0/...)

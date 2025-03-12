# Resumos t2

## Computing Services

### First generation batch processing: Map-reduce

Used to process **large amounts of data** in **parallel** on a **cluster**. It is a **programming model** and an **associated implementation** for processing and generating large data sets. It is based on the **map** and **reduce** functions.

An abstraction that allows **simple computations** we were trying to perform but **hides the messy details** of parallelization, fault tolerance, data distribution, and load-balancing in a library.

Example, Find out the words that appear more frequently in a text.

Goal 1: Count the number of times each word appears in a text. - Map each word to 1, system will sort and shuffle, reduce the sum of the values.

Goal 2: Find the most frequent words. - Map will reverse the order of pair, system will sort and shuffle, and reduce will reverse the order of pair again.

Each computation step is composed of a map and a reduce steps.

A computation is a sequence of map-reduce computations.

This system always sorts by key, that's why in Goal two we need to reverse the order of pairs.

Architecture:

1. Input files stored in a distributed file syustem, and divided into splits
2. Clients send programs to the master
3. Master asks workers to run map tasks: process splits in parallel, and SAVE INTERMEDIATE results in multiple files by key
4. Master asks workers to run reduce tasks: reducers sort intermediate files before processing values for each key

**Master node** coordinates the execution:

- Task status
- Idle tasks get scheduled as workers become available,
- **When a map task completes, it sends the master the location and sizes of its intermediate files, one for each reducer**
- Master pushes this info to reducers
- Master pings workers periodically to detect failures

**Worker node** performs map or reduce tasks, as requested by the coordinator.

Upon failure on **one of the workers**, the task is restarted in another worker.

**Stragglers (slow workers)** - If a task is taking too long to complete, it is launched in other worker, and the **FIRST RESULT IS USED.**

**Master failure** - MapReduce task is aborted and client is notified

We can use a **combine** function **(usually the same as the reduce function)** to pre-aggregate the number of equal tuples in the mapper.

Apache HADOOP 2.0 - handles batch processing (MapReduce and Spark) in **Pig** and streaming in Storm, and uses YARD for cluter resource management and HDFS 2 (redundant, reliable storage, **highly-available**)

#### What are the down-sides?

- Requires complex computations to be split into successive jobs causing **HIGH LATENCY**
  - need to **read and write files**
  - underlying filesystem **replication** (for writes)
  - one job must finish before the next can be started
**TO SOLVE THESE LIMITATIONS WE USE APACHE SPARK**

### Second generation batch processing: Spark

**Key ideas:**

- Spark programs comprise **multiple chained data transformations**
- **Resilient Distributed Dataset (RDD)**

### Stream processing

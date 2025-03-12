# Course presentation

1st project in kuda, 2nd in spark
Groups of 2 students

Each group member willl commit regularly his individual contributions to the group rep using clearl messages
submission will be a commit ID
THERE IS A PROJECT REPORT, Work division percentage must be supported by the commit logs
1º work de inicio de abril até inicio de maio
2º work de inicio de maio até início de junho
discussões no inicio de junho que pode ser preciso.

temos de citar qualquer fonte que tenha inspirado o nosso trabalho.
permitido para código que não está diretamente relacionado diretamente com o trabalho em avaliação, devemos dizer no relatório onde usamos e para quê.

## Why parallel computing

**Parallel computer** - computational system composed of multiple processing elements so that it may execute multiple operations at the same time.
**Parallel computing** - Execution model that leverages parallel computers to execute multiple operations at the same time.
**Parallel programming** - Decompose a program into multiple tasks that will be executed by a parallel computing model with the goal of improving performance.

Thing actually run at the same time (bourded by the number of cores), instead of concurrency that is the illusion of running at the same time.

How to handle parallel computing control in shared state?

**Why?**

- Processor evolution, typical power stagnated, so in order to have a boost in performance we need to take advantage of multiple core processors, so we need to parallelize our code.
- Compute-intensive problems

- Identify what to parallelize, partition the problem, synchronize/communicate
- Many solutions are architecture dependent

**Flynn's Taxonomy:**

- Single instruction, Single data (SISD) architecture:
  - A hardware thread in a modern CPU

- Multiple instruction, Multiple Data (MIMD)

## GPU Programming

- CPU - complex cores, few cores, high clock rate
- GPU - thousands of simple cores, low clock rate

**Tensor cores** - specialized cores for matrix operations

**CUDA** - Compute Unified Device Architecture - Nvidia's parallel computing platform and programming model for GPUs


Host (CPU) <- PCIe bus -> Device (GPUs)

The host handles resource management and the orchestration of the device.
The device SPMD Porgramming model

1. Alocate memory
2. Copy data to device
3. Load GPU code and execute it
4. Copy results from GPUs to host

__global__ - kernel function that runs on the device

using <<>> indicates a call to the device code
N, M denotes a grid of N x M elements

nvcc program.cu -o name_of_executable

Code examples on the slides

A set of blocks is reffered to as a grid
A block is composed by several threads
# Maximize Parallelism - Last lesson on cuda

## Grid Size

- Expose enough parallelism to
  - Keep all cores working
    - Number of thread blocks > numbers of SMs
  - Hide synchronization latency
    - Number of threads blocks > 2 * number of SMs
    - This means that if one block stalls, the other can keep working.
- Scalability envisioning future devices
  - Number of thread blocks > 100 * number of SMs

N - 1000000 -> each thread computes 1 result. vs Grid of N/4 threads, by making the same thread compute 4 results.

## Concurrent grids

- If one kernel is not enough to keep the GPU busy, we can launch multiple kernels at the same time, that will run concurrently.

- Math pipes and memory system don't really care where the work is coming from, as long as there's enough work to do.

- Two cases:
  - Concurrent grids from the same CPU process
    - Launch different functions into different streams
  - Several CPU processes sharing the GPU

## Thread block size

- size of thread block At least 64 = 2 warps (if one stalls)
- Larger may be better: 128, 256, 512, 1024; depends on the problem.

## Hide latency - Memory Access

- A thread stalls when one of the operands is not available.
- Latency might access in the memory access because the value may be in the global memory.

- We can have multiple warps per block to mask the latency when one stalls the other continues to work.

## Occupancy

- Selection of block size is an optimization step that is related to the occupancy of the SM.

- Occupancy = active warps per SM / maximum number or active warps per SM

- If the occupancy is high, the SM can switch between warps to hide latency, otherwise, it will stall.

There's a calculator for this.

https://xmartlabs.github.io/cuda-calculator/

- NSight Compute also features an occupancy calculator.
- there's a function called cudaOccupancyMaxActiveBlocksPerMultiprocessor that can be used to obtain an estimate of the maximum occupancy for a given kernel.

- Don't need 100% occupancy to obtain maximum performace, just the necessary to keep the GPU busy all the time
  - There's no direct correlation

## Guidelines

- Start with 128-256 threads per block

## Kernel Code optimizations

### Maximizing memory throughput

- Memory access operations are issued per warp
- The concurrent accesses of the threads of a warp will coalesce (merge) into several transactions equal to the number of 32-byte transactions necessary to service all the threads of the warp.

- NVIDIA example
  - Stores - Invalidate L1 and write-back for L2 (sets a dirty bit on L2 and only when that block is evicted it is written back to the global memory)

- Coalesced memory access - contiguous memory access
- Stride memory access - interleaved memory access
- Random memory access

- Coalesced and aligned
    - Warp requests 32 aligned, consecutive 4 byte words
    - Address fall in 4 segments

- Use signed integers instead of unsigned integers in loops.
- Use arithmetic instructions to mask latency

Re-arrange data so that in a warp the divergence is minimal. if there's many if statements the performance will be bad.

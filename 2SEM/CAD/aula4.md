# 

Grid of N Blocks

Block 0 - 1 SM with multiple warps

Block 1 - 1 SM with multiple warps

1 warp is 32 threads.

Each lock executes in lock step - all threads in a warp execute the same instruction at the same time.

- **Size of the block must be a multiple of a warp size (usually 32)**

Per thread Local-Memory

Per device global memory, that can be distributed into multiple kernels.

We want to reduce the redundant use of global memory.

So we want to use shared memory.

Shared memory is a memory that is shared between threads in a block.

We can divide an imagine into tiles and treat each tile with a block.

- 1d stencil example 
- stencil is a technique used in image processing to apply a filter to an image.

```c++
__global__ void stencil_id(int *in, int *out) { // in and out are pointers to the global memory
    __shared__ int temp[BLOCK_SIZE + 2 * RADIUS]; // RADIUS is the number of elements that we need to load from the global memory
    int gindex = threadIdx.x + blockIdx.x * blockDim.x; // global index
    int lindex = threadIdx.x + RADIUS; // local index

    temp[lindex] = in[gindex]; // each thread loads one element from global memory to shared memory
    if (threadIdx.x < RADIUS) { // if the thread is in the first RADIUS elements
        temp[lindex - RADIUS] = in[gindex - RADIUS]; // load the previous RADIUS elements
        temp[lindex + BLOCK_SIZE] = in[gindex + BLOCK_SIZE]; // load the next RADIUS elements
    }

    __syncthreads(); // wait for all threads to finish loading the elements, WE NEED THIS TO MAKE SURE THAT ALL THREADS HAVE LOADED THE ELEMENTS, act as a barrier for ONE BLOCK.

    int result = 0;
    for(int offset = -RADIUS; offset <= RADIUS; offset++) { // for each element in the stencil
        result += temp[lindex + offset]; // apply the stencil 
    }

    out[gindex] = result; 
}
```

- In CUDA we have **atomics** for synchronization - slower than normal acesses, but they are necessary when we want to make sure that the data doesn't have races.

For the blur, the blur kernel can use shared memory and we can compare the performance.

## CUDA UVA (only know it exists for the test)

CUDA provides Unified Virtual Memory (UVM) - the memory is shared between the CPU and the GPU.

cudaMallocManaged - allocates memory that is accessible by both the CPU and the GPU.

cudaDeviceSynchronize - waits for all the kernels to finish.

cudaSetDevice(gpu_identifier) - set the current GPU

- P2p memcopies: cudaMemcpyPeerAsync - copy memory between GPUs
  - no need to manually maintain memory buffers on the host for inter-GPU exchanges

- if peer-access is enabled: cudaDeviceEnablePeerAccess
  - Bytes are transferred along the shortest PCIe path 
    - No staging through the host
    - increased throughput
  - if peer-access is not available
    - CUDA driver stages the transfer via CPU memory

## CUDA Streams

- A stream is a queue of device work
  - The host places work in the queue and continues on immediately
  - Device schedules work from stream when resources are free

- CUDA operations are placed within a stream
  - Kernel launches, memory copies

- If we want to execute multiple things at the same time, we need

- Default stream is Stream 0

we can specify the stream in the kernel launch

```c++
kernel<<<grid, block, 0, stream>>>(args); // third argument is the size of shared-memory allocated per block, and the fourth is the stream
kernel2<<<grid, block2, 0, stream>>>(args2);
```

## Asynchronour Memory Transfer Operations

- cudaMemcpyAsync
  - Copies data between host and device memory
  - Can be used to copy data between two devices
  - Can be used to copy data between two host pointers

## Memory Type

- Device Memory
- Pageable host memory
- Pinned host memory

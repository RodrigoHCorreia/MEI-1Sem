# Accelerator Computing

- **Accelerator Computing** is a computing paradigm where the computation is offloaded to a specialized hardware accelerator, which is optimized for a specific type of computation.

- GPGPU (General Purpose Graphics Processing Unit) Using gpus for non-graphical computation.

- Most of the code running on the CPU and for some tasks, we allocate the code to the GPU.

- CUDA Compilation - any source file containing CUDA code must be compiled with the NVIDIA CUDA compiler nvcc.
- NVCC outputs C code (host cpu code) and PTX code (gpu code) and then it uses the NVIDIA driver to compile the PTX code to binary code.

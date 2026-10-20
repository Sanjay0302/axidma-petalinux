[axidma-zcu102-bringup]: https://sanjay0302.github.io/posts/axidma-zcu102-bringup/

## Zynq UltraScale+ AXI DMA Hardware Design

This repository contains Vivado hardware design targeting the Zynq UltraScale+ MPSoC (ZCU102).

The entire project—including the block design, IP configurations, and build execution—is encapsulated in a single, standalone Tcl script. It requires zero local XML .bd files, binary .dcp checkpoints, or cached data to build.

## Hardware Architecture

The block design (`design_1`) connects the Zynq Processing System to programmable logic via AXI interfaces, forming a loopback/data-processing pipeline. Key components include

* Zynq UltraScale+ PS: Configured for the ZCU102 evaluation board with 64-bit high DDR memory access enabled (HPC0 port).
* AXI DMA (v7.1): Configured for 64-bit addressing and Scatter-Gather operations.
* AXI4-Stream Data FIFO: 8192-depth FIFO acting as the stream data payload sink/source for the DMA.
* AXI SmartConnect: Handles memory-mapped routing between the DMA and the PS high-performance coherent (HPC0) port.
* Processor System Reset: Synchronizes resets across the 200 MHz PL clock domain.

## Prerequisites

* Xilinx Vivado 2022.2 (Strict version requirement for Tcl API and IP core compatibility).
* Linux or Windows terminal with the Vivado environment sourced.

## How to Build

> Refer this blog [blog][axidma-zcu102-bringup]

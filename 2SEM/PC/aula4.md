# Concurrency Control

## Mutual Exclusion

- Precedence Ordering
  - Never true that A -> A
  - If A -> B then not true that B -> A
  - If A -> B and B -> C then A -> C
  - A -> B & B -> A might both be false!

a0^k - kth occurence of event a0
A0^k - kth occurence of interval A0

what is inside the lock is the **critical section**

CSik -> be thread i's kth critical section execution
CSjm -> be thread j's m-th critical section execution

Then either CSik -> CSjm or CSjm -> CSik (critical sections do not overlap)

## Deadlock-Free

- If some thread calls lock()
  - And never returns
  - Then other threads must complete lock() and unlock() calls infinitely often
- System as a whole makes progress
  - Even if individuals starve

## Starvation-Free

- If some thread calls lock()
  - It will eventually return
- Individual threads make progress

Starvation-Freedom implies Deadlock-Freedom ??

## Bounded Waiting

- Want stronger fairness guarantees

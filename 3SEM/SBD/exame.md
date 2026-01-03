# Sistemas de Base de dados


## Parte 1 - Core Systems and Storage

- How data is stored and accessed and how queries are executed physically.

Phase 1 — Foundations (what everything depends on)

Blocks, tuples, memory

Indexes (B+ trees, clustering, bitmap)

👉 Without this, you cannot answer 50% of the exam.

Phase 2 — Query execution

Join algorithms

Join order & cost estimation

Phase 3 — Correctness

Concurrency (2PL, deadlocks, isolation levels)

Recovery (logging, undo/redo)

### Main Topics

- **Physical storage & blocks** - T03, T04
  - Block size
  - Tuple size
  - Number of tuples
  - Convert tuples to blocks
- Typical taks:
  - How many blocks does table X occupy, does table X fit in memory

- **Indexes**
  - B+ tree indexes
  - Clustering vs non-clustering
  - Composite keys
  - Bitmap indexes (low-cardinality attributes)
- Typical questions:
  - Which index would you create and why
  - Would this query benefit from the existing index
  - Is the order of attributes in the index important

- **Buffer management**
  - LRU vs MRU
  - Sequential scans vs index scans


## Parte 2 - Query Processing and Transactions

- **Join algorithms & cost estimation (Very important)** - T07, T09
- Typical questions:
  - Which join algorithm would you use and why
  - Which plan has lower cost
  - Given memory M, which join strategy applies

- **Transactions & Concurrency** - T10, T11
  - Two-phase locking
  - Strict / Rigorous 2PL
  - Deadlocks
  - Recoverability
  - Snapshot isolation vs Serializable
- Typical questions:
  - Place lock-S / lock-X / unlock
  - Decide:
    - Is schedule 2PL
    - Is it recoverable
    - does it deadlock
  - Give a schedule in sql that causes a problem

- **Recovery & logging** - T12
  - Log records
  - UNDO / REDO
  - Checkpoints
  - Immediate vs deferred update
- Typical questioons:
  - Complete the log after a crash
  - Which transactions are undone / redone


Saber distinguir:

- Deadlock-Free: At least one thread will always progress (no total halt).

- Starvation-Free: Every thread will eventually progress (no indefinite waiting).

- Bouded Waiting

Proved necessity: at least N registers are required to implement a deadlock-free mutual exclusion for N threads.

Understand when something is linearizable and when it is not.

Oject projections, thread projections, Complete subhistory, Sequential histories, Well-formed histories, Equivalent subhistories.


Sequential consistency

- Progress Conditions:
  - Deadlock-Free: System-wide progress guarantee.
  - Starvation-Free: Thread-level progress guarantee.
  - Lock-Free: Some thread always makes progress.
  - Wait-Free: Every thread always makes progress, no matter the state of other threads.

![alt text](image.png)

Ver registers e atomic snapshot.

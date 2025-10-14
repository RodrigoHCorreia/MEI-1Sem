# Approximation Algorithms: Greedy Algorithms for Load Balancing

— a way of assigning jobs (tasks) to machines (workers) so that no machine gets too overloaded.

## 1. The Problem: Load Balancing

* You have **m machines** (like workers or CPUs).
* You have **n jobs** (tasks), each job takes some time $t_j$.
* Each job must go **entirely** to one machine (no splitting).
* A machine can only do one job at a time.
* **Goal:** Assign jobs so that the *heaviest machine* (the one with the most total work) is as light as possible.
  This maximum load is called the **makespan**.

Example: 3 machines, 6 jobs with times = {2, 3, 4, 6, 2, 2}.
We want the work as balanced as possible.

---

## 2. Greedy Algorithm 1 (greedyLB1)

The idea is very simple:

1. Start with all machines empty (load = 0).
2. For each job:

   * Look at the machine with the **smallest load so far**.
   * Give this job to that machine.
3. Repeat until all jobs are assigned.

 It’s like always giving the next job to the least-busy worker.

---

### Example (m = 3, jobs = {2, 3, 4, 6, 2, 2})

* Start: machines = \[0, 0, 0]
* Job 2 → Machine 1 → \[2, 0, 0]
* Job 3 → Machine 2 → \[2, 3, 0]
* Job 4 → Machine 3 → \[2, 3, 4]
* Job 6 → Machine 1 → \[8, 3, 4]
* Job 2 → Machine 2 → \[8, 5, 4]
* Job 2 → Machine 3 → \[8, 5, 6]

Final loads = \[8, 5, 6] → Makespan = 8

---

## 3. Why "Approximation Algorithm"?

This problem is **NP-complete** (too hard to solve exactly for large inputs).
So instead of the best possible answer, we want a **good enough answer quickly**.

We measure this with the **approximation ratio**:

$$
\frac{L}{L^*}
$$

* $L$ = the makespan our algorithm finds.
* $L^*$ = the best possible makespan (the “perfect” solution we don’t know).

If the ratio is small (close to 1), our algorithm is good.

---

## 4. Properties (the inequalities)

The slides show 3 key facts to prove greedyLB1 is “not too bad”:

1. **P1:** The best possible makespan is at least as big as the biggest job.
   (Because some machine has to take that job.)

   $$
   L^* \geq t_j \quad \forall j
   $$

2. **P2:** The best possible makespan is at least the average load.
   (Because total work ÷ number of machines is the average, and someone has to take at least that much.)

   $$
   L^* \geq \frac{1}{m}\sum_{j=1}^n t_j
   $$

3. **P3:** The machine that ends up the heaviest (makespan $L$) differs from the optimal by at most the last job it got.
   (Reason: it was the least loaded machine when it got that job, so it can’t be much worse than the others.)

   $$
   L \leq L^* + t_k
   $$

---

## 5. Proof greedyLB1 is a 2-approximation

* From P3: $L \leq L^* + t_k$.
* From P1: $t_k \leq L^*$.
* So: $L \leq L^* + L^* = 2L^*$.

That means:

$$
\frac{L}{L^*} \leq 2
$$

👉 greedyLB1 is guaranteed to give a solution at most **twice as bad as the perfect solution**.

Not perfect, but not terrible either.

---

## 6. Greedy Algorithm 2 (greedyLB2)

This is the same as greedyLB1, but with a small twist:

* Before assigning jobs, **sort them from biggest to smallest**.
* Then assign them using the same “least loaded machine” rule.

This avoids putting big jobs too late where they ruin balance.

---

### Example again (jobs = {6,4,3,2,2,2})

* Job 6 → Machine 1 → \[6,0,0]
* Job 4 → Machine 2 → \[6,4,0]
* Job 3 → Machine 3 → \[6,4,3]
* Job 2 → Machine 3 → \[6,4,5]
* Job 2 → Machine 2 → \[6,6,5]
* Job 2 → Machine 3 → \[6,6,7]

Final loads = \[6, 6, 7] → Makespan = 7.
Better than 8 from greedyLB1!

---

## 7. Why is greedyLB2 better?

* With sorting, we can prove it’s a **1.5-approximation**:

  $$
  \frac{L}{L^*} \leq \frac{3}{2}
  $$
* That means it’s guaranteed never to be worse than 1.5× the perfect solution.
* Much better than the factor of 2.

---

✅ **In plain words:**

* The problem is splitting jobs across machines fairly.
* GreedyLB1 = always give next job to least busy → guarantees at most 2× worse than perfect.
* GreedyLB2 = sort jobs biggest first → guarantees at most 1.5× worse than perfect.

---

## Approximation Analysis


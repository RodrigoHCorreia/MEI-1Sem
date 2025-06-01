# Concurrent Objects

> At least 1 questions of each subtopic in the test
> **Chapter 3 of the book**

## Correctness

In a concurrent setting, we need to specify both the **safety** and the **liveness** properties of an object

- Safety: the object behaves as expected
- Liveness: the object makes progress

## Sequential Objects

- Correctness:
    - The object has a **state** given by a set of **fields**
    - The object has a set of **methods** that can be called to manipulate the state


## Quiescent and Sequential Consistency

### Sequential Specifications

- **Precondition**: a condition that must be true before the method is called
- **Postcondition**: a condition that must be true after the method is called

For dequeue:

- Precondition: Queue is non-empty
- Postcondition: Returns first item in queue
- Postcondition: Removes first item in queue

or

- Precondition: Queue is empty
- Postcondition: Throws exception
- Postcondition: Queue is unchanged

- **These are very good because: (in sequetial programming)**
  -  the interactions among methods are captured by side-effects of methods on object state. state meaningful BETWEEN METHOD CALLS.
  -  Documentation size linear in number of methods
  -  Can add new methods without changing existing ones

- **In concurrent programming:**
  - the object state may never be meaningful.
  - Must characterize all possible interactions among methods, therefore, the documentation size is exponential in the number of methods.
  - Everything can potentially interact with everything else

correctness: changes the state as expected if ran in isolation. will also change the state as expected raking into account the preconditions and postconditions of other methods.

## Linearizability

- Each method should :
  - "Take effect"
  - Instantaneously
  - Between invocation and response events
- Object is correct if its sequential behavior is correct, if this is true for all possible interleavings of method calls, then the object is **linearizable.**

some methods in an object might be linearizable and others not.

- One whose methods are all linearizable
- One whose all possible executions are linearizable

If there is an order that makes sense then it is linearizable.

### Object projection and thread projection

- Remove everything else that is not the object we are looking at

H:
A q.enq(3)
A q:void
B p:enq(4)
B p:void
B q:deq()
B q:3

H|q:
A q.enq(3)
A q:void


B q:deq()
B q:3

**Complete subhistory is when we discard the elements that don't have a response.**

**A Sequential Histories is a history when all events match, even if the Final invocation is pending, its ok!!.**

**Well-formed histories - are histories where per-thread projections are sequential.**

**Two histories are equivalent if the projections are the same.**

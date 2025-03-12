# Aula prática 1

- A scaler is a single number.
- Vector is a 1D array.
- Matrix is an array of arrays.

**Linear Algebra:**

Solving EX 1.

m pacients
n symptoms
p treatments

S = R^(m x n)
T = R^(m x p)

P = R^(n x p)
P is the total number of patients with symptom j that received treatment k. 
P = S^T * T

... (**ex. c and d missing**)

**Calculus:**

Solving EX 2. **(need to finish the rest at home)**

- **Derivative** is the rate of change of a function. In more simple terms, it can tell us how a function is changing at any given point.

- **Gradient** (TRIANGULO INVERTIDO) is a vector that points in the direction of the greatest rate of increase of a function.

**partial derivate** is when you isolate one variable, consider the others as constants, and derivate the function.

**Probability:**

**E**[X] = 1/N * sum(Xi)

**Python examples:**

```python
def squared_of_integeres(lst):
	return [x ** 2 for x in lst if x%2 == 0]

NUMPY:
import numpy as np (np is name space for the functions in numpy)

def squared_of_integeres(lst):
	return np.array([x ** 2 for x in lst if x%2 == 0])
```

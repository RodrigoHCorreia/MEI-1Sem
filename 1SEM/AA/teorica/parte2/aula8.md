# Aula 8 - Ensembles, Gradient Boosting

Gradient Boosting - Supervised Learning

2 types of ensembles:

- Bagging - Bootstraping - If i change a little bit the dataset, the model will be different. (nr of dataset = nr of models), treat models in parallel, and then aggregate the results.
- Boosting - Models in series instead of parallel, and the next model comes to correct the previous model. We can do this by Gradient Boosting.

## Gradient Boosting

- Sequential Learning, improving the current model made by previous models.
- Gradient descent Otimization: Specify a loss function, and then we try to minimize this loss function.

## Simple Regression Example

- **Initial Prediction:** We start with a simple model, a simple line. (predict the mean price)
- **Compute Residuals**
- **Fit a model to Residuals**
- **Update Predictions**
- **Iterate**

- Boosting Framework.
- Weak Learners - Tipically aa Shallow Decision Trees.
- Ensemble Model: Sum of all the weak learners.

Fm - Final prediction after M iterations.
hm - Weak learner at iteration m. ( Um modelo que não é muito bom.)
lambdam - Weight applied to the m-th learner.

O que diferencia do bagging, é que vemos o problema como um problema de otimização, que queremos minimizar a Loss Function.

1. **Compute Negative Gradient** - For each data point, compute the residual rim.
2. **Fit Base Learner** - Fit a weak learner to predict rim.
3. **Compute Optimal Weight** - gamma_m = argmin sum_i L(yi, Fm-1(xi) + gamma * hm(xi))
4. **Update Model** - Fm = Fm-1 + gamma_m * hm

Se usarmos gradient boosting e virmos overfitting n#ao queremos ter lambda = 1.

^y = Fm(x) = sum gamma_m * hm(x)

## XGBoost

- **Speed and Performance** - through parallelization and cache optimization.
- **Regularization**
- **Flexibility**

### Key Features

**- Handling Missing Values - THIS MODEL HANDLES MISSING VALUES.**

How can we do 4??

Omega(f) = lmabda * T + 1/2 * gamma sum(w^2)

- T: Number of leaves
- w: leaf weights
- gamma and lambda: Regularization parameters

When i compute the worth of one structure, i compute it based on what could be the possible weight for this data.

## Unsupervised Learning

We want to find patterns and structure in the data.

Anomalys detection, clustering, dimensionality reduction.

- Cluters
- Outliers
- Useful signal hidden in noice, e.g. human speech over a noisy phone, or a noisy image. split the signal from the noice.

Dataset + Algorithm -> Unsupervised Model

### K-means

- Encontrar K clusters nos dados.
- Cada cluster é caracterizado por um centroide.
- Os clusters revelam estruturas interessantes nos dados.

- As a block in semi-supervised learning. (note that UL will be used on the second assignment)

- **Representation/Visualization** - We can take a big image and map it into a point in a 2D space, and then we can see the clusters.

Model Notation

f: X -> S

that maps inputs x E X to some notion of structure s E S.

K-means:

f0 : X -> S

that assigns each input x to a cluster s E S = {1, 2, ..., K}

Loss function is the sum of the squared distances from each point to the centroid of the cluster.


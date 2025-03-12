# Aula teórica 9

## Multiclass Classification - Last Supervised learning topic

Sigmoid = Logistic function

One vs All approach - This is a hack

**~Softmax Function - Very important and very used**

SIGMOID: R-> [0,1]

SOFTMAX (multi-class extension): R^k -> [0,1]^k, this maps a k-dimensional input zE R to a k-dimensional vector of probabilities

Likelihood.

Minimize the L function to respect to T.

exponential of the scor over the exponential of the sum of the scores.

## Unsupervised Learning Continuation

Dimensionality reduction

- PCA

- Linear Algebra
- Statistics
- Optimization

Organizar data em mxn matrix
subtrair a media
calcular o SVD ou os eigenvectors of the covarience.

## 2º Trabalho

Tarefa 1:

Fazer um baseline com linear variable, vamos ter sensor MSE em vez de MSE. Queremos escrever código para fazer gradient descent no sensor MSE, podemos ter de adicionar ridge regularization a isso.

minimizar em termos de tetas, o nosso c MSE( y, ^y) + lambda * ||tetas||^2
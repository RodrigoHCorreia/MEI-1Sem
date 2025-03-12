# Probabilistic modeling - Bayesian approach

- bayesian theorem - 

Example: 

Bayes theorem - P(belief | data) = P(data | belief) * P(belief) / P(data)

Naive Bayes - assumes that the features are independent given the class.

This allows very simple space complexity, even tho the assumption might not be true.

## Review for test: Core topics in ML

- Regression
- Opitimization
- Classification
- Probabilistic ML
- Overfitting, Regulation and Generalization
- Feature Engineering and Debugging ML Models

### Linear regression basics:

- linear model: y = alpha0 + alpha1 * x + epsilon
- Goal: Minimize **MSE**
- Least Squares problem: Least Squares and its connection to Maximum Likelihood Estimation (MLE)

### Gradient Descent for Linear Models

- Gradient Descent Update: theta = theta - etha * gradient
- Impact of learning rate:
  - Too small = slow,
  - Too large = overshoot
- Convergence Criteria: when to stop the iterations.

### Classification: Logistic Regression

- Logistic Function: sigmoid
- Decision Boundary: P(y|x) = 0.5 separates the classes
- Loss Function: Log-loss or cross-entropy

### Overfitting Regularization, Generalization

- Overfitting: model captures noise instead of patterns.
  - We see when is our model too large using the validation set.
  - ONDE O VALIDATION ERROR É MENOR É O DEGREE QUE DEVEMOS ESCOLHER DA POLINOMIAL.
- Na função de perda adicionamos um de dois termos:
  - L1 regularization: Lasso 
  - L2 regularization: Ridge

### Feature Engineering 

- Importance of transforming raw data into meaningful features.
- Techniques:
  - Normalization
  - One-Hot encoding
  - Polynomial Features
  - ...
- Domain knowledge is crucial for meaningful features

- Data leakage - ter cuidado a separar os dados de treino e teste, para não haver dados partilhados.
- Overfitting
- Bias in training data

- Residual plots for regression error analysis.
- Using confusion matrix and other metrics for classification
- The ML workflow - we need to be very fast what our models need, and then we iterate very fast.

training set é para treinar o modelo, só para fitting.
validation set é para escolher qual o modelo é o melhor com dados que o modelo nunca viu.

Iterar entre train e validation para escolher o melhor modelo. depois vamos escolher 2 MODELOS, e vamos aparecer os valores na private leaderboard.

depois de dar commit ao erro temos de saber o erro, para isto usamos o test set, com dados que o modelo nunca viu.
test set é para avaliar o modelo só para saber o erro de generalização (aquilo que interessa).


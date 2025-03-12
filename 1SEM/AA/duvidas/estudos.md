# Duvidas

Should we really remove all 0s lines?? why?.
also check that dropna only drops if ENTIRE line is NaN.

Porque juntam os datasets de treino e de target, tiram umas merdas e separam de novo??

## Trabalho

- Normalizar os dados para termos escalas semelhantesz
- Utilizar as tecnicas de regularização (lasso ou ridge), para evitar overfitting e underfitting
- Perceber se o modelo tem multicolinearidade para perceber qual delas usar (ridge é bom para evitar isso)
- Perceber qual é o melhor valor para o parâmetro de regularização e ver como isso afeta o MSE
- multicolinearidade - é quando duas ou mais features (variáveis independentes) estão altamente correlacionadas.
- Utilizar gradient descent para o training
- Avaliar o modelo com base na MSE.

Treino em Matriz [t, x1, y1, ...] -> X, Y

Teste em Matriz [t, x, y ] -> X, Y

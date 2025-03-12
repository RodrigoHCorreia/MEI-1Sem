# Notas reunião 21-01-2025:

- Professora Ana:
  - A professora ana tem os seguintes ficheiros:
  - 2 modelos diferentes igual ao arnaldo, 1 para antes das 12h com 1 pre-processor a gerar os cenários com base nas previsões e depois a gerar o modelo, e depois antes das 19h com um pre-processor que gera cenários diferentes e um modelo diferentes.
- Para a juliana fazer:
  - limpar as tabelas

- Professor Arnaldo:
  - Foram enviados 2 ficheiros, o primeiro de 2023 está bem. No ficheiro 2023 e 2024 - o ano inteiro de 2023 vem com uma das colunas dos price (day-ahead price) toda a null
  - clean_and_merge.py -> clean_and_merge.csv -> com 1 file de PT e um de ES, dá um ficheiro limpinho pronto a prever.
  - market_forcaster.py -> o segundo ficheiro demora mais tempo -> preds_DA_BaFRR_data.csv
  - A ultima hora está a ser 22h00
  - O periodo acaba às 23, o ficheiro de preds_DA tem a ultima entrada às 22h00, e a previsão das 23h? o professor diz que é bug mas eu não consegui perceber bem a resposta.
  - Necessário fazer testes atuais para ver o que o modelo faz em relação às previsões tendo em conta que dependendo da hora executada temos diferentes variáveis disponíveis até certo tempo.
  - 2 modelos diferentes 1 day-ahead pré conhecimento do day-ahead price antes das 12, 1 modelo que já sabe o day-ahead price antes das 19h.
  - **Como tratar com a mudança da hora**
- O que meter no ficheiro de configuração: **Ficou no Ar**
  - Tipo de modelo: Heuristic, Deterministic, Stochastic.
  - SOC Inicial, máximo e mínimo. se eles têm maneira de saber o SOC minimamente antes do tempo, porque não arranjar maneira da infratrading dizer-nos o SOC para chamar como parâmetro para o modelo.
- O que eu acho que faz sentido:
  - 

O sistema dá previsões de 25 horas e nós é que temos de saber o dia e "truncar" as horas se necessário, mantendo as 25, ou 24, ou 23.

- O sistema tem de saber qual é o dia e saber quantas horas tem o dia em função da data.

# Parsing

Dizer se uma gramática é ambigua ou não

dizer os NULL, FIRST e FOLLOWs

Recursividade esquerda

**Saber como justificar se a gramática é ambigua** - pegar numa palavra vazia e mostrar que tem mais que uma árvore de derivação

Se diz que n é ambigua, calcular o NULL e os FIRST e FOLLOWs e a tabela de parsing

O output de um analisador lexido é um conjunto de tokens.

## Exercise 2

dangling else problem. dar a possibilidade de ter ifs sem elses e saber de que if é o else.

S -> int | bool | if S then S | if S then S else S

hipotese 1:
if bool then (if bool then int) else int

hipotese 2:
if bool then (if bool then int else int)

Monstrar as parse trees:
1ª:
S espande para if S then S, onde o primeiro S é bool, o segundo S expande também para if S then S else S, onde o primeiro S é bool, o segundo S é int e o terceiro também.

2ª
S expande para if S then S else S, primeiro S expande para bool, o terceiro para Int e o segundo para If S then S, o primeiro S é bool e o segundo é Int.

VER TELEMOVEL PARA MELHOR TABELA.

## Exercise 3

G3: 

P -> P(P)
Recursividade de esquerda: 

X -> X o que for

nunca pode ser LL(1) porque todas elas partilham o mesmo conjunto de FIRSTs

G1:
P -> PP

Follow: Encontrar todas as regras onde o A ocorre à direita da seta.

A não tem nada logo é sempre o conjunto vazio

Stack e Input

quando a tabela tem celulas sem nada, é porque é um erro gramatical aka syntax error.

## Exercise 7

A gramática é LL(1)? Nenhuma gramática ambígua será LL(1).
# Aula Pré Teste - Static Typing

## Type checking

- adicionar cenouras com batatas dependendo da linguagem dá resultados diferentes.

- "5" + 37...
- Em ocalm dá type error, em kotlin dá 537
- Em php dá 42

- ao adicionar e1 + e2, como podemos decidir se isto é legal e que operação devemos realizar.
- A resposta é **typing**, uma análise a fazer ao programa que liga tipos a cada expressão.

- Dynamically typed : Tipos são verificados em **tempo de execução.** (python)
- Statically typed: Tipos são verificados em **tempo de compilação.** (ocaml, kotlin, c)

- Type checking must be decidable - não importa a dificuldade, tem sempre de computar se a expressão é válida ou não.
- Type checking must reject programs whose evaluation would fail; this is **type safety**
- Type checking must not reject too many non-absurd programs; the type system must be **expressive**

- **Casts** are a way to bypass type checking.

### Limits of Static Typing

- para um qualquer input, temos de ser capaz de dizer sim ou não.
- o compiler deve detetar erros, e emitir avisos, com o risco de falsos positivos.

### Type checking WHILE, Formally

- Let us conssider the language WHILE from lecture 2 -> **to revisit.**
- We are going to make it even more similar to C
- We are going to formally
  - Give **type checking rules** for this language
  - Show a **type safety property**

- view big-step vs small-step operational semantics

- big-step, obtemos sempre o valor final
- small-step dizemos basicamente que um comando pode-se transformar noutro comando, que pode-se transformar noutro comando, até chegarmos ao valor final.

- big-step para expressions, small-step para statements

**Porquê esta distinção de small e big step??**

- Quando temos as ssemanticas big-step é muito fácil escrever o interpretador, fazendo uma função recursiva.

- No entanto a big-step não é muito interessante para tipificação, porque queremos garantir que em **cada um dos passos** de computação, deve ser analizar e fazer a tipificação.
- tau é utilizado para representar um dos tipos, e é não terminal.

**Typing judgment:**

O tipo de uma variável é dado por um **typing environment** Γ (gamma) (uma função que associa variáveis a tipos)

a typing judgment/relation é escrita:

sobre as premissas do ambiente Γ, a expressão e tem tipo τ, se e só se:
- Γ ⊢ e : τ

Ler da memória, significa que uma desreferenciação de um ponteiro tem o mesmo tipo que o ponteiro.

O e tem de ser uma zona de memória. 

- Γ ⊢ *p + b : int

- desreferenciamos o ponteiro, verificando que tem o mesmo tipo, e depois dizemos que sim senhor o p pertence ao dominio do Γ.

Static typing is strong:
    - We want to know if a program **has semantics**, without actually running it.

Hence, type checking processing is a **compromise** between expressiveness and decidability.

## Type safety

Threorem (type safety):
- If Γ ⊢ s, then reduction of s is either infinite or reaches skip.

**PRESERVATION** - se o comando é bem tipificado e os ambientes são corretos, se eu der um passo e resultar num novo comando, esse comando também é bem tipificado.

Um programa que tem type safety nunca acaba por problema de semântica. Ou seja, nunca acontece acessos indevidos à memória.

Passar das arvores do parser para as arvores tipificadas através do type checker.

the type checker turns a parsed syntax tree into another, typed syntax tree. We build new trees.

Em muitas linguagens, existe subtyping entre tipos numéricos.
class Vehicle
class Car extends Vehicle

Then we can assign a Car to a Vehicle variable.
- Se o tipo é um sub-tipo do outro, podemos fazer a conversão.

Vehicle v = new Car(); - Tipo estático é Vehicle, tipo dinâmico é Car.

Se fizer um cast para carro, é um downcast e o codigo tem de fazer um teste dinâmico para ver se o carro é mesmo uma subclasse de Vehicle.

## Overloading

- Overloading é uma maneira de reutilizar nomes de funções, mas com diferentes tipos de argumentos.
- Por exemplo a função add.

Overloading != overriding
- Overriding é quando uma subclasse tem uma função com o mesmo nome que a superclasse, mas com implementação diferente.

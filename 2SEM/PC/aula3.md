# Multithread in C

- we need to inforce the privacy of the variables when programming in C since they are public by default. (use static)

> #define PRIVATE static -> find and replace

> #include <stdio.h> -> find and replace da INTERFACE diretamente no ficheiro

- a char in C is the ascii code of the character

> #include <ctype.h> -> define tipos, int32, etc

## Monte Carlo PI C

Espectativas:
Real Time: - Olha para o relógio, começa, quando acaba para. é esperado que o tempo baixe quando o número de cores em usage aumenta.
CPU Time: - O CPU Time, inclui o tempo gasto por todos os cores para o programa em questão. é suposto ser mais ou menos constante.

-O3 -> otimização do compilador.

o do prof com 1 thread e 1000000000 pontos demorou 4.86s, pre otimizações demorava 18s.

função worker das pthread é um void* e recebe um void*. devemos passar o nr de jobs.

void* worker(void*)
    int n = *(int*)x;

o facto de ficar tão pior tem haver com a eliminação da cache.

Devemos fazer no eixo do x o nr de processadores e no y quantas vezes mais rápido foi.

ver quantas vezes é que o c é mais rápido que a aula.
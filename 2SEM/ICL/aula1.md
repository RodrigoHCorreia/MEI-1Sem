# Introdução à Interação e Compilação de Linguagens

## Introdução

Professor - Mário Pereira
Office Hours: Wednesday 14h00-16h00, 243, Ed. II

The project:

A compiler from a subset of a programming language into machine code (assembly) - dá muito trabalho.

- Ententer mecanismos internos de compilação
- Entender vários aspetos de linguagens de programação via compilação
- Ganhar competências com ferramentas de compilação

### Frontend of a compiler

source -> Lexical analysis -> stream of tokens -> parsing -> abstract syntax tree -> semantic analysis -> abstract syntact + symbol table.

O compilador realiza 1 tarefa complexa mas apenas 1 vez
O interpretador realiza 1 tarefa mais simples, mas repete para cada input.

Logo, o código compilado é muito mais rápido que o interpretado.

- Modelar a sintaxe abstrata da source language
- Usar existentes/implementar ferramentas de parsing (lexer, parser)

Usar linguagens funcionais em vez de imperativas.

typechecker
parser
lexer
comp
expressions
ast - abstract syntax tree

mll, mly, ml - ocaml

porque escolher OCaml? 

Temos garbage collector, estilo imperativo, static type-checking, paradigma **funcional**:

- Funções anónimas, tipos de dados algebricos e pattern matching, programação imutavel, polimorphism parametrico.

o que isto tem que kotlin n tem?

#### TPC

2º cap. livro
slides intro ocaml

- fazer 1 programa que é 1 pauta digital

f = f0 * 2^octave

```ocaml

(* Definitions of music scores *)
type note = C | D | E | F | G | A | B
type pitch = { note: note; octave: int }
type duration = Full | Half | Quarter | Eighth | Sixteenth
type symbol = Note of duration * pitch | Rest of duration
type score = { symbols: symbol list; tempo: int }

let o1_frequency (n: note) = match n with
    | C -> 32.70
    | D -> 36.71
    | E -> 41.20
    | F -> 43.65
    | G -> 49.0
    | A -> 55.0
    | B -> 61.74

let frequency p = 
    let f0 = o1_frequency p.note in
    f0 *. (2.0 ** (float_of_int p.octave))

let duration d t = 
    let temp = 60 /. (float_of_int t) in
    match d with
    | Full -> temp *. 4.0
    | Half -> temp *. 2.0
    | Quarter -> temp
    | Eighth -> temp /. 2.0
    | Sixteenth -> temp /. 4.0

let df_of_symbol s tp = 
    match s with
    | Rest d -> (duration d tp, 0.0)
    | Note (d, p) -> (duration d tp *, frequency p)

(* Playing sounds *)

let play_sound s tp= 
    let (d, f) = df_of_symbol s tp in
    let pid = Unix.create_process
        "/user/bin/play"
        [| "play"; "-r"; "44100" "-n" "synth"; string_of_float d; "sin"; string_of_float f |]
    let _ = Unix.waitpid [] pid in ()

let rec play_score sc t = 
    List.iter (fun s -> play_sound s sc.tempo) sc.symbols

let c_4_8 = Note (Eighth, {note = A; octave = 4})
let d_4_8 = Note (Eighth, {note = D; octave = 4})
let e_4_8 = Note (Eighth, {note = E; octave = 4})
let f_4_8 = Note (Eighth, {note = F; octave = 4})
let g_4_8 = Note (Eighth, {note = G; octave = 4})
let a_4_8 = Note (Eighth, {note = A; octave = 4})
let b_4_8 = Note (Eighth, {note = B; octave = 4})

let score = 
    { symbols = [c_4_8; d_4_8; e_4_8; f_4_8; g_4_8; a_4_8; b_4_8];
    tempo = 292 
    }

let () = 
    play_score score
```

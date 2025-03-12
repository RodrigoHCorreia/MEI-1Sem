1 por linha, 

TEMPO: 292
Do: 4 Eigth
Re: 5 Quarter

type token = 
    | Note of string * int * string
    | Rest of string * int
    | Tempo of int
    | End

Usar um List.mpa para converter a lista de tokens, na lista de símbolos

string -> string list -> token list -> (int * symbol list) -> score

## 1 - Modelo etc.

- Falta tratar da serviço sistema e verificar diarios, intradiarios, etc.

- Teve oportunidade de olhar para o modelo? sei que já mandei tarde
- ver comentários no modelo

- DST dá dores de cabeça enormes porque só 363 dias estão certos
- No caso de usarmos timestamps, Podia ficar tipo assim:

- QUANDO HÁ SPLIT NO MERCADO COMO TRATAR? 

```sql
CREATE TABLE time_dimension (
    interval_id      SERIAL PRIMARY KEY,
    utc_timestamp    TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    region_id        INT REFERENCES region (id),
    local_timestamp  TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    is_dst           BOOLEAN NOT NULL,
    is_ambiguous     BOOLEAN NOT NULL,
    is_gap           BOOLEAN NOT NULL
);
```

- https://mercado.ren.pt/PT/PeriodosHorarios/Paginas/periodos15.aspx?isdlg=1


Mas mesmo assim para o display depois dos gráficos acho que ia ser mais complicado para converter para o formato que queremos por exemplo nos dias em que há mudança

https://www.tinybird.co/blog-posts/database-timestamps-timezones


- Necessidade de guardar timestamps??
- Para o nosso use case e apresentação de gráficos se calhar é mais simples mostrar:
Dia
Hora
Minuto (Por enquanto sempre a 0, mas de forma a garantir futura compatibilidade com bids 15-15 mins
Interval length (por enquanto é sempre 1H mas de forma a permitir que seja 15Mins)
Assim deve ser mais fácil fazer o display dos gráficos

## 2 - App de inserção

- App que insere content de ficheiros numa diretoria numa BD
- Implementa diferentes parsers para diferentes tipos de ficheiros
- Converter os excel para csv
- Converter os .txt para csv

Ficheiros que temos de considerar:
- Lista Unidades (ProductionUnits)
- Lista Owners 
Match por Owner -> Description do owner

- curva (diário)
- marginal (price)
  - YEAR;MONTH;DAY;PERIOD;PRICE1_PT;PRICE2_ES

- Diário:

1. Curvas - Curvas de oferta e demanda com unidades

casada - fiz pedido de compra/venda e deu match
ofertada - fiz pedido de compra/venda e ninguem quis saber de mim porque vendi caro ou comprei barato

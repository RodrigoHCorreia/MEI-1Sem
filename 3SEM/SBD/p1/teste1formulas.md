# Formulas

b*tT + S*tS

## Selection algorithms

A1 - Linear search

- Scan each file block and test all records

Cost = b(r) block transfers + 1 seek
If selection on a key attribute, stop when found = b(r)/2 block transfers + 1 seek (on average)

A2 - Primary (clusteriing) index on key attribute

(hi+1) * (tT + tS)

Meaning - traverse hi B+- tree nodes + fetch 1 data block, each doing a transfer and a seek
hi = height of B+- tree index with formula:

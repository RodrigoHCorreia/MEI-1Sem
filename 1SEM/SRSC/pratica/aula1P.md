# Aula prática 1

## Symmetric Crypto

2 famílias de algoritmos:

**Block Ciphers** - AES, RC6, Serpent, (old ones: DES, 3DES)
    - É block cipher porque o plain text é dividido em blocos de tamanho fixo e é cifrado bloco a bloco (AES: 128 bits) 
    - encrypt proccess - plain text -> AES Block Cipher (with **same** key) -> cipher text 
    - decrypt proccess - cipher text -> AES Block Cipher (with **same** key) -> plain text
**Stream Ciphers**

currently the keysize is something like **128**, 256, 448, 512 bits. - ARC RC4, CHA-CHA-Poly

AP1 vamos ter de usar **Block Ciphers**.

**computationally impossibility**

If u use AES u are safe if u use the right parameters.

```java
String ciphersuite="AES/CTR/PKCS5Padding"; // Algorithm/mode/padding
```

- manage ur secrets the minimum possible time in memory (reduce the window of opportunity for an attacker to steal the key)
- 
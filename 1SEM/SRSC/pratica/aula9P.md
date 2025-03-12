# Aula prática 9

27/12
-> ASD

30/11
-> Cloud

Receber o enunciado algures no fim-de-semana (15/11 +-), a deadline ainda está por defenir.

O que precisamos para o segundo trabalho é o Lab 3, Lab 4 e Lab 5.

No clip temos um indice com os materiais de cada lab.

Como usar eliptic curve, falta no laboratório 3.

Lab 5 Diffie-Hellman

Usinc ECC - If we want to program stuff using Eliptic Curves.

ECIES - From BC.

Then we create the KeyPairGenerator.

After then we use ECGenParameterSpec to generate a curve.
Curves are very important and used nowadays, including in many cryptocurrencies.

We initialize the KeyPairGenerator with the curve and a SecureRandom.

curve example: secp256r1 - The number is the key size.
Temos uma tabela das correspondencias nos slides. 256 é equivalente a ter RSA com 3072 bits. Para o mesmo nível de segurança, precisamos de chaves muito mais pequenas.

Then we generate the key pair. - This is the public and private key.

Then we can initialize the Cipher to encrypt with the public key. and then we .doFinal with that cipher.

To decrypt we initialize the Cipher with the private key and then we .doFinal with that cipher.

O que é ECIES: é uma primitiva, que gera uma chave com AES, e depois encripta essa chave com a chave pública do destinatário. Depois encripta a mensagem com a chave do AES.

é uma primitiva de mais alto nível, que já faz tudo por nós.


ECDSA - Sign Messages with eliptic curves.

Eliptic Curves: Curves seigned by cubic equations. In general, cubic equations for eliptic curves take the following form, known as a weierstrass equation:

y^2 + axy + by = x^3 + cx^2 + dx + e

The curve is defined by the values of a, b, c, d and e.

---

Para somar dois pontos numa curva, temos que calcular a tangente à curva que passa por esses dois pontos.

Para subtrair, é o mesmo que somar o ponto inverso.

O caso especial quando temos p+p quando a tangente é uma linha vertical, trata-se de fazer uma tangente com um ponto no infinito.

---

Scalar Multiplications: Multiplicar um ponto por um escalar, é somar esse ponto consigo mesmo n vezes.

# PA#1

## Project Context

- Primitives and Crypto methods, algs and constructions
  - Sym Crypto
  - Secure Hashing
  - MAC Constructions
- Combination in Hybrid Constructions

## Notes

Peer -> UDP Connection -> Peer

What we want to provide first is connectionless confidentiality because we're delivering packets on UDP - SE (Symmetric Encryption) is the way to go.
Connectionless Integrity - HASH

**Ek1(M) || H(M)**

**Ek1(M) || H(c)** - This is wrong, because the attacker has access to the ciphertext, and he can change the ciphertext and the hash, and the receiver will not be able to detect the change.

Is better to use **Ek1(M) || MACk2(M)**

**Ek1(M) || MACk2(M)** - This is better, because the attacker can't change the ciphertext and the MAC, because he doesn't know the key.

App Protocol:
TLS - Transport Security Layer
UDP

For the first work assignment, we will use the following:

- o codigo seja "modular" em termos de padding e mode, isto vai num configuration file. DEVE SER PARAMETERIZADO ATÉ NO TIPO DE CIFRA, DEVE SER POSSÍVEL USAR STREAM CIPHER. 

- A chave pode ficar em KeyStores do java, ou num config file tbm.
- Podemos usar os utils dele.

AEAD - Authenticated Encryption with Associated Data

Diferença para stream Ciphers 

- Usar SecureRandom em vez de Random. random = new SecureRandom();
- Gerar um IV com base no SecureRandom. ivSpec = Utils.createCtrIvForAES(1, random);
- key = Utils.createKeyForAES(256, random);

keyed hash construction - MAC

hMacKey = New SecretKeySpec(key.getEncoded(), "HmacSHA256");

cMAC - is more expensive than hMAC because it uses a block cipher. it's the exact same code but we put cMAC instead of hMAC.

AEAD é mais interessante quando queremos ter a mesma confidencialidade e autenticidade, sem ter de meter um MAC à parte.
AEAD stands for Authenticated Encryption with Associated Data.

- Gcm parameters, we need to pass the IV and the AAD (Additional Authenticated Data) to the GCMParameterSpec.
- GCMParameterSpec gcmParams = new GCMParameterSpec(128, iv);
- A diferença da cipher text para o plain text usando o GCM é SEMPRE 16 bytes. Porque aqui ele mete authenticity e integrity check.
- é o unico modo que pode ser utilizado a usar TLS 1.3
- Temos de aprender a usar outros modos porque IoT ou mobile ou outro tipo de devices podem não suportar GCM.

java -cp .:jar bcprov-jdk18on-1.78.1.jar AESGCM aaa. - ASSIM instala-se Bouncy Castel
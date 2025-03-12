# Prática 2: Usando Blobs

Criar uma Storage Account e um Blob Container no Azure.

REESCREVER O CÓDIGO DA AULA PASSADA PARA USAR BLOBS. 
Não usar o código do lab-2, só para referência.

3º objetivo - mudar o código do Tukano para usar Azure

## como fazer o 1º Passo

- Login na azure
- Deploy a aplicação web (do lab 1)
- Vir a storage accounts e create
  - O nome é unico
- What are you using this for? - other.
- NÃO TER DATA PROTECTION (para poupar dinheiro, em real life nós queremos isso)
- Já temos a account vamos criar o container
- Blob annonymous access - enabled (for debugging purposes) (permite aceder por browser e não só pela aplicação)
- Criar um blob container - images
- Ganhamos um código do URL.

## como fazer o 2º Passo

- Acrescentar as dependencias do Maven
- Create client to blob storage.
- NUNCA meter a connectionString diretamente no código (exceto neste lab)
- (a string está em security and network -> Access keys, copiar a connection string)
- Criar o containerClient definindo o ContainerName (que é images)
- um blocClient precisa de um filename para associar ao blob (hash do conteudo da imagem)
- No lab não vamos fazer upload da imagem de um file, mas vamos receber diretamente do user. (instead of .fromFile, use .fromBytes)
- dar upload do seu content para o storage
- Depois vamos fazer download do blob (.downloadContent().toBytes())

## como fazer o 3º Passo

- Converter o Tukano para usaar azure.
- Mudar o código de Tukano (app antiga e disponibilizada) para usar o Azure.


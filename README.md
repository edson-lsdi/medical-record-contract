
## How to run

- Execute dentro `test-network`

```
./network.sh up createChannel -ca -s couchdb
```

```
./network.sh deployCC -ccn medical -ccp caminho_ate_o_contrato/medicalRecord/ -ccl java
```

## Create credentials
- Inicie a rede
- Entre dentro do container

```
docker exec -it ca_org1 bash
```

- Execute os comandos do arquivo

[CreateIdentities.sh](createIdentities.sh)

- Execute o comando para pode acessar a credenciais localmente

```
chmod -R 777 /etc/hyperledger/fabric-ca-server/fabric-ca
```

- Caminho das credencias localmente
```
test-network/organizations/fabric-ca/org1/fabric-ca/clients
```

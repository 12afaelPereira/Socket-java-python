# Socket-java-python
Comunicação simples entre cliente (java) e servidor (python) feita em socket para a disciplina de Redes de Computadores.

---
### Sobre

**O cliente envia um dado, servidor trata esse dado e reenvia para o cliente.**

- Se o dado for uma string numérica, o servidor incrementa o valor e retorna ao cliente.

- Se o dado for uma string de tamanho 1, o servidor verifica se é uppercase ou lowercase e inverte a caixa e retorna ao cliente.

- Se o dado for uma string não numérica e de tamanho > 1, o servidor inverte a string e retorna ao cliente.

---
### Funcionamento

É necessário colocar o ip do host na variável ```HOST = ''``` do servidor.

Para executar o servidor, basta digitar na linha de comando (cmd)
```python Server porta```

Ao executar o cliente, antes compilar o arquivo .java
```javac Client.java```

Agora executando
```java Client host_do_servidor porta```


---
### Compatibilidade

 - Para executar o servidor foi usado o python 2.7.15

 - Para executar o cliente foi usado o java 8

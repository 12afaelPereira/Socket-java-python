# Socket-java-python
A sample socket communication between client (java) and server(python) made for Computer Networks class.


---
### About

**The client send a data, the server process it and resend it to the client.**

- If the data is a numeric String, the server increment this value and resend to the client.

- If the data is a String whith the lenght equals one, the server check if it is upper or lowercase and invert it.

- If the data is a non numeric String and it has length greather than one, the server reverse the string and resend to the client.

---
### Running

It needs to put the host ip on the server ```HOST = ''``` variable.

To run the server, you need to type on the cmd
```python Server port```

You need compile the .java file before run the client. For that, just need to type on cmd
```javac Client.java```

To run the client, you need to type on the cmd
```java Client server_host port```


---
### Compatibility

 - To run the server i've used python 2.7.15

 - To run the client i've used java 8


import sys
import socket

# Host
HOST = ''
# Porta
PORT = int(sys.argv[1])

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

orig = (HOST, PORT)
server.bind(orig)
server.listen(1)
print 'Ouvindo...\n'

conection, cliente = server.accept()
print 'Concetado por', cliente

# Recebendo mensagem do cliente
msg = conection.recv(1024)

print 'Mensagem recebida: ', msg.decode("utf-8")

# Verifica se a string eh numerica
if unicode(msg, 'utf-8').isnumeric():
	msg = int(msg) + 1
	msg = str(msg)

# Verifica se eh caracter maiusculo
elif len(msg) == 1 and unicode(msg, 'utf-8').isupper():
	msg = msg.lower()

# Verifica se eh caracter minusculo
elif len(msg) == 1 and unicode(msg, 'utf-8').islower():
	msg = msg.upper()

else:
	# Inverte string
	msg = msg[::-1]

# Enviando mensagem para o cliente
conection.send(msg.encode("utf-8"))

conection.shutdown(socket.SHUT_RDWR)
conection.close()
print 'Conexao com o cliente ', cliente, ' finalizada'

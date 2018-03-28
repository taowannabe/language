#-*-coding:utf8-*-

from socket import *
from time import ctime

HOST = ''
PORT = 12345
BUFSIZE = 1024
ADDR = (HOST,PORT)

tcpSerSock = socket(AF_INET,SOCK_STREAM)
tcpSerSock.bind(ADDR)
tcpSerSock.listen(5)

while True:
    print('warting for connection')
    tcpCliSock,addr = tcpSerSock._accept()
    print('conecting from '+addr)
    while True:
        data = tcpCliSock.recv(BUFSIZE)
        if not data:
            break
        tcpCliSock.send('[%s] %s'%(bytes(ctime(),'utf-8'),data))
    tcpCliSock.close()
tcpSerSock.close()


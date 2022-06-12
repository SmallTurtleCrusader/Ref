import socket

hostname = input("Please enter website link: (facebook.com , youtube.com, etc...)\n")

#IP from link
print(f"The {hostname} IP address is {socket.gethostbyname(hostname)}")
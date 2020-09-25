# CS5700 Project1
# How To Run Project
1. Fisrt you should run make to compile the code.
2. Then you could run client: ./client <-p port> <-s> [hostname] [NEU ID]
The -p port parameter is optional; it specifies the TCP port that the server is listening on. If this parameter is not supplied on the command line, assume the port is 27995. The -s flag is optional; if given, the client should use an SSL encrypted socket connection. Your client only needs to support -s if you are trying to get the extra credit points. The [hostname] parameter is required, and specifies the name of the server (either a DNS name or an IP address in dotted notation). The [NEU ID] parameter is required. Your code must support NEU IDs that have leading zeroes (do not strip them!).

# High-level Approach
In this project, I use the java socket library to implement a client. it can receive the message from server and solve the questions that server given.

# Challenges
About the ssl connection, I tried to figure out what is ssl and how to implement the ssl connection, it took me a long time.

# Code Test
test the command line
test case: 
1. ./client cs5700fa20.ccs.neu.edu 001401945
2. ./client -p 27995 cs5700fa20.ccs.neu.edu 001401945
3. ./client -s cs5700fa20.ccs.neu.edu 001401945
4. ./client -p 27996 -s cs5700fa20.ccs.neu.edu 001401945
5.Wrong hostname:   ./client cs5700fa20.ccs.neu 001401945
6.Wrong NUID:       ./client cs5700fa20.ccs.neu.edu 00





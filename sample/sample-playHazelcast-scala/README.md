PlayHazelcast Demo Application
=====================================

In order to launch this sample app go to the app root folder

Open 2 terms

In the first one :
	
	> play run
	
	
In the second one : 

	> play run -Dhz.port=5701 9001

go to your browser at the following URLs :

[http://localhost:9000](http://localhost:9000)
	
[http://localhost:9001](http://localhost:9001)

you will see the cluster member list

	instances : [Member [192.168.0.11]:5705, Member [192.168.0.11]:5701 this]
	


That's all

Fred
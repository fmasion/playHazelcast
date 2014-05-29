PlayHazelcast
=============

playframework 2.3.x hazelcast integration plugin

# HazelCast 3.2.1 Plugin for Play 2.3.x

For play 2.2.x see in play2.2.x branch

This is a set **of 2 plugins** that provide basic [Hazelcast](http://http://www.hazelcast.com/)  integration in Play!.

* **HazelcastPlugin**
* **HazelcastClientPlugin**

It is packaged with Hazelcast 3.2 community edition [licenced under Apache 2 licence](http://www.hazelcast.com/downloads.jsp)


# Features

###HazelcastPlugin

In fact this first plugin only binds an Hazelcast instance lifecycle to play application's one and exposes the Hazelcast instance : do WTFYW with it.
It starts an instance with play and stop it with play (stopping one play instance doesn't stop the cluster)

It includes :

* Hazelcast.jar
* Hazelcast-cloud.jar

So it only enables to start an Hazelcast instance on your own servers as well as all needed to start it on AWS.

###HazelcastClientPlugin

This second plugin only provides (and configure the connection of) an Hazelcast-client to handle an Hazelcast cluster through one of it's member. 

The hazelcast instance you manipulate with the client is not necessarily initiated by play (it could be an existing Hazelcast cluster your app is joining)

It includes :

* Hazelcast.jar
* Hazelcast-client.jar

So it only enables your app to connect an existing Hazelcast instance

### Used Together

You can use them together but they are not tied

### Reasons

This very basic integration is done intentionally. Hazelcast is very feature rich and it belongs to other upcomings plugins to extend Play in a particular way by using this very simple plugin if needed.

Moreover this upcoming services should use the [**Hazelcast-client library**](http://mvnrepository.com/artifact/com.hazelcast/hazelcast-client/2.6.6) in order to be able to interact with any Hazelcast cluster (not only the one tied to play). 

Imagine you want to write an open source monitoring tool for Hazelcast with play framework* It would be nice to monitor any Hazelcast cluster not only the one your app creates 


   *(there's a monitoring tool provided for free but limited to 2 instances without subscribtion fee and it's a war so you'll need a container)*


Consider using this plugin for :

* **simple cluster management** (make your play app cluster aware)
* **share and sync data between all machines in your cluster** (in a replicated, fail-safe and **observable** way)
* **cluster based scheduler** (coming soon stay tuned...)
* cluster wide cache replacement for ehcache ([memcached interface](http://www.hazelcast.org/docs/latest/manual/html-single/hazelcast-documentation.html#memcache-client)) or using **[playHazelCache plugin](https://github.com/fmasion/playHazelCache)**
* distributed ORM 2nd level cache ([could fit especially well with hibernate](http://www.hazelcast.org/docs/latest/manual/html-single/hazelcast-documentation.html#hibernate-second-level-cache))
* in memory [grid computation](http://www.hazelcast.org/docs/latest/manual/html-single/hazelcast-documentation.html#distributed-computing) (making wrappers on executors to enable a cluster wide monadic way to express fuctionnal operation…would be cool)
* easy cluster wide [pub/sub](http://www.hazelcast.org/docs/latest/manual/html-single/hazelcast-documentation.html#topic) (despite there's some nice tools already in play)
* [much more up to you…](http://lmgtfy.com/?q=buzz+lightyear+%22to%2Binfinity%2Band%2Bbeyond%22)

I don't encourage you to build statefull apps, but they're some use cases where you need your data be accessible from every some/machine in the cluster. With Hazelcast you **may not** need to deploy a specific middleware (memcached, redis, Hbase, Infinyspan …) that can certainly do much more than you'll need.
 
It's not a **golden Hammer** put it in your stack after prototyping and evaluating if it fits your need.

As usual this comes without any warranty of any kind.


# How to install


In your application, add this configuration to the `project/Build.scala` file :


add this resolver (same for both plugins) :

	resolvers += Resolver.url("Fred's GitHub Play Repository", url("http://fmasion.github.com/releases23x/"))(Resolver.ivyStylePatterns)

`for play 2.2.x use : "http://fmasion.github.com/releases/"`

choose your dependency :

	"playHazelcast"  % "playHazelcast_2.10" % "3.2.1"
and / or 

	"playHazelcastClient"  % "playHazelcastClient_2.10" % "3.2.1"


In your application, add to `conf/play.plugins` (or create the file if it dosn't exist) this configuration :

	500:playHazelcast.HazelcastPlugin
and / or
	
	600:playHazelcastClient.api.HazelcastClientPlugin

The first number is a priority, you can adjust it if you have other plugins which depend on the one in this case when used jointly the client plugin must start after

Finally in the `conf/application.conf` you can configure some elements. Theses elements overide the default config.
If You provide a conf file it is first used then the keys in the `application.conf` are applied to overide those defined in the conf file.

	hz.port=5701
	# hz.configfile="conf/config.xml"
	
	# defining group enables multiple hz instances on the same server
	# so the same machine can participate to many cluster
	# Also there are other product that use hazelcast internaly so it provides connection to annother cluster
	# hz.groupname="dev"
	# hz.grouppassword="dev-pass"
	
	# hazelcast tries to connect and increment ports trying to find other machine on the lan
	# it makes easy the use of multiple server on the same machine
	# hz.portautoincrement=true
	
	# No licenceKey is required for community edition
	# hz.licenceKey="XXXXXXXXX"
		
	# for hazelcastClient you configure a list of seeds (some of the member to contact if present)
	# the first seed that respond enables the connection
	# by default addMembershipListener will keep members up to date 
	# so connection to the cluster won't go down if the connected member fails 
	hz.addresses = [127.0.0.1:5701]

No licenceKey is required for community edition.
It's just if you use enterprise edition (adds jaas base security/credentials, out of heap datastorage, non limited monitoring, C# client, )

If no config.xml file is provided the app lauches with Hazelcast defaults.
To know how to configure hazelcast (in particulary in EC2) [RTFM](http://www.hazelcast.com/docs.jsp)

  
# Usage

Simply access the Hazelcast instance (in Scala or Java) : 

	HazelcastPlugin.getInstance();
	
and / or

	HazelcastClientPlugin.getClient();

# Sample

For an example, see the bundled sample app


## Licence

This software is licensed under the Apache 2 license, quoted below.

Copyright 2013 F. Masion.

Licensed under the Apache License, Version 2.0 (the "License"); you may not use this project except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0.

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

blah blah blaahhh

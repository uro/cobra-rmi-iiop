# PhoneBook Java RMI-IIOP 
 
### About RMI-IIOP

**RMI-IIOP** (read as "RMI over IIOP") denotes the **Java Remote Method Invocation** (RMI) interface over the **Internet Inter-Orb Protocol** (IIOP), which delivers **Common Object Request Broker Architecture (CORBA)** distributed computing capabilities to the Java platform. 

More info : [Wikipedia](https://en.wikipedia.org/wiki/RMI-IIOP)



### Building

1. Compile project files
2. Go to `bin/` directory and run `rmic -iiop zad1.PhoneDirectory` command to generate exportObjects stubs
3. Define JNDI configuration presented below using `jndi.properties` file or in JVM settings
   ```
   java.naming.factory.initial=com.sun.jndi.cosnaming.CNCtxFactory
   java.naming.provider.url=iiop://{hostName}:{port} // eg. localhost:3333
   ```
   Configuration should be placed in your `bin/` directory
   
### Running 

1. Start COS naming ORB server with command `orbd -ORBInitialPort {portNumber}` from your `bin/` directory
3. Run server and client with JNDI configuration (There's client GUI too...)
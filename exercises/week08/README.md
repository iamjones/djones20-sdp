1.
* The strategy design pattern basically means you can change the behaviour of a class
or method at run time. The advantage of this is you will not be adding code to superclasses
 that will not be used by call subclasses. This also means changes can be made without affecting
 the strategy types. This is also known at decoupling.
 
* It is appropriate to use the strategy pattern when you need a class that can change its behaviour
 at run time. For example if you are using code to generate some HTML you would have a  
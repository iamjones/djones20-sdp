1.
* The strategy design pattern basically means you can change the behaviour of a class
or method at run time. The advantage of this is you will not be adding code to superclasses
 that will not be used by call subclasses. This also means changes can be made without affecting
 the strategy types. This is also known at decoupling.
 
* It is appropriate to use the strategy pattern when you need a class that can change its behaviour
 at run time.
  
3.
* It is appropriate to use the abstract factory pattern when you want the flexibility of 
changing or adding many objects during runtime. For example you might have a many implementations
of a car and a car could have different types of wheels, engine and body work. Using the abstract
factory design pattern means you could have many classes that build different types of cars
and each car can have a different configuration so a factory is need to build each individual car.
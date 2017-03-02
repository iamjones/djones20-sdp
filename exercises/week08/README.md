1.
* The strategy design pattern basically means you can change the behaviour of a class
or method at run time. The advantage of this is you will not be adding code to superclasses
 that will not be used by call subclasses. This also means changes can be made without affecting
 the strategy types. This is also known at decoupling.
 
* It is appropriate to use the strategy pattern when you need a class that can change its behaviour
 at run time.
  
3. It is appropriate to use the abstract factory pattern when you want the flexibility of 
changing or adding many objects during runtime. For example you might have a many implementations
of a car and a car could have different types of wheels, engine and body work. Using the abstract
factory design pattern means you could have many classes that build different types of cars
and each car can have a different configuration so a factory is need to build each individual car.

5. They could be part of the controller, whether instantiated inside the controller or
injected as dependencies. This could lead to constructor bloat, especially if the construct
has other things to do other than organise the objects components. The composition objects
could be assigned to the object at runtime using a setter if there needs to be some
flexibility.

7. 
* The facade pattern basically abstracts many method calls into one method.
*. You would use the facade pattern when you want to hide some implementation that a 
piece of code does not need to know about. For example if a method makes a call to another
method called withdrawMoney, it doesnt need to know that the withdraw money method actually
makes calls to the methods validateAccount, checkFundAvailable and withdraw. This helps to
keep code clean.

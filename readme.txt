CODE MODEL MAPPING FRAMEWORK


Site available here http://codemodelmapper.sourceforge.net/

Codemodel Mapper Framework is Java framework that allows generate bridges between models.
Typical use case is following.
For example in you project you need to interact with 3d-part systems - invoke legacy 
systems or expose web-services. But your internal model (based on POJO files or Java 
Beans) is not fit to external API or designed web service API. 
In this case you need to copy data from one model to another. You can create "copy" 
code from scratch or use reflection-based mappers, like Dozer. General problem with 
reflection-based mappers (they are usially force you to create mapping rules 
in Excel or plain text/XML files) is problems on development stage. You have to debug
 you rules on runtime. "Misprint" mistakes will occur after deply/test process. It is 
 not problem for small application. But takes long time for big enterprise application.

Codemodel Mapper Framework works in different way. You create mapping rules right in 
java code with Java Annotations. Then Codemodel Mapper will generate Java mapper class.
This class contains specific mapping code. So, you will see "misprint" mistakes right 
on compile time. And, definitely, native java code works much more faster then reflection.

License http://codemodelmapper.sourceforge.net/license.html


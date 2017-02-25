# Thymeleaf Templates working with Project Lombok
This is a Showcase for a Thymeleaf Template working with a Project-Lombok annotated Bean.

## How it works
The Lombok-annotated Class ``io.github.mufasa1976.Greeting`` has 2 Attributes: ``name`` and ``age``.
A new Instance of this Class will be served by the Controller ``io.github.mufasa1976.Application``.

Then you will get a HTML with 2 Inputfields for Name and Age. This Form will be submitted via a POST-Request
to the same URL.

## How to start
After the Build with ``mvn install`` you can start this Application simply with ``java -jar target/thymeleaf-lombok.jar``

**IoT Services Reference Application**
==================
The example IoT Services Reference application implements a number of REST API's that support the [IoT Services Reference](https://github.com/markreha/cloudservices/blob/master/README.md) application and [IoT Device Raspberry Pi Sense HAT](https://github.com/markreha/cloudpi/blob/master/README.md) application, which in combination demonstrate a simple, scalable, Cloud based IoT application. Get the [Cloud Workshop SDK!](https://github.com/markreha/cloudworkshop/blob/master/README.md)

<p align="center">
	<img src="https://github.com/markreha/cloudworkshop/raw/master/sdk/docs/architecture/images/iotservices.png" alt="IoT Services Logical Architecture"/>
</p>

Architecture & Technologies
--------
The IoT Services Reference application is designed and implemented in Java using the Spring Framework (Spring Core and Spring JDBC) that implements its published REST API's based on the JAX-RS framework using the Jackson and Jersey implementation libraries.

The JavaDoc for the entire application can be found [here](https://htmlpreview.github.io/?https://github.com/markreha/cloudworkshop/blob/master/sdk/docs/javadoc/overview-summary.html)

REST API's
--------
The IoT Services Reference application publishes 3 API's, one of which is an API used for testing and the remaining 2 API's to save and retrieve IoT Weather Data. It should be noted that the REST endpoint is secured by using HTTPS and Basic HTTP Authentication. All REST API's are based off of the [hostname]/cloudservices/weather URL.

![IoT Services UML Diagram](https://github.com/markreha/cloudworkshop/raw/master/sdk/docs/architecture/images/iotrestservice.png)

The REST API's include:

 - GET at /test: will return a test string and is used to test the endpoint
 - GET at /get: will return IoT Weather data for a specified Device ID, From Date, and End Date
 - POST at /save: will save IoT Weather data from the a specified WeatherSensorModel

The REST API's are published using the Swagger API [here](https://markreha.github.io/cloudworkshop/sdk/docs/swagger/site/index.html) and [here](https://markreha.github.io/cloudworkshop/sdk/docs/swagger/index.html).

Building
--------
The instructions for building the IoT Services Reference application can be found [here](https://github.com/markreha/cloudworkshop/blob/master/sdk/docs/development/README.md).

DevOps
--------
The instructions for supporting DevOps in the IoT Services Reference application can be found [here](https://github.com/markreha/cloudworkshop/blob/master/sdk/docs/devops/README.md).



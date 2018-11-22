# Spring Boot Service with JAX-B


# Requirements
•	Java 1.8 or newer



# The application implements a single service with two ports, located at:

http://localhost:8080/getAll       METHOD -> POST

RequestBody : 

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="http://spring.io/guides/gs-producing-web-service">
   <soapenv:Header/>
   <soapenv:Body>
      <sch:PrototypeRequestAll>
      </sch:PrototypeRequestAll>
   </soapenv:Body>
</soapenv:Envelope>

-----------------------------------------------
http://localhost:8080/getValueByKey?wsdl    METHOD -> POST

RequestBody :

<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:sch="http://spring.io/guides/gs-producing-web-service">
   <soapenv:Header/>
   <soapenv:Body>
      <sch:PrototypeRequest>
         <sch:name>key3</sch:name>
      </sch:PrototypeRequest>
   </soapenv:Body>
</soapenv:Envelope>





# How to deploy the Project at local

Just Run it on Intejjil IDE

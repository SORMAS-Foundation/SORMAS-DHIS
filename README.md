# Project SORMAS-DHIS2
## Introduction
District Health Information Software 2 (DHIS2- https://www.dhis2.org) is a flexible, free and open-source, web-based software platform that enables efficient collection, analysis, management, storage, visualization and distribution of data. By using this health information system, governments and health organizations are able to effectively monitor processes, manage their operations and improve communication. Features of DHIS2 include interfaces to other software platforms, advanced data visualization capabilities, individual data sets, the ability to use the software offline and on mobile devices, translation into multiple languages, and the ability to have thousands of users on a server. This makes DHIS2 the preferred national health information system in about sixty countries. SORMAS® is a mobile eHealth (monitoring, disease control, management and analysis) system aimed to improve the prevention and control of communicable diseases, especially in resource-poor environments. The system is being developed by those involved in the surveillance of public health and disease control. SORMAS® is free and complies with the highest data protection standards, good scientific practice and open access policy. 

## Project Objectives
DHIS2 has been adopted by more than 60 African countries as a National Health Information System. All relevant data should be stored and managed on this system. DHIS2 can receive, store and share data from various data sources to other systems and reporting platforms. DHIS2 can exchange data with other software applications and platforms. This interoperability enables collaboration with various software platforms and the integration of data sources from other applications. SORMAS and DHIS2 will be connected to provide a data exchange between these systems. The purpose of data exchange is to improve the control and management of infectious diseases and to allow timely initiation of disease control. The goal of this software project is to create a dynamic, custom API that is specifically designed to transfer data between SORMAS and DHIS2. 


## Build from sources

SORMAS DHIS2 ADAPTER is a java web application program built on simple java logics and algorithm. The best way to get up and running is to download the released war file and deploy it in a web container. However, if you would like to make some changes, follow the following steps.

1. Clone this repository 
    ```
    $ git clone https://github.com/hzi-braunschweig/SORMAS-DHIS.git
    ```
2. Install Maven if not already installed
    ```
    $ sudo apt-get install maven
    ```
3. Navigate to the adapter source directory and package the application
    ```
    $ cd SORMAS-DHIS/sormas_HL7v2
    ```
    ```
    $ mvn package
    ```
    The above action will download all required dependencies and package the application in a war file. If this is successful it would create a sormas_HL7v2-{version}.war

### Installing the application
  1. Download and install Java and MySql server
  
      ```
      $ sudo apt-get install openjdk-9-jdk
      ``` 
      ```
      $ sudo apt-get install mysql-server
      ``` 
      ```
      $ sudo mysql
      ```
      ```
      $ create database {adapter database name}
      ``` 
      ```
      $ CREATE USER 'username'@'localhost' IDENTIFIED WITH authentication_plugin BY 'password';
      ``` 
      ```
      $ GRANT ALL ON database.table TO 'username'@'localhost';
      ``` 
     
  2. Verify java is correctly installed 
      ```
      $ java -version`
      ```
      
  3. Install Tomcat 9 
      ```
      $ sudo apt-get install tomcat9
      ```
      
  4. Deploy the adapter into Tomcat container 
      ```
      $ sudo -r tomcat:tomcat {adapter war file location}/*.war
      ```
      ```
      $ cp {adapter war file location}/*.war /var/lib/tomcat9/webapps/adapter.war
      ```
      
  5. Install the adapter schema
      ```
      $ sudo mysql {adapter database name} < {adapter source directory}/sormas_adapter.sql
      ```
      
  6. Adapter should now be accessible at 
      ```
      $ localhost:8080/adapter
      ```
      
      ## Project Management

### ZenHub
We are using the ZenHub-Plugin to track progess on this project. You can get the Plugin here: https://github.com/marketplace/zenhub. In the bottom of the page select the free pricing plan and install the app and the browser plugin according to the installation guide. 
ZenHub browser extension can be downloaded here: https://www.zenhub.com/extension

 

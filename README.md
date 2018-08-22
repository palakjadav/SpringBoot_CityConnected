**Coding Exercise**

You’re asked to write a program in Java 8 which determines if two cities are connected.

Two cities are considered connected if there’s a series of roads that can be traveled from one city to another.

 

List of roads is available in a file.

File contains a list of city pairs (one pair per line, comma separated), which indicates that there’s a road between those cities.

 

It will be deployed as a spring-boot app and expose one endpoint:

http://localhost:8080/connected?origin=city1&destination=city2

 

Your program should respond with ‘yes’ if city1 is connected to city2, ’no’ if city1 is not connected to city2.

Any unexpected input should result in a ’no’ response.

 

Example:

city.txt content is:

Boston, New York

Philadelphia, Newark

Newark, Boston

Trenton, Albany

 

http://localhost:8080/connected?origin=Boston&destination=Newark

Should return yes

http://localhost:8080/connected?origin=Boston&destination=Philadelphia

Should return yes

http://localhost:8080/connected?origin=Philadelphia&destination=Albany

Should return no


**How to Execute**


Prerequisites:
Java 8
Maven
Git

Steps:
1. Create a new directory mkdir application

2. Navigate to the new directory cd application

3. clone GitHub repository by running the following git command:

4. git clone https://github.com/palakjadav/SpringBoot_CityConnected

5. cd SpringBoot_CityConnected

6. Open the project in IDE and run as Java Application

7. Open the browser and go to http://localhost:8080/connected?origin=Boston&destination=Newark (Will display : Yes)
http://localhost:8080/connected?origin=Boston&destination=Philadelphia (Will display : Yes)
http://localhost:8080/connected?origin=Philadelphia&destination=Albany (Will display : No)

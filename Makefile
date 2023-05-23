deploy:
	sudo docker-compose up
startdb:
	cd ./db && sudo docker-compose up
spring:
	cd ./server && ./mvnw spring-boot:run
startgui:
	cd ./client && mvn clean javafx:run

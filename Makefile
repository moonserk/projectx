run:
	sudo docker-compose up
run_detach:
	sudo docker-compose up -d
run_db:
	cd ./db && sudo docker-compose up
run_server:
	cd ./server && ./mvnw spring-boot:run
run_client:
	cd ./client && mvn clean javafx:run

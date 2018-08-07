.PHONY: build run

build: 
	mvn compile assembly:single

run: 
	java -jar target/ld-demo-java-1.0-SNAPSHOT-jar-with-dependencies.jar
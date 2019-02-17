# paragraph-parser
Sample project for parsing paragraphs.

Tests can be found at:
`src/test/java/com/paragraphparser/service/ParserServiceTest.java`

# Run with gradle wrapper:
1. `./gradlew build`
2. `./gradlew bootrun -Pargs=paragraph.txt`

# Run with Jar
1. `./gradlew build`
2. `java -jar build/libs/paragraph-parser.jar paragraph.txt`

# Run Tests
`./gradlew test`
# paragraph-parser
Sample project for parsing paragraphs.

Tests can be found at:
`src/test/java/com/paragraphparser/service/ParserServiceTest.java`

# Algorithm Complexity
Currently uses a counting sort algorithm to count the frequency of
each letter with one loop through the paragraph (size N). To create the sorted
output, another loop through the range of the character set (size K) is needed.
- Best Case Scenario is O(N+K)
- Worst Case Scenario is O(N+K)

# Run with gradle wrapper:
1. `./gradlew build`
2. `./gradlew bootrun -Pargs=paragraph.txt`

# Run with Jar
1. `./gradlew build`
2. `java -jar build/libs/paragraph-parser.jar paragraph.txt`

# Run Tests
`./gradlew test`

# API
1. `./gradlew bootrun`
2. Access via curl or Swagger UI
- `curl -X POST localhost:8080/parse -d "example" -H "Content-Type: text/plain"`
- `http://localhost:8080/swagger-ui.html`
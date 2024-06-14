Task : To Automate the Below Scenario.
Scenario :- All the users of City `FanCode` should have more than half of their todos task completed. Given User has the todo tasks
And User belongs to the city FanCode
Then User Completed task percentage should be greater than 50%
Note :-
- You can use any language to write api automation/Framework.
- Fancode City can be identified by lat between ( -40 to 5) and long between ( 5 to 100) in users api
Resources(APIs) :- http://jsonplaceholder.typicode.com/ /todos
/posts
/comments
/albums
 /photos
 /users

Build Tool used : Gradle
TechStack : Java, TestNG , RestAssured

<img width="1690" alt="image" src="https://github.com/fruity2409/FanCode_Assignment/assets/172627261/5f29fbe9-edd4-4093-b018-c4417200f5c8">


Command to build project : ./gradlew clean build
Command to run : ./gradlew test

Output Screenshot : <img width="1647" alt="image" src="https://github.com/fruity2409/FanCode_Assignment/assets/172627261/6f15d555-fdc3-42aa-8027-eff014adf0c5">


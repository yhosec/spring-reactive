#Spring Reactive
Learn build reactive application using springboot.

##Technology
* Spring webflux 2.4.3
* Postgres 11

##How To Run
```
mvn clean install
docker-compose up --build
```

##Load Stream Data Using Javascript
```
var evtSource = new EventSource("http://localhost:8087/inactive");
evtSource.onmessage = function (event) {
  var data = JSON.parse(event.data);
  console.log(data);
  if (data.id == 3) {
    evtSource.close();
  }
}
```

##How To Stop This Project
```
command + c / ctrl + c
docker-compose down
```
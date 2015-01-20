Test-Server (Woingenau Backend)
http://thawing-stream-9266.herokuapp.com/

${id} = 1 (zum Testen)

|   GET    | /courses                                        | Action: index            |
---------------------
Liefert - Liste (format unten):

|   GET    | /courses/${id} |Action: show|
--------------------------
Liefert ein Element

```json
{
  "id":1,
  "appointments":[
    {
      "id":1,
      "place":"Empire",
      "start":"2014-12-08T20:21:03Z",
      "end":"2014-12-08T20:21:03Z"
    }
  ],
  "creator":{
    "id":1
  },
  "lecturer":{
    "id":2
  },
  "members":[
    {
      "id":2
    },
    {
      "id":3
    },
    {
      "id":1
    }
  ],
  "title":"The Force 101"
}
```


|   POST   | /courses                                                  | Action: save             |
-----------
Benutzt:

```json
{
  "appointments":[
    {
      "place":"Earth",
      "start":"2014-12-08T20:21:03Z",
      "end":"2014-12-08T20:21:03Z"
    }
  ],
  "creator":{
    "id":1
  },
  "lecturer":{
    "id":2
  },
  "members":[
    {
      "id":2
    },
    {
      "id":3
    },
    {
      "id":1
    }
  ],
  "title":"The Force 101"
}
```

Speichert ein neuer Course in der DB
|   PUT    | /courses/${id}                                            | Action: update           |
-----------
```json
Updates nur :
{
  "creator":{
    "id":1
  },
  "lecturer":{
    "id":2
  },
  "title":"The Force 102"
}
```


|   GET    | /courses/${courseId}/members                              | Action: index            |
-----------
 ```json
[
  {
    "id":3,
    "username":"hans",
    "firstname":"hans",
    "lastname":"hodor",
    "enabled":true
  },
  {
    "id":1,
    "username":"jack",
    "firstname":"jack",
    "lastname":"bauer",
    "enabled":true
  },
  {
    "id":2,
    "username":"joda",
    "firstname":"joda",
    "lastname":"maier",
    "enabled":true
  }
]
```
enabled: true|false ist ob der user freigeschaltet ist. Sollte euch nicht interessieren

|   POST   | /courses/${courseId}/members                              | Action: save             |
-----------
Fügt ein neue User zum Course
```json
{
"id": 3
}
```

|  DELETE  | /courses/${courseId}/members |Action: delete|
--------
Analog zu save

Es gilt--> Action: save ist keine id notwendig, es wird generiert
---
# Url Shortener with Java Spring

## Kullanılan Dependency'ler

- Spring Web
- Spring Data JPA
- H2 Database
- Validation
- Lombok
- Deployin to Heroku

## Base URL: http://localhost:8080

- [GET]/: getAllUrls
- [GET]/{code}: redirectToUrl
- [GET]/show{code}: getUrlByCode
- [Post]/: createShortUrl

·domain.com/SHORT


## API Reference

- #### Get all urls

```http
  GET /all
```
#### Response:
```javascript
[
    {
        "id": 1,
        "url": "https://github.com/talharic",
        "code": "GIT"
    },
    {
        "id": 2,
        "url": "https://www.linkedin.com/in/talharic",
        "code": "IN"
    }
]
```
##

- #### Redirect

```http
  GET /{code}
```
You will be redirected to the URL of the code.

##

- #### Show Url of Code (alias)

```http
  GET /show/{code}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `code`      | `string` | **Required**. Code of url to fetch |

#### Response:
```javascript
{
    "id": 1,
    "url": "https://github.com/talharic",
    "code": "GIT"
}
```
##

- #### Create Short Url

```http
  POST /
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `url`      | `string` | **Required**. Code of url to fetch |
| `code`      | `string` | **Not Required**. If it is null or empty, it will be created automatically. |

#### Request:
```javascript
{
    "url": "https://github.com/talharic",
    "code": "g"
}
```

#### Response:
```javascript
{
    "id": 3,
    "url": "https://github.com/talharic",
    "code": "G"
}
```

## Installation


```bash
   git clone https://github.com/talharic/urlShortener.git

  cd talharicUrlShortener

  mvn spring-boot:run
```
    
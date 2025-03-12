# Aula prática 6

## Artillery

- What is Artillery? Artillery is a testing toolkit used to test an application's performance and resilency under load. It works with HTTP APIs, Websocket and socket.io services, or web applications.

artillery works with a .yaml file. This file has a configuration part, where you can define the target, the phases, and the scenarios. The target is the URL of the application you want to test. The phases are the number of users and the duration of the test. The scenarios are the requests that will be made to the application.

config:
    target: http://127.0.0.1:8080/tukano/rest
    phases: 
        name: simple_get
        duration: 1
        arrivalRate: 1

scenarios:
    - name: TukanoHome
    flow:
        - get:
            url: "/users/kghallagher?pwd=easypass"

guardar os dados que queremos parameterizar num csv.

in the config session, we do a payload:
    payload:
        path: ./data/users.csv
        order: sequence
        skipHeader: true
        delimiter: ","
        skipEmptyLines: true
        fields:
            - "userId"
            - "pwd"
            - "email"
            - "displayName"

insert the values like json: userId: "{{ userId }}", pwd: "{{ pwd }}", email: "{{ email }}", displayName: "{{ displayName }}"

Extend artillery using node.js in order to produce better test (random js helper function to generate usernames and passwords)

criar uma função que cria um request que gera um randomly generated user e password

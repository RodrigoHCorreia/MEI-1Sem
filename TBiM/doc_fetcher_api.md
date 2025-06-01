# Dynamic Fetching Scheduler — API Documentation

## Table of Contents

- [Dynamic Fetching Scheduler — API Documentation](#dynamic-fetching-scheduler--api-documentation)
  - [Table of Contents](#table-of-contents)
  - [Introduction](#introduction)
  - [Date and Time format](#date-and-time-format)
  - [API Endpoints](#api-endpoints)
    - [POST api/provider](#post-apiprovider)
    - [GET api/provider](#get-apiprovider)
    - [POST api/provider/{id}](#post-apiproviderid)
    - [DELETE api/provider/{id}](#delete-apiproviderid)
    - [GET api/providers](#get-apiproviders)
  - [Input Models](#input-models)
    - [Provider Input Model](#provider-input-model)
  - [Output Models](#output-models)
    - [Simple Message](#simple-message)
    - [Add Provider Output Model](#add-provider-output-model)
    - [Provider Output Model](#provider-output-model)
    - [Provider List Output Model](#provider-list-output-model)
  - [Error Handling](#error-handling)

## Introduction

This document outlines the API endpoints and how to interact with the Fetcher API.  
The Fetcher API is a REST API that allows users to add, update, remove, and query providers from the system. When a provider is added, the API will initiate a request to the provider's endpoint to determine whether it is active by checking if the response contains an `isActive` field set to `true`.
The API allows for providers that are either URL-based or script-based, and in addition to scheduling providers via a fixed frequency (using ISO-8601 duration format), the API allows users to specify a list of specific times (as LocalTimes in `HH:mm` format) at which the provider should be scheduled on a daily basis. This enhanced scheduling flexibility lets users define exact fetch times for each provider.

## Date and Time format

This API uses the [ISO-8601](https://en.wikipedia.org/wiki/ISO_8601#Durations) format for dates and durations.  
For specifying scheduling times, use the `HH:mm` format.

## API Endpoints

### POST api/provider

Adds a new provider.

- **URL:** `/api/provider`
- **Method:** `POST`
- **Request Body:**
    - **Required:**
        - [Provider Input Model](#provider-input-model)
- **Success Response:**
    - **Content:**
        - `application/json`
            - [Add Provider Output Model](#add-provider-output-model)
- **Error Response:**
    - **Content:**
        - `application/json`
            - [Bad Request](#bad-request)
- **Sample Call:**
    ```shell
    curl -X POST "http://localhost:8080/api/provider" \
         -H "Content-Type: application/json" \
         -d '{
               "name": "provider1",
               "requestType": "URL",
               "requestPath": "http://localhost:8080/provider1",
               "postProcessorPath": "/process/provider1",
               "specificTimes": ["08:00", "12:00", "16:00"],
               "isActive": true
             }'
    ```

### GET api/provider

Fetches a provider.

- **URL:** `/api/provider/{id}`
- **Method:** `GET`
- **Path Variables:**
    - `id` - The unique id of the provider.
- **Success Response:**
    - **Content:**
        - `application/json`
            - [Provider With Data Output Model](#provider-with-data-output-model)
- **Error Response:**
    - **Content:**
        - `application/json`
            - [Bad Request](#bad-request)
- **Sample Call:**
    ```shell
    curl -X GET "http://localhost:8080/api/provider/1"
    ```

### POST api/provider/{id}

Updates a provider if it exists.

- **URL:** `/api/provider/{id}`
- **Method:** `POST`
- **Path Variables:**
    - `id` - The unique id of the provider to be updated.
- **Request Body:**
    - **Required:**
        - [Provider Input Model](#provider-input-model)
- **Success Response:**
    - **Content:**
        - `application/json`
            - [Provider Output Model](#provider-output-model)
- **Error Response:**
    - **Content:**
        - `application/json`
            - [Bad Request](#bad-request)
- **Sample Call:**
    ```shell
    curl -X POST "http://localhost:8080/api/provider/1" \
         -H "Content-Type: application/json" \
         -d '{
               "name": "provider2",
               "requestType": "URL",
               "requestPath": "http://localhost:8080/provider2",
               "postProcessorPath": "/process/provider2",
               "specificTimes": ["09:00", "15:00"],
               "isActive": true
             }'
    ```

### DELETE api/provider/{id}

Deletes a provider.

- **URL:** `/api/provider/{id}`
- **Method:** `DELETE`
- **Path Variables:**
    - `id` - The unique id of the provider to be deleted.
- **Success Response:**
    - **Content:**
        - `application/json`
            - [Simple Message](#simple-message)
- **Error Response:**
    - **Content:**
        - `application/json`
            - [Bad Request](#bad-request)
- **Sample Call:**
    ```shell
    curl -X DELETE "http://localhost:8080/api/provider/1"
    ```

### GET api/providers

Fetches all providers.

- **URL:** `/api/providers`
- **Method:** `GET`
- **Success Response:**
    - **Content:**
        - `application/json`
            - [Provider List Output Model](#provider-list-output-model)
- **Error Response:**
    - **Content:**
        - `application/json`
            - [Bad Request](#bad-request)
- **Sample Call:**
    ```shell
    curl -X GET "http://localhost:8080/api/providers"
    ```

## Input Models

### Provider Input Model

- **Type:** `application/json`
- **Attributes:**
    - **Required:**
        - `name` - The name of the provider.
        - `requestType` - The type of request ("URL" or "SCRIPT")
        - `requestPath` - The URL or SCRIPT path from which data is fetched.
        - `postProcessorPath` - The path to the post-processor script or JAR.
        - `isActive` - The status of the provider.
    - **Optional (it must have one of them, but not both):**
        - `frequency` - The frequency at which data should be fetched from the provider, in ISO-8601 duration format (e.g., `"PT20S"`).
        - `specificTimes` - A list of specific times (in `HH:mm` format) on a daily basis when the provider should be scheduled for data fetching.
- **Example:**
    ```json
    {
      "name": "provider1",
      "requestType": "URL",
      "requestPath": "http://localhost:8080/provider1",
      "postProcessorPath": "/process/provider1",
      "specificTimes": ["08:00", "12:00", "16:00"],
      "isActive": true
    }
    ```

## Output Models

### Simple Message

- **Type:** `application/json`
- **Attributes:**
    - **Required:**
        - `message` - The message.
- **Example:**
    ```json
    {
      "message": "Provider with id: 123 deleted successfully."
    }
    ```

### Add Provider Output Model

- **Type:** `application/json`
- **Attributes:**
    - **Required:**
        - `id` - The unique id of the provider.
- **Example:**
    ```json
    {
      "id": 1
    }
    ```

### Provider Output Model

- **Type:** `application/json`
- **Attributes:**
    - **Required:**
        - `id` - The unique id of the provider.
        - `name` - The name of the provider.
         - `requestType` - The type of request ("URL" or "SCRIPT")
        - `requestPath` - The URL or SCRIPT path from which data is fetched.
        - `postProcessorPath` - The path to the post-processor script or JAR.
        - `frequency` - The frequency at which data is fetched (in ISO-8601 duration format).
        - `specificTimes` - A list of specific daily times (in `HH:mm` format) when the provider is scheduled (if provided).
        - `isActive` - The status of the provider.
- **Example:**
    ```json
    {
      "id": 1,
      "name": "provider1",
      "requestType": "URL",
      "requestPath": "http://localhost:8080/provider1",
      "postProcessorPath": "/process/provider1",
      "frequency": "PT20S",
      "specificTimes": ["08:00", "12:00", "16:00"],
      "isActive": true
    }
    ```

### Provider List Output Model

- **Type:** `application/json`
- **Attributes:**
    - **Required:**
        - `providers` - A list of [Provider Output Model](#provider-output-model) objects.
        - `size` - The number of providers in the list.
- **Example:**
    ```json
    {
      "providers": [
          {
              "id": 1,
              "name": "provider1",
              "requestType": "URL",
              "requestPath": "http://localhost:8080/provider1",
              "postProcessorPath": "/process/provider1",
              "frequency": "PT20S",
              "isActive": true
          },
          {
              "id": 2,
              "name": "provider2",
              "requestType": "SCRIPT",
              "requestPath": "/get/provider2",
              "postProcessorPath": "/process/provider2",
              "specificTimes": ["09:00", "15:00"],
              "isActive": true
          },
          {
              "id": 3,
              "name": "provider1",
              "requestType": "URL",
              "requestPath": "http://localhost:8080/provider1",
              "postProcessorPath": "/process/provider1",
              "specificTimes": ["08:00", "12:00", "16:00"],
              "isActive": false
          }
      ],
      "size": 3
    }
    ```

## Error Handling

Currently, the API only returns a `Bad Request` or `Not Found` error message, and no additional error handling is implemented.

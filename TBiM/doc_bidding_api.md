# Bidding System — API Documentation

## Table of Contents

- [Bidding System — API Documentation](#bidding-system--api-documentation)
  - [Table of Contents](#table-of-contents)
  - [Introduction](#introduction)
  - [API Endpoints](#api-endpoints)
    - [Bidding](#bidding)
      - [Get Bidding Information](#get-bidding-information)
  - [Request Logging](#request-logging)
  - [Error Handling](#error-handling)

## Introduction

The Bidding System API provides secure access to bidding information over HTTPS. Each request is authenticated via a token provided as a query parameter. The API uses the underlying `BiddingService` for data retrieval, and every request is logged and stored in a database. This logging mechanism records the date, status code, and response body of each request, enabling retrospective validation and analysis of past requests. This logging is implemented via a servlet filter, ensuring that even the data provided with each request is persistently stored.

## API Endpoints

### Bidding

This endpoint is responsible for retrieving bidding data from the system.

#### Get Bidding Information

- **URL:** `/prices`
- **Method:** `GET`
- **Query Parameters:**
  - `token` (required) - The token used for validating that the request comes from an authorized user.
- **Success Response:**
  - **HTTP Status:** `200 OK`
  - **Content-Type:** `application/json`
  - **Body:** Contains the bidding data as returned by the service.
    _Example Success Output:_
    ```json
    {
      "date": "2025-02-19"
      "price": 123.45,
      "period": 1
      
    }
    ```
- **Error Response:**
  - **HTTP Status:** `401 Bad Request`
  - **Content-Type:** `application/json`
  - **Body:** Contains an error message detailing the failure.
    - *Example Error Message:*
      ```json
      {
        "error": "Forbidden: Invalid Token"
      }
      ```
- **Sample Call:**
  ```shell
  curl -X GET "https://localhost:8080/prices?token=your_valid_token" -H "accept: application/json"
  ```

## Request Logging

Every request processed by the Bidding System API is logged into the database. The logging mechanism captures the following details:

- **Log Date:** The timestamp when the request was processed.
- **Status Code:** The HTTP status code of the response.
- **Response Body:** The content of the response, providing a record of the output delivered for each request.

This feature allows administrators and developers to access historical request logs for auditing, troubleshooting, and validation purposes.

## Error Handling

The controller returns a `400 Bad Request` response when:
- The bidding service fails to fetch the bidding data.

And a `401 Unauthorized` response when:
- The provided token is invalid or the user is not authorized.


All errors and successful responses are logged in the database to ensure that the system maintains a complete history of requests and their corresponding responses.

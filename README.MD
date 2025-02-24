# Prerequisites
You need to install Java 17+ JDK
# Installing and Running
To run the project, execute the following command:
```
./mvnw spring-boot:run
```

# Project structure
This project was created using Spring Initializr.
## Controllers
`GET /home` returns "hello :)" when accessed by an authenticated user. This route only requires the user to be logged in without any particular role.

`Any /product/**` endpoint can be accessed by an authenticated user with the `MANAGE_PRODUCT` role.


Examples:

  * `GET /product/1` returns the details of the product with `id:1`.
  * `PUT /product/1` with the body `{price: 120.0}` updates the price for product `1` and returns the updated product details.
## Error Handling
`GET /product/{productId}` throws a `ProductNotFoundException` if the given id doesn't exist in the datasource. 
This exception is handled by `ProductAdvice`, which responds with a `404` status and includes the error message in the body. 
## Authorization and Authentication

The project includes a configuration for web security in `SecurityConfig`. This class injects two beans for this purpose:

  * `securityFilterChain` Configures that any request requires authentication and, for `/product/**` endpoints, a special role is needed.
  * `userDetailsService` Creates an in-memory user details service, providing support for username/password-based authentication stored in memory. 

HTTP Basic authentication is enabled, which creates a `UsernamePasswordAuthenticationToken` extracted from the submitted `username` and `password` (from the `Authorization` header) and passes them to the default `AuthenticationManager`, which checks them against the given `UserDetailsService`.
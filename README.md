# Discover

1. Users will be able to view a list of all restaurants (50 per page) in a pre-defined geolocation.
2. Users will be able to see a restaurant details from the list.


# Architecture

1. MVVM architecture is implemented with option to add Cache with Room & SQLite later.
2. Principles:
    - Separation of concerns
    - Drive UI from a model
    - Each component depends only on the component one level below it
    - The repository is the only component that depends on multiple other components for retrieving data from different sources 

![Screen Shot 2021-04-07 at 10 31 40 AM](https://user-images.githubusercontent.com/82057356/113893303-7d663d00-978c-11eb-9d10-6e604d49dd51.png)

# Testing

1. JUnit 5 tests
2. Mockwebserver tests for APIs

# Libraries Used

1. Glide - get and show images
2. Retrofit - provides Java interface for REST API
3. Gson - de/serializes Java Objects into JSON and back
4. OkHttp MockWebServer - assists in testing Retrofit API

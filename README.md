## URL Shortener

URL Shortener project aimed at providing users with a convenient way to shorten long URLs into more manageable and shareable links. Built using Spring Boot and MySql.

### API Endpoints

#### GET /{short_uri}
Redirects to long url  

#### POST /shortURL
Accepts JSON : { "url" : "long url" }  
Returns short url

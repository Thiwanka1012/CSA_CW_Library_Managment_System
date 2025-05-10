# Library Managment System (CSA CW)
 
Description:

This repository contains the source code for the Westminster Bookstore API, developed for the 5COSC022W Client-Server Architectures coursework at the Informatics Institute of Technology, University of Westminster. The API is a RESTful service for managing a bookstore's resources, including books, authors, customers, carts, and orders. Key features include:

Endpoints: Supports CRUD operations for books, authors, customers, cart items, and orders (e.g., POST /books, GET /customers/{id}/orders).
Functionality: Allows creating, retrieving, updating, and deleting resources with proper validation and error handling.
Testing: Includes comprehensive testing with Postman, covering positive and negative test cases (see the report for details).
Documentation: A detailed report (w2053207_ThiwankaUmesh_5COSC022C.pdf) with test results and a demo video link is included.
Technologies: Built using Java with JAX-RS (javax.ws.rs), but uses third-party libraries (Jersey and Jackson) for JSON handling and server implementation. Note: Third-party libraries were used in this version, as their removal was not fully implemented before submission.
Status: Submitted for coursework evaluation. The project meets functional requirements, but compliance with the rule to avoid third-party libraries (e.g., Jackson, Jersey) is pending review.


How to Run:

Clone the repository: git clone <repository-url>.
Build the project using Maven: mvn clean install.
Deploy the WAR file to a servlet container (e.g., Apache Tomcat).
Access the API endpoints via Postman or a similar tool.
Note: Refer to the included PDF report for test results and the demo video link for a walkthrough of the API functionality.

Explanation
Removed Details: I’ve excluded your UOW ID (w2053207) and IIT ID (20231012) as requested, while keeping your name and group number for identification.
Clarity: The description remains simple and professional, explaining the project’s purpose, features, and current status.
Transparency: It acknowledges the use of third-party libraries (Jackson, Jersey) and notes that their removal wasn’t completed, which aligns with your submission status.
Usability: Includes instructions for running the project and references the report and demo video for further details.

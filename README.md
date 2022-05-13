inf124, PA #2
Programming Group 38
Tenzo Chang, NetID: tenzosc, ID# 71399216
Richard Ko, NetID: kor2, ID# 49678951
PA 1: Building a Dynamic Website

Our website features: Our website continues to build upon the foundational html/css/js/jquery that was utilized to build an offline website for gaining skills to create a dynamic and responsive e-commerce website. For this assignment, we transferred our html code to java servlets and utilizing doGet(), doPost() methods as well as session tracking and "forward"ing and "includ(e)"ing to fulfill the requirements for the assignment. While we fell short in some areas of design, our team worked tirelessly over multiple days to try and bring this project together. We are still working on some database connectivitiy issues, but our website is deployed on AWS through elastic beanstalk at the following address:
http://pa2inf124-env.eba-3zxqv2sr.us-west-1.elasticbeanstalk.com/

Requirements: 
(1) - Only servlets are used to create our website. The product page for each video game system is generated dynamically through a java servlet. Products are obtained from our database "game_db" and displayed through querying the tables. This database was pre-determined. The requirement for the last five products ordered is a part of the order confirmation page and also employs the "include" function of java servlets per the requirement. The user is able to rate their order in the order form and the rating is displayed when they click on the last five products button on the order confirmation page (Please see Canvas → discussions → Clarity regarding...for Professor Malek's permission to do so). While the CSS for the rating "radio" buttons did not successfully build on java servlets, our team achieved success on an html interface. 
(2) - Product details are generated dynamically by the shopping cart session which stores the game id used to reference by query to the actual games and prices. The cart uses a Hashmap data structure to store and a session is invoked (and later made invalidated upon successful check out).
(3) - The user is able to submit an order form, and the information filled into the form is checked for validation. Submitted data is stored in the database under the table "orders". 
(4) - The check out page is viewable by popout form and contains the necessary form fields for a user to fill out in order to ensure successful order/delivery of an item per the requirements of this assignment. Once submitted (along with the review for the order), the information is stored in the database. The list of products is also stored first. Finally, the user is forwarded to the confirmation page via the "forward" function of java servlets.

Extra Credit
(5) - The site is live on the above address through AWS-Eleastic Beanstalk, however, our team is currently having database connectivity issues. Any partial extra credit would be appreciated.
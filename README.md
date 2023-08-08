# WEB NOTICE BOARD
A web notice board, also known as an online bulletin board or digital bulletin board, offers several benefits compared to traditional physical notice boards. Here are some of the key advantages:

**Group members**
>* SEU/IS/20/ICT/001 - Prabhashwara T.H.M.C
>* SEU/IS/20/ICT/012 - Rajapaksha T.D
>* SEU/IS/20/ICT/033 - 
>* SEU/IS/20/ICT/046 - 
>* SEU/IS/20/ICT/070 - Karunarathna W.M.S.H.A

1. Accessibility: Web notice boards are accessible from anywhere with an internet connection. Users can view and interact with the content on the board using various devices, such as computers, tablets, and smartphones.
 
2. Convenience: Users can access and post information at their convenience, eliminating the need to be physically present at a specific location to view or update notices.

3. Real-time Updates: Information on a web notice board can be updated instantly. This is particularly useful for time-sensitive announcements or rapidly changing information.

4. Cost Savings: Traditional notice boards require physical materials like paper, printing supplies, and maintenance. A web notice board eliminates these costs, as it operates digitally.

5. Environmentally Friendly: Since there's no need for physical materials like paper and ink, a web notice board contributes to a reduction in paper waste and environmental impact.

6. Centralized Information: A web notice board serves as a centralized platform for all announcements, notices, and updates. This helps avoid clutter and confusion associated with multiple physical notice boards.

7. Searchability: Web notice boards often come with search functionality, making it easier for users to find specific information within a large pool of notices.

8. Multi-media Integration: Web notice boards can incorporate various types of media, such as images, videos, links, and attachments, enhancing the presentation and understanding of information.

9. User Interaction: Depending on the platform, users may be able to comment, like, share, or interact with notices, promoting engagement and collaboration.

10. Remote Collaboration: Web notice boards facilitate collaboration among individuals or groups that may be physically distant. This is particularly beneficial for organizations with distributed teams or online learning environments.

11. Scheduling and Organization: Notices can be organized by categories, tags, or dates, making it easier for users to navigate and locate relevant information.

12. Automatic Reminders: Some web notice board systems allow for scheduling automatic reminders for upcoming events or deadlines.

13. Notifications: Users can receive notifications (email, app notifications, etc.) when new notices are posted or when there are updates to existing notices.

14. Control and Moderation: Administrators can have better control over the content posted on the notice board, allowing them to review and moderate submissions before they are published.

15. Analytics: Web notice board platforms often provide insights into user engagement, such as the number of views, interactions, and clicks on notices, helping administrators understand the effectiveness of their communications.

## Project architecture
This is created by connecting a JAVA GUI APPLICATION, a DATABASE and a WEBSITE together. New News and Notice can be created, updated and deleted using the Java application.

![](markdownresources/main1.png)
### Database
![](markdownresources/databae.png)
-----------------------------------------------------------
[SQL Schema - Download and craete database(LINK)](markdownresources/seu.sql)
-----------------------------------------------------------
Table structure.

1. user table.
The User Table is responsible for storing user-related information. It contains a unique identifier for each user, an individual's full name, their email address. This table is essential for managing user authentication and maintaining their core profile details.

id(PRIMARY KEY / AUTOINCREMENT) | fullName(VARCHAR) | firsttName(VARCHAR) | lastName(VARCHAR) | email(VARCHAR) | password(VARCHAR)
--- | --- | --- | --- | --- | --- |

2. news table.
The News Table is designed to manage news articles. It holds an identifier for each article, along with its title, subtitle, and main content. Additionally, a timestamp is recorded to indicate when the article was created. The user_id field establishes a connection with the User Table, linking each news article to the user who authored it. This table facilitates the organization and retrieval of news content for users.

id(PRIMARY KEY / AUTOINCREMENT) | title(VARCHAR) | subtitle(VARCHAR) | content(VARCHAR) | timestamp(timestamp) | user_id(FORIEGN KEY)
--- | --- | --- | --- | --- | --- |

3. notice table.
The Notice Table is focused on handling notices or announcements. It stores a unique identifier for each notice, its title, subtitle, and detailed content. The timestamp indicates when the notice was issued. The user_id field connects to the User Table, associating each notice with the user responsible for its creation. This table serves as a repository for important messages or updates intended for users.
id(PRIMARY KEY / AUTOINCREMENT) | title(VARCHAR) | subtitle(VARCHAR) | content(VARCHAR) | timestamp(timestamp) | user_id(FORIEGN KEY)
--- | --- | --- | --- | --- | --- |

These tables collectively enable the efficient management of users, news articles, and notices, enhancing the functionality of the associated system or application.
# java-chat

## Description

This project is a chat app that allows users to register, sign in, and start conversations with other people. Users can
create new chats, add other people to their chats, and send messages that can be viewed by all members of the chat.

## Tools and technologies

- Java
- Spring Boot
- PostgresSQL
- JPA
- JWT

## REST API endpoints

| Request Type | URL                                  | Functionality            | Access  | 
|--------------|--------------------------------------|--------------------------|---------|
| POST         | /users/login/                        | User login               | Public  |
| POST         | /users/register/                     | User registration        | Public  |
| GET          | /channels/                           | User's channels          | Private |
| GET          | /channels/{id}/                      | User's channel           | Private |
| POST         | /channels/                           | Create channel           | Private |
| PUT          | /channels/{id}/                      | Update channel           | Private |
| POST         | /channels/{channelId}/user/{userId}/ | Add user to channel      | Private |
| DELETE       | /channels/{channelId}/               | Delete user from channel | Private |
| GET          | /channels/{id}/messages/             | Get messages in channel  | Private |
| POST         | /channels/{id}/messages /            | Create message           | Private |
| PUT          | /channels/{id}/messages/{messageId}/ | Update message           | Private |
| DELETE       | /channels/{id}/messages/{messageId}/ | Delete message           | Private |

## Hurdles

My biggest hurdle was creation of many-to-many relationship for users and channels(. There
are [multiple ways to implement it in Spring Boot](https://www.baeldung.com/jpa-many-to-many). I used separate entity to
contain relationships between these two tables.

## User Stories

### Bronze

- As a user, I want to register, so I can chat with other people. :heavy_check_mark:
- As a user, I want to sign in into my account, so I can get access to my chats and messages. :heavy_check_mark:
- As a user, I want to create new chat to start conversation. :heavy_check_mark:
- As a user, I want to get a list of chats I'm in. :heavy_check_mark:
- As a user, I want to find specific chat I'm member of. :heavy_check_mark:
- As a user, I want to add other people to my chat, so we can talk. :heavy_check_mark:
- As a user, I want to send a message to the chat, so other users in this chat can see it. :heavy_check_mark:
- As a user, I want to check messages in a chat that I'm member of. :heavy_check_mark:

### Silver

- As a user, I want to change name of chat I'm member of. :heavy_check_mark:
- As a user, I want to edit my message, so I can fix my old message. :heavy_check_mark:
- As a user, I want to delete my message, so nobody can see it anymore. :heavy_check_mark:
- As a user, I want to leave a chat, so I don't get any more messages from there. :heavy_check_mark:

### Gold

- As a user, I want to add picture to my profile so others can see it

## ERD diagram

![image](https://drive.google.com/uc?export=view&id=<FILE_ID>=1B9akAdkTERe8TrlVktyZWDrCrgwjQMZo)

## Documentation

1. Create ERD diagram
2. Initialize Spring Boot project.
3. Added to GitHub repository.
4. Created Models
5. Created Repositories
6. Created Controllers and Services
7. Connected Messages to Channel
8. Added Get and Post requests for Channel and Message
9. Added Not Found Exception
10. Updating User
11. Implementing registration
12. Update services
13. Add more requests
14. Refactoring

## Credit

Thanks amazing team that I worked with while creating this project:
[Kevin Barrios](https://github.com/dayjyun), [Jeff Ou](https://github.com/pophero110), [Jay Padilla](https://github.com/Jaypad07) [Obinna Umerah](https://github.com/ObinnaUmerah), [Dominique Akers](https://github.com/Dommy99)

Recources that helped me:
https://www.baeldung.com
https://stackoverflow.com
https://www.google.com



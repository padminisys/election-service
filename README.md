# Election-Service
Core Backend Services for conducting election.

**For local development :**

- Start a standalone keyclock server.
- Start mysql server.

You may use postman or Insomnia for API testing.

@Padminisys 


##Core phase 1 API List:

- Create House
- Get House
- Get Member
- Get Members List of a particular house
- Membership created by admin
- Update member by Admin – usually for mapping login-email id
- Create Election event by admin
- Create polling event by admin
- Add poll participant to polling event
- A member self-Nominates for election nomination – post nomination for specific polling event
- Reviewer Approve – get list of all nomination, approve
- Election Day open window – time bound window, auto window open
- Cast vote – vote recorded – all poll participant casts vote, validation check and record vote
- Result publishes @specified time with vote stats
- Vote stats like voting % - get stats
- Vote casted notification email

**_@NamedQueries_ support:**

- https://youtrack.jetbrains.com/issue/IDEA-260599 - no support for query from properties file
- for orm.xml queries use https://github.com/jb-tester/spring-jpa-namedqueries/
**explicit queries that use java types (including enums)**

- https://youtrack.jetbrains.com/issue/IDEA-173631 - no injection into constant used as query value
- https://youtrack.jetbrains.com/issue/IDEA-260287 - constant reference in the @Query in highlighted as error
_enums:_
- https://youtrack.jetbrains.com/issue/IDEA-115841 (incorrect results of enum moving)
- https://youtrack.jetbrains.com/issue/IDEA-244155 (unresolved enum literals)
- https://youtrack.jetbrains.com/issue/IDEA-160992 (Show error when enum type passed as argument into native JPA query)
- https://youtrack.jetbrains.com/issue/IDEA-232989 (inner enum literals in JPA queries are not recognized when $ is used)
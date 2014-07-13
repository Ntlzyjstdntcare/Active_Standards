Active_Standards
================

For cron DSL program.

This program is released under the MIT license (see LICENSE.txt).

The program is written in Java, and uses a builder pattern to allow a user to create 
a Cron object in one line of code, by chaining methods. There are seven setter methods 
corresponding to the seven fields of a cron string. The user may chain the methods in 
any order.

Regarding the seconds, minutes, hours, day of month and year fields - we allow the user 
to use the digits 0-59 as before. For the month and day of week fields we require the 
user to use the abbreviated English language specifications that are an option for cron 
strings (JAN-DEC and SUN-SAT). This is in order to reduce ambiguity and provide an 
English-like syntax for our DSL.

Regarding special characters, I have simply replaced the '*', '?', ',' and '-' characters 
with corresponding English-like terms. They are, respectively, 'ALL', 'NONESPECIFIED', 
'AND' and 'UNTIL'. The '/' character is replaced with the terms 'FROM' and 'EVERY'. For 
example, '0/3' becomes 'FROM0EVERY3'. 'EVERY3FROM0' would be more intuitive and 
English-like, but it adds much complexity to the parsing.

The 'L' special character is replaced with 'LAST'. When using it for the day of week 
field in conjunction with a day value, 'LAST' comes before the value. For example, 
'LASTFRI' in our DSL will be translated into FRIL for the cron string. When using 'LAST' 
for the day of month field, we specify an offset by using 'MINUS'. For example, 
'LASTMINUS3' is translated to 'L-3' for the field in the cron string.

The 'W' special character is simply replaced with 'NEARESTWEEKDAY'. For example, 
'15NEARESTWEEKDAY' will translate to '15W' for the cron string, and 'LASTNEARESTWEEKDAY' 
will translate to 'LW'. The '#' special character is replaced by the English language 
equivalents ('FIRST, 'SECOND', ..., 'SEVENTH'). In our DSL the descriptive adjective 
comes before the day of the week. So, for example, 'SECONDTUE' is translated into '3#2'.

If leaving the year field empty we simply enter no parameters to the setter method.

Our DSL is case-sensitive. If I had more time I would certainly strive to remove this 
constraint. Another weakness is the program's crude input validation. Regular expressions 
would provide a much more elegant and powerful means of input validation, but my knowledge 
of regexs is not currently sufficient. Finally, if I had more time I would implement the 
translation of the '/' character the-other-way-round, e.g. 'EVERY3FROM0'.


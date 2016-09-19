import sqlite3 as db

conn=db.connect('test.db')
conn.row_factory=db.Row
cursor=conn.cursor()

# Create table
# cursor.execute("create table films(title text,year text,director text)")
# print "table created"
cursor.execute("drop table if exists temps")
cursor.execute("create table temps(date text,temp int)")

# Insert record
cursor.execute('insert into films values("Annie Hall","1977","Woody Allen")')
cursor.execute('insert into films values("The Godfather","1972","Francis Ford Copolla")')
cursor.execute('insert into temps values("12/1/2011",35)')
cursor.execute('insert into temps values("12/2/2011",42)')
cursor.execute('insert into temps values("12/3/2011",38)')
cursor.execute('insert into temps values("12/4/2011",41)')
cursor.execute('insert into temps values("12/5/2011",40)')

# Retreive record
cursor.execute("select * from films")
rows=cursor.fetchall()
for row in rows:
  print row["title"],row["year"],row["director"]

cursor.execute("select * from temps order by temp")
rows=cursor.fetchall()
for row in rows:
  print row["date"],row["temp"]
cursor.execute("select avg(temp) from temps")
row=cursor.fetchone()
print 'temp average is: ',row[0]

conn.close()



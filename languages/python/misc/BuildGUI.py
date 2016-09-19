from Tkinter import *

# Create a window
win=Tk()

# ListBox
lb=Listbox(win,height=3)
lb.pack()
lb.insert(END,"first entry")
lb.insert(END,"second entry")
lb.insert(END,"third entry")
lb.insert(END,"fourth entry")

# ScrollBar
sb=Scrollbar(win,orient=VERTICAL)
sb.pack(side=LEFT,fill=Y)
sb.configure(command=lb.yview)
lb.configure(yscrollcommand=sb.set)

# Buttons
b1=Button(win,text="One")
b1.pack()
b2=Button(win,text="Exit")
b2.pack()

# Label
l1=Label(win,text="This is a label")
l1.pack()

# Command 
b1.configure(text="Uno")
def but1():
 print "Button was pushed"
b1.configure(command=but1)

# StringVar
v=StringVar()
e=Entry(win,textvariable=v)
e.pack()
v.get()
v.set("This is set from program")

# Run
win.mainloop()

class passengers:
    def __init__ (self,na,mo,uid,pw):
        self.na=na
        self.mo=mo
        self.uid=uid
        self.pw=pw
        self.sts="Pending"
        self.bk_t=0
class tickets:
    tn=50
class details(tickets):
    def __init__ (self):
        self.uid=1201
        self.dd=[]
d=details()
def signup():
    n=input("Enter Name: ")
    m=input("Enter mobile number:")
    pw=input("Enter Password:")
    e=passengers(n,m,d.uid,pw)
    d.dd.append(e)
    print("Your User ID is:",d.uid)
    d.uid+=1
def signin():
    ui=int(input("Enter User ID:"))
    pw=input("Enter Password:")
    if d.dd[ui-1201].uid==ui and d.dd[ui-1201].pw==pw:
        while True:
            opt=int(input("Enter option:\n1.Book tickets\n2.Cancel tickets\n3.Check availability"))
            if opt==4:
                break
            elif opt==1:
                nt=int(input("Enter number of tickets to book:"))
                d.dd[ui-1201].bk_t=nt
                print("Your tickets are pending..........!")
            elif opt==2:
                if d.dd[ui-1201].sts=="Approved":
                    nt=int(input("Enter Number of tickets to cancel:"))
                    d.dd[ui-1201].bk_t-=nt
                    print("Your tickets are cancelled successfully.......!")
                else:
                    print("Your tickets are not yet approved.........!")
            elif opt==3:
                print("Available no of tickets:",d.tn)
    else:
        print("Invalid user Id/Password.....!")
def cash():
    print("Name\tUser ID\tTickets Booked\n      \t         \t               ")
    for i in range(len(d.dd)):
        print(d.dd[i].na,"\t",d.dd[i].uid,"\t",d.dd[i].bk_t)
    while True:
        opt=int(input("Enter option:\n1.Approve\n2.Cancel\n3.Exit"))
        if opt==3:
            break
        elif opt==1:
            tid=int(input("Enter user ID:"))
            d.dd[tid-1201].sts="Approved"
            d.tn-=d.dd[tid-1201].bk_t
            d.dd[tid-1201].bk_t=0
            print("Approved succesfully")
        elif opt==2:
            continue
        else:
            print("Invalid option.........!")
print("*******WELCOME TO T4TEQ TRAVELS*******")
while True:
    n=int(input("Enter option\n1.Passengers\n2.Cashier\n3.Exit\n"))
    if n==3:
        print("Thanks for using........!")
        break
    elif n==1:
        while True:
            opt=int(input("Enter option:\n1.Signup\n2.Signin\n3.Exit\n"))
            if opt==3:
                break
            elif opt==1:
                signup()
            elif opt==2:
                signin()
    elif n==2:
        cash()
        
    else:
        print("Invalid option...!")





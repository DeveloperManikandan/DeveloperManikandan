import java.util.*;
class Bill
{
    int price;
}
class Stock extends Bill
{
    String sn;
    int rt,qt,sid,bid,bqt;
    void addstock(Scanner sc,int tid)
    {
        System.out.println("Enter Stock Name: ");
        this.sn=sc.next();
        System.out.println("Enter Stock Rate: ");
        this.rt=sc.nextInt();
        System.out.println("Enter Stock Quantity: ");
        this.qt=sc.nextInt();
        this.sid=tid;
    }
    void updatestock(Scanner sc,int tid)
    {
        System.out.println("Enter Stock Name: ");
        this.sn=sc.next();
        System.out.println("Enter Stock Rate: ");
        this.rt=sc.nextInt();
        System.out.println("Enter Stock Quantity: ");
        this.qt=sc.nextInt();
        this.sid=tid;
    }
    void addbill(Scanner sc)
    {
        System.out.println("Enter Quantity:");
        this.bqt=sc.nextInt();
        qt-=bqt;//75
        price=bqt*rt;
    } 
    void updatebill(Scanner sc)
    {
        qt+=bqt;//100
        System.out.println("Enter New Quantity:");
        this.bqt=sc.nextInt();
        qt-=bqt;//85
        price=bqt*rt;
    }
}
class Cashier extends Stock
{
    String cid,pw;
    void addcash(Scanner sc)
    {
        System.out.print("Enter Cashier ID: ");
        this.cid=sc.next();
        System.out.print("Enter Cashier Password: ");
        this.pw=sc.next();
        System.out.println("!..Cashier Added Successfully..!");
    }
}
public class Main
{
    public static void main(String arg[])
    {
        int n,cc=0,st=0,aid=1001;
        Scanner sc=new Scanner(System.in);
        Cashier ch[]=new Cashier[10];
        while(true)
        {
            System.out.println("1.Owner\n2.Cashier\n3.Exit\n");
            n=sc.nextInt();
            if(n==1)
            {
                System.out.println("Enter Owner Password: ");
                if(sc.next().equals("teq"))
                {
                    while(true)
                    {
                        System.out.println("1.AddCashier\n2.Report\n3.Exit\n");
                        int opt=sc.nextInt();
                        if(opt==1)
                        {
                            ch[cc]=new Cashier();
                            ch[cc].addcash(sc);
                            cc++;
                        }
                        else if(opt==2)
                        {
                            System.out.println("***>>> Report <<<***");
                            if(cc==0||st==0)
                            System.out.println("No Report Yet...!");
                            else
                            {
                                System.out.println("Stock Name\tQuantity\tPrice\n__________________________________________________");
                                for(int i=0;i<st;i++)
                                {
                                    System.out.println(ch[i].sn+"\t"+ch[i].qt+"\t"+ch[i].rt);
                                }
                                int totalsales=0;
                                for(int i=0;i<st;i++)
                                totalsales+=ch[i].price;
                                System.out.println("Total Sales Of The Shop:"+totalsales);
                            }
                        }
                        else if(opt==3)
                        {
                            break;
                        }
                        else
                            System.out.println("Invalid Option...!");
                    }                
                }
                else
                    System.out.println("Invalid Pasword...!");
            }
            else if(n==2)
            {
                boolean fl=false;
                System.out.println("Enter Cashier ID: ");
                String tid=sc.next();
                System.out.println("Enter Cashier Password: ");
                String tpw=sc.next();
                for(int i=0;i<cc;i++)
                {
                    if(tid.equals(ch[i].cid)&&tpw.equals(ch[i].pw))
                    {
                        fl=true;
                        break;
                    }
                }
                if(fl)
                {
                    while(true)
                    {
                        System.out.println("1.Stock Entry\n2.Bill Entry\n3.Exit\n");
                        int opt=sc.nextInt();
                        if(opt==1)
                        {
                            System.out.println("1.Add\n2.Update\n3.Delete\n");
                            int m=sc.nextInt();
                            if(m==1)
                            {
                                ch[st].addstock(sc,aid);
                                aid++;
                                st++;
                            }
                            if(m==2)
                            {
                                fl=true;
                                System.out.println("\n>>> Stocks IN <<<\n");
                                for(int i=0;i<st;i++)
                                {
                                    System.out.println(ch[i].sn+"\t"+ch[i].sid);
                                }
                                System.out.println("Enter Product ID:");
                                int tid1=sc.nextInt();
                                for(int i=0;i<st;i++)
                                {
                                    if(tid1==ch[i].sid)
                                    {
                                        fl=false;
                                        ch[i].updatestock(sc,tid1);
                                        System.out.println("\n>>> Updated Successfully <<<\n");
                                        break;
                                    }
                                }
                                if(fl)
                                System.out.println("Invalid Product ID...!");
                            }
                        }
                        else if(opt==2)
                        {
                            System.out.println("1.Add\n2.Update\n3.Delete\n");
                            int m=sc.nextInt();
                            if(m==1)
                            {
                                System.out.println("\n>>> Stocks IN <<<\n");
                                for(int i=0;i<st;i++)
                                {
                                    System.out.println(ch[i].sn+"\t"+ch[i].sid);
                                }
                                System.out.println("Enter Product ID: ");
                                int tid1=sc.nextInt();
                                for(int i=0;i<st;i++)
                                {
                                    if(tid1==ch[i].sid)
                                    {
                                        fl=false;
                                        ch[i].addbill(sc);
                                        System.out.println("\n>>> Billed Successfully <<<\n");
                                        break;
                                    }
                                }
                                if(fl)
                                System.out.println("Invalid Product ID...!");
                            }
                            if(m==2)
                            {
                                fl=true;
                                System.out.println("\n>>> Stocks IN <<<\n");
                                for(int i=0;i<st;i++)
                                {
                                    System.out.println(ch[i].sn+"\t"+ch[i].sid);
                                }
                                System.out.println("Enter Product ID:");
                                int tid1=sc.nextInt();
                                for(int i=0;i<st;i++)
                                {
                                    if(tid1==ch[i].sid)
                                    {
                                        fl=false;
                                        ch[i].updatebill(sc);
                                        System.out.println("\n>>> Updated Successfully <<<\n");
                                        break;
                                    }
                                }
                                if(fl)
                                System.out.println("Invalid Product ID...!");
                            }
                        }
                        else if(opt==3)
                        {
                            break;
                        }
                        else
                            System.out.println("Invalid Option...!");
                    }
                }
                else
                    System.out.println(">>>Invalid Cashier ID or Password<<<");
            }
            else if(n==3)
            {
                System.out.println("Thanks for Using...!");
                break;
            }
            else
                System.out.println("Invalid Option..!");
        }
    }
}

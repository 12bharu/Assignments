package JavaAssignments;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;




public class Customer implements Comparable<Customer> {
	
	String name;
	int type;
	double moneyspent;
	String date;
	
//	public Customer() {
//		super();
//	}

	
   public Customer(String name,int type,String date, double moneyspent) {
	   this.name=name;
	   this.type=type;
	   this.date=date;
	   this.moneyspent=moneyspent;
	   
   }
   
   public int money_compare(double m1, double m2) {
	   if(m1>m2) return +1;
	   if(m1<m2) return -1;
	   return 0;
   }
   public int date_Compare(String d1, String d2)   {
	   LocalDate currdate1= LocalDate.parse(d1);
	   int month1= currdate1.getMonthValue();
	   int year1=currdate1.getYear();
	   LocalDate currdate2= LocalDate.parse(d2);
	   int month2= currdate2.getMonthValue();
	   int year2=currdate2.getYear();
	  if(year1==year2) {
		  if(month1>month2) return +1;
		  if(month1<month2) return -1;
		  return 0;	  
	  }
//	   if(d1.compareTo(d2)>0) {
//		   return +1;
//	   }
//	   if(d1.compareTo(d2)<0) {
//		   return -1;
//	   }
//	   return 0;
	   
	  if(year1>year2) return +1;
	  return -1;
   }
@Override
public int compareTo(Customer o) {
	int codate;
	int comoney;
	if(type==o.type) {
		
			codate = date_Compare(date, o.date);
		
		if(codate==0) {
			comoney = money_compare(moneyspent,o.moneyspent);
			if(comoney==0) return 0;
			if(comoney==+1) return -1;
			return +1;
		}
		if(codate==+1) return +1;
		
		
		return -1;
	}
	if(type<o.type) {
		return +1;
	}
	
	return -1;
}



	
	

}


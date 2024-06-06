package org.movie_system.client;

import java.util.*;

import org.movie_system.model.AdminModel;
import org.movie_system.model.MovieMasterModel;
import org.movie_system.model.UserModel;
import org.movie_system.service.AdminService;
import org.movie_system.service.GenresService;
import org.movie_system.service.MovieService;
import org.movie_system.service.UserService;



public class RecommendationClientApplication {

	public static void main(String[] args) {
		AdminService as=new AdminService();
		UserService us=new UserService();
		MovieService ms=new MovieService();
		GenresService gs=new GenresService();
		
		do {
			Scanner sc=new Scanner(System.in);
			
			System.out.println("+----------------------------------------------------------------------------------------+");
			System.out.println("|\t\t\t** Movie_Recommendation_System_Menu **\t\t\t         |");
			System.out.println("|----------------------------------------------------------------------------------------|");
			System.out.println("|\t\t\t\t\t\t\t\t\t\t\t |");
			System.out.println("|\t\t 1 : Registration Panel.                                                 |");
			System.out.println("|\t\t\t\t\t\t\t\t\t\t\t |");
			System.out.println("|\t\t 2 : Admin Login Panel.                                                  |");
			System.out.println("|\t\t\t\t\t\t\t\t\t\t\t |");
			System.out.println("|\t\t 3 : User Login Panel.                                                   |");
			System.out.println("|\t\t\t\t\t\t\t\t\t\t\t |");
			System.out.println("|\t\t 4 : Exit.                                                               |");
			System.out.println("|\t\t\t\t\t\t\t\t\t\t\t |");
			System.out.println("|----------------------------------------------------------------------------------------|");
			System.out.println("|\tAdmin:)mr_pawar96k\t\t\t\t\t\t<java_jdbc>\t |");
			System.out.println("+----------------------------------------------------------------------------------------+");
			System.out.println("Enter your choice and Hit Enter:");
			int choice=sc.nextInt();
			
			switch(choice) {
			
			
			//......................    Registration  .................................. 
			case 1:
				int ch=0;
				do {
					System.out.println("+..........................................................+");
					System.out.println("|\t\t** Registration_Menu **\t\t           |");
					System.out.println("|..........................................................|");
					System.out.println("|\t\t 1 : Admin Registration.                   |");
					System.out.println("|\t\t 2 : User Registration.                    |");
					System.out.println("|\t\t 3 : Exit.                                 |");
					System.out.println("+..........................................................+");
					System.out.println("Enter your Registration choice:");
					ch=sc.nextInt();
					
					switch(ch) {
					case 1:;
						sc.nextLine();
						System.out.println("Enter Admin name     :");
						String adminname=sc.next();
						System.out.println("Enter Admin Mobile No:");
						String amobileno=sc.next();
						System.out.println("Enter PassWord       :");
						String apassword=sc.next();
						
						AdminModel amodel=new AdminModel();
						amodel.setAdminname(adminname);
						amodel.setAmobileno(amobileno);
						amodel.setApassword(apassword);
						
						boolean b=as.isAddAdmin(amodel);
						if(b)
							System.out.println("New Admin Added In Database...Done");
						else
							System.out.println("Admin not added...!");
							
						break;
						
					case 2:
						sc.nextLine();
						System.out.println("Enter User name     :");
						String unname=sc.next();
						System.out.println("Enter User Age      :");
						int uage=sc.nextInt();
						System.out.println("Ener User Mobile No :");
						String umobileno=sc.next();
						System.out.println("Enter PassWord      :");
						String upassword=sc.next();
						
						
						UserModel umodel=new UserModel();
						umodel.setUname(unname);
						umodel.setUage(uage);
						umodel.setUmobileno(umobileno);
						umodel.setUpassword(upassword);
						
						b=us.isAddUser(umodel);
						if(b)
							System.out.println("New User Added In Database...Done");
						else 
							System.out.println("User not added...!");
						
						break;
							
					} // end  switch case
				}while(ch<3);
				
				break;  // end ragistration 
				
				
	//......................    Admin  Login  .................................. 			
			case 2:
				sc.nextLine();
				System.out.println("+..........................................................+");
				System.out.println("|\t\t** Admin_Login **\t\t           |");
				System.out.println("|..........................................................|");
				System.out.println("|  Enter Admin Mobile No :                                 |");
				String mono=sc.next();
				System.out.println("|  Enter Admin PassWord  :                                 |");
				String password=sc.next();
				System.out.println("+..........................................................+");
				boolean b=as.isAdminValid(mono, password);
				
				if(b) {
					System.out.println("Admin Login Successfull.....");
					
					do {
						System.out.println("+..........................................................+");
						System.out.println("|\t\t** Admin_Menu **\t\t           |");
						System.out.println("|..........................................................|");
						System.out.println("|\t 1 : Add New movie.                                |");
						System.out.println("|\t 2 : All Display movies.                           |");
						System.out.println("|\t 3 : Update movie.                                 |");
						System.out.println("|\t 4 : Delete Movie.                                 |");
//						System.out.println("|\t 5 : Add bulk Genres File.                         |");
						System.out.println("|\t 5 : All Admin Display.                            |");	
						System.out.println("|\t 6 : All User Display.                             |");
						System.out.println("|\t 7 : Exit.                                         |");
						System.out.println("+..........................................................+");
						System.out.println("Enter your Registration choice:");
						ch=sc.nextInt();
						
						switch(ch) {
						case 1:
							sc.nextLine();
							System.out.println("Enter Movie Title:");
							String movtitle = sc.nextLine();
							System.out.println("Enter Movie Year :");
							int movyear=sc.nextInt();
							System.out.println("Enter Movie Time :");
							int movtime= sc.nextInt();
							sc.nextLine();
							System.out.println("Enter Movie Language  :");
							String movlang= sc.nextLine();
							System.out.println("Enter movie Reles Date(yyyy/mm/dd):");
							String movdtrel= sc.nextLine();
							System.out.println("Enter movie Country    :");
							String movrelcountry= sc.nextLine();
							
							MovieMasterModel mmodel=new MovieMasterModel();
							mmodel.setMovtitle(movtitle);
							mmodel.setMovyear(movyear);
							mmodel.setMovtime(movtime);
							mmodel.setMovlang(movlang);
							mmodel.setMovdtrel(movdtrel);
							mmodel.setMovrelcountry(movrelcountry);
							
							b=ms.isAddMovie(mmodel);
							if(b)
								System.out.println("Movie Added Successfully in Application..");
							else
								System.out.println("movie not added..!");
			
							break;
				 		case 2:
				 			List<MovieMasterModel> list=ms.getAllMovies();

				 			if(list!=null){
								System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
								System.out.println("Movie_Id \tMovie_Tatle \tMovie_Year \tMovie_Time \tMovie_language \tMovie_rel_date \tMovie_Country");
								System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
								
								list.forEach((m)->System.out.println(m.getMid()+"\t\t"+m.getMovtitle()+"\t\t"+m.getMovyear()+"\t\t"+m.getMovtime()+"\t\t"+m.getMovlang()+"\t\t"+m.getMovdtrel()+"\t\t"+m.getMovrelcountry()));
								
								System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
							}
							else {
								System.out.println("There is no Admin present...!");
							}
				 			
							break;
							
				 		case 3:
				 			System.out.println("Some update leter......");
				 			break;
				 			
				 		case 4:
				 			System.out.println("Some update leter......");
				 			break;
				 			
				 		/*
				 		  case 5:
				 			System.out.println("-----------");
				 			b=gs.isBulkAddGenres();
				 			
				 			if(b)
				 				System.out.println("Genres Added Successfully");
				 			else
				 				System.out.println("some problem is there");
				 			
				 			break;
				 		*/
				 		case 5:
							List<AdminModel> alist =as.getAllAdmin();
							if(alist!=null){
								System.out.println("-----------------------------------------------------------------------");
								System.out.println("Admin_Id \tAdmin_Name \tAdmin_Mobile_No \tAdmin_password");
								System.out.println("-----------------------------------------------------------------------");
								
								alist.forEach((m)->System.out.println(m.getAdminid()+"\t\t"+m.getAdminname()+"\t\t"+m.getAmobileno()+"\t\t"+m.getApassword()));
								
								System.out.println("-----------------------------------------------------------------------");
							}
							else {
								System.out.println("There is no Admin present...!");
							}
							break;
				 		
							
				 		case 6:
							List<UserModel> li =us.getAllUser();
							if(li!=null){
								System.out.println("----------------------------------------------------------------------------------");
								System.out.println("User_Id \tUser_Name \tUser_Age \tUser_Mobile_No \tUser_Password");
								System.out.println("----------------------------------------------------------------------------------");
								
								li.forEach((m)->System.out.println(m.getUid()+"\t\t"+m.getUname()+"\t\t"+m.getUage()+"\t\t"+m.getUmobileno()+"\t\t"+m.getUpassword()));
								
								System.out.println("----------------------------------------------------------------------------------");
							}
							else {
								System.out.println("There is no User present...!");
							}
							
							break;	
							
							
							
						}
						 
					}while(ch<7);
					
				}
					
				else {
					System.out.println("Admin Mobile_no,password not Valid...?");
					System.out.println("Do you want to Forget password..? Type(yes/no)..?");
					String msg=sc.next();
					String temob;
					if(msg.equals("yes")) {
						System.out.printf("Enter the admin Mobile No -->");
						temob=sc.next();
						b=as.checkadminid(temob);
						if(b) {
							System.out.printf("Enter the New Password -->");
							String newpassword=sc.next();
							
							boolean b2=as.changePassword(temob,newpassword);
							if(b2)
								System.out.println("Password Changes Successfully....Done!");
							else
								System.out.println("Some error in changing password.");
							
						}
						else {
							System.out.println("not valid admin Id..!");
						}
					}
					else {
						System.out.println("Thank you.... (^_^)....");
					}
				}
					
		
				break;
				
				
	//......................    User Login  .................................. 
			case 3:
				
				sc.nextLine();
				System.out.println("+..........................................................+");
				System.out.println("|\t\t** User_Login **\t\t           |");
				System.out.println("|..........................................................|");
				System.out.println("|  Enter User Mobile No :                                  |");
				mono=sc.next();
				System.out.println("|  Enter User PassWord  :                                  |");
				password=sc.next();
				System.out.println("+..........................................................+");
				boolean b3=us.isUserValid(mono, password);
				
				if(b3) {
					System.out.println("User Login Successfull.....");
					
					do {
						System.out.println("+..........................................................+");
						System.out.println("|\t\t** Movie_Menu **\t\t           |");
						System.out.println("|..........................................................|");
						System.out.println("|\t 1 : Top 3 Movies Display                          |");
						System.out.println("|\t 2 : Display all movies.                           |");
						System.out.println("|\t 3 : User Watch History.                           |");
						System.out.println("|\t 4 : Exit.                                         |");
						System.out.println("+..........................................................+");
						System.out.println("Enter your Registration choice:");
						ch=sc.nextInt();
						
						switch(ch) {
						
						case 1:
				 			System.out.println("Some update leter......");
				 			List<MovieMasterModel> li=ms.getTopTreeMovies();

				 			if(li!=null){
				 				System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
								System.out.println("Movie_Id \tMovie_Tatle \tMovie_Year \tMovie_Time \tMovie_language \tMovie_rel_date \tMovie_Country");
								System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
								
								li.forEach((m)->System.out.println(m.getMid()+"\t\t"+m.getMovtitle()+"\t\t"+m.getMovyear()+"\t\t"+m.getMovtime()+"\t\t"+m.getMovlang()+"\t\t"+m.getMovdtrel()+"\t\t"+m.getMovrelcountry()));
								
								System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
							}
				 			else {
				 				
				 			}
				 			
				 			break;
				 			
				 		case 2:
				 			List<MovieMasterModel> list=ms.getAllMovies();

				 			if(list!=null){
				 				System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
								System.out.println("Movie_Id \tMovie_Tatle \tMovie_Year \tMovie_Time \tMovie_language \tMovie_rel_date \tMovie_Country");
								System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
								
								list.forEach((m)->System.out.println(m.getMid()+"\t\t"+m.getMovtitle()+"\t\t"+m.getMovyear()+"\t\t"+m.getMovtime()+"\t\t"+m.getMovlang()+"\t\t"+m.getMovdtrel()+"\t\t"+m.getMovrelcountry()));
								
								System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
							}
							else {
								System.out.println("There is no present Movies...!");
							}
				 			
							break;
							
				 		case 3:
				 			System.out.println("Some update leter......");
				 			break;
				 			
				 		
				 			
				 		
				 		/*case 6:
							 sc.nextLine();
							 System.out.println("Enter movie name");
							 String movtitle1=sc.nextLine();
							 int movId=ms.getMovId(movtitle1);
							 System.out.println(movId);
							 if(movId!=-1)
							 {
								 System.out.println("Enter username");
								 String uname=sc.nextLine();
								 System.out.println("Enter user age");
								 int uage=sc.nextInt();
								 System.out.println("Enter user contact number");
								 String ucontact=sc.nextLine();
								 
								 System.out.println("enter user password");
								 String upassword=sc.nextLine();
								 
								 
								 int userid=ms.getUserIdAutomatic();
								 System.out.println(userid);
								 sc.nextLine();
								 UserModel umodel=new UserModel();
								 umodel.setMid(movId);
								 umodel.setUname(uname);
								 umodel.setUpassword(upassword);
								 umodel.setUmobileno(ucontact);
								 umodel.setUage(uage);
								 umodel.setUid(userid);
								 System.out.println(movId+"\t"+uname+"\t"+upassword+"\t"+ucontact+"\t"+uage+"\t"+userid);
								 b=ms.isAddUser(umodel);
								 if(b)
								 {
									 System.out.println("user added Successfully");
								 }
								 else
								 {
									 System.out.println("user not added");
								 }
								 
								 
							 }
							 else
							 {
								 System.out.println("user");
							 }
							
				 			break;
				 			*/
						}
						 
					}while(ch<4);
					
				}
					
				else {
					System.out.println("User Mobile_no,password not Valid...?");
					System.out.println("Do you want to Forget password..? Type(yes/no)..?");
					String msg=sc.next();
					String temob;
					if(msg.equals("yes")) {
						System.out.println("Enter the User Mobile No -->");
						temob=sc.next();
						b3=us.checkUserId(temob);
						if(b3) {
							System.out.println("Enter the New Password -->");
							String newpassword=sc.next();
							
							b3=us.changePassword(temob,newpassword);
							if(b3)
								System.out.println("Password Changes Successfully....Done!");
							else
								System.out.println("Some error in changing password.");
							
						}
						else {
							System.out.println("not valid User Id..!");
						}
					}
					else {
						System.out.println("Thank you.... (^_^)....");
					}
				}
				break;
				
			default:
				System.out.println("wrong choice!");
				
			}//main end switch
		}while(true);
		
	}

}

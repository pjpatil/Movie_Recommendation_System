package org.movie_system.client;

import java.util.*;

import org.movie_system.model.AdminModel;
import org.movie_system.model.GenresModel;
import org.movie_system.model.MovieMasterModel;
import org.movie_system.model.RatingModel;
import org.movie_system.model.UserModel;
import org.movie_system.service.AdminService;
import org.movie_system.service.GenresService;
import org.movie_system.service.MovieService;
import org.movie_system.service.RatingService;
import org.movie_system.service.UserService;

public class RecommendationClientApplication {

	public static void main(String[] args) {
		AdminService as = new AdminService();
		UserService us = new UserService();
		MovieService ms = new MovieService();
		GenresService gs = new GenresService();
		RatingService rts = new RatingService();
		
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println(
					"+----------------------------------------------------------------------------------------+");
			System.out.println("|\t\t\t🎥🎥 Movie_Recommendation_System_Menu 🎥🎥\t\t         |");
			System.out.println(
					"|----------------------------------------------------------------------------------------|");
			System.out.println("|\t\t\t\t\t\t\t\t\t\t\t |");
			System.out.println("|\t\t 1 : Registration Panel.                                                 |");
			System.out.println("|\t\t\t\t\t\t\t\t\t\t\t |");
			System.out.println("|\t\t 2 : Admin Login Panel.                                                  |");
			System.out.println("|\t\t\t\t\t\t\t\t\t\t\t |");
			System.out.println("|\t\t 3 : User Login Panel.                                                   |");
			System.out.println("|\t\t\t\t\t\t\t\t\t\t\t |");
			System.out.println(
					"|----------------------------------------------------------------------------------------|");
			System.out.println("|\tAdmin:)mr_pawar96k\t\t\t\t\t\t<java_jdbc>\t |");
			System.out.println(
					"+----------------------------------------------------------------------------------------+");
			System.out.println("Enter your choice and Hit Enter:");
			int choice = sc.nextInt();

			switch (choice) {

			// ...................... Registration ..................................
			case 1:
				int ch = 0;
				do {
					System.out.println("+..........................................................+");
					System.out.println("|\t\t🎥🎥 Registration_Menu 🎥🎥\t\t   |");
					System.out.println("|..........................................................|");
					System.out.println("|\t\t 1 : Admin Registration.                   |");
					System.out.println("|\t\t 2 : User Registration.                    |");
					System.out.println("|\t\t 3 : Exit.                                 |");
					System.out.println("+..........................................................+");
					System.out.println("Enter your Registration choice:");
					ch = sc.nextInt();

					switch (ch) {
					case 1:   //  1 : Admin Registration. 
						sc.nextLine();
						System.out.println("Enter Admin name     :");
						String adminname = sc.next();
						System.out.println("Enter Admin Mobile No:");
						String amobileno = sc.next();
						System.out.println("Enter PassWord       :");
						String apassword = sc.next();

						AdminModel amodel = new AdminModel();
						amodel.setAdminname(adminname);
						amodel.setAmobileno(amobileno);
						amodel.setApassword(apassword);

						boolean b = as.isAddAdmin(amodel);
						if (b)
							System.out.println("New Admin Added In Database...Done");
						else
							System.out.println("Admin not added...!");

						break;

					case 2:     // 2 : User Registration.
						sc.nextLine();
						System.out.println("Enter User name     :");
						String unname = sc.next();
						System.out.println("Enter User Age      :");
						int uage = sc.nextInt();
						System.out.println("Ener User Mobile No :");
						String umobileno = sc.next();
						System.out.println("Enter PassWord      :");
						String upassword = sc.next();

						UserModel umodel = new UserModel();
						umodel.setUname(unname);
						umodel.setUage(uage);
						umodel.setUmobileno(umobileno);
						umodel.setUpassword(upassword);

						b = us.isAddUser(umodel);
						if (b)
							System.out.println("New User Added In Database...Done");
						else
							System.out.println("User not added...!");

						break;

					} // end switch case
				} while (ch < 3);

				break; // end ragistration

			// ...................... Admin Login ..................................
			case 2:
				sc.nextLine();
				System.out.println("+..........................................................+");
				System.out.println("|\t\t** Admin_Login **\t\t           |");
				System.out.println("|..........................................................|");
				System.out.println("|  Enter Admin Mobile No :                                 |");
				String mono = sc.next();
				System.out.println("|  Enter Admin PassWord  :                                 |");
				String password = sc.next();
				System.out.println("+..........................................................+");
				boolean b = as.isAdminValid(mono, password);

				if (b) {
					System.out.println("Admin Login Successfull.....");

					do {
						System.out.println("+..........................................................+");
						System.out.println("|\t\t** Admin_Menu **\t\t           |");
						System.out.println("|..........................................................|");
						System.out.println("|\t 1 : Add New movie.                                |");
						System.out.println("|\t 2 : Display movie List.                           |");
						System.out.println("|\t 3 : Update movie.                                 |");
						System.out.println("|\t 4 : Delete Movie.                                 |");
						System.out.println("|\t 5 : Add new Genres.                               |");
						System.out.println("|\t 6 : Display Genres wise Movie List.               |");
						System.out.println("|\t 7 : Search Genres by Movie Title.                 |");
						System.out.println("|\t 8 : All Admin Display.                            |");
						System.out.println("|\t 9 : All User Display.                             |");
						System.out.println("|\t 10: Exit.                                         |");
						System.out.println("+..........................................................+");
						System.out.println("Enter your choice:");
						ch = sc.nextInt();

						switch (ch) {

						case 1: // 1 : Add New movie.
							sc.nextLine();
							System.out.println("Enter Movie Title:");
							String movtitle = sc.nextLine();
							System.out.println("Enter Movie Year :");
							int movyear = sc.nextInt();
							System.out.println("Enter Movie Time :");
							int movtime = sc.nextInt();
							sc.nextLine();
							System.out.println("Enter Movie Language  :");
							String movlang = sc.nextLine();
							System.out.println("Enter movie Reles Date(yyyy/mm/dd):");
							String movdtrel = sc.nextLine();
							System.out.println("Enter movie Country    :");
							String movrelcountry = sc.nextLine();

							MovieMasterModel mmodel = new MovieMasterModel();
							mmodel.setMovtitle(movtitle);
							mmodel.setMovyear(movyear);
							mmodel.setMovtime(movtime);
							mmodel.setMovlang(movlang);
							mmodel.setMovdtrel(movdtrel);
							mmodel.setMovrelcountry(movrelcountry);
							b = ms.isAddMovie(mmodel);
							if (b)
								System.out.println("Movie Added Successfully in Application..");
							else
								System.out.println("movie not added..!");

							List<GenresModel> list1 = gs.getAllGenres();
							if (list1 != null) {
								System.out.println("+--------------------------------------------+");
								System.out.println("| Genres_Id \tGenres_Title       |");
								System.out.println("+--------------------------------------------+");
								list1.forEach(
										(mg) -> System.out.println("| " + mg.getGenid() + "\t\t" + mg.getGentitle()));
								System.out.println("+--------------------------------------------+");

								int tempmid = ms.getMovId();
								boolean isTrue = true;
								while (isTrue) {
									System.out.println("you have to assing genres to movie, Type(yes/no):");
									String msg = sc.next();
									if (msg.equals("yes")) {
										System.out.println("Enter Genres id:");
										int tempid = sc.nextInt();

										b = gs.isAddMovGenJoin(tempmid, tempid);
										if (b) {
											System.out.println("add Done join data.............");
										} else {
											System.out.println("not join to tables,,,,,");
										}
										isTrue = true;
									} else {
										isTrue = false;
									}
								}
							} else {
								System.out.println("Genres not Present...!");
							}

							break;

						case 2: // 2 : Display movie List.
							List<MovieMasterModel> list = ms.getAllMovies();

							if (list != null) {
								System.out.println(
										"-------------------------------------------------------------------------------------------------------------------------------");
								System.out.println(
										"Movie_Id \tMovie_Tatle \tMovie_Year \tMovie_Time \tMovie_language \tMovie_rel_date \tMovie_Country");
								System.out.println(
										"-------------------------------------------------------------------------------------------------------------------------------");

								list.forEach((m) -> System.out.println(m.getMid() + "\t\t" + m.getMovtitle() + "\t\t"
										+ m.getMovyear() + "\t\t" + m.getMovtime() + "\t\t" + m.getMovlang() + "\t\t"
										+ m.getMovdtrel() + "\t\t" + m.getMovrelcountry()));

								System.out.println(
										"-------------------------------------------------------------------------------------------------------------------------------");
							} else {
								System.out.println("There is no Admin present...!");
							}

							break;

						case 3: // 3 : Update movie.
							System.out.println("Enter the Movie Id :");
							int tempId = sc.nextInt();
							boolean b22 = ms.checkMovId(tempId);
							if (b22) {
								System.out.println("Enter the New Edit Title:");
								String newTitle = sc.next();

								b22 = ms.updateTitle(tempId, newTitle);
								if (b22) {
									System.out.println("Update Movie Title Successfully....Done!");
								}

								else {
									System.out.println("Some error in updates.");
								}

							} else {
								System.out.println("not exit movie Id in database..!");
							}

							break;

						case 4: // 4 : Delete Movie.
							System.out.println("Enter the Movie Id :");
							int newId = sc.nextInt();
							boolean b4 = ms.checkMovId(newId);
							if (b4) {
								System.out.println("Conform we want to delete Movie,Enter Id to delete :");
								newId = sc.nextInt();

								b4 = ms.deleteMovie(newId);
								if (b4) {
									System.out.println("Deleted Movie Successfully....Done!");
								}

								else {
									System.out.println("Some error in Delete.");
								}

							} else {
								System.out.println("not exit movie Id in database..!");
							}

							break;

						case 5: // 5 : Add new Genres.
							System.out.println("Enter genres title");
							sc.nextLine();
							String gentitle = sc.nextLine();

							GenresModel gModel = new GenresModel();
							gModel.setGentitle(gentitle);

							boolean b2 = gs.isAddGenres(gModel);
							if (b2) {
								System.out.println("Genres added successfully");
							} else {
								System.out.println("Some problem is there");
							}

							break;
						/*
						 * case 5: System.out.println("--- File genres add --------");
						 * b=gs.isBulkAddGenres();
						 * 
						 * if(b) System.out.println("Genres Added Successfully"); else
						 * System.out.println("some problem is there");
						 * 
						 * break;
						 */

						case 6: // 6 : Display Genres wise Movie List .
							List<GenresModel> list6 = gs.getAllMovieGenres();
							if (list6 != null) {
								System.out.println(
										"-------------------------------------------------------------------------------------------------------------------------------");
								System.out.println(
										"Movie_Id \tMovie_Tatle \tMovie_Year \tMovie_Time \tMovie_language \tMovie_rel_date \tMovie_Country \tMovie_genres ");
								System.out.println(
										"-------------------------------------------------------------------------------------------------------------------------------");
								list6.forEach((mg) -> System.out.println(
										mg.getMid() + "\t\t" + mg.getMovtitle() + "\t\t" + mg.getMovyear() + "\t\t"
												+ mg.getMovtime() + "\t\t" + mg.getMovlang() + "\t\t" + mg.getMovdtrel()
												+ "\t\t" + mg.getMovrelcountry() + "\t" + mg.getGentitle()));

							} else {
								System.out.println("some problem is there");
							}

							break;

						case 7:
							 sc.nextLine();
							 System.out.println("Enter movie name");
							 String movtit=sc.nextLine();
							 GenresModel mm=ms.getConcat(movtit);
							 System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
							 System.out.println("Movie_Id \tMovie_Tatle \tMovie_Year \tMovie_Time \tMovie_language \tMovie_rel_date \tMovie_Country \tMovie_genres ");
							 System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
								
							 System.out.println(mm.getMid()+"\t\t"+mm.getMovtitle()+"\t\t"+mm.getMovyear()+"\t\t"+mm.getMovtime()+"\t\t"+mm.getMovlang()+"\t\t"+mm.getMovdtrel()+"\t"+mm.getMovrelcountry()+"\t\t"+mm.getGentitle());
							 
							 System.out.println("-------------------------------------------------------------------------------------------------------------------------------");
							
							break;
							
							
						case 8: // 7 : All Admin Display.
							List<AdminModel> alist = as.getAllAdmin();
							if (alist != null) {
								System.out.println(
										"-----------------------------------------------------------------------");
								System.out.println("Admin_Id \tAdmin_Name \tAdmin_Mobile_No \tAdmin_password");
								System.out.println(
										"-----------------------------------------------------------------------");

								alist.forEach((m) -> System.out.println(m.getAdminid() + "\t\t" + m.getAdminname()
										+ "\t\t" + m.getAmobileno() + "\t\t" + m.getApassword()));

								System.out.println(
										"-----------------------------------------------------------------------");
							} else {
								System.out.println("There is no Admin present...!");
							}
							break;

						case 9: // 8 : All User Display.
							List<UserModel> li = us.getAllUser();
							if (li != null) {
								System.out.println(
										"----------------------------------------------------------------------------------");
								System.out.println("User_Id \tUser_Name \tUser_Age \tUser_Mobile_No \tUser_Password");
								System.out.println(
										"----------------------------------------------------------------------------------");

								li.forEach((m) -> System.out.println(m.getUid() + "\t\t" + m.getUname() + "\t\t"
										+ m.getUage() + "\t\t" + m.getUmobileno() + "\t\t" + m.getUpassword()));

								System.out.println(
										"----------------------------------------------------------------------------------");
							} else {
								System.out.println("There is no User present...!");
							}
							break;

						}
					} while (ch < 10);
				}

				else {
					System.out.println("Admin Mobile_no,password not Valid...?");
					System.out.println("Do you want to Forget password..? Type(yes/no)..?");
					String msg = sc.next();
					String temob;
					if (msg.equals("yes")) {
						System.out.printf("Enter the admin Mobile No -->");
						temob = sc.next();
						b = as.checkadminid(temob);
						if (b) {
							System.out.printf("Enter the New Password -->");
							String newpassword = sc.next();

							boolean b2 = as.changePassword(temob, newpassword);
							if (b2)
								System.out.println("Password Changes Successfully....Done!");
							else
								System.out.println("Some error in changing password.");
						} else {
							System.out.println("not valid admin Id..!");
						}
					} else {
						System.out.println("Thank you.... (^_^)....");
					}
				}

				break;

			// ...................... User Login ..................................
			case 3:
				sc.nextLine();
				System.out.println("+..........................................................+");
				System.out.println("|\t\t** User_Login **\t\t           |");
				System.out.println("|..........................................................|");
				System.out.println("|  Enter User Mobile No :                                  |");
				mono = sc.next();
				System.out.println("|  Enter User PassWord  :                                  |");
				password = sc.next();
				System.out.println("+..........................................................+");
				boolean b3 = us.isUserValid(mono, password);
				if (b3) {
					System.out.println("User Login Successfully.....");
					int uid=0;
					List<UserModel> userid =us.getuserid(mono, password);
					if (userid != null) {
						System.out.println("+------------------------------------------------------------------------------------------------------------+");
						for (UserModel um : userid) {
							uid=um.getUid();
							System.out.println("|\tUser_Id is :"+uid+"\t\t.....(^_^)..... WelCome "+um.getUname()+" .....(^_^).....                                |");
						}
					}

					do {
						System.out.println("+------------------------------------------------------------------------------------------------------------+");
						System.out.println("|                                                                                                            |");
						System.out.println("|                                   **    USER MENU    ***                                                   |");
						System.out.println("|                                                                                                            |");
						System.out.println("|............................................................................................................|");
						List<MovieMasterModel> li = ms.getTopTreeMovies();
						if (li != null) {
							System.out.println(
									"|                                                                                                            |");
							System.out.println(
									"|                                🎥🎥🎥🎥      Top 3 Movie       🎥🎥🎥🎥                                      |");
							System.out.println(
									"|                                                                                                            |");
							System.out.println(
									"| Movie_Id \tMovie_Tatle  \tMovie_Time \tMovie_rel_date \t\tMovie_language  Movie_Country\t     |");
							System.out.println(
									"|............................................................................................................|");

							li.forEach((m) -> System.out.println("| " + m.getMid() + "\t\t" + m.getMovtitle() + "\t\t"+ m.getMovtime() + "\t\t" + m.getMovdtrel() + "\t\t" + m.getMovlang() + "\t\t"+ m.getMovrelcountry() ));

							System.out.println("+------------------------------------------------------------------------------------------------------------+");
						}
						sc.nextLine();
						boolean isTrue = true;
						while (isTrue) {
							System.out.println("\"You have to Watch Top 3 Movies, type(yes/no) :");
							String msg = sc.next();
							if (msg.equals("yes")) {
								System.out.println("Enter Movie id : ");
								int mpid = sc.nextInt();
								System.out.println("Enter movie Rating Number(1-5): ");
								float rating=sc.nextFloat();
								System.out.println("Enter movie Feedback : ");
								String feedback=sc.next();
								
								RatingModel rModel=new RatingModel();
								rModel.setRating_num(rating);
								rModel.setFeedback(feedback);
								rModel.setMid(mpid);
								b=rts.isAddUserWatchHistory(uid,rModel);
//								b = gs.isAddUserWatchHistory(uid,mpid,rating,feedback);
								if (b) {
									System.out.println("Thnk you for Giving Review (^_^).");
								} else {
									System.out.println("not join to tables...!");
								}
								isTrue = true;
							} else {
								isTrue = false;
							}
						}
						System.out.println("+------------------------------------------------------------------------------------------------------------+");
						System.out.println("|                                                                                                            |");
						System.out.println("|\t\t 1 : Display all movies.                                                                     |");
						System.out.println("|                                                                                                            |");
						System.out.println("|\t\t 2 : Search movie By Name.                                                                   |");
						System.out.println("|                                                                                                            |");
						System.out.println("|\t\t 3 : Search movie By Genres.                                                                 |");
						System.out.println("|                                                                                                            |");
						System.out.println("|\t\t 4 : Movie rating Prediction.                                                                |");
						System.out.println("|                                                                                                            |");
						System.out.println("|\t\t 5 : User Watch History.                                                                     |");
						System.out.println("|                                                                                                            |");
						System.out.println("|\t\t 6 : Exit.                                                                                   |");
						System.out.println("|                                                                                                            |");
						System.out.println("+------------------------------------------------------------------------------------------------------------+");
						System.out.println("Enter your choice:");
						ch = sc.nextInt();
						
						switch (ch) {

//						case 1:
//							li = ms.getTopTreeMovies();
//							if (li != null) {
//								System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
//								System.out.println("| Movie_Id \tMovie_Tatle \tMovie_Year \tMovie_Time \tMovie_language \tMovie_rel_date \tMovie_Country");
//								System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
//
//								li.forEach((m) -> System.out.println("| "+m.getMid() + "\t\t" + m.getMovtitle() + "\t\t"+ m.getMovyear() + "\t\t" + m.getMovtime() + "\t\t" + m.getMovlang() + "\t\t"+ m.getMovdtrel() + "\t\t" + m.getMovrelcountry()));
//
//								System.out.println("+----------------------------------------------------------------------------------------------------------------------+");
//							} 
//							break;

						case 1:
							List<MovieMasterModel> list = ms.getAllMovies();

							if (list != null) {
								System.out.println("+---------------------------------------------------------------------------------------------------------------------+");
								System.out.println("| Movie_Id \tMovie_Tatle \tMovie_Year \tMovie_Time \tMovie_language \tMovie_rel_date \tMovie_Country");
								System.out.println("+---------------------------------------------------------------------------------------------------------------------+");

								list.forEach((m) -> System.out.println("| " + m.getMid() + "\t\t" + m.getMovtitle()
										+ "\t\t" + m.getMovyear() + "\t\t" + m.getMovtime() + "\t\t" + m.getMovlang()
										+ "\t\t" + m.getMovdtrel() + "\t\t" + m.getMovrelcountry()));

								System.out.println("+----------------------------------------------------------------------------------------------------------------------+");
								
								sc.nextLine();
								isTrue = true;
								while (isTrue) {
									System.out.println("\"You have to Watch Movies, type(yes/no) :");
									String msg = sc.next();
									if (msg.equals("yes")) {
										System.out.println("Enter Movie id : ");
										int mpid = sc.nextInt();
										System.out.println("Enter movie Rating Number(1-5): ");
										float rating=sc.nextFloat();
										System.out.println("Enter movie Feedback : ");
										String feedback=sc.next();
										
										RatingModel rModel=new RatingModel();
										rModel.setRating_num(rating);
										rModel.setFeedback(feedback);
										rModel.setMid(mpid);
										b=rts.isAddUserWatchHistory(uid,rModel);
//										b = gs.isAddUserWatchHistory(uid,mpid,rating,feedback);
										if (b) {
											System.out.println("Thnk you for Giving Review (^_^).");
										} else {
											System.out.println("not join to tables...!");
										}
										isTrue = true;
									} else {
										isTrue = false;
									}
								}
							
							} else {
								System.out.println("There is no present Movies...!");
							}

							break;

						case 2:
							System.out.println("Enter Movie name to search :");
							String smovie = sc.next();
							b = ms.checkMovName(smovie);

							if (b) {
								System.out.println("movie present in table");

								list = ms.getMovie(smovie);

								if (list != null) {
									System.out.println(
											"+---------------------------------------------------------------------------------------------------------------------+");
									System.out.println(
											"| Movie_Id \tMovie_Tatle \tMovie_Year \tMovie_Time \tMovie_language \tMovie_rel_date \tMovie_Country");
									System.out.println(
											"+---------------------------------------------------------------------------------------------------------------------+");

									list.forEach((m) -> System.out
											.println("| " + m.getMid() + "\t\t" + m.getMovtitle() + "\t\t"
													+ m.getMovyear() + "\t\t" + m.getMovtime() + "\t\t" + m.getMovlang()
													+ "\t\t" + m.getMovdtrel() + "\t\t" + m.getMovrelcountry()));

									System.out.println(
											"+----------------------------------------------------------------------------------------------------------------------+");
									sc.nextLine();
									isTrue = true;
									while (isTrue) {
										System.out.println("\"You have to Watch Movies, type(yes/no) :");
										String msg = sc.next();
										if (msg.equals("yes")) {
											System.out.println("Enter Movie id : ");
											int mpid = sc.nextInt();
											System.out.println("Enter movie Rating Number(1-5): ");
											float rating=sc.nextFloat();
											System.out.println("Enter movie Feedback : ");
											String feedback=sc.next();
										
											RatingModel rModel=new RatingModel();
											rModel.setRating_num(rating);
											rModel.setFeedback(feedback);
											rModel.setMid(mpid);
											b=rts.isAddUserWatchHistory(uid,rModel);
//											b = gs.isAddUserWatchHistory(uid,mpid,rating,feedback);
											if (b) {
												System.out.println("Thnk you for Giving Review (^_^).");
											} else {
												System.out.println("not join to tables..!");
											}
											isTrue = true;
										} else {
											isTrue = false;
										}
									}
								}

							} else {
								System.out.println("Movie not present..!");
							}

							break;

						case 3:
							List<GenresModel> list1 = gs.getAllGenres();
							if (list1 != null) {
								System.out.println("+--------------------------------------------+");
								System.out.println("| Genres_Id \tGenres_Title       |");
								System.out.println("+--------------------------------------------+");
								list1.forEach(
										(mg) -> System.out.println("| " + mg.getGenid() + "\t\t" + mg.getGentitle()));
								System.out.println("+--------------------------------------------+");
							}
							
							System.out.println("Enter Genres Name to search movie");
							String gentitle=sc.next();
							
							List<GenresModel> list2 =gs.SearchByGenres(gentitle);

							if (list2 != null) {
								System.out.println(
										"+---------------------------------------------------------------------------------------------------------------------+");
								System.out.println(
										"| Movie_Id \tMovie_Tatle \tMovie_Year \tMovie_Time \tMovie_language \tMovie_Country");
								System.out.println(
										"+---------------------------------------------------------------------------------------------------------------------+");
								list2.forEach((m) -> System.out.println("| " + m.getMid()+ "\t\t" + m.getMovtitle()+"\t\t"+m.getMovyear()+"\t\t"+m.getMovtime()+"\t\t"+m.getMovlang()+"\t\t"+m.getMovrelcountry()));

								System.out.println(
										"+----------------------------------------------------------------------------------------------------------------------+");
							}
							
							sc.nextLine();
							isTrue = true;
							while (isTrue) {
								System.out.println("\"You have to Watch Movies, type(yes/no) :");
								String msg = sc.next();
								if (msg.equals("yes")) {
									System.out.println("Enter Movie id : ");
									int mpid = sc.nextInt();
									System.out.println("Enter movie Rating Number(1-5): ");
									float rating=sc.nextFloat();
									System.out.println("Enter movie Feedback : ");
									String feedback=sc.next();
									
									RatingModel rModel=new RatingModel();
									rModel.setRating_num(rating);
									rModel.setFeedback(feedback);
									rModel.setMid(mpid);
									b=rts.isAddUserWatchHistory(uid,rModel);
//									b = gs.isAddUserWatchHistory(uid,mpid,rating,feedback);
									if (b) {
										System.out.println("Thnk you for Giving Review (^_^).");
									} else {
										System.out.println("not join to tables...!");
									}
									isTrue = true;
								} else {
									isTrue = false;
								}
							}
							
							break;
							
//						case 3:
//							System.out.println("Some update leter......");
//							break;
						/*
						 * case 6: sc.nextLine(); System.out.println("Enter movie name"); 
						 * String movtitle1=sc.nextLine(); 
						 * int movId=ms.getMovId(movtitle1);
						 * System.out.println(movId); if(movId!=-1) {
						 * System.out.println("Enter username"); String uname=sc.nextLine();
						 * System.out.println("Enter user age"); int uage=sc.nextInt();
						 * System.out.println("Enter user contact number"); String
						 * ucontact=sc.nextLine();
						 * 
						 * System.out.println("enter user password"); String upassword=sc.nextLine();
						 * 
						 * 
						 * int userid=ms.getUserIdAutomatic(); System.out.println(userid);
						 * sc.nextLine(); UserModel umodel=new UserModel(); umodel.setMid(movId);
						 * umodel.setUname(uname); umodel.setUpassword(upassword);
						 * umodel.setUmobileno(ucontact); umodel.setUage(uage); umodel.setUid(userid);
						 * System.out.println(movId+"\t"+uname+"\t"+upassword+"\t"+ucontact+"\t"+uage+
						 * "\t"+userid); b=ms.isAddUser(umodel); if(b) {
						 * System.out.println("user added Successfully"); } else {
						 * System.out.println("user not added"); }
						 * 
						 * 
						 * } else { System.out.println("user"); }
						 * 
						 * break;
						 */
							
						case 4:
							System.out.println("---------------------------  Movie Predicion  ----------------------------------------- ");
							rts.predict();

							break;		
							
							
							
						case 5:
							List<RatingModel> rli = rts.getUserWatchHistory(uid);
							if (rli != null) {
								System.out.println("+------------------------------------------------------------------------------------------------------+");
								System.out.println("| Movie_Id \tMovie_Tatle \tMovie_Year \tMovie_Time \tMovie_Rating \tMovie_Feedback");
								System.out.println("+------------------------------------------------------------------------------------------------------+");

								rli.forEach((m) -> System.out.println("| " + m.getMid() + "\t\t" + m.getMovtitle() + "\t\t"
												+ m.getMovyear() + "\t\t" + m.getMovtime() + "\t\t" +m.getRating_num()+"\t\t"+m.getFeedback()));

								System.out.println("+------------------------------------------------------------------------------------------------------+");
							
							}
							
							break;
							
						
							
						}

					} while (ch < 6);
				}

				else {
					System.out.println("User Mobile_no,password not Valid...?");
					System.out.println("Do you want to Forget password..? Type(yes/no)..?");
					String msg = sc.next();
					String temob;
					if (msg.equals("yes")) {
						System.out.println("Enter the User Mobile No -->");
						temob = sc.next();
						b3 = us.checkUserId(temob);
						if (b3) {
							System.out.println("Enter the New Password -->");
							String newpassword = sc.next();

							b3 = us.changePassword(temob, newpassword);
							if (b3)
								System.out.println("Password Changes Successfully....Done!");
							else
								System.out.println("Some error in changing password.");

						} else {
							System.out.println("not valid User Id..!");
						}
					} else {
						System.out.println("Thank you.... (^_^)....");
					}
				}
				break;

			default:
				System.out.println("wrong choice!");

			}// main end switch
		} while (true);

	}

}

import java.io.BufferedReader; 
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Bank_Management_System 
{
    public static void main() throws IOException, InterruptedException, FileNotFoundException
    {
        BufferedReader ssc = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        boolean b = true;
        
        while(b)
        {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            
            File file0 = new File("./BANK");
            file0.mkdir();
            String FilePath = "./BANK/";
            
            middle("******************************************************", 157);
            middle("WELCOME TO SBI", 157);
            middle("******************************************************", 157);
            
            System.out.println("1. Register and Creat Account");
            System.out.println("2. Login for existing Account");
            System.out.println("3. Exit Program");
            System.out.print("\n\nEnter Choice(1/2/3) : ");
            
            String choice = ssc.readLine().trim();
            
            bear:
            {
                if (choice.equalsIgnoreCase("1")) 
                {
                    System.out.print("\nEnter Name : ");
                    String name = ssc.readLine();
                    
                    String username = "";
                    
                    for(;;)
                    {
                        System.out.print("\nEnter Account name (Account name does not contain --> /,\\,:,*,?,\",<,>,|) : ");
                        username = ssc.readLine();
                        if(checkFileName(username))
                        break;
                        else
                        System.out.println("\nAccount name must not contain --> /,\\,:,*,?,\",<,>,|");
                    }
                    

                    File file = new File(FilePath + username + ".txt");
                    if (file.exists()) 
                    {
                        Scanner dataReader21 = new Scanner(file);
                        if(dataReader21.nextLine().equals("deleted"))
                        new FileWriter(FilePath + username + ".txt", false).close();
                        else
                        {
                            System.out.println("\nAccount name Already Taken !");
                            System.out.println("\nPress enter to continue");
                            try
                            {
                                System.in.read();
                            } catch(Exception e) {
                            }
                            break bear;
                        }
                    }
                    
                    String password = "";
                    
                    for(;;)
                    {
                        System.out.print("\nEnter your secret password : ");
                        password = ssc.readLine();
                        if(password.equals(username) || password.equals(name))
                        System.out.println("\nPassword must not be equal to NAME or ACCOUNT NAME.");
                        else
                        break;
                    }
                    
                    String number = "";
                    
                    for(;;)
                    {
                        System.out.print("\nEnter Phone Number : +91 ");
                        number = "+91 " + ssc.readLine();
                        if(number.length() != 14)
                        System.out.println("\nEnter a valid 10 digit number.");
                        else
                        break;
                    }

                    User_Info reg = new User_Info(name, username, password, number, "TRANSACTION:0", FilePath);
                    reg.message();

                    System.out.println("\nPress enter to continue");
                    try
                    {
                        System.in.read();
                    }
                    catch (Exception e)
                    {
                    }
                }
                
                else if (choice.equalsIgnoreCase("2"))
                {
                    String username = "";
                    for(;;)
                    {
                        System.out.print("\nEnter Account name (Account name does not contain --> /,\\,:,*,?,\",<,>,|) : ");
                        username = ssc.readLine();
                        if(checkFileName(username))
                        break;
                        else
                        System.out.println("\nAccount name does not contain --> /,\\,:,*,?,\",<,>,|");
                    }

                    
                    System.out.print("Enter your secret password : ");
                    String password = ssc.readLine();

                    File file = new File(FilePath + username + ".txt");
                    
                    if (file.exists())
                    {
                        Scanner dataReader21 = new Scanner(file);
                        if(dataReader21.nextLine().equals("deleted"))
                        {
                            System.out.println("\nAccount not created!\nFirst resister yourself and creat account.");
                            System.out.println("\nPress enter to continue");
                            try 
                            {
                                System.in.read();
                            } 
                            catch (Exception e) 
                            {
                            }
                            break bear;
                        }
                        try
                        {
                            Scanner dataReader = new Scanner(file);
                            String money = dataReader.nextLine();
                            int login_money = Integer.parseInt(money);
                            String login_name = dataReader.nextLine();
                            String login_username = dataReader.nextLine();
                            String login_password = dataReader.nextLine();
                            String number = dataReader.nextLine();
                            String login_transaction = dataReader.nextLine();
                            if (username.equals(login_username) && password.equals(login_password))
                            {
                                boolean bo = true;
                                
                                while (bo)
                                {
                                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                                    System.out.println("Welcome " + login_name + " !");
                                    System.out.println("\n**** OPERATIONS ****");
                                    System.out.println("\n1. Deposit Money");
                                    System.out.println("2. Withdraw Money");
                                    System.out.println("3. View Details/Balance");
                                    System.out.println("4. View Transaction History");
                                    System.out.println("5. Transfer to other account");
                                    System.out.println("6. Change Password");
                                    System.out.println("7. Delete Account");
                                    System.out.println("8. Logout");
                                    System.out.print("\n\nEnter Choice(1/2/3/4/5/6/7/8) : ");
                                    String choice2 = ssc.readLine().trim();
                                    System.out.println();

                                    if(choice2.equalsIgnoreCase("1"))
                                    {
                                        for(;;)
                                        {
                                            
                                            int amount = 0;
                                            
                                            for(;;)
                                            {
                                                System.out.print("\nEnter Amount to Deposit (Limit : 1,00,000) : ");
                                                String xxxx = ssc.readLine().trim();
                                                if(allCharDigit(xxxx))
                                                {
                                                    amount = Integer.parseInt(xxxx);
                                                    break;
                                                }
                                                else
                                                System.out.println("Enter amount in digits. No other characters are accepted.");
                                            }
                                            
                                            if (amount > 100000)
                                            {
                                                System.out.println("Ammount exceeds limit.\nEnter correct amount!");
                                                System.out.println("\nPress enter to continue");
                                                try
                                                {
                                                    System.in.read();
                                                }
                                                catch (Exception e) 
                                                {
                                                }
                                            }
                                            else if(amount <= 0)
                                            {
                                                System.out.println("\nEnter correct amount!\nPress enter to continue");
                                                try
                                                {
                                                    System.in.read();
                                                }
                                                catch (Exception e) 
                                                {
                                                }
                                            }
                                            else 
                                            {
                                                try 
                                                {
                                                    FileWriter f0 = new FileWriter(FilePath + username + ".txt", true);
                                                    String old_money = Integer.toString(login_money);
                                                    login_money += amount;
                                                    int temp = amount;
                                                    String to_be_deposited = Integer.toString(login_money);
                                                    modifyFile((FilePath + username + ".txt"), old_money, to_be_deposited);
    
                                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                                    Date date = new Date();
                                                    f0.write("Rs.(+" + temp + ") :: " + formatter.format(date) + " :: Self Deposit " + "\n");
    
                                                    login_transaction = "TRANSACTION:1";
                                                    modifyFile((FilePath + username + ".txt"), "TRANSACTION:0","TRANSACTION:1");
    
                                                    System.out.println("Rs. " + temp + " Deposited !");
    
                                                    System.out.println("\nPress enter to continue");
                                                    try
                                                    {
                                                        System.in.read();
                                                    }
                                                    catch (Exception e)
                                                    {
                                                    }
    
                                                    f0.close();
                                                    break;
                                                } 
                                                catch (IOException e) 
                                                {
                                                    System.out.println("Account's Data not found !");
                                                    e.printStackTrace();
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    
                                    else if (choice2.equalsIgnoreCase("2")) 
                                    {
                                        for(;;)
                                        {
                                            if(login_money == 0)
                                            {
                                                System.out.println("\nNo money is in your account.\nYou can't withdraw money");
                                                System.out.println("\nPress enter to continue");
                                                try 
                                                {
                                                    System.in.read();
                                                } 
                                                catch (Exception e) 
                                                {
                                                }
                                                break;
                                            }
                                            
                                            int amount_withdraw = 0;
                                            
                                            for(;;)
                                            {
                                                System.out.print("\nEnter Amount to Withdraw (Limit : 0 to " + login_money + ") : ");
                                                String xxxx = ssc.readLine().trim();
                                                if(allCharDigit(xxxx))
                                                {
                                                    amount_withdraw = Integer.parseInt(xxxx);
                                                    break;
                                                }
                                                else
                                                System.out.println("Enter amount in digits. No other characters are accepted.");
                                            }
                                            
                                            
                                            if (amount_withdraw > login_money) 
                                            {
                                                System.out.println("Money entered exceeds the money in the account.");
                                                System.out.println("Enter correct amount !");
                                                System.out.println("\nPress enter to continue");
                                                try 
                                                {
                                                    System.in.read();
                                                } 
                                                catch (Exception e) 
                                                {
                                                }
                                            }
                                            else if(amount_withdraw <= 0)
                                            {
                                                System.out.println("Enter correct amount !");
                                                System.out.println("\nPress enter to continue");
                                                try 
                                                {
                                                    System.in.read();
                                                } 
                                                catch (Exception e) 
                                                {
                                                }
                                            }
                                            else 
                                            {
                                                try 
                                                {
                                                    FileWriter f0 = new FileWriter(FilePath + username + ".txt", true);
                                                    String old_money = Integer.toString(login_money);
                                                    login_money -= amount_withdraw;
                                                    int temp1 = amount_withdraw;
                                                    String to_be_withdrawed = Integer.toString(login_money);
                                                    modifyFile(FilePath + username + ".txt", old_money, to_be_withdrawed);
    
                                                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                                    Date date = new Date();
                                                    f0.write("Rs.(-" + temp1 + ") :: " + formatter.format(date) + " :: Self Withdraw" + "\n");
    
                                                    login_transaction = "TRANSACTION:1";
                                                    modifyFile(FilePath + username + ".txt", "TRANSACTION:0", "TRANSACTION:1");
    
                                                    System.out.println("Rs. " + temp1 + " Withdrawed !");
    
                                                    System.out.println("\nPress enter to continue");
                                                    try 
                                                    {
                                                        System.in.read();
                                                    } 
                                                    catch (Exception e) 
                                                    {
                                                    }
    
                                                    f0.close();
                                                    break;
                                                } 
                                                catch (IOException e) 
                                                {
                                                    System.out.println("Account's Data not found !");
                                                    e.printStackTrace();
                                                    break;
                                                }
                                            }
                                        }
                                    }
                                    
                                    else if (choice2.equalsIgnoreCase("3")) 
                                    {
                                        System.out.println("\nDetails :");
                                        System.out.println("1. Name          : " + login_name);
                                        System.out.println("2. Account Name  : " + login_username);
                                        System.out.print("3. Password      : ");
                                        for (int i = 0; i < login_password.length(); i++) 
                                        {
                                            System.out.print("*");
                                        }
                                        System.out.println();
                                        System.out.println("4. Phone No.     : " + number);
                                        System.out.println("5. Balance       : " + login_money + " Rs.");

                                        System.out.println("\nPress enter to continue");
                                        try 
                                        {
                                            System.in.read();
                                        } 
                                        catch (Exception e) 
                                        {
                                        }
                                    }
                                    
                                    else if(choice2.equalsIgnoreCase("4")) 
                                    {
                                        try 
                                        {
                                            File f1 = new File(FilePath + username + ".txt");
                                            dataReader = new Scanner(f1);
                                            System.out.println("\nTransaction History : ");
                                            String temp = "TRANSACTION:0";
                                            if (login_transaction.equals(temp)) 
                                            {
                                                System.out.println("\nNo Transaction History is there !");
                                                System.out.println("\nPress enter to continue");
                                                try 
                                                {
                                                    System.in.read();
                                                } 
                                                catch (Exception e) 
                                                {
                                                }
                                            } 
                                            else 
                                            {
                                                for (int j = 0; j < 6; j++) 
                                                {
                                                    dataReader.nextLine();
                                                }
                                                while (dataReader.hasNextLine()) 
                                                {
                                                    String fileData = dataReader.nextLine();
                                                    System.out.println(fileData);
                                                }
                                                System.out.println("\nPress enter to continue");
                                                try 
                                                {
                                                    System.in.read();
                                                } 
                                                catch (Exception e) 
                                                {
                                                }
                                            }
                                            dataReader.close();
                                        } 
                                        catch (FileNotFoundException exception) 
                                        {
                                            System.out.println("Unexcpected error occurred!");
                                            exception.printStackTrace();
                                            System.out.println("\nPress enter to continue");
                                            try 
                                            {
                                                System.in.read();
                                            } catch (Exception e) 
                                            {
                                            }
                                        }
                                    }
                                    
                                    else if (choice2.equalsIgnoreCase("5")) 
                                    {
                                        String username_to_transfer = "";
                                        
                                        for(;;)
                                        {
                                            System.out.print("\nEnter Account name of the account you want to send money to : ");
                                            username_to_transfer = ssc.readLine();
                                            if(username_to_transfer.equals(username))
                                            System.out.println("\nEnter correct Account name.");
                                            else
                                            break;
                                        }
                                        File file_to_transfer = new File(FilePath + username_to_transfer + ".txt");
                                    
                                        if (file_to_transfer.exists()) 
                                        {
                                            Scanner dataReader2 = new Scanner(file_to_transfer);
                                            String money_old = dataReader2.nextLine();
                                            String name_transfer = dataReader2.nextLine();
                                            int money_old_user = Integer.parseInt(money_old);
                                            
                                            for(;;)
                                            {
                                                if(login_money == 0)
                                                {
                                                    System.out.println("\nNo money is in our account.\nFirst deposite money then try again to transfer.");
                                                    System.out.println("\nPress enter to continue");
                                                    try 
                                                    {
                                                        System.in.read();
                                                    } 
                                                    catch (Exception e) 
                                                    {
                                                    }
                                                    break;
                                                }
                                                
                                                int amount_transfer_update = 0;
                                                
                                                for(;;)
                                                {
                                                    System.out.print("\nEnter Amount to Transfer (Limit : 0 to " + login_money + ") : ");
                                                    String xxxx = ssc.readLine().trim();
                                                    if(allCharDigit(xxxx))
                                                    {
                                                        amount_transfer_update = Integer.parseInt(xxxx);
                                                        break;
                                                    }
                                                    else
                                                    System.out.println("Enter amount in digits. No other characters are accepted.");
                                                }
    
                                                if (amount_transfer_update > login_money) 
                                                {
                                                    System.out.println("\nMoney entered exceeds the money in the account.");
                                                    System.out.println("Enter correct amount !");
                                                    System.out.println("\nPress enter to continue");
                                                    try 
                                                    {
                                                        System.in.read();
                                                    } 
                                                    catch (Exception e) 
                                                    {
                                                    }
                                                }
                                                else if(amount_transfer_update <= 0)
                                                {
                                                    System.out.println("Enter correct amount !");
                                                    System.out.println("\nPress enter to continue");
                                                    try 
                                                    {
                                                        System.in.read();
                                                    } 
                                                    catch (Exception e) 
                                                    {
                                                    }
                                                }
                                                else 
                                                {
                                                    String to_upd = Integer.toString(login_money);
                                                    login_money -= amount_transfer_update;
                                                    String to_upd2 = Integer.toString(login_money);
                                                    modifyFile(FilePath + username + ".txt", to_upd, to_upd2);
    
                                                    String to_update = Integer.toString(money_old_user);
                                                    money_old_user += amount_transfer_update;
                                                    String to_update_2 = Integer.toString(money_old_user);
                                                    modifyFile((FilePath + username_to_transfer + ".txt"), to_update, to_update_2);
                                                    modifyFile((FilePath + username_to_transfer + ".txt"), "TRANSACTION:0", "TRANSACTION:1");
                                                    try 
                                                    {
                                                        FileWriter f11 = new FileWriter(FilePath + username_to_transfer + ".txt", true);
                                                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                                        Date date = new Date();
                                                        f11.write("Rs.(+" + amount_transfer_update + ") :: " + formatter.format(date) + " :: Transferred from " + username + " (" + login_name + ")\n");
                                                        f11.close();
    
                                                        FileWriter f12 = new FileWriter(FilePath + username + ".txt", true);
                                                        SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                                        Date date2 = new Date();
                                                        f12.write("Rs.(-" + amount_transfer_update + ") :: " + formatter2.format(date2) + " :: Transferred to " + username_to_transfer + " (" + name_transfer + ")\n");
                                                        f12.close();
    
                                                        System.out.println("Rs.(" + amount_transfer_update + ") Transferred to " + username_to_transfer + " (" + name_transfer + ")");
                                                        System.out.println("\nPress enter to continue");
                                                        try 
                                                        {
                                                            System.in.read();
                                                        } 
                                                        catch (Exception e) 
                                                        {
                                                        }
                                                        
                                                    } 
                                                    catch (IOException e) 
                                                    {
                                                        System.out.println("Account's Data not found !");
                                                        e.printStackTrace();
                                                    }
                                                    break;
                                                }
                                            }

                                            dataReader2.close();
                                        } 
                                        else 
                                        {
                                            System.out.println("ACCOUNT DON'T EXISTS !");
                                            System.out.println("\nPress enter to continue");
                                            try 
                                            {
                                                System.in.read();
                                            } 
                                            catch (Exception e) 
                                            {
                                            }
                                        }
                                    }
                                    
                                    else if(choice2.equalsIgnoreCase("6"))
                                    {
                                        File filex = new File(FilePath + username + ".txt");
                                        dataReader = new Scanner(filex);
                                        for(int i=0; i<3; i++)
                                        dataReader.nextLine();
                                        String old_pass = dataReader.nextLine();
                                        System.out.print("\nEnter the old password : ");
                                        String old_pass_input = ssc.readLine();
                                        if(old_pass.equals(old_pass_input))
                                        {
                                            String new_pass_input = "", new_pass_input2 = "";
                                            for(;;)
                                            {
                                                System.out.print("\nEnter the new password : ");
                                                new_pass_input = ssc.readLine();
                                                if(new_pass_input.equals(username) || new_pass_input.equals(login_name))
                                                System.out.println("\nPassword must not be equal to NAME or ACCOUNT NAME.");
                                                else
                                                break;
                                            }
                                            
                                            for(;;)
                                            {
                                                System.out.print("\nEnter the new password again : ");
                                                new_pass_input2 = ssc.readLine();
                                                if(new_pass_input2.equals(username) || new_pass_input2.equals(login_name))
                                                System.out.println("\nPassword must not be equal to NAME or ACCOUNT NAME.");
                                                else
                                                break;
                                            }
                                            
                                            if(new_pass_input.equals(new_pass_input2))
                                            {
                                                modifyFile((FilePath + login_username + ".txt"), old_pass, new_pass_input);
                                                System.out.println("\nYour account's password has been changed!");
                                                System.out.println("\nPress Enter to continue");
                                                try
                                                {
                                                    System.in.read();
                                                }
                                                catch(Exception e){
                                                }
                                            }
                                            else
                                            {
                                                System.out.println("\nThe re-entered password is not matched!");
                                                System.out.println("\nPress Enter to continue");
                                                try
                                                {
                                                    System.in.read();
                                                }
                                                catch(Exception e)
                                                {
                                                }
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("\nOld password entered is not matched! Try again later.");
                                            System.out.println("\nPress enter to continue.");
                                            try
                                            {
                                                System.in.read();
                                            }
                                            catch(Exception e)
                                            {
                                            }
                                        }
                                    }
                                    
                                    
                                    else if(choice2.equalsIgnoreCase("7"))
                                    {
                                        System.out.print("\nAre you sure you want to delete the Account(y/n) : ");
                                        char choice3 = ssc.readLine().trim().charAt(0);
                                        if(choice3 == 'y' || choice3 == 'Y')
                                        {
                                            System.out.print("\nEnter the Account's password : ");
                                            String passman = ssc.readLine().trim();
                                            if(passman.equals(login_password))
                                            {
                                                File file69 = new File(FilePath + username + ".txt");
                                                Scanner dataReader69 = new Scanner(file69);
                                                String s = "";
                                                while(dataReader69.hasNextLine())
                                                {
                                                    s = s + dataReader69.nextLine() + "\r\n";
                                                }
                                                
                                                dataReader69.close();
                                                
                                                new FileWriter(FilePath + username + ".txt", false).close();
                                                FileWriter writer = new FileWriter(FilePath + username + ".txt");
                                                writer.write("deleted");
                                                writer.close();
                                                
                                                System.out.println("\nAccount successfully deleted.");
                                                System.out.println("\nPress Enter to continue");
                                                try
                                                {
                                                    System.in.read();
                                                }
                                                catch(Exception e)
                                                {
                                                }
                                                break bear;
                                            }
                                            else
                                            {
                                                System.out.println("\nThe password entered is wrong.\nPlease try again.");
                                                System.out.println("\nPress Enter to continue");
                                                try
                                                {
                                                    System.in.read();
                                                }
                                                catch(Exception e)
                                                {
                                                }
                                            }
                                        }
                                        else
                                        {
                                            System.out.println("\nThe process of deleting your account is stopped.");
                                            System.out.println("\nPress enter to continue.");
                                            try
                                            {
                                                System.in.read();
                                            }
                                            catch(Exception e)
                                            {
                                            }
                                        }
                                    }
                                    
                                    else if(choice2.equalsIgnoreCase("8"))
                                    {
                                        break bear;
                                    }
                                    
                                    else
                                    {
                                        System.out.println("\n\nWrong choice");
                                        System.out.println("\nPress enter to continue.");
                                        try
                                        {
                                            System.in.read();
                                        }
                                        catch(Exception e)
                                        {
                                        }
                                    }
                                }
                                sc.close();
                            }
                            else
                            {
                                System.out.println("\nAccount name or Password is Incorrect !\nPlease Try Again");
                                System.out.println("\nPress enter to continue");
                                try 
                                {
                                    System.in.read();
                                } 
                                catch (Exception e) 
                                {
                                }
                                break bear;
                            }
                            dataReader.close();
                        } 
                        catch (FileNotFoundException e) 
                        {
                            System.out.println("File not found !");
                            e.printStackTrace();
                            System.out.println("\nPress enter to continue");
                            try 
                            {
                                System.in.read();
                            } 
                            catch (Exception f) 
                            {
                            }
                        }
                    } 
                    else 
                    {
                        System.out.println("\nAccount not created!\nFirst resister yourself and creat account.");
                        System.out.println("\nPress enter to continue");
                        try 
                        {
                            System.in.read();
                        } 
                        catch (Exception e) 
                        {
                        }
                        break bear;
                    }
                } 
                
                else if(choice.equalsIgnoreCase("3"))
                {
                    System.out.print("\n\n");
                    middle("***** THANK YOU FOR USING SBI BANKING SYSTEM *****", 157);
                    sc.close();
                    b = false;
                    break;
                }
                
                else
                {
                    System.out.println("\n\nWrong choice");
                    System.out.println("\nPress enter to continue.");
                    try
                    {
                        System.in.read();
                    }
                    catch(Exception e)
                    {
                    }
                }
            }
        }
    }
    
    public static void middle(String a, int c)
    /*
     * This finction is used to print any text at the middle of the screen of any row.
     * It depends on the total number of columns entered.
     */
    {
        int l = a.length();
        int z = (c/2)-(l/2);
        /*
         * Total number of column in bluej for 15.6 inch screen is 160.
         * This number of column will depend on the size of monitor used.
         * So it may be not in the middle.
        */
        for(int i=1; i<=z; i++)
            System.out.print(" ");
        
        System.out.println(a);
    }

    public static void modifyFile(String filePath, String oldString, String newString)
    {
        String oldContent = "";
        BufferedReader reader = null;
        
        try 
        {
            FileReader rrr = new FileReader(filePath);
            reader = new BufferedReader(rrr);
            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + "\r\n";
                line = reader.readLine();
            }
            
            String newContent = oldContent.replaceFirst(oldString, newString);
            
            rrr.close();
            new FileWriter(filePath, false).close();
            FileWriter writer = new FileWriter(filePath);
            writer.write(newContent);
            writer.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        } 
        
        try 
        {
            reader.close();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    
    public static boolean allCharDigit(String a)
    {
        if(a.trim().equals(""))
        return false;
        for(int i=0; i<a.length(); i++)
        {
            if(!Character.isDigit(a.charAt(i)))
            return false;
        }
        return true;
    }
    
    public static boolean checkFileName(String filename)
    {
        for(int i=0; i<filename.length(); i++)
        {
            char b = filename.charAt(i);
            if(b == '/' || b == '\\' || b == '?' || b == '*' || b == ':' || b == '<' || b == '>' || b == '"' || b == '|') 
            return false;
        }
        return true;
    }
}

import java.io.FileWriter;
import java.io.IOException;

class User_Info
{
    int money;
    String username;
    String password;
    String Name;
    String number;

    User_Info(String name, String username, String password, String number,String transaction,String FilePath) 
    {
        this.money = 0;
        setName(name);
        setUsername(username);
        setPassword(password);
        setNumber(number);
        try 
        {
            FileWriter fwrite = new FileWriter(FilePath + getUsername() + ".txt",true);
            fwrite.write(this.money + "\r\n" + getName() + "\r\n" + getUsername() + "\r\n"+ getPassword() + "\r\n" + getNumber() + "\r\n"+transaction+"\r\n");
            fwrite.close();
        } 
        catch (IOException e) 
        {
            System.out.println("Unexpected error occurred");
            e.printStackTrace();
        }
    }

    void message() 
    {
        System.out.println("USER GENERATED SUCCESFULLY !");
    }
    
    public String getUsername() 
    {
        return this.username;
    }

    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getPassword() 
    {
        return this.password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getNumber() 
    {
        return this.number;
    }

    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getName() 
    {
        return Name;
    }

    public void setName(String name) 
    {
        this.Name = name;
    }
}

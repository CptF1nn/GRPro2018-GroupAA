import java.util.ArrayList;
import java.util.List;
public class User{
    protected List<Movie> myMovieList;
    protected List<Series> mySeriesList;
    protected String userName;
    protected String password;
    protected Boolean admin;

    public User(String userName, String password, Boolean admin){
        if(!userName.equals("")){
            this.userName=userName;
        }else{
            throw new IllegalArgumentException("Username is null");
        }
        myMovieList = new ArrayList<Movie>();
        mySeriesList = new ArrayList<Series>();
        this.admin = admin;
        this.password = password;
    }

    public void addToMyList(Media media){
        if(media instanceof Movie)
            myMovieList.add((Movie)media);
        else if (media instanceof Series)
            mySeriesList.add((Series)media);
        else
            throw new InvalidMediaException(media);

    }
    public void removeFromMyList(Media media){
        if(media instanceof Movie){
            myMovieList.remove(media);}
        else if (media instanceof Series){
            mySeriesList.remove(media);
        }
    }

    public List<Media> getList(){
        List<Media> temporaryList = new ArrayList<Media>();
        for (Movie m:
             myMovieList) {
            temporaryList.add(m);
        }
        for (Series s:
             mySeriesList) {
            temporaryList.add(s);
        }
        return temporaryList;
    }

    public String getUserName(){return userName;}

    public Boolean checkPassword(String typedPassword){
        return (password.equals(typedPassword));
    }
}
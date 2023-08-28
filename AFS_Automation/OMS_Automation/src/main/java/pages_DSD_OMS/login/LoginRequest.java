package pages_DSD_OMS.login;

public class LoginRequest
{
        private String username;
        private String password;
        private boolean rememberMe;

    public LoginRequest(String username, String password, boolean rememberMe)
    {
        this.username = username;
        this.password = password;
        this.rememberMe = rememberMe;
    }
    @Override
        public String toString()
        {
        return "LoginRequest{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", rememberMe=" + rememberMe +
                '}';
        }
}
